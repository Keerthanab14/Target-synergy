import React, { useState,useEffect } from "react";
import Poll from "react-polls";
import axios from "axios"

const source = axios.CancelToken.source();
// Declaring poll question and answers
 const id=231
const Vote = () => {
  const [mcq , setmcq] = useState({question:'', choices:[]})
 
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/polls/${id}`)
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
