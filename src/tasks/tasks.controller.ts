import { Controller, Get, Post, Body, Param, Delete, Patch, UseGuards, Req, HttpException, HttpStatus} from '@nestjs/common';
import { TaskService } from './task.service';
import { Task } from './task.entity';
import { CreateTaskDto } from './dto/create-task.dto';
import { UpdateTaskDto } from './dto/update-task.dto';
import { JwtAuthGuard } from '../auth/jwt-auth.guard';
import { Request } from 'express';

@Controller('tasks')
export class TasksController {
  constructor(private readonly taskService: TaskService) {}

  // Get all tasks for the authenticated user
  @UseGuards(JwtAuthGuard)
  @Get()
  async getAllTasks(@Req() request: Request): Promise<Task[]> {
    const user = request.user;
    console.log(`hello:${user}`);
    if (!user) {
      throw new HttpException('Unauorized', HttpStatus.UNAUTHORIZED);
    }
    return this.taskService.findAll(user['id']);
  }

  // Create a new task for the authenticated user
  @UseGuards(JwtAuthGuard)
  @Post()
  async createTask(@Body() createTaskDto: CreateTaskDto, @Req() req: Request): Promise<Task> {
    const userId = req.user?.id;
    console.log(`user${req.user.sub}`);
    if (!userId) {
      throw new HttpException('Unauthorized', HttpStatus.UNAUTHORIZED);
    }
    return this.taskService.create(createTaskDto, userId);
  }

  // Get a specific task by ID for the authenticated user
  @UseGuards(JwtAuthGuard)
  @Get(':id')
  async getTask(@Param('id') id: number, @Req() req: Request): Promise<Task> {
    const userId = req.user?.id;
    if (!userId) {
      throw new HttpException('Unauthorized', HttpStatus.UNAUTHORIZED);
    }
    return this.taskService.findOne(id, userId);
  }

  // Update an existing task for the authenticated user
  @UseGuards(JwtAuthGuard)
  @Patch(':id')
  async updateTask(@Param('id') id: number, @Body() updateTaskDto: UpdateTaskDto, @Req() req: Request): Promise<Task> {
    const userId = req.user?.['id'];
    if (!userId) {
      throw new HttpException('Unauthorized', HttpStatus.UNAUTHORIZED);
    }
    return this.taskService.update(id, updateTaskDto, userId);
  }

  // Delete a task by ID for the authenticated user
  @UseGuards(JwtAuthGuard)
  @Delete(':id')
  async deleteTask(@Param('id') id: number, @Req() req: Request): Promise<{ message: string }> {
    const userId = req.user?.['id'];
    if (!userId) {
      throw new HttpException('Unauthorized', HttpStatus.UNAUTHORIZED);
    }
    await this.taskService.remove(id, userId);
    return { message: 'Task deleted successfully' };
  }
}
