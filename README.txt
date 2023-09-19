A web service supporting the operation of a car rental from the perspective of two users.
The backend was created with the Java programming language and the Spring Boot framework.
The graphical user interface was designed using HTML and CSS with the Thymeleaf component.
Login is secured thanks to the Spring Security component.
The database was created in PostgreSQL.

Clients:
- ability to find available cars (filters: model, price per day, registration number, fuel etc.) and book a selected car
- possibility to check the list with booked cars and to return the selected car to the car rental
- ability to view information about the car rental service and to contact with a form

Administrator:
- ability to  search, add, delete and modify available cars
- possibility to search reservations, add a new car rent, archivize, change status or modify selected reservation
- ability to search client, add a new client, modify or delete existing client
- option to search available branches, add a new branch, delete or modify a branch from a list
