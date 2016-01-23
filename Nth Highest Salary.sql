/*
    Write a SQL query to get the nth highest salary from the Employee table.
    
    Link: https://leetcode.com/problems/nth-highest-salary/

    Example: For example, given the above Employee table, the nth highest salary where n = 2 is 200. 
    If there is no nth highest salary, then the query should 

    Solution: None
    
    Source: https://leetcode.com/discuss/26779/my-accepted-simply-solution-any-advising
*/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set N = N-1;
  RETURN (
    select distinct Salary from Employee order by Salary desc limit N, 1
  );
END