import React from 'react'
import Button from '@material-ui/core/Button';

function Home() {
    return (
        <div>
            <Button
                variant="contained"
                onClick={() => {/*link to respective poll.js*/ }}
                style={
                    {
                        backgroundColor: "#cc0000",
                        color: "white",
                        position: "relative",
                        border: "1px solid white",
                        margin: "1px"
                    }
                }
            >Submit</Button>
        </div>
    )
};

export default Home