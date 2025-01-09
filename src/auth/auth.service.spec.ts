import { Injectable } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';
import * as bcrypt from 'bcrypt';
import { JwtPayload } from './interfaces/jwt-payload.interface';
import { LoginDto } from './dto/login.dto';
import { UnauthorizedException } from '@nestjs/common';
import { User } from '../users/user.entity';

@Injectable()
export class AuthService {
  constructor(private jwtService: JwtService) {}

  // In-memory user storage (for simulation purposes)
  private users: User[] = [];

  // Only login method, no registration needed anymore
  async login(loginDto: LoginDto): Promise<{ access_token: string }> {
    const { username, password } = loginDto;

    // Check if the user exists
    const user = this.users.find(user => user.username === username);
    if (!user) {
      throw new UnauthorizedException('Invalid credentials');
    }

    // Check if password is correct
    const isPasswordValid = await bcrypt.compare(password, user.password);
    if (!isPasswordValid) {
      throw new UnauthorizedException('Invalid credentials');
    }

    // Create and sign the JWT token
    const payload: JwtPayload = {
      username: user.username,
      sub: String(user.id),
    };
    return { access_token: this.jwtService.sign(payload, { secret: process.env.JWT_SECRET || 'your-secret-key' }) };
  }

  // This method is for validating the user in the JWT payload
  async validateUser(payload: JwtPayload): Promise<User | null> {
    const user = this.users.find(user => user.username === payload.username || user.id.toString() === payload.sub);
    if (!user) {
      return null;
    }
    const { password, ...safeUser } = user;
    return safeUser as User; // Return user excluding password
  }
}
