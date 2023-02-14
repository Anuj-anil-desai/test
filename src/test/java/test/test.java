package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.loginpage;

public class test extends loginpage {

	
	@BeforeMethod()
	public void setup(){
		loginpage bro=new loginpage();
		bro.browger();

	}
	@AfterMethod()
	public void close() {
		driver.quit();
	}
	
	@Test(dataProvider="data")
	public void OpenHomePage(String username,String password,String input) {
		
		test run= new test();
		run.log(username,password,input);
		
		if(username.isBlank()|| password.isBlank()) {
		run.window();
		
			Assert.assertEquals("Required", run.erromessage(),"Wrong ErrorMessage for Blank Username/psasword!!!");
		}
		else if(input.equals("invaild")) {
			run.window();
			Assert.assertEquals("Invalid credentials", run.erromessage(),"Wrong ErrorMessage for invaild Username/psasword!!!");
		}
		else if(input.equals("vaild")) {
			run.window();
			Assert.assertEquals("Dashboard", run.erromessage(),"Wrong ErrorMessage for invaild Username/psasword !!!");
		}
			
	}
	@DataProvider (name="data")
	   public String [][] information(){
			   
		String [][] data= {{"Admin","admin123","vaild"},
							{"Admin"," ","Blank"},
							{" ","admin123 ","Blank"},
							{"demo","demo123","invaild"}};
			return data;   
	}
	   
}
