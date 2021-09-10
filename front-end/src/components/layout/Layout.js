import classes from "./Layout.module.css";
import MainNav from "./MainNav";
import logoHeader from "../../assets/logoleftcropped.jpeg";
import topGradient from "../../assets/20percent.png";


function Layout(props){
    return <div>
         
        <MainNav setPage={props.setPage} currentUser={props.currentUser} setCurrentUser={props.setCurrentUser}/>
        <main className={classes.main}>
            <div className={classes.headerLogoDiv}>
                <img className={classes.logoHeader} src={logoHeader} alt="logo" />
            </div>
            <div className={classes.topGradientDiv}>
                <img className={classes.topGradient} src={topGradient} alt="small gradient" />
                </div>
            
            {props.children}
        </main>
       
     
               
    </div>
}

export default Layout;