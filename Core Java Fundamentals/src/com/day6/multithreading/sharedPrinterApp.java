package com.day6.multithreading;

//imagine a printer - shared among employees
//- only one employee can use at a time - synchronized access
//- two emps are printing - paper jam

class printer{
	private int printerAvailable = 2;
	
	synchronized void usePrinter(String userName) {
		if(printerAvailable >0) {
			System.out.println(userName+ " is printing....");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			printerAvailable--;
			System.out.println(userName+ " successfully printed");
		}
		else {
			System.out.println("Sorry "+userName+" , cannot print ");
		}
	}
}

public class sharedPrinterApp {

	public static void main(String[] args) {
		printer print = new printer();
		
		Thread t1 = new Thread(() -> print.usePrinter("A"));
		Thread t2 = new Thread(() -> print.usePrinter("B"));
		Thread t3 = new Thread(() -> print.usePrinter("C"));
		
		t1.start();
		t2.start();
		t3.start();

	}

}
