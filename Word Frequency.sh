#   Write a bash script to calculate the frequency of each word in a text file words.txt.
	
#   For simplicity sake, you may assume:
#   	words.txt contains only lowercase characters and space ' ' characters.
#   	Each word must consist of lowercase characters only.
#   	Words are separated by one or more whitespace characters.
    
#   Link: https://leetcode.com/problems/word-frequency/

#   Example: 
#   	For example, assume that words.txt has the following content:
#   		the day is sunny the the
# 			the sunny is is

#			Your script should output the following, sorted by descending frequency:
#			the 4
#			is 3
#			sunny 2
#			day 1

#   Solution: None
    
#   Source: https://leetcode.com/discuss/72794/my-16ms-unix-pipe-cat-tr-awk-sort-hash-solution

# Read from the file words.txt and output the word frequency list to stdout.

# use cat+tr+awk+sort
# use hashtables
# use Unix pipes

cat words.txt | \
tr -s ' ' '\n' | \
awk '{nums[$1]++}END{for(word in nums) print word, nums[word]}' | \
sort -rn -k2