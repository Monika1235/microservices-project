## Architecture
- This project demonstrates a containerized microservices architecture deployed on an AWS EC2 instance using Docker Compose.
- An Nginx API gateway acts as a reverse proxy to route external client requests to internal microservices.
- The system includes multiple Spring Boot services communicating over a Docker network with MongoDB as the database.
- All services run as independent containers and communicate through REST APIs.
---
### Tech Stack
- Java 17
- Spring Boot
- Maven
- Docker
- Docker Compose
- MongoDB
- AWS S3
---
### Prerequisites
Make sure the following tools are installed before running the project:
- Java 17+
- Maven
- Docker
- Docker Compose
- Git
---
### Setup Instructions
- Connect to EC2
```bash
sudo chmod 400 your-key.pem

sudo ssh -i your-key.pem ubuntu@<EC2-IP>
```
- Create a folder
```bash
mkdir microservices-project
```
- Clone the Repository
 ```bash  
git clone https://github.com/Monika1235/microservices-project.git
cd microservices-project
```
- Configure Environment Variables
  - Create a .env file in the root directory for S3.
```
AWS_ACCESS_KEY_ID=your_access_key
 
AWS_SECRET_ACCESS_KEY=your_secret_key
 
AWS_REGION=your_region
 
AWS_S3_BUCKET=your_bucket_name
```
- Build Services
   
If needed, build each service using Maven.
```bash
mvn clean package
```
- Run the Application with Docker
   
Start all services using Docker Compose.
```bash
sudo docker compose up --build
```
- Access APIs

#### Example Test Endpoints:

- http://13.232.228.36/users

- http://13.232.228.36/tasks

- http://13.232.228.36/files/upload

- http://13.232.228.36/notifications
---
### Logging:
- The Nginx gateway logs incoming requests including:
  - client IP
  - upstream service
  - response time
  - HTTP status
---
### Example Workflow
- User registers through the User Service.
- Tasks are created and managed via the Task Service.
- Files related to tasks are uploaded through the File Service and stored in AWS S3.
- Notifications are sent using the Notification Service.
---
### Challenges faced
- NonExistentPath: Data directory /data/db not found while running mongod server
  -Solution:
  ```bash
  sudo mkdir -p /data/db
  sudo chown -R $USER:$USER /data/db
  ```
- Failed to bind host port for 0.0.0.0:27017 address already in use
  -Solution:
  ```bash
  sudo systemctl stop mongod
  lsof -i :27017
  ```
----
### Future Improvements
- Implement service discovery
- Add centralized logging
- Add CI/CD pipeline using GitHub Actions
- Introduce load balancing across service instances
- Implement event-driven communication using message queues
---
