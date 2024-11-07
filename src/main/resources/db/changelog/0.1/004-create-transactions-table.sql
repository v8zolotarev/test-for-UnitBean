CREATE TABLE transactions (
id SERIAL PRIMARY KEY,
transaction_type VARCHAR(50) NOT NULL,
timestamp TIMESTAMP NOT NULL,
reader_id BIGINT NOT NULL,
book_id BIGINT NOT NULL,
CONSTRAINT fk_transaction_reader FOREIGN KEY (reader_id) REFERENCES readers(id),
CONSTRAINT fk_transaction_book FOREIGN KEY (book_id) REFERENCES books(id)
);