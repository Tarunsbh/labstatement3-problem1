package com.greatlearning;

import java.util.Stack;

public class BalanceExpression {
	public static void main(String args[]) {
		String expression = "([[{}]])";
		boolean checkExp = checkExpression(expression);
		if (checkExp) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");

		}
	}

	private static boolean checkExpression(String expression) {
		Stack<Character> expressionStack = new Stack<Character>();
		for (int i = 0; i < expression.length(); i++) {
			char exp = expression.charAt(i);
			if (exp == '{' || exp == '[' || exp == '(') {
				expressionStack.push(exp);
				continue;
			}
			if (expressionStack.isEmpty())
				return false;

			char c;

			switch (exp) {
			case '}':
				c = expressionStack.pop();
				if (c == '(' || c == '[')
					return false;
				break;
			case ')':
				c = expressionStack.pop();
				if (c == '{' || c == '[')
					return false;
				break;
			case ']':
				c = expressionStack.pop();
				if (c == '(' || c == '{')
					return false;
				break;

			}

		}
		return expressionStack.isEmpty();
	}
}
