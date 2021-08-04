import React from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import SettingsIcon from '@material-ui/icons/Settings';
import PeopleIcon from '@material-ui/icons/People';
import AccountCircle from '@material-ui/icons/AccountCircle';
import { Link } from 'react-router-dom';
import { IconButton } from '@material-ui/core';


const StyledMenu = withStyles({
  paper: {
    border: '1px solid #d3d4d5',
  },
})((props) => (
  <Menu

    getContentAnchorEl={null}
    anchorOrigin={{
      vertical: 'bottom',
      horizontal: 'left',
    }}
    transformOrigin={{
      vertical: 'top',
      horizontal: 'center',
    }}
    {...props}
  />
));

const useStyles = makeStyles(() => ({
  root: {
    
    },
  head: {
      backgroundColor: '#ff8080',
      '&:hover': {
        backgroundColor: '#ff8080',
        disableRipple: true ,
        },
      
    },
}))

export default function User() {
  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };
  const classes = useStyles();
  return (
    <div>
    <IconButton 
    aria-label="account of current user"
    aria-controls="menu-appbar"
    aria-haspopup="true"
    color="inherit"
     onClick={handleClick}>
      <AccountCircle /></IconButton>
      <StyledMenu
        id="customized-menu"
        anchorEl={anchorEl}
        keepMounted
        open={Boolean(anchorEl)}
        onClose={handleClose}
        style={
          {
            marginTop:"4px",
    
          }
        }
      >
            {/*  <Link to="/polls" style={{color:"black", textDecoration:"none"}}> */}
                <MenuItem className={classes.head}  >
                
                  <ListItemIcon>
                           
                    <SettingsIcon fontSize="small"  />
                    
                  </ListItemIcon>
                    <ListItemText primary="SETTINGS"   /> 
                  </MenuItem>
              {/*</Link> */}
             {/* <Link to="settingspage" style={{color:"black", textDecoration:"none" }}>*/}
                    
                  <MenuItem className={classes.root} onClick={handleClose}>
                    <ListItemText primary="Notifications"   /> 
                  </MenuItem>
            <MenuItem className={classes.root} onClick={handleClose}>
                   <ListItemText primary="Logout"   /> 
                  </MenuItem>
              <MenuItem className={classes.head} >
                  <ListItemIcon>
              <PeopleIcon fontSize="small" />
              </ListItemIcon>
                  <ListItemText primary="TEAM MEMBERS" />    
              </MenuItem>
              <MenuItem className={classes.root} onClick={handleClose}>
                   <ListItemText primary="Add New"   /> 
                  </MenuItem>
            <MenuItem className={classes.root} onClick={handleClose}>
              <ListItemText primary="Existing"   /> 
                  </MenuItem>
             {/* </Link> */}
              
          </StyledMenu>
    </div>
  );
}