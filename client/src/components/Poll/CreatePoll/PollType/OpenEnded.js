import styled, { css } from "styled-components";
import React,{useState,useEffect} from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Box from '@material-ui/core/Box';
import randomColor from 'randomcolor'
import axios from 'axios'
const id=27
const useStyles = makeStyles((theme) => ({
    root: {
        flex: 1,
      '& > *': {
        margin: theme.spacing(1),
        width: '100%',
      
      },
    },
    h:{
      fontSize: '15px',
      marginBottom: '0',

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
  height: 1%;

`;
const OpenEnded = (props) => {
    const [OpenEndedResponses , setOpenEndedResponses] = useState({responses:[]});
  console.log("hi")
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/QandA/36`)
      console.log(result.data)
      setOpenEndedResponses({
       
        responses: result.data.questions 
      })
    },[])
    const responses_OpenEnd=["a","b"];
//     OpenEndedResponses.responses.map((post,key) => (
//     responses_OpenEnd[key]=post.text
// ));
console.log(responses_OpenEnd);
    const classes = useStyles();
    
    return (
        <div >
            <h1 fontFamily= "Helvetica" justifyContent="left" >{props.openEnded.question}</h1>
           
    {responses_OpenEnd.map((x, i) => {
         var color = randomColor();
    return(
       
       <Container marginTop= '10px'>
          <div>
                <Box color="white" bgcolor={color} p={1} fontFamily= "Helvetica" style={{ marginBottom: '5px', marginRight:"10px"}}>
              {responses_OpenEnd[i]}
                </Box>
           </div>
          
        </Container>
       
    )
    })}
    </div>
    );
}

export default OpenEnded
