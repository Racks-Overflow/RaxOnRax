import TripList from "../components/layout/trips/TripList";
import NewTripForm from "../components/NewStuff/NewTripForm";
import classes from './Page.module.css'

const DUMMY_DATA = [
    {
      id: '12',
      number: '6',
      double: '100.00',
      address: 'Meetupstreet 5, 12345 Meetup City',
      description:
        'This is a first, amazing meetup which you definitely should not miss. It will be a lot of fun!',
    },
    {
      id: 'm2',
      title: 'This is a second meetup',
      image:
        'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Stadtbild_M%C3%BCnchen.jpg/2560px-Stadtbild_M%C3%BCnchen.jpg',
      address: 'Meetupstreet 5, 12345 Meetup City',
      description:
        'This is a first, amazing meetup which you definitely should not miss. It will be a lot of fun!',
    },
  ];

function Trips(){
    fetch(
        
    )



    return <section>
        <h1>All Trips</h1>
        <TripList trips={DUMMY_DATA} />
        
        </section>
        
        ;
}

export default Trips;