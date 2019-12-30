package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_002_LoginDDTest extends BaseClass
{
    @Test(dataProvider= "LoginData")
    public void loginDDTest(String user, String pwd) throws InterruptedException, IOException
    {
    	LoginPage lp = new LoginPage(driver);
    	lp.clickLogin();
    	Thread.sleep(3000);
    	lp.setUserName(user);
    	lp.setPasword(pwd);
    	lp.clickSubmit();
    	
    	
    	if (driver.getTitle().equals("nopCommerce demo store")) {
			lp.clickLogout();
			Assert.assertTrue(true);
			logger.info("Login test passed");
			try {
				captureScreen(driver,"loginDDTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		} else {
			captureScreen(driver,"loginDDTest");
			logger.info("Login Failed");//logger msg
			Assert.assertTrue(false);
		}
    }

    @DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
		
}
    

