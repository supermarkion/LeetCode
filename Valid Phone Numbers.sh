#   Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash 
#   script to print all valid phone numbers.
    
#   Link: https://leetcode.com/problems/valid-phone-numbers/

#   Example: 
#   	For example, assume that file.txt has the following content:
#   		987-123-4567
#			123 456 7890
#			(123) 456-7890
#		Your script should output the following valid phone numbers:
#			987-123-4567
#			(123) 456-7890

#   Solution: None
    
#   Source: None

# Read from the file file.txt and output all valid phone numbers to stdout.
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt