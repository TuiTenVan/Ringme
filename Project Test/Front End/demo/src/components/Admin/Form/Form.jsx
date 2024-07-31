import { Form, Input, Button, Select, Upload, DatePicker, message } from "antd";
import { useCallback } from "react";
import { UploadOutlined, ArrowLeftOutlined, PlusOutlined } from "@ant-design/icons";
import { useNavigate } from "react-router-dom";
import AccountManagerHeader from "../AccountManager/AccountManagerHeader"
import "./Form.css"
const { Option } = Select;

function AddAccounts(){
  const [form] = Form.useForm();
  const navigate = useNavigate();

  const handleSubmit = async (values) => {
    const token = localStorage.getItem('token');
    const formattedValues = {
      ...values,
      birthday: values.birthday.format("YYYY-MM-DD"),
    };

    try {
      const response = await fetch('http://localhost:8081/api/admin/accounts', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(formattedValues),
      });

      if (response.ok) {
        message.success('Tài khoản đã được thêm thành công');
        navigate('/accountManager');
      } else {
        message.error('Lỗi khi thêm tài khoản');
      }
    } catch (error) {
      console.error('Error:', error);
      message.error('Lỗi khi thêm tài khoản');
    }
  };


  const normFile = (e) => {
    if (Array.isArray(e)) {
      return e;
    }
    return e && e.fileList;
  };

  const handleGoBack = useCallback(() => {
    navigate(-1); 
  }, [navigate]);

  return (
    <>
      <AccountManagerHeader />
      <div className="container">
        <div className="form-container">
          <div className="text-left">
            <Button icon={<ArrowLeftOutlined />} onClick={handleGoBack}>
              Quay lại
            </Button>
          </div>
          <Form
            form={form}
            onFinish={handleSubmit}
            layout="vertical"
            initialValues={{ category_id: "" }}
          >
            <Form.Item
              label="Họ và tên"
              name="fullName"
              rules={[{ required: true, message: "Please enter name" }]}
              style={{ width: '70%', marginRight: '20px' }} 
            >
              <Input placeholder="Enter Name" />
            </Form.Item>
            <Form.Item
              label="Tên người dùng"
              name="name"
              rules={[{ required: true, message: "Please enter name" }]}
              style={{ width: '70%', marginRight: '20px' }} 
            >
              <Input placeholder="Enter Name" />
            </Form.Item>
            <Form.Item
              label="Địa chỉ"
              name="address"
              rules={[{ required: true, message: "Please enter address" }]}
              style={{ width: '70%' }} 
            >
              <Input placeholder="1234 Main St" />
            </Form.Item>
            <Form.Item
              label="Email"
              name="email"
              rules={[{ required: true, message: "Please enter email" }]}
              style={{ width: '70%' }} 
            >
              <Input placeholder="Enter Email" />
            </Form.Item>
            <Form.Item
                label="Số điện thoại"
                name="phone"
                rules={[{ required: true, message: "Please enter username" }]}
                style={{ width: '70%', marginRight:'20px' }} 
              >
                <Input placeholder="Enter Name" />
              </Form.Item>
            <Form.Item
              label="Password"
              name="password"
              rules={[{ required: true, message: "Please enter password" }]}
              style={{ flex:1, width: '20%' }} 
            >
              <Input.Password placeholder="Enter Password" />
            </Form.Item>
            <Form.Item
              label="Salary"
              name="salary"
              style={{ width: '70%' }} 
            >
              <Input placeholder="Enter Salary" />
            </Form.Item>
            
            <div style={{ display: 'flex', justifyContent: 'space-between' }}>
              <Form.Item
                label="Giới tính"
                name="gender"
                rules={[{ required: true, message: "Please select gender" }]}
                style={{ width: '20%', marginRight: 8 }}
              >
                <Select placeholder="Select Gender">
                  <Option value="Nam">Nam</Option>
                  <Option value="Nữ">Nữ</Option>
                  <Option value="Other">Khác</Option>
                </Select>
              </Form.Item>
              <Form.Item
                label="Ngày sinh"
                name="birthday"
                rules={[{ required: true, message: "Please select birthday" }]}
                style={{ flex: 1 }}
              >
                <DatePicker placeholder="Select Birthday" format="DD/MM/YYYY" />
              </Form.Item>
            </div>
            <Form.Item
              label="Image"
              name="image"
              valuePropName="fileList"
              getValueFromEvent={normFile}
              style={{ width: '100%' }} // Full width
            >
              <Upload name="logo" action="/upload.do" listType="picture">
                <Button icon={<UploadOutlined />}>Click to upload</Button>
              </Upload>
            </Form.Item>
            <div className="text-center">
              <Button type="primary" ghost htmlType="submit" icon={<PlusOutlined />}>
                Thêm
              </Button>
            </div>
          </Form>
        </div>
      </div>
    </>
  );
}

export default AddAccounts;
