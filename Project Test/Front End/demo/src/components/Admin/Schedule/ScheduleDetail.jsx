import { Table, Checkbox, Select, Button } from 'antd';
import {ArrowLeftOutlined} from "@ant-design/icons";
import AccountManagerHeader from '../AccountManager/AccountManagerHeader';
import { useCallback } from 'react';
import { useNavigate } from "react-router-dom";

const { Option } = Select;

const columns = [
  { title: 'Ca', dataIndex: 'shift', key: 'shift' },
  { title: 'Thứ 2', dataIndex: 'monday', key: 'monday', render: () => <Checkbox /> },
  { title: 'Thứ 3', dataIndex: 'tuesday', key: 'tuesday', render: () => <Checkbox /> },
  { title: 'Thứ 4', dataIndex: 'wednesday', key: 'wednesday', render: () => <Checkbox /> },
  { title: 'Thứ 5', dataIndex: 'thursday', key: 'thursday', render: () => <Checkbox /> },
  { title: 'Thứ 6', dataIndex: 'friday', key: 'friday', render: () => <Checkbox /> },
  { title: 'Thứ 7', dataIndex: 'saturday', key: 'saturday', render: () => <Checkbox /> },
];

const data = [
  { key: '1', shift: 'Ca sáng' },
  { key: '2', shift: 'Ca chiều' },
];




const ScheduleDetail = () => {
    const navigate = useNavigate();
    const handleGoBack = useCallback(() => {
        navigate(-1); 
      }, [navigate]);

    return (
        <>
            <AccountManagerHeader />
            <div className="text-left">
            <Button icon={<ArrowLeftOutlined />} onClick={handleGoBack}>
              Quay lại
            </Button>
          </div>
            <div style={{ width: '100%' }}>
                <Select defaultValue="mon" style={{ marginBottom: '20px', width: '200px' }}>
                    <Option value="mon">Tuần 1</Option>
                    <Option value="tue">Tuần 2</Option>
                    <Option value="wed">Tuần 3</Option>
                </Select>

                <Table columns={columns} dataSource={data} bordered pagination={false} />

                <Button type="primary" ghost style={{ marginRight: '10px', marginTop: '20px' }}>Lưu</Button>
                <Button danger style={{ marginTop: '20px' }}>Xóa</Button>
            </div>
        </>
        
    );
};

export default ScheduleDetail;