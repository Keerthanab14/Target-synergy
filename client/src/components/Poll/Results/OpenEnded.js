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
const OpenEnded = () => {
  const [question,setquestion]=useState({question:""})
  // axios.get(`http://localhost:8080/OpenEnded/611972bf71e57871d4321fe4`).then(res=>{
        
  //       setquestion({question:res.data.question})
       
  //   })
    const [OpenEndedResponses , setOpenEndedResponses] = useState({responses:[]});
  
//     useEffect(async () => {
//       var result = await axios.get(`http://localhost:8080/responses/611ac9536bc994626e4d6beb`)
//   setOpenEndedResponses({
    
//     OpenEndedResponses: result.data.responses 
//   })
// },[])
    axios.get(`http://localhost:8080/responses/611ac9536bc994626e4d6beb`)
    .then(res=>{
      console.log(res)
      setOpenEndedResponses({
        responses: res.data.responses
      })
    })
    .catch (error=> {
      console.log(error.response);
    })
    const responses_OpenEnd=[];
    console.log(OpenEndedResponses)
//    OpenEndedResponses.map((post,key) => (
//      responses_OpenEnd[key]=post.text
//  ));
console.log(responses_OpenEnd);
    const classes = useStyles();
    
    return (
        <div >
            <h1 fontFamily= "Helvetica" justifyContent="left" >{question.question}</h1>
           
    {OpenEndedResponses.responses.map((x, i) => {
         var color = randomColor();
    return(
       
       <Container marginTop= '10px'>
          <div>
                <Box color="white" bgcolor="#cc0000" p={1} fontFamily= "Helvetica" style={{ backgroundColor:'#cc0000', marginBottom: '5px', marginRight:"10px"}} >
              {x}
                </Box>
           </div>
          
        </Container>
       
    )
    })}
    </div>
    );
}

export default OpenEnded
