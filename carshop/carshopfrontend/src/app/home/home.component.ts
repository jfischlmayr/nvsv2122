import { Component, OnInit } from '@angular/core';
import { Car } from '../model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  cars: Car[] = [];

  constructor(private client: HttpClient) { }

  async ngOnInit() {
    var bearer = localStorage.getItem('__bearer');
    var cars = await this.client.get<Car[]>(environment.url + "getCars", { headers: {
      'content-type': 'application/json',
      'Authorization': `Bearer ${bearer}`}}).toPromise();
    if (cars != undefined) {
        this.cars = cars;
    }
  }
}
