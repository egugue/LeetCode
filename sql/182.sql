# https://leetcode.com/problems/duplicate-emails

DROP TABLE Person;

CREATE TABLE Person(
    Id  INTEGER PRIMARY KEY,
    Email VARCHAR(255) NOT NULL
);

INSERT INTO Person (Id, Email) VALUES
    (1, 'a@b.com'),
    (2, 'c@d.com'),
    (3, 'a@b.com'),
    (4, 'c@d.com'),
    (5, 'x@y.com')
;

# Write your MySQL query statement below
# Case of Using Self Join
SELECT DISTINCT
    p1.Email
FROM
    Person p1, Person p2
WHERE
    p1.Id <> p2.Id
    AND p1.Email = p2.Email
;

# Case of Using EXISTS
SELECT DISTINCT
    p1.Email
FROM
    Person p1
WHERE EXISTS (
    SELECT
        *
    FROM
        Person p2
    WHERE
        p1.Id <> p2.Id
        AND p1.Email = p2.Email
);

# Case of Group By which is official approach 2
SELECT
    p1.Email
FROM
    Person p1
GROUP BY
    p1.Email
HAVING
    COUNT(p1.Email) > 1
;
