package testNG_Prac;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EXample_dataProvider {

	@Test(dataProvider = "loginData")
	public void VerifyLogin(String UserName, String Password) {
		System.out.println(UserName);
		System.out.println(Password);

	}

	@DataProvider
	public Object[][] loginData() {
		Object[][] data = new Object[4][2];
		// 1stset of data
		data[0][0] = "Suresh";
		data[0][1] = "Suresh@1234";
		// 2nd set of data
		data[1][0] = "Ramesh";
		data[1][1] = "Ramesh@1234";
		// 3rd set of data
		data[2][0] = "kishore";
		data[2][1] = "kishore@1234";
		// 4th set of data
		data[3][0] = "Mallesh";
		data[3][1] = "Mallesh@1234";
		return data;
	}

	@Test(dataProvider = "registerData")
	public void VerifyRegisterAccount(String firstName, String LastName, Long Phno, String Email) {
		System.out.println(firstName);
		System.out.println(LastName);
		System.out.println(Phno);
		System.out.println(Email);
	}

	@DataProvider
	public Object[][] registerData() {
		Object[][] data = new Object[5][4];
		data[0][0] = "Suresh";
		data[0][1] = "poreddy";
		data[0][2] = 9849434480l;
		data[0][3] = "Suresg@gmial.com";

		data[1][0] = "Ramesh";
		data[1][1] = "potti";
		data[1][2] = 9848022338l;
		data[1][3] = "Rmaesh@gmail.com";

		data[2][0] = "milika";
		data[2][1] = "gangireddy";
		data[2][2] = 720738508l;
		data[2][3] = "milika@gmail.com";

		data[3][0] = "kishore";
		data[3][1] = "padigepati";
		data[3][2] = 9848934580l;
		data[3][3] = "kishore@gmail.com";

		data[4][0] = "sunitha";
		data[4][1] = "padigi";
		data[4][2] = 9701446092l;
		data[4][3] = "Sunitha2Gmail.com";
		return data;

	}

}
