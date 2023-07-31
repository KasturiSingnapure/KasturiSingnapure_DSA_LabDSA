package com.greatlearning.stack;

public class DriverApp {
	public static void main(String[] args) {

		// The input string containing brackets to be checked for balance
		String input = "([[{}]])";

		// Create an instance
		MyStack ms = new MyStack();

		// Call the checkBracket method from MyStack class to check for balanced
		// brackets
		Boolean result = ms.checkBracket(input);
		if (result == true)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");

	}

}
