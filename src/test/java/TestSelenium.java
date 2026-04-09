import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class TestSelenium {

    public static void main(String[] args) {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang anhtester.com
        driver.get("https://anhtester.com/");

        //Click nút Login
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();

        //Tắt browser
        driver.quit();
    }

}

