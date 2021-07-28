import styled, { css } from "styled-components";
import React from 'react'

export const Container = styled.div`
  margin: 0px auto;
  max-width: 800px;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
`;

export const MainContainer = styled.div`
  display: flex;
  justify-content: space-evenly;
  width: 100%;
  height: 100%;
`;

export const BarChartContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
`;

export const Chart = css`
  margin-top: 0%;
  
  width: ;
  max-width: 96px;
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

export const MakeBar = styled.div`
  height: ${(props) => props.height}%;
  background-image: linear-gradient(
    to bottom,
    ${(props) => props.colors[0]},
    ${(props) => props.colors[1]}
  );
  ${Chart};
`;

export const BlackLine = styled.div`
  width: 100%;
  height: 5px;
  background-color: grey;
`;

export const __DATA__ = [
    {
      distance: 13,
      colors: ["#ffd847", "#e0a106"]
    },
    {
      distance: 20,
      colors: ["#ff47ab", "#e0064e"]
    },
    {
      distance: 16,
      colors: ["#add9c0", "#1da890"]
    },
    {
      distance: 30,
      colors: ["#cbd9ad", "#7ca81d"]
    },
  ];
  
function ImageChoice () {
    return(
      <Container>
      <MainContainer>
        {__DATA__.map(({ distance, colors }, i) => {
          return (
            <BarChartContainer key={i}>
              <Number color={colors[1]}>{distance}</Number>
              <MakeBar height={distance * 2} colors={colors} />
            </BarChartContainer>
          );
        })}
      </MainContainer>
      <BlackLine />
    </Container>
    );
  } 
  export default ImageChoice