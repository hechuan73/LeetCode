# Write your MySQL query statement below
CREATE TABLE Person(
                       Id varchar(11) not null primary key,
                       Email varchar(30) not null
);

DELETE p1 FROM Person p1, Person p2 where p1.Email = p2.Email AND p1.Id > P2.Id;

DELETE FROM Person WHERE Id NOT IN
    (SELECT * FROM (
        SELECT MIN(Id) FROM Person GROUP BY Email)
        as p);