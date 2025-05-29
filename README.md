# 💼 SmartEmployee - Employee Management System

A Spring Boot-based web application for managing employees. Features include user login, employee registration, file upload, and validations. Built using Java, Spring Boot, Thymeleaf, and MySQL.

---

## ✅ Features

- 🔐 **Login Authentication** – Basic login form validation
- 👨‍💼 **Add New Employees** – Capture personal and professional details
- 🆔 **Auto-generate Employee ID & Login ID**
- 📎 **Aadhaar Upload** – PDF only (10KB–1MB), path saved to DB
- 📅 **DOB Validation** – Must be 18 years or older
- 🔍 **Search Employees** by login ID
- 🔁 **Update/Delete** employee data
- 🔄 **Remote Pagination** – Efficient employee listing

---

## 🛠️ Tech Stack

| Layer            | Technology               |
|------------------|------------------        |
| Backend          | Java 17, Spring Boot 3   |
| View             | Thymeleaf                |
| Database         | MySQL                    |
| Build Tool       | Maven                    |
| IDE              | Eclipse                  |

---

## 📁 Folder Structure
SmartEmployee/
├── src/
│ ├── main/
│ │ ├── java/com/ak/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── service/
│ │ └── resources/
│ │ ├── templates/
│ │ └── application.properties
└── uploads/ (manually created)
