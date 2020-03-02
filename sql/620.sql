# https://leetcode.com/problems/not-boring-movies/

Create table If Not Exists cinema (id int, movie varchar(255), description varchar(255), rating float(2, 1));
Truncate Table cinema;
Insert Into cinema (id, movie, description, rating) Values ('1', 'War', 'great 3D', '8.9');
Insert Into cinema (id, movie, description, rating) Values ('2', 'Science', 'fiction', '8.5');
Insert Into cinema (id, movie, description, rating) Values ('3', 'irish', 'boring', '6.2');
Insert Into cinema (id, movie, description, rating) Values ('4', 'Ice song', 'Fantacy', '8.6');
Insert Into cinema (id, movie, description, rating) Values ('5', 'House card', 'Interesting', '9.1');

# Write your MySQL query statement below
Select
    id,
    movie,
    description,
    rating
From
    cinema
Where
    (id % 2) = 1
    AND description <> 'boring'
Order by rating Desc
;
