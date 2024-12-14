# **OpenCart Automation Framework**

This repository contains the automated test framework for **OpenCart** using **Selenium** and Java. It follows the **Page Object Model (POM)** structure to ensure modularity, reusability, and maintainability of the test scripts.

---

## **Folder Structure**

The project is organized as follows:

### 1. **logs/**
   - Contains log files generated during test execution.
   - Logs are stored in a structured format to help debug test failures.

### 2. **Reports/**
   - Holds test execution reports.
   - These reports provide insights into passed, failed, and skipped test cases.

### 3. **Screenshots/**
   - Stores screenshots captured for failed test cases.
   - Helps in analyzing issues during debugging.

### 4. **src/test/java/**
   - Contains all the source code related to tests and the Page Object Model.

#### **pageObjects/**
   - Contains classes that represent the web pages or components of the OpenCart application.
   - Each class includes locators and methods for the elements on that specific page.
     - `AccountRegistrationPage` - Methods for account registration functionality.
     - `BasePage` - Common reusable methods across all pages.
     - `HomePage` - Methods for interactions with the home page.

#### **testCases/**
   - Includes all test cases written for the OpenCart application.
   - These tests validate the functionality of the web application by interacting with the page objects.

#### **utilities/**
   - Contains utility classes and helper methods used across the framework.
   - Examples include:
     - Reading configuration files.
     - Common test utilities like waits and actions.

#### **resources/**
   - Holds additional resources needed for test execution.
   - Examples include property files, JSON files, or environment-specific configurations.

---

### 5. **target/**
   - Directory where compiled code and test results are stored.
   - Generated automatically after Maven build execution.

### 6. **Testdata/**
   - Contains test data files in formats like Excel, JSON, or CSV used for data-driven testing.

---

### 7. **XML Configuration Files**

- **CrossBrowserTesting.xml**: 
   - Configuration file for cross-browser test execution.
   - Helps in running tests across multiple browsers like Chrome, Firefox, Edge, etc.

- **master.xml**: 
   - Main test suite file to trigger the execution of all test cases.

---

## **Technologies Used**
- **Programming Language**: Java
- **Automation Tool**: Selenium WebDriver
- **Framework**: TestNG
- **Build Tool**: Maven
- **Design Pattern**: Page Object Model (POM)
- **Logging**: Log4j
- **Reporting**: Extent Reports / TestNG Reports

---

## **How to Run the Framework**

1. **Pre-requisites**:
   - Install Java JDK (8 or higher).
   - Install Maven.
   - Install Selenium-compatible browser drivers (e.g., ChromeDriver).
   - Configure environment variables for Maven and Java.

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/Pankj699/HybridTestFramework.git
   cd OpenCart
   ```

3. **Run Tests**:
   - Run the master suite using Maven:
     ```bash
     mvn test -Dsuite=master.xml
     ```

   - For cross-browser testing:
     ```bash
     mvn test -Dsuite=CrossBrowserTesting.xml
     ```

4. **View Reports**:
   - Reports will be generated in the `Reports/` folder.

---

## **Best Practices Followed**
1. **Page Object Model** ensures separation of page-specific logic from test cases.
2. **Reusable Methods** are implemented in the `BasePage` to avoid code duplication.
3. **Test Data Management**: Test data is stored separately in the `Testdata/` folder for easy maintenance.
4. **Cross-Browser Compatibility**: The framework supports execution on multiple browsers.

---

## **Contributions**
Feel free to fork the repository and submit pull requests with enhancements or bug fixes.

---

## **Contact**
For any queries or suggestions, feel free to contact:

**Pankaj Gupta**  
- **Email**: pankjgupta699@gmail.com  
- **LinkedIn**: https://www.linkedin.com/in/pankaj-gupta-96092b222  

---
