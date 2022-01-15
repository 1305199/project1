package Project;

public class LockFile {

	public static void main(String[] args) {
		
		// Create "main" folder if not present in current folder structure
		PerformOperations.createMyProjectFolderIfNotPresent("MY PROJECT");
		
		MenuList.printWelcomeScreen(" LockedMe.com:", "Nikita Patole");
		
		ControlOptions.handleWelcomeScreenInput();
	}

	
}