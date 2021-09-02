import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TripService } from './trip.service';
import { Trip } from './trip.create/trip.create.component';
import { TripCreateComponent } from './trip/trip-create/trip-create.component';

@NgModule({
  declarations: [
    AppComponent,
    Trip.CreateComponent,
    TripCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [TripService],
  bootstrap: [AppComponent]
})
export class AppModule { }
