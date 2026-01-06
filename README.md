# TP-24 : Conteneurisation d'une Application Spring Boot + Angular

## 📋 Description

Ce projet démontre la **conteneurisation** d'une application full-stack composée d'un backend **Spring Boot** et d'un frontend **Angular** avec **Docker** et **Docker Compose**.

## 🏠 Application : Smart Home

L'application **Smart Home** permet de gérer une maison intelligente :
- Gestion des pièces (Rooms)
- Gestion des appareils connectés (Devices)
- Interface utilisateur moderne avec Angular

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                     Docker Compose                           │
├─────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────┐ │
│  │   Angular App   │  │  Spring Boot    │  │   MySQL     │ │
│  │   (Port 4200)   │──│   (Port 8080)   │──│  (Port 3306)│ │
│  │    Frontend     │  │    Backend      │  │  Database   │ │
│  └─────────────────┘  └─────────────────┘  └─────────────┘ │
└─────────────────────────────────────────────────────────────┘
```

## 🛠️ Technologies Utilisées

### Backend
| Technologie | Description |
|-------------|-------------|
| Java 17+ | Langage de programmation |
| Spring Boot 3.x | Framework REST API |
| Spring Data JPA | Persistance des données |
| MySQL | Base de données |

### Frontend
| Technologie | Description |
|-------------|-------------|
| Angular 16+ | Framework frontend |
| TypeScript | Langage typé |
| Tailwind CSS | Framework CSS |

### DevOps
| Technologie | Description |
|-------------|-------------|
| Docker | Conteneurisation |
| Docker Compose | Orchestration |
| Nginx | Serveur web frontend |

## 📁 Structure du Projet

```
TP-24-Ilyas/
├── docker-compose.yml      # Orchestration des conteneurs
├── .env                    # Variables d'environnement
├── Smart_Home_back/        # Backend Spring Boot
│   ├── Dockerfile
│   ├── src/
│   └── pom.xml
└── smartHome-front/        # Frontend Angular
    ├── Dockerfile
    ├── src/
    └── package.json
```

## 🐳 Fichiers Docker

### Dockerfile Backend

```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Dockerfile Frontend

```dockerfile
FROM node:18 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

FROM nginx:alpine
COPY --from=build /app/dist/* /usr/share/nginx/html/
EXPOSE 80
```

### docker-compose.yml

```yaml
version: '3.8'
services:
  mysql:
    image: mysql:8.0
    environment:
      MYSQL_DATABASE: smarthome
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"

  backend:
    build: ./Smart_Home_back
    ports:
      - "8080:8080"
    depends_on:
      - mysql

  frontend:
    build: ./smartHome-front
    ports:
      - "4200:80"
    depends_on:
      - backend
```

## 🚀 Démarrage

### Avec Docker Compose

```bash
# Build et démarrage
docker-compose up --build

# En arrière-plan
docker-compose up -d --build

# Arrêt
docker-compose down
```

### Sans Docker

```bash
# Backend
cd Smart_Home_back
mvn spring-boot:run

# Frontend
cd smartHome-front
npm install
ng serve
```

## 🌐 Points d'Accès

| Service | URL |
|---------|-----|
| Frontend Angular | http://localhost:4200 |
| Backend API | http://localhost:8080 |
| MySQL | localhost:3306 |

## 📡 API Endpoints

```bash
# Rooms
GET    /api/rooms
GET    /api/rooms/{id}
POST   /api/rooms
PUT    /api/rooms/{id}
DELETE /api/rooms/{id}

# Devices
GET    /api/devices
GET    /api/devices/{id}
POST   /api/devices
PUT    /api/devices/{id}
DELETE /api/devices/{id}
```

## ✨ Fonctionnalités

- ✅ Conteneurisation multi-stage
- ✅ Orchestration avec Docker Compose
- ✅ Persistance MySQL
- ✅ API REST complète
- ✅ Interface Angular moderne

## 👨‍💻 Auteur

**Ilyas MICHICH**

---
*Travail Pratique - Conteneurisation Full-Stack*
