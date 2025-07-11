import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

   private baseURL = "http://localhost:8000/auth";

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<string> {
  return this.http.post("http://localhost:8000/auth/login", { username, password }, { responseType: 'text' });
}


 register(user: User): Observable<string> {
  return this.http.post("http://localhost:8000/auth/register", user, { responseType: 'text' });
}


  
}
