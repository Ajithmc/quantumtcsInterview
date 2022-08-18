import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1 go to youtube.com 
		 * 2 select video 
		 * 3 play video in full screen 
		 * 4 verify video
		 * is playing in full screen
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
		search.sendKeys("manual testing full course");
		driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-searchbox'])[3]")).click();
		driver.findElement(By.xpath("//yt-formatted-string[text()='QA Manual Testing Full Course for Beginners Part-1']")).click();
		driver.findElement(By.xpath("//div[text()='Skip Ads']")).click();
		WebElement fullScreen = driver.findElement(By.xpath("//button[@title='Full screen (f)']"));
		fullScreen.click();
		if(fullScreen.isEnabled()) {
			System.out.println("The full Screen is enabled");
		}
		else {
			System.out.println("Not enabled");
		}
	}

}
