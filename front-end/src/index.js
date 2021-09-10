import React from 'react';
import ReactDOM from 'react-dom';
import './index.module.css';
import App from './App';
import { BrowserRouter } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { UserContextProvider } from './store/tripUser-context';



ReactDOM.render(
<UserContextProvider>
  <BrowserRouter>
    <App />
  </BrowserRouter>
  </UserContextProvider>,
  
  document.getElementById('root')
);

