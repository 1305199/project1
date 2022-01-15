package Project;

public class MenuList {

	public static void printWelcomeScreen(String appName, String developerName) {
		String companyDetails = """
				=======================================================
				******************************************************
				WELCOME TO %S
				******************************************************
				DEVELOPED BY %S
				========================================================""";
		companyDetails=String.format(companyDetails,appName, developerName);
		System.out.println(companyDetails);
	}

	public static void displayMenuList() {
		String menu = """
				1.Retrieve File
				2.Perform Operation On File.
				3.Exit.
				""";
				
		System.out.println(menu);

	}

	public static void displayFileMenuOptions() {
		String fileMenu=	 """
		===============================================
		1.Add File.
		2.Delete File.
		3.Search File.
		4.Exit.
		=========PLEASE ENTER YOUR CHOICE========
		""";
		
		System.out.println(fileMenu);
	}

}
