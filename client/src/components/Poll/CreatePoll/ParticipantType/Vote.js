import React, { useState,useEffect,useContext } from "react";
import { makeStyles } from '@material-ui/core/styles';
import Poll from "react-polls";
import axios from "axios";
import Button from '@material-ui/core/Button';
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
  const url =props.match.params.id;
  const [textBased , setTextBased] = useState({question:'', choices:[]})
  // const id = useContext(IdContext);
  // const url = id.id;
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
    choice[key]=({option:(post.text), votes:0})
));
// console.log(choice);
// console.log(id.id);
let Answers = [...choice];
console.log(Answers);
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
 
  return (
    <div >
      <h1>Poll Name</h1>
      <Poll question={pollQuestion} answers={Answers} onVote={handleVote} />
      <div style={{display: 'flex',flexDirection: 'column', width: '100%', justifyContent: 'space-evenly',alignItems: "center"}}>
     <Button
        style={{ width: "20%",background:"#cc0000", color:"white" }}
        className={classes.button}
        variant="contained"
       // color="primary"
        size="large"
        fullWidth={true}
      >Submit
      </Button>
      <Button
        style={{ width: "20%",background:"#cc0000", color:"white"}}
        className={classes.button}
        variant="contained"
       // color="primary"
        size="large"
       >View Result
      </Button></div>
    </div>
  );
};

export default Vote;
