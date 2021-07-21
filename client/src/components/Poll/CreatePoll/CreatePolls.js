import React from "react";
import Sidebar from "./Sidebar";
import '../CreatePoll/CreatePolls.css'
import { useHistory } from 'react-router-dom';
  function CreatePolls() {
    let history = useHistory();
  
    
       function handleClick(path) {
          history.push(path);
      } 
    return (
    <div className = 'CreatePolls'> 
     <Sidebar /></div>
    );
}

export default CreatePolls