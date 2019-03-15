package PhoneBook;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Application {
	private static String[] menus = {"Add new entries","Search by first name *","Search by full name *",
			"Search by telephone number","Search by city or state","Delete a record for a given telephone number","Update a record for a given telephone number","Show all records in asc order",
			"Exit"};
	private static String[] personMenus = {"Update Name","Update Middle Name","Update Last Name","Update Address","Update Contact",
			"Exit"};
	
	private static String[] addressMenus = {"Update Street","Update City","Update State","Update Zipcode",
	"Exit"};
	
	private static String[] contactMenus = {"Update Telephone",
	"Exit"};
	
	
	private static Scanner sc = new Scanner(System.in);
	
	private static Person[] personList = new Person[0];
	
	private static String header = "|  Full Name  |        Address       | Contact Info |";

	
	public static void main(String args[]) {
		
		
		//Testing
		String[] str = {"John 1, 114 Market St, St Louis, AL, 63403, 6366435698", "John 3, 324 Main St, St Charles, MO,63303, 8475390126", "John 2, 574 Pole ave, St. Peters, MO, 63333, 5628592375"};
		
		for(int i = 0; i < str.length; i++) {
			redirect(1,str[i],"mainMenu",null);
		}
		//
		
		
		runningType(sc, "mainMenu",null);
		
	}
	
	
	
	
	public static void runningType(Scanner sc, String menuType,Person person) {
		
		if(menuType.equals("personMenus")) {
			String line = "";
			for(int i = 0; i < 20;i++) line += "*";
			System.out.println(String.format("%s\nUPDATE FOR %s\n%s",line,person.fullName(),line));
		}
		
		
		String[] mymenus = getMenu(menuType);
		System.out.println(Screen(menuType));
		int option = sc.nextInt();
		sc.nextLine();
		String response = "";
		//System.out.flush();
		
	

		while(option != mymenus.length) {
			
			//Getting option
			if((menuType.equals("personMenus") && option == 4) || (menuType.equals("personMenus") && option == 5) || (menuType.equals("mainMenu") && option == 8) ) {
				
			}else {
				System.out.println(Option(option,menuType));
				response = sc.nextLine();
			}
			

			
			redirect(option,response,menuType,person);
			
			
			//Menus
			System.out.println(Screen(menuType));
			option = sc.nextInt();
			sc.nextLine();
			//sc.next();
			
		}
		
		
	}
	
	
	
	public static String[] getMenu(String menuType) {
		
		if(menuType.contentEquals("mainMenu")) return menus;
		if(menuType.contentEquals("personMenus")) return personMenus;
		if(menuType.contentEquals("addressMenus")) return addressMenus;
		if(menuType.contentEquals("contactMenus")) return contactMenus;
		else return null;
		
	}
	
	
	
	public static String Screen(String menuType) {
		String[] mymenus = getMenu(menuType);

		
		String printMenus = "Please enter an option...\n";
		for(int i = 0 ; i < mymenus.length; i++) {
			String menu  = (i+1) + ")" + mymenus[i];
			if(i == 0) {
				printMenus +=  menu;
				continue;
			}
			printMenus += "\n" + menu;
		}
		
		
		return printMenus;
	}
	
	
	public static String Option(int option,String menuType) {
		String result = "Please enter to ";
		
		if(menuType == "mainMenu") {
			switch(option) {
			case 1 : return result += "add new entry: ";
			case 2 : return result += "search by first name*: ";
			case 3 : return result += "search by last name*: ";
			case 4 : return result += "search by telephone number: ";
			case 5 : return result += "search by city or state: ";
			case 6 : return result += "delete a record for a given telephone number: ";
			case 7 : return result += "Update a record for a given telephone number: ";
			case 8 : return "";
			default : return "Please enter only from an options!";
			}	
		}
		
		if(menuType == "personMenus") {
			switch(option) {
			case 1 : return result += "Update Name: ";
			case 2 : return result += "Update Middle Name: ";
			case 3 : return result += "Update Last Name: ";
			case 4 : return result += "Update Address: ";
			case 5 : return result += "Update Telephone: ";
			default : return "Please enter only from an options!";
			}
		}
		
		
		if(menuType == "addressMenus") {
			switch(option) {
			case 1 : return result += "Update Street: ";
			case 2 : return result += "Update City: ";
			case 3 : return result += "Update State: ";
			case 4 : return result += "Update Zipcode: ";
			default : return "Please enter only from an options!";
			}
		}
		
		
		if(menuType == "contactMenus") {
			switch(option) {
			case 1 : return result += "Update Telephone: ";
			default : return "Please enter only from an options!";
			}
		}
		
		
		return "";
		
	}
	
	public static void redirect(int option, String response,String menuType,Person person) {
		if(menuType == "mainMenu") {
		
			switch(option) {
			case 1 : addEntry(response); break;
			case 2 : search(response,option);break;
			case 3 : search(response,option);break;
			case 4 : search(response,option);break;
			case 5 : search(response,option);break;
			case 6 : delete(response); break;
			case 7 : update(response); break;
			case 8 : showAll(); break;
			default : break;
			}
		
		}
		
		if(menuType == "personMenus") {
			
			switch(option) {
			case 1 : updatePerson(response,option,person); break;
			case 2 : updatePerson(response,option,person);break;
			case 3 : updatePerson(response,option,person);break;
			case 4 : updateAddressScreen(person);break;
			case 5 : updateContactScreen(person);break;
			default : break;
			}
		
		}
		
		
		
		if(menuType == "addressMenus") {
			
			switch(option) {
			case 1 : updateAddress(response,option,person); break;
			case 2 : updateAddress(response,option,person);break;
			case 3 : updateAddress(response,option,person);break;
			case 4 : updateAddress(response,option,person);break;
			case 5 : updateAddress(response,option,person);break;
			default : break;
			}
		
		}
		
		if(menuType == "contactMenus") {
			
			switch(option) {
			case 1 : updateContact(response,option,person); break;
			default : break;
			}
		
		}
		
		
	}
	
	public static void showAll() {
		sortPersonList(personList);
		
		System.out.println(header);
		
		for(Person p : personList) {
			System.out.println(p.toString());
		}
	}
	
	public static void updateAddressScreen(Person person) {
		runningType(sc, "addressMenus",person);
	}
	
	public static void updateContactScreen(Person person) {
		runningType(sc, "contactMenus",person);
	}
	
	public static void updatePerson(String response,int option, Person person) {
		if(option == 1) person.setFirstName(response);
		if(option == 2) person.setMiddleName(response);
		if(option == 3) person.setLastName(response);
		
	}
	
	public static void updateAddress(String response,int option, Person person) {
		if(option == 1) person.getAddress().setStreet(response);
		if(option == 2) person.getAddress().setCity(response);
		if(option == 3) person.getAddress().setState(response);
		if(option == 4) person.getAddress().setZipcode(response);

	}
	
	public static void updateContact(String response,int option, Person person) {
		if(option == 1) person.getContact().setTelephone(response.replaceAll("[^0-9]",""));

		
	}
	
	
	
	
	public static void update(String response) {
		for(Person p : personList) {
			if(p.getContact().getTelephone().toLowerCase().equals(response.replaceAll("[^0-9]","").toLowerCase())) {
				runningType(sc, "personMenus",p);

				break;
			}
		}
	}
	
	
	
	
	
	public static void addEntry(String response) {
		
		Person person = setPerson(response);
		if(person == null) return;
		
		personList = addPerson(personList,person);
				
		System.out.println(personList.length);
		for(int i = 0 ; i < personList.length; i++) {
			System.out.println(personList[i]);
		}

		//Object[] tempArr = addObj(,)	
		
	}
	
	public static void delete(String response) {
		for(Person p : personList) {
			if(p.getContact().getTelephone().toLowerCase().equals(response.replaceAll("[^0-9]","").toLowerCase())) {
				removePerson(personList,p);
				break;
			}
		}
		
		for(int i = 0 ; i < personList.length; i++) {
			System.out.println(personList[i]);
		}
	}
	
	public static void search(String response, int opt) {
		Person[] searchList = new Person[0];
		
		
		
		for(Person p : personList) {
			//System.out.println(p.getFirstName().toLowerCase().contains(response.toLowerCase()));
			if(opt == 2 && p.getFirstName().toLowerCase().contains(response.toLowerCase())) {
				searchList = addPerson(searchList,p);
			}
			
			if(opt == 3 && p.fullName().toLowerCase().contains(response.toLowerCase())) {
				searchList = addPerson(searchList,p);
			}
			
			if(opt == 4 && p.getContact().getTelephone().toLowerCase().contains(response.toLowerCase())) {
				searchList = addPerson(searchList,p);
			}
			
			if(opt == 5) {
				boolean isStateCity = false;
				if(response.length() == 2) {
					isStateCity  = p.getAddress().getState().toLowerCase().contains(response.toLowerCase());
				} else {
					isStateCity = p.getAddress().getCity().toLowerCase().contains(response.toLowerCase());
				}
				if(isStateCity) {
					searchList = addPerson(searchList,p);
				}
				
			}
		
		}
		
		
		sortPersonList(searchList);
		System.out.println(header);
		
		//System.out.println(personList.length);
		
		//Arrays.sort(personList);
		//sortPersonList()
		 for(int i = 0 ; i < searchList.length;i++) {
			  System.out.println(searchList[i]);
			  
		 }
		
		

		
	}
	
	
	public static void sortPersonList(Person[] sortList) {
		Arrays.sort(sortList, Collections.reverseOrder(new Comparator<Person>() {
		    @Override
		    public int compare(Person a1, Person a2) {
		    	return -1* a1.fullName().compareTo(a2.fullName());
		    }
		}));

	}
	
	
	
	public static Person setPerson(String response) {
		Person person;
		String[] data = response.split(",");
		
		for(int i = 1; i < data.length;i++) {
			data[i] = data[i].substring(1);
		}
		String[] personData = new String[0];
		Address addr = null;
		Contact contact = null ;
		try {
			personData = data[0].split(" ");
			addr = new Address(data[1], data[2], data[3], data[4]);
		    contact = new Contact(data[5]);
		} catch(Exception e) {
			System.out.println("Please enter valid data");
			return null;
		}
		
		
		/*
		 * for(int i = 0 ; i < data.length; i++) { System.out.println(data[i]); }
		 */
		
		if(personData.length == 2) {
			person = new Person(personData[0],personData[1]);
		} else {
			person = new Person(personData[0],personData[1],personData[2]);
		}
		
		person.setAddress(addr);
		person.setContact(contact);
		
		return person;
	}

	public static Person[] addPerson(Person[] a, Person b) {
		
		Person[] result =  new Person[a.length + 1];
		System.arraycopy(a, 0, result, 0, a.length);
		result[result.length-1] = b;
		
		return result;
		
	} 

	public static void removePerson(Person [] arr, Person obj) {
		int index = getIndexObj(arr,obj);
		Person[] result =  new Person[arr.length - 1];
		System.arraycopy(arr, 0, result, 0, arr.length-1);
		int count = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(i != index) {
				result[count] = arr[i];
				count ++;
			}
		}
		
		personList = result;
		
		
		
	}
	
	public static int getIndexObj(Object[] arr, Object obj) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].toString().equals(obj.toString())) return i;
		}
		
		return -1;
	}
	
}
