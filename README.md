🚀 FSAD Lab Experiments
Full Stack Application Development (Course Repository)
<p align="center"> <img src="https://img.shields.io/badge/Java-17-orange" /> <img src="https://img.shields.io/badge/Maven-Build-red" /> <img src="https://img.shields.io/badge/Hibernate-ORM-yellow" /> <img src="https://img.shields.io/badge/Spring-Core-green" /> <img src="https://img.shields.io/badge/Spring-Boot-brightgreen" /> </p> <p align="center"> Repository containing laboratory experiments for the <b>Full Stack Application Development (FSAD)</b> course. </p>
📘 About This Repository

This repository contains six skill-based experiments implemented using modern Java backend technologies.

Each experiment demonstrates important backend concepts such as:

Version Control using Git

ORM using Hibernate

Querying using HQL

Spring Dependency Injection

Spring Autowiring

Spring Boot REST APIs

All projects are built using Maven and organized in a modular structure.

🛠 Technology Stack
Technology	Purpose
Java 17	Core programming language
Maven	Build and dependency management
Hibernate ORM	Object Relational Mapping
Spring Framework	Dependency Injection & Autowiring
Spring Boot	REST API development
MySQL	Database for Hibernate experiments
VS Code / STS	Development environments
📂 Repository Structure
skill-1   → Git Version Control Demo
skill-2   → Hibernate CRUD Operations
skill-3   → Hibernate HQL Queries
skill-4   → Spring Dependency Injection
skill-5   → Spring Autowiring (@Autowired)
skill-6   → Spring Boot MVC Web Request Handling

Each folder contains an independent Maven project.

🧪 Experiment Overview
Skill	Experiment	Key Concepts
Skill-1	Git Version Control	Git workflow, commits, branching
Skill-2	Hibernate CRUD	ORM mapping, insert/update/delete
Skill-3	Hibernate HQL	Sorting, pagination, aggregate queries
Skill-4	Spring Dependency Injection	Constructor & Setter Injection
Skill-5	Spring Autowiring	@Component and @Autowired
Skill-6	Spring Boot MVC	REST APIs, request handling
⚙️ Running the Projects
🧩 Skill-1 – Basic Maven Project
mvn -f skill-1/pom.xml clean package
java -cp skill-1/target/classes Main
🧩 Skill-2 – Hibernate CRUD

Before running, update database credentials in:

skill-2/src/main/resources/hibernate.cfg.xml

Run:

mvn -f skill-2/pom.xml clean test
🧩 Skill-3 – Hibernate HQL
mvn -f skill-3/pom.xml clean test
🧩 Skill-4 – Spring Dependency Injection

Run XML configuration demo:

mvn -f skill-4/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.XmlConfigMain"

Run annotation configuration demo:

mvn -f skill-4/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.AnnotationConfigMain"
🧩 Skill-5 – Spring Autowiring
mvn -f skill-5/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.MainApp"

Example Output:

Student{id=101, name='Hareesh', gender='Male', certification=Certification{...}}
🧩 Skill-6 – Spring Boot MVC

Start the Spring Boot application:

mvn -f skill-6/pom.xml spring-boot:run

Application runs at:

http://localhost:8081

Example endpoints:

/welcome
/books
/books/{id}
/search?title=Java
/author/{name}
/addbook
/viewbooks
🌐 Example API Endpoints
Endpoint	Method	Description
/welcome	GET	Welcome message
/count	GET	Returns book count
/price	GET	Returns book price
/books	GET	List of book titles
/books/{id}	GET	Book details
/search?title=	GET	Search books
/author/{name}	GET	Author information
/addbook	POST	Add a new book
/viewbooks	GET	View all books
🎯 Learning Outcomes

By completing these experiments, the following concepts were practiced:

Git repository management

Hibernate ORM and CRUD operations

Advanced queries using HQL

Spring Dependency Injection

Spring Autowiring

REST API development using Spring Boot

Web request handling using MVC architecture

👨‍💻 Author

GURRALA HAREESH REDDY
ID: 2400090155
Course: Full Stack Application Development (FSAD)

⭐ Purpose

This repository was created for academic laboratory submission and demonstrates practical implementation of Java enterprise development frameworks.
