# LeetCode
Save Codes on LeetCode questions implmement

1. When we want to sort list with objects, we use a class to define comparator.
for example:
	Collections.sort(intervals, new IntervalComparator());

private class IntervalCompareator implements Comparator<Interval> {
	public int compare(Interval a, Interval b) {
	    return a.start - b.start;
    }
}
2. The Text Justification.java is a template on construct text file with special format.
3. From now on, I should use Thinking in Java to practice my OOP defintions.
4. When you say something is static, it means that particular field or method is not tied to any particular object instance of that class.
5. However, for the static nested classes, you should use final to declare you class, prevents extension of the class since extending a static class makes no sense. After that, make the constructor to private, and use static to declare all methods.
6. The good of static classes is that it can define one-off, utility and library classes where instatiation would not make sense.
7. The default behavior of equals() is to compare references.
8. In the overloading method, once we input a argument, and there is no perfect type to match it, we will promoted its type, and apply the method which meet new type. e.g. if only method on f(long a), and we input a int a, it will run f(long a). However, once we input is wider than existing argument type, unless we transform it by hand, or it will raise a error.
10. For the static key word, there is no this for that particular method, you cannot call a non-static methods from insdier static methods (although the reverse is possible), and you can call a static method for the class itself, without any object. It is kind of Global Method, eventhough Java is not allow global method. (when we use static, there is no need to pass message to object, and it can say there is no this in method)
11. To summarize the process of creating an object, consider of a class called Dog:
1) Even though it doesn't explicitly use the static keyword, the constructor is actually a static method. So the first time an ojbect of type Dog is created, or the first time a static method or static field of class DOg is accessed, the Java interpreter must locate Dog.class, which it does by searching through the classpath.
2) As Dog.class is loaded (creating a Class object, which you'ill learn about later), all of its static initializers are run. Thus, static initialization takes place only once, as the Class object is loaded for the first time.
3) When you create a new Dog(), the construction process for a Dog object first allocates enough storage for a Dog object on the heap.
4) This storage is wiped to zero, automatically setting all the primitives in that Dog object to their default values (zero for numbers and the equivalent boolean and char) and the references to null.
5) Any initializations that occur at the point of field definition are executed.
6) Constructors are executed. It might actually involve a fair amount of activity, expecially when inheritance is involved.
12. We can also use static keyword and {} to cover block of code, which means these code is executed only once: the first time you make an object of that class or the first time you access a static member of that class.
13. Igeneral you can use an enum as if it were another way to create a data type, and then just put the results to work. 








