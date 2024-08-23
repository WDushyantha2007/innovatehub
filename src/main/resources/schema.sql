CREATE TABLE IF NOT EXISTS `orders` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `OrderName` varchar(255) NOT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `product` (
  `ProductID` int NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `ProductUrl` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `member` (
  `MemberID` int NOT NULL AUTO_INCREMENT,
  `MemberName` varchar(255) NOT NULL,
  `MemberUrl` varchar(255) NOT NULL,
  PRIMARY KEY (`MemberID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `tag` (
  `TagID` int NOT NULL AUTO_INCREMENT,
  `TagName` varchar(255) NOT NULL,
  PRIMARY KEY (`TagID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `role` (
  `RoleID` int NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(255) NOT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `productmember` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `MemberID` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `ProductID` (`ProductID`),
  KEY `MemberID` (`MemberID`),
  CONSTRAINT `productmember_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `productmember_ibfk_2` FOREIGN KEY (`MemberID`) REFERENCES `member` (`MemberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `memberrole` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `MemberID` int NOT NULL,
  `RoleID` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `MemberID` (`MemberID`),
  KEY `RoleID` (`RoleID`),
  CONSTRAINT `memberrole_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `member` (`MemberID`),
  CONSTRAINT `memberrole_ibfk_2` FOREIGN KEY (`RoleID`) REFERENCES `role` (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `productcategory` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `CategoryID` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `ProductID` (`ProductID`),
  KEY `CategoryID` (`CategoryID`),
  CONSTRAINT `productcategory_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `productcategory_ibfk_2` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`CategoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `producttag` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `TagID` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `ProductID` (`ProductID`),
  KEY `TagID` (`TagID`),
  CONSTRAINT `producttag_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`),
  CONSTRAINT `producttag_ibfk_2` FOREIGN KEY (`TagID`) REFERENCES `tag` (`TagID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `roleId` int NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `productmeeting` (
  `MeetingId` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `MeetingName` int NOT NULL,
  PRIMARY KEY (`MeetingId`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `productmeeting_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;