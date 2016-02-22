/*
Hash Tables impelement
*/

public HashMap<Integer, Student> buildMap(Student[] students) {
	HashMap<Integer, Student> map = new HashMap<Integer, Student>();
	for (Student s : students) {
		map.put(s.getId(), s);
	}
	return map;
}

/*
ArrayList (Dynamically Resizing Array), A typical implementation is that when a vector is full, the array
doubles in size. Each doubling takes O(n) time, but happens so rarely that its amortized time is still O(1).
*/
public ArrayList<String> merge(String[] words, String[] more) {
	ArrayList<String> sentence = new ArrayList<String>();
	for (String w : words) {
		sentence.add(w);
	}
	for (String w : more) {
		sentece.add(w);
	}
	return sentece;
}

/*
We use StringBuilder to make the strings sum problem complexity become a O(n) problem.
*/