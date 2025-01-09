import { Injectable } from '@nestjs/common';
import { JwtService } from '@nestjs/jwt';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import * as bcrypt from 'bcrypt';
import { User } from '../users/user.entity'; // Ensure this path is correct

@Injectable()
export class AuthService {
  constructor(
    private readonly jwtService: JwtService, // Inject JwtService
    @InjectRepository(User) // Inject the User repository
    private readonly userRepository: Repository<User>,
  ) {}

  async login(loginDto: { username: string; password: string }) {
    const { username, password } = loginDto;
  
    const user = await this.userRepository.findOne({ where: { username } });
    if (!user) {
      throw new Error('Invalid credentials');
    }
  
    const isPasswordValid = await bcrypt.compare(password, user.password);
    if (!isPasswordValid) {
      throw new Error('Invalid credentials');
    }
  
    // Include the user's ID in the JWT payload
    const payload = { username: user.username, id: user.id }; // Add user.id
    const accessToken = this.jwtService.sign(payload);
  
    return { access_token: accessToken };
  }
  

  async register(registerDto: { username: string; password: string }) {
    const { username, password } = registerDto;

    const existingUser = await this.userRepository.findOne({ where: { username } });
    if (existingUser) {
      throw new Error('Username already exists');
    }

    const hashedPassword = await bcrypt.hash(password, 10);
    const newUser = this.userRepository.create({ username, password: hashedPassword });

    await this.userRepository.save(newUser);

    return { message: 'User registered successfully' };
  }
}
