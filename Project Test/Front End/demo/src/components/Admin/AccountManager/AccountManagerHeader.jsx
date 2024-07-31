import { BiNotification, BiSearch } from 'react-icons/bi';

import { useState } from 'react';
import { NavLink } from 'react-router-dom';

function AccountManagerHeader() {
  const [showMenu, setShowMenu] = useState(false);
  const [searchKeyword, setSearchKeyword] = useState('');

  const toggleMenu = () => {
    setShowMenu(!showMenu);
  };

  const handleSearchChange = (event) => {
    setSearchKeyword(event.target.value);
  };

  const handleSearchKeyPress = (event) => {
    if (event.key === 'Enter') {
      search();
    }
  };

  const search = () => {
    fetch(`http://localhost:8081/api/admin/accounts/search?fullName=${searchKeyword}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to search');
      }
      return response.json();
    })
    .then(data => {
      console.log('Search result:', data);
    })
    .catch(error => {
      console.error('Error searching:', error);
    });
  };

  const handleLogout = () => {
    localStorage.clear();
  };

  return (
    <div className='content--header'>
      <h1 className="header--title">Quản lý nhân viên</h1>
      <div className='header--activity'>
        <div className="search-box">
          <input 
            type='text' 
            placeholder='Search...'
            value={searchKeyword}
            onChange={handleSearchChange}
            onKeyPress={handleSearchKeyPress}
          />
          <BiSearch className='icon'/>
        </div>
        <div className="notify" onClick={toggleMenu}>
          <BiNotification className='icon'/>
          {showMenu && (
            <div className="dropdown-menu">
              <ul>
                <li>Thông tin tài khoản</li>
                <li>Setting</li>
                <NavLink to="/login" onClick={handleLogout}><li>Logout</li></NavLink> 
              </ul>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default AccountManagerHeader;
