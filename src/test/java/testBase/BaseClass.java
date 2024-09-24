package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties prop;


    @Parameters({"os","browser"})
    @BeforeClass(groups = {"Sanity","Regression","Master","DataDriven"})
    public void setUp(String os, String br) throws IOException {

        //Loading properties file
        FileReader file=new FileReader(".//src//test//resources//config.properties");
        prop=new Properties();
        prop.load(file);

        //loading log4j file
        logger= LogManager.getLogger(this.getClass());

        //launching browser based on condition
        switch (br.toLowerCase())
        {
            case "chrome" : driver=new ChromeDriver(); break;
            case "edge" : driver=new EdgeDriver();break;
            case "firefox" : driver=new FirefoxDriver();break;
            default: System.out.println("Invalid browser entry"); return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        driver.get(prop.getProperty("appUrl"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity","Regression","Master","DataDriven"})
    public void tearDown()
    {
        driver.quit();
    }


    public String randomString()
    {
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String randomNumber()
    {
        String generateNum=RandomStringUtils.randomNumeric(10);
        return generateNum;
    }

    public String randomAlpaNumaric()
    {
        String Str=RandomStringUtils.randomAlphabetic(3);
        String Num=RandomStringUtils.randomNumeric(3);
        return (Str+Num);
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
