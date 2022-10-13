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
    
    
    -- Table: public.account

-- DROP TABLE IF EXISTS public.account;

CREATE TABLE IF NOT EXISTS public.account
(
    accountid integer NOT NULL DEFAULT nextval('account_id_seq'::regclass),
    balance numeric,
    customer integer,
    currency character varying COLLATE pg_catalog."default",
    country character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT account_pkey PRIMARY KEY (accountid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account
    OWNER to postgres;
    
    
    -- Table: public.country

-- DROP TABLE IF EXISTS public.country;

CREATE TABLE IF NOT EXISTS public.country
(
    id integer NOT NULL DEFAULT nextval('country_id_seq'::regclass),
    name character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT country_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.country
    OWNER to postgres;
    
    
    -- Table: public.customer

-- DROP TABLE IF EXISTS public.customer;

CREATE TABLE IF NOT EXISTS public.customer
(
    customer_id integer NOT NULL DEFAULT nextval('"customer_customerId_seq"'::regclass),
    customer_name text COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;
    
    
    -- Table: public.transaction

-- DROP TABLE IF EXISTS public.transaction;

CREATE TABLE IF NOT EXISTS public.transaction
(
    "transactionId" integer NOT NULL DEFAULT nextval('"transaction_transactionId_seq"'::regclass),
    accountid integer,
    amount numeric,
    currency character varying(5) COLLATE pg_catalog."default",
    transactiondirection character varying(3) COLLATE pg_catalog."default",
    description character varying COLLATE pg_catalog."default",
    balance numeric,
    CONSTRAINT transaction_pkey PRIMARY KEY ("transactionId")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaction
    OWNER to postgres;
