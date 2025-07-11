import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Task } from './task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseUrl = "http://localhost:8000/task";

  constructor(private http: HttpClient) {}

  getAll(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.baseUrl}/all`).pipe(
    tap(data => console.log('Tasks from backend:', data)));
  }

  getById(id: number): Observable<Task> {
    return this.http.get<Task>(`${this.baseUrl}/view/${id}`);
  }

  create(task: Task): Observable<Task> {
    return this.http.post<Task>(`${this.baseUrl}/add`, task);
  }

  update(id: number, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.baseUrl}/update/${id}`, task);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${id}`);
  }
  
}
