import { useState, useEffect } from 'react';
import { Table, Button, Space, Popconfirm, Tag, message, Modal, Form, Input, Select, DatePicker, Upload } from 'antd';
import { EditOutlined, DeleteOutlined, PlusOutlined, UploadOutlined } from '@ant-design/icons';
import AccountManagerHeader from './AccountManagerHeader';
import { Link } from 'react-router-dom';
import './AccountManager.css';
import moment from 'moment';

const { Option } = Select;

const columns = (handleEdit, handleDelete) => [
  { title: 'Họ và tên', dataIndex: 'fullName', key: 'fullName',  align: 'center' },
  { title: 'Ngày sinh', dataIndex: 'birthday', key: 'birthday', align: 'center' },
  { title: 'Email', dataIndex: 'email', key: 'email', align: 'center' },
  { title: 'Giới tính', dataIndex: 'gender', key: 'gender', align: 'center' },
  { title: 'Chức vụ', dataIndex: 'role', key: 'role', align: 'center' },
  { title: 'Địa chỉ', dataIndex: 'address', key: 'address', align: 'center' },
  { 
    title: 'Trạng thái', dataIndex: 'status', key: 'status', align: 'center', 
    render: (status) => {
      let color, statusText;
      switch (status) {
        case 1:
          color = 'green';
          statusText = 'Đã duyệt';
          break;
        case 0:
          color = 'gold';
          statusText = 'Chưa duyệt';
          break;
        case -1:
          color = 'red';
          statusText = 'Sa thải';
          break;
        default:
          color = 'gray';
          statusText = 'Unknown';
      }
      return <Tag color={color}>{statusText}</Tag>; 
    }
  },
  {
    title: 'Thao tác',
    key: 'actions',
    align: 'center',
    render: (text, record) => (
      <Space size="small">
        <Button variant="outlined" icon={<EditOutlined />} onClick={() => handleEdit(record)} /> 
        <Popconfirm
          title="Bạn có chắc muốn xóa?"
          onConfirm={() => handleDelete(record.id)}
          okText="Đồng ý"
          cancelText="Hủy"
        >
          <Button danger icon={<DeleteOutlined />} />
        </Popconfirm>
      </Space>
    ),
  },
];

const AccountManager = () => {
  const [rows, setRows] = useState([]);
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [currentRecord, setCurrentRecord] = useState(null);
  const [form] = Form.useForm();

  const fetchAccounts = async () => {
    try {
      const response = await fetch('http://localhost:8081/api/admin/accounts/all');
      if (!response.ok) {
        throw new Error('Lỗi khi lấy dữ liệu tài khoản');
      }
      const data = await response.json();

      const formattedData = data.map((item) => ({
        ...item,
        birthday: new Date(item.birthday).toLocaleDateString('vi-VN', {
          day: '2-digit',
          month: '2-digit',
          year: 'numeric',
        }),
      }));
      
      setRows(formattedData);
    } catch (error) {
      console.error('Error fetching accounts:', error);
    }
  };

  useEffect(() => {
    fetchAccounts();
  }, []);

  const handleEdit = (record) => {
    setCurrentRecord(record);
    setIsModalVisible(true);
    form.setFieldsValue({
      ...record,
      birthday: moment(record.birthday, 'DD/MM/YYYY'),
    });
  };

  const handleDelete = async (id) => {
    try {
      const token = localStorage.getItem('token');
      const response = await fetch(`http://localhost:8081/api/admin/accounts/${id}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
      });

      if (response.ok) {
        message.success('Xóa tài khoản thành công');
        fetchAccounts(); 
      } else {
        message.error('Lỗi khi xóa tài khoản');
      }
    } catch (error) {
      console.error('Error deleting account:', error);
      message.error('Lỗi khi xóa tài khoản');
    }
  };

  const handleOk = async () => {
    try {
      const values = await form.validateFields();
      const token = localStorage.getItem('token');

      const response = await fetch(`http://localhost:8081/api/admin/accounts/${currentRecord.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify({
          id: currentRecord.id,
          ...values,
          birthday: values.birthday.format('YYYY-MM-DD'),
        }),
      });

      if (response.ok) {
        message.success('Cập nhật tài khoản thành công');
        fetchAccounts();
        setIsModalVisible(false);
      } else {
        message.error('Lỗi khi cập nhật tài khoản');
      }
    } catch (error) {
      console.error('Error updating account:', error);
      message.error('Lỗi khi cập nhật tài khoản');
    }
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  return (
    <div className='content'>
      <AccountManagerHeader />
      <Link to='/accounts'>
        <Button variant="outlined" className='button' icon={<PlusOutlined />}>Thêm tài khoản</Button>
      </Link>
      <div style={{ marginTop: 16 }}>
        <Table 
          columns={columns(handleEdit, handleDelete)} 
          dataSource={rows} 
          pagination={{ pageSize: 7, pageSizeOptions: [5, 10] }} 
        />
      </div>
      <Modal
        title="Sửa tài khoản"
        visible={isModalVisible}
        onOk={handleOk}
        onCancel={handleCancel}
      >
        <Form form={form} layout="vertical">
          <Form.Item
            label="Họ và tên"
            name="fullName"
            rules={[{ required: true, message: 'Vui lòng nhập họ và tên' }]}
          >
            <Input />
          </Form.Item>
          <Form.Item
            label="Email"
            name="email"
            rules={[{ required: true, message: 'Vui lòng nhập email' }]}
          >
            <Input />
          </Form.Item>
          <Form.Item
            label="Giới tính"
            name="gender"
            rules={[{ required: true, message: 'Vui lòng chọn giới tính' }]}
          >
            <Select>
              <Option value="Nam">Nam</Option>
              <Option value="Nữ">Nữ</Option>
              <Option value="Other">Khác</Option>
            </Select>
          </Form.Item>
          <Form.Item
            label="Ngày sinh"
            name="birthday"
            rules={[{ required: true, message: 'Vui lòng chọn ngày sinh' }]}
          >
            <DatePicker format="DD/MM/YYYY" />
          </Form.Item>
          <Form.Item
            label="Địa chỉ"
            name="address"
            rules={[{ required: true, message: 'Vui lòng nhập địa chỉ' }]}
          >
            <Input />
          </Form.Item>
          
          <Form.Item
            label="Chức vụ"
            name="role"
            rules={[{ required: true, message: 'Vui lòng nhập chức vụ' }]}
          >
            <Select>
              <Option value="ADMIN">ADMIN</Option>
              <Option value="Quản lý">Quản lý</Option>
              <Option value="Nhân viên">Nhân viên</Option>
            </Select>
          </Form.Item>
          <Form.Item
              label="Image"
              name="image"
              valuePropName="fileList"
              style={{ width: '100%' }} 
            >
              <Upload name="logo" action="/upload.do" listType="picture">
                <Button icon={<UploadOutlined />}>Click to upload</Button>
              </Upload>
          </Form.Item>
        </Form>
      </Modal>
    </div>
  );
};

export default AccountManager;
