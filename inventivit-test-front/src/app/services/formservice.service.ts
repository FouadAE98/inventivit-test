import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FormserviceService {
  constructor(private http: HttpClient) {}

  public submite(fullName: string, intention: string) {
    return this.http
      .get('https://api.db-ip.com/v2/free/self')
      .subscribe(
        (data) => {
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );
  }
}
