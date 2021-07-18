import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import "../Poll/Poll.css";
import { Link } from 'react-router-dom';

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

const Poll = () => {
    const classes = useStyles();
    return (
        <div className="polls">
            <div className={classes.root}>
                <h1>Service - Polls</h1>
                <Grid container spacing={3} style={{margin: "10px"}}>
                    <Grid item xs={6} sm={3}>
                    <Paper className={classes.paper} 
                            style={{
                                border: "1px solid black",
                                width: "250px",
                                height: "150px"
                    }}>
                        <Link to='/create-poll'><AddCircleIcon style={{fontSize:"3rem" , margin:"50px"}}/></Link>
                    </Paper>
                    </Grid>
                </Grid>
            </div>
        </div>
        
    )
}

export default Poll
