import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'common.ChromeClean.openChromeClean'()

WebUI.navigateToUrl(GlobalVariable.G_BaseUrl)

WebUI.waitForElementPresent(findTestObject('Catalog/btn_SignIn'), 10)
WebUI.verifyElementPresent(findTestObject('Catalog/btn_SignIn'), 10)
WebUI.click(findTestObject('Catalog/btn_SignIn'))

WebUI.waitForElementPresent(findTestObject('SignIn/txt_TitlePage'), 10)
WebUI.verifyElementPresent(findTestObject('SignIn/txt_TitlePage'), 10)
WebUI.verifyElementPresent(findTestObject('SignIn/txt_UserAndPass'), 10)

WebUI.setText(findTestObject('SignIn/input_Username'), username)
WebUI.setText(findTestObject('SignIn/input_Password'), password)
WebUI.click(findTestObject('SignIn/btn_Login'))

if (expected == 'success') {
	WebUI.waitForElementPresent(findTestObject('Catalog/txt_WelcomeText'), 10)
	WebUI.verifyElementPresent(findTestObject('Catalog/txt_WelcomeText'), 10)

} else if (expected == 'invalid') {
	WebUI.waitForElementPresent(findTestObject('SignIn/txt_invalidLogin'), 10)
	WebUI.verifyElementPresent(findTestObject('SignIn/txt_invalidLogin'), 10)
	WebUI.verifyElementNotPresent(findTestObject('Catalog/txt_WelcomeText'), 3)

} else if (expected == 'empty') {
	// page reloads with no message: still on the sign in page and not logged in
	WebUI.verifyElementPresent(findTestObject('SignIn/txt_TitlePage'), 10)
	WebUI.verifyElementPresent(findTestObject('SignIn/btn_Login'), 10)
	WebUI.verifyElementNotPresent(findTestObject('SignIn/txt_invalidLogin'), 3)
	WebUI.verifyElementNotPresent(findTestObject('Catalog/txt_WelcomeText'), 3)
}

WebUI.closeBrowser()

