
import { BiEdit } from 'react-icons/bi'

function ProfileHeader(){
  return (
    <div className='profile--header'>
        <h2 className='header--title'>Profile</h2>
        <div className="edit">
            <BiEdit className='icons'/>
        </div>
    </div>
  )
}

export default ProfileHeader