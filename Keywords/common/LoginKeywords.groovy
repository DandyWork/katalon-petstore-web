package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class LoginKeywords {
	@Keyword
	def login(String username = GlobalVariable.G_Username, String password = GlobalVariable.G_Password) {
		WebUI.navigateToUrl(GlobalVariable.G_BaseUrl)

		WebUI.waitForElementPresent(findTestObject('Catalog/btn_SignIn'), 0)
		WebUI.verifyElementPresent(findTestObject('Catalog/btn_SignIn'), 0)
		WebUI.click(findTestObject('Catalog/btn_SignIn'))

		WebUI.waitForElementPresent(findTestObject('SignIn/txt_TitlePage'), 0)
		WebUI.verifyElementPresent(findTestObject('SignIn/txt_TitlePage'), 0)
		WebUI.verifyElementPresent(findTestObject('SignIn/txt_UserAndPass'), 0)

		WebUI.setText(findTestObject('SignIn/input_Username'), username)
		WebUI.setText(findTestObject('SignIn/input_Password'), password)
		WebUI.click(findTestObject('SignIn/btn_Login'))

		WebUI.waitForElementPresent(findTestObject('Catalog/txt_WelcomeText'), 0)
		WebUI.verifyElementPresent(findTestObject('Catalog/txt_WelcomeText'), 0)
	}
}
