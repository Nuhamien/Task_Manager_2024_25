// src/types/express.d.ts

import { User } from '../auth/user.entity'; // Or your user entity path

declare global {
  namespace Express {
    interface Request {
      user?: User; // Add the `user` property to the Request interface
    }
  }
}
