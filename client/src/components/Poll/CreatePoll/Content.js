import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import AddIcon from '@material-ui/icons/Add';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import FormGroup from '@material-ui/core/FormGroup';
import { Typography } from '@material-ui/core';
const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1),
        width: '28ch',
      },
    },
    h:{
      fontSize: '15px',
      marginBottom: '0px',

    },
    typography: {
        // for settings
        fontSize: 12,
      },
    button: {
        margin: theme.spacing(1),
        borderRadius: "2em",
        
      },
    addicon: {
        color: 'solid white',
    },
}));

const Content = () => {
    const [state, setState] = React.useState({
        checkedA: false,
        checkedB: false,
        checkedC: false,
      });
    
      const handleChange = (event) => {
        setState({ ...state, [event.target.name]: event.target.checked });
      };
    
    const classes = useStyles();

    return (
      <div >
          <form className={classes.root} noValidate autoComplete="off"><h4 className={classes.h}>Your Questions</h4>
        <TextField id="outlined-basic" label="Your multiple choice question" variant="outlined" size="small"/>
        <h4 className={classes.h}>Options</h4>
        <TextField id="outlined-basic" label="Option 1" variant="outlined" size="small" />
        <TextField id="outlined-basic" label="Option 2" variant="outlined" size="small"/>
        <TextField id="outlined-basic" label="Option 3" variant="outlined" size="small"/>
        <Button
        style={{ width: "248px" }}
        className={classes.button}
        variant="contained"
        color="primary"
        size="large"
        fullWidth={true}
      >
        <AddIcon className={classes.addicon} />
        &nbsp;Add
      </Button>
        <h4 className={classes.h}>Other Settings</h4>
        <FormGroup row >
         <FormControlLabel
         control={
           <Checkbox
             checked={state.checkedA}
             onChange={handleChange}
             name="checkedA"
             color="primary"
           />
         }
         label={<Typography className={classes.typography} color="textSecondary">Allow picking more than one options</Typography>}
       />
       <FormControlLabel
         control={
           <Checkbox
             checked={state.checkedB}
             onChange={handleChange}
             name="checkedB"
             color="primary"
           />
         }
         label={<Typography className={classes.typography} color="textSecondary">This question has correct answer(s)</Typography>}
       />
       <FormControlLabel
         control={
           <Checkbox
             checked={state.checkedC}
             onChange={handleChange}
             name="checkedC"
             color="primary"
           />
         }
         label={<Typography className={classes.typography} color="textSecondary">Hide Results</Typography>}
       />
       </FormGroup>
       </form>
      </div>
      
    );
}



export default Content
