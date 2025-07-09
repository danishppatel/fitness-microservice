# Fitness Microservice Project

This repo contains two services:

- `userservice` — PostgreSQL-based user management
- `activityservice` — MongoDB-based activity tracking

## 🔐 Configuration
Copy `application-template.yml` to `application.yml` and fill in your local config.

```bash
# For userservice
cp userservice/src/main/resources/application-template.yml userservice/src/main/resources/application.yml

# For activityservice
cp activityservice/src/main/resources/application-template.yml activityservice/src/main/resources/application.yml

# For eureka
cp eureka/src/main/resources/application-template.yml eureka/src/main/resources/application.yml
