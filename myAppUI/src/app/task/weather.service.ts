import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
//'http://api.openweathermap.org/data/2.5/weather?q=Austin,Texas&appid='

  defaultLocation = 'q=Austin,Texas&'
  apiKey = 'appid=939ac13658fad1c02b7fcad388a113d2'
  imperialUnits = 'units=imperial&'
  defaultWeatherUrl = 'http://api.openweathermap.org/data/2.5/weather?'
  

  public weather: BehaviorSubject<any> = new BehaviorSubject<any>([]);
  
  constructor(private http:HttpClient) { }

  getWeather(){
    return this.http.get(this.defaultWeatherUrl+this.defaultLocation+this.imperialUnits+this.apiKey)
  }

  zipcodeWeather(zipcode){
    return this.http.get(this.defaultWeatherUrl+'zip='+zipcode+',us&'+this.imperialUnits + this.apiKey)
  }

  cityWeather(city,state){
    return this.http.get(this.defaultWeatherUrl + 'q=' + city +','+state+ '&' + this.imperialUnits + this.apiKey)
  }
}
