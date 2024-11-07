CREATE TABLE readers (
id SERIAL PRIMARY KEY,
phone_number VARCHAR(15),
first_name VARCHAR(255),
last_name VARCHAR(255),
gender VARCHAR(10),
birth_date DATE
);