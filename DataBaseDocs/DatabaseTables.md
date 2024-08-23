database : innovatehub

create database innovatehub;
use innovatehub;

CREATE TABLE Orders (
OrderID int AUTO_INCREMENT,
OrderName varchar(255) NOT NULL,
PRIMARY KEY (OrderID)
);

CREATE TABLE Product (
ProductID int AUTO_INCREMENT,
ProductName varchar(255) NOT NULL,
Brand varchar(255) NOT NULL,
Description varchar(255) NOT NULL,
ProductUrl varchar(255) NOT NULL,
PRIMARY KEY (ProductID)
);

CREATE TABLE Member (
MemberID int AUTO_INCREMENT,
MemberName varchar(255) NOT NULL,
MemberUrl varchar(255) NOT NULL,
PRIMARY KEY (MemberID)
);

CREATE TABLE Category (
CategoryID int AUTO_INCREMENT,
CategoryName varchar(255) NOT NULL,
PRIMARY KEY (CategoryID)
);

CREATE TABLE Tag (
TagID int AUTO_INCREMENT,
TagName varchar(255) NOT NULL,
PRIMARY KEY (TagID)
);

CREATE TABLE Role (
RoleID int AUTO_INCREMENT,
RoleName varchar(255) NOT NULL,
PRIMARY KEY (RoleID)
);

CREATE TABLE ProductMember (
Id int AUTO_INCREMENT,
ProductID int NOT NULL,
MemberID int NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
FOREIGN KEY (MemberID) REFERENCES Member(MemberID)
);

CREATE TABLE MemberRole (
Id int AUTO_INCREMENT,
MemberID int NOT NULL,
RoleID int NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (MemberID) REFERENCES Member(MemberID),
FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);

CREATE TABLE ProductCategory (
Id int AUTO_INCREMENT,
ProductID int NOT NULL,
CategoryID int NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

CREATE TABLE ProductTag (
Id int AUTO_INCREMENT,
ProductID int NOT NULL,
TagID int NOT NULL,
PRIMARY KEY (Id),
FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
FOREIGN KEY (TagID) REFERENCES Tag(TagID)
);

CREATE TABLE ProductMeeting (
MeetingId int AUTO_INCREMENT,
ProductID int NOT NULL,
MeetingName int NOT NULL,
PRIMARY KEY (MeetingId),
FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

CREATE TABLE User (
UserID int AUTO_INCREMENT,
UserName varchar(255) NOT NULL,
Password varchar(255) NOT NULL,
roleId int NOT NULL,
PRIMARY KEY (UserID));

insert into User(UserName,Password,roleId) values('TestUser1', '$2a$12$gUx/v.wOsIdFctF.vzZ4p.8/PlBMaTM.JKCI.yR/FCMSzxk2NHhIu', 1);