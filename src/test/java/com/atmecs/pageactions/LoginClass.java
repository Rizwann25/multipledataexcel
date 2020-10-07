package com.atmecs.pageactions;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.atmecs.constant.Constant;
import com.atmecs.helper.HelperClass;
import com.atmecs.reader.LoginDataProvider;
import com.atmecs.reader.PropertyReader;
import com.atmecs.testsuit.SetUp;

	public class LoginClass extends SetUp {

		Properties Location_path;

		@Test(dataProvider = "Login", dataProviderClass = LoginDataProvider.class)
		public void login(String username, String password) throws InterruptedException, IOException {
			Location_path=PropertyReader.readProperty(Constant.LOCATOR_PATH);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		    HelperClass.selectElementById(driver, Location_path.getProperty("LoginId"));
			HelperClass.ElementSelectorSendKeys(driver, Location_path.getProperty("Login_User"),username);
			HelperClass.ElementSendKeys(driver, Location_path.getProperty("Login_Password"),password);
			HelperClass.elementClick(driver, Location_path.getProperty("LoginButton"));

		}

	}
