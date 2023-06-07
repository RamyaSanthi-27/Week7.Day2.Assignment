package week7.day2.Assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicityWaitforLeafGround {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		//1. Launch the url ("https://www.leafground.com/window.xhtml")		
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().window().maximize();
		
		//2.Declaration of ExplicitWait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//3.Wait for Visibility (1 - 10 Sec)
		driver.findElement(By.xpath("//span[text()='Click']")).click();			
		//4.wait until Visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='I am here']")));
        String text1 = driver.findElement(By.xpath("//h5[text()='Wait for Visibility (1 - 10 Sec)']")).getText();
        System.out.println(text1);
        String text2 = driver.findElement(By.xpath("//span[text()='I am here']")).getText();
        System.out.println(text2);
        System.out.println("==============================");
               
        
        //5.Wait for Invisibility (1 - 10 Sec)
      	
      	 String text3 = driver.findElement(By.xpath("//h5[text()='Wait for Invisibility (1 - 10 Sec)']")).getText();
         System.out.println(text3);
      	 String text4 = driver.findElement(By.xpath("//span[text()='I am about to hide']")).getText();
         System.out.println(text4);
         driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click();	
      	//6.wait until InVisible
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='I am about to hide']")));
         String text5 = driver.findElement(By.xpath("//h5[text()='Wait for Invisibility (1 - 10 Sec)']")).getText();
         System.out.println(text5);        
         System.out.println("==============================");
         
         
         //7.Wait for Clickability
         String text6 = driver.findElement(By.xpath("//h5[text()='Wait for Clickability']")).getText();
         System.out.println(text6); 
         WebElement clickfirst = driver.findElement(By.xpath("//span[text()='Click First Button']"));
         wait.until(ExpectedConditions.elementToBeClickable(clickfirst));
         String text7 = driver.findElement(By.xpath("//span[text()='Click First Button']")).getText();
         System.out.println(text7);   
         WebElement clickSecond= driver.findElement(By.xpath("//span[text()='Click Second']"));
         clickSecond.click();
         String text8 = driver.findElement(By.xpath("//span[text()='Click Second']")).getText();
         System.out.println(text8); 
         System.out.println("==============================");
         
         //8.Wait for Text Change (1 - 10 Sec)
         String text9 = driver.findElement(By.xpath("//h5[text()='Wait for Text Change (1 - 10 Sec)']")).getText();
         System.out.println(text9);                  
         String text = driver.findElement(By.xpath("//span[text()='I am going to change!']")).getText();
         System.out.println(text);         
         WebElement clickChange = driver.findElement(By.xpath("(//span[text()='Click'])[3]"));
         clickChange.click();
         System.out.println("===Changed Text is===");
         //9.Wait until change the text
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Did you notice?']")));
         String text10 = driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText();
         System.out.println(text10); 
 	  
	}
	
}
