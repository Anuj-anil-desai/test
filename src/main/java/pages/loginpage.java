package pages;

import org.openqa.selenium.By;

public class loginpage extends utilities  {
	By username= By.name("username");
	By password= By.name("password");
	By clickButton= By.xpath("//button[@type='submit']");

	
	By newpage=By.xpath("//div[@class='oxd-topbar-header-title']//h6");	
	By textError=By.xpath("//form//span");
	By invaildError= By.xpath("(//div[@class='orangehrm-login-error']//p)[1]");


	loginpage util= new loginpage();
	
	public void log(String user,String pass,String input) {
		if(input.equals("valid")) {
			driver.findElement(username).sendKeys(user);
			driver.findElement(password).sendKeys(pass);
			driver.findElement(clickButton).click();
			util.erromessage(newpage);
		}
		else if(input.equals("Blank")) {
			driver.findElement(username).sendKeys(user);
			driver.findElement(password).sendKeys(pass);
			driver.findElement(clickButton).click();
			util.erromessage(textError);
			
		}	
		else if(input.equals("invalid")) {
			driver.findElement(username).sendKeys(user);
			driver.findElement(password).sendKeys(pass);
			driver.findElement(clickButton).click();
			util.erromessage(invaildError);
		}			
	}
	
	public String erromessage(By by)
	{
		String massage=loginpage.errormessage(by);
		return massage;
	}
	
}



