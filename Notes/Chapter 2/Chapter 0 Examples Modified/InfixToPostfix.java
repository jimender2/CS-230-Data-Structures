import java.util.Scanner;

public class InfixToPostfix {

	public static void main(String[] args) {

		int value;
		String infixExpression;
		String postfixExpression;
		Scanner keyboard = new Scanner( System.in);
		
		for( int count = 1 ; count <= 5 ; count++) {
			
			System.out.print( "Enter infix expression: ");
			infixExpression = keyboard.nextLine();
			postfixExpression = convertToPostfix( infixExpression);
			value = evaluatePostfix( postfixExpression);
			System.out.println( infixExpression + " = " + postfixExpression + " = " + value);
		}
		
		keyboard.close();
		return;
	}
	
	public static int evaluatePostfix( String postfix) {
		
		int value = 0;
		int length, operand1, operand2, answer;
		char token;
		final char ADD = '+';
		final char SUB = '-';
		final char MUL = '*';
		final char DIV = '/';
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		postfix = removeBlanks( postfix);
		length = postfix.length();
		
		for( int index = 0 ; index < length ; index++) {
			
			token = postfix.charAt( index);
			
			switch( token) {
			
			case ADD:
				operand2 = stack.pop();
				operand1 = stack.pop();
				answer = operand1 + operand2;
				stack.push( answer);
				break;
			
			case SUB:
				operand2 = stack.pop();
				operand1 = stack.pop();
				answer = operand1 - operand2;
				stack.push( answer);
				break;
				
			case MUL:
				operand2 = stack.pop();
				operand1 = stack.pop();
				answer = operand1 * operand2;
				stack.push( answer);
				break;
				
			case DIV:
				operand2 = stack.pop();
				operand1 = stack.pop();
				answer = operand1 / operand2;
				stack.push( answer);
				break;
				
			default:
				String str = "";
				stack.push( Integer.parseInt( str + token));
			}
		}
		
		value = stack.pop();
		return value;
	}
	
	public static String removeBlanks( String originalString)
	{
		char ch;
		final char BLANK = ' ';
		int index, stringLength;
		String deblankedString = "";
				    
		stringLength = originalString.length();
		for( index = 0 ; index < stringLength ; index++) {
			ch = originalString.charAt( index);
			if( ch != BLANK)
				deblankedString = deblankedString + ch;
		}
		
		return deblankedString;
	}

	public static String convertToPostfix( String infix)
	{
	    String postfix = "";
		final char LP = '(';
		final char RP = ')';
		final char ADD = '+';
		final char SUB = '-';
		final char MUL = '*';
		final char DIV = '/';
		char token, stackToken;
		final String BLANKSTR = " ";
		int infixLength;
		LinkedStack<Character> stack = new LinkedStack<Character>();
		
		infix = removeBlanks( infix);
		infixLength = infix.length(); 
		for( int index = 0 ; index < infixLength ; index++) {
			
			token = infix.charAt( index);	
			switch( token) {	
				case LP:
					stack.push( token);
					break;
				case RP:
					for( ; ; ) {
						stackToken = stack.pop();
						if ( stackToken == LP)
							break;
						else
							postfix = postfix + BLANKSTR + stackToken;
					}
					break;
				case ADD: case SUB:
					for( ; ; ) {
						if( stack.isEmpty()) {
							stack.push( token);
							break;
						}
						else {
							stackToken = stack.peek();
							if( stackToken == LP) {
								stack.push( token);
								break;
							}
							else {
								stackToken = stack.pop();
								postfix = postfix + BLANKSTR + stackToken;
							}
						}
					}
					break;
				case MUL: case DIV:
					for( ; ; ) {
						if( stack.isEmpty()) {
							stack.push( token);
							break;
						}
						else {
							stackToken = stack.peek();
							if( stackToken == LP || stackToken == ADD || stackToken == SUB) {
								stack.push( token);
								break;
							}
							else {
								stackToken = stack.pop();
								postfix = postfix + BLANKSTR + stackToken;
							}
						}

					}
					break;
				default:
					postfix = postfix + BLANKSTR + token;
					break;
			}			
		}
		while( !stack.isEmpty()) {
				stackToken = stack.pop();
				postfix = postfix + BLANKSTR + stackToken;
		}
		
		return postfix;
	}
}
