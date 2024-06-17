# Vehicle Rental System

The Vehicle Rental System is a Java application designed to create detailed invoices based on rental periods, calculate rental costs, and manage customer information efficiently.

## Features

- **Invoice Generation**: Automatically generates invoices detailing rental infoprmation including rental period, vehicle details, insurance costs, and total expenses.
  
- **Vehicle Types**: Supports different types of vehicles including cars, motorcycles, and cargo vans, each with specific rental pricing and insurance calculations.

- **Customer Management**: Invoices can be generated and viewed by customer name.

- **User Interface**: Simple command-line interface (CLI) for easy navigation and interaction. Users can select options from menus to perform various operations such as viewing invoices or exiting the system.

  ## Functionality Overview

1. **Invoice Generation**
   - **Description**: The system generates detailed invoices for customers based on their rental information.
   - **Implementation**: 
     - Each `Invoice` object is associated with a `Pricing` object, which in turn holds references to a specific `Vehicle` and `RentalPeriod`.
     - When an `Invoice` is created, it calculates and formats the rental costs, insurance costs, discounts/additions (if applicable), and totals using the pricing details provided.

2. **Vehicle Types and Pricing**
   - **Description**: Different types of vehicles (`Car`, `Motorcycle`, `CargoVan`) have specific rental costs and insurance calculations based on their characteristics.
   - **Implementation**: 
     - Each `Vehicle` type (`Car`, `Motorcycle`, `CargoVan`) extends the abstract `Vehicle` class, defining specific attributes like safety rating, customer age, or customer experience.

3. **User Interface (CLI)**
   - **Description**: Users interact with the system through a Command Line Interface (CLI) to view invoices and manage rental information.
   - **Implementation**: 
     - The `Execution` class handles user input and displays menus for viewing invoices by customer name.
     - It utilizes `Scanner` for user input and `System.out.println()` for output messages and menus.

4. **Data Validation**
   - **Description**: The system validates input data such as customer names, rental periods, and vehicle information to ensure correctness and prevent errors.
   - **Implementation**: 
     - Validation methods are implemented in relevant classes such as `Invoice`, `Pricing`, `RentalPeriod`, and `Vehicle`.
     - Errors are handled using `IllegalArgumentException` and appropriate error messages.

5. **Main Class**
   - **Description**: The `Main` class initializes the system, creates instances of `Vehicle`, `RentalPeriod`, and `Pricing`, and starts the CLI interface for user interaction.
   - **Implementation**: 
     - It creates instances of `Car`, `Motorcycle`, and `CargoVan` with sample data for demonstration purposes.
     - `Execution` class methods are called to display menus and handle user choices.

## Technologies Used

- **Java**: Developed using Java programming language, ensuring robust object-oriented design.

## Usage

- **Main Menu**: Upon starting the application, the main menu presents options to view invoices by customer name or exit the system.

- **Viewing Invoices**: Selecting the option to view invoices by customer name lists available customers. Choose a customer to display their detailed invoice, including rental dates, vehicle details, insurance costs, and total expenses.

- **Exiting the System**: To exit the application, select the appropriate option from the main menu.

## Contributors

- **Lora Gotseva**: Developer


