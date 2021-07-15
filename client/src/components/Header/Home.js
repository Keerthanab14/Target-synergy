import React from 'react'
import Button from '@material-ui/core/Button';

function Home() {
    return (
        <div>
            <Button
                variant="contained"
                onClick={() => {/*link to main.js*/ }}
                style={
                    { backgroundColor: "#cc0000", 
                          color: "white", 
                          float: "left",
                          border: "1px solid white",
                          margin: "1px 5rem"
                    }
                  }
            >Home</Button>
        </div>
    )
};

export default Home