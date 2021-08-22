import React, { useState,useEffect,useContext } from "react";
import { makeStyles } from '@material-ui/core/styles';
import Poll from "react-polls";
import axios from "axios";
import Button from '@material-ui/core/Button';
import { useHistory } from 'react-router-dom';
import { IdContext } from '../../../../App';
const useStyles = makeStyles((theme) => ({
  root: {
      flex: 1,
    '& > *': {
      margin: theme.spacing(1),
      width: '100%',
    
    },
  },
  button: {
    margin: theme.spacing(1),
    borderRadius: "2em",
    
  },
}));
const Vote = (props) => {
  const classes=useStyles();
  const history = useHistory();
  const url =props.match.params.id;
  const [textBased , setTextBased] = useState({question:'', choices:[]})
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/MCQ/${url}`)
      
      setTextBased({
        question: result.data.question,
        choices: result.data.choices,
        count: result.data.count,
      })
    },[]);
    const choice=[];
    textBased.choices.map((post,key) => (
    choice[key]=({option:(post.option), votes:post.votes})
));

let Answers = [...choice];
// console.log(Answers);
  const pollQuestion = textBased.question;
  const handleVote = (voteAnswer) => {
    const newAnswers = Answers.map((answer) => {


      
      if (answer.option === voteAnswer) {
          answer.votes++;
      }
      console.log(answer);
      return answer;
      
    });
    Answers= newAnswers;
    
  };
  const uri = `/MCQ/${url}/results`
  function handleResult(path) {
    history.push(path);
}
  const handleClick = () =>{
    const q ={
      question: pollQuestion,
      choices:Answers
    }
    console.log(q)
    axios.put(`http://localhost:8080/MCQ/${url}`, q)
           .then(res=>{
              console.log(res)
            })
  }
 
  return (
    <div >
      <h1>Poll Name</h1>
      <Poll question={pollQuestion} answers={Answers} onVote={handleVote} />
      <div style={{display: 'flex',flexDirection: 'column', width: '100%', justifyContent: 'space-evenly',alignItems: "center"}}>
     <Button
        style={{ width: "20%",background:"#cc0000", color:"white" }}
        className={classes.button}
        variant="contained"
        onClick = {()=>handleClick()}
        size="large"
        fullWidth={true}
      >Submit
      </Button>
      <Button
        style={{ width: "20%",background:"#cc0000", color:"white"}}
        className={classes.button}
        variant="contained"
        onClick={() => {handleResult(`${uri}`)}}
        size="large"
       >View Result
      </Button></div>
    </div>
  );
};

export default Vote;
