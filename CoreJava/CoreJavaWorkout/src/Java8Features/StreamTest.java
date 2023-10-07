package Java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		List<Mobile> mobiles = new ArrayList<Mobile>();
		mobiles.add(new Mobile(1, "vivo", 10000));
		mobiles.add(new Mobile(2, "redme", 15000));
		mobiles.add(new Mobile(3, "samsung", 20000));
		mobiles.add(new Mobile(4, "Apple", 80000));

		List<String> mobileNames = mobiles.stream().filter(mobile -> mobile.price > 14000)// filter data
				.map(mobile -> mobile.name)// fetch only name
				.collect(Collectors.toList());
		System.out.println(mobileNames);

		mobiles.stream().filter(mobile -> mobile.price > 14000).forEach(mobile -> System.out.println(mobile.name));

		// max of price
		Mobile m1 = mobiles.stream().max((mob1, mob2) -> mob1.price > mob2.price ? 1 : -1).get();
		System.out.println("Max price:" + m1.price);

		// min of price
		Mobile m2 = mobiles.stream().min((mob1, mob2) -> mob1.price > mob2.price ? 1 : -1).get();
		System.out.println("Min price:" + m2.price);

		// cout phones greater than 14k
		long count = mobiles.stream().filter(mobile -> mobile.price > 14000).count();
		System.out.println("count:" + count);

		// accumulate result as set
		Set<Double> mobilePrices = mobiles.stream().filter(mobile -> mobile.price > 14000).map(mobile -> mobile.price)
				.collect(Collectors.toSet());

		System.out.println(mobilePrices);

		// accumulate result as set
		Map<Integer, String> mobilemap = mobiles.stream().filter(mobile -> mobile.price > 14000)
				.collect(Collectors.toMap(mobile -> mobile.id, mobile -> mobile.name));

		System.out.println(mobilemap);

		mobiles.clear();
		// using methodreference

		List<phone> phones = new ArrayList<phone>();
		phones.add(new phone(1, "vivo", 10000));
		phones.add(new phone(2, "redme", 15000));
		phones.add(new phone(3, "samsung", 20000));
		phones.add(new phone(4, "Apple", 80000));
		System.out.println("===============================");
		List<String> phoneNames = phones.stream().map(phone::getName).collect(Collectors.toList());

		System.out.println(phoneNames);

		// create employee class with attribute eid,ename,esal and
		// few objects of it in to list
		// sort the result by ename after filtered by esal<4500

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "vasu", 10000));
		employees.add(new Employee(2, "Ram", 15000));
		employees.add(new Employee(3, "Bhuvi", 20000));
		employees.add(new Employee(4, "Raju", 80000));
		System.out.println("===============================");
//		List<String> employs=employees.stream()
//				.map(employ->employ.getEname())
//				.filter(employe->employe.getesal<4500);
//		//Stream<Employee> filterdEmp=
		employees.stream().filter(employee -> employee.getEsal() < 14000)
				.sorted((emp1, emp2) -> emp1.getEname().compareTo(emp2.getEname()))
				.forEach(employee -> System.out.println(employee.getEname()));

		//employees.stream().filter(em->em.esal<45000).sorted((employee1,employee2)->employee1.ename.compareTo(employee2.ename)).forEach(ele->System.out.println(ele.ename));;
	}

}

class Employee {
	private int eid;
	private String ename;
	private double esal;

	public Employee(int eid, String ename, double esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal) {
		this.esal = esal;
	}

}

class phone {
	private int id;
	private String name;
	private double price;

	public phone(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
