import React from "react";
import Sidebar from "./Sidebar";
import Presentation from "./Presentation";
import '../CreatePoll/CreatePolls.css'
import Button from '@material-ui/core/Button';
import { Link,useHistory } from 'react-router-dom';
import { Breadcrumbs, Typography } from '@material-ui/core';
import { Row } from "react-bootstrap";


  function CreatePolls() {
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
   }

    return (
        <div className= 'CreatePolls'>
  <div className = 'Navbar' style={{
    overflow: 'hidden'
    
  }}> 
        <Breadcrumbs aria-label="breadcrumb" style={{float: 'left' }}>
            
            <Link to="/" style={{color:"black", textDecoration:"none" }} >
                   Services
            </Link>
            <Link to="/polls" style={{color:"black", textDecoration:"none" }} >
                   Polls
            </Link>
            <Typography>
                  Design
            </Typography>
           </Breadcrumbs> 
           <Button
                    variant="contained"
                    onClick={() => {handleClick("/link") }}
                             style={
                                 {
                                            backgroundColor: "#cc0000",
                                            color: "white",
                                            float: "right",
                                            marginRight: 25,
                                            border: "1px solid white",
                                            margin: "3px",
                                            
                                        }
                                    }
                                >Create Link
                            </Button>                     
                            </div> 
     
       
<div className='Designarea' style={{
    overflow: 'hidden',
    marginTop: -30
}}>
     <Sidebar style={{
         float: 'left'
     }}/>
     <Presentation style={
         {position: "relative",
         float: "right",
        }
     }/>
     
     </div>
    </div>
    
    )
}

export default CreatePolls