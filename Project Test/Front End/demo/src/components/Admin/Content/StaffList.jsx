import { useState, useEffect } from "react";
import { Table, Switch, Image, message } from "antd";
import "./StaffList.css";
import { getListStaff } from "../../../services/staffListService";

function StaffList() {
  const [staffList, setStaffList] = useState([]);
  const [shouldFetch, setShouldFetch] = useState(true);


  useEffect(() => {
    if (shouldFetch) {
      const fetchStaffList = async () => {
        try {
          const json = await getListStaff(); 
          setStaffList(json); 
          setShouldFetch(false);
        } catch (error) {
          console.error("Failed to fetch staff list:", error);
        }
      };

      fetchStaffList();
    }
  }, [shouldFetch]);
  
  const handleSwitchChange = (id) => {
    const updatedStaffList = staffList.map((staff) => {
      if (staff.id === id) {
        const updatedStaff = { ...staff, status: 1 };
        updateStaffInDatabase(updatedStaff);
        return updatedStaff;
      }
      return staff;
    });
    setStaffList(updatedStaffList);
  };

  const updateStaffInDatabase =  (staff) => {
    const token = localStorage.getItem("token");
    fetch(`http://localhost:8081/api/admin/accounts/approve/${staff.id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(staff),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Lỗi khi cập nhật dữ liệu nhân viên");
        }
        message.success("Duyệt tài khoản thành công");
        setShouldFetch(true);
      })
      .catch((error) => {
        console.error(error);
        message.error("Lỗi khi duyệt tài khoản");
        setShouldFetch(true);
      });
  };

  const columns = [
    {
      title: "Avatar",
      dataIndex: "image",
      key: "image",
      render: (image, record) => <Image src={image} alt={record.fullName} />,
      align: "center",
    },
    {
      title: "Họ và tên",
      dataIndex: "fullName",
      key: "fullName",
      className: "align-center",
      align: "center",
    },
    {
      title: "Tên tài khoản",
      dataIndex: "name",
      key: "name",
      className: "align-center",
      align: "center",
    },
    {
      title: "Số điện thoại",
      dataIndex: "phone",
      key: "phone",
      className: "align-center",
      align: "center",
    },
    {
      title: "Trạng thái",
      key: "status",
      dataIndex: "status",
      render: (status, record) => (
        <Switch
          checked={status === 1}
          onChange={() => handleSwitchChange(record.id)}
          inputProps={{ "aria-label": "controlled" }}
        />
      ),
      align: "center",
    },
  ];

  return (
    <div className="staff--list">
      <div className="list--header align-center">
        <h2>Danh sách chờ xét duyệt</h2>
      </div>
      <div className="list--container">
        <Table
          columns={columns}
          dataSource={staffList}
          rowKey="id"
          pagination={false}
          className="center-table"
          pagination={{ pageSize: 5, pageSizeOptions: [5, 10] }} 
        />
      </div>
    </div>
  );
}

export default StaffList;
