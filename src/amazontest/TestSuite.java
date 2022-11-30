package amazontest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void dellOnAmazon() throws InterruptedException {
        //Type "Dell Laptop" in the search box and press enter or click on search Button.
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));
        //Click on the checkbox brand dell on the left side.
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[5]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]"));
        //Verify that the  products are displayed on the page.
        List<WebElement> followingSibling = driver.findElements(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/following-sibling::*"));
        System.out.println("Number of Listing:   " + followingSibling.size());
        boolean isProductDisplayed = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/following-sibling::*")).isDisplayed();
        System.out.println("All items displayed:   " + isProductDisplayed);
//Print all product names in the console

        for (WebElement element : followingSibling) {
            String strLink = element.getText();

            System.out.println(strLink);
        }


    }}
