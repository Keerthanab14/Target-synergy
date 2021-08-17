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
const WordCloudUser = ({data3}) => {
    const [WordCloudQues , setWordCloudQues] = useState({question:""});
 
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/WordCloud/97`)
      setWordCloudQues({
       
        question: result.data.question
      })

      
    function handle(e){
        const newdata={...inputList}
        newdata[e.target.id]=e.target.value
        setInputList(newdata)
        console.log(newdata)
  
      }
    },[])
//     const responses_OpenEnd=[];
//     OpenEndedResponses.responses.map((post,key) => (
//     responses_OpenEnd[key]=post.text
// ));
//console.log(responses_OpenEnd);
    const classes = useStyles();
    
    return (
        
              <form onSubmit={submit} className={classes.root} noValidate autoComplete="off">
              <h1 fontFamily= "Helvetica" justifyContent="left" >{WordCloudQues.question}</h1>
        <TextField id="outlined-basic" label="Your multiple choice question" variant="outlined" size="small" onChange={(e)=>handle(e)} id="question" value={inputList.question} type="text" style={{width: '100%'}} />

           
    {/* {responses_OpenEnd.map((x, i) => {
         var color = randomColor();
    return(
       
       <Container marginTop= '10px'>
          <div>
          <form onSubmit={submit} className={classes.root} noValidate autoComplete="off">

          <TextField id="outlined-basic" label="Your multiple choice question" variant="outlined" size="small" onChange={(e)=>handle(e)} id="question" value={inputList.question} type="text" style={{width: '100%'}} />
            </form>
           </div>
          
        </Container>
       
    )
    })} */}
    </form>
    );
}

export default WordCloudUser
