/** @format */
import { useHistory } from "react-router";
import NewTripForm from "./NewTripForm";

function NewTripPage() {
    const history = useHistory();

	function addTripHandler(tripData) {
		fetch(
            'https://stax-67bce-default-rtdb.firebaseio.com/newtrip.json',
            {
              method: 'POST',
              body: JSON.stringify(tripData),
              headers: {
                'Content-Type': 'application/json',
              },
            }
          ).then(() => {
            history.replace('/');
          });
        }

        return (
          <section>
            <h1>Add New Trip</h1>
            <NewTripForm onClick={}/>
          </section>
        );
      }

export default NewTripPage;
