# Write your MySQL query statement below

CREATE TABLE Person
(
    PersonId  INT(11) NOT NULL PRIMARY KEY,
    FirstName VARCHAR(20),
    LastName  VARCHAR(20)
);
CREATE TABLE Address
(
    AddressId  INT(11) NOT NULL,
    PersonId  INT(11) ,
    City VARCHAR(20),
    State  VARCHAR(20),
    PRIMARY KEY (`AddressId`),
    KEY `PersonId`(`PersonId`),
    CONSTRAINT `fk_address_person` FOREIGN KEY (`PersonId`) REFERENCES `Person`(PersonId)
        ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 使用where语句会过滤掉那些没有address的person，所以这里用outer join
SELECT FirstName, LastName, City, State
FROM Person LEFT JOIN Address
ON Person.PersonId = Address.PersonId;