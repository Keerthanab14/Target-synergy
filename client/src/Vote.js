import React, { useState } from "react";
import Poll from "react-polls";
import axios from "axios"

const source = axios.CancelToken.source();
// Declaring poll question and answers
const id=231
const path=`http://localhost:8080/polls/${id}`;
//Vote(path)

const Vote = () => {
  const [mcq , setmcq] = useState({question:'', choices:[]})
  const [isVisible , setVisible] = useState(false)
    axios.get(`${path}`, {
     // cancelToken: source.token
    })//source.cancel();
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
    source.cancel(),
    // const pollAnswers = 
    <div>
     
      <Poll question={pollQuestion} answers={Answers} onVote={handleVote} />
    </div>
  );
};

export default Vote;
