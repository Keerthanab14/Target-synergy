import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import { ButtonBase, ButtonGroup, Grid } from '@material-ui/core'
import EqualizerIcon from '@material-ui/icons/Equalizer';
import PhotoLibraryIcon from '@material-ui/icons/PhotoLibrary';
import AssignmentRoundedIcon from '@material-ui/icons/AssignmentRounded';
import CloudIcon from '@material-ui/icons/Cloud';
import TuneIcon from '@material-ui/icons/Tune';
import QuestionAnswerIcon from '@material-ui/icons/QuestionAnswer';
import ToggleButton from '@material-ui/lab/ToggleButton';
import ToggleButtonGroup from '@material-ui/lab/ToggleButtonGroup';
import { Button } from '@material-ui/core';



const useStyles = makeStyles((theme) => ({
    
    root: {
      flexGrow: 1,
    },
    togglebtn: {
      width: '110px',
      margin: '1px' ,
      marginRight: '5px',
      height: '100px',
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
   
    const handleAlignment = (event, newAlignment) => {
      setAlignment(newAlignment);
    };

 const {clickHandler}=props;

        

    function FormRow(props) {
      
      
    
      return (
        
        <ButtonGroup
        
      value={alignment}
      exclusive
      onChange={handleAlignment}
      aria-label="text alignment"
      style={{marginBottom: '20px'}}
    >
          
            <Button   value="mc" aria-label="multiplechoice" className={classes.togglebtn} onClick={clickHandler("multiplechoice")}
          >
            <EqualizerIcon fontSize="large" className={classes.icon} /><h5>Multiple Choice</h5>
            </Button>
         
          <Button value="ic" aria-label="imagechoice" className={classes.togglebtn} onCLick={clickHandler("imagechoice")}>
            <PhotoLibraryIcon fontSize="large" className={classes.icon}/><h5>Image Choice</h5>
            </Button>
            
            </ButtonGroup>
      );
    }

    
    function FormRow1() {
      return (
        
        <ButtonGroup
        style={{marginBottom: '20px'}}
      value={alignment}
      exclusive
      onChange={handleAlignment}
      aria-label="text alignment"
    >
          
            <Button value="oe" aria-label="open ended" className={classes.togglebtn}>
            <AssignmentRoundedIcon fontSize="large" className={classes.icon} /><h5>Open Ended</h5>
            </Button>
  
         
            <Button value="wc" aria-label="word cloud" className={classes.togglebtn} onCLick={() => clickHandler("wordcloud")}  >
           <CloudIcon fontSize="large" className={classes.icon}/><h5>Word Cloud</h5>
            </Button>
          
          </ButtonGroup>
            );
    }

    function FormRow2() {
      return (
         
        <ButtonGroup
        style={{marginBottom: '20px'}}
      value={alignment}
      exclusive
      onChange={handleAlignment}
      aria-label="text alignment"
    >
          
            <Button value="sc" aria-label="scales" className={classes.togglebtn}>
       
            <TuneIcon fontSize="large" className={classes.icon} /><h5>Scales</h5>
           </Button>
         
          
           <Button value="qa" aria-label="Q and A" className={classes.togglebtn}>
           <QuestionAnswerIcon fontSize="large" className={classes.icon}/><h5>Q and A</h5>
           </Button>
            
            </ButtonGroup>
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
