package io.javabrains;
import java.util.ArrayList;
import java.util.List;


public class Manager extends Employee {
	private char name;
	private int	totalAllocate = 0;
	private int monthlyExpAlloc = 0;
	private int allocate;
	public Manager() {};

	public Manager(char name,int allocate, int warrantAllocate) 
	{
		super(warrantAllocate);
		this.name = name;
		this.allocate = allocate;
	};
	
	private List<Employee> inCharge = new ArrayList<Employee>();

	
	public void addEmployee(Employee emp) {
		inCharge.add(emp);
	}
	
	/*
	 * Adding all workers including manager's alocation warrant for montthly
	 * expenses
	 */	public void addEmpWarrantAllocate() {
		monthlyExpAlloc = 0;
		monthlyExpAlloc += warrantAllocate;
		for(Employee emp : inCharge) {
			if(emp instanceof Manager) {
				monthlyExpAlloc += ((Manager) emp).getMonthlyExpAlloc();
			} else {
				monthlyExpAlloc += emp.getWarrantAllocate();
			}
			
		
		}
	}
	
	
	

	
	public int getMonthlyExpAlloc() {
		return monthlyExpAlloc;
	}

	public void setMonthlyExpAlloc(int monthlyExpAlloc) {
		this.monthlyExpAlloc = monthlyExpAlloc;
	}

	public int getAllocate() {
		return allocate;
	}

	public void setAllocate(int allocate) {
		this.allocate = allocate;
	}

	public List<Employee> getInCharge() {
		return inCharge;
	}

	public void setInCharge(List<Employee> inCharge) {
		this.inCharge = inCharge;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public int getTotalAllocate() {
		return totalAllocate;
	}

	public void setTotalAllocate(int totalAllocate) {
		this.totalAllocate = totalAllocate;
	}
	
	
		
	
}
