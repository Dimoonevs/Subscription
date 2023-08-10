import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AddNewSportsmen, GetSportsmenByIDResp, UpdateSportsmanReq, UserRepo } from './interfase/interface';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  allLinks = "http://localhost:8080/api/v1/"

  constructor(private http: HttpClient) { }

  getAllSportsmenOfGrope(id: number):Observable<UserRepo>{
    const headers =new HttpHeaders({
      "Grope": id
    })

    return this.http.get<UserRepo>("http://localhost:8080/api/v1/for/sportsman/get/all/by/grope", {headers:headers})
  }

  getAllLinks():string{
    return this.allLinks;
  }
  getSpurtsmenByID(id:any):Observable<GetSportsmenByIDResp>{
    const headers = new HttpHeaders({
      "id":id
    })
    return this.http.get<GetSportsmenByIDResp>(this.allLinks + "sportsmen/get_by_id", {headers: headers})
  }

  updateSportsmen(id:any, sportsmanReq: UpdateSportsmanReq){
    const headers = new HttpHeaders({
      "id":id
    })
      return this.http.post(this.allLinks + "sportsmen/update", sportsmanReq, {headers:headers})
  }
  addSportsmen(sportsmanReq: AddNewSportsmen){
    return this.http.post(this.allLinks + "sportsmen/add", sportsmanReq)
  }

}
