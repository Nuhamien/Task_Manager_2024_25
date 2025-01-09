// src/tasks/tasks.service.ts
import { Injectable } from '@nestjs/common';
import { Task } from './task.interface'; // Correctly importing Task interface

@Injectable()
export class TasksService {
  private tasks: Task[] = []; // Use Task interface here

  // Returns all tasks
  getAllTasks(): Task[] {
    return this.tasks;
  }

  // Creates a new task
  createTask(taskData: { title: string; description: string }): Task {
    const newTask: Task = {
      // Make sure you're using the Task interface here
      id: Math.random().toString(),
      title: taskData.title,
      description: taskData.description,
    };
    this.tasks.push(newTask);
    return newTask;
  }

  // Deletes a task
  deleteTask(id: string): { message: string } {
    const index = this.tasks.findIndex((task) => task.id === id);
    if (index !== -1) {
      this.tasks.splice(index, 1);
      return { message: 'Task deleted successfully' };
    }
    return { message: 'Task not found' };
  }
}
