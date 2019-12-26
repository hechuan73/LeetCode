CREATE TABLE World (
    name varchar(11),
    continent varchar(11),
    area int,
    population long,
    gdp long
);

SELECT name, population, area FROM World WHERE area > 3000000 OR population > 25000000;