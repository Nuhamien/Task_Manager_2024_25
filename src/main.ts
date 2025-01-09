import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);

  // Disable CORS
  app.enableCors({
    origin: true, // No origins are allowed
  });

  await app.listen(process.env.PORT ?? 3000);
}

bootstrap();
