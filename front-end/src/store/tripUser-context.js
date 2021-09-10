import { createContext, useState } from "react";

const UserContext = createContext({
    travellerList: [],
    totalTravellers: 0,
    addTraveller: (traveller) =>{},
    userIsGoing: () => {},
    removeTraveller: () => {}
});

  export function UserContextProvider(props){
    const [traveller, setTraveller]=useState([]);

    function addTravellerHandler(){
        setTraveller((prevTraveller) => { 
            return prevTraveller.concat(traveller);
        });
    }

    function removeTravellerHandler(){
        setTraveller(prevTraveller => {
            return prevTraveller.filter(user => user.id !== user);
        });
    }

    function travellerIsGoingHandler(){
        return traveller.some(user => user.id === user);
    }


    const context ={
        travellerlist: traveller,
        totalTravellers: traveller.length,
        addTraveller: addTravellerHandler,
        removeTraveller: removeTravellerHandler,
        traveller: travellerIsGoingHandler

    };


    return <UserContext.Provider value={context}>
{props.children}
    </UserContext.Provider>
}
export default UserContext;