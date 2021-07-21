import React from "react";
import Sidebar from "./Sidebar";
import Presentation from "./Presentation";
import '../CreatePoll/CreatePolls.css'
import Button from '@material-ui/core/Button';
import { Link,useHistory } from 'react-router-dom';
import { Breadcrumbs, Typography } from '@material-ui/core';


  function CreatePolls() {
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
   }

    return (
  <div className = 'CreatePolls'> 
                            <Button
                                    variant="contained"
                                    onClick={() => {handleClick("/link") }}
                                    style={
                                        {
                                            backgroundColor: "#cc0000",
                                            color: "white",
                                            position: "relative",
                                            float: "right",
                                            marginRight: '50px',
                                            border: "1px solid white",
                                            margin: "3px",
                                            
                                        }
                                    }
                                >Create Link
                            </Button>             
     
       <Breadcrumbs aria-label="breadcrumb">
            
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

     <Sidebar/>
     <Presentation/>


    </div> 
    )
}

export default CreatePolls