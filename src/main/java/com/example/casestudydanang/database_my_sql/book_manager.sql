CREATE DATABASE book_manager;
USE book_manager;

CREATE TABLE Category
(
    category_id   INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(250) NOT NULL
);
CREATE TABLE Publisher
(
    publisher_id   INT AUTO_INCREMENT PRIMARY KEY,
    publisher_name VARCHAR(250) NOT NULL
);

CREATE TABLE Book
(
    book_id      INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(250) NOT NULL,
    description  VARCHAR(250),
    image_url    VARCHAR(250),
    status       BIT          NOT NULL,
    category_id  INT,
    publisher_id INT,
    FOREIGN KEY (category_id) REFERENCES Category (category_id),
    FOREIGN KEY (publisher_id) REFERENCES Publisher (publisher_id),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE Customers
(
    customer_id        INT AUTO_INCREMENT PRIMARY KEY,
    customer_name      VARCHAR(250) NOT NULL,
    customer_code      VARCHAR(250) NOT NULL,
    customer_class     VARCHAR(250),
    customer_address   VARCHAR(250),
    customer_birthday  DATE,
    customer_is_active BOOLEAN DEFAULT TRUE
);
CREATE TABLE status_borrow
(
    status_borrow_id   INT AUTO_INCREMENT PRIMARY KEY,
    status_borrow_type VARCHAR(250)
);
CREATE TABLE borrow_transactions
(
    borrow_transactions_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id            INT,
    book_id                INT,
    borrow_date            DATE NOT NULL,
    return_date            DATE,
    status_borrow_id        INT,
    FOREIGN KEY (customer_id) references Customers(customer_id),
    FOREIGN KEY (book_id) references  Book(book_id),
    FOREIGN KEY (status_borrow_id) references status_borrow(status_borrow_id)
);

DELIMITER //

CREATE PROCEDURE deleteCategory(IN categoryId INT)
BEGIN
    DELETE FROM Category WHERE category_id = categoryId;
END //

DELIMITER ;
select borrow_transactions_id, customer_name, customer_code, customer_class, name, status_borrow_type from Customers
join  borrow_transactions on Customers.customer_id = borrow_transactions.customer_id
join Book on borrow_transactions.book_id = Book.book_id
join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id
where customer_code = ?;

ALTER TABLE customers
    ADD COLUMN is_deleted boolean ;
SELECT
    bt.borrow_transactions_id,
    c.customer_name,
    c.customer_code,
    b.name AS book_name,
    sb.status_borrow_type
FROM
    Customers c
        JOIN
    borrow_transactions bt ON c.customer_id = bt.customer_id
        JOIN
    Book b ON bt.book_id = b.book_id
        JOIN
    status_borrow sb ON bt.status_borrow_id = sb.status_borrow_id
WHERE
    bt.return_date < CURRENT_DATE
  AND bt.status_borrow_id != 3;
ALTER TABLE Customers
    MODIFY COLUMN customer_is_active BOOLEAN DEFAULT FALSE;
select count(*) from Customers;