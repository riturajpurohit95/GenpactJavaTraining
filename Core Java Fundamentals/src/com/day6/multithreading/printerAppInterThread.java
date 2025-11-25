package com.day6.multithreading;

class printer2{
	private boolean isBusy = false;
	
	//synchronized method 
//	public synchronized void printDocument(String empName, String docName) {
	public void printDocument(String empName, String docName) {
		//if printer busy - wait until it become free
		
		synchronized(this) {
		while(isBusy) {
			try {
				System.out.println(empName+ " is waiting for printer..");
				wait(); //release lock and wait
			}catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
			
		
		//mark printer as busy
		isBusy = true;
		} // isBusy - shared object - so used synchronized block
		
		//simulate printing
		System.out.println(empName+ " is printing: "+docName);
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println(empName+" has finished prinitng: "+ docName );
		
		synchronized(this) {
			//mark printer as free and notify waiting threads
			isBusy = false;
			notify();//wake up one waiting thread
		} // isBusy - shared object - so used synchronized block
		
		}
}

class Employee extends Thread{
	private printer2 prtr;
	private String docmt;
	
	public Employee(String name, printer2 prtr, String docmt) {
		super(name);//call thread class constructor, empname -thread name
		this.prtr = prtr;
		this.docmt = docmt;
	}
	
	public void run() {
		prtr.printDocument(getName(), docmt);
	}
}

public class printerAppInterThread {

	public static void main(String[] args) {
		
		//create just one printer object to share among all emps
		
		printer2 sharedPrinter = new printer2();
		
		//multiple emps/ threads
		Employee emp1 = new Employee("emp1",sharedPrinter,"ProjectReport.pdf");
		Employee emp2 = new Employee("emp2",sharedPrinter,"BudgetReport.pdf");
		Employee emp3 = new Employee("emp3",sharedPrinter,"PresentationReport.pdf");
		

		//start the threads
		emp1.start();
		emp2.start();
		emp3.start();
		
	}

}

