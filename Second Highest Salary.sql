/*
    Write a SQL query to get the second highest salary from the Employee table.
		+----+--------+
		| Id | Salary |
		+----+--------+
		| 1  | 100    |
		| 2  | 200    |
		| 3  | 300    |
		+----+--------+
    
    Link: https://leetcode.com/problems/second-highest-salary/

    Example: For example, given the above Employee table, the second highest salary is 200. If there is no second highest salary, 
    then the query should return null.

    Solution: None
    
    Source: https://leetcode.com/discuss/71174/easy-solution-for-this
*/

# Write your MySQL query statement below

select max(Salary) from Employee where Salary < (select max(Salary) from Employee) order by Salary desc;