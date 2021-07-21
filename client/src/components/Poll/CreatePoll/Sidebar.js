import React from 'react'
import { Button } from '@material-ui/core'
import { createTheme, makeStyles } from '@material-ui/core/styles'
import PollType from '../CreatePoll/PollType'
import Content from '../CreatePoll/Content'
import Background from '../CreatePoll/Background'
import '../CreatePoll/CreatePolls.css'

const useStyles = makeStyles((theme) => ({
  
}));

const theme = createTheme({
});

const Sidebar = () => {
   const menuItems =[
   { component:<PollType />, title:"Type"},
    { component:<Content />, title:"Content"},
    { component:<Background />, title:"Background" }
   ];

   const [component, setComponent] = React.useState(menuItems[0].component);
   const classes = useStyles();
    return (
      <div>
        <div className="Sidebar"><ul id="menu">
                { menuItems.map((item,i)=>
                  <Button  
                  style={
                    {
                      border: "2px",
                      margin: "0px",
                      }} > 
                    <li key={i} onClick={()=>setComponent(item.component)} className="menu-item">
                     {item.title} 
                    
          
                      
                    </li>
                   </Button> 
                  )
                  
                }
                
            </ul>
            <div className="container">
              {component}
        </div>
        </div>
        
       </div>
    );
};


export default Sidebar