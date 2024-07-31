import { NavLink } from 'react-router-dom';
import { BiBuilding, BiLogoAndroid, BiLogoHtml5 } from 'react-icons/bi';

const courses = [
    {
        title: "Quản lý tài khoản",
        icon: <BiLogoHtml5/>,
        link: "/accountManager"
    },
    {
        title: "Lịch làm việc",
        duration: '2 hours',
        icon: <BiLogoAndroid/>,
        link: "/workSchedule"
    },
    {
        title: "Lịch đăng kí",
        duration: '2 hours',
        icon: <BiBuilding/>,
        link: "/registrationSchedule"
    },
    {
        title: "Bảng tính lương",
        duration: '2 hours',
        icon: <BiBuilding/>,
        link: "/salarySheet"
    }
];

function Card(){
  return (
    <div className='card--container'>
        {courses.map((item, index) => (
            <div className='card' key={index}>
                <div className='card--cover'>{item.icon}</div>
                <div className="card--title">
                    <NavLink to={item.link}>
                        <h2>{item.title}</h2>
                    </NavLink>
                </div>
            </div>
        ))}
    </div>
  );
}

export default Card;
