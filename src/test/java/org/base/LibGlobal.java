package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibGlobal {
	
	public static WebDriver driver;
	public static Actions ac;
	public static Robot r;
	public static Alert a;
	public static Select select;
	public static TakesScreenshot ts;
	
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver", "F:\\priya\\Maven_workspace\\FirstMaven\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 	}
	
	public static void enterUrl(String data) {
	driver.get(data);
	driver.manage().window().maximize();
		}
	public static void title() {
		System.out.println(driver.getTitle());
		
		driver.getCurrentUrl();
			}
	public static void closeBrowsers() {
		driver.quit();
			}
	
	public static void enterValue(WebElement element, String value) {
	element.sendKeys(value);
		}
	public static void enterValuewithEnter(WebElement element, String value) {
		element.sendKeys(value,Keys.ENTER);
			}
	public static void clickButton(WebElement element) {
	element.click();
	}
		
	public static void getText(WebElement element) {
		String txt=element.getText();
		System.out.println(txt);
				}
	
	public static void getAttribute(WebElement element) {
		String value=element.getAttribute("value");
		System.out.println(value);
				}	
		
		//actions
	
	
	public static void mouseOver(WebElement element) {
		 ac=new Actions(driver);
		ac.moveToElement(element).perform();
				}	
	
	public static void doubleClick(WebElement element) {
		 ac=new Actions(driver);
		ac.doubleClick(element).perform();
				}	
	
	public static void dragAndDrop(WebElement dragelement,WebElement dropelement) {
		 ac=new Actions(driver);
		ac.dragAndDrop(dragelement, dropelement).perform();
				}
	public static void rightClick(WebElement element) {
		 ac=new Actions(driver);
		ac.contextClick(element).perform();
				}	
	
	//Robot
	
	
	public static void robotEscape() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);

	}
	
	//alert
	public static void simpleAlertmsg() {
		;
		a=driver.switchTo().alert();
		String txt=a.getText();
		System.out.println(txt);
			}
	
	public static void alertAccept() {
		a=driver.switchTo().alert();
		a.accept();
			}
	
	public static void alertCancel() {
		a=driver.switchTo().alert();
		a.dismiss();
			}
	
	public static void promptAlert(String value) {
		a=driver.switchTo().alert();
		a.sendKeys(value);
	}
		
	//dropdown handle
	public static void dDnselectByIndex(WebElement element,int value) {
		select=new Select(element);
		select.selectByIndex(value);

	}
	
	public static void dDnselectByValue(WebElement element,String value) {
		select=new Select(element);
		select.selectByValue(value);
	}
	
	public static void dDnselectByVisibleText(WebElement element,String value) {
		select=new Select(element);
		select.selectByVisibleText(value);
	}
	public static void dDnPrintAllOptions(WebElement element) {
		select=new Select(element);
		List<WebElement> alloptions = select.getOptions();
		for (int i = 0; i < alloptions.size(); i++) {
			WebElement x=alloptions.get(i);
			String txt=x.getText();
			System.out.println("All options are"+txt);
		}
	}
		public static void dDnPrintAllOptionsgetAttribute(WebElement element) {
			select=new Select(element);
			List<WebElement> alloptions = select.getOptions();
			for (int i = 0; i < alloptions.size(); i++) {
				WebElement x=alloptions.get(i);
				String txt=x.getAttribute("value");
				System.out.println("All options are"+txt);
			}

	}
		
		public static void dDnSelectAllUsingIndex(WebElement element) {
			select=new Select(element);
			List<WebElement> alloptions = select.getOptions();
			for (int i = 0; i < alloptions.size(); i++) {
				select.selectByIndex(i);
			}
		}
		
		public static void dDnSelectAllUsingVisibleText(WebElement element) {
			select=new Select(element);
			List<WebElement> alloptions = select.getOptions();
			for (WebElement x : alloptions) {
				String txt=x.getText();
				select.selectByVisibleText(txt);
			}
			}
			
			public static void dDnSelectAllUsingValue(WebElement element) {
				select=new Select(element);
				List<WebElement> alloptions = select.getOptions();
				for (WebElement x : alloptions) {
					String txt=x.getAttribute("value");
					select.selectByValue(txt);
					
				}	
		}
		
			public static void firstSelectOptionDdn(WebElement element) {
				select=new Select(element);
				WebElement first=select.getFirstSelectedOption();
				String txt=first.getText();
				System.out.println("First selected option is"+txt);
						}
		
	public static void multiSelectDdn(WebElement element) {
		select=new Select(element);
		boolean b=select.isMultiple();
		System.out.println(b);
		}
	
	
	public static void deselectAllDdn(WebElement element) {
		select=new Select(element);
		select.deselectAll();
	}
	
	public static void deselectByIndex(WebElement element,int index) {
		select=new Select(element);
		select.deselectByIndex(index);
	}
	
	public static void deselectByValue(WebElement element,String value) {
		select=new Select(element);
		select.deselectByValue(value);
	}
	public static void deselectByVisibleText(WebElement element,String value) {
		select=new Select(element);
		select.deselectByVisibleText(value);
	}
	//dropdown without select tag
	
	public static void dDnSendkeys(WebElement element,String value) {
		select=new Select(element);
		element.sendKeys(value);
	}
	
	//screenshot
	public static void takescreenshot(String location) throws IOException {
		ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(location);
FileUtils.copyFile(source,dest);
	}
	
	//JavascriptExecutor
	
	public static void javascriptExecutorSetAttribute(String value,WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(value, element);
	}
	

	public static void javascriptExecutorbtnClick(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element);
	}
	
public static void javascriptExecutorgetAttribute(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Object txt=js.executeScript("return arguments[0].getAttribute('value')",element);
		System.out.println(txt);
	}
	//scroll down ,scroll up

public static void javascriptExecutorScrollDown(WebElement element) {
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
}


public static void javascriptExecutorScrollUp(WebElement element) {
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(false)", element);
}


//37
//frames
public static void framesize(String value) {
	List<WebElement> framesize=driver.findElements(By.tagName(value));
	int size=framesize.size();
	System.out.println("Framesize:"+size);
}


public static void switchToFrameByIndex(String value,int index) {
	List<WebElement> framesize=driver.findElements(By.tagName(value));
	int size=framesize.size();
	System.out.println("Framesize:"+size);
	driver.switchTo().frame(index);
	
}

public static void switchToFrameByName(String framename) {
	
	driver.switchTo().frame(framename);
	
}

//for dynamic frames use webelement reference
public static void switchToFrameByWebElement(WebElement element) {
	
	driver.switchTo().frame(element);
	
}

//to get back to normal window

public static void switchToNormalWindow(WebElement element) {
	
	driver.switchTo().defaultContent();
	
}


public static void parentWindow() {
	String prntWindow=driver.getWindowHandle();
	System.out.println(prntWindow);

}

public static void allWindows() {
Set<String> allWindows=driver.getWindowHandles();
System.out.println(allWindows);
	}
public static void switchtoChildWindow() {
	String prntWindow=driver.getWindowHandle();
	Set<String> allWindows=driver.getWindowHandles();
	for (String x : allWindows) {
		if(!prntWindow.equals(allWindows))
		{
			driver.switchTo().window(x);
		}
	}
}


//webtable
public static void printWebtable(WebElement element) {
	String table=element.getText();
	System.out.println(table);
	}

public static void printRow(WebElement element) {
	List<WebElement> tablerow=element.findElements(By.tagName("tr"));
	for (int i = 0; i < tablerow.size(); i++) {
		String rowtxt=tablerow.get(i).getText();
		System.out.println(rowtxt);
	}

}

public static void printColumn(List<WebElement> element) {
	for (int i = 0; i < element.size(); i++) {
		String txt=element.get(i).getText();
		System.out.println(txt);
	}

}


//48
//waits
public static void implicitWait(int timeout) {
	driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	
}

public static void webdriverWait(int timeout) {
	WebDriverWait ww=new WebDriverWait(driver, timeout);
	}


public static void navigateTo(String url) {
	driver.navigate().to(url);
}
public static void navigateRefresh() {
	driver.navigate().refresh();
}
public static void navigateForward() {
	driver.navigate().forward();
}
public static void navigatebackward() {
	driver.navigate().back();
}


}

