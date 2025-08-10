# Arccos(x) Calculator

A Java-based application for computing the **arccosine** of a given value using the **Maclaurin series approximation**.  
Developed as part of the **SOEN 6011 – Software Engineering Process** course, this project emphasizes **clean code practices**, **semantic versioning**, **UI design principles**, **accessibility**, and **quality assurance**.


## 📖 Overview
The **Arccos(x) Calculator** computes the inverse cosine of a given value in the range **[-1, 1]**.  
It is implemented in **Java Swing** with an intuitive graphical interface and designed according to the **Google Java Style Guide**.

This project was developed over multiple deliverables:
- **D1**: Context of use, requirements specification, and CLI prototype
- **D2**: Full GUI implementation with accessibility and error handling
- **D3**: Code styling, static analysis, debugging, semantic versioning, and unit testing

---

## ✨ Features
- **GUI-based Application** built with Java Swing
- **Input validation** for domain restrictions `x ∈ [-1, 1]`
- **Maclaurin Series Implementation** (no direct `Math.acos` usage)
- **Tooltip guidance** for user input
- **Accessibility support** for screen readers
- **Semantic versioning** for clear release tracking
- **JUnit-based unit testing**
- **GitHub-based version control workflow**

---

## 🛠 Technologies Used
- **Java 17**
- **Java Swing**
- **Google Java Style Guide**
- **Checkstyle**
- **SonarQube** (Static Analysis)
- **JUnit 5** (Unit Testing)
- **Git & GitHub** (Version Control)

---
## ▶ Usage
- **Enter a value for x between -1 and 1 in the text field.**
- **Click the "Calculate" button.**
- **The arccosine value will be displayed in radians.**
- **If the input is invalid, an error message will be shown.**
- **Tooltips and accessibility features help guide users through input and output.**

## 📌 Versioning
This project follows Semantic Versioning (MAJOR.MINOR.PATCH):
- **v1.0.0** – Initial CLI version
- **v1.1.0** – GUI added with tooltips and accessibility features
- **v1.2.0** – Version displayed in title bar and footer, UI enhancements

## 🧪 Testing
- **Unit tests are implemented using JUnit 5:**
- **Valid Input Tests** – Correct calculation for values within [-1, 1]
- **Boundary Tests** – Proper handling of x = -1 and x = 1
- **Invalid Input Tests** – Correct error messages for out-of-range or non-numeric inputs
All tests pass successfully, ensuring accurate computation and robust error handling.
