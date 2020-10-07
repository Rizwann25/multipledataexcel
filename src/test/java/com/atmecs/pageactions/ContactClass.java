package com.atmecs.pageactions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.atmecs.constant.Constant;
import com.atmecs.helper.HelperClass;
import com.atmecs.reader.ContactDataProvider;
import com.atmecs.reader.PropertyReader;
import com.atmecs.testsuit.SetUp;

	public class ContactClass extends SetUp {
		Properties Location_path;
		@Test(dataProvider = "Contact", dataProviderClass = ContactDataProvider.class)

		public void contact(String mail,String name,String message) throws InterruptedException {
			Location_path=PropertyReader.readProperty(Constant.LOCATOR_PATH);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			HelperClass.elementClick(driver, Location_path.getProperty("ContactLink"));
			HelperClass.ElementSelectorSendKeys(driver, Location_path.getProperty("Recipient_Email"), mail);
			HelperClass.ElementSelectorSendKeys(driver, Location_path.getProperty("Recipient_name"),name);
			HelperClass.sendKeyById(driver, Location_path.getProperty("Messageid"),message);

			HelperClass.elementClick(driver, Location_path.getProperty("SendMessage"));

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			

		}
}
