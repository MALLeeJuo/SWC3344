package hypermarket;

public class ItemInformation {

	String itemId;
	String itemName;
	float itemPrice;
	String datePurchase;
	int itemQuantity;

	public String getItemId() {
		return itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public float getItemUnitPrice() {
		return itemPrice;
	}
	public float getItemQuantity() {
		return itemQuantity;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
}