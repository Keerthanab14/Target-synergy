import React from 'react'
import Button from '@material-ui/core/Button';

function Home() {
    return (
        <div>
            <Button
                variant="contained"
                onClick={() => {/*link to main.js*/ }}
                style={{ backgroundColor: "#cc0000", color: "white" }}
            >Home</Button>
        </div>
    )
};

export default Home