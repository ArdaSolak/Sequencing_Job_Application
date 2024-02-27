package Sequencing_Job_Application;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.time.LocalDate;

//CUSTOMER CLASS

class Customer
{
	// FIELDS
	
	private String customerName;
	private String customerSurname;
	private LocalDate tradingStartDate;
	private double customerGrade;
	
	// CONSTRUCTOR
	
	public Customer(String customerName,String customerSurname, LocalDate tradingStartDate) 
	{
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.tradingStartDate = tradingStartDate;
		
		// CALCULATION OF CUSTOMER RANK - Grade calculation is found by dividing the number of days since the start of trading with the customer by 10.
		
		LocalDate today = LocalDate.now();
		long daysDifference = ChronoUnit.DAYS.between(tradingStartDate, today);
		double gradeForCustomers = (double)daysDifference/10;
		
		this.customerGrade = gradeForCustomers;
	}
	
	// GETTER METHODS
	
	public String getCustomerName() 
	{
		return customerName;
	}
	public String getCustomerSurame() 
	{
		return customerSurname;
	}
	public LocalDate getTradingStartDate() 
	{
		return tradingStartDate;
	}
	public double getCustomerGrade() 
	{
		return customerGrade;
	}
	
	// SETTER METHODS
	
	public void setCustomerName(String CustomerName) 
	{
		this.customerName = CustomerName;
	}
	public void setCustomerSurname(String CustomerSurname) 
	{
		this.customerSurname = CustomerSurname;
	}
	public void setTradingStartDate(LocalDate TradingStartDate) 
	{
		this.tradingStartDate = TradingStartDate;
	}
	public void setCustomerGrade(double CustomerGrade) 
	{
		this.customerGrade = CustomerGrade;
	}
}

//JOB CLASS

class Job 
{ 
	// FIELDS

	private String jobName;
	private int processingHourInMachine1;
	private int processingHourInMachine2;
 private int processingHourInMachine3;
 private int DueDateInDay;
 private Customer customer;

// CONSTRUCTOR
 
 public Job(String jobName, Customer customer ,int processingTime1, int processingTime2, int processingTime3,  int DueDateInDay) 
 {
     this.jobName = jobName;
     this.customer = customer;
 	this.processingHourInMachine1 = processingTime1;
 	this.processingHourInMachine2 = processingTime2;
 	this.processingHourInMachine3 = processingTime3;
     this.DueDateInDay = DueDateInDay;      
 }
 
 // 	GETTER METHODS

 public String getJobName() 
 {
     return jobName;
 }
 public Customer getCustomer()
 {
 	return customer;
 }
 public int getProcessingHourInMachine1() 
 {
     return processingHourInMachine1;
 }
 public int getProcessingHourInMachine2() 
 {
 	return processingHourInMachine2;
 }

 public int getProcessingHourInMachine3() 
 {
 	return processingHourInMachine3;
 }
 public int getDueDateInDay() 
 {
     return DueDateInDay;
 }
 
 // SETTER METHODS

 public void setJobName(String JobName) 
 {
     this.jobName = JobName;
 }
 public void setCustomer(Customer Customer)
 {
 	this.customer = Customer;
 }
 public void setProcessingHourInMachine1(int ProcessingHourInMachine1) 
 {
     this.processingHourInMachine1 = ProcessingHourInMachine1;
 }
 public void setProcessingHourInMachine2(int ProcessingHourInMachine2) 
 {
 	this.processingHourInMachine2 = ProcessingHourInMachine2;
 }

 public void setProcessingHourInMachine3(int ProcessingHourInMachine3) 
 {
 	this.processingHourInMachine3 = ProcessingHourInMachine3;
 }
 public void setDueDateInDay(int DueDateInDay) 
 {
     this.DueDateInDay = DueDateInDay;
 }
 
 // CHECK PROCESSING LIMITS METHOD
 
 // Only Machine 1 has processing limits 100.
 public String checkProcessingLimits() 
 {
     if (this.processingHourInMachine1 > 100) 
     {
         return "This job requires additional attention for Machine 1!";
     } 
     else 
     {
         return "This job is within normal processing limits for Machine 1.";
     }
 }
 
 // OVERRIDE TOSTRING
 
 public String toString() 
 {
     int totalProcessingTimeInHours = getProcessingHourInMachine1() + getProcessingHourInMachine2() + getProcessingHourInMachine3();
     int totalProcessingTimeInDays = totalProcessingTimeInHours / 24; 
     StringBuilder stringBuilder = new StringBuilder();
     stringBuilder.append("Job name: ").append(jobName).append("\n");
     stringBuilder.append("Total processing time: ").append(totalProcessingTimeInDays).append(" days").append("\n");
     stringBuilder.append("Processing hours in Machine 1: ").append(getProcessingHourInMachine1()).append(" hours").append("\n");
     stringBuilder.append("Processing hours in Machine 2: ").append(getProcessingHourInMachine2()).append(" hours").append("\n");
     stringBuilder.append("Processing hours in Machine 3: ").append(getProcessingHourInMachine3()).append(" hours").append("\n");        
     return stringBuilder.toString();
 }
}

//MACHINE CLASS

class Machine
{
	// FIELDS
	
	private int machineID; 
	private String machineName;

	// CONSTRUCTOR
	
	public Machine(int machineID, String machineName) 
	{
		this.machineID = machineID;
		this.machineName = machineName;
	}
	
	// GETTER METHODS
	
	public int getMachineID() 
	{
		return machineID;
	}
	public String getMachineName() 
	{
		return machineName;
	}
	// SETTER METHODS
	
	public void setMachineID(int MachineID) 
	{
		this.machineID = MachineID;
	}
	public void setMachineName(String MachineName) 
	{
		this.machineName = MachineName;
	}
}

public class Sequencing_Job_App_Class 
{
	public static void main(String[] args)
	{
		// 5 CUSTOMER COMPANY HAVE
		
				Customer customer1 = new Customer("Arda","Solak", LocalDate.of(1990,1,20));
				Customer customer2 = new Customer("Damla","Bal", LocalDate.of(1995,7,10));
				Customer customer3 = new Customer("İrem","Aldemir", LocalDate.of(2010,11,07));
				Customer customer4 = new Customer("Ömer","Utlu", LocalDate.of(2020,6,30));
				Customer customer5 = new Customer("Sudem","Hızarcıoğlu", LocalDate.of(2004,4,12));
				
				// 5 JOBS BELONGING TO 5 CUSTOMERS THAT THE COMPANY HAVE
				
				Job job1 = new Job("Laptop production for Arda Solak customer",customer1,70,30,12,10);
				Job job2 = new Job("Telephone production for Sudem Hızarcıoğlu customer",customer2,45,50,12,5);
				Job job3 = new Job("Television production for İrem Aldemir customer",customer3,13,120,7,12);
				Job job4 = new Job("Tablet production for Damla Bal customer",customer4,90,10,92,17);
				Job job5 = new Job("Smart Watch production for Ömer Utlu customer",customer5,160,73,84,20);
				
				// 3 MACHINE THAT COMPANY HAVE
				
				Machine machine1 = new Machine(1,"Welding Machine");
				Machine machine2 = new Machine(1,"Assembly Machine");
				Machine machine3 = new Machine(1,"Packaging Machine");
			
				// *****SEQUENCING******
				 
				// SEQUENCING FOR EARLIEST DUE DATE
				
				Job[] jobsArr = {job1, job2, job3, job4, job5};
				Arrays.sort(jobsArr, Comparator.comparingInt(Job::getDueDateInDay)); 
				System.out.println("SEQUENCING FOR EARLIEST DUE DATE");
				for(Job job : jobsArr) 	
				{
					System.out.println(job);
					System.out.println(job.checkProcessingLimits());
				}
				
				// SEQUENCING FOR EARLIEST PROCESSING TIME
				
				Arrays.sort(jobsArr, Comparator.comparingInt(Sequencing_Job_App_Class::calculateTotalProcessingTime));
				System.out.println("SEQUENCING FOR EARLIEST PROCESSING TIME");
				for(Job job : jobsArr) 	
				{
					System.out.println(job);
					System.out.println(job.checkProcessingLimits());
				}
				
				// SEQUENCING FOR LONGEST PROCESSNG TIME
				
				Arrays.sort(jobsArr, Comparator.comparingInt(Sequencing_Job_App_Class::calculateTotalProcessingTime).reversed());
				System.out.println("SEQUENCING FOR EARLIEST DUE DATE");
				for(Job job : jobsArr) 	
				{
					System.out.println(job);
					System.out.println(job.checkProcessingLimits());
				}
				
				// SEQUENCING FOR CUSTOMER GRADE
				
				Arrays.sort(jobsArr, Comparator.comparingDouble(job -> ((Job) job).getCustomer().getCustomerGrade()).reversed());
				System.out.println("SEQUENCING FOR CUSTOMER GRADE");	
				for (Job job : jobsArr) 
				{
				    System.out.println(job);
				    System.out.println(job.checkProcessingLimits());
				}
			}
			// TOTAL PROCESSNG TIME METHOD
			public static int calculateTotalProcessingTime(Job job) 
			{
		        return job.getProcessingHourInMachine1() + job.getProcessingHourInMachine2() + job.getProcessingHourInMachine3();
		    }
}
