import { Component, OnInit } from '@angular/core';
import { StoragesessionService } from 'src/app/servicios/storagesession.service';
import {Router} from '@angular/router';
import { LoginService } from 'src/app/servicios/login.service';
import { Isession } from 'src/app/models/isession';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private storeStorage:StoragesessionService,
              private loginService:LoginService,
              private router:Router) {}

  login(username:string, password:string, event:Event) {
    if(this.loginService.login(username,password)) {
      let token="asdadasd";

      let u:Isession={username:username,token:token};
      this.storeStorage.setSessionloggedIn(u);
      this.router.navigateByUrl("/Home");
    } else {
      this.router.navigateByUrl("/Login");
    }
  }

  ngOnInit() {

  }

  

}
