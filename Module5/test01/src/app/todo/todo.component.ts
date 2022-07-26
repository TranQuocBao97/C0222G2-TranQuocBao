import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TodoService} from './todo.service';

let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todoForm: FormGroup;
  todos: Todo[] = [];
  todo: Todo = {};
  content = new FormControl();
  idEdit:number;
  contentEdit:string;
  completeEdit:boolean;

  constructor(private todosService: TodoService) {

  }

  ngOnInit() {
    this.todosService.getAllToDo().subscribe(data => {
      this.todos = data;
    }, error => {
      console.log(error);
    });
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  add() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        content: value,
        complete: false
      };
      this.todosService.addNewTodo(todo).subscribe(data => {

      }, error => {

      },() => {
        this.ngOnInit();
      })  ;
    }
  }

  delete(id: number){
    this.todosService.deleteTodo(id).subscribe(data => {

    },error => {

    },() => {
      this.ngOnInit();
    });
  }

  showEdit(todo: Todo) {
    this.idEdit = todo.id;
    this.contentEdit = todo.content;
    this.completeEdit = todo.complete;
  }

  edit(id: number) {
    this.todosService.findById(id).subscribe(data => {
      this.todo = data;
    })
    this.todo.content = this.contentEdit;
    this.todosService.updateEditTodo(id,this.todo).subscribe( data => {
      this.ngOnInit();
    });
  }
}
