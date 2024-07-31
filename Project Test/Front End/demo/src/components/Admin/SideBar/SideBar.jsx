import { BiHome, BiLeftIndent, BiMessage, BiSolidReport, BiStats, BiTask } from 'react-icons/bi';
import { NavLink } from 'react-router-dom';
import './SideBar.css';

function SideBar() {
  return (
    <div className='menu'>
      <div className='logo'>
        <BiLeftIndent className='logo--icon'/>
        <h2>Administrator</h2>
      </div>

      <div className='menu--list'>
        <NavLink to="admin/home" className='item' activeClassName='active'>
          <BiHome className='icon'/>
          Trang chủ
        </NavLink>
        <NavLink to="accountManager" className='item' activeClassName='active'>
          <BiTask className='icon'/>
          Quản lý tài khoản
        </NavLink>
        <NavLink to="workSchedule" className='item' activeClassName='active'>
          <BiSolidReport className='icon'/>
          Lịch làm việc
        </NavLink>
        <NavLink to="registrationSchedule" className='item' activeClassName='active'>
          <BiStats className='icon'/>
          Lịch đăng kí
        </NavLink>
        <NavLink to="salarySheet" className='item' activeClassName='active'>
          <BiMessage className='icon'/>
          Bảng tính lương
        </NavLink>

      </div>
    </div>
  );
}

export default SideBar;
