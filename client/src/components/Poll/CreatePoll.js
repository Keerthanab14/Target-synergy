import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import InputBase from '@material-ui/core/InputBase';
import Button from '@material-ui/core/Button';
import '../Poll/CreatePoll.css'

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
    return (
        <div className='bx'>
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
                            <InputBase
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
                                onClick={() => {/*link to respective poll.js*/ }}
                                style={
                                    {
                                        backgroundColor: "#cc0000",
                                        color: "white",
                                        position: "relative",
                                        border: "1px solid white",
                                        margin: "3px",
                                        
                                    }
                                }
                            >Create Poll
                        </Button>
                        <Button
                                variant="contained"
                                onClick={() => {/*link to respective poll.js*/ }}
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
            </div>
        </div>
    )
}

export default CreatePoll
