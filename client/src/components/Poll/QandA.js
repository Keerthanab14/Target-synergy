import Questions from 'react-questions'
function QandA() {
// const finish = () => {
//     /* called when finished */
//   }
  
  const questions = [
    {id: 1, question: "What's your name?"},
    {id: 2, question: "How old are you?"},
  ]
  
  return (
    <Questions questions={questions} animation="blur-fade">
      {(submit, currentQuestion) => (
        <div className="your-custom-component" onClick={submit}>
          <button onClick={submit}>Submit</button>
        </div>
      )}
    </Questions>
  )
      }
      export default QandA