import React from 'react'
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';

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