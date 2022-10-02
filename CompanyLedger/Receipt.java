public class Receipt {

	int quantity;
	double price;
	
	/**
	 * the Receipt class establishes the receipt 
	 * of wood purchased by True Lumber Company
	 * @param quantity
	 * @param price
	 */
	public Receipt(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}
	
	/**
	 * getQuantity 
	 * @return the quantity wood purchased
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * getPrice
	 * @return the price per unit of wood
	 */
	public double getPrice() {
		return price;
	}
	
	
}
