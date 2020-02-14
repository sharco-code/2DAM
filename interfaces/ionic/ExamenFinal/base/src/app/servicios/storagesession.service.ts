import { Injectable } from '@angular/core';
import { Isession } from '../models/isession';

@Injectable({
  providedIn: 'root'
})
export class StoragesessionService {
private isUserLoggedIn:boolean = false;
public SessionLogged:Isession;

  constructor() { }
  setSessionloggedIn(Session:Isession) {
    this.isUserLoggedIn = true;
    this.SessionLogged = Session;
    localStorage.setItem("currentUser",JSON.stringify(Session));
  }
  getSessionLoggedIn() {
    return JSON.parse(localStorage.getItem("currentUser"));
  }
  isAuthenticated():boolean{
    return this.isUserLoggedIn;
  }
  setSessionloggedOut(){
    localStorage.removeItem("currentUser");
    this.SessionLogged = null;
    this.isUserLoggedIn = false;
  }
}