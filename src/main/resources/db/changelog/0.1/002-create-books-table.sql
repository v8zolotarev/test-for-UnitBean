CREATE TABLE books (
id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
published_year INT,
author_id BIGINT NOT NULL,
CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES authors(id)
);