/*
    Table: Person
		+-------------+---------+
		| Column Name | Type    |
		+-------------+---------+
		| PersonId    | int     |
		| FirstName   | varchar |
		| LastName    | varchar |
		+-------------+---------+

	PersonId is the primary key column for this table.
	Table: Address
		+-------------+---------+
		| Column Name | Type    |
		+-------------+---------+
		| AddressId   | int     |
		| PersonId    | int     |
		| City        | varchar |
		| State       | varchar |
		+-------------+---------+

	AddressId is the primary key column for this table.
    
    Link: https://leetcode.com/problems/combine-two-tables/

    Example: 
    	Write a SQL query for a report that provides the following information for each person in the Person table, 
    regardless if there is an address for each of those people:
		FirstName, LastName, City, State

    Solution: None
    
    Source: https://leetcode.com/discuss/21216/its-a-simple-question-of-left-join-my-solution-attached
*/

# Write your MySQL query statement below
SELECT Person.FirstName, Person.LastName, Address.City, Address.State from Person LEFT JOIN Address on Person.PersonId = Address.PersonId;