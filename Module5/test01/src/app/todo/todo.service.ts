import { Injectable } from '@angular/core';
import {Todo} from '../todo';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  todoList: Todo[] = [];
  private URL_TODO = "http://localhost:3000/todo/";
  constructor(private httpClient: HttpClient) {

  }

  getAllToDo(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(this.URL_TODO);
  }

  addNewTodo(todo: Todo){
    return this.httpClient.post(this.URL_TODO,todo);
  }

  deleteTodo(idForDelete: number){
    return this.httpClient.delete(this.URL_TODO + idForDelete);
  }

  updateEditTodo(id: number, todo: Todo){
    console.log(todo)
    return this.httpClient.put(this.URL_TODO + id, todo);
  }
  findById(id: number){
    return this.httpClient.get<Todo>(this.URL_TODO + id);
  }

}
