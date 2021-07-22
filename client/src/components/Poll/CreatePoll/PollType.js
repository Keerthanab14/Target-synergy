import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import { Grid } from '@material-ui/core'
import Paper from '@material-ui/core/Paper';
import EqualizerIcon from '@material-ui/icons/Equalizer';
import PhotoLibraryIcon from '@material-ui/icons/PhotoLibrary';
import AssignmentRoundedIcon from '@material-ui/icons/AssignmentRounded';
import CloudIcon from '@material-ui/icons/Cloud';
import TuneIcon from '@material-ui/icons/Tune';
import QuestionAnswerIcon from '@material-ui/icons/QuestionAnswer';
const section = {
  height: "100%",
};
const useStyles = makeStyles((theme) => ({
    h5: {
     marginTop: '5px',
     textAlign: 'center',
    },
    root: {
      flexGrow: 1,
    },
    paper: {
      margin: '1px',
      height: '70px',
      padding: theme.spacing(1),
      color: theme.palette.text.secondary,
    },
    icon: {
    marginLeft: '35px',
     height: '70%',
     display: 'block',
    
  },
  }));
const PollType = () => {
    const classes = useStyles();

    function FormRow() {
      return (
        
        <React.Fragment>
          <Grid item xs={6} >
            <Paper variant="outlined" className={classes.paper} ><EqualizerIcon fontSize="large" className={classes.icon} /><h5 className={classes.h5}>Multiple Choice</h5></Paper>
          </Grid>
          <Grid item xs={6}>
            <Paper variant="outlined" className={classes.paper}><PhotoLibraryIcon fontSize="large" className={classes.icon}/><h5 className={classes.h5}>Image Choice</h5></Paper>
          </Grid>
            
        </React.Fragment>
      );
    }
    
    function FormRow1() {
      return (
        
        <React.Fragment>
        <Grid item xs={6} alignItems="center">
            <Paper variant="outlined" className={classes.paper} ><AssignmentRoundedIcon fontSize="large" className={classes.icon} /><h5 className={classes.h5}>Open Ended</h5></Paper>
          </Grid>
          <Grid item xs={6}>
            <Paper variant="outlined" className={classes.paper}><CloudIcon fontSize="large" className={classes.icon}/><h5 className={classes.h5}>Word Cloud</h5></Paper>
          </Grid>
            
        </React.Fragment>
      );
    }
    function FormRow2() {
      return (
        
        <React.Fragment>
        <Grid item xs={6} >
    
            <Paper variant="outlined" className={classes.paper} ><TuneIcon fontSize="large" className={classes.icon} /><h5 className={classes.h5}>Scales</h5></Paper>
          </Grid>
          <Grid item xs={6}>
            <Paper variant="outlined" className={classes.paper}><QuestionAnswerIcon fontSize="large" className={classes.icon}/><h5 className={classes.h5}>QandA</h5></Paper>
          </Grid>
            
        </React.Fragment>
      );
    }
    return (
        <div className={classes.root}>
          <Grid container spacing={1} style={{marginTop: '120px', marginLeft:"50px"}} >&nbsp; Questions Type
            <Grid container item xs={12} spacing={3} alignItems="center">
              <FormRow />
            </Grid>
            <Grid container item xs={12} spacing={3} alignItems="center">
              <FormRow1 />
            
            </Grid>
            <Grid container item xs={12} spacing={3} alignItems="center">
              <FormRow2 />
            </Grid>
          </Grid>
        </div>
      );
}

export default PollType
