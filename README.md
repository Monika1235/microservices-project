Architecture
------------

This project demonstrates a containerized microservices architecture deployed on an AWS EC2 instance using Docker Compose.

An Nginx API gateway acts as a reverse proxy to route external client requests to internal microservices.

The system includes multiple Spring Boot services communicating over a Docker network with MongoDB as the database.

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

AWS_ACCESS_KEY_ID=your_access_key
 
AWS_SECRET_ACCESS_KEY=your_secret_key
 
AWS_REGION=your_region
 
AWS_S3_BUCKET=your_bucket_name

3. Build Services
   
If needed, build each service using Maven.

mvn clean package

4. Run the Application with Docker
   
Start all services using Docker Compose.

docker compose up --build

5.Access APIs

Example requests:

http://<EC2_PUBLIC_IP>/users

http://<EC2_PUBLIC_IP>/tasks

http://<EC2_PUBLIC_IP>/files/upload

http://<EC2_PUBLIC_IP>/notifications

Logging:
-------

The Nginx gateway logs incoming requests including:

client IP

upstream service

response time

HTTP status

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

 Introduce load balancing across service instances

 Implement event-driven communication using message queues
