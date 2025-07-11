import { Priority } from "./priority";
import { Status } from "./status";
import { User } from "./user";


export class Task {
  public id: number;
  public title: string;
  public description: string;
  public dueDate: Date;        
  public priority: Priority;
  public status: Status;
  public user: User;           

  constructor() {}
}
