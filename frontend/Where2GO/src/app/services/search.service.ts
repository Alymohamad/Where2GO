import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from "rxjs/operators";
import { Response } from '../models/response'
import { Location } from '../models/Location'


@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiUrl = "http://localhost:8080/find";

  constructor(private http: HttpClient) { }

  getRandomLocation(): Observable<Response> {
    return this.http.get(this.apiUrl)
      .pipe(
        map((data: any) =>
          data.map(
            (item: any) =>
              console.log(JSON.stringify(item)),
              new Response(null, null)
          )
        )
      );
  }

  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}

