# SpringBootAuthenticationExamples
Different examples of Spring Boot REST API's secured with Auth0 connecting to various databases

<br>

All samples are REST API's secured by [Auth0](https://auth0.com/). The only accessible path on these API's are the root path '/' and '/swagger-ui/. A `Authorization` header with your `'Bearer xxx...'` token as a value from Auth0 must be passed into the protected routes, or else a HTTP 401 occurs. Reference this [link](https://auth0.com/blog/spring-boot-authorization-tutorial-secure-an-api-java/) for more information. These samples can be ran locally or deployed, both containerized and non containerized. Seed data is included under the `database` directory in the projects. These were created and used with Maven in mind. Run `mvn clean package` and `mvn spring-boot:run` in the directory of the `pom.xml` to start.

<br>

#### Swagger
All examples have [Swagger](https://swagger.io/) v3.0.0 implemented. The UI can be accessed from the '/swagger-ui/' path. For example, localhost:8080/swagger-ui/.

<br>

### MongoDB Example
The MongoDB example under the `springbootauth0mongodb` directory is a Spring Boot project which has the option to connect to a locally running MongoDB instance as well as a connection URI example to connect to Mongo Atlas.

#### Routes
- <b>'/'</b> - Home route
- <b>'/find_all_inventory'</b> - A `GET` request. Get all inventory within the collection specified 
- <b>'/inventory/{id}'</b> - A `GET` request. Finds an item by ID. Pass in the ID of a specific item to retrieve it's information. 
- <b>'/add_inventory'</b> - A `POST` request. Accepts a JSON object with proper fields to add an item to the collection.
- <b>'/delete_inventory/{id}'</b> - A `DELETE` request. Accepts the ID passed into the URL of a known item to delete from the collection.
- <b>'/update_inventory/{id}'</b> - A `PUT` request. Accepts the ID passed into the URL of a known item to update the item.

<br>
<br>

### MySQL Example
The MySQL example under the `springbootauth0mysql` directory is a Spring Boot project which has the option to connect to a locally running MySQL instance as well as a connection URI example to connect to Azure Database for MySQL.

#### Routes
- <b>'/'</b> - Home route
- <b>'/get_todo'</b> - A `GET` request. Get all todos.
- <b>'/todo/{id}'</b> - A `GET` request. Find a todo by ID passed into the URL
- <b>'/add_todo'</b> - A `POST` request. Accepts a JSON object with the proper fields to add an new todo.
- <b>'/delete_todo/{id}'</b> - A `DELETE` request. Accepts the ID passed into the URL of a known todo.
- <b>'/update_todo/{id}'</b> - A `PUT` request. Accepts the ID passed into the URL of a known todo to update the todo.

<br>
<br>

### PostgreSQL Example
The PostgreSQL example under the `springbootauth0postgres` directory is a Spring Boot project which has the option to connect to a locally running MySQL instance as well as a connection URI example to connect to Azure Database for MySQL.

#### Routes
- <b>'/'</b> - Home route
- <b>'/all_listings'</b> - A `GET` request. Get all AirBNB listings.
- <b>'/find_by_id/{id}'</b> - A `GET` request. Find a AirBNB listing by ID passed into the URL.
- <b>'/add_listing'</b> - A `POST` request. Accepts a JSON object with the proper fields to add an new AirBNB listing.
- <b>'/update_listing/{id}'</b> - A `PUT` request. Accepts the ID passed into the URL of a known AirBNB listing to update the listing.
- <b>'/delete_listing/{id}'</b> - A `DELETE` request. Accepts the ID passed into the URL of a known AirBNB listing to delete the listing.
