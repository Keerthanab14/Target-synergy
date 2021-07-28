import React, { useState,useEffect } from "react";
import Poll from "react-polls";
import axios from "axios"

const source = axios.CancelToken.source();
// Declaring poll question and answers
// const id=231
// const path=`http://localhost:8080/polls/${id}`;


const Vote = () => {
  const [mcq , setmcq] = useState({})
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/polls/231`)
      setmcq(result.data)
      
    },[])
  const pollQuestion = "jj";
  console.log(typeof mcq.choices[0]);
  // let choice = JSON.parse( mcq.choices[0]);
  //  console.log(choice.text);
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
