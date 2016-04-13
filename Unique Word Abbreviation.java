 /*
    An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
      a) it                      --> it    (no abbreviation)

           1
      b) d|o|g                   --> d1g

                    1    1  1
           1---5----0----5--8
      c) i|nternationalizatio|n  --> i18n

                    1
           1---5----0
      d) l|ocalizatio|n          --> l10n
    Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's 
    abbreviation is unique if no other word from the dictionary has the same abbreviation.

    Link: https://leetcode.com/problemset/algorithms/

    Example: 
		  Given dictionary = [ "deer", "door", "cake", "card" ]
        isUnique("dear") -> false
        isUnique("cart") -> true
        isUnique("cane") -> false
        isUnique("make") -> true
	
    Solution: None

    Source: http://blog.csdn.net/pointbreak1/article/details/48858599
*/

public class ValidWordAbbr {

    public ValidWordAbbr(String[] dictionary) {
        for (String s: dictionary) {
            String key = s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
            if (d.containsKey(key)) {
                d.get(key).add(s);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                d.put(key, l);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        if (!d.containsKey(key)) {
          return true;
        } else if (d.get(key).size() < 2  && d.get(key).get(0).equals(word)) {
          return true;
        }
        return false;
    }
    
    private HashMap<String, List<String>> d = new HashMap<>();
}