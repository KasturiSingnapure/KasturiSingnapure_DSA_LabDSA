package com.greatlearning.stack;

import java.util.Stack;

//{[()]}
public class MyStack {

	// Initialize a stack to store characters
	Stack<Character> stack = new Stack<>();

	// Method to check if the input string contains balanced brackets
	public Boolean checkBracket(String input) {
		char z, p;
		for (int i = 0; i < input.length(); i++) {
			z = input.charAt(i);

			// If the character is an opening bracket ({, [, or (),
			// push it onto the stack and continue to the next character
			if (z == '{' || z == '[' || z == '(') {
				stack.push(z);
				continue;
			}

			// If the character is a closing bracket (}, ], or )),
			// check if the stack is empty. If it is, then the brackets are not balanced.
			if (stack.isEmpty())
				return false;

			// Check the current character and the corresponding character at the top of the
			// stack
			// to see if they form a valid pair of brackets
			switch (z) {
			case '}':
				p = stack.pop();
				if (p == '[' || p == '(')
					return false;
				break;

			case ']':
				p = stack.pop();
				if (p == '{' || p == '(')
					return false;
				break;

			case ')':
				p = stack.pop();
				if (p == '{' || p == '[')
					return false;
				break;
			}
		}
		return (stack.isEmpty());

	}

}
