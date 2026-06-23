# Swag Labs Automation Framework

## Overview

This project is a Selenium WebDriver Automation Testing Framework developed for the Swag Labs web application.

The framework was designed using Page Object Model (POM) and PageFactory to improve maintainability, reusability, and scalability while following automation testing best practices.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* PageFactory
* JSON Test Data
* ConfigReader
* Allure Reports

---

## Framework Features

* Page Object Model (POM)
* PageFactory Implementation
* Externalized Configuration using ConfigReader
* JSON-Based Test Data Management
* Reusable Test Methods
* Constants Management
* Cross-Browser Configuration Support
* Explicit Wait Infrastructure
* Allure Reporting Integration

---

## Automated Test Scenarios

### Authentication

* Valid Login
* Invalid Login

### Cart Functionality

* Add Product To Cart
* Remove Product From Cart
* Verify Product In Cart

### Checkout Functionality

* Checkout Validation
* Complete Checkout Workflow

---

## Project Structure

src

├── main/java

│   ├── base

│   ├── models

│   ├── pages

│   └── utilities

│

├── test/java

│   ├── base

│   └── tests

│

└── test/resources

```
├── config

└── testdata
```

---

## Test Data

Test data is maintained using JSON files located in:

src/test/resources/testdata

---

## Configuration

Application configuration is maintained using:

src/test/resources/config/config.properties

---

## Run Tests

Run the TestNG suite:

testng.xml

Or execute using Maven:

mvn clean test

Or double click on RunAutomationDemo.bat

---

## Generate Allure Report

allure serve allure-results

---

## Project Demo

Watch the project demo on LinkedIn:

https://www.linkedin.com/posts/muhammad-safwat-179773219_qa-softwaretesting-automationtesting-ugcPost-7475194739559059457-J54F/?highlightedUpdateUrn=urn%3Ali%3Aactivity%3A7475195203881099264&origin=SOCIAL_SHARE&utm_source=share&utm_medium=member_desktop&rcm=ACoAADcbsC0B20PhmB98sHiwzPjAIlq4gxTYjY0

---

## Author

Muhammad Safwat
Software QA & Automation Test Engineer
