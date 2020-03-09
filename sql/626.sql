# https://leetcode.com/problems/exchange-seats/

Create table If Not Exists seat(id int, student varchar(255));
Truncate Table seat;
Insert Into seat (id, student) Values ('1', 'Abbot');
Insert Into seat (id, student) Values ('2', 'Doris');
Insert Into seat (id, student) Values ('3', 'Emerson');
Insert Into seat (id, student) Values ('4', 'Green');
Insert Into seat (id, student) Values ('5', 'Jeames');

# Write your MySQL query statement below
# 172 ms	0B
Select
    COALESCE(s2.id, s1.id) As id,
    s1.student As student
From
    seat s1
Left Join seat s2 On s1.id = (
    Case When Mod(s2.id, 2) = 0
    Then s2.id - 1
    Else s2.id + 1
    END)
;
