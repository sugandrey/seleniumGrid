import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteTest {

	public static void main(String[] args) throws IOException {
		//Desired capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.17:4444/wd/hub"), dc);
		driver.get("http://rediff.com");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\user\\Desktop\\screenShot1.png"));
		driver.close();
		DesiredCapabilities fdc = new DesiredCapabilities();
		fdc.setBrowserName("firefox");
		fdc.setPlatform(Platform.WINDOWS);
		WebDriver fdriver = new RemoteWebDriver(new URL("http://192.168.0.17:4444/wd/hub"),fdc);
		fdriver.get("https://jw.org");
		File fsrc = ((TakesScreenshot)fdriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fsrc,new File("C:\\Users\\user\\Desktop\\screenShot2.png"));
		fdriver.close();
		}

}
