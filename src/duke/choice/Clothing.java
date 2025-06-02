/**
 * 
 */
package duke.choice;

/**
 * @author MANJU
 *
 */
public class Clothing {

	private String description;

	private double price;

	private String size = "M";

	public final double MINIMUM_PRICE = 10;

	public final double TAX = 0.2;

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
		return price+price*TAX;
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

}
