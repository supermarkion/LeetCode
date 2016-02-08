# LeetCode
Save Codes on LeetCode questions implmement

1. When we want to sort list with objects, we use a class to define comparator.
for example:
```
	Collections.sort(intervals, new IntervalComparator());
	private class IntervalCompareator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
		    return a.start - b.start;
	    }
	}
```

2. The Text Justification.java is a template on construct text file with special format.

3. From now on, I should use Thinking in Java to practice my OOP defintions.

4. When you say something is static, it means that particular field or method is not tied to any particular object instance of that class.

5. However, for the static nested classes, you should use final to declare you class, prevents extension of the class since extending a static class makes no sense. After that, make the constructor to private, and use static to declare all methods.

6. The good of static classes is that it can define one-off, utility and library classes where instatiation would not make sense.

7. The default behavior of equals() is to compare references.

8. In the overloading method, once we input a argument, and there is no perfect type to match it, we will promoted its type, and apply the method which meet new type. e.g. if only method on f(long a), and we input a int a, it will run f(long a). However, once we input is wider than existing argument type, unless we transform it by hand, or it will raise a error.

10. For the static key word, there is no this for that particular method, you cannot call a non-static methods from insdier static methods (although the reverse is possible), and you can call a static method for the class itself, without any object. It is kind of Global Method, eventhough Java is not allow global method. (when we use static, there is no need to pass message to object, and it can say there is no this in method)

11. To summarize the process of creating an object, consider of a class called Dog:
	* Even though it doesn't explicitly use the static keyword, the constructor is actually a static method. So the first time an ojbect of type Dog is created, or the first time a static method or static field of class Dog is accessed, the Java interpreter must locate Dog.class, which it does by searching through the classpath.
	* As Dog.class is loaded (creating a Class object, which you'ill learn about later), all of its static initializers are run. Thus, static initialization takes place only once, as the Class object is loaded for the first time.
	* When you create a new Dog(), the construction process for a Dog object first allocates enough storage for a Dog object on the heap.
	* This storage is wiped to zero, automatically setting all the primitives in that Dog object to their default values (zero for numbers and the equivalent boolean and char) and the references to null.
	* Any initializations that occur at the point of field definition are executed.
	* Constructors are executed. It might actually involve a fair amount of activity, expecially when inheritance is involved.

12. We can also use static keyword and {} to cover block of code, which means these code is executed only once: the first time you make an object of that class or the first time you access a static member of that class.

13. Igeneral you can use an enum as if it were another way to create a data type, and then just put the results to work. 

14. The class controls the code that has access to its members. Code from anther package can't just come around. The only way to grant access to a member is to:
	* Make the member public. Then everybody, everywhere can access it.
	* Given the member package access by elaving off any access specifier, and put the other classes in the same package. Then the other classes in that package can access the member.
	* When inheritance is introduced, an inherited class can access a protected member as well as a public member. It can access package-access members only if the two classes are in the same package.
	* Provide "accessor/mutator" methods (also known as "get/set" methods) that read and change the value. This is the most civilized approach in terms of OOP.

15. Java's final keyword has slightly different meaning depending on the context, but in general it says "this cannot be changed". You might want to prevent changes for two reasons: design or efficiency. Because these two reasons are quite different, it's possible to misues the final keyword. It can be used in three part: for data, methods and classes.

16. There are two reaons for final methods. THe first is to put a lock on the method to prevent any inheriting class from change its meaning. This is done for design reasons when you want to make sure that a method's behavior is retained during inheritance and cannot be overridden. The second reason for final methods is effeciency. If you made a method final, you allowed the compile to turn any calls to that method into inline calls. But now, its no longer necessary.

17. We can use to get result of a int number bit version.
```
	private static boolean[] toBinary(int number, int base) {
		final boolean[] ret = new boolean[base];
		for (int i = 0; i < base; i++) {
		    ret[base - 1 - i] = (1 << i & number) != 0;
		}
		return ret;
	}
		
```

18. It's helpful to create **abstract** classes and methods because they make the abstractness of a class explicit, and tell both the user and the compiler how it was intened to be used. Abstract classes are also uesful refactoring tolls, since they allow you to easily move common methods up the inheritance hierarchy.


19. In the problem on **Reorder List**, we can use three templates to finish this task.
```
		// find middle
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rHead = slow.next;
        slow.next = null;

        // reverse ListNode on the right side
        ListNode prev = null;
        while (rHead != null) {
            ListNode temp = rHead.next;
            rHead.next = prev;
            prev = rHead;
            rHead = temp;
        }

        // merge two list
        rHead = prev;
        ListNode lHead = head;
        while (lHead != null && rHead != null) {
            ListNode temp1 = lHead.next;
            lHead.next = rHead;
            rHead = rHead.next;
            lHead.next.next = temp1;
            lHead = temp1;
        }
```


