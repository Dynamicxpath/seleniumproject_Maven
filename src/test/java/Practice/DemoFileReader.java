package Practice;

import com.crm.autodesk.GenericLibraries.Jsonutility;

public class DemoFileReader {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Jsonutility jfu = new Jsonutility();
		String browser = jfu.readDATAFromJSON("browser");
		String url = jfu.readDATAFromJSON("url");
		String username= jfu.readDATAFromJSON("username");
		String password= jfu.readDATAFromJSON("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		

	}

}
