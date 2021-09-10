import React from 'react';
import styles from './Footer.module.css';
import { Link } from "react-router-dom";

export default function Footer() {
    return (
        <footer className={styles.footer}>
            <div>
            
            <h1 className={styles.quote}>"A journey is best measured in friends rather than miles." - Author Tim Cahill</h1>
            </div>
            <div className={styles.emailDiv}>
          <Link className={styles.email} to="/report-bug" > Please contact us at StaxOverFlow@gmail.com  </Link>
        </div>
        </footer>
    );
   
}