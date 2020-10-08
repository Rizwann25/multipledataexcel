package com.atmecs.pageactions;

import java.util.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.atmecs.constant.Constant;
import com.atmecs.helper.HelperClass;
import com.atmecs.reader.PropertyReader;
import com.atmecs.reader.SignInDataProvider;
import com.atmecs.testsuit.SetUp;


	public class SignUpClass extends SetUp {

		Properties Location_path;

		@Test(dataProvider = "SignIn", dataProviderClass = SignInDataProvider.class)
		public void SignUp(String username, String password) throws InterruptedException {

			Location_path = PropertyReader.readProperty(Constant.LOCATOR_PATH);

			HelperClass.selectElementById(driver, Location_path.getProperty("SignIn_Id"));
			HelperClass.ElementSelectorSendKeys(driver, Location_path.getProperty("Signup_Username"), username);
			HelperClass.ElementSendKeys(driver, Location_path.getProperty("Signup_Password"), password);
			HelperClass.elementClick(driver, Location_path.getProperty("ButtonXpath"));
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();

		}

}
