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
import { ImageRounded } from '@material-ui/icons';

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

const ContentImageChoice = () => {
      const [state, setState] = React.useState({
        checkedA: false,
         checkedB: false,
       checkedC: false,
       selectedFile: null
     });
   
      // On file select (from the pop up)
     const onFileChange = (event) => {
      
        // Update the state
        setState({ selectedFile: event.target.files[0] });
      
      };
      
      // On file upload (click the upload button)
      const onFileUpload = () => {
      
        // Create an object of formData
        const formData = new FormData();
      
        // Update the formData object
        formData.append(
          "myFile",
          state.selectedFile,
          state.selectedFile.name
        );
      
        // Details of the uploaded file
        console.log(state.selectedFile);
      
        // Request made to the backend api
        // Send formData object
        axios.post("localhost:8080/", formData);
      };
      
      // File content to be displayed after
      // file upload is complete
      const fileData = () => {
      
      };
      const [inputList, setInputList] = useState([{ choice: "" }]);

  // handle input change
  const handleInputChange = (e, index) => {
    const { name, value } = e.target;
    const list = [...inputList];
    list[index][name] = value;
    setInputList(list);
  };
 
  // handle click event of the Remove button
  const handleRemoveClick = index => {
    const list = [...inputList];
    list.splice(index, 1);
    setInputList(list);
  };
 
  // handle click event of the Add button
  const handleAddClick = () => {
    setInputList([...inputList, { choice: "" }]);
  };
      const handleChange = (event) => {
        setState({ ...state, [event.target.name]: event.target.checked });
      };
    
    const classes = useStyles();
    const url="http://localhost:8080/polls"
    const[data, setData]=useState({
        question: "",
        choice:[]
    })
    const[id, setId]=useState("")
    const submit = (e) => {

      e.preventDefault();
      inputList.map((choicee,key)=>{
        data.choice[key]=choicee.choice
      })
  
      const q ={
        question: data.question,
       choices: data.choice
      }
      console.log(q)
      axios.post(url, q)
           .then(res=>{
              console.log(res)
              setId(res.data);
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
          <form onSubmit={submit} className={classes.root} noValidate autoComplete="off"><h4 className={classes.h}>Your Question</h4>
      
     
        <TextField id="outlined-basic" label="Your question" variant="outlined" size="small" onChange={(e)=>handle(e)} id="question" value={data.question} type="text" style={{width: '100%'}}/>
        <h4 className={classes.h}>Options</h4>
        <Grid container={true}  direction="row"  alignItems="center" 
>
{inputList.map((x, i) => {
        return (
          <div >
              
          {fileData()}
          <Button>
        
      </Button>
          <Button variant ="contained" style={{ width: "230px",background:"#cc0000", color:'white'}}
        className={classes.button}
        
       // color="primary"
        size="large"
        fullWidth={true}
        
              name="choice"
        placeholder="Enter choice"
              value={x.choice}
              onChange={e => handleInputChange(e, i)}  ><input type="file" onChange={onFileChange} />
              </Button>
              <div>
                
                <Button className={classes.button}
         style={{borderRadius: "2em",
                                         backgroundColor: '#1e69d4',  
                                         color: 'white',
                                         size: 'small',
                                         fontSize: '11px',
                                         maxWidth: '50x',
                                         minWidth: '50px',
                                         textAlign: 'center',
                                         width: '40%', background:"#cc0000",
                                         color:'white'}}
                                         onClick={onFileUpload}>
                  Upload!
                </Button>
            </div>
           
            <div>
              {inputList.length !== 1 && <DeleteIcon style={{background:"#C0C0C0", color:"white", marginRight:"3px"}}
                className="mr10"
                onClick={() => handleRemoveClick(i)}/>}
              {inputList.length - 1 === i && <AddIcon style={{background:"#C0C0C0", color:"white"}} onClick={handleAddClick} className={classes.addicon} />}
            </div>
          </div>
        );
      })}
    
      </Grid>  <Button
        style={{ width: "235px",background:"#cc0000", color:"white" }}
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
        <FormControlLabel
         control={
           <Checkbox
             checked={state.checkedA}
             onChange={handleChange}
             name="checkedA"
             color="primary"
           />
         }
         label={<Typography className={classes.typography} color="textSecondary">Allow selectind more than one options</Typography>}
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



export default ContentImageChoice