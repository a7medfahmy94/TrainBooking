DROP DATABASE IF EXISTS bookingSystem;

CREATE DATABASE bookingSystem;

USE bookingSystem;

CREATE TABLE user (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
is_admin BOOL DEFAULT 0
);

CREATE TABLE train(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
capacity INT NOT NULL
);

CREATE TABLE trip(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
position VARCHAR(100) NOT NULL,
destination VARCHAR(100) NOT NULL,
note VARCHAR(1000) NOT NULL,
datetime DATETIME NOT NULL,
price INT NOT NULL,
train_id INT,

FOREIGN KEY (train_id) REFERENCES train(id)
);


CREATE TABLE booked(
trip_id INT,
user_id INT,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (trip_id) REFERENCES trip(id)
);

insert into user (name, email, password, is_admin) VALUES('admin','admin','admin',true);
