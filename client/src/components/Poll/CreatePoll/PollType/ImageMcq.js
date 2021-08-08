import React, { useState,useEffect,useContext } from "react";
import Poll from "react-polls";
import axios from "axios";
import { IdContext } from '../../../../IdContext';

// Declaring poll question and answers
 
const ImageMcq = () => {
  const [textBased , setTextBased] = useState({question:'', choices:[]})
  const id = useContext(IdContext);
  const url = id.id;
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/mcq/610fbf5066e210524c8325a5`)
      console.log(result)
      setTextBased({
        question: result.data.question,
        choices: result.data.choices 
      })
    },[])
    const choice=[];
    textBased.choices.map((post,key) => (
        console.log(post.text),
        axios.get(`http://localhost:8080/file/download/${post.text}`),
       
          // <img src={'http://localhost:8080/file/download/${post.text}'}/>
            choice[key]=({option:(`http://localhost:8080/file/download/${post.text}`), votes:0})
        )
    
);
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
    <div>
      <Poll question={pollQuestion} answers={Answers} onVote={handleVote} />
    </div>
  );
};

export default ImageMcq;
