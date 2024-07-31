import { Form, Input, Button, Col, Row, Select, DatePicker } from "antd";
import { useNavigate, NavLink } from "react-router-dom";
import "../styles/register.css"; 
import TopBar from "./Web/TopBar/TopBar";
import Footer from "./Web/Footer/footer";


function Register() {
  const [form] = Form.useForm();
  const navigate = useNavigate();

  const handleSubmit = async (values) => {
    try {
      const response = await fetch("http://localhost:8081/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(values),
      });

      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      alert("Registration successful!");
      navigate("/login");
    } catch (error) {
      console.error("There was an error registering!", error);
      alert("An error occurred. Please try again.");
    }
  };

  return (
    <>
      <TopBar />
      <div className="signup-box">
        <h1>Đăng ký</h1>
        <Form
          form={form}
          layout="vertical"
          onFinish={handleSubmit}
          className="register-form"
        >
          <Row gutter={[16, 16]}>
            <Col span={12}>
              <Form.Item
                label="Họ và tên"
                name="fullName"
                rules={[{ required: true, message: "Vui lòng nhập họ và tên" }]}
              >
                <Input />
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                label="Tên tài khoản"
                name="name"
                rules={[{ required: true, message: "Vui lòng nhập tên tài khoản" }]}
              >
                <Input />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={[16, 16]}>
            <Col span={12}>
              <Form.Item
                label="Số điện thoại"
                name="phone"
                rules={[{ required: true, message: "Vui lòng nhập số điện thoại" }]}
              >
                <Input />
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                label="Email"
                name="email"
                rules={[{ required: true, message: "Vui lòng nhập email" }, { type: 'email', message: 'Email không hợp lệ' }]}
              >
                <Input />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={[16, 16]}>
            <Col span={12}>
              <Form.Item
                label="Mật khẩu"
                name="password"
                rules={[{ required: true, message: "Vui lòng nhập mật khẩu" }]}
              >
                <Input.Password />
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                label="Địa chỉ"
                name="address"
                rules={[{ required: true, message: "Vui lòng nhập địa chỉ" }]}
              >
                <Input />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={[16, 16]}>
            <Col span={12}>
              <Form.Item
                label="Giới tính"
                name="gender"
                rules={[{ required: true, message: "Vui lòng chọn giới tính" }]}
              >
                <Select placeholder="Chọn giới tính">
                  <Select.Option value="Nam">Nam</Select.Option>
                  <Select.Option value="Nữ">Nữ</Select.Option>
                  <Select.Option value="Khác">Khác</Select.Option>
                </Select>
              </Form.Item>
            </Col>
            <Col span={12}>
              <Form.Item
                label="Ngày sinh"
                name="birthday"
                rules={[{ required: true, message: "Vui lòng chọn ngày sinh" }]}
              >
                <DatePicker style={{ width: "100%" }} />
              </Form.Item>
            </Col>
          </Row>
          <Row gutter={[16, 16]}>
            <Col span={24}>
              <Button type="primary" htmlType="submit" className="register-button">
                Đăng ký
              </Button>
            </Col>
          </Row>
          <p className="para-2">
            Đã có tài khoản? <NavLink to="/login">Đăng nhập</NavLink>
          </p>
        </Form>
      </div>
      <Footer/>
    </>
  );
}

export default Register;
