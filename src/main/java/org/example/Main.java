package org.example;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromedriver", "drivers/chromedriver");

        Scanner s = new Scanner(System.in);
        String URL;
        do {
            System.out.println("Gimme your URL!");
            URL = s.nextLine();
        } while (URL.isEmpty());

        if (!URL.matches("")) {
            WebDriver driver = new ChromeDriver();

            driver.get("https://flvconverter.org/rthgnugjdg/youtube-mp3-indir-dur.php"); // siteyi aç
            driver.manage().window().maximize(); // ekranı büyüt

            WebElement urlBox = driver.findElement(By.cssSelector(
                    "#__next > div > main > section.ConvertBlock_top-content__LgpIU > section > div > div > form > input"));
            urlBox.sendKeys(URL);

            WebElement button = driver.findElement(By.cssSelector(
                    "#__next > div > main > section.ConvertBlock_top-content__LgpIU > section > div > div > form > div.ConvertForm_form-footer__Oa5aB > div > button"));
            button.click();

            Thread.sleep(3500);
            String main = driver.getWindowHandle();
            Set<String> sekmeIsaretcileri = driver.getWindowHandles();
            for (String sekmeIsaretcisi : sekmeIsaretcileri) {
                if (!sekmeIsaretcisi.equals(main)) {
                    driver.switchTo().window(sekmeIsaretcisi);
                    break;
                }
            }
            driver.close();
            driver.switchTo().window(main);

            Thread.sleep(3000);
            WebElement mp3Download = driver.findElement(By.cssSelector(
                    "#__next > div > main > section.container.VideoPreview_preview__G8h8L > div > div:nth-child(1) > ul > li:nth-child(1) > button"));
            mp3Download.click();

            Thread.sleep(3000);
            main = driver.getWindowHandle();

            sekmeIsaretcileri = driver.getWindowHandles();
            for (String sekmeIsaretcisi : sekmeIsaretcileri) {
                if (!sekmeIsaretcisi.equals(main)) {
                    driver.switchTo().window(sekmeIsaretcisi);
                    break;
                }
            }
            driver.close();
            driver.switchTo().window(main);


            WebElement yuzde = driver.findElement(By.cssSelector("#__next > div > main > div > div.TopContent_info__S7wca > div"));
            while(true){
                if(yuzde.getText().matches("100"))
                    break;
                System.out.println(yuzde.getText());
                Thread.sleep(300);
            }

            Thread.sleep(2000);
            main = driver.getWindowHandle();
            driver.switchTo().window(main);

            WebElement download =
                    driver.findElement(By.cssSelector("#__next > div > main > div > div.DownloadContent_container__WaQ92 > div.DownloadContent_download__w3hv5 > div > a:nth-child(1) > button"));
            download.click();

            Thread.sleep(1500);
            main = driver.getWindowHandle();
            sekmeIsaretcileri = driver.getWindowHandles();
            for (String sekmeIsaretcisi : sekmeIsaretcileri) {
                if (!sekmeIsaretcisi.equals(main)) {
                    driver.switchTo().window(sekmeIsaretcisi);
                    driver.close();
                    break;
                }
            }
            driver.switchTo().window(main);
        }
    }
}