package PhoneBook;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Application {
	private static String[] menus = {"Add new entries","Search by first name *","Search by full name *",
			"Search by telephone number","Search by city or state","Delete a record for a given telephone number","Update a record for a given telephone number",
			"Exit"};
	private static String[] personMenus = {"Update Name","Update Middle Name","Update Last Name","Update Address","Update Telephone",
			"Exit"};
	
	private static String[] addressMenus = {"Update Street","Update City","Update State","Update Zipcode",
	"Exit"};
	
	
	private static Person[] personList = new Person[0];
	
	public static void main(String args[]) {
		
		String[] str = {"John Doe, 114 Market St, St Louis, MO, 63403, 6366435698", "John All, 324 Main St, St Charles, MO,63303, 8475390126", "Jake Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375"};
		
		for(int i = 0; i < str.length; i++) {
			redirect(1,str[i]);
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Screen());
		int option = sc.nextInt();
		sc.nextLine();
		String response = "";
		//System.out.flush();

		while(option != menus.length) {
			
			//Getting option
			System.out.println(Option(option,"mainMenu"));
			response = sc.nextLine();
			
			
			redirect(option,response);
			
			
			//Menus
			System.out.println(Screen());
			option = sc.nextInt();
			sc.nextLine();
			//sc.next();
			
		}
		
		
		
		
		
	}
	
	public static String Screen() {
		String printMenus = "Please enter an option...\n";
		for(int i = 0 ; i < menus.length; i++) {
			String menu  = (i+1) + ")" + menus[i];
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
		
		
		return "";
		
	}
	
	public static void redirect(int option, String response) {
		switch(option) {
		case 1 : addEntry(response); break;
		case 2 : search(response,option);break;
		case 3 : search(response,option);break;
		case 4 : search(response,option);break;
		case 5 : search(response,option);break;
		case 6 : delete(response); break;
		case 7 : update(response); break;
		default : break;
		}
	}
	
	
	public static void update(String response) {
		
	}
	
	
	public static void addEntry(String response) {
		
		Person person = setPerson(response);
		Object[] tempArr = addObj(personList,person);
		personList = new Person[tempArr.length];
		
		System.arraycopy(tempArr, 0, personList, 0, tempArr.length);
		
		System.out.println(personList.length);
		for(int i = 0 ; i < personList.length; i++) {
			System.out.println(personList[i]);
		}

		//Object[] tempArr = addObj(,)	
		
	}
	
	public static void delete(String response) {
		Object[] tempArr = new Object[0];
		for(Person p : personList) {
			if(p.getContact().getTelephone().toLowerCase().equals(response.toLowerCase())) {
				tempArr = removeObj(personList,p);
				personList = new Person[tempArr.length];
				System.arraycopy(tempArr, 0, personList, 0, tempArr.length);
				break;
			}
		}
		
		for(int i = 0 ; i < personList.length; i++) {
			System.out.println(personList[i]);
		}
	}
	
	public static void search(String response, int opt) {
		Person[] searchList = new Person[0];
		Object[] tempArr = new Object[0];
		
		
		for(Person p : personList) {
			//System.out.println(p.getFirstName().toLowerCase().contains(response.toLowerCase()));
			if(opt == 2 && p.getFirstName().toLowerCase().contains(response.toLowerCase())) {
				tempArr = addObj(searchList,p);
				searchList = new Person[tempArr.length];
				System.arraycopy(tempArr, 0, searchList, 0, tempArr.length);
			}
			
			if(opt == 3 && p.fullName().toLowerCase().contains(response.toLowerCase())) {
				tempArr = addObj(searchList,p);
				searchList = new Person[tempArr.length];
				System.arraycopy(tempArr, 0, searchList, 0, tempArr.length);
			}
			
			if(opt == 4 && p.getContact().getTelephone().toLowerCase().contains(response.toLowerCase())) {
				tempArr = addObj(searchList,p);
				searchList = new Person[tempArr.length];
				System.arraycopy(tempArr, 0, searchList, 0, tempArr.length);
			}
			
			if(opt == 5) {
				boolean isStateCity = false;
				if(response.length() == 2) {
					isStateCity  = p.getAddress().getState().toLowerCase().contains(response.toLowerCase());
				} else {
					isStateCity = p.getAddress().getCity().toLowerCase().contains(response.toLowerCase());
				}
				if(isStateCity) {
					tempArr = addObj(searchList,p);
					searchList = new Person[tempArr.length];
					System.arraycopy(tempArr, 0, searchList, 0, tempArr.length);
				}
				
			}
		
		}
		
		
		
		
		Arrays.sort(personList, Collections.reverseOrder(new Comparator<Person>() {
		    @Override
		    public int compare(Person a1, Person a2) {

		    	
		    	if(opt == 2) {
		    		return a1.getFirstName().compareTo(a2.getFirstName());
		    	}
		    	else if(opt == 3){
		    		return a1.fullName().compareTo(a2.fullName());
		    	} 
		    	else if(opt == 4) {
		    		return a1.getContact().getTelephone().compareTo(a2.getContact().toString());
		    	} else if(opt == 5) {
		    		if(response.length() == 2) {
						return a1.getAddress().getState().compareTo(a2.getAddress().getState());
					} else {
						return a1.getAddress().getCity().compareTo(a2.getAddress().getCity());
					}
		    	}
		    	
		    	else {
		    		return 0;
		    	}
		    	
			        
		        
		    }
		}));
		
		//Arrays.sort(personList);
		
		
		for(int i = searchList.length - 1; i >= 0; i--) {
			System.out.println(searchList[i]);
		}
		
		//for(Person p : searchList) { System.out.println(p.toString()); }
		 
		
	}
	
	
	
	public static Person setPerson(String response) {
		Person person;
		String[] data = response.split(",");
		
		for(int i = 1; i < data.length;i++) {
			data[i] = data[i].substring(1);
		}
		
		String[] personData = data[0].split(" ");
		Address addr = new Address(data[1], data[2], data[3], data[4]);
		Contact contact = new Contact(data[5]);
		
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

	public static Object[] addObj(Object[] a, Object b) {
		
		Object[] result =  new Object[a.length + 1];
		System.arraycopy(a, 0, result, 0, a.length);
		result[result.length-1] = b;
		return result;
	} 

	public static Object[] removeObj(Object[] arr, Object obj) {
		int index = getIndexObj(arr,obj);
		Object[] result =  new Object[arr.length - 1];
		System.arraycopy(arr, 0, result, 0, arr.length-1);
		int count = 0;
		for(int i = 0 ; i < arr.length; i++) {
			if(i != index) {
				result[count] = arr[i];
				count ++;
			}
		}
		
		
		return result;
	}
	
	public static int getIndexObj(Object[] arr, Object obj) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].toString().equals(obj.toString())) return i;
		}
		
		return -1;
	}
	
}
