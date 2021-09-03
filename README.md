# expense-reimbursement-system

Name: Gabriel Gil

Description: Expense Reimbursement System

Functionality: Enable employees to manage their reimbursement requests.
Employees are able submit requests for reimbursements, and view their past 
and pending reimbursement tickets. Furthermore, the app enables the finance
managers to view all reimbursement requests and past tickets. Also, the finance
managers are able to resolve employees' reimbursement request via the app.

Technologies used: Java, Maven, PostgresSQL, Java Database Connectivity,
JUnit, Mockito, Servlets, Jackson, HTML, CSS,
JavaScript, AJAX (Fetch API), and Bootstrap 5

Future improvements:
1.) Enable employees to upload a document/image of their receipt when submitting 
a reimbursement request.
2.) Hashing/Encrypting users' passwords in Java and storing the passwords in the 
database for security purposes.
3.) Notifying an employee via email via the application,
when they have been registered as a new user, providing them a temporary password.

Setup:
1.) Create a class called ConnectionUtilities in the dao package
2.) In the class, create three static String variables [url], [username], [password]
3.) The value for the url variable will be "jdbc:postgresql://{HostServer}/{DatabaseName}
4.) The username and password variables will need the values for your HostServer credentials
5.) Tomcat Server Plugin is utilized; deployment path must reach the webapp
6.) Context path is set to the project's name "/expense-reimbursement-system"
7.) Keep Server & Admin ports to 8080 and 8005 respectively