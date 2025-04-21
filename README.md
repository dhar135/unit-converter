# Unit Converter

This project is a simple Unit Converter application based on the backend project idea from [roadmap.sh](https://roadmap.sh/).

## Project Goal

The goal of this project is to create a web application that can convert between different units of measurement (e.g., length, weight, temperature). This project is part of the backend learning path suggested by roadmap.sh.

You can find the original project description here: [roadmap.sh/projects/unit-converter](https://roadmap.sh/projects/unit-converter)

## Technologies Used

*   Java 23
*   Spring Boot 3.4.4
*   Spring Web
*   Thymeleaf
*   Maven

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 23 or later
*   Apache Maven

### Running the Application

1.  Clone the repository:
    ```bash
    git clone <your-repository-url>
    cd unit-converter
    ```
2.  Build the project using Maven:
    ```bash
    mvn clean install
    ```
3.  Run the application:
    ```bash
    mvn spring-boot:run
    ```
    Alternatively, you can run the packaged JAR file:
    ```bash
    java -jar target/unit-converter-0.0.1-SNAPSHOT.jar
    ```
4.  Open your web browser and navigate to `http://localhost:8080` (or the configured port).

## Features

This application provides web interfaces for the following unit conversions:

*   **Length Conversion:** Convert between various units of length (e.g., meters, kilometers, miles, feet, inches).
*   **Weight Conversion:** Convert between various units of weight (e.g., grams, kilograms, pounds, ounces).
*   **Temperature Conversion:** Convert between Celsius, Fahrenheit, and Kelvin.

## License

MIT License