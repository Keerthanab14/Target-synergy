import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import { Grid } from '@material-ui/core'
import Paper from '@material-ui/core/Paper';
import EqualizerIcon from '@material-ui/icons/Equalizer';
import PhotoLibraryIcon from '@material-ui/icons/PhotoLibrary';
const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
    },
    paper: {
      margin: '2px',
      padding: theme.spacing(1),
      textAlign: 'center',
      color: theme.palette.text.secondary,
    },
    icon: {
     height: '63%',
     display: 'block',
    
    },
  }));
const PollType = () => {
    const classes = useStyles();

    function FormRow() {
      return (
        
        <React.Fragment>
    <Grid item xs={5} alignItems="center">
            <Paper variant="outlined" className={classes.paper} ><EqualizerIcon className={classes.icon} />Multiple Choice</Paper>
          </Grid>
          <Grid item xs={5}>
            <Paper variant="outlined" className={classes.paper}><PhotoLibraryIcon  className={classes.icon}/>Image Choice</Paper>
          </Grid>
            
        </React.Fragment>
      );
    }
    return (
        <div className={classes.root}>
          <Grid container spacing={1} >&nbsp; Questions Type
            <Grid container item xs={12} spacing={3} alignItems="center">
              <FormRow />
            </Grid>
          </Grid>
        </div>
      );
}

export default PollType
