import React,{useState, useEffect,useContext} from 'react';
import ReactWordcloud from 'react-wordcloud';
import axios from 'axios'
import { IdContext } from '../../../../IdContext';


const wcr=['Word', 'Cloud', 'Red', 'White', 'Polling', 'Live'];
const WordCloud=({data4,textcolor})=>{
  const callbacks = {
    getWordColor: word => word.value > 50 ? "blue" : "red",
    onWordClick: console.log,
    onWordMouseOver: console.log,
    getWordTooltip: word => `${word.text} (${word.value}) [${word.value > 50 ? "good" : "bad"}]`,
  }
 
  const options = {
    colors: ["#1f77b4", "#ff7f0e", "#2ca02c", "#d62728", "#9467bd", "#8c564b"],
    enableTooltip: true,
    deterministic: false,
    fontFamily: "helvetica",
    fontSizes: [ 30, 100],
    fontStyle: "normal",
    fontWeight: "normal",
    padding: 1,
    rotations: 2,
    rotationAngles: [0, 90, -90],
    scale: "sqrt",
    spiral: "archimedean",
    transitionDuration: 1000
  };
  const size = [600, 200];

    return (
      <div>
        <h1 style={{color: textcolor}}>{data4.question}</h1>
        <div style={{display: 'flex',width: '50%'}}>
      <ReactWordcloud
        callbacks={callbacks}
        options={options}
        size={size}
        words={wcr}
      />
      </div>
      </div>
    );
  }
  export default WordCloud;