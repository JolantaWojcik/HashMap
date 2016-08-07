import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTask {
	public static void main(String[] args) {
		List<Employee> empsList = new ArrayList<>();
		empsList.add(new Employee("Jan1", "Kowalski", 10000, "Manager"));
		empsList.add(new Employee("Jan2", "Kowalski", 9000, "Tester"));
		empsList.add(new Employee("Jan3", "Kowalski", 8000, "Tester"));
		empsList.add(new Employee("Jan4", "Kowalski", 7000, "Programmer"));
		empsList.add(new Employee("Jan5", "Kowalski", 9000, "Programmer"));
		empsList.add(new Employee("Jan6", "Kowalski", 8000, "Programmer"));
		empsList.add(new Employee("Jan7", "Kowalski", 6000, "Analyst"));

		/*
		 * Mapa gdzie kluczem jest stanowisko -> a wartoscia liczba pracownikow
		 * na danym stanowisku 
		 * Mapa gdzie kluczem jest stanowisko -> a wartoscia
		 * suma pensji wszystkich pracownikow na danym stanowisku 
		 * Mapa gdzie kluczem jest stanowisko -> a wartoscia srednia pensja na danym
		 * stanowisku 
		 * 
		 * Mapa gdzie kluczem jest stanowisko -> a wartosica lista
		 * pracownikow na danym stanowisku 
		 * Mapa gdzie kluczem bedzie Stanowisko
		 * -> najwiesza pensja na danym stanowisku
		 * 
		 */

		Map<String, Long> numberOfemployee = empsList.stream()
				.collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));
		// Map<String, Integer> numberOfemployee = new HashMap<>();
		// for (Employee e : empsList) {
		// if (!numberOfemployee.containsKey(e.getPosition())) {
		// numberOfemployee.put(e.getPosition(), 1);
		// } else {
		// numberOfemployee.put(e.getPosition(),
		// numberOfemployee.get(e.getPosition()) + 1);
		// }
		// }
		numberOfemployee.forEach((k, v) -> System.out.println("Stanowisko " + k + " liczba pracowniko " + v));
		System.out.println("\n");
		Map<String, Integer> sumOfSalaries = empsList.stream()
				.collect(Collectors.groupingBy(Employee::getPosition, Collectors.summingInt(Employee::getSalary)));
		// Map<String, Integer> sumOfSalaries = new HashMap<>();
		// for (Employee e : empsList) {
		// if (!sumOfSalaries.containsKey(e.getPosition())) {
		// sumOfSalaries.put(e.getPosition(), e.getSalary());
		// } else {
		// sumOfSalaries.put(e.getPosition(), sumOfSalaries.get(e.getPosition())
		// + e.getSalary());
		// }
		// }

		sumOfSalaries.forEach((k, v) -> System.out.println("Stanowisko " + k + " suma pensji " + v));
		System.out.println("\n");
		// return source.stream().filter(c ->
		// c.getPosition().equals(position)).collect(Collectors.averagingDouble(n->n.getSalary()));

		Map<String, Double> avarageOfSalaries = empsList.stream()
				.collect(Collectors.groupingBy(Employee::getPosition, Collectors.averagingDouble(Employee::getSalary)));
		// Map<String, Double> avarageOfSalaries = new HashMap<>();
		// for(Employee e: empsList){
		// avarageOfSalaries.put(e.getPosition(),
		// (double)sumOfSalaries.get(e.getPosition()) /
		// numberOfemployee.get(e.getPosition()));
		// }
		avarageOfSalaries.forEach((k, v) -> System.out.println("Stanowisko " + k + " srednia pensja " + v));

		Map<String, Double> maxOfSalaries = empsList.stream()
				//return cars.stream().collect(Collectors.maxBy((a, b) ->  (int) a.getCost_of_repair()- (int) b.getCost_of_repair())).get();
				.collect(Collectors.groupingBy(Employee::getPosition, Collectors.maxBy((a, b) ->  
				(int) a.getSalary()- (int) b.getSalary()))).get();
		maxOfSalaries.forEach((k, v) -> System.out.println("Stanowisko " + k + " najwieksza pensja " + v));
	}

}
