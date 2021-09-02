import styled, { css } from "styled-components";
import React,{useState,useEffect} from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import randomColor from 'randomcolor'
import axios from 'axios'


const useStyles = makeStyles((theme) => ({
    root: {
        flex: 1,
        margin: theme.spacing(1),
        width: '100%',
        justifyContent:'center', alignItems:"center", height:'100%'
    },
    typography: {
        // for settings
        fontSize: 12,
      },
    button: {
        margin: theme.spacing(1),
        borderRadius: "2em",
        
      },
    addicon: {
        color: 'solid white',
    },

}));

export const Container = styled.div`
inline-size: 150px;
overflow-wrap: break-word;
text-align: center;
float: left;
  width: 250px;
  padding: 3px;
  margin: 3px;

`;


export const box = styled.div`
  height: 1%;`;
  
const OpenEnded = (props) => {
  const url = props.match.params.id;
  const [OpenEndedResponses , setOpenEndedResponses] =useState({responses:[]});
  const [resUrl, setResUrl] = useState("");
  const [question,setquestion]=useState({question:""})
  const [Background, setBackground]=useState({
    bgcolor: 'white',
    textcolor: 'black',
    opacity: 100,
  })

      useEffect(async ()=>{
        await axios.get(`http://localhost:8080/OE/${url}`)
                    .then(res=>{
                      setquestion({question:res.data.question})
                       console.log(res.data);
                       const update={...Background, 
                        bgcolor: res.data.bg.bgColor,
                         textcolor: res.data.bg.textColor,
                         opacity: (res.data.bg.opacity/10)*0.1
                      }
                      setBackground(update)
                   })
                  .catch((error)=>{
                    console.log(error)
                  })
        await axios.get(`http://localhost:8080/quest/${url}`)
      .then(result => {
        setResUrl(result.data);
        if(resUrl !== ""){
          axios.get(`http://localhost:8080/responses/${resUrl}`)
          .then ((res) => {
            setOpenEndedResponses({responses: res.data.responses})
          })
          .catch(error => console.log(error))
        }
      })
      .catch(error => console.log(error))
 
    },[url,resUrl])
        

    const choice=OpenEndedResponses.responses;
    const classes = useStyles();
    
    return (
      <div  style={{
        backgroundColor: Background.bgcolor,
        opacity: Background.opacity,
        color: Background.textcolor,
        width: '100%',
        height:'100%'}}>
       
      <h1 style={{ marginTop:"50px", fontFamily:"Helvetica",  textAlign:"center", fontSize:"30px"}} >{question.question} </h1>
     <div style={{justifyContent: 'space-evenly',display: 'flex', flexWrap: 'wrap', width: '70%',margin:"auto"}} >
           {choice.map((x, i) => {
           const color = randomColor({luminosity:"bright"});
      return(
         
         <Container style={{padding:"1%"}}>
            <Box color="white" bgcolor={color} p={2} fontFamily= "Helvetica" style={{ backgroundColor:{color}, width: '100%'}} >
                    {x}
            </Box>
          </Container>
         
      )
      })} 
      </div>
      </div>
    );
}

export default OpenEnded
