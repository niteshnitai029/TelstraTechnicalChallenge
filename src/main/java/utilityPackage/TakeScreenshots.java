package utilityPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshots {
	
	
	public void screenShot(WebDriver driver) throws IOException
    {
        // wait for field
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(generateFileName()));
            System.out.print(".");      
    }
	
	public String generateFileName() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = simpleDateFormat.format(cal.getTime()).replaceAll("\\s+","").replaceAll("-","_").replaceAll(":","_");
		String propertyFilePath= "Screenshots//TestScreenshot_"+ now + ".jpg";
		System.out.println("File name : "+propertyFilePath);
		return propertyFilePath;
	}
}
