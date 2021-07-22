import React from 'react'
import '../CreatePoll/CreatePolls.css'
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';

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


const Presentation = () => {
    const classes = useStyles();
    
    return (
        <div>
            
            <div className='slide'>
            <div className={classes.root} >
            <Grid container spacing={3} style={{margin: "10px"}} style={{float: 'right'}}>
                    <Grid item xs={6} sm={3}>
                    <Paper className={classes.paper} 
                            style={{
                                border: "1px solid black",
                                width: "770px",
                                height: "400px",
                                marginTop:"40px",
                                marginLeft: "100px",

                    }}>
                    </Paper>
                    </Grid>
                </Grid>
            </div></div>
        </div>
    );
}


export default Presentation
