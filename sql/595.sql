Create table If Not Exists World (
    name varchar (255),
    continent varchar (255),
    area int,
    population int,
    gdp BIGINT
);
Truncate Table World;
Insert Into World (name, continent, area, population, gdp)
       Values ('Afghanistan', 'Asia', '652230', '25500100', '20343000000');
Insert Into World (name, continent, area, population, gdp)
       Values ('Albania', 'Europe', '28748', '2831741', '12960000000');
Insert Into World (name, continent, area, population, gdp)
       Values ('Algeria', 'Africa', '2381741', '37100000', '188681000000');
Insert Into World (name, continent, area, population, gdp)
       Values ('Andorra', 'Europe', '468', '78115', '3712000000');
Insert Into World (name, continent, area, population, gdp)
       Values ('Angola', 'Africa', '1246700', '20609294', '100990000000');

# Write your MySQL query statement below
SELECT
 name,
 population,
 area
FROM World
WHERE
    area > 3000000
    OR population > 25000000
;


