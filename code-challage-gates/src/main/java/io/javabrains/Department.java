package io.javabrains;
import java.util.ArrayList;
import java.util.List;

public class Department {
	private List<Manager> managers = new ArrayList<>();
	private int allocate;
	private int monthlyExpAlloc = 0;
	public Department() {}
	
	public Department(int allocate) {
		this.allocate = allocate;
	}
	
	public void addManager(Manager manager) {
		managers.add(manager);
	}
	
	
	
	/*
	 * This method will go through each manager, sub-manager and other workers (Devs
	 * and QA_Testers) adds all the alocate warrant for monthly expenses
	 */	public void addEmpWarrantAllocate() {
		//Resetting allocation to 0 for Unit Testing
		monthlyExpAlloc = 0;
		for(Manager manager : managers) {
			monthlyExpAlloc += manager.getWarrantAllocate();
			for(Employee subEmp : manager.getInCharge()) {
				if(subEmp instanceof Manager) {
					((Manager) subEmp).addEmpWarrantAllocate();
					//monthlyExpAlloc += ((Manager) subEmp).getWarrantAllocate();
					monthlyExpAlloc += ((Manager) subEmp).getMonthlyExpAlloc();
				} else {
					monthlyExpAlloc += subEmp.getWarrantAllocate();

				}
			}
			
			/*
			 * if(emp instanceof Manager) { ((Manager) emp).addEmpWarrantAllocate();
			 * 
			 * monthlyExpAlloc += ((Manager) emp).getMonthlyExpAlloc();
			 * 
			 * for(Employee subManager : ((Manager) emp).getInCharge()) { if(subManager
			 * instanceof Manager) { ((Manager) subManager).addEmpWarrantAllocate();
			 * monthlyExpAlloc += ((Manager) subManager).getMonthlyExpAlloc(); } } }
			 */
		
		
		}
	}
	
	
	/*
	 * public void calcMonthlyAlloc() { monthlyExpAlloc = allocate -
	 * totalEmpAlocate;
	 * 
	 * }
	 */
	
	
	

	public int getWarrantAllocate() {
		return allocate;
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

	public void setWarrantAllocate(int allocate) {
		this.allocate = allocate;
	}



	public int getAllocate() {
		return allocate;
	}

	public void setAllocate(int allocate) {
		this.allocate = allocate;
	}

	public int getMonthlyExpAlloc() {
		return monthlyExpAlloc;
	}

	public void setMonthlyExpAlloc(int monthlyExpAlloc) {
		this.monthlyExpAlloc = monthlyExpAlloc;
	}
	
	
		
	
}
