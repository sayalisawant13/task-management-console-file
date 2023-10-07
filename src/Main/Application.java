package Main;

import java.io.IOException;
import java.util.Scanner;

import Task_Management.TaskManagement;
import User_Management.UserManagement;


public class Application {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner Scanner = new Scanner (System.in);
		boolean canikeeprunningprogram = true ;
		
		System.out.println("**WELCOME TO TASK MANAGEMENT");
		System.out.println("/n");
		System.out.println("Enter login Name:");
		String loginName = Scanner.nextLine();
		System.out.println("Enter Password:");
		String password = Scanner.nextLine();
		
		if(!UserManagement.validateUserandPassword(loginName, password)){
			System.out.println("!!!Login failed.closing the application..");
			return;
			
		}
			while (canikeeprunningprogram == true) {
				System.out.println("##WELCOME TO TASK MANAGEMENT##");
				System.out.println("/n");
				System.out.println("What would like to do ?");
				System.out.println("1. User Management");
				System.out.println("2.Task Management");
				System.out.println("5.Quit");
				
				int optionselectedbyuser = Scanner .nextInt();
				if (optionselectedbyuser == 1) {
					UserManagement.Management();
					}
				else if (optionselectedbyuser == 2) {
					TaskManagement.taskmanagement();
				}
				else if (optionselectedbyuser == 5) {
					break;
				}
			}
			
	}

}

