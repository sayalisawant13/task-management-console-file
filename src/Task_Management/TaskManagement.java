package Task_Management;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class TaskManagement {
	
static ArrayList<Task> al= new ArrayList<>();
	
	public static void  taskmanagement() throws IOException  {
		loadDataFromFileToArrayList();
		
		Scanner scanner= new Scanner(System.in);
		boolean CanIKeepRunningTheProgram= true;
				
		while(CanIKeepRunningTheProgram == true) {
			
			
			
			System.out.println("**** Welcome to Task Management****");
			System.out.println("\n");
			
			System.out.println("What would you like to do?");
			System.out.println("1. Add Task");
			System.out.println("2. Update Task");
			System.out.println("3. Delete Task");
			System.out.println("4. Search Task");
			System.out.println("5. Quit");
			
			int optionSelectedByuser= scanner.nextInt();
			 if (optionSelectedByuser==Taskoptions.QUIT){
				 
				 File file= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Task_Management\\src\\Task_Management\\task.csv");
				 FileWriter fileWriter= new FileWriter(file, false);
				 BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
				 
				 for (Task task: al) {
					 bufferedWriter.write( "Task ID:"+task.taskID +"," + "Task Name:"+task.taskName + "," +"Task Description:"+ task.taskDescription + "," + "Start Date:"+task.startdate +"," + "End Date:"+task.enddate + "\n");
				 }
				 bufferedWriter.close();
				 fileWriter.close();
				 file= null;
			
				 System.out.println("!!! Program Closed");
				 CanIKeepRunningTheProgram= false;
			 }else if (optionSelectedByuser==Taskoptions.ADD_TASK) {
				addTask();
				 System.out.println("\n");
			 }else if (optionSelectedByuser==Taskoptions.SEARCH_TASK) {
				 System.out.println("Enter Task Name to Search:");
				 scanner.nextLine();
				 String sn = scanner.nextLine();
				 searchTask(sn);
				 System.out.println("\n");
				 
			 }else if (optionSelectedByuser==Taskoptions.DELETE_TASK) {
				 System.out.println("Enter Task  Name to delete:");
				 scanner.nextLine();
				 String deleteTaskName  = scanner.nextLine();
				 deletetask(deleteTaskName);
				 System.out.println("\n"); 
				 
			 }else if (optionSelectedByuser==Taskoptions.UPDATE_TASK) {
				 System.out.println("Enter Task Name to edit:");
				 scanner.nextLine();
				 String editTaskName  = scanner.nextLine();
				 edittask(editTaskName);
				 System.out.println("\n");  
			 }
		}
	}
	
	public static void addTask()throws IOException {
		Scanner scanner = new Scanner(System.in);
		Task taskObject=new Task();
		
		System.out.print("Task ID: ");
		taskObject.taskID = scanner.nextLine();
	  

	    System.out.print("Task Name: ");
	    taskObject.taskName = scanner.nextLine();
	  
	    System.out.print("Task Description:");
	    taskObject.taskDescription = scanner.nextLine();
	   
	    System.out.print("Start Date: ");
	    taskObject.startdate = scanner.nextLine();
	    
	    System.out.print("End Date: ");
	    taskObject.enddate = scanner.nextLine();
	    
	    System.out.println(" Task ID: "+ taskObject.taskID);
	    System.out.println(" Task Name: "+ taskObject.taskName);
	    System.out.println(" Task Description: "+ taskObject.taskDescription);
	    System.out.println(" Start Date: "+ taskObject.startdate);
	    System.out.println(" End Date: "+ taskObject.enddate);
	   
	   al.add(taskObject);
	    
	
	}
	public static void searchTask(String taskName) {
		for (Task task : al) {
			if (task.taskName.equalsIgnoreCase(taskName)) {
	 System.out.println(" Task ID: "+ task.taskID);
	    System.out.println(" Task Name: "+ task.taskName);
	    System.out.println(" Task Description: "+ task.taskDescription);
	    System.out.println(" Start Date: "+ task.startdate);
	    System.out.println(" End Date: "+ task.enddate);
	    return;
			}
	}
			System.out.println("Task not found.");
	}
	
	public static void deletetask(String taskName) {
		Iterator<Task> taskIterator=al.iterator();
		
		while (taskIterator.hasNext()) {
			Task task= taskIterator.next();
			if(task.taskName.equalsIgnoreCase(taskName)) {
				taskIterator.remove();
			}
				System.out.println("Task"+ task.taskName+" has been deleted.");
				break;
			}
	}
		
		public static void edittask( String taskName) {
		for (Task task : al) {
		if (task.taskName.equalsIgnoreCase(taskName)) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Edit Task: "+ task.taskName);
		
		
		System.out.println(" New Task ID: ");
		task.taskID = scanner.nextLine();
		
		
		System.out.println(" New Task Name: ");
		task.taskName = scanner.nextLine();
		
		System.out.println(" New Task Description:");
		task.taskDescription = scanner.nextLine();
		
		System.out.println(" New Start Date: ");
		task.startdate = scanner.nextLine();
		
		System.out.println(" New End Date: ");
		task.enddate = scanner.nextLine();
		
		System.out.println("Task information updated.");
		return;
		}
		}
		System.out.println("Task not found ");
		
		}
		
		public static void loadDataFromFileToArrayList() throws IOException {
			File file= new File("C:\\Users\\Lenovo\\eclipse-workspace\\Task_Management\\src\\Task_Management\\task.csv");
			FileReader fr= new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line ="";
			 while((line= br.readLine())!=null)
			 {
				 Task task= new Task();
				 String[] taskDataArray= line.split(",");
				 if (taskDataArray.length>4)
				 {
					 task.taskID=taskDataArray[0];
					 task.taskName=taskDataArray[1];
					 task.taskDescription=taskDataArray[2];
					 task.startdate=taskDataArray[3];
					 task.enddate=taskDataArray[4];
					 al.add(task);
			 }
		}
br.close();
fr.close();
file=null;
	}

		}	
		
	

