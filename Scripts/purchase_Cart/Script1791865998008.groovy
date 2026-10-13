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
import java.text.SimpleDateFormat as SimpleDateFormat

CustomKeywords.'common.ChromeClean.openChromeClean'()

WebUI.callTestCase(findTestCase('Test Cases/add_Cart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Catalog/btn_ShoppingCart'))

WebUI.waitForElementPresent(findTestObject('ShopingCart/txt_TitlePage'), 0)

WebUI.verifyElementPresent(findTestObject('ShopingCart/txt_ItemId', [('itemId') : GlobalVariable.G_ItemId]), 0)

WebUI.verifyElementPresent(findTestObject('ShopingCart/txt_ProductId', [('productId') : GlobalVariable.G_ProductId]), 0)

WebUI.click(findTestObject('ShopingCart/btn_ProceedtoCheckout'))

WebUI.waitForElementPresent(findTestObject('Checkout/txt_PaymentDetails'), 0)

WebUI.waitForElementPresent(findTestObject('Checkout/txt_BillingAddress'), 0)

WebUI.verifyElementPresent(findTestObject('Checkout/txt_PaymentDetails'), 0)

WebUI.verifyElementPresent(findTestObject('Checkout/txt_BillingAddress'), 0)

WebUI.click(findTestObject('Checkout/btn_Continue'))

WebUI.waitForElementPresent(findTestObject('OderConfirm/txt_ConfirmMessage'), 0)

WebUI.waitForElementPresent(findTestObject('OderConfirm/txt_BillingAddress'), 0)

WebUI.waitForElementPresent(findTestObject('OderConfirm/txt_ShippingAddress'), 0)

WebUI.verifyElementPresent(findTestObject('OderConfirm/txt_ConfirmMessage'), 0)

WebUI.verifyElementPresent(findTestObject('OderConfirm/txt_BillingAddress'), 0)

WebUI.verifyElementPresent(findTestObject('OderConfirm/txt_ShippingAddress'), 0)

WebUI.click(findTestObject('OderConfirm/btn_Confirm'))

WebUI.waitForElementPresent(findTestObject('OrderSuccess/txt_ThankYouMessage'), 10)

WebUI.verifyElementPresent(findTestObject('OrderSuccess/txt_BillingAddress'), 10)

WebUI.verifyElementPresent(findTestObject('OrderSuccess/txt_ShippingAddress'), 10)

// Order header contains today's date (UTC, same as the time shown on the order)
SimpleDateFormat dateFormat = new SimpleDateFormat('yyyy/MM/dd')

dateFormat.setTimeZone(TimeZone.getTimeZone('UTC'))

String today = dateFormat.format(new Date())

String orderHeader = WebUI.getText(findTestObject('OrderSuccess/txt_OrderHeader'))

WebUI.verifyMatch(orderHeader, ('.*' + today) + '.*', true, FailureHandling.CONTINUE_ON_FAILURE)

// Back to main menu
WebUI.click(findTestObject('OrderSuccess/lnk_ReturnToMainMenu'))

WebUI.verifyElementPresent(findTestObject('Catalog/txt_WelcomeText'), 10)

WebUI.closeBrowser()

