CREATE TABLE cinema (
    id int,
    movie varchar(31),
    description varchar(100),
    rating float(1)
);
SELECT id, movie, description, rating FROM cinema WHERE mod(id, 2)=1 AND description <> 'boring' ORDER BY rating DESC;