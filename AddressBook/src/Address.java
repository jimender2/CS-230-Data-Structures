
public class Address {

	private String name;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phoneNumber;

	public Address() {
		leftOperand = 0;
		rightOperand = 0;
		answer = 0;
	}

	public int getLeftOperand() {
		return leftOperand;
	}

	public int getRightOperand() {
		return rightOperand;
	}

	public int getAnswer() {
		return answer;
	}

	public void setLeftOperand( int operand) {
		leftOperand = operand;
		answer = leftOperand + rightOperand;
		return;
	}

	public void setRightOperand( int operand) {
		rightOperand = operand;
		answer = leftOperand + rightOperand;
		return;
	}

	public void setOperands( int operand1, int operand2) {
		leftOperand = operand1;
		rightOperand = operand2;
		answer = leftOperand + rightOperand;
		return;
	}

	public AdditionProblem getAdditionProblem() {
		AdditionProblem problem = new AdditionProblem( leftOperand, rightOperand);

		return problem;
	}

	@Override
	public String toString() {
		String str = "";

		str = str + leftOperand + " + " + rightOperand + " = ";
		return str;
	}

	public String displayAnswer() {
		String str = "";

		str = str + leftOperand + " + " + rightOperand + " = " + answer;
		return str;
	}
}
