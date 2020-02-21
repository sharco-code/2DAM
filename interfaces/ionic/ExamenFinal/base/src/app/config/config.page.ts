import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-config',
  templateUrl: './config.page.html',
  styleUrls: ['./config.page.scss'],
})
export class ConfigPage implements OnInit {

  public Config ={IP:"localost"};
  public IP="localhost";

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

  Exit(){
    this.router.navigate([ '/login']); 
  }

}
