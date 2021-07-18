import React from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import InputBase from '@material-ui/core/InputBase';
import { alpha, makeStyles } from '@material-ui/core/styles';
import AccountCircle from '@material-ui/icons/AccountCircle';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/Menu';
import logo from '../images/logo.jpg'
import Service from './Service'
//import Home from './Home'
import Submit from './Submit'
import { positions } from '@material-ui/system';
import { BrowserRouter as Router, Link } from 'react-router-dom';
import GoogleLogin from 'react-google-login';
import { useAuth0 } from "@auth0/auth0-react";

const useStyles = makeStyles((theme) => ({
    logo: {
        maxWidth: 70,
        marginRight: theme.spacing(0),
        marginLeft: theme.spacing(0),
        paddingLeft: 0,
    },

    root: {
        flexGrow: 1,
    },

    title: {
        flexGrow: 1,
        display: 'none',
        [theme.breakpoints.up('sm')]: {
            display: 'block',
        },
    },
    search: {
        position: 'relative',
        borderRadius: theme.shape.borderRadius,
        backgroundColor: alpha(theme.palette.common.white, 0.15),
        '&:hover': {
            backgroundColor: alpha(theme.palette.common.white, 0.25),
        },
        marginLeft: 0,
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            marginLeft: theme.spacing(1),
            width: 'auto',
        },
    },

    inputInput: {
        padding: theme.spacing(1, 1, 1, 0),
        color: "white",
        textAlign: "center",
        // vertical padding + font size from searchIcon
        paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
        transition: theme.transitions.create('width'),
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            width: '20ch',
            '&:focus': {
                width: '20ch',
            },
        },
    },
}));

function Header() {
    const classes = useStyles();
    const [auth, setAuth] = React.useState(true);
    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);

    const handleChange = (event) => {
        setAuth(event.target.checked);
    };

    const handleMenu = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    //google-login
    const responseGoogle= (response) =>{
        console.log(response);
        console.log(response.profileObj);
    }
    const { loginWithRedirect } = useAuth0();
    return (

        <Router>

        <div className={classes.root}>
            <AppBar position="static" style={{ backgroundColor: "#cc0000" }}>
                <Toolbar>
                
                    <Link to ="public\App.js">

                    <img src={logo} alt="logo" className={classes.logo} />
                    </Link>
                    &nbsp;&nbsp;
                    <Typography className={classes.title} variant="h6" noWrap >
                   
                        <Service />

                    </Typography>
                    <div className={classes.search}>

                        <InputBase
                            placeholder="Enter code"
                            classes={{
                                root: classes.inputRoot,
                                input: classes.inputInput,
                            }}
                            inputProps={{ 'aria-label': 'Enter code' }}
                            style={
                                {
                                    border: " 1px solid white",
                                    position: "relative",
                                  
                   }
               }
           />
                    </div>
                    &nbsp;
                    <Submit />
                     &nbsp; &nbsp;
                    {auth && (
                    
                        <div>
                            <IconButton
                                aria-label="account of current user"
                                aria-controls="menu-appbar"
                                aria-haspopup="true"
                                onClick={handleMenu}
                                color="inherit"
                            >
                               
                                

                                <AccountCircle onClick={() => loginWithRedirect()}/>
                                
                            </IconButton>

                           
                                
                        </div>
                    )}
                </Toolbar>
            </AppBar>
        </div>
        </Router>
    );
}
export default Header