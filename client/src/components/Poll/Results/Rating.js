import React,{useEffect,useState } from 'react'
import axios from "axios";



const Rating =(props) => {
    console.log(props)
  const url =props.match.params.id;
 
 
  const [textBased , setTextBased] = useState({question:'', choices:[]})
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/RT/${url}`)
      setTextBased({
        question: result.data.question,
       choices: result.data.choices
        
      })
      

    },[])
    const choice=[];
    const result=[]
    textBased.choices.map((post,key) => (
    choice[key]=((post.option))
)

);
textBased.choices.map((post,key) => (
    result[key]=((post.votes))
));
console.log(choice)
let Answers = [...choice];
 console.log(Answers);
console.log(textBased.question)
console.log(result)
  return (
    <div>
        <div className='header' >
          <h1 className='title'>{textBased.question}</h1>
          <div className='links'>
          </div>
        </div>
          
{Answers.map((x, i) => {
 
 return(
     <div style={{display: "flex", flexDirection: 'column', justifyContent: 'center', alignItems: 'center', width: '95%', margin: '2%' }}>
   
       <h5>{x}</h5>
  
       <Rating
       name="customized-empty"
       value={result[i]}
      
       precision={0.5}
       
         
       
     />
    
       
</div>
     );
   })}   
        
    </div>
  )
}
export default Rating