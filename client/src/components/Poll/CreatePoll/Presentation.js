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
  
 

const Presentation = ({color,isVisible,isVisibleComponent}) => {
    const classes = useStyles();
 
    
    
    return (
       
            
            
                    <Paper className={classes.paper} 
                            style={{
                                border: "1px solid black",
                                width: "75%",
                                height: "400px",
                                marginLeft: "26%",
                                backgroundColor: color

                    }}
                    >
                     
                  
                      {isVisibleComponent === '0'? isVisible && (<MultipleChoice />) : null}
                      {isVisibleComponent === '1'? isVisible && (<WordCloud />) : null}
                      
                     
                    
                      
                     
                      
                     
                    </Paper>
                    
    );
}


export default Presentation
