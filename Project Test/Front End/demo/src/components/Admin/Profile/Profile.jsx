
import ProfileHeader from './ProfileHeader'
import "./Profile.css"
import { BiUser } from 'react-icons/bi'

const description = [
  {
    title: "Tui là mèo",
    description: "Mèo Mèo Mèo",
    icon: <BiUser/>
  },
  {
    title: "Tui là mèo",
    description: "Mèo Mèo Mèo",
    icon: <BiUser/>
  },
  {
    title: "Tui là mèo",
    description: "Mèo Mèo Mèo",
    icon: <BiUser/>
  }
]

function Profile(){
  return (
    <div className='profile'>
      <ProfileHeader/>
      <div className="user--profile">
        <div className="user--detail">
          <img src='https://static.vecteezy.com/system/resources/previews/000/439/863/original/vector-users-icon.jpg' alt=''></img>
          <h3 className='username'>Tui là mèo</h3>
          <span className="professtion">Mèo Mèo Mèo</span>
        </div>
        <div className="user--description">
            {description.map((description) => (
              <>
                <div className='description'>
                  <div className="description--detail">
                      <div className="description--cover">
                        {description.icon}
                      </div>
                      <div className="description--name">
                        <h5 className='title'>{description.title}</h5>
                        <span className='description1'>{description.description}</span>
                      </div>
                  </div>
                </div>
              </>       
            ))}
        </div>
      </div>
    </div>
  )
}

export default Profile