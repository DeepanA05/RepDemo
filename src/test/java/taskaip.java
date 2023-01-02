

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class taskaip {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omrbranch.com/apitestingtraininginchennaiomr");
		WebElement cdd = driver.findElement(By.id("country-list"));
		Select s = new Select(cdd);
		List<WebElement> options = s.getOptions();
		File file = new File("C:\\Users\\Deepan\\eclipse-workspace\\Framework\\excel\\dropdown.xlsx");
		Workbook work = new XSSFWorkbook();
	    Sheet Sheet = work.createSheet();
	    for (int i = 0; i < options.size(); i++) {
	    	WebElement element = options.get(i);
	    	Row row = Sheet.createRow(i);
	    	Cell cell = row.createCell(0);
	    	String text = element.getText();
	    	cell.setCellValue(text);
	    	
	    	FileOutputStream out = new FileOutputStream(file);
	    	work.write(out);
	    	
			
		}
		
				
		
	}

}
