# eCommerce Application

This project goal is to add authentication and authorization controls so users can only access their data, and that data can only be accessed in a secure way. 

## Project Template

1. Set template
The template is written in Java using Spring Boot, Hibernate ORM, and the H2 database. 

Included, 5 packages:

* demo - this package contains the main method which runs the application

* model.persistence - this package contains the data models that Hibernate persists to H2. There are 4 models: Cart, for holding a User's items; Item , for defining new items; User, to hold user account information; and UserOrder, to hold information about submitted orders. 

* model.persistence.repositories - these contain a `JpaRepository` interface for each of our models.

* model.requests - this package contains the request models. The request models will be transformed by Jackson from JSON to these models as requests are made. 

* controllers - these contain the api endpoints for our app, 1 per model. 

2. Run Project
Once started, using a REST client, such as Postman, explore the APIs.

Some examples are as below:
To create a new user for example, send a POST request to:
http://localhost:8080/api/user/create with an example body like 

```
{
    "username": "test"
}
```


and this would return
```
{
    "id" 1,
    "username": "test"
}
```

## Adding Authentication and Authorization
Use a combination of usernames and passwords for authentication, as well as JSON Web Tokens (JWT) to handle the authorization.

Implement a password based authentication scheme by hashing, and it's this hash which should be stored. Additionally when viewing their user information, the user's hash should not be returned to them in the response, also add some requirements and validation, as well as a confirm field in the request, to make sure they didn't make a typo. 

1. Add spring security dependencies: 
   * Spring-boot-starter-security
2. JWT does not ship as a part of spring security, add
   * java-jwt dependency
3. Spring Boot ships with an automatically configured security module that must be disabled
4. Create password for the user
5. Implement 4 classes :
   * a subclass of `UsernamePasswordAuthenticationFilter` for taking the username and password from a login request and logging in. This, upon successful authentication, should hand back a valid JWT in the `Authorization` header
   * a subclass of `BasicAuthenticationFilter`. 
   * an implementation of the `UserDetailsService` interface. This should take a username and return a userdetails User instance with the user's username and hashed password.
   *  a subclass of `WebSecurityConfigurerAdapter`. Handles session management and what endpoints are secured. 

Spring's default '/login' endpoint to login example:

```
POST /login 
{
    "username": "test",
    "password": "somepassword"
}
```

and that should, if those are valid credentials, return a 200 OK with an Authorization header which looks like "Bearer <data>" this "Bearer <data>" is a JWT and must be sent as a Authorization header for all other requests. If it's not present, endpoints should return 401 Unauthorized. If it's present and valid, the endpoints should function as normal.

## Testing
Implement unit tests demonstrating at least 80% code coverage.
