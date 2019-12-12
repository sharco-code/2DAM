import { Component } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import localeES from '@angular/common/locales/es';

@Component({
  selector: 'my-app',
  templateUrl:"app.component.html",
  styleUrls: [ './app.component.css' ]
})

export class AppComponent  {
  
  a: number = 0.259;
  b: number = 1.3495;
  today: number = Date.now();
  objectjson: Object = {foo: 'bar', baz: 'qux', nested: {xyz: 3, numbers: [1, 2, 3, 4, 5]}};
  object: {[key: number]: string} = {2: 'foo', 1: 'bar'};
  map = new Map([[2, 'foo'], [1, 'bar']]);
  collection: string[] = ['a', 'b', 'c', 'd'];
  name = "Raul";
  ArrayJsons=[{p0: 1,p1: 'aa', p2: 3, p3: '3'},
              {p0: 2,p1: 'CC', p2: 2, p3: '2'},
              {p0: 3,p1: 'BB', p2: 5, p3: '5'},
              {p0: 4,p1: 'BB', p2: 1, p3: '1'},
              {p0: 5,p1: 'aa', p2: 2, p3: '4'},    
              {p0: 6,p1: 'AA', p2: 2, p3: '4'},           
              {p0: 7,p1: 'AA', p2: 4, p3: '4'}];

  title = 'PBASE';

  ngOnInit() {
    registerLocaleData(localeES,'es');
  }


}

