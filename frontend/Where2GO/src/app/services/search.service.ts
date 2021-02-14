import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";
import { SearchResponse } from '../models/SearchResponse'
import { Location } from '../models/Location'
import { catchError } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiUrl = "http://localhost:8080/find";
  private searchResponse:SearchResponse;
  public storedLocation:Location;

  constructor(private http: HttpClient) { }

  async getRandomLocation(params: HttpParams):Promise<SearchResponse> {
    this.http.get(this.apiUrl,{params}).subscribe(data => this.extractData(data));
    const result = await this.http.get(this.apiUrl).toPromise();

    console.log("öööööööö")
    console.log(this.searchResponse)
    return this.searchResponse;

  }

  private extractData(res: any) {
    let body = res;
    this.searchResponse = new SearchResponse(body.location, body.status);
  }
  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

  public setLocation(loc: Location){
    this.storedLocation = loc;
  }
  public getLocation(){
    return this.storedLocation;
  }

}

