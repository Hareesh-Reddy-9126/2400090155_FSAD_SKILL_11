# Skill-13: Full Stack Student Manager Deployment

## Project Structure

```
skill-13/
├── backend/
│   ├── pom.xml
│   └── src/
│       └── main/
│           ├── java/
│           │   ├── StudentAppApplication.java
│           │   ├── Student.java
│           │   ├── StudentRepository.java
│           │   ├── StudentService.java
│           │   └── StudentController.java
│           └── resources/
│               └── application.properties
├── frontend/
│   ├── package.json
│   ├── .env
│   ├── public/
│   │   └── index.html
│   └── src/
│       ├── App.js
│       ├── App.css
│       ├── index.js
│       └── components/
│           └── StudentManager.js
```

## Deployment Instructions

### 1. Build React Frontend

```bash
cd skill-13/frontend
npm install
npm run build
```

### 2. Copy React Build to Backend Static Folder

```bash
# Copy build output to backend static folder
cp -r build/* ../backend/src/main/resources/static/
```

### 3. Build and Run Spring Boot Backend

```bash
cd ../backend
mvn clean package
java -jar target/student-manager-1.0.0.jar
```

### 4. Access Application

- Open [http://localhost:8085](http://localhost:8085) in your browser.

### 5. Nginx Deployment (Optional)

- Deploy the React build folder to Nginx for static hosting.
- Update Nginx config to proxy API requests to Spring Boot backend.

## Environment Configuration

- React API URL: Set in `.env` as `REACT_APP_API_URL=http://localhost:8085`
- Spring Boot static resources: `application.properties` configures static folder.

## Verification Steps

- Add students via UI, verify backend API and database.
- Check static files served from backend after build copy.
- Confirm API calls use correct URL from `.env`.

---

**This setup enables a production-ready full stack deployment with React + Spring Boot.**
