import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styleUrls: ['./star.component.css']
})
export class StarComponent implements OnInit {

  @Input() rating=0;
  starWith=0;

  constructor() { }

  ngOnChanges():void{
    this.starWith = this.rating * 75 / 5;
  }

  onClick() {

  }

  Una():boolean{return this.starWith>0 ? true : false}
  Dos():boolean{return this.starWith>20 ? true : false}
  Tres():boolean{return this.starWith>40 ? true : false}
  Cuatro():boolean{return this.starWith>60 ? true : false}
  Cinco():boolean{return this.starWith>80 ? true : false}

  ngOnInit() {
  }

}
