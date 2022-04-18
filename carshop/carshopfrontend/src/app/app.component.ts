import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { User } from './model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  currentUser?: User = undefined;

  constructor(private router: Router, private client: HttpClient, private snack: MatSnackBar) {
  }
  async ngOnInit() {
    if(await this.loggedIn())
      this.currentUser = await this.info()
  }

  navigateHome() {
    this.router.navigate(['/home']);
  }

  navigateLogin() {
    this.router.navigate(['/login']);
  }

  public async info(): Promise<User> {
    var bearer = localStorage.getItem('__bearer');
    return this.client.get<User>(environment.url + 'info', {headers: {
          'content-type': 'application/json',
          'Authorization': `Bearer ${bearer}`
        },}).toPromise()
        .catch((error: HttpErrorResponse) => undefined)
        .then((data: any) => data, error => undefined);
  }

  public async loggedIn(): Promise<boolean> {
    var bearer = localStorage.getItem('__bearer');
    if (bearer == undefined) return false;
    var userInfo = await this.info();
    return userInfo !== undefined;
  }

  performLogout() {
    localStorage.removeItem('__bearer')
    this.currentUser = undefined
    this.router.navigate(['/login']).then(_ => this.snack.open("Logged out!", "Close"))
  }
}
