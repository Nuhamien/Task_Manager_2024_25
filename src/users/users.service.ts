import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { User } from './user.entity';

@Injectable()
export class UsersService {
  constructor(
    @InjectRepository(User)
    private userRepository: Repository<User>,
  ) {}

  // Method to find a user by ID
  async findOne(id: number): Promise<User> {
    return this.userRepository.findOne({ where: { id } });
  }

  // Add more methods if needed for user management
}
