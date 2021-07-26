import React, { useState } from "react";
import Poll from "react-polls";
import axios from "axios"

// Declaring poll question and answers


const Polls = () => {
  const [mcq , setmcq] = useState({question:'', choices:[]})
  const [isVisible , setVisible] = useState(false)
    axios.get(`http://localhost:8080/polls/231`)
        .then((res) => {
          console.log(res.data.choices[0].text)
          setmcq({
            question: res.data.question,
            choices: res.data.choices,  
        })
      })

  const pollQuestion = mcq.question;
  console.log(mcq)
  let choice = mcq.choices[0];
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
    // const pollAnswers = 
    <div>
      <Poll question={pollQuestion} answers={Answers} onVote={handleVote} />
    </div>
  );
};

export default Polls;
