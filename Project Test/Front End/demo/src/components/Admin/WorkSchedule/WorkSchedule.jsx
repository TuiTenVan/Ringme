import {Tabs, Select, Table } from 'antd';
import './WorkSchedule.css';
import AccountManagerHeader from '../AccountManager/AccountManagerHeader';

const { TabPane } = Tabs;
const { Option } = Select;

const WorkSchedule = () => {
 

  const renderTabs = () => {
    const days = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

    return days.map((day, index) => (
      <TabPane tab={day} key={index + 1}>
      </TabPane>
    ));
  };

  const dataSource = [
    { 
      key: '1', 
      shift: 'Ca sáng', 
      employees: [
        { name: 'John Doe', checkIn: '08:00', checkOut: '12:00' }, // Thêm thông tin check in và check out cho mỗi nhân viên
        { name: 'Jane Smith', checkIn: '08:30', checkOut: '12:30' },
      ] 
    },
    { 
      key: '2', 
      shift: 'Ca chiều', 
      employees: [
        { name: 'Alice Johnson', checkIn: '13:00', checkOut: '17:00' },
        { name: 'Bob Brown', checkIn: '13:30', checkOut: '17:30' },
      ] 
    },
  ];

  const columns = [
    { 
      title: 'Ca', 
      dataIndex: 'shift', 
      key: 'shift', 
      render: (shift) => (
        <div>
          <strong>{shift}</strong>
        </div>
      ),
    },
    { 
      title: 'Nhân viên đi làm', 
      dataIndex: 'employees', 
      key: 'employees', 
      render: (employees) => (
        <ul>
          {employees.map((employee, index) => (
            <li key={index}>
              {employee.name}
            </li>
          ))}
        </ul>
      ),
    },
    { 
      title: 'Check in', 
      dataIndex: 'employees', 
      key: 'checkIn', 
      render: (employees) => (
        <ul>
          {employees.map((employee, index) => (
            <li key={index}>
              {employee.checkIn}
            </li>
          ))}
        </ul>
      ),
    },
    { 
      title: 'Check out', 
      dataIndex: 'employees', 
      key: 'checkOut', 
      render: (employees) => (
        <ul>
          {employees.map((employee, index) => (
            <li key={index}>
              {employee.checkOut}
            </li>
          ))}
        </ul>
      ),
    },
  ];

  return (
    <><AccountManagerHeader/>
      <div className="your-timeline-container">
      <Select defaultValue="mon" style={{ marginBottom: '20px', width: '200px' }}>
                    <Option value="mon">Tuần 1</Option>
                    <Option value="tue">Tuần 2</Option>
                    <Option value="wed">Tuần 3</Option>
                </Select>
        <Tabs defaultActiveKey="1" type="card">
          {renderTabs()}
        </Tabs>
        <div className="table-container">
          <Table columns={columns} dataSource={dataSource} pagination={false} />
        </div>
      </div>
    </>
  );
};

export default WorkSchedule;
