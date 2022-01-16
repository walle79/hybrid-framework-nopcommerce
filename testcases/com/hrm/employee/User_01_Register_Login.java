package com.hrm.employee;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.PageGenerator;
import pageObjects.hrm.MyInfoPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login extends BaseTest {
	WebDriver driver;
	String employeeID;
	String statusValue, editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNationality;
	String adminUsername, adminPassword, empFirstName, empLastName, empFullName, empUsername, empPassword;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		loginPO = PageGenerator.getLoginPage(driver);
		statusValue = "Enabled";
		adminUsername = "Admin";
		adminPassword = "admin123";
		empFirstName = "hong";
		empLastName = "son";
		empFullName = empFirstName + " " + empLastName;
		empUsername = "hongson95";
		empPassword = "iloveyou79";
		
		// Edit value
		editEmpFirstName = "John";
		editEmpLastName = "Wick";
		editEmpGender = "Male";
		editEmpMaritalStatus = "Single";
		editEmpNationality = "Vietnamese";
		// Login with Admin Role
		dashboardPO = loginPO.loginToSystem(driver, adminUsername, adminPassword);
	}

	@Test
	public void Employee_01_Add_New_Employee() {
		// Open 'Employee List' Page
		dashboardPO.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPO = PageGenerator.getEmployeeListPage(driver);

		// Click to 'Add' btn => Open 'Add Employee' Page
		employeeListPO.clickToBtnByID(driver, "btnAdd");
		addEmployeePO = PageGenerator.getAddEmployeePage(driver);

		// Enter to First Name txtbox
		addEmployeePO.enterToTextboxByID(driver, "firstName", empFirstName);

		// Enter to Last Name txtbox
		addEmployeePO.enterToTextboxByID(driver, "lastName", empLastName);

		// Get EmployeeID
		employeeID = addEmployeePO.getTextboxValueByID(driver, "employeeId");

		// Click To 'Create Login Details' checkbox
		addEmployeePO.clickToCheckboxByLabel(driver, "Create Login Details");

		// Enter to Username txtbox
		addEmployeePO.enterToTextboxByID(driver, "user_name", empUsername);

		// Enter to Password txtbox
		addEmployeePO.enterToTextboxByID(driver, "user_password", empPassword);

		// Enter to Confirm Password txtbox
		addEmployeePO.enterToTextboxByID(driver, "re_password", empPassword);
		
		// Select statusValue in Status Dropdown
		addEmployeePO.selectItemInDropdownByID(driver, "status", statusValue);
		
		// Click Save Btn => Open 'Personal Details' Page
		addEmployeePO.clickToBtnByID(driver, "btnSave");
		myInfoPO = PageGenerator.getMyInfoPage(driver);
		
		// Open 'Employee List' Page
		myInfoPO.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPO = PageGenerator.getEmployeeListPage(driver);
		Assert.assertTrue(employeeListPO.isJQueryAjaxLoadedSuccess(driver));
		
		// Enter to Employee Name txtbox
		employeeListPO.enterToTextboxByID(driver, "empsearch_employee_name_empName", empFullName);
		
		// Click to Search Btn
		employeeListPO.clickToBtnByID(driver, "searchBtn");
		Assert.assertTrue(employeeListPO.isJQueryAjaxLoadedSuccess(driver));
		
		// Verify Employee Information in Result Table
		Assert.assertEquals(employeeListPO.getValueDisplayedInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (& Middle) Name", "1"), empFirstName);
		Assert.assertEquals(employeeListPO.getValueDisplayedInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		Assert.assertEquals(employeeListPO.getValueDisplayedInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), empLastName);
	}

	@Test
	public void Employee_02_Upload_Avatar() {
		loginPO = employeeListPO.logoutToSystem(driver);
		// Login with Employee Role
		dashboardPO = loginPO.loginToSystem(driver, empUsername, empPassword);
		
		// Open 'Personal Detail' Page
		dashboardPO.openMenuPage(driver, "My Info");
		myInfoPO = PageGenerator.getMyInfoPage(driver);
	}

	@Test
	public void Employee_03_Personal_Details() {
		// Open 'Personal Details' tab at sidebar
		myInfoPO.openTabAtSidebarByName("Personal Details");
		
		// Verify all fields are disabled
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtEmpFirstName"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtEmpLastName"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtEmployeeId"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtLicenNo"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtNICNo"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtSINNo"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_optGender_1"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_optGender_2"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_cmbMarital"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_cmbNation"));
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_DOB"));
		
		// Click to Edit button at Personal Details form
		myInfoPO.clickToBtnByID(driver, "btnSave");
		
		// Verify 'Employee Id' textbox is disabled
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtEmployeeId"));

		// Verify 'Driver's License Number' textbox is disabled
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtLicenNo"));

		// Verify 'SSN Number' textbox is disabled
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtNICNo"));

		// Verify 'SIN Number' textbox is disabled
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_txtSINNo"));

		// Verify 'Date of birth' textbox is disabled
		Assert.assertFalse(myInfoPO.isFieldEnabledByID(driver, "personal_DOB"));

		// Enter new value to 'First Name' textbox
		myInfoPO.enterToTextboxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);
		
		// Enter new value to 'Last Name' textbox
		myInfoPO.enterToTextboxByID(driver, "personal_txtEmpLastName", editEmpLastName);
		
		// Select new value to 'Gender' radio button
		myInfoPO.clickToRadioByLabel(driver, editEmpGender);
		
		// Select new value to 'Marital Status' dropdown
		myInfoPO.selectItemInDropdownByID(driver, "personal_cmbMarital", editEmpMaritalStatus);
		
		// Select new value to 'Nationality' dropdown
		myInfoPO.selectItemInDropdownByID(driver, "personal_cmbNation", editEmpNationality);
		
		// Click to Save button at Personal Details form
		myInfoPO.clickToBtnByID(driver, "btnSave");
		
		// Verify success message is displayed
		//Assert.assertTrue(myInfoPO.isSuccessMessageDisplayed(driver, "Successfully Saved"));
		//myInfoPO.sleepInSecond(5);
		
		// Verify 'First Name' textbox is updated
		Assert.assertEquals(myInfoPO.getTextboxValueByID(driver, "personal_txtEmpFirstName"), editEmpFirstName);
		
		// Verify 'Last Name' textbox is updated
		Assert.assertEquals(myInfoPO.getTextboxValueByID(driver, "personal_txtEmpLastName"), editEmpLastName);

		// Verify 'Gender' value is updated
		Assert.assertTrue(myInfoPO.isRadioBtnSelectedByLabel(driver, editEmpGender));

		// Verify 'Martial Status' value is updated
		Assert.assertEquals(myInfoPO.getTextboxValueByID(driver, "personal_cmbMarital"), editEmpMaritalStatus);

		// Verify 'Nationality' value is updated
		Assert.assertEquals(myInfoPO.getTextboxValueByID(driver, "personal_cmbNation"), editEmpNationality);

	}

	@Test
	public void Employee_04_Contact_Details() {

	}

	@Test
	public void Employee_05_Emergency_Details() {

	}

	@Test
	public void Employee_06_Assigned_Dependents() {

	}

	@Test
	public void Employee_07_Edit_View_Job() {

	}

	@Test
	public void Employee_08_Edit_View_Salary() {

	}

	@Test
	public void Employee_09_Edit_View_Tax() {

	}

	@Test
	public void Employee_10_Qualifications() {

	}

	@Test
	public void Employee_11_Search_Employee() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	public String getRandomEmail() {
		Random random = new Random();
		return "testing" + random.nextInt(99999) + "@gmail.com";
	}

	LoginPO loginPO;
	EmployeeListPO employeeListPO;
	DashboardPO dashboardPO;
	MyInfoPO myInfoPO;
	AddEmployeePO addEmployeePO;

}
