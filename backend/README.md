<<<<<<< HEAD
# eBanking
=======
# JEE E-Banking-Angular

Welcome to the JEE E-Banking-Angular repository! This repository contains the source code for a Java Enterprise Edition (JEE) application that combines Angular for the frontend and JEE for the backend to create an e-banking web application.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

JEE E-Banking-Angular is a full-stack web application that provides a user-friendly interface for managing banking transactions and accessing account information. The application leverages Angular for the frontend, providing a responsive and interactive user interface, and JEE for the backend, handling business logic and data management.

## Features

- User registration and authentication: Users can create new accounts and securely authenticate using their credentials.
- Account management: Users can view their account details, including balance, transaction history, and beneficiary information.
- Fund transfers: Users can transfer funds between their accounts and to other registered beneficiaries securely.
- Transaction history: Users can access a detailed history of their transactions, including dates, amounts, and transaction types.
- Admin dashboard: Administrators have access to an admin dashboard for managing user accounts, transactions, and system settings.
- Responsive design: The application is built with a responsive design, ensuring optimal user experience across devices.

## Prerequisites

To run this application locally, you need to have the following software installed on your system:

- Java SE Development Kit 8 or later
- Apache Maven
- Node.js (v12 or higher)
- Angular CLI (v12 or higher)
- MySQL server

## Installation

1. Clone this repository to your local machine using the following command:
git clone https://github.com/spyhimself/JEE_E-Banking-Angular.git

2. Navigate to the project root directory:
cd JEE_E-Banking-Angular

3. Install the backend dependencies and build the backend project using Maven:
mvn clean install

4. Navigate to the `client` directory:
cd client

5. Install the frontend dependencies:
npm install

## Usage

1. Start the backend server by running the following command in the project root directory:
mvn tomcat7:run

2. In a separate terminal, navigate to the `client` directory and start the frontend development server:
ng serve

3. Open your web browser and visit `http://localhost:4200` to access the application.

Feel free to explore the different features and functionalities available in the application. Create user accounts, perform transactions, and manage system settings through the provided user interface.

## Contributing

Contributions to this project are welcome! If you find any bugs or want to suggest enhancements, please open an issue on the [GitHub repository](https://github.com/spyhimself/JEE_E-Banking-Angular/issues). If you would like to contribute code, you can fork the repository and submit a pull request with your changes.

Please ensure that your contributions align with the coding conventions and best practices observed in the project.

## License

This project is licensed under the [MIT License](LICENSE). You are free to use, modify, and distribute this application as per the terms of the license.

---

Thank you for your interest in the JEE E-Banking-Angular
>>>>>>> frontend
