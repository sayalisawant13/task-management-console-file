
package User_Management;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Scanner;

	public class UserManagement {
		private static final String Useroption = null;
		static ArrayList<User> a2 = new ArrayList<>();
		static {
			try {
				loaddatafromfileToArrayList();
				} catch (IOException e) {
					//TODO Auto-generated catch book
					e.printStackTrace();
				}
		}
		public static void Management() throws IOException {
			Scanner sc = new Scanner(System.in);
			boolean canIKeepRunningTheProgram = true;
			while (canIKeepRunningTheProgram == true) {
				System.out.println("**Welcome to user_management**");
				System.out.println("\n");
				System.out.println("what would you like to do?");
				System.out.println("1. Add user");
				System.out.println("2. Edit user");
				System.out.println("3. delete user");
				System.out.println("4. search user");
				System.out.println("5. Quit");
				int optionSelectedByUser = sc.nextInt();
				if (optionSelectedByUser == UserOptions.QUIT) {
					File file = new File(
							"C:\\Users\\Lenovo\\eclipse-workspace\\Task_Management\\src\\User_Management\\user.csv");
					FileWriter fileWriter = new FileWriter(file, false);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					for (User User : a2) {
						// System.out.println(user.loginName+","+user.userName+""+user.Password+""+user.ConfirmPassword+"\n");

						bufferedWriter.write(User.loginName + "," + User.userName + "," + User.Password + ","
								+ User.ConfirmPassword + "\n");

					}
					bufferedWriter.close();
					fileWriter.close();
					file = null;

					System.out.println("Program closed");
					canIKeepRunningTheProgram = false;
					System.out.println("After while loop");
				} else if (optionSelectedByUser == UserOptions.ADD_USER) {
					addUser();
					System.out.println("\n");

				} else if (optionSelectedByUser == UserOptions.SEARCH_USER) {
					System.out.println("Enter your name to search");
					sc.nextLine();
					String sn = sc.nextLine();
					SearchUser(sn);
					System.out.println("\n");

				} else if (optionSelectedByUser == UserOptions.DELETE_USER) {
					System.out.println("Enter your Name to delete");
					sc.nextLine();
					String deleteuserName = sc.nextLine();
					deleteuserName(deleteuserName);
					System.out.println("\n");

				} else if (optionSelectedByUser == UserOptions.EDIT_USER) {
					System.out.println("Enter your Name to edit");
					sc.nextLine();
					String edituserName = sc.nextLine();
					edituserName(edituserName);
					System.out.println("\n");
				}
	          
				for (User u : a2) {
					System.out.println(u.loginName);
					System.out.println(u.userName);
					System.out.println(u.Password);
					System.out.println(u.ConfirmPassword);
				}

			}
		}

		private static void loadDataFromFileToArrayLiist() {
			// TODO Auto-generated method stub

		}

		public static void addUser() {
			Scanner sc = new Scanner(System.in);
			User User = new User();

			System.out.println("Enter login name");
			User.loginName = sc.nextLine();

			System.out.println("Enter user name");
			User.userName = sc.nextLine();

			System.out.println("Enter Password");
			User.Password = sc.nextLine();

			System.out.println("Enter conform Password");
			User.ConfirmPassword = sc.nextLine();

			System.out.println("loginName" + "\t" + User.loginName);
			System.out.println("userName" + "\t" + User.userName);
			System.out.println("Password" + "\t" + User.Password);
			System.out.println("Userobject.ConfirmPassword" + "\t" + User.ConfirmPassword);
			a2.add(User);
		}

		public static void SearchUser(String loginName) {
			for (User user2 : a2) {
				if (user2.loginName != null && user2.loginName.equalsIgnoreCase(loginName)) {
					System.out.println("loginName Name" + user2.loginName);
					System.out.println("userName" + user2.userName);
					System.out.println("Password" + user2.Password);
					System.out.println("ConfirmPassword" + user2.ConfirmPassword);
					return;
				}
			}
			System.out.println("User Not Found");
		}

		public static void deleteuserName(String loginName) {
			Iterator<User> UserIterator = a2.iterator();
			while (UserIterator.hasNext()) {
				User User2 = UserIterator.next();
				if (User2.loginName.equalsIgnoreCase(loginName)) {
					UserIterator.remove();
					System.out.println("Userobject" + User2.loginName + "has been deleted");
					break;
				}
			}
		}

		public static void edituserName(String loginName) {
			{
				for (User User3 : a2) {
					if (User3.loginName.equalsIgnoreCase(loginName)) {
						Scanner sc = new Scanner(System.in);
						System.out.println("Editing user" + User3.loginName);

						System.out.println("new loginName name");
						User3.loginName = sc.nextLine();

						System.out.println("Enter new user name");
						User3.userName = sc.nextLine();

						System.out.println("Enter new Password");
						User3.Password = sc.nextLine();

						System.out.println("Enter new conform Password");
						User3.ConfirmPassword = sc.nextLine();

						System.out.println("USER INFORMATION IS UPDATE");

						return;
					}

				}
			}
			System.out.println("user not found");
		}

		public static void Deleteuser(String userName) {
			Iterator<User> UserIterator = a2.iterator();
			while (UserIterator.hasNext()) {
				User User = UserIterator.next();
				if (User.userName.equalsIgnoreCase(userName)) {
					UserIterator.remove();
					System.out.println("User" + User.userName + "has been deleted");
					break;
				}

			}
		}

		public static void loaddatafromfileToArrayList() throws IOException {
			File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Task_Management\\src\\User_Management\\user.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = " ";
			while ((line = bufferedReader.readLine()) != null) {
				User User = new User();
				String[] userDataArray = line.split(",");
				if (userDataArray.length > 3) {
					User.loginName = userDataArray[0];
					User.userName = userDataArray[1];
					User.Password = userDataArray[2];
					User.userRole = userDataArray[3];
					a2.add(User);
				}
			}
			bufferedReader.close();
			fileReader.close();
			file = null;

		}
		public static boolean validateUserandPassword(String loginName , String Password) {
		Iterator<User> UserIterator = a2.iterator();
		while (UserIterator.hasNext()) {
			User User =UserIterator.next();
			if (User.loginName.equalsIgnoreCase(loginName) && User.Password.equalsIgnoreCase(Password)) {
				return true ;
			}
		}
		return false;
		}
	}












