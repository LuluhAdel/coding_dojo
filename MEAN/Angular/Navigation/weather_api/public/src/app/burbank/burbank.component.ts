import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpService } from './../http.service';

@Component({
  selector: 'app-burbank',
  templateUrl: './burbank.component.html',
  styleUrls: ['./burbank.component.css']
})
export class BurbankComponent implements OnInit {
  weather;
  humidity;
  temp;
  description;
  temp_min;
  temp_max;
  constructor(
    private _route: ActivatedRoute,
    private _router: Router,
    private _httpService: HttpService
  ) {}

  ngOnInit() {
    let observable = this._httpService.getWeather('Burbank')
    observable.subscribe((data:any) => {
      this.humidity = data.main.humidity
      this.temp = data.main.temp
      this.temp_min = data.main.temp_min
      this.temp_max = data.main.temp_max
      this.description = data.weather.description
  
})
}

}

