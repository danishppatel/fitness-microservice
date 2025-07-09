# Fitness Microservice Project

This repo contains two services:

- `userservice` — PostgreSQL-based user management
- `activityservice` — MongoDB-based activity tracking

## 🔐 Configuration

Each service has a `application-template.yml` file.  
To run locally:

```bash
# For userservice
cp userservice/src/main/resources/application-template.yml userservice/src/main/resources/application.yml

# For activityservice
cp activityservice/src/main/resources/application-template.yml activityservice/src/main/resources/application.yml
