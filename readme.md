#Table of contents
* [Recruit task for sonalake](#recruit-task-for-sonalake)
* [Technologies](#technologies)
* [Setup](#setup)
* [Api usage](#api-usage)

##Recruit task for sonalake


##Technologies
* Spring Boot
* Lombok
* Postgresql
* Swagger
##Setup
1. Create database:
    ```
    docker-compose up -d
    ```
2. Running tests:
    ```
    ./gradlew test
    ```
3. Build project using gradle:
    ```
    ./gradlew clean build
    ```
4. Run backend:
    ```
    java -jar build/libs/zadanie_kalkulator_s-0.0.1-SNAPSHOT.jar 
    ```
##Api usage
###Get All countries - endpoint providing list of countries.

```GET - http://localhost:8080/api/countries ```

####Responses:

Code 200:
```json
[
  {
    "id": 0,
    "isoCode": "string"
  }
]

```
###Create Offer - endpoint providing creation of offer, which are also stored in the system.
```
POST - http://localhost:8080/api/offers?country={countryId}
```
Body
```json
{
  "dailyPayment": 0
}
```
####Response:
```json
{
  "countryCode": "string",
  "monthPayment": 0
}
```
### Swagger
Api is also described in Swagger:

http://localhost:8080/swagger-ui.html

You can use swagger only after running the server.
