### **Kameleoon trial task project.**

Project created with Java 8, Spring Boot and H2 in-memory database. Database migrations are done with Flyway support.

The project runs on Localhost 8080 port by default.

H2 database console can be accessed via link: **http://localhost:8080/h2-console**

Login credentials for H2 database are:
 - JDBC url: jdbc:h2:mem:backdb
 - Login: **sa**
 - Password: **password**
 
For more comfortable testing of REST services swagger support provided and can be accessed via link: **http://localhost:8080/swagger-ui.html#**
 
Features that are covered in this project:

##### **Registration controller:**
  - **/api/v1/registration/save/user**: allows to register new user. POST Method.
  
##### **User controller:** 
  - **/api/v1/users/get/{userId}**: allows to get information about specific user by passing his Id. GET Method.
  
##### **Quote controller:**
  - **/api/v1/quotes/save/quote**: allows to create new quote and link it to user. **POST** Method.
  - **/api/v1/quotes/edit/{quoteId}**: allows to edit existing quote by passing it's Id and new qoute's content. **PUT** Method.
  - **/api/v1/quotes/delete/{quoteId}**: allows to delete existing quote by passing it's Id. **DELETE** Method.
  - **/api/v1/quotes/get/{quoteId}**: allows to view specific quote's information by passing quote Id. **GET** Method.
  - **/api/v1/quotes/get/user/{userId}**: allows to get list of specific user quotes by passing user Id. **GET** Method.
  - **/api/v1/quotes/get/random**: allows to view random quote from all quotes that are posted. **GET** Method.
  - **/api/v1/quotes/get/random/{userId}**: allows to view random quote from specific user by passing user Id. **GET** Method.
  - **/api/v1/quotes/get/top/{limit}**: allows to get number of most upvoted quotes, the number of returned quotes is flexible and controlled by input limit parameter. **GET** Method.
  - **/api/v1/quotes/get/flop/{limit}**: allows to get number of most disliked quotes, output number also controlled by limit parameter. **GET** Method.
  - **/api/v1/quotes/get/top/{userId}/{limit}**: allows to get flexible number of most upvoted quotes from specific user. Input parameters are: user Id and limit. **GET** Method.
  - **/api/v1/quotes/get/flop/{userId}/{limit}**: allows to get flexible number of most disliked quotes from specific user. Input parameters are: user Id and limit. **GET** Method.
  
##### **Vote controller:**
  - **/api/v1/votes/save/vote**: allows to create vote and link it to specific user and specific quote. **POST** Method.
  - **/api/v1/votes/get/{voteId}**: allows to view specific vote by passing it's Id. **GET** Method.
  - **/api/v1/votes/get/user/{userId}**: allows to get all votes from specific user. Input parameter is userId. **GET** Method.
  - **/api/v1/votes/get/graph/{quoteId}**: allows to see evolution of votes over time for a specific quote. Input parameter is quote Id. **GET** Method.
  
To run this project you can use **docker-compose.yml** file and **$ Docker compose up** command.
If running from IDE please use these environment variables:
  - **H2_NAME**: **backdb**
  - **H2_USER**: **sa**
  - **H2_PASSWORD**: **password** 