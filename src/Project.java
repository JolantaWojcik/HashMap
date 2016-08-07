import java.util.ArrayList;
import java.util.List;

//Emp moze nalezec do max jednego projektu
//a projekt moze zawierac wielu empow
public class Project {

	private String name;
	private String descirption;
	private int price;
	private List<Employee> employees;

	public Project(String name, String descirption, int price) {
		this.name = name;
		this.descirption = descirption;
		this.price = price;
		this.employees = new ArrayList<>();
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescirption() {
		return descirption;
	}

	public void setDescirption(String descirption) {
		this.descirption = descirption;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void addEmployee(Employee emp) {
		if (emp.getProject() != null) {
			throw new IllegalArgumentException("Employee is already assigned");
		}
		employees.add(emp);
		emp.setProject(this);
	}

	public void removeEmployee(Employee emp) {
		if (!employees.contains(emp)) {
			throw new IllegalArgumentException("Employee is not assigned to this project");
		}
		employees.remove(emp);
		emp.setProject(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descirption == null) ? 0 : descirption.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (descirption == null) {
			if (other.descirption != null)
				return false;
		} else if (!descirption.equals(other.descirption))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + ", descirption=" + descirption + ", price=" + price + "]";
	}

}
