Architecture
------------

The application follows a microservices architecture where each service handles a specific responsibility.

Services included:

User Service – Handles user management and authentication.

Task Service – Manages tasks assigned to users.

File Service – Handles file uploads and storage using AWS S3.

Notification Service – Responsible for sending notifications.

MongoDB – Database used by the services.

All services run as independent containers and communicate through REST APIs.

Tech Stack
----------

Java

Spring Boot

Maven

Docker

Docker Compose

MongoDB

AWS S3

Prerequisites
-------------

Make sure the following tools are installed before running the project:

Java 17+

Maven

Docker

Docker Compose

Git

Setup Instructions
------------------

1. Clone the Repository
   
   git clone https://github.com/Monika1235/microservices-project.git

   cd microservices-project

2. Configure Environment Variables
   
 Create a .env file in the root directory for S3.

 WS_ACCESS_KEY_ID=your_access_key
 
 AWS_SECRET_ACCESS_KEY=your_secret_key
 
 AWS_REGION=your_region
 
 AWS_S3_BUCKET=your_bucket_name

3. Build Services
   
 If needed, build each service using Maven.

 mvn clean package

4. Run the Application with Docker
   
   Start all services using Docker Compose.

   docker compose up --build

5. Stop the Application
   
   docker compose down

Service Ports
-------------

User Service	8081

Task Service	8082

File Service	8083

Notification Service	8084

MongoDB	27017

Example Workflow
-----------------

 User registers through the User Service.

 Tasks are created and managed via the Task Service.

 Files related to tasks are uploaded through the File Service and stored in AWS S3.
 
 Notifications are sent using the Notification Service.

Future Improvements
-------------------

 Implement service discovery

 Add centralized logging

 Add CI/CD pipeline using GitHub Actions
