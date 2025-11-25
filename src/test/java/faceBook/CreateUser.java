package faceBook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateUser {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        String facebookUrl="https://www.facebook.com/";
//		if (facebookUrl.equalsIgnoreCase(driver.getCurrentUrl())) {
//			System.out.println("URL matched "+ driver.getCurrentUrl());
//
//		} else {
//			System.out.println(driver.getCurrentUrl());
//			System.out.println("URL MISMATCHED");
//		}

        Assert.assertEquals(driver.getCurrentUrl(), facebookUrl, "Url not matched");

        String homePageText = "Facebook helps you connect and share with the people in your life.";

        WebElement textHomePage = driver.findElement(By.xpath("//h2[@class='_8eso']"));
        textHomePage.getText();

        Assert.assertEquals(textHomePage.getText(), homePageText, "text not matched");

        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vedant");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shukla");

        WebElement birthDate = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select s = new Select(birthDate);
        s.selectByVisibleText("10");

        WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select s1 = new Select(birthMonth);
        s1.selectByIndex(7);

        WebElement birthYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select s2 = new Select(birthYear);
        s2.selectByValue("2014");

        driver.findElement(By.xpath("//label[text()='Male']/input")).click();


        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("789456123");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("789ajshgel@kadf");

        driver.findElement(By.xpath("//button[@name='websubmit']")).click();


    }
}
