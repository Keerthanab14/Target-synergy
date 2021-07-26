import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import { Grid } from '@material-ui/core'
import EqualizerIcon from '@material-ui/icons/Equalizer';
import PhotoLibraryIcon from '@material-ui/icons/PhotoLibrary';
import AssignmentRoundedIcon from '@material-ui/icons/AssignmentRounded';
import CloudIcon from '@material-ui/icons/Cloud';
import TuneIcon from '@material-ui/icons/Tune';
import QuestionAnswerIcon from '@material-ui/icons/QuestionAnswer';
import ToggleButton from '@material-ui/lab/ToggleButton';
import ToggleButtonGroup from '@material-ui/lab/ToggleButtonGroup';

import CreatePolls from './CreatePolls';

const useStyles = makeStyles((theme) => ({
    
    root: {
      flexGrow: 1,
    },
    togglebtn: {
      width: '130px',
      margin: '1px' ,
      marginRight: '5px',
      height: '120px',
      padding: theme.spacing(2),
      color: theme.palette.text.secondary,
      
    },
    icon: {
    
     display: 'block',
     
     
     
    
  },
  }));
const PollType = (props) => {
    const classes = useStyles();
    const [alignment, setAlignment] = React.useState('mc');
    const {toggleVisibility}=props;
    const handleAlignment = (event, newAlignment) => {
      setAlignment(newAlignment);
    };
    function FormRow(props) {
      
      
    
      return (
        
        <ToggleButtonGroup
      value={alignment}
      exclusive
      onChange={handleAlignment}
      aria-label="text alignment"
      style={{marginBottom: '20px'}}
    >
          
            <ToggleButton  value="mc" aria-label="multiplechoice" className={classes.togglebtn} onClick={toggleVisibility}
          >
            <EqualizerIcon fontSize="large" className={classes.icon} /><h5>Multiple Choice</h5>
            </ToggleButton>
         
          <ToggleButton value="ic" aria-label="imagechoice" className={classes.togglebtn}>
            <PhotoLibraryIcon fontSize="large" className={classes.icon}/><h5>Image Choice</h5>
            </ToggleButton>
            
            </ToggleButtonGroup>
      );
    }

    
    function FormRow1() {
      return (
        
        <ToggleButtonGroup
        style={{marginBottom: '20px'}}
      value={alignment}
      exclusive
      onChange={handleAlignment}
      aria-label="text alignment"
    >
          
            <ToggleButton value="oe" aria-label="open ended" className={classes.togglebtn}>
            <AssignmentRoundedIcon fontSize="large" className={classes.icon} /><h5>Open Ended</h5>
            </ToggleButton>
  
         
            <ToggleButton value="wc" aria-label="word cloud" className={classes.togglebtn}>
           <CloudIcon fontSize="large" className={classes.icon}/><h5>Word Cloud</h5>
            </ToggleButton>
          
          </ToggleButtonGroup>
            );
    }

    function FormRow2() {
      return (
         
        <ToggleButtonGroup
        style={{marginBottom: '20px'}}
      value={alignment}
      exclusive
      onChange={handleAlignment}
      aria-label="text alignment"
    >
          
            <ToggleButton value="sc" aria-label="scales" className={classes.togglebtn}>
       
            <TuneIcon fontSize="large" className={classes.icon} /><h5>Scales</h5>
           </ToggleButton>
         
          
           <ToggleButton value="qa" aria-label="Q and A" className={classes.togglebtn}>
           <QuestionAnswerIcon fontSize="large" className={classes.icon}/><h5>Q and A</h5>
           </ToggleButton>
            
            </ToggleButtonGroup>
      );
    }
    return (
        <div className={classes.root}>
          <Grid container spacing={1}  ><h4>Questions Type</h4> 
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
