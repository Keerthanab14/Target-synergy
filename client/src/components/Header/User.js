import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import SettingsIcon from '@material-ui/icons/Settings';
import PeopleIcon from '@material-ui/icons/People';
import AccountCircle from '@material-ui/icons/AccountCircle';
import { Link } from 'react-router-dom';


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

const StyledMenuItem = withStyles((theme) => ({
  root: {
    '&:hover': {
      backgroundColor: '#cc0000',
      },
    
  
  },
}))(MenuItem);

export default function User() {
  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  return (
    <div>
      <AccountCircle
       
        onClick={handleClick}
      >
        
      </AccountCircle>
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
                <StyledMenuItem onClick={handleClose}>
                
                  <ListItemIcon>
                           
                    <SettingsIcon fontSize="small"  />
                    
                  </ListItemIcon>
                    <ListItemText primary="Settings"   /> 
                  </StyledMenuItem>
              {/*</Link> */}
             {/* <Link to="settingspage" style={{color:"black", textDecoration:"none" }}>*/}
              <StyledMenuItem onClick={handleClose}>
                  <ListItemIcon>
              <PeopleIcon fontSize="small" />
              </ListItemIcon>
                  <ListItemText primary="Team Members" />    
              </StyledMenuItem>
             {/* </Link> */}
              
          </StyledMenu>
    </div>
  );
}