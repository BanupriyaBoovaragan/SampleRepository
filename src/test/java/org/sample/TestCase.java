package org.sample;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.base.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase extends LibGlobal {

	public static void main(String[] args) throws AWTException {
		browserLaunch();
		/*enterUrl("https://www.facebook.com");
		WebElement txtUser=driver.findElement(By.id("email"));
		enterValue(txtUser,"java");
		
		WebElement txtPwd=driver.findElement(By.id("pass"));
		enterValue(txtPwd,"java333");
		rightClick(txtUser);
		*/
		//enterUrl("http://output.jsbin.com/osebed/2");
	//	WebElement t=driver.findElement(By.id("fruits"));
		//dDnselectByIndex(t, 1);
		//dDnselectByValue(t, "orange");
		
		//dDnselectByVisibleText(t,"Orange");
		
	/*	driver.get("http://www.greenstechnologys.com/");
		
		WebElement txtGreens=driver.findElement(By.xpath("//div[@id='article-wrapper']"));
		getText(txtGreens);
		*/
		/*enterUrl("https://www.flipkart.com/");
		WebElement btnX=driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
	clickButton(btnX);
		
		//baby&kids
		WebElement firstmouseover=driver.findElement(By.xpath("//span[@class='_2FZd5H'][5]"));
		mouseOver(firstmouseover);*/
	driver.get("http://demo.automationtesting.in/Alerts.html");
		
			//Click button to display an alert box and click ok button
	WebElement btnAlert=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	clickButton(btnAlert);
	simpleAlertmsg();
		
		
	}

	
	

}
