import React, {useState, useEffect} from 'react';
import PropTypes from 'prop-types';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Slider from '@material-ui/core/Slider';
import Typography from '@material-ui/core/Typography';
import Tooltip from '@material-ui/core/Tooltip';
import axios from 'axios'
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button'
import Input from '@material-ui/core/Input';
import randomColor from 'randomcolor'
import { ChatVoice } from 'styled-icons/remix-line';
import { List } from '@material-ui/core';
const id=36

const useStyles = makeStyles({
    root: {
      width: '100%',
      height: '100%'
    },
    input: {
      width: 20,
    },
  });
  
  const Scales =() => {
    const [questions , setQuestions] = useState({questions:[]});
 
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/QandA/${id}`)
      setQuestions({
       
        questions: result.data.questions 
      })
    },[])
    const qAndA=[1,2,3];
  // questions.questions.map((post,key) => (
  //  qAndA[key]=post.text
//));
console.log(qAndA);
    const classes = useStyles();
    let a=new Array(qAndA.length).fill(0)
   // console.log(a)
    

    //const [inputList, setInputList] = useState([{value}]);
    const [value, setValue] = React.useState(a);
    const [inputList, setInputList] = useState([{ choice: "" }]);
    const handleSliderChange =(index)=>(event, newValue) => {
      const list=[...value]
  
      list[index]=newValue
      setValue(list);
      console.log(list)
    };
  
    const handleInputChange = (event,index) => {
     setValue(event.target.value === '' ?  '' : Number(event.target.value));
    
      
    };
  
    const handleBlur = () => {
      if (value < 0) {
        setValue(0);
      } else if (value > 100) {
        setValue(100);
      }
    };
    const[data, setData]=useState({
      
        response:[]
    })
    const url="http://localhost:8080/QandAResponse"
    const submit = (e) => {

      e.preventDefault();
    
  
      const q ={
        
       responses: data.response
      }
      console.log(q)
      axios.post(url, q)
           .then(res=>{
              console.log(res.data)
            })

    }
    return (
      <div  style={{display: "flex", flexDirection: 'column', justifyContent: 'center', alignItems: 'center', width: '100%', height: '100%'}}><h3 fontFamily= "Helvetica">{questions.questions}</h3>
           <form onSubmit={submit} className={classes.root} noValidate autoComplete="off">
      
{qAndA.map((x, i) => {
 
    return(
        <div style={{display: "flex", flexDirection: 'column', justifyContent: 'center', alignItems: 'center', width: '95%', margin: '2%' }}>
      
          <h5>{x}</h5>
     
            <Slider
              value={value[i]}
              onChange={handleSliderChange(i)}
              aria-labelledby="input-slider"
              valueLabelDisplay="on"
           
            
            />
       
          
</div>
        
           

        );
      })}
    <div style={{display: "flex", flexDirection: 'column', justifyContent: 'center', alignItems: 'center', width: '100%', }}>
        <Button
        style={{ width: "20%",background:"#cc0000", color:"white" }}
        className={classes.button}
        variant="contained"
       // color="primary"
        size="large"
        fullWidth={true}
        onClick={submit}
      >Submit
      </Button></div>
  
       
       
       </form>
      </div>
      
    );
  }
  export default Scales