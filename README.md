# 📝 Task Manager Application

A functional Task Manager built using **Spring Boot**, featuring authentication, CRUD task operations, and audit trail logging.  
This project demonstrates core backend skills such as **REST API development, service-layer architecture, logging, and database handling with Spring Data JPA.**

---

## 🚀 Features

- 🔐 User Login System  
- 📝 Create, Read, Update, Delete Tasks  
- 🔍 Search and Pagination  
- 📜 Audit Logs for every action  
- 🗄️ Database integration with Spring Data JPA  
- 🌍 REST API with JSON responses  

---

## 📌 Tech Stack

| Category | Technology |
|---------|------------|
| Framework | Spring Boot |
| Database | MySQL / H2 |
| ORM | Spring Data JPA |
| Architecture | Controller → Service → Repository |
| UI | HTML, CSS, JavaScript |
| Logging | Custom Audit Logging |

---

## 📸 Application Preview

---

### 🔐 Login Page

<p align="center">
  <img src="Login Page.png" width="800">
</p>

---

### 📝 Task Management Page

<p align="center">
  <img src="Task Page.png" width="800">
</p>

---

### 📜 Audit Log Page

<p align="center">
  <img src="Audit Log Page.png" width="800">
</p>

---

## 🔐 Authentication

Users must log in before accessing the system.

```
Username: admin
Password: password123
```

---

## 📂 Task Management

After login, users can:

- Add new tasks  
- Edit or update existing tasks  
- Delete a task  
- View paginated task list  
- Search tasks using keywords  

### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/tasks` | Create a task |
| GET | `/tasks` | Get all/paginated tasks |
| PUT | `/tasks/{id}` | Update a task |
| DELETE | `/tasks/{id}` | Delete a task |

---

## 🧾 Audit Logging

Every change is recorded, including:

- Task Create
- Task Update
- Task Delete
- Timestamp + Task ID

Example entry:

```json
{
  "action": "Task Updated",
  "taskId": 4,
  "timestamp": "2025-11-23T15:31:02"
}
```

---

## 📁 Folder Structure

```
src/main/java/com/taskmanager
 ┣ controller       → Handles API requests
 ┣ entity           → Task & AuditLog models
 ┣ repository       → Database CRUD interfaces
 ┣ service          → Business logic + audit tracking
 ┗ security         → Login handling
```

---

## 🧪 Error Handling

The app returns proper structured responses in case of invalid operations (ex: editing non-existing task).

```json
{
  "error": "Task not found",
  "status": 404
}
```

---

## 🏁 How to Run Locally

1. Clone the repository  
2. Update database config in `application.properties`  
3. Run the Spring Boot application  
4. Open browser:

```
http://localhost:8080
```

---

## ⭐ Why This Project Matters

✔ Real-world structure (Controller → Service → Repository)  
✔ Includes authentication + database + logging  
✔ Good portfolio project for backend roles  
✔ Easy to extend with JWT or frontend frameworks  

---

## 🔧 Future Enhancements

- JWT Authentication  
- Role-based access control  
- Docker Support  
- React/Angular Frontend  

---

### 📌 Status: Completed ✔
