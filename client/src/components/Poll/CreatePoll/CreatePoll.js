import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import InputBase from '@material-ui/core/InputBase';
import Button from '@material-ui/core/Button';
import '../CreatePoll/CreatePoll.css';
import { CopyToClipboard } from "react-copy-to-clipboard";
import { useState } from "react";
import { useHistory } from 'react-router-dom';
import axios from 'axios'
import Vote from "../../../Vote"

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));

const CreatePoll = () => {
    const classes = useStyles();
    const history = useHistory();
    
    function handleClick(path) {
       history.push(path);
   }

    const [text, setText] = useState("");
    const [isCopied, setIsCopied] = useState(false);

const onCopyText = () => {
    setIsCopied(true);
    setTimeout(() => {
      setIsCopied(false);
    }, 1000);
  };
//   const [mcq , setmcq] = useState({question:'', choices:[]})
  const [isVisible , setVisible] = useState(false)
//   const PollsSubmit = () => {
//     axios.get(`http://localhost:8080/polls/231`)
//         .then((res) => {
//           console.log(res.data.choices[0].text)
//           setmcq({
//             question: res.data.question,
//             choices: res.data.choices,  
//         })
//         setVisible(true)
//         })
//   }

    return (
        <div className='bx'>
            {!isVisible &&
            <div className={classes.root}>
                <Grid item xs={12}>
                <Paper className={classes.paper} style={{border: "1px solid black" , textAlign: 'left', color:"black"}}>
                    <h1>Create New Poll</h1>
                    <h2>Poll Name</h2>
                    <div className={classes.search}>
                        <InputBase
                            placeholder="Enter Poll Name"
                            classes={{
                                root: classes.inputRoot,
                                input: classes.inputInput,
                            }}
                            inputProps={{ 'aria-label': 'Enter code' }}
                            style={
                                {
                                    border: " 1px solid black",
                                    width: "40rem",
                                    padding: "5px",
                                    fontSize: "1.2rem"
                                }
                            }
                        />
                    </div>
                    <div className='accessCode'>
                        <h2>Access Code</h2>
                        <div className={classes.search}>
                            <CopyToClipboard text={text} onCopy={onCopyText} style={{float: 'right'}}>
                                <div className="copy-area">
                                <Button
                    variant="contained"
                    onClick={() => {handleClick("/link") }}
                             style={
                                 {
                                            backgroundColor: "#cc0000",
                                            color: "white",
                                            float: "right",
                                            marginRight: "30px",
                                            border: "1px solid white",
                                            margin: "3px",
                                            
                                        }
                                    }
                                >copy
                            </Button>
                                </div>
                            </CopyToClipboard>

                            <InputBase
                                type="text"
                                value={text}
                                onChange={(event) => setText(event.target.value)}
                                placeholder="https://targetsynergy.com/CODE"
                                classes={{
                                    root: classes.inputRoot,
                                    input: classes.inputInput,
                                }}
                                inputProps={{ 'aria-label': 'Enter code' }}
                                style={
                                    {
                                        border: " 1px solid black",
                                        width: "40rem",
                                        padding: "5px",
                                        fontSize: "1.2rem"
                                    }
                                }
                                />
                            
                            
                        </div>
                    </div>
                    
                    <div className='btnn'>
                            <Button
                                    variant="contained"
                                    onClick={() => {handleClick("/231")}}
                                    style={
                                        {
                                            backgroundColor: "#cc0000",
                                            color: "white",
                                            position: "relative",
                                            border: "1px solid white",
                                            margin: "3px",
                                            
                                        }
                                    }
                                >Done
                            </Button> 
                        
                        <Button
                                variant="contained"
                                onClick={() => {handleClick("/create-poll") }}
                                style={
                                    {
                                        backgroundColor: "#ffffff",
                                        color: "black",
                                        position: "relative",
                                        border: "1px solid black",
                                        margin: "3px",
                                        
                                    }
                                }
                            >Cancel
                        </Button>
                    </div>
                </Paper>
                </Grid>
            </div>}
            {/* {isVisible && <Vote mcq={mcq} />} */}
        </div>
    )
}

export default CreatePoll
