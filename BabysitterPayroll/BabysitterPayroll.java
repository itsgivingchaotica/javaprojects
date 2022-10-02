import java.io.*;
import java.util.Scanner;

/**
 * Payroll program which calculates the paychecks for babysitters on payroll
 * @author Saoirse Siobhan Ebert
 *
 */

class BabysitterPayroll {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner (new File("/Users/siobhan/javaprojects/BabysitterPayroll/babysitter_file_data.txt"));
		Scanner inputHours = new Scanner(new File("/Users/siobhan/javaprojects/BabysitterPayroll/babysitter_payroll_file_data.txt"));
		String emplID = "";
		String emplName = "";
		String address1 = "";
		String address2 = "";
		double pay1 = 0;
		double pay2 = 0;
		double pay3 = 0;
		Payroll payroll = new Payroll();
	
		
		/**
		 * add employee information including rates of pay as Employee class objects to the payroll class object 
		 * Payroll is an ArrayList of Employee objects
		 */
		while (input.hasNext()) {
			emplID = input.next();
			input.nextLine();
			emplName = input.nextLine();
			address1 = input.nextLine();
			address2 = input.nextLine();
			pay1 = input.nextDouble();
			pay2 = input.nextDouble();
			pay3 = input.nextDouble();
			input.nextLine();
			//new employee object consisting of information input above
			Employee employee = new Employee(emplID,emplName,address1,address2,pay1,pay2,pay3);
			//add employee to payroll
			payroll.addLine(employee);
		}
		input.close();
		
		//loop thru the hours worked for each employee ID. 
		while (inputHours.hasNext()) {
			String processID = inputHours.next();
			int daysWorked = inputHours.nextInt();
			
			//loop through by number of days worked for each id number
			for (int i=0; i<daysWorked; i++)
			{
				double pay;
				String startHour = inputHours.next();
				String endHour = inputHours.next();
				//find the index value in the ArrayList corresponding to the ID
				int index = payroll.findEmplIndex(processID);
				//find the employee corresponding to the position in the ArrayList
				Employee tempEmployee = payroll.getEmployee(index);
				//Create a new time punch for each shift and calculate the pay
				TimePunch time = new TimePunch(startHour,endHour,tempEmployee);
				pay = time.calculatePay();
				if (pay!=-1) {
					tempEmployee.addPay(pay);
				}
				else 
				{
				System.out.println("The hours " + startHour + " to " + endHour + " are invalid. Edit " + tempEmployee.getEmplName() + "'s timepunch.");
				}
			}
		}
		inputHours.close();
		//print the final pay figures of each employee
		payroll.issuePaychecks();
		
	}

}
