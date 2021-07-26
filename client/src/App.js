import React,{useState} from 'react'
import './App.css';
import Main from './components/Main/Main';
import Poll from './components/Poll/Poll';
import Header from './components/Header/Header';
import Opinions from './components/Opinions/Opinions';
import Feedback from './components/Feedback/Feedback';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import CreatePoll from './components/Poll/CreatePoll/CreatePoll';
import Vote from './Vote';
import CreatePolls from './components/Poll/CreatePoll/CreatePolls';
import PollType from './components/Poll/CreatePoll/PollType';
import Content from './components/Poll/CreatePoll/Content';
import Background from './components/Poll/CreatePoll/Background';
import axios from 'axios'

function App() {
  
  return (
    <BrowserRouter>
    <div className="App">
      {/* <button onClick={PollsSubmit}>Submit</button>
      <Vote result = {result}/> */}
        <Header />
        <Switch>
          <Route exact path="/" component={Main}/>
          <Route path="/polls" component={Poll}/>
          <Route path="/opinions" component={Opinions}/>
          <Route path="/feedback" component={Feedback}/>
          <Route path="/link" component={CreatePoll}/> 
          <Route
            path="/create-poll"
            render={({ match: { url } }) => (
             <Switch>
                <Route path={`${url}/`} component={CreatePolls} exact />
            { /* <Route path={`${url}/type`} component={PollType} />
                <Route path={`${url}/content`} component={Content} />
            <Route path={`${url}/background`} component={Background} /> */ }
                      </Switch>
            )}
          />
          <Route path="/:id" component={Vote}/>
        </Switch> 
    </div>
    </BrowserRouter>

  );
}

export default App;
