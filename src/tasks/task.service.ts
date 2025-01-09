import { Injectable, HttpException, HttpStatus } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { Task } from './task.entity';
import { CreateTaskDto } from './dto/create-task.dto';
import { UpdateTaskDto } from './dto/update-task.dto';
import { UsersService } from '../users/users.service';

@Injectable()
export class TaskService {
  constructor(
    @InjectRepository(Task)
    private taskRepository: Repository<Task>,
    private usersService: UsersService,
  ) {}

  async create(createTaskDto: CreateTaskDto, userId: number): Promise<Task> {
    const user = await this.usersService.findOne(userId);
    if (!user) throw new HttpException('User not found', HttpStatus.NOT_FOUND);

    const task = this.taskRepository.create({
      ...createTaskDto,
      user,
    });
    return this.taskRepository.save(task);
  }

  async findAll(userId: number): Promise<Task[]> {
    const user = await this.usersService.findOne(userId);
    if (!user) throw new HttpException('User not found', HttpStatus.NOT_FOUND);
    return this.taskRepository.find({ where: { user } });
  }

  async findOne(id: number, userId: number): Promise<Task> {
    const user = await this.usersService.findOne(userId);
    if (!user) throw new HttpException('User not found', HttpStatus.NOT_FOUND);
    const task = await this.taskRepository.findOne({ where: { id, user } });
    if (!task) throw new HttpException('Task not found', HttpStatus.NOT_FOUND);
    return task;
  }

  async update(id: number, updateTaskDto: UpdateTaskDto, userId: number): Promise<Task> {
    const user = await this.usersService.findOne(userId);
    if (!user) throw new HttpException('User not found', HttpStatus.NOT_FOUND);

    const task = await this.taskRepository.findOne({ where: { id, user } });
    if (!task) throw new HttpException('Task not found', HttpStatus.NOT_FOUND);

    Object.assign(task, updateTaskDto);
    return this.taskRepository.save(task);
  }

  async remove(id: number, userId: number): Promise<void> {
    const user = await this.usersService.findOne(userId);
    if (!user) throw new HttpException('User not found', HttpStatus.NOT_FOUND);

    const task = await this.taskRepository.findOne({ where: { id, user } });
    if (!task) throw new HttpException('Task not found', HttpStatus.NOT_FOUND);

    await this.taskRepository.remove(task);
  }
}
