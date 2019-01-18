
public class RationalNumberDriver {

	public static void main(String[] args) {

		Boolean test;
	}

}



public class testcircle {
	public static void main(String[] args) {
		Boolean test;
		
		Circle cir = new Circle(1243.6);
		System.out.println(cir.getRadius());
		System.out.println(cir.getDiameter());
		System.out.println(cir.getCircumference());
		System.out.println(cir.getArea());
		System.out.println(cir.toString());
		Circle circle2 = new Circle(cir);
//		circle2 = cir.copy();
		System.out.println(circle2.getRadius());
		System.out.println(circle2.getDiameter());
		System.out.println(circle2.getCircumference());
		System.out.println(circle2.getArea());
		System.out.println(circle2.toString());
		
		test=cir.equals(circle2);
		System.out.println(test);
		
		System.out.println(cir.getRadius());
		System.out.println(cir.getDiameter());
		System.out.println(cir.getCircumference());
		System.out.println(cir.getArea());
		System.out.println(cir.toString());
		
		test=cir.equals(circle2);
		System.out.println(test);
		
		System.out.println(circle2.getRadius());
		System.out.println(circle2.getDiameter());
		System.out.println(circle2.getCircumference());
		System.out.println(circle2.getArea());
	}
}
