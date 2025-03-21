package task_11;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowsFrame_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// 1. Open the URL
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		// 2. Switch to Top frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		
		// 3. Verify Three frame are there in top frame
		int frameCount = driver.findElements(By.tagName("frame")).size();
		if (frameCount ==3) {
			System.out.println("Top Frame contains Three Frames");
		}
		else {
			System.out.println("Top Frame doesn't contains Three Frames");
		}
		
		// 4. Switch To Left Frame
		Actions actions = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.name("frame-left")));
		WebElement leftText = driver.findElement(By.tagName("body"));
		actions.moveToElement(leftText).perform();
		System.out.println("Left Frame Text: " +leftText.getText());
		
		//switch to top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
		// 5. Switch to Middle Frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		WebElement middleText = driver.findElement(By.tagName("body"));
		if(middleText.getText().trim().equals("MIDDLE")) {
			System.out.println("Middle Frame Text : " +middleText.getText());
		}
		else {
			System.out.println("Middle Frame Text is wrong");
		}
		
		//switch to top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
		// 6. Switch to Right Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
		WebElement rightText = driver.findElement(By.tagName("body"));
		if(rightText.getText().trim().equals("RIGHT")) {
			System.out.println("Right Frame Text :" +rightText.getText());
		}
		else {
			System.out.println("Right Frame Text is wrong");
		}
		
		//switch to top frame
		driver.switchTo().defaultContent();
		//driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
		// 7. Switch to Bottom Frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));
		WebElement bottomText = driver.findElement(By.tagName("body"));
		if(bottomText.getText().trim().equals("BOTTOM")) {
			System.out.println("Bottom Frame Text : " +bottomText.getText());
		}
		else {
			System.out.println("Bottom Frame Text is wrong");
		}
		
		//switch to top frame
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
		// 8. Verify Page title
		String pageTitle = driver.getTitle();
		System.out.println("Page Title : " + pageTitle);
		Assert.assertEquals(pageTitle, "Frames", "Page title doesn't match!");
		
		driver.quit();
	}

}
