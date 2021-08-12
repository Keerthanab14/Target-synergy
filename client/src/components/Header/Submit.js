import React from 'react'
import Button from '@material-ui/core/Button';
import {useHistory} from 'react-router-dom';

function Home() {
    let history = useHistory();
    function handleClick(path) {
       history.push(path);
       
   }
    return (
        <div>
            <Button
                variant="contained"
                onClick={() => {/*handleClick('') */}}
                style={
                    {
                        backgroundColor: "#cc0000",
                        color: "white",
                        position: "relative",
                        border: "1px solid white",
                        margin: "3px",
                        
                    }
                }
            >Submit</Button>
        </div>
    )
};

export default Home