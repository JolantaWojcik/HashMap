import java.util.ArrayList;
import java.util.List;

/*
 * Na "stack" s¹ trzymane zmienne lokalne, oraz wywoa³ania metod.
 */
public class Main {

	public static void main(String[] args) {

		Employee e1 = new Employee("Jan", "Kowalski", 1000, "Manager");
		Employee e2 = new Employee("Anna", "Nowak", 5000, "secretary");
		Employee e3 = new Employee("Zenek", "Juzek", 1500, "farmer");

		Project p1 = new Project("some name...", "some description...", 900000);
		Project p2 = new Project("another project", "another description", 5000000);

		p1.addEmployee(e1);
		p1.addEmployee(e2);
		p2.addEmployee(e3);

		try {
			p2.addEmployee(e1);
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

		System.out.println(p1);
		System.out.println("emps:");
		p1.getEmployees().forEach(System.out::println);

		System.out.println(p2);
		System.out.println("emps:");
		p2.getEmployees().forEach(System.out::println);

	}

}
