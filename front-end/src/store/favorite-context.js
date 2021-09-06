// import { createContext, useState } from "react";

// const FavoritesContext = createContext({
//     favorites: [],
//     totalFavorites: 0,
//     addFavorite: (favoriteTrip) =>{},
//     itemIsFavorite: (tripId) => {},
//     removeFavorite: (tripId) => {}
// });

// export function FavoritesContetProvider(props){
//     const [userFavorites, setUserFavorites]=useState([]);

//     function addFavoriteHandler(){
//         setUserFavorites((prevUserFavorites) => { 
//             return prevUserFavorites.concat(favoriteTrip);
//         });
//     }

//     function removeFavoriteHandler(){
//         setUserFavorites(prevUserFavorites => {
//             return prevUserFavorites.filter(trip => trip.id !== tripId);
//         });
//     }

//     function itemIsFavoriteHandler(){
//         return userFavorites.some(trip => trip.id === tripId);
//     }


//     const context ={
//         favorites: userFavorites,
//         totaltFavorites: userFavorites.length,
//         addFavorite: addFavoriteHandler,
//         removeFavorite: removeFavoriteHandler,
//         itemIsFavorite: itemIsFavoriteHandler

//     };


//     return <FavoritesContext.Provider value={context}>
// {props.children}
//     </FavoritesContext.Provider>
// }
// export default FavoritesContext;