<div align = "center">
  <h1>AAD PHASE 02 - POS SYSTEM</h1>
</div>

The POS System Backend is a comprehensive RESTful API built to efficiently support the various functionalities of a Point of Sale (POS) system. This backend service plays a crucial role in handling diverse aspects of the POS system, including:

- **Customer Data Management** : It allows for the creation, retrieval, updating, and deletion of customer profiles and information, ensuring that all customer interactions and transactions are accurately recorded and managed.
  
- **Item Data Management** : This feature includes managing product details, such as item codes, names, quantities, and prices. The backend supports operations for adding new items, updating existing item details, and removing items from the system.

- **Order Processing** : The API facilitates the entire order lifecycle from initiation to completion. This includes processing sales transactions, tracking order statuses, and managing payment information.

Overall, the POS System Backend ensures seamless integration and operation of the POS system, enabling businesses to manage their sales, inventory, and customer interactions effectively through a set of robust API endpoints.

<hr/>

## Contents
- [Key Features](#key-features)
- [Technology Stack](#technology-stack)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Folder Structure](#folder-structure)
- [API References](#api-references)
- [License](#license)

<hr/>

## Key Features

- **Customer Record Management** : Efficiently handles the creation, retrieval, updating, and deletion of customer profiles. This feature ensures that customer information is accurately maintained and easily accessible for personalized service and transaction history.


- **Order Processing and Inventory Management** : Manages the complete order lifecycle, from order initiation to completion. It tracks sales transactions, updates inventory levels in real-time, and supports inventory management tasks to ensure optimal stock levels.


- **Real-Time Item Quantity Updates** : Provides immediate updates on item quantities as sales occur or inventory is adjusted. This feature helps in maintaining accurate stock counts and prevents discrepancies between physical and system inventory.


- **Discount Application and Total Calculations** : Allows for the application of discounts to orders and performs precise calculations of totals, including tax and final amount. This ensures that pricing adjustments are accurately reflected in transaction totals.


- **Secure Endpoints with Authentication** : Ensures that all API endpoints are protected by robust authentication mechanisms. This feature safeguards sensitive data and system operations by allowing access only to authorized users, thereby enhancing overall system security.

<hr/>

## Technology Stack

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

- **Backend** : Spring, Spring Web MVC, Spring Data JPA, Hibernate
- **Database** : MySQL

<hr/>

## Setup Instructions

### Prerequisites

- Java 11 or later
- Maven (for dependency management)
- SLF4J with Logback
- Any IDE (e.g., IntelliJ IDEA or Eclipse) for backend development

### Installation

1. **Clone the repository** :
    ```bash
     git clone https://github.com/charmiesw/AAD-Phase2-POS-BackEnd
     ```
    
2. **Backend setup**:
    - Navigate to the backend folder.
    - Run the Spring application.
    - Create a MySQL database named `pos_aad`.
    - The backend server should now be running on.

<hr/>

## Usage

1. **Customer Management** : Use the "Customers" section to add, edit, view or delete customer details.
2. **Item Management** : Go to the "Items" section to manage product information like name, description and unitprice.
3. **Place Orders** : Select items from inventory, specify quantities, and place orders.
4. **View Orders** : View the details of previous orders, including customer and item information.

<hr/>

## Folder Structure

```plaintext
AAD Phase2 POS BackEnd/
├── src/
|  ├── main/
│     ├── java/      # Spring-based backend code
│     └── webapp/    # Application configuration
|
└── pom.xml   # Maven dependencies
```

<hr/>

## API References
For detailed API documentation, please refer to the project’s Swagger UI available.

This documentation provides interactive access to the following APIs and Refer to the project Documentations :

- **Customer API documentation URL :**  [https://documenter.getpostman.com/view/35386294/2sAXxV59QW]
- **Item API documentation URL :**  [https://documenter.getpostman.com/view/35386294/2sAXxV59QY]
- **Order API documentation URL :**  [https://documenter.getpostman.com/view/35386294/2sAXxV59Qa]
- **Order Details API documentation URL :**  [https://documenter.getpostman.com/view/35386294/2sAXxV59QZ]

You can reffer to the json formats of the postman APIs as (src/main/resources/postman)

<hr/>

## License
This project is licensed under the MIT License. See the [LICENSE](https://github.com/charmiesw/AAD-Phase2-POS-BackEnd/blob/main/LISENSE.md) file for details.

<div align="center">

#### © 2024 All Right Reserved, Designed By [Charmie Weerapperuma](https://github.com/charmiesw)

</div>

<hr/>
