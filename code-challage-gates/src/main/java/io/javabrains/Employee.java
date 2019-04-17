package io.javabrains;

public abstract class Employee {
	protected int warrantAllocate;
	
	public Employee() {};
	
	public Employee(int warrantAllocate) {
		this.warrantAllocate = warrantAllocate;
	}
	
	public int getWarrantAllocate() {
		return warrantAllocate;
	}

	public void setWarrantAllocate(int allocate) {
		this.warrantAllocate = allocate;
	}
	
	
}
