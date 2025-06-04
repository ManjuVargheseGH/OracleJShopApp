/**
 * 
 */
package duke.choice;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

/**
 * @author MANJU
 *
 */
public class ShopApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double tax = 0.2;
		double total = 0;
		int measurement = 3;

		System.out.println("Welcome to Duke Choice Shop!");
		System.out.println("Minimun Price is...." + Clothing.MINIMUM_PRICE);
		System.out.println("Tax rate is....." + Clothing.TAX_RATE);

		Customer c1 = new Customer("Pinky", 3);
		c1.setSize("S");
		System.out.println("Good Morning " + c1.getName());

		Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
		Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
		Clothing item3 = new Clothing("Green Scarf", 5, "S");
		Clothing item4 = new Clothing("Blue T-Shirt", 10.5, "S");

		Clothing[] items = { item1, item2, item3, item4 };

		try {
			ItemList list = new ItemList(items);
			Routing routing = Routing.builder().get("/items", list).build();
			ServerConfiguration config = ServerConfiguration.builder()
					.bindAddress(InetAddress.getLocalHost())
					.port(8888).build();
			WebServer ws=WebServer.create(config,routing);
			ws.start();
		} catch (UnknownHostException ex) {
			System.out.println("Unknown host exception"+ex.getMessage());
			ex.printStackTrace();
			// TODO: handle exception
		}

		// item1=makeClothing("Blue Jacket",20.9,"M");
		// item2=makeClothing("Orange T-Shirt",10.5,"S");
		// item3=makeClothing("Green Scarf",5,"S");
		// item4=makeClothing("Blue T-Shirt",10.5,"S");

		displayClothing(item1);
		displayClothing(item2);

		// Clothing array
		// Clothing[] items={item1,item2};
		Clothing[] clothArray = new Clothing[2];
		clothArray[0] = item1;
		clothArray[1] = item2;

		// calculateTotal(tax, total, item1, item2);
		// calculateTotalUsingLoop(tax, total, clothArray);
		// c1.setSize(measurement);
		String custSize = deriveCustomerSize(measurement);
		if (c1.getSize().equals(custSize)) {
			System.out.println("deriveCustomerSize() method returned correct size for the customer");
		} else {
			System.out.println("verify deriveCustomerSize() method");
		}
		System.out.println("Size for the customer " + c1.getName() + " is..." + custSize);

		Clothing[] clothArray1 = new Clothing[4];
		clothArray1[0] = item1;
		clothArray1[1] = item2;
		clothArray1[2] = item3;
		clothArray1[3] = item4;
		c1.addItems(clothArray1);
		for (Clothing eachCloth : clothArray1) {
			System.out.println("ClothArray is...." + eachCloth);
		}
		System.out.println(c1.getTotalClothingCost(clothArray1));
		System.out.println("Average price for all clothing is..." + calculateAvgForClothing(c1));
		System.out.println("Clothing items after sorting");
		Arrays.sort(c1.getItems());
		for (Clothing eachCloth : clothArray1) {
			System.out.println(eachCloth);
		}
		// calculateTotalBasedOnCustomerSize(c1, clothArray1, tax, total);

		// standard for loop demo
//		for(int i=0;i<5;i++) {
//			System.out.print("i is "+i+" ,");
//		}
		// advanced for loop
//		String[] names= {"Mary","Bob","Sarah"};
//		for(String name:names) {
//			System.out.println("\n"+name);
//		}

	}

	private static double calculateAvgForClothing(Customer c1) {
		int total = 0;
		int count = 0;
		for (Clothing eachCloth : c1.getItems()) {
			if (eachCloth.getSize().equals("L")) {
				total = (int) (total + eachCloth.getPrice());
				count++;
			}
		}
		double avg = 0;
		try {
			avg = total / count;
		} catch (ArithmeticException ae) {
			String errMsg = ae.getMessage();
			System.out.println("Error Message:  " + errMsg);
			ae.printStackTrace();
		}
		return avg;
	}

	private static void calculateTotalBasedOnCustomerSize(Customer c1, Clothing[] clothArray, double taxrate,
			double total) {
		// TODO Auto-generated method stub
		System.out.println("******Total when customer size is same******");
		double cost = 0;
		double tax = 0;

		for (Clothing clothing : clothArray) {
			if (c1.getSize().equals(clothing.getSize())) {
				cost = cost + clothing.getPrice();
				tax = tax + clothing.getPrice() * taxrate;
				if (cost > 15) {
					break;
				}
			}
		}
		System.out.println("Amount before tax is..." + cost);
		total = cost + tax;
		System.out.println("Total amount is ...." + total);

	}

	private static void calculateTotalUsingLoop(double taxrate, double total, Clothing[] clothArray) {
		// TODO Auto-generated method stub
		System.out.println("******Inside for each loop******");
		double cost = 0;
		double tax = 0;
		for (Clothing clothing : clothArray) {
			cost = cost + clothing.getPrice();
			tax = tax + clothing.getPrice() * taxrate;
		}
		System.out.println("Amount before tax is..." + cost);
		total = cost + tax;
		System.out.println("Total amount is ...." + total);
	}

	/**
	 * 
	 * @param measurement
	 * @return
	 */
	private static String deriveCustomerSize(int measurement) {
		String custSize = null;
		switch (measurement) {
		case 1:
		case 2:
		case 3:
			custSize = "S";
			break;
		case 4, 5, 6:
			custSize = "M";
			break;
		case 7:
		case 8:
		case 9:
			custSize = "L";
			break;
		default:
			custSize = "XL";
		}
		return custSize;
	}

	/**
	 * 
	 * @param tax
	 * @param total
	 * @param item1
	 * @param item2
	 */
	private static void calculateTotal(double tax, double total, Clothing item1, Clothing item2) {
		double cost = item1.getPrice() + (2 * item2.getPrice());
		System.out.println("Amount before tax is..." + cost);
		total = cost + ((item1.getPrice() * tax) + (2 * (item2.getPrice() * tax)));
		System.out.println("Total amount is ...." + total);
	}

	/**
	 * 
	 * @param item
	 */
	private static void displayClothing(Clothing item) {
		System.out.println(item.getDescription() + ", " + item.getPrice() + ", " + item.getSize());
	}

	/**
	 * 
	 * @param description
	 * @param price
	 * @param size
	 * @return
	 */
	private static Clothing makeClothing(String description, double price, String size) {
		Clothing item = new Clothing(description, price, size);
		// item.setDescription(description);
		// item.setPrice(price);
		// item.setSize(size);
		return item;
	}

}
