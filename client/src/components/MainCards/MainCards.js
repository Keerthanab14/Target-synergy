import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { CardActionArea, GridList } from '@material-ui/core';
import { Grid } from '@material-ui/core';
import polls from '../images/polls.png'
import opinion from '../images/opinion.png'
import feedback from '../images/feedback.png'
import '../MainCards/MainCard.css'
const useStyles = makeStyles({
  root: {
  
    flexGrow: 1,
       borderSpacing: 2
  },
});
function MainCards() {
  const classes = useStyles();
 
    return(
      <Card className={classes.root}>
        <Grid
                container
                spacing={3}
                direction="row"
                justify="flex-start"
                alignItems="flex-start"
        >
        <Grid item md={3} spacing={8} >

        <CardActionArea>
          <CardMedia
            component="img"
            alt="Polls"
            height="140"
            image={polls}
            title="Polls"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="h2">
              Polls
            </Typography>
            <Typography variant="body2" color="textSecondary" component="p">
            Get Instant Feedback with Online Polls

            </Typography>
          </CardContent>
        </CardActionArea>
        </Grid>
        <Grid item md={3} spacing={8}>

        <CardActionArea>
          <CardMedia
            component="img"
            alt="Polls"
            height="140"
            image={opinion}
            title="Opinions"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="h2">
              Opinions
            </Typography>
            <Typography variant="body2" color="textSecondary" component="p">
            Your opinion matters to make the right decision


            </Typography>
          </CardContent>
        </CardActionArea>
        </Grid>
        <Grid item md={3} spacing={8}>

        <CardActionArea>
          <CardMedia
            component="img"
            alt="Polls"
            height="140"
            image={feedback}
            title="Feedback"
          />
          <CardContent>
            <Typography gutterBottom variant="h5" component="h2">
              Feedback
            </Typography>
            <Typography variant="body2" color="textSecondary" component="p">
            Share your thought as it matters

            </Typography>
          </CardContent>
        </CardActionArea>
        </Grid>
        <CardActions>
          
        </CardActions>
    
        </Grid>
    </Card>
    )
}

export default MainCards
