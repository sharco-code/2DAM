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
  public pass="Admin";

  public Config ={currentuser:this.user};
  public currentuser;

  constructor(
    public loginService: LoginService,
    public storeStorage: StoragesessionService,
    public router: Router
  ){}

  login() {

    this.loginService.login(this.user,this.pass);
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

/*
public Config ={IP:"localost"};
  public IP="localhost";h

  constructor( public router: Router) {
    this.Config=JSON.parse(localStorage.getItem('ConfigTest'));
    if (this.Config) this.IP=this.Config.IP;    

   }

  ngOnInit() {
  }

  onFormSubmit(){
    this.Config={IP:this.IP};
    localStorage.setItem('ConfigTest', JSON.stringify(this.Config));
    //window.location.reload();
    //this.router.navigateByUrl('/home');
    this.router.navigate([ '/login']); 
  }
*/