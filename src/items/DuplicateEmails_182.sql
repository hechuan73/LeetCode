# Write your MySQL query statement below
CREATE TABLE Person(
    Id varchar(11) not null primary key,
    Email varchar(30) not null
);
SELECT Email From Person GROUP BY Email HAVING COUNT(*) > 1;