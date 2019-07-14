package priceMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class ImpMet {

	

	//Method game price long
	public static void impMet2(WebDriver driver, String gameName) throws InterruptedException {
		
		double course = Methods.course(driver);
		String gameName1 = Methods.google(driver, gameName);
		if(gameName1.contentEquals("The Witcher 3: Wild Hunt")) {
			StringBuilder sb = new StringBuilder(gameName1);
			sb.insert(11, "®");
			gameName1 = sb.toString();
		}
		String gameName2 = gameName1.toUpperCase();
		double cdK = Methods.cdKeys(driver, gameName1, course);
		double stM = Methods.steamPowered(driver, gameName1);
		double huB = Methods.humbleBundle(driver, gameName2);
		
		
		List<Double> list = new ArrayList<>();
		list.add(cdK);
		list.add(huB);
		list.add(stM);
		double best = Collections.min(list);
		if(best == cdK) {
			System.out.println("\n Best price is on cdkeys");
			Methods.cdKeys(driver, gameName1, course);
			
		}
		else if(best == huB) {
			System.out.println("\n Best price is on Humble Bundle");
			Methods.humbleBundle(driver, gameName2);
			
		}
		else if(best == stM) {
			System.out.println("\n Best price is on steam");
			Methods.steamPowered(driver, gameName1);
			
		}
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	
	//Method game price short
	public static void impMet1(WebDriver driver, String gameName) throws InterruptedException {
		double course = Methods.course(driver);
		String gameName1 = Methods.google(driver, gameName);
		
		double cdK = Methods.cdKeys(driver, gameName1, course);
		double stM = Methods.steamPowered1(driver, gameName1);
		double huB = Methods.humbleBundle1(driver, gameName1);
		
		List<Double> list = new ArrayList<>();
		list.add(cdK);
		list.add(huB);
		list.add(stM);
		double best = Collections.min(list);
		if(best == cdK) {
			System.out.println("\n Best price is on cdkeys");
			Methods.cdKeys(driver, gameName1, course);
			
		}
		else if(best == huB) {
			System.out.println("\n Best price is on Humble Bundle");
			Methods.humbleBundle(driver, gameName1);
			
		}
		else if(best == stM) {
			System.out.println("\n Best price is on steam");
			Methods.steamPowered(driver, gameName1);
			
		}
		Thread.sleep(3000);
		driver.manage().window().maximize();
	}
	
	
	
}
