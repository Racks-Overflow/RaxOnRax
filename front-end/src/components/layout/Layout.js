import classes from "./Layout.module.css";
import MainNav from "./MainNav";

function Layout(props){
    return <div>
        <MainNav setPage={props.setPage} currentUser={props.currentUser} setCurrentUser={props.setCurrentUser}/>
        <main className={classes.main}>{props.children}</main>
    </div>
}

export default Layout;