import java.io.*;
import java.util.*;

public class Menu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int option;
			int suboption;
			String path;
			System.out.println("Application Developer : Kiran Konduri");
			System.out.println("File menu Related Application");

			do {
				System.out.println("Choose your option");
				System.out.println("1 - Display the current File Name");
				System.out.println("2 - Display the user interface");
				System.out.println("3 - Exit");
				path = "E:\\Simplelearn\\notes"; // sc.next();
				option = sc.nextInt();
				switch (option) {
				case 1:
					// The first option should return the current file names in ascending order. The
					// root directory can be either empty or contain few files or folders in it

					// path as input--->It should display all the files in the specified directory

					File maindir = new File(path);

					// Get all the names of the files present
					// in the given directory
					if (maindir.exists() && maindir.isDirectory()) {
						// array for files and sub-directories
						// of directory pointed by maindir
						File arr[] = maindir.listFiles();

						System.out.println("**********************************************");
						System.out.println("Files from main directory : " + maindir);
						System.out.println("**********************************************");

						// Calling recursive method
						RecursivePrint(arr, 0);
					}
					break;
				case 2:
					boolean loop = true;
					while (loop) {
						System.out.println("You are in Case 2");
						System.out.println("Choose the operation to do ....");
						System.out.println("4 - Add File");
						System.out.println("5 - Delete File");
						System.out.println("6 - Serch File");
						System.out.println("7 - Back to main menu");
						suboption = sc.nextInt();
						switch (suboption) {
						case 4:
							// 1.Add a file to the existing directory list
							System.out.println("Enter the the file Name to be added ");
							String aFileName=sc.next();
							File file = new File(path + "\\" + aFileName); // initialize File object and passing
																				// path as argument
							boolean result;
							try {
								result = file.createNewFile(); // creates a new file
								if (result) // test if successfully created a new file
								{
									System.out.println("file created " + file.getCanonicalPath()); // returns the path
																									// string
								} else {
									System.out.println("File already exist at location: " + file.getCanonicalPath());
								}
							} catch (IOException e) {
								e.printStackTrace(); // prints exception if any
							}
							break;
						case 5:
							// 2.Delete a user specified file from the existing directory list
							try {
								System.out.println("Enter the the file Name to be Deleted ");
								String dFileName=sc.next();
								File f = new File(path + "\\" + dFileName); // file to be delete
								if (f.delete()) // returns Boolean value
								{
									System.out.println(f.getName() + " deleted"); // getting and printing the file name
								} else {
									System.out.println("failed");
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						case 6:
							// 3.Search a user specified file from the main directory
					        // Create an object of the File class
					        // Replace the file path with path of the directory
							
					        File directory = new File("E:\\Simplelearn\\notes");
					        String fNameString;
					        // store all names with same name
					        // with/without extension
					        String[] flist = directory.list();
					        int flag = 0;
					        if (flist == null) {
					            System.out.println("Empty directory.");
					        }
					        else {
					        	System.out.println("Enter file name");
					        	 fNameString=sc.next();
					            // Linear search in the array
					            for (int i = 0; i < flist.length; i++) {
					                String filename = flist[i];
					               
					                if (filename.equalsIgnoreCase(fNameString)) {
					                    System.out.println(filename + " found");
					                    flag = 1;
					                }
					            }
					        }
					  
					        if (flag == 0) {
					            System.out.println("File Not Found");
					        }
							break;
						case 7:
							// 4.Option to navigate back to the main context
							loop = false;
							break;
						}
					}
					break;

				case 3:
					// There should be a third option to close the application
					java.lang.System.exit(0);
					break;
				}
			} while (true);

		} catch (Exception e) {
			System.out.println(e);
		}
		// rest code of the program
		System.out.println("rest of the code...");
	}

	static void RecursivePrint(File[] arr, int level) {
		// for-each loop for main directory files
		for (File f : arr) {
			// tabs for internal levels
			for (int i = 0; i < level; i++)
				System.out.print("\t");

			if (f.isFile())
				System.out.println(f.getName());

			else if (f.isDirectory()) {
				System.out.println("[" + f.getName() + "]");

				// recursion for sub-directories
				RecursivePrint(f.listFiles(), level + 1);
			}
		}

	}
}
