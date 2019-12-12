import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.katalon.windows_test.artifacts.ProjectsKeyword
import com.katalon.windows_test.artifacts.TestCasesKeyword
import com.katalon.windows_test.components.MainContentKeyword
import com.katalon.windows_test.components.MainWindowKeyword
import com.katalon.windows_test.components.MenubarKeyword
import com.katalon.windows_test.components.TestsExplorerKeyword
import com.katalon.windows_test.keywords.WindowsEnhancedKeyword
import com.katalon.windows_test.util.NamingKeyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement


/**
 * [Script]
 *
 * 1. Open `Katalon Studio` and wait for project to load
 * 2. Create a sample test case
 * 3. Copy the sample test case by using shortcut key [Ctrl + C]
 * 4. Paste the copied test case at the same folder by using shortcut key [Ctrl + V]
 * 5. Verify the cloned test case is appeared (Name: "<sample test case name> - Copy")
 * 6. Delete both sample & cloned test case
 * 7. Close Katalon Studio
 */

String sampleTestCaseName = NamingKeyword.generateTestCaseName()
String clonedTestCaseName = sampleTestCaseName + ' - Copy'

if (!GlobalVariable.G_runTestCasesContinuously) {
	Windows.comment('1. Open `Katalon Studio` and wait for project to load')
	Windows.startApplication(GlobalVariable.G_appPath)
	ProjectsKeyword.waitForProjectLoad()
}

Windows.comment('2. Create a sample test case')
TestCasesKeyword.createTestCaseUsingFileMenu(sampleTestCaseName)

Windows.comment('3. Copy the sample test case by using shortcut key [Ctrl + C]')
WebElement sampleTestCase = TestsExplorerKeyword.findTreeItem(sampleTestCaseName)
sampleTestCase.click()
WindowsEnhancedKeyword.pressKey(Keys.chord(Keys.CONTROL, 'c'))

Windows.comment('4. Paste the copied test case by using shortcut key [Ctrl + V]')
WindowsEnhancedKeyword.pressKey(Keys.chord(Keys.CONTROL, 'v'))

Windows.comment('5. Verify the cloned test case is appeared (Name: "<sample test case name> - Copy")')
WebElement clonedTestCase = TestsExplorerKeyword.findTreeItem(clonedTestCaseName)
WindowsEnhancedKeyword.verifyElementPresent(clonedTestCase, FailureHandling.STOP_ON_FAILURE)

Windows.comment('6. Delete both sample and cloned test case')
TestsExplorerKeyword.deleteTreeItem(clonedTestCaseName)
TestsExplorerKeyword.deleteTreeItem(sampleTestCaseName)

if (!GlobalVariable.G_runTestCasesContinuously) {
	Windows.comment('7. Close Katalon Studio')
	MainWindowKeyword.close()
}


