# https://leetcode.com/problems/human-traffic-of-stadium/

Create table If Not Exists stadium (id int, visit_date DATE NULL, people int);
Truncate table stadium;
insert into stadium (id, visit_date, people) values ('1', '2017-01-01', '10');
insert into stadium (id, visit_date, people) values ('2', '2017-01-02', '109');
insert into stadium (id, visit_date, people) values ('3', '2017-01-03', '150');
insert into stadium (id, visit_date, people) values ('4', '2017-01-04', '99');
insert into stadium (id, visit_date, people) values ('5', '2017-01-05', '145');
insert into stadium (id, visit_date, people) values ('6', '2017-01-06', '1455');
insert into stadium (id, visit_date, people) values ('7', '2017-01-07', '199');
insert into stadium (id, visit_date, people) values ('8', '2017-01-08', '188');


# Write your MySQL query statement below
# 218 ms	0B
Select Distinct
    s1.id,
    s1.visit_date,
    s1.people
From stadium s1, stadium s2, stadium s3
Where s1.people >= 100
    And s2.people >= 100
    And s3.people >= 100
    And (
        (s1.id = s2.id - 1 and s1.id = s3.id  - 2)
        OR (s2.id = s3.id - 1 and s2.id = s1.id - 2)
        OR (s3.id = s1.id - 1 and s3.id = s2.id - 2)
    )
Order By s1.id
;
