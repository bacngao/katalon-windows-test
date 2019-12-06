import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.katalon.windows_test.keywords.WindowsEnhancedKeyword as WindowsEnhancedKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

'Open default project'
Windows.callTestCase(findTestCase('Common/Project/Verify can open project'), [:], FailureHandling.STOP_ON_FAILURE)

'Collapse all items on Tests Explorer'
Windows.click(findWindowsObject('Object Repository/Tests Explorer/Button_Collapse_All'))

'Double click on the Object Repository tree item'
Windows.doubleClick(findWindowsObject('Object Repository/Tests Explorer/TreeItem_Root_Object_Repository'))

'Verify the target object present'
WindowsEnhancedKeyword.verifyElementPresent(findWindowsObject('Object Repository/Tests Explorer/TreeItem_New_Test_Object'), 
    FailureHandling.STOP_ON_FAILURE)

'Send CTRL + C keys to copy object'
Windows.sendKeys(findWindowsObject('Object Repository/Tests Explorer/TreeItem_New_Test_Object'), Keys.chord(Keys.CONTROL + "C").toString())

'Send CTRL + V keys at parent folder to paste the target object'
Windows.sendKeys(findWindowsObject('Object Repository/Tests Explorer/TreeItem_Root_Object_Repository'),
	Keys.chord(Keys.CONTROL + "V").toString())

'Wait for KS to complete the paste action'
Windows.delay(2)

'Verify the clone object present on Tests Explorer'
WindowsEnhancedKeyword.verifyElementPresent(findWindowsObject('Object Repository/Tests Explorer/Artifacts/Object Repository/TreeItem_Test_Object_Copy'), 
    FailureHandling.STOP_ON_FAILURE)