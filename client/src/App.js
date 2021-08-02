import React,{useState} from 'react'
import './App.css';
import Main from './components/Main/Main';
import Poll from './components/Poll/Poll';
import Header from './components/Header/Header';
import Opinions from './components/Opinions/Opinions';
import Feedback from './components/Feedback/Feedback';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import CreatePoll from './components/Poll/CreatePoll/CreatePoll';
import CreatePolls from './components/Poll/CreatePoll/CreatePolls';
import Vote from './Vote';
import QandA from './components/Poll/CreatePoll/PollType/QandA';
import Scales from './components/Poll/CreatePoll/PollType/Scales'
import WordCloud from './components/Poll/CreatePoll/PollType/WordCloud'
import DesktopBreakpoint from './components/responsive_utilities/desktop_breakpoint';
import PhoneBreakpoint from './components/responsive_utilities/phone_breakpoint';

import axios from 'axios'
function App() {
  const[id, setId]=useState("")
  return (
    <div>
    <DesktopBreakpoint>
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
          <Route path="/link" component={CreatePoll} id={id}/> 
          <Route
            path="/create-poll"
            render={({ match: { url } }) => (
             <Switch>
                <Route path={`${url}/`} component={CreatePolls} setId={setId}exact />
            { /* <Route path={`${url}/type`} component={PollType} />
                <Route path={`${url}/content`} component={Content} />
            <Route path={`${url}/background`} component={Background} /> */ }
                      </Switch>
            )}
          />
         {/* // <Route path="/231" component={Vote}/> */}
         <Route path="/231" component={Vote}/>
         <Route path="/27" component={QandA}/>
         <Route path="/66" component={WordCloud}/>
         <Route path="/36" component={Scales}/>
        </Switch> 
    </div>
    </BrowserRouter>
    </DesktopBreakpoint>
    <PhoneBreakpoint>
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
          <Route path="/231" component={Vote}/>
        </Switch> 
    </div>
    </BrowserRouter>
    </PhoneBreakpoint>
    </div>
  );
}

export default App;
