/**
 * 
 */
package duke.choice;

/**
 * @author MANJU
 *
 */
public class Clothing implements Comparable<Clothing> {

	private String description;

	private double price;

	private String size = "M";

	public final static double MINIMUM_PRICE = 10;

	public final static double TAX_RATE = 0.2;

	/**
	 * @param description
	 * @param price
	 */
	public Clothing(String description, double price, String size) {
		this.description = description;
		this.price = price;
		this.size = size;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price + price * TAX_RATE;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = (price > MINIMUM_PRICE) ? price : MINIMUM_PRICE;
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

	@Override
	public String toString() {
		return getDescription() + ", " + getPrice() + ", " + getSize();
	}

	@Override
	public int compareTo(Clothing clothObj) {
		// TODO Auto-generated method stub
		return this.description.compareTo(clothObj.description);
	}
}
