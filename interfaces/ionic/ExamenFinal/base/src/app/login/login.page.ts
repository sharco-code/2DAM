import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from  "@angular/router";
import { Platform } from '@ionic/angular';
import { Isession } from '../models/isession';
import { StoragesessionService } from '../servicios/storagesession.service';
import { LoginService } from '../servicios/login.service';
//import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  public user="Admin";
  public pass="admin";

  constructor(
    public loginService: LoginService,
    public storeStorage: StoragesessionService,
    public router: Router
  ){}

  login() {
    if(this.loginService.login(this.user,this.pass)) {
      console.log("Login Correco");
      let token="asdf";

      let u:Isession={username:this.user,token:token};
      
      this.storeStorage.setSessionloggedIn(u);
      this.router.navigateByUrl("/home");
      
    } else {
      console.log("Login Inorreco");
      this.router.navigateByUrl("/login");
      
    }
  }
  irConfig(){  
    this.router.navigate(['/config']);
  }
  Exit(){
    window.close();    
  }
  ngOnInit() {
  }

}
