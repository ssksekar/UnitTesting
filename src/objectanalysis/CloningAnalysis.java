//$Id$
package objectanalysis;

import me.prettyprint.cassandra.service.template.SuperCfResult;

public class CloningAnalysis {

	public static void main(String[] args) throws CloneNotSupportedException {

		// Original Object
		Person p = new Person("Person-A", "Civic");
		p.setCar( new Car("sathish"));
		System.out.println("Original (orginal values): " + p.getName() + " - " + p.getCar().getName());

		// Clone as a shallow copy

		Person q = (Person) p.clone();

		System.out.println("Clone (before change): " + q.getName() + " - "		+ q.getCar().getName());

		// change the primitive member

		q.setName("Person-B");

		// change the lower-level object

		q.getCar().setName("Accord");

		System.out.println("Clone (after change): " + q.getName() + " - "		+ q.getCar().getName());

		System.out.println("Original (after clone is modified): " + p.getName()		+ " - " + p.getCar().getName());

	}
}

class Person implements Cloneable {
	// Lower-level object

	private Car car;
	private String name;

	public Car getCar() {

		return car;
	}

	public String getName() {

		return name;
	}

	public void setName(String s) {

		name = s;
	}
	public void setCar(Car c) {
		
		car = c;
	}

	public Person(String s, String t) {

		name = s;

		//car = new Car(t);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {

		// Deep copy

		//Person p = new Person(name, car.getName());
		

		return super.clone();
	}
}

class Car {

	private String name;

	public String getName() {

		return name;
	}

	public void setName(String s) {

		name = s;
	}

	public Car(String s) {

		name = s;
	}
}