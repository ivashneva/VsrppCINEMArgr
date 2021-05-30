drop database if exists cinema;
create database cinema;
use cinema;

CREATE TABLE `users` (
    `ID` int NOT NULL AUTO_INCREMENT,
    `Login` text,
    `Password` text,
    `Mail` text,
    `Authority` text,
    PRIMARY KEY (`ID`)
);

CREATE TABLE `genre` (
     `ID` int NOT NULL AUTO_INCREMENT,
     `Name` text,
     PRIMARY KEY (`ID`)
);

CREATE TABLE `produsser` (
     `ID` int NOT NULL AUTO_INCREMENT,
     `Name` text,
     PRIMARY KEY (`ID`)
);

CREATE TABLE `film` (
    `ID` int NOT NULL AUTO_INCREMENT,
    `Name` text,
    `ID_Produsser` int not null,
    `ID_Genre` int not null,
    PRIMARY KEY (`ID`)
);

INSERT INTO users (Login, Password, Mail, Authority) values 
('admin', '$2y$12$xkOgR9cIkYrmQVuTo.Nks.zFZRSlGgka0K5tROOxPrgfKzU8a5qTa', 'admin@example.com', 'ROLE_ADMIN'),
('user', '$2y$12$sK4AggiYLkz1WMmNNbFk0O3t1F3UWcwg0vadq9Q3fevHxX754opJy', 'user@example.com', 'ROLE_GUEST');

INSERT INTO genre (Name) values
('Horror'),
('Comedy'),
('Romantic'),
('Adventure'),
('Science'),
('Fantasy');

INSERT INTO produsser (Name) values
('Ivan Ivanov'),
('Petr Petrov'),
('Sergei Sergeev'),
('Anna Karenina'),
('Christopher Nolan');

INSERT INTO film (Name, ID_Genre, ID_Produsser) values
('IT', 1, 3),
('Cat and Dog', 4, 1),
('How it works', 5, 1),
('Love story', 3, 2),
('Comedy Club', 2, 4),
('Prestige', 6, 5);
