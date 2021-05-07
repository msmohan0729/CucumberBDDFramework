package com.petstore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class TestUtil extends TestBase {

	public static int PAGE_LOAD_TIMEOUT = 20;
	public static int IMPLICIT_WAIT = 20;

	public String userName;
	public String password;
	public String firstName;
	public String lastName;
	public String email;
	public long phoneNumber;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public long zipCode;
	public String country;
	public String languagePreferred;
	public String favouriteCategory;

	public TestUtil() throws IOException {
		FileInputStream fis = new FileInputStream(new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\petstore\\testdata\\controller.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		userName = sheet.getRow(1).getCell(0).getStringCellValue();
		password = sheet.getRow(1).getCell(1).getStringCellValue();
		firstName = sheet.getRow(1).getCell(2).getStringCellValue();
		lastName = sheet.getRow(1).getCell(3).getStringCellValue();
		email = sheet.getRow(1).getCell(4).getStringCellValue();
		phoneNumber = (long) sheet.getRow(1).getCell(5).getNumericCellValue();
		address1 = sheet.getRow(1).getCell(6).getStringCellValue();
		address2 = sheet.getRow(1).getCell(7).getStringCellValue();
		city = sheet.getRow(1).getCell(8).getStringCellValue();
		state = sheet.getRow(1).getCell(9).getStringCellValue();
		zipCode = (long) sheet.getRow(1).getCell(10).getNumericCellValue();
		country = sheet.getRow(1).getCell(11).getStringCellValue();
		languagePreferred = sheet.getRow(1).getCell(12).getStringCellValue();
		languagePreferred = languagePreferred.toLowerCase();
		favouriteCategory = sheet.getRow(1).getCell(13).getStringCellValue();
		favouriteCategory = favouriteCategory.toUpperCase();
	}

	public static void clickButton(WebElement button) {
		WebElement element = button;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}



}
