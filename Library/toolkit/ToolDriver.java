package com.peter.toolkit;

import java.util.Scanner;

public class ToolDriver {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
		Scanner scan = new Scanner(System.in);
		String input = null;
		
		input = scan.nextLine();
		while (!input.equals(null)) {
			if (input.contains("q"))
				break;
			
			if (!input.equals(Calculator.BACK) && input.contains("c")) {
				calc.reset();
				continue;
			}
			
			if (input.contains("="))
				System.out.println(calc.equalsTo());
			else if ("+-*/".contains(input))
				System.out.println(calc.operate(input.charAt(0)));
			else
				System.out.println(calc.number(input));
			
			input = scan.nextLine();
		}
		
		scan.close();
	}

}
