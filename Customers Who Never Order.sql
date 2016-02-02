/*
    Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who 
    never order anything.
	
	Table: Customers.
		+----+-------+
		| Id | Name  |
		+----+-------+
		| 1  | Joe   |
		| 2  | Henry |
		| 3  | Sam   |
		| 4  | Max   |
		+----+-------+

	Table: Orders.
		+----+------------+
		| Id | CustomerId |
		+----+------------+
		| 1  | 3          |
		| 2  | 1          |
		+----+------------+
	    
    Link: https://leetcode.com/problems/customers-who-never-order/

    Example: Using the above tables as example, return the following:
		+-----------+
		| Customers |
		+-----------+
		| Henry     |
		| Max       |
		+-----------+

    Solution: None
    
    Source: https://leetcode.com/discuss/33366/my-simple-way-with-left-outer-join
*/

# Write your MySQL query statement below

SELECT C.Name
FROM Customers  AS C LEFT OUTER JOIN Orders AS O
ON C.Id = O.CustomerId
WHERE O.CustomerId IS NULL;