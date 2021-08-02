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
      flexGrow: 1,
      flexShrink: 1,
      padding: theme.spacing(2),
      textAlign: 'center',
      color: theme.palette.text.secondary,
      //backgroundImage: `url(${img})`
    },
    
  }));

const Presentation = ({color, component, opacity, img}) => {
    const classes = useStyles();

    return (
       
                    <Paper className={classes.paper} 
                            style={{
                                border: "1px solid black",
                                width: "75%",
                                maxHeight: "800px",
                                minHeight: '400px',
                                marginLeft: "26%",
                                backgroundColor: color,
                                opacity: opacity/100,
                                backgroundImage: img,
                    }}
                    >
                     
                  
         {component === 'multiplechoice' && <MultipleChoice/>}
         {component === 'imagechoice' && <ImageChoice/>}
         {component === 'wordcloud' && <WordCloud/>}

                    </Paper>
                    
    );
}


export default Presentation
