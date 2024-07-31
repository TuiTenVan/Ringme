import { Route, Routes} from 'react-router-dom';
import './style.css';
import SideBar from '../SideBar/SideBar';
import AccountManager from '../AccountManager/AccountManager';
import Content from '../Content/Content';
import Form from '../Form/Form';
import WorkSchedule from '../WorkSchedule/WorkSchedule';
import Schedule from '../Schedule/Schedule';
import Calendar from '../Schedule/Calendar';
import ScheduleDetail from '../Schedule/ScheduleDetail';

const HomeAdmin = () => {

  return (
    <div className='dashboard'>
      <SideBar />
      <div className="dashboard--content">
        <Routes>
          <Route path="admin/home" element={<Content />} />
          <Route path="accountManager" element={<AccountManager />}/>
          <Route path="accounts" element={<Form />} />
          <Route path="workSchedule" element={<WorkSchedule />} />
          <Route path="registrationSchedule" element={<Schedule/>} />
          <Route path="schedule-create" element={<Calendar/>} />
          <Route path="schedule-detail" element={<ScheduleDetail/>} />
        </Routes>
      </div>
    </div>
  );
}

export default HomeAdmin;
