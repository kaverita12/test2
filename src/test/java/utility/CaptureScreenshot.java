package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utility.CurrentDateTime;
import utility.ReadConfig;


public class CaptureScreenshot {

	public static String takeScreenshot(WebDriver driver) throws IOException {
		String path = null;
		try {
			path = ReadConfig.getScreenshotPath()+CurrentDateTime.getDateTime()+".png";
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println("Screenshot taken");
		return path;
	}
	
}
