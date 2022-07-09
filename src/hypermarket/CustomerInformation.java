package hypermarket;

import java.util.ArrayList;

public class CustomerInformation {
 
	String custID;
	String custIC;
	String custName;
	String counterPaid;
	float totalPayment;
	ArrayList<ItemInformation> itemInfo;
	
	public String getCustID() {
		return custID;
	}
	public String getCustIC() {
		return custIC;
	}
	public String getCounterPaid() {
		return counterPaid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public void setCustIC(String custIC) {
		this.custIC = custIC;
	}
	public void setCounterPaid(String counterPaid) {
		this.counterPaid = counterPaid;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public void getItemList(ArrayList<ItemInformation> itemInfomation) {		
		this.itemInfo = itemInfomation;		
	}
	public ArrayList<ItemInformation> sendItemList() {
		return this.itemInfo;
	}
	public int totalItem() {
		return this.itemInfo.size();
	}
	public float totalPay() {
		totalPayment = 0;
		for (int counter = 0; counter < this.itemInfo.size(); counter++) { 		      
			ItemInformation pr = this.itemInfo.get(counter);
			totalPayment = totalPayment + pr.getItemPrice();
		}  
		return totalPayment;
	}
}