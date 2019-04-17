package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DepartmentTest {

	@Test
	void test() {
		Department department = new Department(8000);
		
		
		//Managers
		Employee manA = new Manager('A',4200,600);
		Employee manB = new Manager('B',3600,600);
		Employee manC = new Manager('C',1200,600);
		Employee manD = new Manager('D',600,600);
		Employee manE = new Manager('E',2600,600);

		
		//Developers/Qt_Testers
		Employee developer = new Developer(2000);
		Employee qtTesters = new QA_Tester(1000);
		
		
		((Manager) manB).addEmployee(developer);
		((Manager) manB).addEmployee(qtTesters);
		
		
		//((Manager) manB).addEmpWarrantAllocate();
		
		((Manager) manA).addEmployee(manB);
		//((Manager) manA).addEmpWarrantAllocate();
		
		((Manager) manC).addEmployee(manD);
		
		
		((Manager) manE).addEmployee(developer);
		
		

	

		
		int expected = department.getManagers().size() + 1;
		department.addManager((Manager) manA);
		int actually = department.getManagers().size();
		
		assertEquals(expected,actually,"Checking making item been added");
		
		
		expected = 4200;
		department.addEmpWarrantAllocate();
		actually = department.getMonthlyExpAlloc();
		
		//System.out.println(expected + " " + actually);
		
		assertEquals(expected,actually,"Adding Manager (A) with sub employees(Manager B, Developer, QtTester) = 4200 Monthly Expense of Manager E employees");

		department.addManager((Manager) manC);
		department.addManager((Manager) manE);
		
		expected = 8000;
		department.addEmpWarrantAllocate();
		actually = department.getMonthlyExpAlloc();
		
		//System.out.println(expected + " " + actually);
		assertEquals(expected,actually,"Adding Manager (A) 4200 + Manager (C) 1200 + Manager (E) 2600 = 8000");

		expected = 0;
		actually = department.getMonthlyExpAlloc() - department.getAllocate();
		assertEquals(expected,actually,"8000 monthly expenses - 8000 department alocation = 0");


		//System.out.println(expected + " " + actually);
		
	}

	

}
