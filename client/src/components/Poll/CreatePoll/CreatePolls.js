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
import NotInterestedIcon from '@material-ui/icons/NotInterested';
import Bgimage1 from '../../images/bgimage_1.jpg';
import Bgimage2 from '../../images/bgimage_2.jpg';
import Bgimage3 from '../../images/bgimage_3.png';

const useStyles = makeStyles({
root:{
    flexGrow: 1,
    flexBasis: 0,
    flexShrink: 1
},
});


  const CreatePolls=() => {
    const [isOpen, setIsOpen] = useState(false);
    const [img,setimg] = useState(null);

  const togglePopup = () => {
    setIsOpen(!isOpen);
  }
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
       
   }
   const [color, setColor] = React.useState(''); //for background color change in presentation component
   const [opacity, setOpacity]=React.useState(100);
   const [component, setComponent] = React.useState('');

   

    const clickHandler=(e)=> {
        switch (e) {
          case "imagechoice":
                setComponent("imagechoice")
                console.log(component)
                break
            case "multiplechoice":
                setComponent("multiplechoice")
                console.log(component)
                break
            case "wordcloud":
               setComponent("wordcloud")
               console.log(component)
               break
            case "qanda":
              setComponent("qanda")
              console.log(component)
              break
            case "openended":
              setComponent("openended")
              console.log(component)
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
            <Typography style={{fontSize:"12px"}}> Services</Typography>
            </Link>
            <Link to="/polls" style={{color:"black", textDecoration:"none" }} >
            <Typography style={{fontSize:"12px"}}>Polls</Typography>
            </Link>
            <Typography style={{fontSize:"12px"}}>
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

  
     <Sidebar color={color} parentCallback={setColor}
     component={component} clickHandler={clickHandler}
     setOpacity={setOpacity} opacity={opacity} togglePopup={togglePopup} 
     />
     
     <Presentation style={
         { float: "right", overflow: "hidden", position: "fixed"}
     } color={color} opacity={opacity} component={component} img={img} flex='1' />
     
     
    
     </Container>
     {isOpen && <Popup 
      content={<>
        <b style={{color: 'white', textAlign: 'center' }}>Background Images</b>
        
        <Grid container spacing={2} style={{margin: "4px"}}>
        <Grid item xs={6} sm={2} ><Paper style={{width: '100px', height: '100px', marginTop: '15%', marginLeft: '50%'}}>
                      <CardActions color='white' style={{height: '80px', marginLeft: '10%'}}>
                        <Button ><AddIcon/></Button>
                    </CardActions></Paper>
            </Grid>
                    <Grid item xs={6} sm={2} >
                      <CardActionArea onClick={()=>setimg(Bgimage1)}>
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
                    <CardActionArea onClick={()=>setimg(Bgimage2)}>
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
           <CardActionArea  onClick={()=>setimg(Bgimage3)} >
          <CardMedia
              component="img"
              alt="Image3"
              height="100"
              width="250"
              image={Bgimage3}
              title="3"
             
            /></CardActionArea>
                    </Grid>
                    <Grid item xs={6} sm={2} ><Paper style={{width: '100px', height: '100px', marginTop: '15%', marginLeft: '60%'}}>
           <CardActions color='white' style={{height: '80px', marginLeft: '10%'}} >
             <Button onClick={()=>setimg(null)} ><NotInterestedIcon /></Button>
          </CardActions></Paper>
                    </Grid>
                </Grid>
  
      </>}
      handleClose={togglePopup}
    />}
    </Container>
   
    
    );
}

export default CreatePolls