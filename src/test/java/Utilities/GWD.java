package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.http.WebSocket;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {
    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    private static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    public static WebDriver getDriver(){

        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language","EN");

        Logger logger=Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

        if(threadBrowserName.get()==null)
            threadBrowserName.set("chrome");

        if(threadDriver.get()==null) {
            switch (threadBrowserName.get()) {
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "safari":
                    threadDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadDriver.set(new FirefoxDriver());
                    break;

                default:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                    threadDriver.set(new ChromeDriver(options));
                    break;

            }
        }

        threadDriver.get().manage().window().maximize();
        return threadDriver.get();

    }

    public static void quitDriver(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
        if(threadDriver.get()!=null){
            threadDriver.get().quit();
            WebDriver driver= threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }

    }

    public static void threadBrowserSet(String browser){
        threadBrowserName.set(browser);
    }

    public static String threadBrowserGet(){
        return threadBrowserName.get();
    }


}
