package priceMethods;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Proba {
	//Main method for starting program to find best game price
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Milan\\Desktop\\GamePrice Project\\GamePriceProject\\driver\\chromedriver.exe");
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to find best game price program ");
		Thread.sleep(2000);
		System.out.println("\nPlease enter the name of game:");
		String game = sc.nextLine();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(1000, 50));
		
		System.out.println("Choose a method:\n1. Faster method\n2 Slower method");
		
		while(true) {
			int n = sc.nextInt();
			if(n == 1) {
				ImpMet.impMet1(driver, game);
				break;
			}
			else if(n == 2) {
				ImpMet.impMet2(driver, game);
				break;
			}
			else {
				System.err.println("WRONG INPUT");
			}
		}				
	}	
}
