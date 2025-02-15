# Training Center Registry API

## Overview
This project is an MVP for a registry of government-funded training centers. It is developed using **Spring Boot** and **MongoDB** to store training center information. The API allows users to **add** and **retrieve** training center details with validation and filtering features.

## Tech Stack
- **Backend:** Spring Boot (Java)
- **Database:** MongoDB
- **ORM:** Spring Data MongoDB
- **Validation:** Spring Boot Annotations
- **Exception Handling:** Global Exception Handler
- **Build Tool:** Maven

## Prerequisites
- Java 17+
- Maven 3+
- MongoDB (Local or Cloud)

## Installation & Setup
1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd training_center_registry
   ```
2. **Configure MongoDB:** Update the database connection details in `application.properties`:
   ```properties
   spring.data.mongodb.uri=<your-mongodb-connection-string>
   spring.data.mongodb.database=trainingCentersRegistry
   ```
3. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```
   The application will start on `http://localhost:8080`

## API Endpoints
### 1. Create a Training Center
**Endpoint:** `POST /api/training-centers`

**Request Body:**
```json
{
  "centerName": "Tech Training Hub",
  "centerCode": "ABC123XYZ456",
  "address": {
    "detailedAddress": "123, Main Road",
    "city": "Mumbai",
    "state": "Maharashtra",
    "pincode": "400001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Python"],
  "contactEmail": "info@techtraining.com",
  "contactPhone": "9876543210"
}
```

**Validations:**
- `centerName`: Required, max 40 characters
- `centerCode`: Required, exactly 12 alphanumeric characters
- `address`: Required (includes city, state, pincode)
- `pincode`: 6-digit valid Indian postal code
- `contactEmail`: Must be a valid email format
- `contactPhone`: 10-digit valid phone number

**Response:**
```json
{
  "id": "65abc123456d789",
  "centerName": "Tech Training Hub",
  "centerCode": "ABC123XYZ456",
  "address": {
    "detailedAddress": "123, Main Road",
    "city": "Mumbai",
    "state": "Maharashtra",
    "pincode": "400001"
  },
  "studentCapacity": 100,
  "coursesOffered": ["Java", "Python"],
  "createdOn": "1700000000",
  "contactEmail": "info@techtraining.com",
  "contactPhone": "9876543210"
}
```

### 2. Get All Training Centers
**Endpoint:** `GET /api/training-centers`

**Response:**
```json
[
  {
    "id": "65abc123456d789",
    "centerName": "Tech Training Hub",
    "centerCode": "ABC123XYZ456",
    "address": {
      "detailedAddress": "123, Main Road",
      "city": "Mumbai",
      "state": "Maharashtra",
      "pincode": "400001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Python"],
    "createdOn": "1700000000",
    "contactEmail": "info@techtraining.com",
    "contactPhone": "9876543210"
  }
]
```

### 3. Filter Training Centers
**Endpoint:** `GET /api/training-centers?city=Mumbai&state=Maharashtra&course=Java`

**Response:**
```json
[
  {
    "id": "65abc123456d789",
    "centerName": "Tech Training Hub",
    "centerCode": "ABC123XYZ456",
    "address": {
      "detailedAddress": "123, Main Road",
      "city": "Mumbai",
      "state": "Maharashtra",
      "pincode": "400001"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Python"],
    "createdOn": "1700000000",
    "contactEmail": "info@techtraining.com",
    "contactPhone": "9876543210"
  }
]
```

## Error Handling
- **Validation Error:**
  ```json
  {
    "errorMsg": "Validation failed",
    "errorDetail": {
      "centerCode": "Center code must be exactly 12 characters"
    }
  }
  ```
- **Duplicate Entry (Center Code Conflict):**
  ```json
  {
    "errorMsg": "Data Conflict",
    "errorDetail": "A record with this key already exists"
  }
  ```
- **Unexpected Server Error:**
  ```json
  {
    "errorMsg": "An unexpected error occurred",
    "errorDetail": "Internal Server Error"
  }
  ```

## Running API Tests in Postman
1. **Import API collection into Postman.**
2. **Start the Spring Boot application.**
3. **Run the requests:**
    - `POST /api/training-centers` → Add training center
    - `GET /api/training-centers` → Fetch all centers
    - `GET /api/training-centers?city=Delhi` → Fetch filtered centers

    
## Conclusion
This MVP successfully implements a functional training center registry with validation, filtering, and proper error handling. Further improvements could include authentication, pagination, and advanced search features.
