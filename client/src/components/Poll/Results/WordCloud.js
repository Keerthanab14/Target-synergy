import styled, { css } from "styled-components";
import React,{useState,useEffect} from 'react'
import { makeStyles } from '@material-ui/core/styles';
import ReactWordcloud from 'react-wordcloud';
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
const WordCloud = (props) => {
    const url = props.match.params.id;
    const [WCResponses , setWCResponses] =useState({});
    const [resUrl, setResUrl] = useState("");
    const [question,setquestion]=useState({question:""})
    axios.get(`http://localhost:8080/WC/${url}`)
   .then(res=>{
         setquestion({question:res.data.question})
        //  console.log(question);
    })
    .catch((error)=>{
      console.log(error)
    })
    useEffect(async ()=>{
      await axios.get(`http://localhost:8080/quest/${url}`)
    .then(result => {
      setResUrl(result.data);
      // console.log(result.data);
    })
    .catch(error => console.log(error))
  },[])
  // console.log(resUrl);
  // if(resUrl !== ""){
  //   axios.get(`http://localhost:8080/responses/${resUrl}`)
  //   .then ((res) => {
  //     setWCResponses({responses: res.data.responses})
  //     // console.log(WCResponses.responses)
  //   })
  //   .catch(error => console.log(error))
  // }

  
const wcr=["hh","hyyf"];
if(resUrl !== ""){
    axios.get(`http://localhost:8080/WordCloudResponse/${resUrl}`)
      .then(res=>{
    // console.log(res.data)
    setWCResponses(res.data)
    })
    
}
// console.log(WCResponses)
      let i=0
      Object.entries(WCResponses).forEach(([key, value]) => {
      wcr[i]=({text:`${key}`, value:`${value}`})
      // console.log(wcr[i])
      i++
      })

  // let wcrs=[...wcr]
  console.log(wcr[0])


  const resizeStyle = {
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    border: "solid 1px #ddd",
    width: '97%%',
    height: '100%',
    marginTop: '5%'
  };
  const callbacks = {
      getWordColor: word => word.value > 50 ? "blue" : "red",
      onWordClick: console.log,
      onWordMouseOver: console.log,
      getWordTooltip: word => `${word.text} (${word.value}) [${word.value > 50 ? "" : ""}]`
  }

  const options = {
      colors: ["#1f77b4", "#ff7f0e", "#2ca02c", "#d62728", "#9467bd", "#8c564b"],
      enableTooltip: true,
      deterministic: false,
      fontFamily: "helvetica",
      fontSizes: [ 30, 100],
      fontStyle: "normal",
      fontWeight: "normal",
      padding: 1,
      rotations: 2,
      rotationAngles: [0, 90, -90],
      scale: "sqrt",
      spiral: "archimedean",
      transitionDuration: 1000
  };
  const size = [1200, 400];

return (
<div >
<h1 style={{fontFamily: "Helvetica", textAlign: 'center'}} >{question.question} </h1>
=======

const resizeStyle = {
display: "flex",
alignItems: "center",
justifyContent: "center",
border: "solid 1px #ddd",
width: '80%',
height: '100%',


};
const callbacks = {
//getWordColor: word => word.value > 50 ? "blue" : "red",
onWordClick: console.log,
onWordMouseOver: console.log,
//getWordTooltip: word => `${word.text} (${word.value}) [${word.value > 50 ? "" : ""}]`,
}

const options = {
colors: ["#1f77b4", "#ff7f0e", "#2ca02c", "#d62728", "#9467bd", "#8c564b"],
enableTooltip: true,
deterministic: false,
fontFamily: "helvetica",
fontSizes: [ 20, 90],
fontStyle: "normal",
fontWeight: "normal",
padding: 1,
rotations: 2,
rotationAngles: [0],
scale: "sqrt",
spiral: "archimedean",
transitionDuration: 1000
};
//const size = [1200, 400];

return (
<div style={{display:'flex',flexDirection:'column',justifyContent:'center',alignItems:'center',height:'100%',width:'100%'}} >
<h1 style={{fontFamily: "Helvetica", textAlign: 'center'}} >kk{question.question}</h1>



  <div style={resizeStyle}>
  <ReactWordcloud
  callbacks={callbacks}
  options={options}

  size={size}
  words={wcr}
  />
</div>
</div>
);
}

export default WordCloud
