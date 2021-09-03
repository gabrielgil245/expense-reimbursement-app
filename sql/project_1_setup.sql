CREATE TABLE ers_user_roles(
ers_user_role_id SMALLINT PRIMARY KEY NOT NULL,
user_role varchar(20) NOT NULL
);

INSERT INTO ers_user_roles VALUES (1, 'Employee');
INSERT INTO ers_user_roles VALUES (2, 'Finance Manager');

SELECT * FROM ers_user_roles;

CREATE TABLE ers_users(
ers_users_id SERIAL PRIMARY KEY NOT NULL,
ers_username varchar(50) UNIQUE NOT NULL,
ers_password varchar(50) NOT NULL,
user_first_name varchar(100) NOT NULL,
user_last_name varchar(100) NOT NULL,
user_email varchar(150) UNIQUE NOT NULL,
user_role_id SMALLINT REFERENCES ers_user_roles(ers_user_role_id) NOT NULL
);

SELECT * FROM ers_users;

CREATE TABLE ers_reimbursement_type(
reimb_type_id SMALLINT PRIMARY KEY NOT NULL,
reimb_type varchar(10) NOT NULL
);

INSERT INTO ers_reimbursement_type VALUES (1, 'LODGING');
INSERT INTO ers_reimbursement_type VALUES (2, 'TRAVEL');
INSERT INTO ers_reimbursement_type VALUES (3, 'FOOD');
INSERT INTO ers_reimbursement_type VALUES (4, 'OTHER');

SELECT * FROM ers_reimbursement_type;

CREATE TABLE ers_reimbursement_status(
reimb_status_id SMALLINT PRIMARY KEY NOT NULL,
reimb_status varchar(10) NOT NULL
);

INSERT INTO ers_reimbursement_status VALUES (1, 'Pending');
INSERT INTO ers_reimbursement_status VALUES (2, 'Approved');
INSERT INTO ers_reimbursement_status VALUES (3, 'Denied');

SELECT * FROM ers_reimbursement_status;

CREATE TABLE ers_reimbursement(
reimb_id SERIAL PRIMARY KEY NOT NULL,
reimb_amount NUMERIC(10,2) NOT NULL,
reimb_submitted timestamp DEFAULT current_timestamp NOT NULL,
reimb_resolved timestamp DEFAULT current_timestamp,
reimb_description varchar(250),
reimb_receipt bytea,
reimb_author integer REFERENCES ers_users(ers_users_id) NOT NULL,
reimb_resolver integer REFERENCES ers_users(ers_users_id),
reimb_status_id SMALLINT DEFAULT 1 REFERENCES ers_reimbursement_status(reimb_status_id) NOT NULL,
reimb_type_id SMALLINT REFERENCES ers_reimbursement_type(reimb_type_id) NOT NULL
);

ALTER TABLE ers_reimbursement ALTER COLUMN reimb_status_id SET DEFAULT 1;

SELECT * FROM ers_users;
SELECT * FROM user_info;

SELECT * FROM ers_reimbursement;
SELECT * FROM reimbursement_tickets;

SELECT * FROM ers_user_roles;
SELECT * FROM ers_reimbursement_status;
SELECT * FROM ers_reimbursement_type;

INSERT INTO ers_users VALUES (DEFAULT, 'emp1', 'password',
'John', 'Smith', 'john.smith@test.com', 1);
INSERT INTO ers_users VALUES (DEFAULT, 'fmgr1', 'password',
'Jorge', 'Ramirez', 'j.ramirez@test.com', 2);

CREATE VIEW user_info AS
SELECT u.*, ur.user_role FROM ers_users AS u 
INNER JOIN ers_user_roles AS ur ON u.user_role_id = ur.ers_user_role_id;

--Get Login Crendentials
SELECT * FROM user_info WHERE ers_username = 'emp1' AND ers_password = 'password';
SELECT * FROM user_info WHERE ers_username = 'fmgr1' AND ers_password = 'password';

--Add Reimbursement Ticket
INSERT INTO ers_reimbursement VALUES (DEFAULT, 2000, DEFAULT,
NULL, 'souvenir for my kids', NULL, 1, NULL, DEFAULT, 4);

SELECT * FROM ers_reimbursement;

--View of the Reimbursement Tickets
CREATE VIEW reimbursement_tickets AS
SELECT re.*, rs.reimb_status, rt.reimb_type FROM ers_reimbursement AS re
INNER JOIN ers_reimbursement_status AS rs ON re.reimb_status_id = rs.reimb_status_id
INNER JOIN ers_reimbursement_type AS rt ON re.reimb_type_id = rt.reimb_type_id;

--Get Reimbursement Tickets as an Employee
SELECT * FROM reimbursement_tickets WHERE reimb_author = 1;

--Resolve/Update Reimbursement Ticket as a Finance Manager
UPDATE ers_reimbursement SET reimb_resolved = DEFAULT,
reimb_resolver = 2, reimb_status_id = 2 WHERE reimb_id = 1;

SELECT * FROM reimbursement_tickets;
SELECT * FROM reimbursement_tickets WHERE reimb_status_id = 2;
SELECT * FROM reimbursement_tickets WHERE reimb_status = 'Pending';
