import { Component, OnInit } from '@angular/core';
import { WeatherService } from 'src/app/task/weather.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.scss']
})
export class WeatherComponent implements OnInit {

  weatherInfo
  mainWeather
  weatherDesc
  temperature
  tempFeelsLike
  tempMax
  tempMin
  windSpeed
  windUnit

  constructor(private weatherService: WeatherService) { }

  ngOnInit() {
    this.weatherService.getWeather()
      .subscribe((data) => {
        this.weatherInfo = data
        console.log(this.weatherInfo)
        this.mainWeather = this.weatherInfo.weather[0].main
        this.weatherDesc = this.weatherInfo.weather[0].description
        this.temperature = this.weatherInfo.main.temp
        this.tempFeelsLike = this.weatherInfo.main.feels_like
        this.tempMax = this.weatherInfo.main.temp_max
        this.tempMin = this.weatherInfo.main.temp_min
        this.windSpeed = this.weatherInfo.wind.speed
        this.windUnit = this.weatherInfo.wind.unit
        console.log(this.weatherInfo.weather[0].main, " day with ", this.weatherInfo.weather[0].description)
      })
  }
  zipcodeWeatherForm = new FormGroup({
    zipcode: new FormControl('')
  })

  cityWeatherForm = new FormGroup({
    city: new FormControl(''),
    state: new FormControl('')
  });

  onZipcodeWeatherSubmit() {
    this.weatherService.zipcodeWeather(this.zipcodeWeatherForm.value.zipcode)
      .subscribe((data) => {
        this.weatherInfo = data
        console.log(this.weatherInfo)
        this.mainWeather = this.weatherInfo.weather[0].main
        this.weatherDesc = this.weatherInfo.weather[0].description
        this.temperature = this.weatherInfo.main.temp
        this.tempFeelsLike = this.weatherInfo.main.feels_like
        this.tempMax = this.weatherInfo.main.temp_max
        this.tempMin = this.weatherInfo.main.temp_min
        this.windSpeed = this.weatherInfo.wind.speed
        this.windUnit = this.weatherInfo.wind.unit
        console.log(this.weatherInfo.weather[0].main, " day with ", this.weatherInfo.weather[0].description)
      })
  }
  onCityWeatherSubmit() {
    this.weatherService.cityWeather(this.cityWeatherForm.value.city, this.cityWeatherForm.value.state)
      .subscribe((data) => {
        this.weatherInfo = data
        console.log(this.weatherInfo)
        this.mainWeather = this.weatherInfo.weather[0].main
        this.weatherDesc = this.weatherInfo.weather[0].description
        this.temperature = this.weatherInfo.main.temp
        this.tempFeelsLike = this.weatherInfo.main.feels_like
        this.tempMax = this.weatherInfo.main.temp_max
        this.tempMin = this.weatherInfo.main.temp_min
        this.windSpeed = this.weatherInfo.wind.speed
        this.windUnit = this.weatherInfo.wind.unit
        console.log(this.weatherInfo.weather[0].main, " day with ", this.weatherInfo.weather[0].description)
      })
  }
}
