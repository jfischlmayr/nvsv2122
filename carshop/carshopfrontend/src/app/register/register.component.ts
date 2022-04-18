import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { AuthenticationModel } from '../model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private snack: MatSnackBar, private formBuilder: FormBuilder, private router: Router, private client: HttpClient) { }

    public registerForm!: FormGroup;

    ngOnInit(): void {
        this.registerForm = this.formBuilder.group({
            userName: ['', Validators.required],
            password: ['', Validators.required],
        });
    }

    public async performRegistration() {
        if (this.registerForm.valid) {
          const register: AuthenticationModel = { userName: this.registerForm.get('userName')?.value, password: this.registerForm.get('password')?.value}
          console.log(register)
          var success = await this.client.post(environment.url + "register", JSON.stringify(register), { headers: new HttpHeaders({'content-type': 'application/json'})}).toPromise()

          if (success) {
              this.router.navigate(['/login'])
                  .then(_ => this.snack.open("Account created successfully!", "Close"));
          } else {
              this.snack.open("An account with this name already exists!", "Close");
          }
        }
    }

}
