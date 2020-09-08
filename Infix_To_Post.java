package coding;

import java.util.Stack;

public class Infix_To_Post {

	public static int prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;

		}
		return -1;
	}

	public static String postfix(String exp) {
		String result ="";
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (Character.isLetterOrDigit(c))
				result += c;
			else if (c == '(') {
				stk.push(c);
			} else if (c == ')') {
				while (!stk.isEmpty() && stk.peek() != '(') {
					result += stk.pop();
				}
				if (!stk.isEmpty() && stk.peek() != '(')
					return "Invalid";
				else
					stk.pop();

			} else {
				while (!stk.empty() && prec(c) <= prec(stk.peek())) {
					if (!stk.isEmpty() && stk.peek() == '(') {
						return "invalid";
					}
					result += stk.pop();
				}
				stk.push(c);

			}
		}
		while (!stk.isEmpty()) {
			if (stk.peek() == '(') {
				return "invalid";
			}
			result += stk.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(postfix(str));
	}

}
