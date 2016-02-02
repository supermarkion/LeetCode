/*
    Write a SQL query to find all duplicate emails in a table named Person.
		+----+---------+
		| Id | Email   |
		+----+---------+
		| 1  | a@b.com |
		| 2  | c@d.com |
		| 3  | a@b.com |
		+----+---------+
    
    Link: https://leetcode.com/problems/duplicate-emails/

    Example: For example, your query should return the following for the above table:
		+---------+
		| Email   |
		+---------+
		| a@b.com |
		+---------+

    Solution: None
    
    Source: https://leetcode.com/discuss/53206/a-solution-using-a-group-by-and-another-one-using-a-self-join
*/

# Write your MySQL query statement below

SELECT Email from Person
Group By Email
Having Count(*) > 1;