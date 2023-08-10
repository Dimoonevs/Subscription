import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Subscribable, Subscription } from 'rxjs';
import { AuthService } from '../../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  form: FormGroup | any;
  aSub!: Subscription
  constructor(private fb:FormBuilder, private serice: AuthService, private router:Router){ this._createForm()}

  private _createForm(){
    this.form = this.fb.group(
      {
        Login: [''],
        Password:['']
      }
    )
  }
  get  _login() {return this.form.get('Login'); }
  get  _password() {return this.form.get('Password'); }

  onSubmit(){
    const coach = {
      login: this.form.value.Login,
      password: this.form.value.Password
    }
    this.aSub = this.serice.login(coach).subscribe((data)=>{
      this.router.navigate(['08d3n7i26a377m81'])
    })
  }
}
