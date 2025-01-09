import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { TaskService } from './task.service';
import { Task } from './task.entity';
import { UsersModule } from '../users/users.module'; // Import UsersModule to access UserService and UserRepository
import { TasksController } from './tasks.controller';
import { JwtModule } from '@nestjs/jwt'; // Import JwtModule
import { JwtAuthGuard } from '../auth/jwt-auth.guard'; // Import JwtAuthGuard if needed

@Module({
  imports: [
    TypeOrmModule.forFeature([Task]), // Task repository
    UsersModule, // Import UsersModule to access User repository and UserService
    JwtModule.register({
      secret: 'your-secret-key', // Replace with a proper secret
      signOptions: { expiresIn: '1h' }, // Set the expiration time for the JWT
    }), // Make JwtService available in the module
  ],
  providers: [TaskService, JwtAuthGuard], // Add JwtAuthGuard to providers if needed
  controllers: [TasksController],
})
export class TasksModule {}
