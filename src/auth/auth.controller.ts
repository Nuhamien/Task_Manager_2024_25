import { Controller, Post, Body } from '@nestjs/common';
import { AuthService } from './auth.service';

@Controller('auth')
export class AuthController {
  constructor(private readonly authService: AuthService) {}

  // Route to handle user login
  @Post('login')
  async login(@Body() loginDto: { username: string; password: string }) {
    return this.authService.login(loginDto); // Call AuthService to generate JWT
  }

  // Route to handle user registration
  @Post('register')
  async register(@Body() registerDto: { username: string; password: string }) {
    return this.authService.register(registerDto); // Call AuthService to register a user
  }
}
