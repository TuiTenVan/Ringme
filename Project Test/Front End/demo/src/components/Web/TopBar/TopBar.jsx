import { Layout, Menu, Button } from 'antd';
import './TopBar.css';
import { Link } from 'react-router-dom';

const { Header } = Layout;

function TopBar() {
    return (
        <Layout>
            <Header className="header"> 
                <div className="logo">
                    <a href="/">MyLogo</a>
                </div>
                <Menu theme="filled" mode="horizontal" defaultSelectedKeys={['1']} className="nav-menu">
                    <Menu.Item key="1"><a href="/">Home</a></Menu.Item>
                    <Menu.Item key="2"><a href="/">About</a></Menu.Item>
                    <Menu.Item key="3"><a href="/">Services</a></Menu.Item>
                    <Menu.Item key="4"><a href="/">Contact</a></Menu.Item>
                </Menu>
                <div className="auth-buttons">
                    <Link to="/login">
                        <Button type="default" className="login-button">Login</Button>
                    </Link>
                    <Link to="/register">
                        <Button type="primary" className="signup-button">Sign Up</Button>
                    </Link>
                </div>
            </Header>
        </Layout>
    );
}

export default TopBar;
