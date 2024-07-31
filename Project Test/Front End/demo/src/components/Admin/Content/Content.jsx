import AccountManagerHeader from "../AccountManager/AccountManagerHeader"
import './Content.css'
import Card from './Card'
import StaffList from './StaffList'


function Content(){
  return (
    <div className='content'>
     <AccountManagerHeader />
     <Card/>
     <StaffList/>
    </div>
  )
}

export default Content