import React,{useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import AddCircleIcon from '@material-ui/icons/AddCircle';
import AddIcon from '@material-ui/icons/Add';
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

const OpenEndedUser = () => {
  const [OpenEnded,setOpenEnded]=useState({question:""})
     const [state, setState] = React.useState({
         checkedA: false,
         checkedB: false,
         checkedC: false,
      });
    
     const [inputList, setInputList] = useState([{ question: "" }]);

  // // handle input change
  // const handleInputChange = (e, index) => {
    
  //   const { name, value } = e.target;
  //   const list = [...inputList];
  //   list[index][name] = value;
  //   setInputList(list);
    
  // };
  // const handle =(e) => {
  //   const newdata={...data3}
  //   newdata[e.target.id]=e.target.value
  //   setData3(newdata)
  // }
 
  
  //     const handleChange = (event) => {
  //       setState({ ...state, [event.target.name]: event.target.checked });
  //     };
    
    const classes = useStyles();
    const url="http://localhost:8080/OpenEnded"
    
   
    const submit = (e) => {

      e.preventDefault();
      
  
      axios.post(url, OpenEnded)
           .then(res=>{
              console.log(res.data)
            })

    }
    
    function handle(e){
      const newdata={...OpenEnded}
      newdata[e.target.id]=e.target.value
      setOpenEnded(newdata)
      console.log(newdata)

    }


    return (
      <div >
           <form onSubmit={submit} className={classes.root} noValidate autoComplete="off"><h4 className={classes.h}>Your Question</h4>
      
     
      <TextField id="outlined-basic" label="Your multiple choice question" variant="outlined" size="small" onChange={(e)=>handle(e)} id="question" value={OpenEnded.question} type="text" style={{width: '100%'}} />
    
      
     <Button
        style={{ width: "235px",background:"#cc0000", color:"white" }}
        className={classes.button}
        variant="contained"
       // color="primary"
        size="large"
        fullWidth={true}
        onClick={submit}
      >Submit
      </Button>
  
       </form>
      </div>
      
    );
}



export default OpenEndedUser