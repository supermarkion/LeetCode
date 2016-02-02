#   How would you print just the 10th line of a file?
    
#   Link: https://leetcode.com/problems/tenth-line/

#   Example: 
#   	For example, assume that file.txt has the following content:
#   		Line 1
# 			Line 2
# 			Line 3
# 			Line 4
#			Line 5
#			Line 6
#			Line 7
#			Line 8
#			Line 9
#			Line 10
#		Your script should output the tenth line, which is:
#			Line 10

#   Solution: None
    
#   Source: https://leetcode.com/discuss/31240/share-four-different-solutions

# Read from the file file.txt and output the tenth line to stdout.
cnt=0
while read line && [ $cnt -le 10 ]; do
  let 'cnt = cnt + 1'
  if [ $cnt -eq 10 ]; then
    echo $line
    exit 0
  fi
done < file.txt