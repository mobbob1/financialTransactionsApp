# tuumassessment
The tasks consist of implementing a small core banking solution:
• Account to keep track of current accounts, balances, and transaction history
• Capability to publish messages into RabbitMQ for other consumers

INSTRUCTION ON HOW TO READ THE APPLICATION
1.	Create the database and execute the dump file located in the root directory of the project
2.	Run the docker file and dockercompose.yml to get the environment ready.
3.	Access the application api and endpoints with the postman with the below endpoints
a.	localhost:8080/api/country/insertCountry  (Create the country)
b.	localhost:8080/api/account/createAccount  (Create the account)
c.	localhost:8080/api/account/findAccountById/{id}  (Find Account by ID)
d.	localhost:8080/api/customer/insertCustomer    (Create Customer)
e.	localhost:8080/api/transaction/createTransaction (Create Transaction)
f.	localhost:8080/api/transaction/findTransactionByAccountId/{id} (Find Transaction ID)
Note: The endpoints parameters are specified by the exact model/entity fields. 


IMPORTANT CHOICES MADE DURING DEVELOPMENT
1.	Comments were made to the blocks for codes to follow the clean coding practice and make the review clear.
2.	Lombok dependency was used to prevent boilerplate codes for the getter and setter.
3.	Notation for the constructor was also introduced.
4.	Aside from the specified requirements in the assignment, other assumptions were taken in case there is an expansion of codes in the future for other endpoints to be readily available.


PER SECOND MY APPLICATION CAN HANDLE 20 TRANSACTIONS ON MY DEVELOPMENT MACHINE

SCALING THE APPLICATION 
You can use the spring cloud project for extra added features like service discovery and other goodies that make scaling easier .

For load balancing you can either choose something like an Nginx or leave it to spring cloud which also has a lot of other handy features for scaling/clustering. Scaling shouldn't be very hard because spring boot runs on it's own server.


DATABASE SCRIPTS

CREATE DATABASE tuum
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE tuum
    IS 'For the tuum developer assignment';
