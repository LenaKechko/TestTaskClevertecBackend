-- Database: storeDB

-- DROP DATABASE IF EXISTS "storeDB";

-- CREATE DATABASE "storeDB"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'Russian_Belarus.1251'
--     LC_CTYPE = 'Russian_Belarus.1251'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS Employee;

DROP TABLE IF EXISTS Product;

DROP TABLE IF EXISTS Discount_card;

CREATE TABLE Product (
	id int UNIQUE,
	name varchar(100),
	price real,
	promotion boolean DEFAULT false,
	PRIMARY KEY(id)
);

CREATE TABLE Discount_card (
	number_card int UNIQUE
);

CREATE TABLE Employee (
	id int UNIQUE,
	name varchar(100),
	address_store varchar(100),
	PRIMARY KEY(id)
);

INSERT INTO Product VALUES (1, 'milk', 1.26),
                           (2, 'bread', 1.01);
INSERT INTO Product VALUES (3, 'butter', 2.5, true);
INSERT INTO Product VALUES (4, 'salt', 0.9);
INSERT INTO Product VALUES (5, 'meat', 5.7, true),
                           (6, 'sugar', 2.3, true);
INSERT INTO Product VALUES (7, 'sausage', 4.38),
                           (8, 'egg', 2.89);

INSERT INTO Discount_card VALUES (1234), (654), (751), (9871);

INSERT INTO Employee VALUES (421, 'Natalia Ivanova', 'Sovetskaya, 4'),
                            (357, 'Svetlana Petrova', 'Kirova, 1'),
                            (946, 'Elena Fedotova', 'Mazurova, 17');