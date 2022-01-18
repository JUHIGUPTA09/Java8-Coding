import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Test {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(5);
		l.add(20);
		l.add(19);
		l.add(15);
		l.add(36);
		l.add(72);
		
		
		List<Student> students = new ArrayList<>();
		students.add(new Student(31, "Abhinav", "Rathi"));
		students.add(new Student(6, "Prince", "Agrahari"));
		students.add(new Student(17, "Sandeep", "Jaiswal"));
		students.add(new Student(25, "Gaurav", "Agrawal"));
		students.add(new Student(5, "Gaurav", "Bansal"));
		students.add(new Student(8, "Gaurav", "Agrawal"));
		
		Map<Integer, String> map = new HashMap<>();
		map.put(114, "Prince");
		map.put(99, "Sandeep");
		map.put(201, "Gaurav");
		map.put(4, "Abhinav");
		map.put(299, "Pallavi");
		
		//even number list
		
		List<Integer> listEven=l.stream().filter(i -> i%2==0).collect(Collectors.toList());
		System.out.println(listEven);
		
		//odd number list
		
		List<Integer> listOdd=l.stream().filter(i -> i%2!=0).collect(Collectors.toList());
		System.out.println(listOdd);
		
		//average

		double avg=l.stream().mapToInt(i->i).average().getAsDouble();
		System.out.println(avg);
		
		//sum
		System.out.println(l.stream().mapToInt(i ->i).sum());
		
		int x=l.stream().collect(Collectors.summingInt(i->i));
		System.out.println("X="+x);
		
		
		//sorting a list
		
		System.out.println("Natural Sorting Order");
		l.stream().sorted().forEach(System.out::println);
		System.out.println("-----------------------------");
		
		System.out.println("Reverse Sorting Order");
		l.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("-----------------------------");
		
		System.out.println("Custom Sorting Orde----Roll No");
		students.stream().sorted(Comparator.comparing(Student::getRollNo)).forEach(System.out::println);
		System.out.println("-----------------------------");
		
		
		System.out.println("Custom Sorting Orde----First Name");
		students.stream().sorted(Comparator.comparing(Student::getFirstName)).forEach(System.out::println);
		System.out.println("-----------------------------");
		
		
		System.out.println("Custom Sorting Orde----First Name,if first name is same then roll no");
		students.stream().sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getRollNo)).forEach(System.out::println);
		System.out.println("-----------------------------");
		
		
		students.stream().sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName).thenComparing(Student::getRollNo)).forEach(System.out::println);
		
		//sorting a map
		System.out.println("Sort by key");
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(System.out::println);
		
		
		
		map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(System.out::println);
		
		
	//	map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.)
		

	//sorting the map nd then collecting it into map
		
	Map<Integer,String> map1=map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1,o2)->o1, LinkedHashMap::new));
	System.out.println(map1);	
	
		
		

	}

}


class Student
{
	private Integer rollNo;
	private String firstName;
	private String lastName;

	public Student(Integer rollNo, String firstName, String lastName) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
}