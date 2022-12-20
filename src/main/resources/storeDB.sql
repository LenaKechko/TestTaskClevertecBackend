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

DROP TABLE IF EXISTS  employee;

DROP TABLE IF EXISTS product;

DROP TABLE IF EXISTS discount_card;

CREATE TABLE product (
	id int UNIQUE,
	name varchar(100),
	price real,
	promotion boolean DEFAULT false,
	tax real DEFAULT 0.0,
	PRIMARY KEY(id)
);

CREATE TABLE discount_card (
	number_card int UNIQUE
);

CREATE TABLE employee (
	id int UNIQUE,
	name varchar(100),
	address_store varchar(100),
	PRIMARY KEY(id)
);

INSERT INTO product VALUES (1, 'milk', 1.26),
                           (2, 'bread', 1.01);
INSERT INTO product VALUES (3, 'butter', 2.5, true);
INSERT INTO product VALUES (4, 'salt', 0.9);
INSERT INTO product VALUES (5, 'meat', 5.7, true),
                           (6, 'sugar', 2.3, true);
INSERT INTO product VALUES (7, 'sausage', 4.38),
                           (8, 'egg', 2.89);

INSERT INTO discount_card VALUES (1234), (654), (751), (9871);

INSERT INTO employee VALUES (421, 'Natalia Ivanova', 'Sovetskaya, 4'),
                            (357, 'Svetlana Petrova', 'Kirova, 1'),
                            (946, 'Elena Fedotova', 'Mazurova, 17');