# API Testing with Rest-Assured
This repository contains a collection of API tests written using Rest-Assured, a powerful Java library for testing RESTful APIs. The project demonstrates how to automate API testing, validate responses, and ensure the reliability of APIs.

### Table of Contents
- [Introduction](https://chat.deepseek.com/a/chat/s/2d53e176-73ed-41fe-a39c-ec2b53c2b005#introduction)
- [Prerequisites](https://chat.deepseek.com/a/chat/s/2d53e176-73ed-41fe-a39c-ec2b53c2b005#prerequisites)
- [Installation](https://chat.deepseek.com/a/chat/s/2d53e176-73ed-41fe-a39c-ec2b53c2b005#installation)
- [Usage](https://chat.deepseek.com/a/chat/s/2d53e176-73ed-41fe-a39c-ec2b53c2b005#usage)
- [Test Cases](https://chat.deepseek.com/a/chat/s/2d53e176-73ed-41fe-a39c-ec2b53c2b005#test-cases)
- [Contributing](https://chat.deepseek.com/a/chat/s/2d53e176-73ed-41fe-a39c-ec2b53c2b005#contributing)

### Introduction
API testing is a critical part of ensuring the functionality, reliability, and performance of web services. This project uses Rest-Assured, a Java DSL (Domain-Specific Language) for simplifying API testing. It provides a clean and expressive way to write tests for RESTful APIs.

### Key Features:

- Easy-to-read syntax for API requests and response validation.
- Support for various HTTP methods (GET, POST, PUT, DELETE, etc.).
- Integration with testing frameworks like JUnit or TestNG.
- JSON and XML response validation.

### Prerequisites
Before running the tests, ensure you have the following installed:
- Java Development Kit (JDK): Version 8 or higher.
- Maven: For dependency management and building the project.
- IDE: IntelliJ IDEA, Eclipse, or any other Java IDE.
- Rest-Assured: Included in the pom.xml file.

### Installation
Clone the repository:
```sg
git clone https://github.com/ebrahimhossaincse/API-Testing-With-Rest-Assured.git
```

Navigate to the project directory:
```sh
cd API-Testing-With-Rest-Assured
```

Install dependencies using Maven:
```sh
mvn clean install
```

### Usage
To run the API tests, follow these steps:
1. Open the project in your preferred IDE.
2. Navigate to the test classes located in the src/test/java directory.
3. Run the tests using your IDE's test runner or via the command line: mvn  test


### Test Cases
The repository includes tests for various API scenarios, such as:

- GET Requests: Validate status codes, response headers, and JSON/XML payloads.
- POST Requests: Test creating new resources and validate responses.
- PUT/PATCH Requests: Test updating existing resources.
- DELETE Requests: Test resource deletion and verify responses.
- Authentication: Test APIs with authentication (e.g., OAuth, Basic Auth).

### Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:
- Fork the repository.
- Create a new branch for your feature or bugfix:
  ```sh
  git checkout -b feature/your-feature-name
  ```
- Commit your changes:
  ```sh
  git commit -m "Add your commit message here"
  ```
- Push your branch:
  ```sh
  git push origin feature/your-feature-name
  ```
- Open a pull request and describe your changes.


### Acknowledgments
[Rest-Assured](https://rest-assured.io/) for providing a powerful API testing framework.

The open-source community for continuous support and inspiration.

For any questions or feedback, feel free to reach out to the repository owner:
**### Ebrahim Hossain**
[GitHub Profile](https://github.com/ebrahimhossaincse)
📧 Email: [mdebrahimhossain.me@gmail.com](mailto:mdebrahimhossain.me@gmail.com)

Happy Testing! 🚀