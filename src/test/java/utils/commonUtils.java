package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class commonUtils {
	
	public  static String  generateRandomEmail()
	{
		Date date=new Date();
		return date.toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com";
		
	}
	
	public  static boolean compareTwoScreenshots(String expectedPath,String actualPath) throws IOException
	{
		
	    
	     BufferedImage expectedImage = ImageIO.read(new File(expectedPath));
	     BufferedImage actualImage = ImageIO.read(new File(actualPath));
	     
	    
	     ImageDiffer imgDiff = new ImageDiffer();
	     ImageDiff differenceImage = imgDiff.makeDiff(expectedImage, actualImage);
	    return  differenceImage.hasDiff();
	}

}
