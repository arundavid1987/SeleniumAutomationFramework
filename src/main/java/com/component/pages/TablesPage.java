package com.component.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablesPage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait waittime;

	public TablesPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		waittime = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public TablesPage initElements() {
		return PageFactory.initElements(this.driver, TablesPage.class);
	}

	@FindBy(id = "shopping")
	private WebElement tableOne;

	@FindBy(xpath = "//label[contains(.,\"Let's handle it\")]")
	private WebElement tableTwoLabel;
	
	@FindBy(id = "simpletable")
	private WebElement tableTwo;
	
	@FindBy(xpath = "//label[contains(.,\"Sortable Tables\")]")
	private WebElement tableThreeLabel;

	@FindBy(css = ".mat-sort.table.is-bordered.is-striped.is-narrow.is-hoverable.is-fullwidth")
	private WebElement tableThree;
	
	public void highlight(WebElement element) throws Exception{
		waittime.until(ExpectedConditions.visibilityOf(element));
		for (int i = 0; i < 2; i++)
		{

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 3px solid red;");

			Thread.sleep(500);

			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			Thread.sleep(500);

		}
	}

	public boolean checkSumColumn(String columnName) throws Exception {
		int expectedSum = 0;
		int rowNo = 0, columnNo = 0, expectedColumnNo = 0;
		waittime.until(ExpectedConditions.visibilityOf(tableOne));
		Thread.sleep(2000);
		highlight(tableOne);
		Thread.sleep(2000);
		List<WebElement> tableRows = tableOne.findElements(By.tagName("tr"));
		rowNo = tableRows.size();
		System.out.println("Number of Rows inside table:" + rowNo);
		List<WebElement> tableColumns = tableRows.get(0).findElements(By.tagName("th"));
		columnNo = tableColumns.size();
		System.out.println("Number of Columns inside table:" + columnNo);

		for (int i = 0; i < columnNo; i++) {
			if (columnName.equals(tableColumns.get(i).getText())) {
				expectedColumnNo = i;
				System.out.println("Expected Column Number:" + (expectedColumnNo + 1));
			}
		}
		highlight(tableColumns.get(expectedColumnNo));
		Thread.sleep(2000);
		for (int j = 1; j < rowNo; j++) {
			expectedSum = expectedSum
					+ Integer.parseInt(tableRows.get(j).findElements(By.tagName("td")).get(expectedColumnNo).getText());
		}
		System.out.println("Expected Sum:" + expectedSum);

		WebElement tableFooter = tableOne.findElement(By.tagName("tfoot"));
		WebElement footerColumn = tableFooter.findElements(By.tagName("td")).get(expectedColumnNo);
		int actualSum = Integer.parseInt(footerColumn.findElement(By.tagName("b")).getText());
		System.out.println("Actual Sum:" + actualSum);
		if (expectedSum == actualSum)
			return true;
		else
			return false;
	}

	public int relativeCellClick(String relativeData) throws Exception {
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", tableTwoLabel);
		Thread.sleep(2000);
		highlight(tableTwo);
		Thread.sleep(2000);
		int rowNo = -1, srcColNo, destColNo, i;
		String cellData;
		List<WebElement> allRows, rowColumns;
		try {
			String[] cellParams = relativeData.split(";");
			if (cellParams.length == 3) {
				srcColNo = Integer.parseInt(cellParams[0]) - 1;
				// System.out.println("Column Number:" + srcColNo);
				String relativeSearchText = cellParams[1];
				destColNo = Integer.parseInt(cellParams[2]) - 1;
				if (tableTwo != null) {
					waittime.until(ExpectedConditions.visibilityOf(tableTwo));
					allRows = tableTwo.findElements(By.tagName("tr"));
					System.out.println("Number of Rows in Table:" + allRows.size());
					for (i = 0; i < allRows.size(); i++) {
						rowColumns = allRows.get(i).findElements(By.xpath("./th | ./td"));
						if (rowColumns.size() < srcColNo) {
							throw new Exception("Invalid Column Number:" + srcColNo + ", Number of Columns Present:"
									+ rowColumns.size());
						} else {
							cellData = rowColumns.get(srcColNo).getText();
							System.out.println(cellData);
							if (cellData.equals(relativeSearchText)) {
								System.out.println("Match Found:" + cellData);
								rowNo = i;
								highlight(allRows.get(rowNo));
								Thread.sleep(2000);
								js.executeScript("arguments[0].click();",
										rowColumns.get(destColNo).findElement(By.xpath(".//*")));
								System.out.println("Cell content clicked");
								break;
							}
						}
					}

				} else {
					throw new Exception("Table Not Found:" + tableTwo);
				}
			} else {
				throw new Exception(
						"Invalid Number of Arguments Provided,Pls provide Source Column, Search Text and Destination Column");
			}
		} catch (StaleElementReferenceException e) {
			throw new Exception("Stale Element Reference:" + tableTwo);
		} catch (NoSuchElementException e) {
			throw new Exception("Element Not Found:" + tableTwo);
		} catch (TimeoutException e) {
			throw new Exception("Element Not Visible:" + tableTwo);
		} catch (NumberFormatException e) {
			throw new Exception("Invalid Argument, Expected Column No");
		}
		return rowNo;
	}

	public boolean checkSorting(String columnName) throws Exception {
		int rowNo = 0, columnNo = 0, expectedColumnNo = 0;
		boolean ascendingOrder, descendingOrder;
		waittime.until(ExpectedConditions.visibilityOf(tableThree));
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", tableThreeLabel);
		Thread.sleep(2000);
		highlight(tableThree);
		WebElement tableHeader = tableThree.findElement(By.tagName("thead"));
		List<WebElement> tableColumns = tableHeader.findElements(By.tagName("th"));
		columnNo = tableColumns.size();
		System.out.println("Number of Columns inside table:" + columnNo);

		for (int i = 0; i < columnNo; i++) {
			if (tableColumns.get(i).getText().equals(columnName)) {
				expectedColumnNo = i;
				System.out.println("Expected Column Number:" + (expectedColumnNo + 1));
			}
		}
		
		highlight(tableColumns.get(expectedColumnNo));
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click();",tableColumns.get(expectedColumnNo));
		System.out.println("Verifying Ascending Order");

		List<WebElement> tableRows = tableThree.findElements(By.tagName("tr"));
		rowNo = tableRows.size();
		
		ArrayList<String> columnValuesList = new ArrayList<>();
		for (int j = 0; j < rowNo; j++) {
			columnValuesList.add(tableRows.get(j).findElements(By.tagName("td")).get(expectedColumnNo).getText());
			System.out.println(tableRows.get(j).findElements(By.tagName("td")).get(expectedColumnNo).getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : columnValuesList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);

		if (sortedList.equals(columnValuesList)) {
			System.out.println("Ascending Order Verifed");
			ascendingOrder=true;
		} else
			return false;
		
		columnValuesList.clear();
		sortedList.clear();
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",tableColumns.get(expectedColumnNo));
		System.out.println("Verifying Descending Order");
		
		tableRows = tableThree.findElements(By.tagName("tr"));
		for (int j = 0; j < rowNo; j++) {
			columnValuesList.add(tableRows.get(j).findElements(By.tagName("td")).get(expectedColumnNo).getText());
			System.out.println(tableRows.get(j).findElements(By.tagName("td")).get(expectedColumnNo).getText());
		}
		
		for (String s : columnValuesList) {
			sortedList.add(s);
		}
		
		Collections.sort(sortedList);
		
		Collections.reverse(sortedList);
				
		if (sortedList.equals(columnValuesList)) {
			System.out.println("Descending Order Verifed");
			descendingOrder=true;
		} else
			return false;
		
		if(ascendingOrder && descendingOrder)
			return true;
		else 
			return false;
	}

}
