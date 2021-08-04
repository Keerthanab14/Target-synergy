import React from 'react'
import { useTheme, makeStyles } from '@material-ui/core/styles'
import PropTypes from 'prop-types';
import SwipeableViews from 'react-swipeable-views';
import PollType from './PollType/PollType'
import ContentQandA from './ContentType/ContentQandA'
import ContentWordCloud from './PollType/ContentWordCloud'
 import ContentImageChoice from './ContentType/ContentImageChoice';
import ContentOpenEnded from './ContentType/ContentOpenEnded';
import Content from './ContentType/Content'
import Background from '../CreatePoll/Background'
import '../CreatePoll/CreatePolls.css'
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import { Grid } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
 tablabel: {
   minWidth: 65, maxWidth: 400,
   flexGrow: 1,
      flexShrink: 1,
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



const Sidebar = ({ parentCallback, color, clickHandler, setOpacity, togglePopup, component }) => {

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
        <Grid className="Sidebar" style={ { flexGrow: 1, flexShrink: 1}}>
                  <AppBar position="static" color="default" style={{marginTop: '0%'}} style={{flexGrow: 1, flexShrink: 1}}>
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="primary"
          textColor="primary"
          aria-label="full width tabs example"
          style={{flex: '1'}}
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
        <TabPanel value={value} index={0} dir={theme.direction}  >
          <PollType 
          clickHandler={clickHandler} handleChangeIndex={handleChangeIndex} style={{flex: '1'}}  />
        </TabPanel>
        <TabPanel value={value} index={1} dir={theme.direction}style={{flex: '1'}}>
        {component==="multiplechoice" && <Content />}
        {component==="qanda" && <ContentQandA />}
        {component==="wordcloud" && <ContentWordCloud />}
        {component==="openended" && <ContentOpenEnded/>}
       {component==="imagechoice" && <ContentImageChoice/>} 

        </TabPanel>
        <TabPanel value={value} index={2} dir={theme.direction}style={{flex: '1'}}>
          <Background parentCallback={parentCallback} color={color} setOpacity={setOpacity} togglePopup={togglePopup} />
        </TabPanel >
      </SwipeableViews>
                
           
        </Grid>
        
       
    );
};


export default Sidebar
