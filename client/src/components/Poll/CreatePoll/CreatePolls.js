import React,{useState} from "react";
import Sidebar from "./Sidebar";
import Presentation from "./Presentation";
import '../CreatePoll/CreatePolls.css'
import CardMedia from '@material-ui/core/CardMedia';
import CardActions from '@material-ui/core/CardActions';
import AddIcon from '@material-ui/icons/Add';
import Button from '@material-ui/core/Button';
import { Link,useHistory } from 'react-router-dom';
import { Breadcrumbs, CardActionArea, Paper, Typography } from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import NavigateNextIcon from '@material-ui/icons/NavigateNext';
import { Container, Grid } from "@material-ui/core";

import Bgimage1 from '../../images/bgimage_1.jpg';
import Bgimage2 from '../../images/bgimage_2.jpg';
import Bgimage3 from '../../images/bgimage_3.jpg';

const useStyles = makeStyles({
root:{
    flexGrow: 1,
    flexBasis: 0,
    flexShrink: 1
},
});


  function CreatePolls() {
    const [isOpen, setIsOpen] = useState(false);
 
  const togglePopup = () => {
    setIsOpen(!isOpen);
  }
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
       
   }
   const [color, setColor] = React.useState('white'); //for background color change in presentation component
   const [opacity, setOpacity]=React.useState(100);
   const [component, setComponent] = React.useState("multiplechoice");

   

    const clickHandler=()=> {
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
   
   const classes = useStyles();
   const Popup = props => {
    return (
      <div className="popup-box">
        <div className="box">
          <span className="close-icon" onClick={props.handleClose}>x</span>
          {props.content}
        </div>
      </div>
    );
  };

  
    return (
        
        <Container className={classes.root} style={ {marginRight:'0%'}}>
  <Container className = 'Navbar' display='flex' flex='1' jutify='space-between' style={{
    overflow: 'hidden', 
    
  }}> 
        <Breadcrumbs separator={<NavigateNextIcon fontSize="small" />} aria-label="breadcrumb" style={{float: 'left' , margin: "10px" }}>
            <Link to="/" style={{color:"black", textDecoration:"none" }} >
            <Typography style={{fontSize:"18px"}}> Services</Typography>
            </Link>
            <Link to="/polls" style={{color:"black", textDecoration:"none" }} >
            <Typography style={{fontSize:"18px"}}>Polls</Typography>
            </Link>
            <Typography style={{fontSize:"18px"}}>
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
                                            marginRight: "-2%"
                                            
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

  
     <Sidebar state={color} parentCallback={setColor}
     component={component} clickHandler={clickHandler}
     setOpacity={setOpacity} opacity={opacity} togglePopup={togglePopup}
     
     />
     
     <Presentation style={
         { float: "right", overflow: "hidden", position: "fixed"}
     } color={color} opacity={opacity} component={component}  flex='1' />
     
     
    
     </Container>
     {isOpen && <Popup 
      content={<>
        <b style={{color: 'white'}}>Background Images</b>
        
        <Grid container spacing={2} style={{margin: "4px"}}>
        <Grid item xs={6} sm={2} >
                      <CardActions><Paper>
                        <Button  ><AddIcon/></Button></Paper>
                    </CardActions>
            </Grid>
                    <Grid item xs={6} sm={2} >
                      <CardActionArea>
                    <CardMedia
              component="img"
              alt="Image1"
              height="100"
              width="250"
              image={Bgimage1}
              title="1"
            /> </CardActionArea>
            </Grid>
            
                    <Grid item xs={6} sm={2} >
                    <CardActionArea>
                    <CardMedia
              component="img"
              alt="Image2"
              height="100"
              width="250"
              image={Bgimage2}
              title="2"
            /> </CardActionArea>
                    </Grid>
                   
           <Grid item xs={6} sm={2} >
           <CardActionArea >
          <CardMedia
              component="img"
              alt="Image3"
              height="100"
              width="250"
              image={Bgimage3}
              title="3"
            /></CardActionArea>
                    </Grid>

                </Grid>
           
       
        
      </>}
      handleClose={togglePopup}
    />}
    </Container>
   
    
    );
}

export default CreatePolls