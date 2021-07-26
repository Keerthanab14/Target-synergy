import React,{useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import AddIcon from '@material-ui/icons/Add';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import FormGroup from '@material-ui/core/FormGroup';
import { Typography } from '@material-ui/core';
import DeleteIcon from '@material-ui/icons/Delete';
import { Grid } from '@material-ui/core';
import IconButton from '@material-ui/core/IconButton';
import axios from 'axios'

const useStyles = makeStyles((theme) => ({
    root: {
        flex: 1,
      '& > *': {
        margin: theme.spacing(1),
        width: '100%',
      
      },
    },
    h:{
      fontSize: '15px',
      marginBottom: '0',

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
    const url="http://localhost:8080/newPolls"
    const[data, setData]=useState({
        question: "",
        choices0: "",
        choices1:""
    })

    function submit(e){
      e.preventDefault();
      axios.post(url,{
        question: data.question,
        choices0: data.choices0,
        choices1: data.choices1
      })
      .then(res=>{
        console.log(res.data)
      })

    }

    function handle(e){
      const newdata={...data}
      newdata[e.target.id]=e.target.value
      setData(newdata)
      console.log(newdata)

    }

    return (
      <div >
          <form onSubmit={(e)=>submit(e)} className={classes.root} noValidate autoComplete="off"><h4 className={classes.h}>Your Questions</h4>
      
     
        <TextField id="outlined-basic" label="Your multiple choice question" variant="outlined" size="small" onChange={(e)=>handle(e)} id="question" value={data.question} type="text" style={{width: '94%'}}/>
        <h4 className={classes.h}>Options</h4>
        <Grid container={true}  direction="row"  alignItems="center" 
>

        <TextField id="outlined-basic" label="Option 1" variant="outlined" size="small" onChange={(e)=>handle(e)} id="choice0" value={data.choices0} type="text" style={{width: '94%'}} />
        <DeleteIcon/>
      </Grid>
    
        <TextField id="outlined-basic" label="Option 2" variant="outlined" size="small" onChange={(e)=>handle(e)} id="choice1" value={data.choices1} type="text" style={{width: '94%'}}/><DeleteIcon />
        <TextField  id="outlined-basic" label="Option 3" variant="outlined" size="small" style={{width: '94%'}}/><DeleteIcon />
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
      
      <button>Submit</button>
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
