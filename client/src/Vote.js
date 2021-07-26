import React, { useState } from "react";
import Poll from "react-polls";

// Declaring poll question and answers
const pollQuestion = "Is react useful?";
const pollAnswers = [
  { option: "Yes", votes: 3 },
  { option: "No", votes: 5 }
];

const Polls = (result) => {
  var [Answers, setAnswers] = useState([...pollAnswers]);
  
  const handleVote = (voteAnswer) => {
    const newAnswers = Answers.map((answer) => {
      if (answer.option === voteAnswer) answer.votes++;
      return answer;
    });
    setAnswers({
      pollAnswers: newAnswers
    });
  };

  //
  return (
    <div>
      <Poll question={pollQuestion} answers={pollAnswers} onVote={handleVote} />
    </div>
  );
};

export default Polls;
