# Write your MySQL query statement below
SELECT
  p.FirstName,
  p.LastName,
  a.City,
  a.State
FROM
  Person AS p
LEFT JOIN Address As a
  ON p.PersonId = a.PersonId
;