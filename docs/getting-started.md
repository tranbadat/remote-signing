# Starting the project

The following was discovered as part of building this project:

* No Docker Compose services found. As of now, the application won't start! Please add at least one service to
  the `compose.yaml` file.

# Getting Started

### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/tranbadat/remote-signing.git
cd remote-signing

```
### **2️⃣ Set Up Dependencies**
Make sure the following tools are installed on your system:
- **Java 17**: For running the Spring Boot application.
- **Maven**: To manage dependencies and build the project.
- **Docker**: Required for running services like Keycloak, Redis, and Kafka.

---

### **3️⃣ Configure the Environment**
Create an `.env` file or export the following environment variables: 

### **2️⃣ Set Up Dependencies**
Make sure the following tools are installed on your system:
- Java 17 (for running the Spring Boot application)
- Maven (to manage dependencies and build the project)
- Docker (required for running services like Keycloak, Redis, and Kafka)
---
### **3️⃣ Configure the Environment**
Set up the following environment variables in an `.env` file or directly in your system:
**Keycloak Configuration**
```plaintext
KEYCLOAK_URL=http://localhost:8080
KEYCLOAK_CLIENT_ID=your-client-id
KEYCLOAK_SECRET=your-client-secret
```
**Redis Configuration**
```plaintext
REDIS_URL=redis://localhost:6379
```

**Kafka Configuration**
```plaintext
- KAFKA_BOOTSTRAP_SERVERS=localhost:9092
```

**Database Configuration**
```plaintext
DB_URL=jdbc:postgresql://localhost:5432/your-database
DB_USERNAME=your-username
DB_PASSWORD=your-password
```
---

### **4️⃣ Run the Application**
To start the application, use the following Maven command:  
`gradlew bootRun`

---

### **5️⃣ Access the API Documentation**
Once the application is running, open your web browser and navigate to:  
`http://localhost:8080/swagger-ui/`

Here, you can explore and test the available API endpoints.

---
