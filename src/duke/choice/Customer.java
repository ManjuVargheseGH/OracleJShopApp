/**
 * 
 */
package duke.choice;

/**
 * @author MANJU
 *
 */
public class Customer {

	private String name;

	private String size;
	
	private Clothing[] items;

	/**
	 * @return the items
	 */
	public Clothing[] getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void addItems(Clothing[] items) {
		this.items = items;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * 
	 * @param measurement
	 */
	public void setSize(int measurement) {
		switch (measurement) {
		case 1:
		case 2:
		case 3:
			setSize("S");
			break;
		case 4, 5, 6:
			setSize("M");
			break;
		case 7:
		case 8:
		case 9:
			setSize("L");
			break;
		default:
			setSize("XL");
		}
	}

	public double getTotalClothingCost(Clothing[] items) {
		System.out.println("******Inside getTotalClothingCost()******");
		double cost=0;
		double tax = 0;
		for (Clothing clothing : items) {
			cost=cost+clothing.getPrice();
			tax=tax+clothing.getPrice()*clothing.TAX;
		}
		System.out.println("Amount before tax is..."+cost);
		return (cost+tax) ;
	}
}
