import React,{useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import AddCircleIcon from '@material-ui/icons/AddCircle';
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

const ContentOpenEnded = () => {
     const [state, setState] = React.useState({
         checkedA: false,
         checkedB: false,
         checkedC: false,
      });
    
     const [inputList, setInputList] = useState([{ question: "" }]);

  // handle input change
  const handleInputChange = (e, index) => {
    const { name, value } = e.target;
    const list = [...inputList];
    list[index][name] = value;
    setInputList(list);
  };
 
  
      const handleChange = (event) => {
        setState({ ...state, [event.target.name]: event.target.checked });
      };
    
    const classes = useStyles();
    const url="http://localhost:8080/OpenEnded"
    const[data, setData]=useState({
      
        question:[]
    })
   
    const submit = (e) => {

      e.preventDefault();
      inputList.map((questione,key)=>{
        data.question[key]=questione.question
      })
  
      const q ={
        
       questions: data.question
      }
      console.log(q)
      axios.post(url, q)
           .then(res=>{
              console.log(res.data)
            })

    }



    return (
      <div >
          <form onSubmit={submit} className={classes.root} noValidate autoComplete="off">
      
     
        <h4 className={classes.h}>Please enter the question</h4>
        <Grid container={true}  direction="row"  alignItems="center" 
>
{inputList.map((x, i) => {
        return (
          <div >
          
            <TextField
            id="outlined-basic"
            variant="outlined" size="small"
            id="outlined-basic"
            style={{width: '96%'}}
              className="ml10"
              name="question"
   placeholder="Enter question"
              value={x.question}
              onChange={e => handleInputChange(e, i)}
            />
            
          </div>
        );
      })}
    
      </Grid>  <Button
        style={{ width: "248px",background:"#cc0000", color:"white" }}
        className={classes.button}
        variant="contained"
       // color="primary"
        size="large"
        fullWidth={true}
        onClick={submit}
      >Submit
      </Button>
  
        <h4 className={classes.h}>Other Settings</h4>
        <FormGroup row >
        
       </FormGroup>
       
       </form>
      </div>
      
    );
}



export default ContentOpenEnded