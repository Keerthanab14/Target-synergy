import React from 'react'

import { useTheme, makeStyles } from '@material-ui/core/styles'
import PropTypes from 'prop-types';
import SwipeableViews from 'react-swipeable-views';
import PollType from '../CreatePoll/PollType'
import Content from '../CreatePoll/Content'
import Background from '../CreatePoll/Background'
import '../CreatePoll/CreatePolls.css'
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';

const useStyles = makeStyles((theme) => ({
 tablabel: {
   minWidth: 75, maxWidth: 400
 }
}));
function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`full-width-tabpanel-${index}`}
      aria-labelledby={`full-width-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box p={3}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index) {
  return {
    id: `full-width-tab-${index}`,
    'aria-controls': `full-width-tabpanel-${index}`,
  };
}



const Sidebar = ({ parentCallback, toggleVisibility }) => {
  const theme = useTheme();
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };
  
   
   const classes = useStyles();
    return (
        <div className="Sidebar">
                  <AppBar position="static" color="default" style={{marginTop: '10%'}}>
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="primary"
          textColor="primary"
          aria-label="full width tabs example"
        >
          <Tab label="Type" {...a11yProps(0)} className={classes.tablabel} />
          <Tab label="Content" {...a11yProps(1)}className={classes.tablabel} />
          <Tab label="Background" {...a11yProps(2)}className={classes.tablabel} />
        </Tabs>
      </AppBar>
      <SwipeableViews
        axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
        index={value}
        onChangeIndex={handleChangeIndex}
      >
        <TabPanel value={value} index={0} dir={theme.direction} >
          <PollType toggleVisibility={toggleVisibility}  />
        </TabPanel>
        <TabPanel value={value} index={1} dir={theme.direction}>
          <Content />
        </TabPanel>
        <TabPanel value={value} index={2} dir={theme.direction}>
          <Background parentCallback={parentCallback}/>
        </TabPanel>
      </SwipeableViews>
                
           
        </div>
        
       
    );
};


export default Sidebar