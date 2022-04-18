import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { AuthenticationModel, LoginResult } from '../model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  constructor(private formBuilder: FormBuilder, private snack: MatSnackBar, private router: Router, private client: HttpClient) { }

  public loginForm!: FormGroup;

  ngOnInit(): void {
      this.loginForm = this.formBuilder.group({
          userName: ['', Validators.required],
          password: ['', Validators.required]
      });
  }

  public async performLogin() {
      if (this.loginForm.valid) {
        const login: AuthenticationModel = { userName: this.loginForm.get('userName')?.value, password: this.loginForm.get('password')?.value}
        this.client.post<LoginResult>(environment.url + "login", JSON.stringify(login), { headers: new HttpHeaders({'content-type': 'application/json'})}).toPromise()
            .then(
              (loginResult) => {
                  localStorage.setItem('__bearer', loginResult!.token);
                  this.router.navigate(['/home'])
                      .then(_ => window.location.reload())
                      .then(_ => this.snack.open("Login successful", "Close"))
              },
              (_: any) => this.snack.open("Invalid username or password", "Close")
          );
      }
  }
}
