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
CREATE TABLE User (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      role VARCHAR(20) NOT NULL
);



DELIMITER //
CREATE PROCEDURE show_list(
)
BEGIN
    SELECT book.name, book.description, book.image_url, book.status, category.category_name, Publisher.publisher_name
    FROM book
             Join Publisher on book.publisher_id = Publisher.publisher_id
             join category on book.category_id = category.category_id;
end //
DELIMITER ;
select customer_id, customer_name, customer_code, customer_class, customer_address,customer_birthday, customer_is_active from customers;
ALTER TABLE Customers ADD COLUMN is_deleted BOOLEAN DEFAULT FALSE;
SELECT customer_id, customer_name, customer_code,
            customer_class, customer_address, customer_birthday, customer_is_active FROM customers WHERE is_deleted = FALSE;
select borrow_transactions_id,customer_name, customer_code, customer_class, customer_birthday, name, image_url, status, category_name, publisher_name, borrow_date, return_date, status_borrow_type from customers
    join borrow_transactions on customers.customer_id = borrow_transactions.customer_id
join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id
join Book on borrow_transactions.book_id = Book.book_id
join category on Book.category_id = category.category_id
join publisher on Book.publisher_id = publisher.publisher_id
WHERE Customers.is_deleted = false;
use book_manager;
create database demo;
select borrow_transactions_id, customer_name, customer_code, name, status_borrow_type from Customers
join borrow_transactions  on Customers.customer_id = borrow_transactions.customer_id
join Book on borrow_transactions.book_id = Book.book_id
join status_borrow on borrow_transactions.status_borrow_id = status_borrow.status_borrow_id
where Customers.is_deleted = false;

=======

SELECT b.*, c.category_name, p.publisher_name
FROM Book b
         JOIN Category c ON b.category_id = c.category_id
         JOIN Publisher p ON b.publisher_id = p.publisher_id
WHERE c.category_name LIKE 'Ngôn Tình';

DELIMITER //

CREATE PROCEDURE deleteCategory(IN categoryId INT)
BEGIN
    DELETE FROM Category WHERE category_id = categoryId;
END //

DELIMITER ;

