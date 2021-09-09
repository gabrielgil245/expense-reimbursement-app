# expense-reimbursement-app

## Project Description
The Expense Reimbursement App will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used
* Java
* Maven
* PostgresSQL
* Java Database Connectivity
* JUnit
* Mockito
* Servlets
* Jackson 
* HTML & CSS
* JavaScript
* AJAX (Fetch API)
* Bootstrap 5

## Features
* Enable employees to manage their reimbursement requests.
* Employees are able submit requests for reimbursements, and view their past and pending reimbursement tickets. 
* Enable finance managers to view all employees' reimbursement requests and past tickets. 
* Finance managers are able to resolve employees' reimbursement request via the app.
* Relocate user to login or dashboard page(s), based on whether the user is in a session from logging in.

Todo-list:
* Enable employees to upload a document/image of their receipt when submitting a reimbursement request.
* Hash/Encrypt users' passwords in Java and storing the passwords in the database for security purposes.
* Notify an employee via email via the application, when they have been registered as a user, providing them a temporary password.

## Getting Started
* git clone https://github.com/gabrielgil245/expense-reimbursement-app
* Create a class called ConnectionUtilities in the dao package
* In the class, create three static String variables [url], [username], [password]
* The value for the url variable will be "jdbc:postgresql://{HostServer}/{DatabaseName}
* The username and password variables will need the values for your HostServer credentials
* Tomcat Server Plugin is utilized; deployment path must reach the webapp
* Context path is set to the project's name "/expense-reimbursement-system"
* Keep Server & Admin ports to the default values (8080 and 8005 respectively)
