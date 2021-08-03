import styled, { css } from "styled-components";
import React from 'react'
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

export const box = styled.div`
  height: 10%;

`;

function OpenEnded(){
    return(
        <Container marginTop= '10px'>
          <h1 fontFamily= "Helvetica" justifyContent="left" >What would you like to say?</h1>
          <div style={{ marginTop: '10px', marginLeft: "10px" , justifyContent: "center", display: "flex", align: "center"}}>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    I would like to thank the presenter for such an informative seminar! Would like to join more such sessions
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    very intersenting way to conduct the presentation. I appreciste you taking the views from audicence
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    Thank you for the presentation, but can ypu please repeat the last part i didn't get it.
                </Box>
            </div>
            <div style={{ marginTop: '10px', marginLeft: "10px" , justifyContent: "center", display: "flex", align: "center"}}>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    I would like to thank the presenter for such an informative seminar! Would like to join more such sessions
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    very intersenting way to conduct the presentation. I appreciste you taking the views from audicence
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    Thank you for the presentation, but can ypu please repeat the last part i didn't get it.
                </Box>
            </div>
            <div style={{ marginTop: '10px', marginLeft: "10px" , justifyContent: "center", display: "flex", align: "center"}}>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    I would like to thank the presenter for such an informative seminar! Would like to join more such sessions
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    very intersenting way to conduct the presentation. I appreciste you taking the views from audicence
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    Thank you for the presentation, but can ypu please repeat the last part i didn't get it.
                </Box>
            </div>
            <div style={{ marginTop: '10px', marginLeft: "10px" , justifyContent: "center", display: "flex", align: "center"}}>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    I would like to thank the presenter for such an informative seminar! Would like to join more such sessions
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    very intersenting way to conduct the presentation. I appreciste you taking the views from audicence
                </Box>
                <Box color="white" bgcolor="#708090" p={1} fontFamily= "Helvetica" style={{ width:"500px", marginBottom: '5px', marginRight:"10px"}}>
                    Thank you for the presentation, but can ypu please repeat the last part i didn't get it.
                </Box>
            </div>
        </Container>
    );
}

export default OpenEnded
