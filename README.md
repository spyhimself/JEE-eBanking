# JEE-eBanking

This repository contains the source code and documentation for the JEE-eBanking project.

## Project Description

JEE-eBanking is a web-based banking application that allows users to perform CRUD (Create, Read, Update, Delete) operations on Bank Accounts (Current/Savings). The project utilizes Angular as the frontend framework and Spring Boot as the backend framework.

## Features

- User registration and authentication
- Bank Account management (create, view, update, delete)
- Support for different types of Bank Accounts (Current/Savings)
- Account transactions and balance management
- Role-based access control for administrators and customers
- Security measures to protect against common threats
- Interactive web-based user interface using Angular components

## Prerequisites

To run the project locally, ensure you have the following prerequisites installed on your system:

- Node.js
- Angular CLI
- Java Development Kit (JDK) 8 or above
- Apache Maven
- MySQL Server

## Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/spyhimself/JEE-eBanking.git
   ```

2. Frontend (Angular):

   - Navigate to the `frontend` directory:

     ```shell
     cd JEE-eBanking/frontend
     ```

   - Install the dependencies:

     ```shell
     npm install
     ```

   - Run the Angular development server:

     ```shell
     ng serve
     ```

   - The Angular application will be accessible at `http://localhost:4200`.

3. Backend (Spring Boot):

   - Configure the database:
     - Create a MySQL database.
     - Update the database connection details in the `src/main/resources/application.properties` file.

   - Build the project using Maven:

     ```shell
     cd JEE-eBanking
     mvn clean install
     ```

   - Run the Spring Boot application:

     ```shell
     mvn spring-boot:run
     ```

   - The backend API will be accessible at `http://localhost:8080`.

## Project Structure

The project follows a standard structure for Angular and Spring Boot projects. Here are the main directories:

- `frontend`: Contains the Angular frontend source code.
- `backend`: Contains the Spring Boot backend source code.
- `src/main/resources`: Contains the configuration files and static resources for the backend.

## Documentation

The `docs` directory contains additional documentation for the project, including:

- `architecture.md`: Provides an overview of the project's architecture.
- `database_design.md`: Describes the database design and schema.
- `user_guide.md`: A user guide for using the JEE-eBanking application.

## Project Report

For a detailed overview of the project, please refer to the [Project Report](https://docs.google.com/document/d/1fEcciIKeUQ1fUNL1orZhFtNt1AwjxhdWxo9YEWaDYRU/edit?usp=sharing).

## Contributing

Contributions are welcome! If you would like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature/bug fix.
3. Make your changes and commit them.
4. Push your changes to your forked repository.
5. Submit a pull request to the `main` branch of this repository.

Please ensure your code follows the project's coding conventions and includes appropriate tests and documentation.

## License

The JEE-eBanking project is licensed under the [MIT License](LICENSE).

## Contact

For any questions or inquiries, please contact the project maintainer: [my e-mail](mailto:tararayman7@gmail.com).
```

Please note that you may need to modify the instructions in the Angular and Spring Boot sections if your project structure or setup differs from the assumptions made in the README
