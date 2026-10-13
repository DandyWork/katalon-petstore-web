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

CustomKeywords.'common.LoginKeywords.login'()

WebUI.click(findTestObject('Catalog/txt_Fish'))

WebUI.waitForElementPresent(findTestObject('Fish/header_ProductId'), 0)

WebUI.verifyElementPresent(findTestObject('Fish/header_ProductId'), 0)

WebUI.click(findTestObject('Fish/txt_ProductFish1', [('productId') : GlobalVariable.G_ProductId]))

WebUI.waitForElementPresent(findTestObject('Fish/AngelFish/txt_ProductTitle'), 0)

WebUI.verifyElementPresent(findTestObject('Fish/AngelFish/txt_Item01', [('itemId') : GlobalVariable.G_ItemId]), 0)

WebUI.click(findTestObject('Fish/AngelFish/txt_Item01', [('itemId') : GlobalVariable.G_ItemId]))

WebUI.waitForElementPresent(findTestObject('Fish/AngelFish/Details/txt_ItemId', [('itemId') : GlobalVariable.G_ItemId]), 
    0)

WebUI.verifyElementPresent(findTestObject('Fish/AngelFish/Details/txt_ItemId', [('itemId') : GlobalVariable.G_ItemId]), 0)

WebUI.click(findTestObject('Fish/AngelFish/Details/btn_AddtoCart'))

WebUI.waitForElementPresent(findTestObject('ShopingCart/txt_ItemId', [('itemId') : GlobalVariable.G_ItemId]), 0)

WebUI.waitForElementPresent(findTestObject('ShopingCart/txt_ProductId', [('productId') : GlobalVariable.G_ProductId]), 0)

WebUI.verifyElementPresent(findTestObject('ShopingCart/txt_ItemId', [('itemId') : GlobalVariable.G_ItemId]), 0)

WebUI.verifyElementPresent(findTestObject('ShopingCart/txt_ProductId', [('productId') : GlobalVariable.G_ProductId]), 0)

WebUI.click(findTestObject('Catalog/img_Logo'))

