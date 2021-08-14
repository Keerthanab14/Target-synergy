import React,{useState,useEffect,useContext} from 'react';
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
import { IdContext } from '../../../../IdContext';

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

const QandA = () => {
   
const id = useContext(IdContext);
const url = id.id;
  const [questions , setQuestions] = useState({questions:[]});
 
    useEffect(async () => {
      var result = await axios.get(`http://localhost:8080/QandA/36`)
      setQuestions({
       
        questions: result.data.questions 
      })
    },[])
    const qAndA=["a","b","c"];
//     questions.questions.map((post,key) => (
//     qAndA[key]=post.text
// ));
console.log(qAndA);

     const [state, setState] = React.useState({
         checkedA: false,
         checkedB: false,
         checkedC: false,
      });
    
      const [inputList, setInputList] = useState([{ response: "" }]);
      
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
    
    const[data, setData]=useState({
      
        response:[]
    })
    const urlS="http://localhost:8080/QandAResponse"
    const submit = (e) => {

      e.preventDefault();
      inputList.map((resp,key)=>{
        data.response[key]=resp.response
      })
  
      const q ={
        
       responses: data.response
      }
      console.log(q)
      axios.post(urlS, q)
           .then(res=>{
              console.log(res.data)
            })

    }



    return (
      <div >
        <h1 fontFamily= "Helvetica" justifyContent="Left" >What would you like to ask?</h1>
          <form onSubmit={submit} className={classes.root} noValidate autoComplete="off">
     
      
        <Grid container={true}  direction="row"  alignItems="center" 
>
{qAndA.map((x, i) => {
        return (
          <div >
            <h4 className={classes.h}>{qAndA[i]}</h4>
            <TextField
            id="outlined-basic"
            variant="outlined" size="small"
            id="outlined-basic"
            style={{width: '96%'}}
              className="ml10"
              name="question"
              placeholder="Enter your answer"
              value={inputList.response}
              onChange={e => handleInputChange(e,i)}
            ></TextField>
            
          </div>
        );
      })}
    
      </Grid>  
       
       </form>
      </div>
      
    );
}




export default QandA