package Reusable_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Generic_function {
	public static WebDriver driver;
	public static XSSFWorkbook workbook;
	public static XSSFWorkbook workbook1;
	public static XSSFSheet sheet;
	public static XSSFCell cell,f;
	public static XSSFRow row;
	public static String CellData,path;
	public static int s=1;
	public static String Locator_value;
	public static int iter;
	public static int col;
	public static String mainwindow ;
	public static Set<String> s1 ;
	public static Iterator<String> i1 ;
	static File file = new File("configuration/config.properties");
	static Properties prop = new Properties();

	

	/* Reading  driver path from config.properties file */
	public static String getDriverPath() {
		String driverpath= prop.getProperty("Driverpath");
		if(driverpath!=null) return driverpath ;
		else throw new RuntimeException ("Driverpath is not specified in the Config.properties");
	}

	/* Reading URL from config.properties file */
	public static String getURL() {
		String URL= prop.getProperty("URL");
		if(URL!=null) return URL ;
		else throw new RuntimeException ("URL is not specified in the Config.properties");
	}

	/* Reading Excel file path  from config.properties   */
	private static String getFilepath() {
		String filepath= prop.getProperty("Filepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}

	 /* To read test data value of a particular fieldname passing to this function using findRow function to get row number from excel sheet */
	 public static String td_reader(String fieldname) {
	  sheet = workbook.getSheetAt(0);
	  col= Dataiter();
	  String td_value=sheet.getRow(findRow(fieldname)).getCell(col).getStringCellValue();
	  return td_value;
	 }
		
	 /* To read test data value of a particular fieldname using index where its values are seperated with a comma within cell in excel sheet */
	 public static String td_reader(String fieldname,int index){
	  sheet = workbook.getSheetAt(0);
	  col= Dataiter();
	  String td_value = sheet.getRow(findRow(fieldname)).getCell(col).getStringCellValue();
	  String[] str = td_value.split(",");
	  return str[index];
	 }
	    
	 /* To get row number of a particular fieldname passing to this function from excel sheet */
	 public static int findRow(String fieldname) {
	  sheet = workbook.getSheetAt(0);
	  for (Row row : sheet) {
	   for (Cell cell : row) {
	    if (cell.getRichStringCellValue().getString().trim().equals(fieldname)) {
	     return row.getRowNum();  
	    }
	   }
	  }       
	  return 0;
	 }
	
	/*To get directory path of screenshots*/
	public static  String getDir() {
		String dirpath= prop.getProperty("Dirpath");
		if(dirpath!=null) return dirpath ;
		else throw new RuntimeException ("user Dir is not specified in the Config.properties");
	}
	/*Object Locator of Excel sheet*/
	public static String OR_reader(String sheetname,String Fieldname) throws IOException  {
		File src=new File(getFilepath());
		FileInputStream finput = new FileInputStream(src);
		workbook = new XSSFWorkbook(finput);
		sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		row = sheet.getRow(0);
		for(int i=1;i<rowCount;i++) {
			cell = sheet.getRow(i).getCell(0);
			CellData = cell.getStringCellValue();
				 
			if(CellData.equals(Fieldname))
			{		 
				f= sheet.getRow(i).getCell(2);
				path = f.getStringCellValue();	 
				break;
			}
			
			
			else
			{
				continue;
			}
		}
		return path;
	}
	/*Generic Click function*/
	public static void click(String objname) throws IOException {
		driver.findElement(By.xpath(OR_reader("Object_Locator", objname))).click();

	}
   /* Browser launch*/
	public static WebDriver browserlaunch() throws IOException {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		 System.setProperty("webdriver.chrome.driver",getDriverPath());
		 driver =new ChromeDriver();
		 driver.navigate().to(getURL());
		 driver.manage().window().maximize();
		return driver;
	}
	
	/*Refresh the browser*/
	public static void browser_refresh() throws IOException {
		driver.navigate().refresh();
	}
	
	/*Close the opened driver*/
	public static void driverquit() {
		driver.close();
		driver.quit();	}
	  
	/*Close the window*/
	public static void window_close() {
		driver.close();
			}
	
	
	/*To get test data iteration value from config.properties file*/
	 public static int Dataiter() {            
	  iter=Integer.parseInt(prop.getProperty("Data_iteration"));
	  return iter;  
	 } 
	 
	 /* To wait the browser till the time passed to this function */
		public static void page_wait(int time) {
			driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		}
		
		/*  Navigated to the previous page  */
		public static void page_back() {
			driver.navigate().back();
		}
		
		/* Function used to handle multiple window*/
		public static void browser_handle() {
			mainwindow = driver.getWindowHandle();
			s1 = driver.getWindowHandles();
			i1 = s1.iterator();
			while (i1.hasNext()) {
	            String ChildWindow = i1.next();
	                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	                }
	        }    
	  
		}
		
		/* Function used to switch parent window*/ 
		   public static void browser_switch() {
		   driver.switchTo().window(mainwindow);
			}
		   
		   /* Taking Screenshot of failed test cases */ 
			 public static void takeScreenShot(String fileName) throws IOException { 
				 File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
				 FileUtils.copyFile(file, new File(getDir()+fileName+".png"));
				 }
			 
			 
		   
}
