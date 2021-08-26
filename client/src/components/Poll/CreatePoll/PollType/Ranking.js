import React from 'react';
import Rating from '@material-ui/lab/Rating';
import StarBorderIcon from '@material-ui/icons/StarBorder';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';

function Ranking({data2, result, inputList, textcolor}) {
  return (
    <div>
      <h1 style={{color: textcolor}}>{data2.question}</h1>
      {inputList.map((x,i)=>{
            return(
              <Box component="fieldset" mb={3} borderColor="transparent" key={i}>
              <b style={{textAlign: 'left'}}>{inputList[i].choice}</b>
                <Typography component="legend">Option</Typography>
                <Rating
                name="customized-empty"
                defaultValue={2}
                precision={0.5}
                max={5}
                size="large"
                emptyIcon={<StarBorderIcon fontSize="inherit" />}
                />
              </Box>  )
        })}
    </div>
  );
}

export default Ranking