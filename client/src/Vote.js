import React, { useState,useEffect } from "react";
import Poll from "react-polls";
import axios from "axios"

const source = axios.CancelToken.source();
// Declaring poll question and answers
// const id=231
// const path=`http://localhost:8080/polls/${id}`;


const Vote = () => {
  const [mcq , setmcq] = useState({question:'', choices:[]})
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/polls/231`)
      setmcq({
        question: result.data.question,
        choices: result.data.choices
      })
      
    },[])
  const pollQuestion = mcq.question;
  
  // let choice = mcq.choices[0];
  //  console.log(choice);
  const pollAnswers = [
    { option: "31" , votes: 1 },
    { option: "24", votes: 1}
  ];
  const [Answers, setAnswers] = useState([...pollAnswers]);
  
  const handleVote = (voteAnswer) => {
    const newAnswers = Answers.map((answer) => {
      if (answer.option === voteAnswer) {
          answer.votes++;
      }
      return answer;
    });
    setAnswers(newAnswers);
  };

  //
  return (
    <div>
      <Poll question={pollQuestion} answers={Answers} onVote={handleVote} />
    </div>
  );
};

export default Vote;
