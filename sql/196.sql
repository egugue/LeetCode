# https://leetcode.com/problems/delete-duplicate-emails/

DROP TABLE Person;

CREATE TABLE Person(
    Id  INTEGER PRIMARY KEY,
    Email VARCHAR(255) NOT NULL
);

INSERT INTO Person (Id, Email) VALUES
    (1, 'john@example.com'),
    (2, 'bob@example.com'),
    (3, 'john@example.com'),
    (4, 'john@example.com')
;

# Write your MySQL query statement below
DELETE
    p1
FROM Person p1, Person p2
WHERE
    p1.Email = p2.email
    AND p1.Id > p2.Id
;
