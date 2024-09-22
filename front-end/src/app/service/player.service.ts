import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getPlayer() {
    let basicAuthHeaderString = `Basic ` + window.btoa('mostafa@gmail.com' + `:` + '123456');// 64
    let header = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    // @ts-ignore
    return this.http.get<any>(`http://localhost:8080/football/start`,{headers : header,responseType: 'text'});
    /*
    return this.http.get<any>(`http://localhost:8080/football/start`,{headers : header,responseType: 'text'}).pipe(
      map(
        response => {
          // @ts-ignore
          console.log(response)
          console.log(header)
       //   let xsrf = this.getCookie('XSRF-TOKEN');
//          window.sessionStorage.setItem("XSRF-TOKEN",xsrf);
          return response;
        }
      )
    );
     */
  }
  getPlayerBas() {
    let basicAuthHeaderString = `Basic ` + window.btoa('mostafa@gmail.com' + `:` + '123456');// 64
    let header = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })
    // @ts-ignore
    return this.http.get<any>(`http://localhost:8080/basketball/start`,{headers : header,responseType: 'text'});
  }

 /* getCookie(name: string) {
    let cookie = {};
    document.cookie.split(';').forEach(function(el) {
      let [k,v] = el.split('=');
      // @ts-ignore
      cookie[k.trim()] = v;
    })
    // @ts-ignore
    return cookie[name];
  }*/

}
