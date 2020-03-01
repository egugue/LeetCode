# https://leetcode.com/problems/rising-temperature/

Create table If Not Exists Weather (Id int, RecordDate date, Temperature int);
Truncate Table Weather;
Insert Into Weather (Id, RecordDate, Temperature) Values ('1', '2015-01-01', '10');
Insert Into Weather (Id, RecordDate, Temperature) Values ('2', '2015-01-02', '25');
Insert Into Weather (Id, RecordDate, Temperature) Values ('3', '2015-01-03', '20');
Insert Into Weather (Id, RecordDate, Temperature) Values ('4', '2015-01-04', '30');
Insert Into Weather (Id, RecordDate, Temperature) Values ('4', '2015-01-04', '30');

# Write your MySQL query statement below
SELECT
    w1.Id
FROM
    Weather w1, Weather w2
WHERE
    w1.RecordDate = ADDDATE(w2.RecordDate, 1)
    AND w1.Temperature > w2.Temperature
;
