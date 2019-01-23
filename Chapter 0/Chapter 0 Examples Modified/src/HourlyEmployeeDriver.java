import java.util.Random;
import java.text.DecimalFormat;

public class HourlyEmployeeDriver {

	public static void main(String[] args) {

//		double salary;
//		Random rand = new Random();
//		int hours = rand.nextInt( 80);
//		DecimalFormat formatter = new DecimalFormat( ",##0.00");
//		
//		Employee bob = new Employee( "Bob", "Smith", "000-00-0000");	
//		System.out.println( bob);
//		
//		HourlyEmployee mary = new HourlyEmployee( "Mary", "Smith", "123-45-6789", 0, 0);
//		System.out.println( mary);
//		
//		hours = rand.nextInt( 80);
//		mary.setHours( hours);
//		mary.setRate( 35.0);
//		System.out.println( mary);
//		salary = mary.computeSalary();
//		System.out.println( mary.getFirstName() + "'s salary is: $" + formatter.format( salary));
//		
//		System.out.println( "\nDone.");
//		return;
//	}
		
		Employee bob = new Employee( "Bob", "Smith", "000-00-0000");
		System.out.println( bob);
		
		HourlyEmployee mary = new HourlyEmployee( "Mary", "Smith", "111-11-111", 40, 40);
		System.out.println( mary);
		
		HourlyEmployee jane = mary.copy();
		System.out.println( jane);
		jane.setName( "Jane", "Martin");
		System.out.println( jane);
		if (jane.equals(mary)) {
			System.out.println("Two employees with the same SSN");
		}
	}
}
