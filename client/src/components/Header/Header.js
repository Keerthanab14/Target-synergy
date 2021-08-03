import React, { useState } from 'react';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import InputBase from '@material-ui/core/InputBase';
import { alpha, makeStyles } from '@material-ui/core/styles';
import AccountCircle from '@material-ui/icons/AccountCircle';
import logo from '../images/logo.jpg'
import Service from './Service'
import Submit from './Submit'
import { Link } from 'react-router-dom';
import User from './User';
import {GoogleLogin, GoogleLogout} from 'react-google-login';
import axios from 'axios'

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

function Header({setCheck, check}) {
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
    // // google-login
    // const responseGoogle = (response) => {
    //     console.log(response);
    //     console.log(response.profileObj);
    // }

    const onSuccess = (res)=>{
        // console.log(res.profileObj);
        const data =  {
            googleId: res.profileObj.googleId,
            email: res.profileObj.email,
            name: res.profileObj.name
            
          }
          console.log(data);
            axios.post("http://localhost:8080/newUser", data)
            .then(r =>console.log("success"))
            .catch(err => { 
            console.error(err);
          });
          setCheck(true);
    }
    const onFailure = (res)=>{
            console.log('login failed', res);
            setCheck(false);
        }

    

    return (

        <div className={classes.root}>
            <AppBar position="static" style={{ backgroundColor: "#cc0000" }}>
                <Toolbar>

                    <Link to="/">
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
                                <div>
                                   { !check && <GoogleLogin
                                        clientId="4565827063-vh8t8cgckg74git2dh3ulfq7fvd02gai.apps.googleusercontent.com"
                                        render={renderProps => (
                                            <AccountCircle onClick={renderProps.onClick  } disabled={renderProps.disabled}>
                                            </AccountCircle>
                                        )}
                                        buttonText="Gmail Login"
                                        onSuccess={onSuccess}
                                        onFailure={ onFailure}
                                        cookiePolicy={'single_host_origin'}
                                        uxMode="redirect"
                                        redirect_uri="http://localhost:3000/"
                                        isSignedIn={true}
                                    >
                                    </GoogleLogin>
                                     }
                                      </div>     
                                     { check && <User />}</IconButton>

                                    {/* <GoogleLogout
                                        clientId="4565827063-vh8t8cgckg74git2dh3ulfq7fvd02gai.apps.googleusercontent.com"
                                        buttonTex="Logout"
                                        onLogoutSuccess={onSuccess}
                                    >   
                                    </GoogleLogout> */}
                               




                           

                            {/* <MenuItem onClick={handleClose}>Sign in</MenuItem>
                                <MenuItem onClick={handleClose}>Sign up</MenuItem> */}




                        </div>
                    )}
                </Toolbar>
            </AppBar>
        </div>

    );
}
export default Header