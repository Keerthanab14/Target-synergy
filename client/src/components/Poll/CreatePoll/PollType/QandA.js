import styled, { css } from "styled-components";
import React, {useState} from 'react'
import Button from '@material-ui/core/Button';
import Box from '@material-ui/core/Box';


export const Container = styled.div`
  margin: 0px auto;
  max-width: 1000px;
  height: 100%;
  min-height: 400px;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
`;

export const MainContainer = styled.div`
  display: flex;
  justify-content: space-evenly;
  width: 100%;
  height: 100%;
  min-height: inherit;
`;

export const Chart = css`
  margin-top: 0%;
  width: 100%;
  max-width: 86px;
  &:hover {
    opacity: 0.8;
  }
  @media (max-width: 420px) {
    width: 34px;
  }
`;

export const Number = styled.span`
  font-size: 1.5rem;
  text-align: center;
  color: ${(props) => props.color};
`;

function QandA ({data6, result, textcolor}) {
  const answer=['Question 1', 'Question 2','Question 3']
    return(
      <div style={{justifyContent: 'space-evenly',display: 'flex', flexWrap: 'wrap', width: '40%', alignItems: 'center'}}>
        <h1 style={{color: textcolor}}>{data6.question}</h1>
       { answer.map((x,i)=>{
          return(
          <MainContainer>
        <Box color="white" bgcolor="#cc0000" p={1} fontFamily= "Helvetica" style={{ backgroundColor:'#cc0000', width: '30%'}} >
          {x}
        </Box>
      </MainContainer>)
        })}
        
    </div>
    );
  } 
  export default QandA