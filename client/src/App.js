import React from 'react'
import './App.css';
import Main from './components/Main/Main';
import MainCards from './components/MainCards/MainCards';
import Bootstrap from 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
       <h1>Target Synergy</h1>
      
     
      <Main/>
      
      <MainCards/>
      
   
    </div>
    
  );
}

export default App;
