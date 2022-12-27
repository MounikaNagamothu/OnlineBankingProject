package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest {
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("Hi");
  }
@Test
public void test()
{
	System.out.println("How are you");
}
  @AfterMethod
  public void afterMethod() {
	  System.out.println("Hello");
  }

}
