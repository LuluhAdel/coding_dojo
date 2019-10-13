import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'MEAN';
  recievec: any;
  tasks = []
  
  constructor(private _httpService: HttpService){}
  

  ngOnInit(){
    let observable = this._httpService.getTasks()
    observable.subscribe(data => {
      this.recievec = data
      this.tasks = data['tasks']
    })
  }
}
