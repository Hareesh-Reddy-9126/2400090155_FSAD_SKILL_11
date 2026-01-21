# FSAD (Full Stack Application Development) – Course Submission

This repository contains Skill/Experiment projects for the FSAD course.

## Tech Stack
- Java (JDK 17 recommended)
- Maven 3.x
- MySQL (only required for Hibernate-based skills)
- Spring Framework (skills 4 and 5)

## How to Run

### Skill 1 – Basic Maven / Hello World
Folder: `skill-1/`

- Build:
	- `mvn -f skill-1/pom.xml clean package`
- Run:
	- `java -cp skill-1\target\classes Main`

### Skill 2 – Hibernate CRUD (Product)
Folder: `skill-2/`

This module uses Hibernate and reads DB settings from `src/main/resources/hibernate.cfg.xml`.
Update the URL/username/password in that file to match your local MySQL setup.

- Build:
	- `mvn -f skill-2/pom.xml clean test`
- Run (PowerShell-safe):
	- `mvn -f skill-2/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.App"`

### Skill 3 – Hibernate HQL Demo
Folder: `skill-3/`

This module uses Hibernate HQL and reads DB settings from `src/main/resources/hibernate.cfg.xml`.
Update the URL/username/password in that file to match your local MySQL setup.

- Build:
	- `mvn -f skill-3/pom.xml clean test`
- Run (PowerShell-safe):
	- `mvn -f skill-3/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.demo.ProductHqlDemo"`

### Skill 4 – Spring Core DI (XML + Java Config)
Folder: `skill-4/`

This module demonstrates dependency injection using:
- XML configuration: `com.example.XmlConfigMain`
- Java @Configuration: `com.example.AnnotationConfigMain`

- Build:
	- `mvn -f skill-4/pom.xml clean test`
- Run XML config demo:
	- `mvn -f skill-4/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.XmlConfigMain"`
- Run annotation config demo:
	- `mvn -f skill-4/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.AnnotationConfigMain"`

### Skill 5 – Spring Autowiring (@Component + @Autowired)
Folder: `skill-5/`

This module prints the expected output:
`Student{..., certification=Certification{...}}`

- Build:
	- `mvn -f skill-5/pom.xml clean test`
- Run (PowerShell-safe):
	- `mvn -f skill-5/pom.xml org.codehaus.mojo:exec-maven-plugin:3.1.0:java "-Dexec.mainClass=com.example.MainApp"`

## Repository Structure
- `skill-1/`
- `skill-2/`
- `skill-3/`
- `skill-4/`
- `skill-5/`
