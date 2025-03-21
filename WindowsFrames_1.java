package task_11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsFrames_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				WebDriver driver = new ChromeDriver();
				
				// 1. Open the application in the browser
				driver.get("https://the-internet.herokuapp.com/windows");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				// 2. Click the button to open the new window
				WebElement ClickHere = driver.findElement(By.linkText("Click Here"));
				ClickHere.click();
				
				// 3. Get the window Handles
				String mainWindow = driver.getWindowHandle();
				System.out.println(mainWindow);
				
				Set<String> allWindowHandles = driver.getWindowHandles();
				System.out.println(allWindowHandles);  //get all the windows
				
				// 4. Get how many windows present in the browser
				int Numwin = allWindowHandles.size();
				System.out.println(Numwin);
				
				// 5. Switch to the new window
				for (String windowHandle : allWindowHandles) {
					if(!windowHandle.equals(mainWindow)) {
						driver.switchTo().window(windowHandle);
						break;
					}
				}
				
				// 6. Verify New window is present
				WebElement newWindow = driver.findElement(By.tagName("h3"));
				if (newWindow.getText().equals("New Window")) {
					System.out.println("Verified new window Present");
				}
				else {
					System.out.println("Verified New window Not Present");
				}
				
				// 7. Close the new window
				driver.close();
				
				// 8. Verify original window is present
				driver.switchTo().window(mainWindow);
				if(driver.getTitle().equals("The Internet")) {
					System.out.println("Original Window is Active");
				}
				else {
					System.out.println("Original window is Inactive");
				}
				
				// 9. Close the browser
				
				driver.quit();

	}

}
