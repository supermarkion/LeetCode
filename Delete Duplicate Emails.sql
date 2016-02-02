/*
    Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
		+----+------------------+
		| Id | Email            |
		+----+------------------+
		| 1  | john@example.com |
		| 2  | bob@example.com  |
		| 3  | john@example.com |
		+----+------------------+
    
    Link: https://leetcode.com/problems/delete-duplicate-emails/

    Example: For example, after running your query, the above Person table should have the following rows:
		+----+------------------+
		| Id | Email            |
		+----+------------------+
		| 1  | john@example.com |
		| 2  | bob@example.com  |
		+----+------------------+

    Solution: None
    
    Source: https://leetcode.com/discuss/76274/very-easy-to-understand
*/

# Write your MySQL query statement below

DELETE p2 FROM Person p1, Person p2 WHERE p1.Email = p2. Email AND p1.Id < p2.Id