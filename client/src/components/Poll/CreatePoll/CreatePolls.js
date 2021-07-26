import React from "react";
import Sidebar from "./Sidebar";
import Presentation from "./Presentation";
import '../CreatePoll/CreatePolls.css'
import Button from '@material-ui/core/Button';
import { Link,useHistory } from 'react-router-dom';
import { Breadcrumbs, Typography } from '@material-ui/core';
import NavigateNextIcon from '@material-ui/icons/NavigateNext';
import { Container } from "@material-ui/core";
import { Grid } from "@material-ui/core";


export const typee=[
    { id: 1, label: 'multiplechoice', checked: false },
    { id: 2, label: 'imagechoise', checked: false },
    { id: 3, label: 'openended', checked: false },
    { id: 4, label: 'wordcloud', checked: false },
   ];
  function CreatePolls() {
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
       
   }
   const [color, setColor] = React.useState('white'); //for background color change in presentation component
   const [isVisible, setIsVisible] = React.useState(true); // to show and hide type(of sidebar) component in presentation
   const toggleVisibility = () => setIsVisible(!isVisible);

  
    return (
        <Container className= 'CreatePolls' style={ {marginRight:'0%'}}>
  <Container className = 'Navbar' style={{
    overflow: 'hidden'
    
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
     
       
                            <Grid
  container
  spacing={0}
  direction="row"
  alignItems="space-between"
  justify="space-between"
  overflow="hidden"
  style={{ minHeight: '80vh', minWidth: '100px', maxWidth: '2000px',
  maxheight: '120vh' }}
>

  
     <Sidebar state={color} parentCallback={setColor} isVisible={isVisible} toggleVisibility={toggleVisibility}
     style={{
         float: 'left', marginLeft: '0%' }}/>
     <Presentation style={
         { float: "right"}
     } color={color} isVisible={isVisible}/>
     
     </Grid>
    </Container>
    
    )
}

export default CreatePolls