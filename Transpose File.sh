#   Given a text file file.txt, transpose its content. You may assume that each row has the same number of columns and 
#	each field is separated by the ' ' character
    
#   Link: https://leetcode.com/problems/transpose-file/

#   Example: 
#   	For example, if file.txt has the following content:
#   		name age
# 			alice 21
# 			ryan 30

#			Output the following:
#			name alice ryan
#			age 21 30

#   Solution: None
    
#   Source: https://leetcode.com/discuss/65277/solution-using-associative-array-transpose-file

# Read from the file file.txt and print its transposed content to stdout.

#!/bin/bash

declare -A matrix
col=1
row=1

while read line; do
    col=1
    for word in $line; do
            matrix[$row,$col]=$word
            ((col++))
    done
    ((row++))
done < file.txt

for ((i=1;i<col;i++)) do
    echo -n ${matrix[1,$i]} 
    for((j=2;j<row;j++)) do
            echo -n ' '${matrix[$j,$i]}
    done
    echo
done