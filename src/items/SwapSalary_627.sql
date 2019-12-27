CREATE TABLE salary (
    id int,
    name varchar(11),
    sex char(1),
    salary int
);

# solution 1
UPDATE salary SET sex = CASE sex WHEN "m" THEN "f" ELSE "m" END;
# solution 2
UPDATE salary SET sex = IF(sex = "m", "f", "m");