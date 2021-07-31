import React from "react";
import Sidebar from "./Sidebar";
import Presentation from "./Presentation";
import '../CreatePoll/CreatePolls.css'
import Button from '@material-ui/core/Button';
import { Link,useHistory } from 'react-router-dom';
import { Breadcrumbs, Typography } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import NavigateNextIcon from '@material-ui/icons/NavigateNext';
import { Container } from "@material-ui/core";
const useStyles = makeStyles({
root:{
    flexGrow: 1,
    flexBasis: 0,
    flexShrink: 1
},
});


  function CreatePolls() {
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
       
   }
   const [color, setColor] = React.useState('white'); //for background color change in presentation component
   const [isVisible, setIsVisible] = React.useState(true);
   const [component, setComponent] = React.useState("multiplechoice")

    function clickHandler(component) {
        switch (component) {
            case "multiplechoice":
                setComponent('multiplechoice')
                
                break
            case "imagechoice":
                
                setComponent('imagechoice')
                
                break
            case "wordcloud":
               setComponent('wordcloud')
               break
               
        }
    }
   const types = React.createContext(component);
   const toggleVisibility = () => setIsVisible(!isVisible);
   const classes = useStyles();

  
    return (
        
        <Container className={classes.root} style={ {marginRight:'0%'}}>
  <Container className = 'Navbar' display='flex' flex='1' jutify='space-between' style={{
    overflow: 'hidden', 
    
  }}> 
        <Breadcrumbs separator={<NavigateNextIcon fontSize="small" />} aria-label="breadcrumb" style={{float: 'left' , margin: "10px" }}>
            <Link to="/" style={{color:"black", textDecoration:"none" }} >
            <Typography style={{fontSize:"20px"}}> Services</Typography>
            </Link>
            <Link to="/polls" style={{color:"black", textDecoration:"none" }} >
            <Typography style={{fontSize:"20px"}}>Polls</Typography>
            </Link>
            <Typography style={{fontSize:"20px"}}>
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
                                            border: "1px solid white",
                                            margin: "1% 0%",
                                            
                                        }
                                    }
                                >Create Link
                            </Button>                     
                            </Container> 
     
       
                            <Container

 flex='1'
  spacing={0}
  Flexdirection="row"
  display="flex"
  style={{ minHeight: '80vh', maxWidth: '2000px' }}
>

  
     <Sidebar state={color} parentCallback={setColor} isVisible={isVisible} toggleVisibility={toggleVisibility} 
     component={component} clickHandler={clickHandler}
     
     />
     < types.Provider value={component}>
     <Presentation style={
         { float: "right", overflow: "hidden", position: "fixed"}
     } color={color} isVisible={isVisible} component={component}  flex='1' />
     </types.Provider>
     
     </Container>
    </Container>
   
    
    );
}

export default CreatePolls