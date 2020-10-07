package com.atmecs.reader;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import com.atmecs.constant.Constant;

	public class ContactDataProvider {


		  @DataProvider(name="Contact")
		   public static Object[][] getData() throws IOException
		   {
				XlsReader xls=new XlsReader(Constant.CONTACT_DATA_PATH);
				Object[][] data=xls.readExcelData("ContactSheet");
				return data;
				
		   }
		}
