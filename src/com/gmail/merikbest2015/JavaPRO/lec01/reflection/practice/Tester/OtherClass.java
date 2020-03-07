package com.gmail.merikbest2015.JavaPRO.lec01.reflection.practice.Tester;

public class OtherClass {

	public static String work(String... ls) {
		StringBuilder sb = new StringBuilder();
		for (String s : ls)
			sb.append(s);
		
		return sb.toString();
	}
	
	@Test
	public static boolean testMethod() {
		boolean res = work("1", "22", "333").equals("122333");
		System.out.println("OtherClass: " + res);
		return res;
	}
}