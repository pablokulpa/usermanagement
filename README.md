# usermanagement
 Build app:
 ```bash
mvn clean install
 ```
Run app:

 ```bash
java -jar target/usermanagement-0.0.1-SNAPSHOT.jar
 ```
 
 HTTP POST BODY example url: http://localhost:8080/employees
 
 ```json
{
    "name": "Ala",
    "surname": "Kata",
    "grade": 50,
    "salary": 3000
}
 ```
 
HTTP GET example url: http://localhost:8080/employees/1

HTTP DELETE example url: http://localhost:8080/employees/1

HTTP POST BODY example url: http://localhost:8080/employees/1
 
 ```json
{
    "name": "Ala",
    "surname": "Kataqqqqqqqqw",
    "grade": 50,
    "salary": 3000
}
 ```

HTTP GET BODY  search example url: http://localhost:8080/search

 ```json
{
    "name": "Ala",
    "surname": "Kataqqqqqqqqw"
}
 ```

