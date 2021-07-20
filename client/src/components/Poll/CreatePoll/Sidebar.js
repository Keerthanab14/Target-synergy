import React from 'react'
import PollType from '../CreatePoll/PollType'
import Content from '../CreatePoll/Content'
import Background from '../CreatePoll/Background'
import '../CreatePoll/CreatePolls.css'

const divStyle = {
    display: 'flex',
    alignItems: 'center',
    
  };

const Sidebar = () => {
   const menuItems =[
   { id: 1, menuname:'Type', source: {PollType}, title:"Type"},
    {id: 2, menuname:'Content', source: {Content}, title:"Content"},
    {id: 2, menuname:'Background',source:{Background}, title:"Background" }
   ];

   const [menuname, setComponent] = React.useState(menuItems[0].menuname);

    return (
      <div>
        <div className="Sidebar">
            <ul id="menu">
            <div style={divStyle}>
                {
                  menuItems.map((item,i)=>
                    <li key={i} onClick={()=>setComponent(item.menuname)} className="menu-item">
                      {item.title} 
                      &nbsp;
                    </li>
                  )
                }
                </div>
            </ul>
            <div className="container">
           {menuname}
        </div>
        </div>
        
       </div>
    );
};


export default Sidebar