# saucedemo-automation
This project contains automated tests for [SauceDemo](https://www.saucedemo.com/v1) using **Selenium WebDriver**, **Cucumber (Gherkin)** with **JUnit4** and **GitHub Actions** for CI/CD.

## 🚀 Features
- Behavior-Driven Development with Gherkin syntax
- Page Object Model (POM) structure
- CI/CD pipeline via GitHub Actions

## 📂 Project Structure

```markdown
test-cases.md # list of test cases
.github/workflows/ci.yml # GitHub Actions pipeline
src/
main/java/driver/ # Web Driver Manager
test/java/pages/ # Page objects and xpath locators
test/java/runners/ # Cucumber runners
test/java/steps/ # Step definitions and Hooks
test/java/features/ # Gherkin feature files
```



## ⚙️ Setup & Run
1. Clone the repo
   ```bash
   git clone https://github.com/ellisepagong/saucedemo-automation.git
   ```
   
2. Install WebDriver (ChromeDriver, EdgeDriver, etc.)

3. go to src/main/java/driver/DriverFactory.java
    ```java
   // line 10
   private static final String DRIVER_PATH = "PATH_TO_DRIVER"; // <- Replace with path to Driver
   ```
   * note: DriverFactory assumes you have and will use Microsoft Edge installed in the default location. Feel free to replace EdgeOptions/EdgeDriver with your preferred browser driver.
   

4. Install Dependencies
   ```mvn
   mvn clean install
   ```
5. Open runner.java, replace tag with desired test case

---
## CI/CD

Tests are automatically run on every Pull Request via GitHub Actions, as well as on every 1st and 15th of every month.
These tests are skipped if a Pull Request contains ```[skip-check]``` in the title.

DriverFactory.java contains an environment check to run Google Chrome on headless in the CI environment. The specific mvn command is as follows:

   ```mvn
   mvn test -Denv=ci -Dcucumber.filter.tags=@Regression
   ```

---
## Prerequisites
- Java 17+
- Maven 3+
- Microsoft Edge installed
