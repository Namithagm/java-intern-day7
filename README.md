🧑‍💻 Employee Management System (Java + PostgreSQL)
A simple CRUD (Create, Read, Update, Delete) console-based application built using Java, JDBC, and PostgreSQL.
It allows you to add, view, update, and delete employee records from a PostgreSQL database.

🚀 Features
✅ Connects Java application to PostgreSQL database
🧾 Add new employee details
👀 View all employees
✏ Update existing employee data
❌ Delete an employee by ID
🎯 Uses PreparedStatements (SQL Injection safe)

🏗 Tech Stack
Component	Technology
Language	Java (JDK 17+)
IDE	Eclipse
Database	PostgreSQL
Driver	PostgreSQL JDBC (postgresql-42.7.4.jar)

⚙ Prerequisites
Before running, ensure you have:
☕ Java JDK 17+ installed
🧱 Eclipse IDE (or any Java IDE)
🐘 PostgreSQL installed and running locally
🧩 PostgreSQL JDBC Driver: Download Here

🧰 Database Setup (PostgreSQL)
Open pgAdmin or psql, then run the following SQL commands:
-- Step 1: Create database
CREATE DATABASE employeedb;
-- Step 2: Connect to database
\c employeedb
-- Step 3: Create table
CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    salary NUMERIC(10,2)
);
✅ Your database is now ready.

🪜 Eclipse Project Setup
Step 1️⃣: Create Java Project
Open Eclipse → File → New → Java Project
Name it EmployeeCRUDApp
Step 2️⃣: Add PostgreSQL JDBC Driver
1. Download postgresql-42.7.4.jar
2. Inside your project, create a folder named lib
3. Copy the .jar file into lib
4. Right-click lib/postgresql-42.7.4.jar → Build Path → Add to Build Path
✅ You should now see it under Referenced Libraries
💡 Connection Details
Update your PostgreSQL username and password in code:
Connection con = DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/employeedb",
    "postgres",         
    "your_password"      
);

🧩 Run the Application
1. Right-click your EmployeeApp.java → Run As → Java Application
2. You’ll see:
✅ Connected to PostgreSQL Database!
========= Employee CRUD Menu =========
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter your choice:
3. Choose a number and interact via console.


🧠 Example Run
Enter your choice: 1
Enter Name: Namitha
Enter Email: nami@gmail.com
Enter Salary: 50000
✅ Employee added successfully!

Enter your choice: 2
ID | NAME     | EMAIL           | SALARY
------------------------------------------
1  | Namitha  | nami@gmail.com  | 50000.00



🧹 Common Errors & Fixes
Error	Cause	Fix

ClassNotFoundException: org.postgresql.Driver	JDBC jar not added	Add postgresql-42.7.4.jar to Build Path
relation "employee" does not exist	Table missing	Run CREATE TABLE employee(...)
column "email" is of type character[]	Wrong column type	ALTER TABLE employee DROP COLUMN email; ADD COLUMN email VARCHAR(100)

📜 License
This project is open source and free to use for learning purposes.


🙌 Author

Namitha M
💼 Java Developer | 💡
