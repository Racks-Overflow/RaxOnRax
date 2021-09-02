import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Trip } from './trip';
import { TripService } from './trip.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title : string = "Hi";
  public trips: Trip[] = [];

  constructor(private tripService : TripService) {}

  ngOnInit() {
    this.getTrips();
  }

  public getTrips(): void {
    this.tripService.getTrips().subscribe(
      (response: Trip[]) =>{
        this.trips = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public addTrips(trip: Trip): void {
    this.tripService.addTrip(trip).subscribe(
      (response: Trip) =>{
        console.log(trip); 
        this.getTrips();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
