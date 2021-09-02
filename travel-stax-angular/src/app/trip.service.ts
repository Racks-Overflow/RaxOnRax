import { Injectable } from '@angular/core';
import { HttpClient}  from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trip } from './trip';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TripService {
  private apiServerURL = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getTrips(): Observable<Trip[]> {
    return this.http.get<Trip[]> (`${this.apiServerURL}/tripcontroller/see-all`);
  }

  public addTrip(trip: Trip): Observable<Trip> {
    return this.http.post<Trip> (`${this.apiServerURL}/tripcontroller/create`, trip);
  }

}
