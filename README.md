# Automation Assessment Framework

This project is an end-to-end test automation framework built with **Java**, **TestNG**, **Selenium**, and **REST Assured**, following the **Page Object Model (POM)** design pattern. It also includes **Test Reports** generation using **Surefire Reports**.

## Tech Stack

- Java 17+
- Maven
- Selenium WebDriver
- TestNG
- REST Assured (for API tests)
- WebDriverManager (for managing ChromeDriver)
- Surefire Reports (for test reporting)
- IntelliJ IDEA (recommended IDE)

---

## Folder Structure

```bash
automation-assessment/
├── pom.xml
├── README.md
├── /src
│   ├── /main
│   │   └── /java
│   │       └── com.assessment.pages     # Page Object classes
│   │           └── CartPage
│   │           └── CheckoutCompletePage
│   │           └── CheckoutInfoPage
│   │           └── CheckoutOverviewPage
│   │           └── LoginPage
│   │           └── ProductsPage
│   └── /test
│       └── /java
│           └── com.assessment.api       # REST Assured API tests
│               └── CommentApiTest
│           └── com.assessment.base      # Base class
│               └── BaseTest
│           └── com.assessment.tests     # TestNG test classes
│               └── CheckoutTest
│               └── LoginTest
└── /target                              # Generated test reports
        └── /surefire-reports
            └── emailable-report.html    # The report in HTML format
```

---

## Getting Started

### Prerequisites

Ensure the following are installed on your machine:

- Java (JDK 17 or higher)
- Maven
- Git (if cloning from GitHub)
- IntelliJ IDEA (recommended for project execution and editing)

---

### Cloning the Repository

```bash
git clone https://github.com/afiqakmar21/automation-assessment.git
cd automation-assessment
```
Alternatively, you can download the ZIP from GitHub and extract it.

---

### Executing the Tests

```bash
mvn clean test
```

---

### Viewing the Report

```bash
open target/surefire-reports/emailable-report.html
```

---

## Important Notes

- The **CheckoutTest** might fail due to Chrome's popup blocking and interfering with the completion of the test
- If this happens, in **src/test/java/com.assessment/base/BaseTest** file, please **comment** _CHROME BROWSER_ block and **uncomment** either _FIREFOX BROWSER_ block or _SAFARI BROWSER_ block
- Then execute
```bash
mvn clean test
```
- Then view the report
```bash
open target/surefire-reports/emailable-report.html
```
