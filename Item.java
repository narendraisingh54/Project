package p1;

public class Item {
	
	private String itemId;
	private String name;
	private float price;
	
	public Item() {
		super();
	}

	public Item(String itemId, String name, float price) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", price=" + price + "]";
	}
	

}
