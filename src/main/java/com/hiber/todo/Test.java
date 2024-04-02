package com.hiber.todo;

import com.hiber.utility.Utils;

public class Test {
	public static void main(String[] args) {
		System.out.print("Enter a string");
		String string = Utils.input().nextLine();
		System.out.print("Enter 2nd string");
		String string2 = Utils.input().next();
		System.out.println(string);
		System.out.println(string2);
	}

}
