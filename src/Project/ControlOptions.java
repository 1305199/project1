package Project;

import java.util.List;
import java.util.Scanner;

public class ControlOptions {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuList.displayMenuList();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					PerformOperations.displayAllFiles("MyProject");
					break;
				case 2:
					ControlOptions.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuList.displayFileMenuOptions();
				PerformOperations.createMyProjectFolderIfNotPresent("MyProject");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// This case is use to a add file
					System.out.println("Enter the name of the file to be added to the \"MyProject\" folder");
					String fileToAdd = sc.next();
					
					PerformOperations.createFile(fileToAdd, sc);
					
					break;
				case 2:
					//This case is use to delete a file 
					System.out.println("Enter the name of the file to be deleted from \"MyProject\" folder");
					String fileToDelete = sc.next();
					
					PerformOperations.createMyProjectFolderIfNotPresent("MyProject");
					List<String> filesToDelete = PerformOperations.displayFileLocations(fileToDelete, "MyProject");
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
							System.out.println(deletionPrompt);
							
									int index = sc.nextInt();

									if (index != 0) {
								       PerformOperations.deleteFileRecursively(filesToDelete.get(index - 1));
									} else {

									// If index == 0, delete all files displayed for the name
									for (String path : filesToDelete) {
										PerformOperations .deleteFileRecursively(path);
									}
									}
							
					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"MyProject\" folder");
					String fileName = sc.next();
					
					PerformOperations.createMyProjectFolderIfNotPresent("MyProject");
					PerformOperations.displayFileLocations(fileName, "Myproject");
				
					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}