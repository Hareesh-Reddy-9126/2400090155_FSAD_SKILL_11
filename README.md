FSAD (Full Stack Application Development) – Course Submission

This repository contains Skill/Experiment projects for the FSAD (Full Stack Application Development) course. Each skill demonstrates different backend development concepts using Java, Maven, Hibernate, Spring Framework, and Spring Boot.

Tech Stack

Java (JDK 17 recommended)

Maven 3.x

MySQL (required for Hibernate-based skills)

Spring Framework (Core DI & Autowiring)

Spring Boot (Web MVC)

VS Code / Spring Tool Suite

How to Run
Skill 1 – Basic Maven / Hello World

Folder: skill-1/

Build:

mvn -f skill-1/pom.xml clean package

Run:

java -cp skill-1\target\classes Main
Skill 2 – Hibernate CRUD (Product)

Folder: skill-2/

This module demonstrates CRUD operations using Hibernate ORM.
Database configuration is stored in:

src/main/resources/hibernate.cfg.xml

Update the MySQL URL, username, and password before running.

Build:

mvn -f skill-2/pom.xml clean test

Run:

mvn -f skill-2/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.App"
Skill 3 – Hibernate HQL Demo

Folder: skill-3/

This module demonstrates HQL queries including sorting, pagination, filtering, and aggregate functions.

Database configuration:

src/main/resources/hibernate.cfg.xml

Build:

mvn -f skill-3/pom.xml clean test

Run:

mvn -f skill-3/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.demo.ProductHqlDemo"
Skill 4 – Spring Core Dependency Injection

Folder: skill-4/

This module demonstrates Spring Dependency Injection using XML configuration and Java-based configuration.

Features demonstrated:

Constructor Injection

Setter Injection

XML Configuration

Annotation-based Configuration

Build:

mvn -f skill-4/pom.xml clean test

Run XML configuration demo:

mvn -f skill-4/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.XmlConfigMain"

Run annotation configuration demo:

mvn -f skill-4/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.AnnotationConfigMain"
Skill 5 – Spring Autowiring (@Component + @Autowired)

Folder: skill-5/

This module demonstrates Spring Autowiring using @Component and @Autowired where the Certification object is automatically injected into the Student object by the Spring IoC container.

Expected output example:

Student{id=101, name='Hareesh', gender='Male', certification=Certification{id=501, name='Spring Professional', dateOfCompletion='10-01-2026'}}

Build:

mvn -f skill-5/pom.xml clean test

Run:

mvn -f skill-5/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.MainApp"
Skill 6 – Spring Boot MVC Web Request Handling

Folder: skill-6/

This module demonstrates Spring Boot REST APIs using Spring MVC annotations.

Concepts demonstrated:

@RestController

@GetMapping

@PostMapping

@PathVariable

@RequestParam

@RequestBody

In-memory data storage

Endpoints implemented:

Endpoint	Description
/welcome	Returns welcome message
/count	Returns total number of books
/price	Returns sample book price
/books	Returns list of book titles
/books/{id}	Returns book details using path variable
/search?title=	Searches book by title
/author/{name}	Returns books by author
/addbook	Adds a book using POST request
/viewbooks	Returns all stored books

Run the Spring Boot application:

mvn -f skill-6/pom.xml spring-boot:run

Application runs at:

http://localhost:8081

Example:

http://localhost:8081/welcome
Repository Structure
skill-1/
skill-2/
skill-3/
skill-4/
skill-5/
skill-6/

Each folder contains an independent Maven project demonstrating a specific FSAD concept.

Author

GURRALA HAREESH REDDY
ID: 2400090155
Course: Full Stack Application Development (FSAD)
