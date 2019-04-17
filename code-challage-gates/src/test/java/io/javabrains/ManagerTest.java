package io.javabrains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagerTest {

	@Test
	void test() {
		Employee manA = new Manager('A',4200,600);
		Employee manB = new Manager('B',3600,600);
		
		
		Employee manC = new Manager('C',1200,600);
		Employee manD = new Manager('D',600,600);
		Employee manE = new Manager('E',2600,600);

		Employee developer = new Developer(2000);
		Employee qtTesters = new QA_Tester(1000);
		
		
		
		
		
		int expected = ((Manager) manB).getInCharge().size() + 1;
		((Manager) manB).addEmployee(developer);
		
		int actually = ((Manager) manB).getInCharge().size();
		
		assertEquals(expected,actually,"0 Items + 1 Item = 1 Item total. Checking manager make sure it adding employees");
		((Manager) manB).addEmployee(qtTesters);
		
		
		
		expected = 3600;
		((Manager) manB).addEmpWarrantAllocate();
		actually = ((Manager) manB).getMonthlyExpAlloc();
		
		//System.out.println(expected + " " + actually);
		
		assertEquals(expected,actually,"Adding Dev(2000) + QtTester(1000) + Manager B(600) = 3600 Monthly Expense of Manager A employees");
		
		expected = 4200;
		((Manager) manA).addEmployee(manB);
		((Manager) manA).addEmpWarrantAllocate();
		actually = ((Manager) manA).getMonthlyExpAlloc();

		//System.out.println(expected + " " + actually);
		assertEquals(expected,actually,"Adding Dev(2000) + QtTester(1000) + Manager B(600) + Manager A(600) = 4200 Monthly Expense of Manager A employees");

		
		expected = 600;
		((Manager) manD).addEmpWarrantAllocate();
		actually = ((Manager) manD).getMonthlyExpAlloc();
		assertEquals(expected,actually,"Adding Manager D(600) = 600 Monthly Expense of Manager D employees");

		
		expected = 1200;
		((Manager) manC).addEmployee(manD);
		((Manager) manC).addEmpWarrantAllocate();
		actually = ((Manager) manC).getMonthlyExpAlloc();

		//System.out.println(expected + " " + actually);
		assertEquals(expected,actually,"Adding Manager C(600) + Manager D(600) = 1200 Monthly Expense of Manager C employees");

		expected = 2600;
		((Manager) manE).addEmployee(developer);
		((Manager) manE).addEmpWarrantAllocate();
		actually = ((Manager) manE).getMonthlyExpAlloc();

		//System.out.println(expected + " " + actually);
		assertEquals(expected,actually,"Adding Dev(2000) + Manager E(600) = 2600 Monthly Expense of Manager E employees");
		
		
		
		
	}

}
