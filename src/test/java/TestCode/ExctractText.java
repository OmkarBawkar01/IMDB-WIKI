package TestCode;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExctractText {
     WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPushpaMovieDetails() {
        // Navigate to IMDB page for Pushpa: The Rise
        driver.get("https://www.imdb.com/title/tt9389998/");
        
        // Extract country and release date from IMDB page
        
        String imdbReleaseDate = driver.findElement(By.xpath("//a[text()='December 17, 2021 (United States)']")).getText().trim();
        String imdbCountry = driver.findElement(By.xpath("//a[text()='India']")).getText();
       

        // Navigate to WikiPedia page for Pushpa:The Rise
        
        driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
       
        // Extract country and release date from WikiPedia page

        String wikiReleaseDate = driver.findElement(By.xpath("//li[text()='17 December 2021']")).getText();
        String wikiCountry = driver.findElement(By.xpath("//td[text()='India']")).getText();
        
        
        // Print extracted details to console
        System.out.println("Pushpa:_The_Rise Release Date (IMDB): " + imdbReleaseDate);
        System.out.println("Pushpa:_The_Rise Country (IMDB): " + imdbCountry);
       
        System.out.println("Pushpa:_The_Rise Release Date (Wikipedia): " + wikiReleaseDate);
        System.out.println("Pushpa:_The_Rise Country (Wikipedia): " + wikiCountry);
        
    }
}
