import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  public usuarios =[
    {
      "id": 1, "name": "Leanne Graham", "username": "Bret", "email": "Sincere@april.biz",
      "address": {
        "street": "Kulas Light", "suite": "Apt. 556","city": "Gwenborough","zipcode": "92998-3874",
        "geo": {"lat": "-37.3159","lng": "81.1496"}
      }
    },
    {
      "id": 2,"name": "Ervin Howell","username": "Antonette","email": "Shanna@melissa.tv",
      "address": {
        "street": "Victor Plains","suite": "Suite 879","city": "Wisokyburgh","zipcode": "90566-7771",
        "geo": {"lat": "-43.9509","lng": "-34.4618"}
      }
    }
    ]

  constructor() { }

  getUsuarios() {
    return this.usuarios;
  }
}
