import { Form, Input, Button, message } from "antd";
import { NavLink, useNavigate } from "react-router-dom";
import "../styles/login.css";
import TopBar from "./Web/TopBar/TopBar";
import Footer from "./Web/Footer/footer";


function Login() {
  const [form] = Form.useForm();
  const navigate = useNavigate();

  const handleSubmit = async (values) => {
    try {
      const response = await fetch("http://localhost:8081/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(values),
      });

      const data = await response.json();
      const { token, role } = data;

      localStorage.setItem("token", token);
      localStorage.setItem("role", JSON.stringify(role));

      if (role.includes("ROLE_ADMIN") || role.includes("ROLE_MANAGER")) {
        navigate("/admin/home");
      } else {
        navigate("/");
      }
    } catch (error) {
      console.error("There was an error logging in!", error);
      message.error("Không được quyền truy cập");
    }
  };

  return (
    <>
      <TopBar />
      <div className="login-container">
        <div className="login-box">
          <h1>Đăng nhập</h1>
          <Form form={form} onFinish={handleSubmit} layout="vertical">
            <Form.Item
              label="Số điện thoại"
              name="phone"
              rules={[
                {
                  required: true,
                  message: "Vui lòng nhập số điện thoại",
                },
              ]}
            >
              <Input />
            </Form.Item>
            <Form.Item
              label="Mật khẩu"
              name="password"
              rules={[
                {
                  required: true,
                  message: "Vui lòng nhập mật khẩu",
                },
              ]}
            >
              <Input.Password />
            </Form.Item>
            <Form.Item>
              <Button type="primary" htmlType="submit" className="login--button">
                Đăng nhập
              </Button>
            </Form.Item>
          </Form>
          <p className="para-2">
            Chưa có tài khoản? <NavLink to="/register">Đăng ký</NavLink>
          </p>
        </div>
      </div>
      <Footer/>
    </>
  );
}

export default Login;
