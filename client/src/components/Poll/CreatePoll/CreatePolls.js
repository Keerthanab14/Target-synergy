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
import axios from 'axios'

const useStyles = makeStyles((theme) => ({
root:{
    flexGrow: 1,
    flexBasis: 0,
    flexShrink: 1
},
button: {
  margin: theme.spacing(1),
  borderRadius: "2em",
},
}));


  const CreatePolls=({setId}) => {
    const [isOpen, setIsOpen] = useState(false);
    const [img,setimg] = useState(null);
    const [result, setResult] = useState(
     [ {
        distance: 5,
        colors: ["#ffd847", "#e0a106"],
        label: ""
      }
    ]
    );                          //multiplechoice type
    const[data1, setData1]=useState({
      question: "",
      choice:[]
  })
     const[data2, setData2]=useState({
     question: "",
     choice:[]
})
    const[data3, setData3]=useState({
    question:""
})
const[data5, setData5]=useState({
  question: "",
  choice:[]
})
    const [state, setState] = React.useState({
      checkedA: false,
       checkedB: false,
     checkedC: false,
     selectedFile: null
   });
   
   const onFileChange = (event) => {
      setState({ selectedFile: event.target.files[0] }); 
    };

    const fileData = () => {
    };
    const [inputList, setInputList] = useState([{ choice: "" }]);

const handleInputChange = (e) => {
  const { name, value } = e.target;
  const list = [...inputList];
  list[name] = value;
  setInputList(list);
};               
  const togglePopup = () => {
    setIsOpen(!isOpen);
  }
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
       
   }
   const [color, setColor] = React.useState(''); //for background color change in presentation component
   const [opacity, setOpacity]=React.useState(100);
   const [component, setComponent] = React.useState('multiplechoice');

   

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
            case "scales":
              setComponent("scales")
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
     setOpacity={setOpacity} opacity={opacity} togglePopup={togglePopup} setData1={setData1} data1={data1} data2={data2} setData2={setData2} 
     data3={data3} setData3={setData3} data5={data5} setData5={setData5} result={result} setResult={setResult}
     />
     
     <Presentation style={
         { float: "right", overflow: "hidden", position: "fixed"}
     } color={color} opacity={opacity} component={component} img={img} data1={data1} data2={data2} data3={data3} data5={data5} result={result} flex='1'  />
     
     
    
     </Container>
     {isOpen && <Popup 
      content={<>
        <b style={{color: 'black', textAlign: 'center' }}>Background Images</b>
        
        <Grid container spacing={2} style={{margin: "4px"}}>
        <Grid item xs={6} sm={2} >
        <h7 style={{color: "black"}}>Add your own image</h7>
                      {inputList.map((x, i) => {
                        return (
                          <div>
                        {fileData()}
                        <Button 
                        className={classes.button}
                        size="small"
                        width="10px"
                        fullWidth={true}
                        name="choice"
                        style={{ width: '190px', position: 'relative', height: '60px', marginTop: '8%', marginLeft: '10%', backgroundColor: "white", color: "black"}}
                        placeholder="Enter choice"value={x.choice}
                        onChange={e => handleInputChange(e)}  ><input type="file" onChange={e => onFileChange(e)} />
                        </Button>
                        <Button className={classes.button}
                            style={{borderRadius: "2em",
                                         size: 'small',
                                         fontSize: '11px',
                                         textAlign: 'center',
                                         position: 'relative',
                                         marginLeft: '17px',
                                         marginTop: '0px',
                                         width: '8%', background:"white",
                                         color:'black'}}
                                         
                                         >
                                           Set
                        </Button>
                        </div>
        );
      })}
                   
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