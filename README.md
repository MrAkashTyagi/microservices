**Microservices Architecture Project**
A distributed system designed with a microservice-oriented approach, focusing on high scalability and decoupled data management.

**🏗️ Architecture Overview**

The system is partitioned into three core services, each utilizing a specialized database strategy (Polyglot Persistence) to meet specific data requirements.

**1. User Service**
Handles user identity and profile management.
•	Database: MySQL (Relational)
•	Operations:
o	POST /users - Register a new user
o	GET /users/{userId} - Retrieve specific user details
o	GET /users - Fetch all registered users

**2. Hotel Service**
Manages hotel inventory and property details.
•	Database: PostgreSQL (Relational)
•	Operations:
o	POST /hotels - Add a new property
o	GET /hotels/{hotelId} - Get detailed hotel information
o	GET /hotels - List all available hotels

**3. Rating Service**
Manages user-generated reviews and ratings. Optimized for high-frequency writes and flexible schema.
•	Database: MongoDB (NoSQL)
•	Operations:
o	POST /ratings - Submit a new rating
o	GET /ratings/{ratingId} - Get specific rating details
o	GET /ratings - Retrieve all ratings
o	GET /ratings/user/{userId} - Get all ratings submitted by a specific user
o	GET /ratings/hotel/{hotelId} - Get all ratings for a specific hotel 

**🛠️ Tech Stack**
**Service**	**Responsibility**	  **Technology**	**Database**
UserService	  Identity Management	Java/Spring Boot	MySQL
HotelService	Property Management	Java/Spring Boot	PostgreSQL
RatingService	Feedback & Reviews	Java/Spring Boot	MongoDB

