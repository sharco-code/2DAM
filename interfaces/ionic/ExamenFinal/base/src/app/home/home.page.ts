import { Component } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { LoginService } from '../servicios/login.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss']
})
export class HomePage {

  public currentUser;
  public user;

  constructor( private router: Router,
    public loginService: LoginService) {

    this.currentUser=JSON.parse(localStorage.getItem('currentUser'));
    this.user = this.currentUser.username;
  }

  ngOnInit() {
  }

  irConfig(){  
    this.router.navigate(['/config']);
  }
  Logout(){  
    this.loginService.logout();
    this.router.navigateByUrl("/login");
  }
  Pagoscaja(){
    this.router.navigateByUrl("/pagoscaja-list");
  }
  Exit(){
    window.close();    
  }

}
/**
 * 
  LoginData;
  public user;

  constructor() {
    this.LoginData=JSON.parse(localStorage.getItem('LoginData'));
    this.user = this.LoginData.currentuser;
    console.log("user:"+this.user);
    console.log("LoginData:"+this.LoginData.currentuser);
   }

  ngOnInit() {
    this.LoginData=JSON.parse(localStorage.getItem('LoginData'));
    this.user = this.LoginData.currentuser;
    console.log("user:"+this.user);
    console.log("LoginData:"+this.LoginData.currentuser);
  }
*/