import { useState, useEffect } from 'react';
import { Table, Button, Select } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import AccountManagerHeader from '../AccountManager/AccountManagerHeader';
import { Link } from 'react-router-dom';
import '../AccountManager/AccountManager.css';
const { Option } = Select;

const columns = () => [
  { title: 'Họ và tên', dataIndex: 'fullName', key: 'fullName',  align: 'center' },
  { title: 'Chức vụ', dataIndex: 'role', key: 'role', align: 'center' },
  { title: 'Thao tác', key: 'actions', align: 'center',
    render: () => (
      <Link to="/schedule-detail">
        <Button variant="outlined">Xem lịch đăng kí</Button>
      </Link>
    ),
   },
];

const AccountManager = () => {
  const [rows, setRows] = useState([]);

  const fetchAccounts = async () => {
    try {
      const response = await fetch('http://localhost:8081/api/admin/accounts/all');
      if (!response.ok) {
        throw new Error('Lỗi khi lấy dữ liệu tài khoản');
      }
      const data = await response.json();
      const filteredData = data.filter(item => item.status === 1);

      const formattedData = filteredData.map((item) => ({
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

  return (
    <div className='content'>
      <AccountManagerHeader />
      <Link to='/schedule-create'>
        <Button variant="outlined" className='button' icon={<PlusOutlined />}>Lập lịch</Button>
      </Link>
      <div style={{ marginTop: 16 }}>
        <Select defaultValue="mon" style={{ marginBottom: '20px', width: '200px' }}>
            <Option value="mon">Tuần 1</Option>
            <Option value="tue">Tuần 2</Option>
            <Option value="wed">Tuần 3</Option>
        </Select>
        <Table 
          columns={columns()} 
          dataSource={rows} 
          pagination={{ pageSize: 7, pageSizeOptions: [5, 10] }} 
        />
      </div>
    </div>
  );
};

export default AccountManager;
