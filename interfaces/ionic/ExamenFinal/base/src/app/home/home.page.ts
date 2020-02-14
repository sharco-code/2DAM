import { Component } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss']
})
export class HomePage {

  constructor( private router: Router) {}

  irConfig(){  
    this.router.navigate(['/config']);
  }
  irProductos(){  
    this.router.navigate(['/product-list']);
  }
  Exit(){
    window.close();    
  }

}
