package priceMethods;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Methods {

	//Method for game price on humblebundle (long)
	public static double humbleBundle(WebDriver driver, String gameName) throws InterruptedException {
		driver.get("https://www.humblebundle.com/");
		Scanner sc = new Scanner(System.in);
		WebElement srch = driver.findElement(By.xpath("//input[@id='site-search']"));
		srch.sendKeys(gameName);
		Thread.sleep(2000);
		
		WebElement src1 = driver.findElement(By.xpath("//a[@class='site-search-link js-search-link']"));
		src1.click();
		
		Thread.sleep(2000);	
		List<WebElement> list = driver.findElements(By.className("entity-title"));
		for(int i = 0; i < list.size(); i++) {
			String gr = list.get(i).getText();
			if(gameName.contains(gr)) {
				list.get(i).click();
				break;				
			}
		}
		
			System.out.println("\nIf the game is called differently on this site \nPlease click on the game and then confirm in console");
			String cf = sc.nextLine();
					
		try {
		WebElement yer = driver.findElement(By.className("js-selection-year"));
		yer.click();
		WebElement yer1 = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/section/div[2]/div[2]/div/div[3]/select[3]/option[86]"));
		yer1.click();
		WebElement yer3 = driver.findElement(By.className("js-selection-month"));
		yer3.click();
		WebElement yer4 = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/section/div[2]/div[2]/div/div[3]/select[2]/option[3]"));
		yer4.click();
		WebElement yer5 = driver.findElement(By.className("js-submit-button"));
		yer5.click();
		}catch(Exception e) {
			System.out.println("No age restriction");
		}
		WebElement prc = driver.findElement(By.xpath("//div[contains(@class,'row-view gray-row showcase-row')]//meta[1]"));
		String se = prc.getAttribute("content");
		double d = Double.parseDouble(se);
		System.out.println("Price on humblebundle is "+d+" euros");
		return d;
		
		}
		
	//Method for game price on steam (long)
	public static double steamPowered(WebDriver driver, String gameName) throws InterruptedException {
		driver.get("https://store.steampowered.com/");
		Scanner sc = new Scanner(System.in);
		WebElement src = driver.findElement(By.xpath("//input[@id='store_nav_search_term']"));
		src.sendKeys(gameName);
		
		WebElement srcButton = driver.findElement(By.xpath("//a[@id='store_search_link']//img"));
		srcButton.click();
		
		Thread.sleep(2000);	
		List<WebElement> list = driver.findElements(By.className("title"));
		
			for(int i = 0; i < list.size(); i++) {
				String gr = list.get(i).getText();
				if(gameName.contains(gr)) {
					list.get(i).click();
					break;				
				}
			}
		
			System.out.println("\nIf the game is called differently on this site \nPlease click on the game and then confirm in console");
			String cf = sc.nextLine();
		
			try {
				WebElement yer = driver.findElement(By.xpath("//select[@id='ageYear']"));
				yer.click();
				WebElement yer1 = driver.findElement(By.xpath("//option[contains(text(),'1985')]"));
				yer1.click();
				WebElement yer3 = driver.findElement(By.xpath("//select[@id='ageMonth']"));
				yer3.click();
				WebElement yer4 = driver.findElement(By.xpath("//option[contains(text(),'May')]"));
				yer4.click();
				WebElement yer5 = driver.findElement(By.xpath("//span[contains(text(),'View Page')]"));
				yer5.click();
				}catch(Exception e) {
					System.out.println("No age restriction");
				}
		
				
		Thread.sleep(2000);
		List<WebElement> lst1 = driver.findElements(By.className("game_purchase_action_bg"));
		WebElement price1 = lst1.get(0);
		String se = price1.getText();
		String se1 = se.replaceAll("[^\\d]", "");		
		StringBuilder sb = new StringBuilder(se1);
		sb.insert(2, ".");
		String fin = sb.toString();
		double d = Double.parseDouble(fin);
		System.out.println("Price on steam is "+d+" euros");
		return d;
						
	}
	
	//Method for game name correction on google
	public static String google(WebDriver driver, String gameName) {
		driver.get("https://www.google.com/");
		WebElement gl = driver.findElement(By.xpath("//input[@name='q']"));
		gl.click();
		gl.sendKeys(gameName + " video game");
		WebElement button = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']"));
		button.click();
		WebElement nameG = driver.findElement(By.className("kno-ecr-pt"));
		String nameN = nameG.getText();		
		return nameN;
	}
	
	//Method for game name correction on steam
	public static String steamName(WebDriver driver, String gameName) throws InterruptedException {
		driver.get("https://store.steampowered.com/");
		WebElement src = driver.findElement(By.xpath("//input[@id='store_nav_search_term']"));
		src.sendKeys(gameName);
		
		WebElement srcButton = driver.findElement(By.xpath("//a[@id='store_search_link']//img"));
		srcButton.click();
		
		Thread.sleep(2000);
		List<WebElement> lst = driver.findElements(By.className("search_price"));
		WebElement price = lst.get(0);
		price.click();
		
		WebElement title = driver.findElement(By.xpath("//div[@class='apphub_AppName']"));
		String t1 = title.getText();
		String t = t1.toUpperCase();
		return t;		
	}
	
	//Method for game price on cdkeys (long and short)
	public static double cdKeys(WebDriver driver, String gameName, double course) throws InterruptedException {
		driver.get("https://www.cdkeys.com/");
		WebElement src = driver.findElement(By.xpath("//input[@id='search']"));
		src.sendKeys(gameName);
		WebElement srcButton = driver.findElement(By.xpath("//input[@id='search_cta']"));
		srcButton.click();
		
		Thread.sleep(2000);
		List<WebElement> lst = driver.findElements(By.className("price"));
		WebElement price = lst.get(0);
		String se = price.getText();		
		double d = Double.parseDouble(se.replaceAll("£", ""));
		System.out.println("Price on cdkeys is "+d * course+" euros");
		return d * course;
	}
	
	//Method for pound/euro daily course
	public static double course(WebDriver driver) {
		driver.get("https://www.xe.com/currencyconverter/convert/?Amount=1&From=GBP&To=EUR/");
		WebElement de = driver.findElement(By.xpath("//span[@class='converterresult-toAmount']"));
		String se = de.getText();
		double d = Double.parseDouble(se);
		System.out.println("Today 1 british pound is "+d+" euros");
		return d;
	}
	
	//Method for game price on humblebundle (short)
	public static double humbleBundle1(WebDriver driver, String gameName) throws InterruptedException {
		driver.get("https://www.google.com/");
		WebElement gl = driver.findElement(By.xpath("//input[@name='q']"));
		gl.click();
		gl.sendKeys(gameName + " humblebundle");
		WebElement button = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']"));
		button.click();
		
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.className("LC20lb"));
		WebElement nameG = list.get(0);
		nameG.click();
		
		try {
			WebElement yer = driver.findElement(By.className("js-selection-year"));
			yer.click();
			WebElement yer1 = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/section/div[2]/div[2]/div/div[3]/select[3]/option[86]"));
			yer1.click();
			WebElement yer3 = driver.findElement(By.className("js-selection-month"));
			yer3.click();
			WebElement yer4 = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/section/div[2]/div[2]/div/div[3]/select[2]/option[3]"));
			yer4.click();
			WebElement yer5 = driver.findElement(By.className("js-submit-button"));
			yer5.click();
			}catch(Exception e) {
				System.out.println("No age restriction");
			}
		
		WebElement prc = driver.findElement(By.xpath("//div[contains(@class,'row-view gray-row showcase-row')]//meta[1]"));
		String se = prc.getAttribute("content");
		double d = Double.parseDouble(se);
		System.out.println("Price on humblebundle is "+d+" euros");
		return d;			
	}
	
	//Method for game price on steam (short)
	public static double steamPowered1(WebDriver driver, String gameName) throws InterruptedException {
		driver.get("https://www.google.com/");
		WebElement gl = driver.findElement(By.xpath("//input[@name='q']"));
		gl.click();
		gl.sendKeys(gameName + " steam");
		WebElement button = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']"));
		button.click();
		
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.className("LC20lb"));
		WebElement nameG = list.get(0);
		nameG.click();
		
		try {
			WebElement yer = driver.findElement(By.xpath("//select[@id='ageYear']"));
			yer.click();
			WebElement yer1 = driver.findElement(By.xpath("//option[contains(text(),'1985')]"));
			yer1.click();
			WebElement yer3 = driver.findElement(By.xpath("//select[@id='ageMonth']"));
			yer3.click();
			WebElement yer4 = driver.findElement(By.xpath("//option[contains(text(),'May')]"));
			yer4.click();
			WebElement yer5 = driver.findElement(By.xpath("//span[contains(text(),'View Page')]"));
			yer5.click();
			}catch(Exception e) {
				System.out.println("No age restriction");
			}
		
		Thread.sleep(2000);
		List<WebElement> lst1 = driver.findElements(By.className("game_purchase_action_bg"));
		WebElement price1 = lst1.get(0);
		String se = price1.getText();
		String se1 = se.replaceAll("[^\\d]", "");		
		StringBuilder sb = new StringBuilder(se1);
		sb.insert(2, ".");
		String fin = sb.toString();
		double d = Double.parseDouble(fin);
		System.out.println("Price on steam is "+d+" euros");
		return d;
		
	}
	
		
	
}
