import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  templateUrl:"app.component.html",
  styleUrls: [ './app.component.css' ]
})
export class AppComponent  {
  private stat = true;

  public mycolors = {
    BGcolor1:this.stat,
    TXTcolor1:this.stat,
    TXTproperty1:this.stat
  };

  change(value) {
    console.log(value)
  }

  public selectedValue:string= "";

  movies: Movie[] = [  
    {title:'Zootopia',director:'Byron Howard, Rich Moore',cast:'Idris Elba, Ginnifer Goodwin, Jason Bateman',releaseDate:'March 4, 2016',ciudad:'Madrid'},  
    {title:'Batman v Superman: Dawn of Justice',director:'Zack Snyder',cast:'Ben Affleck, Henry Cavill, Amy Adams',releaseDate:'March 25, 2016', ciudad:'Madrid'},  
    {title:'Captain America: Civil War',director:'Anthony Russo, Joe Russo',cast:'Scarlett Johansson, Elizabeth Olsen, Chris Evans',releaseDate:'May 6, 2016',ciudad:'Barcelona'},  
    {title:'X-Men: Apocalypse',director:'Bryan Singer',cast:'Jennifer Lawrence, Olivia Munn, Oscar Isaac',releaseDate:'May 27, 2016',ciudad:'Valencia'}  
  ]  

}


export interface Movie {  
  title : string;  
  director : string;  
  cast : string;  
  releaseDate : string;  
  ciudad:string;
}  
