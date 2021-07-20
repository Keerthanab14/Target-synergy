import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import PollIcon from '@material-ui/icons/Poll';
import CreateIcon from '@material-ui/icons/Create';
import PeopleIcon from '@material-ui/icons/People';
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
      horizontal: 'center',
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
    '&:focus': {
        _backgroundColor: "#cc0000",
        get backgroundColor() {
            return this._backgroundColor;
        },
        set backgroundColor(value) {
            this._backgroundColor = value;
        },
      '& .MuiListItemIcon-root, & .MuiListItemText-primary': {
          color: theme.palette.common.white,
      },
    },
  },
}))(MenuItem);

export default function Service() {
  const [anchorEl, setAnchorEl] = React.useState(null);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  return (
    <div>
      <Button
        aria-controls="customized-menu"
        aria-haspopup="true"
        variant="contained"
        style={
          {
            backgroundColor: "#cc0000",
            color: "white",
            float: "left",
            border: "1px solid white",
            margin: "1px 10px"
          }
        }
        onClick={handleClick}
      >
        Services
      </Button>
      <StyledMenu
        id="customized-menu"
        anchorEl={anchorEl}
        keepMounted
        open={Boolean(anchorEl)}
        onClose={handleClose}
        style={
          {
            marginTop:"5px"
          }
        }
      >
<<<<<<< HEAD
              <StyledMenuItem onClick={handleClose}>
=======
              <Link to="/polls" style={{color:"black", textDecoration:"none"}}>
                <StyledMenuItem>
>>>>>>> 5abf70fce4e151e7b764a1c06444a1590ee1c3ed
                
                  <ListItemIcon>
                           
                    <PollIcon fontSize="small"  />
                    
                  </ListItemIcon>
                    <ListItemText primary="Polls" /> 
<<<<<<< HEAD
                  </Link>
              </StyledMenuItem>
              <StyledMenuItem onClick={handleClose}>
=======
                  </StyledMenuItem>
              </Link>
              <Link to="/opinions" style={{color:"black", textDecoration:"none" }}>
              <StyledMenuItem>
>>>>>>> 5abf70fce4e151e7b764a1c06444a1590ee1c3ed
                  <ListItemIcon>
              <PeopleIcon fontSize="small" />
              </ListItemIcon>
                  <ListItemText primary="Opinions" />    
              </StyledMenuItem>
<<<<<<< HEAD
              <StyledMenuItem onClick={handleClose}>
=======
              </Link>
              <Link to="/feedback" style={{color:"black" , textDecoration:"none"}}>
              <StyledMenuItem>
>>>>>>> 5abf70fce4e151e7b764a1c06444a1590ee1c3ed
                  <ListItemIcon>
                  
                    <CreateIcon fontSize="small" />
                    
                  </ListItemIcon>
                  
                  <ListItemText primary="Feedback" />
                 
                  
              </StyledMenuItem>
              </Link>
          </StyledMenu>
    </div>
  );
}
