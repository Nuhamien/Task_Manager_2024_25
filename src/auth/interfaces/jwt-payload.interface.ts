// src/auth/interfaces/jwt-payload.interface.ts
export interface JwtPayload {
  username: string; // Username of the user
  sub: string; // User's unique identifier (e.g., userId)
}
