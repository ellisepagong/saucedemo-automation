# saucedemo-automation
This project contains automated tests using **Selenium WebDriver**, **Cucumber (Gherkin)**  and **GitHub Actions** for CI/CD.

## 🚀 Features
- BDD with Gherkin syntax
- Page Object Model (POM) structure
- Configurable environments (via `config.properties`)
- CI/CD pipeline via GitHub Actions

## 📂 Project Structure

```markdown
src/
main/java/pages/ # Page Object classes
test/java/features/ # Gherkin feature files
test/java/steps/ # Step definitions
test/java/hooks/ # Setup & teardown
test/java/runners/ # Cucumber runners
test/java/utils/ # Helpers (DriverFactory, ConfigReader)
```

[//]: # (.github/workflows/ci.yml # GitHub Actions pipeline)


## ⚙️ Setup & Run
1. Clone the repo
   ```bash
   git clone https://github.com/your-org/automation-tests.git
   ```

2. Install Dependencies
   ```bash
   mvn clean install
   ```
3. Open runner.java, replace tag with desired test case

---
## CI/CD

Tests are automatically run on every push via GitHub Actions

---
## Documentation

More in-depth documentation can be found [here](https://www.notion.so/nightcourt/SauceDemo-QA-Technical-Documentation-25af9af81e6180319e78f9debc520647).

---
## Prerequisites
- Java 17+
- Maven 3+
- Microsoft Edge installed