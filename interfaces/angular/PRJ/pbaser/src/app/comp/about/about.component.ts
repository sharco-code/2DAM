import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor(
    private router:Router,
    private RutaActiva:ActivatedRoute) { }

  ngOnInit() {
  }
  onClick(){
    this.router.navigate(['../',{relativeTo:this.RutaActiva}])
  }

}
