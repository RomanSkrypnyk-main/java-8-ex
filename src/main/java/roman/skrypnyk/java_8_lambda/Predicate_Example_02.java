package roman.skrypnyk.java_8_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee{

	String name;
	int salary;
	int experience;

	public Employee(String name, int salary, int experience) {
		this.name = name;
		this.salary = salary;
		this.experience = experience;
	}
}

public class Predicate_Example_02 {

	public static void main(String[] args) {

		Employee employee_01 = new Employee("Roman", 1000, 1);
		Employee employee_02 = new Employee("Albert", 800, 0);

		//Ex1
		Predicate<Employee> employeePredicate1 = x -> (x.salary > 500 && x.experience >= 1);
		System.out.println(employeePredicate1.test(employee_01));

		//Ex2
		List<Employee> listOfEmployers = new ArrayList<Employee>();
		//convenient and fastest way to add many conditions to check
		Predicate<Employee> employeePredicate2 = x -> (x.salary > 200 && x.experience > 2);
		listOfEmployers.add(new Employee("Svat", 1800, 3));
		listOfEmployers.add(new Employee("Borat", 200, 0));
		listOfEmployers.add(new Employee("Zoro", 900, 2));

		for(Employee employee : listOfEmployers){
			if(employeePredicate2.test(employee)){
				System.out.println(employee.name);
			}
		}
	}
}
