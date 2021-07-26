import React from 'react'
import '../CreatePoll/CreatePolls.css'
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import MultipleChoice from "./PollType/MultipleChoice";
import WordCloud from './PollType/WordCloud';
import ImageChoice from './PollType/ImageChoice';

const useStyles = makeStyles((theme) => ({
    
    paper: {
      flexGrow: 2,
      flexShrink: 1,
      padding: theme.spacing(2),
      textAlign: 'center',
      color: theme.palette.text.secondary,
    },
    
  }));
  
 

const Presentation = ({color,isVisible}) => {
    const classes = useStyles();
    
    return (
       
            
            
                    <Paper className={classes.paper} 
                            style={{
                                border: "1px solid black",
                                width: "60%",
                                height: "100%",
                                minWidth: '200px',
                                minHeight: '500px',
                    
                                backgroundColor: color

                    }}
                    >
                     
                      {isVisible && ( <MultipleChoice />)}
                      {!isVisible && (<WordCloud />)}
                     
                    </Paper>

            
    );
}


export default Presentation
