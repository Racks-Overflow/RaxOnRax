import { useContext } from 'react';

import ActiveContext from '../../store/favorite';
import TripList from './TripList';

function FavoritesPage() {
  const favoritesCtx = useContext(ActiveContext);

  let content;

  if (favoritesCtx.totalFavorites === 0) {
    content = <p>You got no favorites yet. Start adding some?</p>;
  } else {
    content = <TripList trips={favoritesCtx.favorites} />;
  }

  return (
    <section>
      <h1>My Favorites</h1>
      {content}
    </section>
  );
}

export default FavoritesPage;