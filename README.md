# 📝 Task Manager Application

A simple yet functional Task Manager built using **Spring Boot**, featuring authentication, task CRUD operations, and audit logging.  
This project demonstrates backend fundamentals such as **REST API design, validation, logging, persistence using JPA, and UI integration**.

---

## 🚀 Features

- 🔐 Login Authentication  
- ✨ Create, Read, Update, Delete Tasks  
- 🔍 Search and Pagination  
- 📜 Audit Logging for activity tracking  
- 🗄️ Database integration using Spring Data JPA  
- 🌍 REST API returning proper JSON responses  

---

## 📌 Tech Stack

| Layer | Technology Used |
|-------|----------------|
| Backend Framework | Spring Boot |
| Database | MySQL / H2 |
| ORM | Spring Data JPA |
| Validation | Jakarta Validation |
| Logging | Custom Audit Logging |
| UI | HTML, CSS, JavaScript |

---

## 🔐 Authentication (Login)

Users must authenticate before using the application.

> Default credentials (as per assessment):
```
Username: admin
Password: password123
```

### 🔻 Login UI

![Login](Screenshot 2025-11-23 113230.png)

---

## 📂 Task Management

After login, users can:

- Create new tasks  
- View task list with pagination  
- Edit existing tasks  
- Delete tasks  
- Search tasks by title/description  

### 🔻 Task Page UI

![Tasks Page](Screenshot 2025-11-23 113553.png)

Backend Endpoints Example:

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/tasks` | Create a task |
| GET | `/tasks` | Fetch paginated tasks |
| PUT | `/tasks/{id}` | Update task |
| DELETE | `/tasks/{id}` | Delete task |

---

## 🧾 Audit Logging

Every operation is recorded:

- Task Creation  
- Task Update  
- Task Deletion  
- Task ID included for traceability  

### 🔻 Audit Logs UI

![Audit Logs](Screenshot 2025-11-23 113628.png)

Example log entry stored in DB:

```json
{
  "timestamp": "2025-11-23T10:02:41",
  "action": "Create Task",
  "taskId": 2,
  "updatedContent": "{title: ...}"
}
```

---

## 📁 Project Structure

```
src/main/java/com/taskmanager
 ┣ controller       → REST Controllers
 ┣ entity           → JPA Entities (Task, AuditLog)
 ┣ repository       → Spring Data JPA Interfaces
 ┣ service          → Business Logic + Audit Tracking
 ┗ security         → Authentication Logic
```

---

## 🧪 Validation & Error Handling

The app validates inputs and returns clear JSON error messages.

Example invalid input response:

```json
{
  "timestamp": "2025-11-23",
  "error": "Validation Failed",
  "details": "Task title cannot be empty"
}
```

---

## 🏁 How to Run

1. Clone repository  
2. Configure database in `application.properties`  
3. Run Spring Boot application  
4. Open browser:

```
http://localhost:8080
```

---

## ⭐ Why This Project Adds Value

✔ Demonstrates real-world backend architecture  
✔ Includes authentication and audit logs  
✔ Follows clean REST design principles  
✔ Good project for freshers to showcase Spring Boot skills  

---

## 🔧 Possible Future Enhancements

- JWT Authentication  
- RBAC (Admin/User Roles)  
- Docker Support  
- Frontend rewrite using React/Angular  

---

### 📌 Status: Completed ✔

