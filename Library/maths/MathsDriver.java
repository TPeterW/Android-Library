package com.peter.maths;

public class MathsDriver {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		StringOperator strChecker = new StringOperator();
		NumberOperator numChecker = new NumberOperator();
		
		System.out.println(strChecker.isPalindrome(",."));
	}
}