# https://leetcode.com/problems/rank-scores/

Create table If Not Exists Scores (Id int, Score DECIMAL(3,2));
Truncate table Scores;
insert into Scores (Id, Score) values ('1', '3.5');
insert into Scores (Id, Score) values ('2', '3.65');
insert into Scores (Id, Score) values ('3', '4.0');
insert into Scores (Id, Score) values ('4', '3.85');
insert into Scores (Id, Score) values ('5', '4.0');
insert into Scores (Id, Score) values ('6', '3.65');

# Write your MySQL query statement below
# Case using self inequality join. Refer to a Book "達人に学ぶSQL徹底指南書"
SELECT
    s1.Score As Score,
    (
        SELECT COUNT(DISTINCT s2.Score)
        FROM Scores s2
        WHERE s2.Score > s1.Score
    ) + 1 AS Rank
FROM
    Scores s1
ORDER BY s1.Score DESC
;

# MySQL on LeetCode does not support Rank
SELECT
    Score,
    Rank() OVER (Order By Score Desc)
From Scores;
