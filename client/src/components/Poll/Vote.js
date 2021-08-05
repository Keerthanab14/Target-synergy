import React, { useState,useEffect,useContext } from "react";
import Poll from "react-polls";
import axios from "axios";
import { IdContext } from '../../IdContext';

// Declaring poll question and answers
 
const Vote = () => {
  const [mcq , setmcq] = useState({question:'', choices:[]})
  const id = useContext(IdContext);
  const url = id.id;
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/polls/${url}`)
      setmcq({
        question: result.data.question,
        choices: result.data.choices 
      })
    },[])
    const choice=[];
    mcq.choices.map((post,key) => (
    choice[key]=({option:(post.text), votes:0})
));
console.log(choice);
console.log(id.id);
let Answers = [...choice];
console.log(Answers);
  const pollQuestion = mcq.question;
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
    <div>
      <Poll question={pollQuestion} answers={Answers} onVote={handleVote} />
    </div>
  );
};

export default Vote;
