package com.eaias.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CuEAIASBaseClass {

	
	
protected static WebDriver driver;
	
	Actions actions ;
	
	static Alert alert;
	
	/**
	 * 
	 * @see used to maintain chrome browser launch method
	 * @date 30-Aug-2023
	 * 
	 */

	public static void chromeBrowserLaunch() {
	
	   driver = new ChromeDriver();
	}
	
	/**
	 * @see used to maintain browser launch switch method
	 * @date 30-Aug-2023
	 * @param browserType
	 */
	
	public static void browserLaunch(String browserType) {
		
		switch (browserType) {
		case "chrome":
			
			driver = new ChromeDriver();
			
			break;
			
        case "ie":
			
			driver = new InternetExplorerDriver();
			
			break;
			
case "firefox":
	
	driver = new FirefoxDriver();
	
	break;
	
case "edge":
	
	driver = new EdgeDriver();
	
	break;

		default:
			break;
		}
		
	}

	/**
	 * @see used to maintain search url method
	 * @date 30-Aug-2023
	 * @param url
	 */
	
	public static void getUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * @see used to maintain window maximize method
	 * @date 30-Aug-2023
	 */

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
//	@SuppressWarnings("deprecation")
//	public void implicitWait() {
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
//	}
	
	/**
	 * @see used to maintain implicit wait method
	 * @date 
	 */
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));	
	}
	
	/**
	 * @see used to maintain implicit wait method with input
	 * @date 30-Aug-2023
	 * @param secs
	 */
	
	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));	
	}
	
	/**
	 * @see used to maintain webdriver wait method
	 * @date 30-Aug-2023
	 * @param secs
	 * @param element
	 */
	public void webDriverWait(int secs, WebElement element ) {
		
		WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		driverwait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * @see used maintain webdriver wait method with input
	 * @date 30-Aug-2023
	 * @param element
	 */
	
	public void webDriverWait(WebElement element ) {
		
		WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverwait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * @see used to maintain fluent wait method
	 * @date 30-Aug-2023
	 * @param element
	 */
	public void fluentWait(WebElement element) {
		
       Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(10)).ignoring(Throwable.class);  
       w.until(ExpectedConditions.elementToBeClickable(element));
	}
    /**
     * @see used to maintain fluent wait with inputs method
     * @date 30-Aug-2023
     * @param secs
     * @param pollingsecs
     * @param element
     */
	public void fluentWait(int secs, int pollingsecs, WebElement element) {
		
	       Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(secs)).pollingEvery(Duration.ofSeconds(pollingsecs)).ignoring(Throwable.class);  
	       w.until(ExpectedConditions.elementToBeClickable(element));
		}
	/**
	 * @see used to maintain findelement by id method with input
	 * @date 30-Aug-2023
	 * @param id
	 * @return webelement
	 */
	
	public WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
/**
 * @see used to maintain findelement by name method with input
 * @date 30-Aug-2023
 * @param name
 * @return webelement
 */
	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}
	/**
	 * @see used to maintain findelement by class method with input
	 * @date 30-Aug-2023
	 * @param classname
	 * @return webelement
	 */
	public WebElement findElementByClassName(String classname) {
		WebElement element = driver.findElement(By.className(classname));
		return element;
	}
	/**
	 * @see used to maintain locate webelement by xpath method with input
	 * @date 30-Aug-2023
	 * @param xpathExpression
	 * @return webelement
	 */
	
	public WebElement locateByXpath(String xpathExpression) {
		WebElement element = driver.findElement(By.xpath(xpathExpression));
		return element;
	}
	/**
	 * @see used to maintain input text in searchbox method with input
	 * @date 30-Aug-2023
	 * @param element
	 * @param value
	 */

	public void inputText(WebElement element, String value) {
		element.sendKeys(value);
	}
	/**
	 * @see used to maintain webelement click method
	 * @date 30-Aug-2023
	 * @param element
	 */

	public void click(WebElement element) {
		element.click();
	}
	/**
	 * Used to maintain clear text box method with input
	 * @date 30-Aug-2023 
	 * @param element
	 */
	public void clearTextBox(WebElement element) {
		element.clear();
	}
/**
 * @see used to maintain close window method
 * @date 30-Aug-2023
 */
	public static void closeWindow() {
		driver.close();
	}
/**
 * @see used to maintain quitbrowser method
 * @date 30-Aug-2023
 */
	public static void quitBorwser() {
		driver.quit();
	}
/**
 * @see used to maintain refresh webpage method
 * @date 30-Aug-2023
 */
	public static void refreshPage() {
		driver.navigate().refresh();;
	}
	/**
	 * @see used to maintain accept alert method
	 * @date 30-Aug-2023
	 */
	 public void alertOk() {
	     alert = driver.switchTo().alert();
	     alert.accept();
	}
	    /**
	     * @see used to maintain dismiss alert method
	     * @date 30-Aug-2023
	     */
	    public void alertCancel() {
	    alert = driver.switchTo().alert();
	    alert.dismiss();
	}
	/**
	 * @return 
	 * @see used to maintain get title method
	 * @date 30-Aug-2023
	 */
	public String getTitle() {
		String title = driver.getTitle();
//		System.out.println(title);
		return title;
	}
/** 
 * @see used to maintain get current url method
 * @date 30-Aug-2023
 */
	public void getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
/**
 * @see used to maintain get attribute method with input
 * @date 30-Aug-2023
 * @param element
 * @return string
 */
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("Value");
		return attribute;
	}
/**
 * @see used to maintain get text method with input
 * @param element
 * @return string
 */
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	/**
	 * @see used to maintain actions class method
	 * @date
	 */
	public void actionsClass() {
		
		actions = new Actions(driver);
	}
/**
 * @see used to maintain mouse over action method with input
 * @date 30-Aug-2023
 * @param element
 */
	public void mouseOverAction(WebElement element) {
		actions.moveToElement(element).perform();
	}
/**
 * @see used to maintain drag and drop method with inputs
 * @date 30-Aug-2023
 * @param sourceElement
 * @param destElement
 */
	public void dragAndDrop(WebElement sourceElement, WebElement destElement) {
		actions.dragAndDrop(sourceElement, destElement).perform();
	}
/**
 * @see used to maintain doubleclick method
 * @date 30-Aug-2023
 * @param element
 */
	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}
	/**
	 * @see used to maintain rghtclick method
	 * @date 30-Aug-2023
	 * @param element
	 */
	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}
    /**
     * @see used to maitain keydown method with inputs
     * @date 30-Aug-2023
     * @param actions
     * @param key
     */
	public void keyDown(Actions actions, CharSequence key) {
		actions.keyDown(key).perform();
	}
/**
 * @see used to maintain keyup method with inputs
 * @date 30-Aug-2023
 * @param actions
 * @param key
 */
	public void keyUp(Actions actions, CharSequence key) {
		actions.keyUp(key).perform();
	}
	/**
	 * @see used to maintain switch to parent window method
	 * @date 30-Aug-2023
	 */
//	@SuppressWarnings("unused")
	public void switchToParentWindow() {
		String parentWindow = driver.getWindowHandle();
	    driver.switchTo().window(parentWindow);
	}
	/**
	 * @see used to maintain switch to child window method
	 * @date 30-Aug-2023
	 */
//	@SuppressWarnings("unused")
	public void switchToChildWindow() {
		
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		for (String eachWindow : childWindow) {
			if (!parentWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);			
			}	
		}
	
	}
     /**
      * @see used to maintain navigate back method
      * date 30-Aug-2023
      */
	public void navigateBack() {
		driver.navigate().back();
	}
/**
 * @see used to navigate forward method
 * date 30-Aug-2023
 */
	public void navigateFwd() {
		driver.navigate().forward();
	}
/**
 * @see used to maintain navigate refresh method
 * @date 30-Aug-2023
 */
	public void navigateRefresh() {
		driver.navigate().refresh();
	}
/**
 * @see used to maintain robot enter method
 * @date 30-Aug-2023
 * @throws AWTException
 */
	public void robotEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * @see used to maintain robot shift method
	 * @date 30-Aug-2023
	 * @throws AWTException
	 */
	public void robotShift() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	/**
	 * @see used to maintain robot control method
	 * @date 30-Aug-2023
	 * @throws AWTException
	 */
	public void robotCtrl() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	/**
	 * @see used to maintain robot up method
	 * @date 30-Aug-2023
	 * @throws AWTException
	 */
	public void robotUp() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}
	/**
	 * @see used to maintain robot down method
	 * @date 30-Aug-2023
	 * @throws AWTException
	 */
	public void robotDown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}
	/**
	 * @see used to maintain robot tab method
	 * @date 30-Aug-2023
	 * @throws AWTException
	 */
	public void robotTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
/**
 * @see used to maintain find element by xpath method with input
 * @date 30-Aug-2023
 * @param xpathExpresseion
 * @return webelement
 */
	public WebElement findElementByXpath(String xpathExpresseion) {

		WebElement element = driver.findElement(By.xpath(xpathExpresseion));
		return element;

	}
/**
 * @see used to maintain maximize method 
 * @date 30-Aug-2023
 */
	public static void maximize() {
		driver.manage().window().maximize();
	}
/**
 * @see used to maintain sendkeys method
 * @date 30-Aug-2023
 * @param element
 * @param value
 */
	public void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}
	/**
	 * @see used to maintain sendkeys with tab method with input
	 * @date 30-Aug-2023
	 * @param element
	 * @param value
	 */
	public void sendKeysWithTab(WebElement element, String value) {
		element.sendKeys(value,Keys.TAB);
	}
	/**
	 * @see used to maintain sendkeys with enter method with input
	 * @date 30-Aug-2023
	 * @param element
	 * @param value
	 */
	public void sendKeysWithEnter(WebElement element, String value) {
		element.sendKeys(value,Keys.ENTER);
	}
	/**
	 * @see used to maintain robot enter key method
	 * @date 30-Aug-2023
	 * @throws AWTException
	 */
	public void enterKey() throws AWTException {
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * @see used to maintain sendkeys with javascript method with input
	 * @date 30-Aug-2023
	 * @param element
	 * @param data
	 */
	public void sendKeysJs(WebElement element,String data) {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}
	/**
	 * @see used to maintain click with javascript method with inputs
	 * @param element
	 * @param subsequence
	 */
public void sendKeysJsChar(WebElement element,CharSequence subsequence) {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value','"+subsequence+"')", element);
	}
	/**
	 * @see 
	 * @param element
	 */
public void clickJs(WebElement element) {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
	}

	public void selectOptionbyText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionbyIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectOptionbyValue(WebElement element, String attributeValue) {

		Select select = new Select(element);
		select.selectByValue(attributeValue);
	}

	public void deselectOptionbyText(WebElement element, String text) {

		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	public void deselectOptionbyIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void deselectOptionbyValue(WebElement element, String attributeValue) {

		Select select = new Select(element);
		select.deselectByValue(attributeValue);

	}

	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();

	}

	public List<WebElement> getOptions(WebElement element) {

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;

	}

	public void printOptions(WebElement element) {

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		for (int i = 0; i < options.size(); i++) {

			WebElement element2 = options.get(i);
			String text = element2.getText();
			System.out.println(text);
		}

	}

	public void selectAllByIndex(WebElement element) {

		Select select = new Select(element);
		List<WebElement> options = select.getOptions();

		for (int i = 1; i <= options.size(); i++) {
			select.selectByIndex(i);
		}

	}

	public void selectAllBytext(WebElement element) {

		Select select = new Select(element);
		List<WebElement> options2 = select.getOptions();

		for (WebElement webElement : options2) {
			String text = webElement.getText();
			select.selectByVisibleText(text);

		}
	}

	public void takeScreenshot(String destination) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		File d = new File(destination);
		FileUtils.copyFile(s, d);

	}

	public void takeScreenshotForElement(WebElement element, String destination) throws IOException {

		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File(destination);
		FileUtils.copyFile(s, d);

	}

//	public void excelUpdateCellData(String sheetName, int rowNum, int cellNum, String oldData, String newData) throws IOException {
//
//		File file = new File("");
//		FileInputStream stream = new FileInputStream(file);
//
//		@SuppressWarnings("resource")
//		Workbook workbook = new XSSFWorkbook(stream);
//		Sheet sheet = workbook.getSheet(sheetName);
//		Row row = sheet.getRow(rowNum);
//		Cell cell = row.createCell(cellNum);
//	    String value = cell.getStringCellValue();
//	    
//	    if (value.equals(oldData)) {
//	    	cell.setCellValue(newData);
//		}
//		FileOutputStream out = new FileOutputStream(file);
//		workbook.write(out);
//
//	}
//
//	public void excelWriteCellData(String path, String sheetName, int rowNum, int cellNum, String value) throws IOException {
//
//		File file = new File(path);
//		FileInputStream stream = new FileInputStream(file);
//
//		@SuppressWarnings("resource")
//		Workbook workbook = new XSSFWorkbook(stream);
//		Sheet sheet = workbook.getSheet(sheetName);
//		Row row = sheet.getRow(rowNum);
//		Cell cell = row.getCell(cellNum);
//		cell.setCellValue(value);
//		
//		FileOutputStream outputStream = new FileOutputStream(file);
//		workbook.write(outputStream);
//
//	}
//
//	public String excelReadCellData(String path, String sheetName, int rowNum, int cellNum) throws IOException {
//
//		String value = null;
//		File file = new File(path);
//		FileInputStream stream = new FileInputStream(file);
//
//		@SuppressWarnings("resource")
//		Workbook workbook = new XSSFWorkbook(stream);
//		Sheet sheet = workbook.getSheet(sheetName);
//		Row row = sheet.getRow(rowNum);
//		Cell cell = row.getCell(cellNum);
//		CellType cellType = cell.getCellType();
//
//		switch (cellType) {
//
//		case STRING:
//			value = cell.getStringCellValue();
//			break;
//
//		case NUMERIC:
//
//			if (DateUtil.isCellDateFormatted(cell)) {
//				Date dateCellValue = cell.getDateCellValue();
//				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
//				value = dateFormat.format(dateCellValue);
//
//			}
//
//			else {
//				double cellValue = cell.getNumericCellValue();
//				value = new DecimalFormat("").format(cellValue).toString().replaceAll(",", "");
//				System.out.println(value);
//
//			} break;
//			
//		case BLANK:
//			break;
//		case BOOLEAN:
//			break;
//		case ERROR:
//			break;
//		case FORMULA:
//			break;
//		case _NONE:
//			break;
//		default:
//			break;
//		}
//
//		return value;
//
//	}

	public void frameById(String frameId) {

		driver.switchTo().frame(frameId);

	}

	public void frameByName(String frameName) {

		driver.switchTo().frame(frameName);

	}

	public void frameByWebElement(WebElement element) {

		driver.switchTo().frame(element);

	}

	public void frameByIndex(String frameId) {

		driver.switchTo().frame(frameId);

	}

	public int frameCount(String frameName) {

		List<WebElement> findElements = driver.findElements(By.tagName(frameName));
		int frameCount = findElements.size();
		return frameCount;

	}

	   public void returnFromFrame() {

		driver.switchTo().defaultContent();

	}
       public void writeCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		
		File file = new File("D:\\Eclipse\\eclipse-workspace\\MavenClass02\\Depfile\\MavenDay02Task.xlsx");
		FileInputStream iS = new FileInputStream(file);
		@SuppressWarnings("resource")
		Workbook wb = new XSSFWorkbook(iS);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream oS = new FileOutputStream(file);
		wb.write(oS);
	}	

    public void updateCellData(String sheetname, int rownum, int cellnum, String oldData, String newData ) throws IOException {
	
	File file = new File("D:\\Eclipse\\eclipse-workspace\\MavenClass02\\Depfile\\MavenDay02Task.xlsx");
	FileInputStream iS = new FileInputStream(file);
	@SuppressWarnings("resource")
	Workbook wb = new XSSFWorkbook(iS);
	Sheet sheet = wb.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String stringCellValue = cell.getStringCellValue();
	
	if (stringCellValue.equals(oldData)) { 
		
		cell.setCellValue(newData);
		} 
	FileOutputStream oS = new FileOutputStream(file);
	wb.write(oS);
}

    
public String readCellData(String sheetname, int rownum, int cellnum) throws IOException {
		
		String value = null ;
		
		File file = new File("D:\\Eclipse\\eclipse-workspace\\MavenClass02\\Depfile\\MavenDay02Task.xlsx");
		FileInputStream iS = new FileInputStream(file);
		@SuppressWarnings("resource")
		Workbook wb = new XSSFWorkbook(iS);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		
		CellType type = cell.getCellType();
		
		switch (type) {
		
		case STRING:
			
			value = cell.getStringCellValue();
			
			break;
			
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				value = dateFormat.format(dateCellValue);
			}else {
				
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				
				if (numericCellValue==round) {
					
					value = String.valueOf(round);
					
				} else {
					
					value = String.valueOf(numericCellValue);

				}
			}
			break;
			
		default:
			break;
		}
		return value;
	}

    
    public static String getProjectPath() {
		
    	String path = System.getProperty("user.dir");
        return path;
	}
    
    public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		
    	Properties properties = new Properties();
    	
    	properties.load(new FileInputStream(getProjectPath()+"\\config\\contactus.properties"));
    	
    	Object object = properties.get(key);
        String value = (String) object;
        
        return value;
	}
    
public void selectRoomType(String roomType) {
		
    	String[] v = roomType.split("/");
    	
    	for (String text : v) {
			
    		selectOptionbyText(null, text);
		}

	}

public byte[] screenShotCucumber() {
	
	TakesScreenshot screenShot = (TakesScreenshot) driver;
	byte[] byteScreenShot = screenShot.getScreenshotAs(OutputType.BYTES);
	return byteScreenShot;

}

@SuppressWarnings("unused")
public boolean isDisplayed(WebElement element) {
	boolean tOrF = element.isDisplayed();
return tOrF;
}

public boolean isEnabled(WebElement element) {
	boolean tOrF = element.isEnabled();
return tOrF;
}

	
}
