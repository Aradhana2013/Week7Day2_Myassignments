package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	public ChromeDriver driver;
	public String leadID;
	public String MleadID;
	public String pWindowHandle;
		
	
	@Given("Open the browser") 
	public void openBrowser() {
		driver = new ChromeDriver();
	}

	@And("Load the URL")
	public void loadURL() {
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
	}

	@And("Enter the username as {string}")
	public void enterUsername(String uName) {
		driver.findElement(By.id("username")).sendKeys(uName);
	}

	@And("Enter the password as {string}")
	public void enterPassword(String pWord) {
		driver.findElement(By.id("password")).sendKeys(pWord);
	}

	@When("Click Login button")
	public void clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Homepage should be displayed")
	public void verifyHomepage() {
		String title = driver.getTitle();
		if (title.contains("Leaftaps")) {
			System.out.println("Homepage is displayed");

		}
		else {
			System.out.println("Homepage is not displayed");
		}

	}

	@But("Error message should be displayed")
	public void verifyErrorMessage(){
		System.out.println("Error message is displayed");
	}

	@When("Click on CRMSFA link")
	public void clickCRMSFAlink(){
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

	@And("Click on Leads tab")
	public void clickLeadsTab(){
		driver.findElement(By.linkText("Leads")).click();
	}

	@And("Click on Create Leads tab")
	public void clickCreateLeadsTab(){
		driver.findElement(By.linkText("Create Lead")).click();
	}


	@Given("Enter Company Name as (.*)$")
	public void enterCompanyName(String cName){
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
	}


	@And("Enter firstName as (.*)$")
	public void enterFirstName(String fName){
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
	}

	@And("Enter lastName as (.*)$")
	public void enterLastName(String lName){
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
	}

	@And("Enter phone number as (.*)$")
	public void enterPhoneNumber(String pNo){
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNo);
	}

	@When("Click on Create Lead button")
	public void clickCreateLeadButton(){
		driver.findElement(By.name("submitButton")).click();
	}


	@Then("ViewLeads page should be displayed")
	public void verifyViewLeadsPage(){
		String viewLeadstitle = driver.getTitle();
		if (viewLeadstitle.contains("View Lead")) {
			System.out.println("ViewLeads page is displayed");

		}
		else {
			System.out.println("ViewLeads page is not displayed");
		}
	}

	@And("Close the browser")
	public void closeBrowser() {
		driver.quit();
	}

	@And("Click on Find Leads tab")
	public void clickFindLeadsTab() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@And("Click on Phone tab")
	public void clickPhoneTab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
	}

	@And("Enter search phone number as {string}")
	public void enterEditPhoneNumber(String phNo) {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNo);
	}

	@And("Click Find Leads button")
	public void clickFindLeadsButton() {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@And("Wait for sometime")
	public void waitForSometime() throws InterruptedException {
		Thread.sleep(4000);
	}

	@And("Click on first record from search results")
	public void clickFirstRecord() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Given("Click on edit button")
	public void clickEditButton() {
		driver.findElement(By.linkText("Edit")).click();
	}

	@When("Clear existing company name")
	public void clearExistingCompanyName() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();


	}

	@And("Enter new company name as {string}")
	public void enterNewCompanyName(String coName) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(coName);
	}

	@And("Click on submit button")
	public void clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify if Lead is editted")
	public void verifyLeadEditted() {
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("TCS")) {
			System.out.println("Lead is editted successfully");
		}
		else {
			System.out.println("Lead is not editted");
		}
	}

	@And("Capture the LeadId of the first search record")
	public void captureFirstLeadId() {
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	}

	@When("Click on Delete button")
	public void clickDeleteButton() {
		driver.findElement(By.linkText("Delete")).click();
	}

	@And("Click on Find Leads tab for delete verification")
	public void clickFindLeadsTabforDeleteCheck() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@And("Search using the same LeadId")
	public void searchDeletedLeadId() {
		
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}

	@Then("Verify if deleted lead does not show up")
	public void verifyIfLeadDeleted() throws InterruptedException {
		Thread.sleep(4000);
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Lead deleted successfully");
		} else {
			System.out.println("Lead is not deleted ");
		}
	}

	@And("Click on Merge Leads tab")
	public void clickMergeLeadTab() {
		driver.findElement(By.linkText("Merge Leads")).click();
		pWindowHandle = driver.getWindowHandle();
	}
	
	@And("Fetch leadid on From Lead field")
	public void fetchFromLeadFieldValue() {
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Subraja");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	@And("Capture the LeadId of the first search record in From Lead field") 
	public void captureLeadIdOfFromLeadField() {
		 MleadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		
	}
	
	@And("Click on first record from search results of From Lead field")
	public void clickOnFirstRecordFromLeadField(){
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//driver.switchTo().window(allhandles.get(0));
		driver.switchTo().window(pWindowHandle);
		
	}
	
	@And("Fetch leadid on To Lead field")
	public void fetchToLeadFieldValue() {
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> allWindows2 = driver.getWindowHandles();
		List<String> allhandles2 = new ArrayList<String>(allWindows2);
		driver.switchTo().window(allhandles2.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("hari");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	@And("Click on first record from search results of To Lead field")
	public void clickOnFirstRecordToLeadField() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		//driver.switchTo().window(allhandles2.get(0));
		driver.switchTo().window(pWindowHandle);
	}
	
	@And("Click on Merge button and handle the alert of the same")
	public void clickonMergeButtonAndAlertHandle() {
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		driver.switchTo().alert().accept();
	}
	
	@And("Search using the same Merge LeadId") 
	public void searchMergedLeadId(){
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(MleadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	}
	
	@Then("Verify if merged lead does not show up")
	public void verifyIfLeadsMerged() {
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		
	}	

}
