package day01_12032024;

import org.testng.annotations.Test;

public class GroupsDemo {
	
	@Test(groups = {"Smoke"})
	public void test1() {
		System.out.println("Test 1");
	}
	@Test (groups = {"Retesting"})
	public void test2() {
		System.out.println("Test 2");
	}
	@Test (groups = {"regression"})
	public void test3() {
		System.out.println("Test 3");
	}
	@Test (groups = {"function"})
	public void test4() {
		System.out.println("Test 4");
	}
	@Test (groups = {"Stress"})
	public void test5() {
		System.out.println("Test 5");
	}

}
