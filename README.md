# TextXtract
# TextXtract Application

## Overview

The TextXtract application is designed to enable users to upload images and extract text from them using Tesseract OCR. This application comprises a backend implemented using Spring Boot, which provides a REST API for handling image uploads and text extraction, and a frontend for user interaction.

## Components

### 1. `ImageTextController` Class (API Endpoint)

The `ImageTextController` class is the core of the REST API. It handles image uploads and text extraction through Tesseract OCR.

- **Endpoint:** `POST /api/extract-text`
- **Functionality:**
  - Accepts image file uploads.
  - Processes the image (currently without modification).
  - Uses Tesseract OCR to extract text.
  - Returns the extracted text in the response.
- **Key Method:** `preprocessImage`
  - Designed to preprocess images to enhance OCR accuracy.
  - Currently returns the original image without modification.

### 2. `ImageTextExtractorApplication` Class

The `ImageTextExtractorApplication` class serves as the entry point for the Spring Boot application.

- **Main Method:** `public static void main(String[] args)`
  - Initializes and launches the Spring Boot application.
  - Sets up the Spring application context and environment for the REST API.

### 3. HTML Frontend (for Image Upload)

The `index.html` file provides a simple user interface for image uploads.

- **Features:**
  - Includes a form with a file input element (`<input type="file" name="file" accept="image/*" required>`).
  - Allows users to select and upload image files.
  - Submits images to the `/api/extract-text` endpoint for processing.

### 4. `pom.xml` (Maven Project Object Model)

The `pom.xml` file is the Maven configuration file for managing project dependencies and build configurations.

- **Purpose:**
  - Includes essential libraries and tools such as Spring Boot and Tesseract OCR.
  - Facilitates smooth project build and dependency management.

## Implementation Details

### 1. Spring Boot Framework

- **Tool Used:** Spring Boot
- **Purpose:** To create a stand-alone, production-grade Spring-based application with minimal configuration.
- **Implementation:**
  - Uses the Spring Boot Starter Web dependency for web server setup and HTTP request handling.
  - The main application class `ImageTextExtractorApplication` is annotated with `@SpringBootApplication` to enable component scanning and auto-configuration.
  - The `ImageTextController` class exposes RESTful API endpoints for file uploads and image data processing.

### 2. REST API for Image Upload and Text Extraction

- **Tool Used:** Spring MVC
- **Purpose:** To implement REST APIs for uploading images and retrieving extracted text.
- **Implementation:**
  - The API endpoint `/api/extract-text` is defined using the `@PostMapping` annotation in the `ImageTextController` class.
  - Accepts file uploads through the `@RequestParam` annotation with the parameter `MultipartFile file`.
  - The uploaded file is saved to a temporary directory, pre-processed, and passed to the OCR engine for text extraction.

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd textxtract
   ```

2. **Build the Application:**
   ```bash
   mvn clean install
   ```

3. **Run the Application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the Frontend:**
   Open your browser and navigate to `http://localhost:8080` to access the HTML frontend for image uploads.

## Dependencies

- Spring Boot
- Spring MVC
- Tesseract OCR
- Maven

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
