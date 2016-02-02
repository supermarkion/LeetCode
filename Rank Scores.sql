/*
    Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. 
    Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, 
    there should be no "holes" between ranks.
		+----+-------+
		| Id | Score |
		+----+-------+
		| 1  | 3.50  |
		| 2  | 3.65  |
		| 3  | 4.00  |
		| 4  | 3.85  |
		| 5  | 4.00  |
		| 6  | 3.65  |
		+----+-------+
    
    Link: https://leetcode.com/problems/rank-scores/

    Example: For example, given the above Scores table, your query should generate the following report 
    (order by highest score):
		+-------+------+
		| Score | Rank |
		+-------+------+
		| 4.00  | 1    |
		| 4.00  | 1    |
		| 3.85  | 2    |
		| 3.65  | 3    |
		| 3.65  | 3    |
		| 3.50  | 4    |
		+-------+------+

    Solution: None
    
    Source: https://leetcode.com/discuss/40116/simple-short-fast
*/

# Write your MySQL query statement below

SELECT
  Score,
  (SELECT count(*) FROM (SELECT distinct Score s FROM Scores) tmp WHERE s >= Score) Rank
FROM Scores
ORDER BY Score desc