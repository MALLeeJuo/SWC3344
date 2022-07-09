package hypermarket;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class Counter {

    private JTable table1;
    private JTable table2;
    private JTable table3;
    private DefaultTableModel tablemodel_counter1;
    private DefaultTableModel tablemodel_counter2;
    private DefaultTableModel tablemodel_counter3;
    private LinkedList<CustomerInformation> queue1;
    private LinkedList<CustomerInformation> queue2;
    private LinkedList<CustomerInformation> queue3;
    private ArrayList<ItemInformation> purchasedItem;
    private CustomerInformation customer;
    private int count;
    private int currentQue;
    private int currentIndex;
	
	
Counter(LinkedList<CustomerInformation> counter1,LinkedList<CustomerInformation> counter2,LinkedList<CustomerInformation> counter3,int count){
		
	counter();
	this.queue1 = counter1;
	this.queue2 = counter2;
	this.queue3 = counter3;
	refresh();
    this.count = 1;
}

public void counter() {

    JFrame frmCounterCustomerInfo = new JFrame();
    frmCounterCustomerInfo.setResizable(false);
    frmCounterCustomerInfo.setPreferredSize(new Dimension( 1020, 1020 ));
    JPanel panel = new JPanel();
    panel.setBackground(SystemColor.textHighlight);
    panel.setLayout(null);
    frmCounterCustomerInfo.setLocation(new Point(10, 10));
    frmCounterCustomerInfo.getContentPane().add(panel);
		
    JButton btnPay = new JButton("Pay");
    btnPay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
    btnPay.setBackground(SystemColor.inactiveCaption);
    btnPay.addActionListener(new ActionListener() {
        @Override
	public void actionPerformed(ActionEvent e) {
               Pay pay = new Pay(customer); 	
	}
    });
                
    btnPay.setBounds(551, 135, 185, 40);
    panel.add(btnPay);
		
    JLabel title = new JLabel("Queue Counter");
    title.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 36));
    title.setForeground(Color.BLACK);
    title.setBounds(226, 0, 263, 51);
    panel.add(title);

    JLabel lblCounter1 = new JLabel("Counter 1");
    lblCounter1.setForeground(Color.BLACK);
    lblCounter1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
    lblCounter1.setBounds(27, 41, 139, 40);
    panel.add(lblCounter1);
		
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(27, 77, 501, 161);
    panel.add(scrollPane);
		
    String column_names[]= {"Customer ID","Total item","Total Price"};
    tablemodel_counter1 =new DefaultTableModel(column_names,0);
		
    String column_names_counter_2[]= {"Customer ID","Total Items","Total Price"};
    tablemodel_counter2 = new DefaultTableModel(column_names_counter_2,0);
		
    String column_names_counter_3[]= {"Customer ID","Total Items","Total Price"};
    tablemodel_counter3 = new DefaultTableModel(column_names_counter_3,0);
		
    table1 = new JTable(tablemodel_counter1);
    table1.setRowSelectionAllowed(false);
    table1.addMouseListener(
    new java.awt.event.MouseAdapter(){         
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e){
                        
            int indexNumber = table1.getSelectedRow();
            int row =table1.rowAtPoint(e.getPoint());
            int column = table1.columnAtPoint(e.getPoint());
            customer = queue1.get(indexNumber);
            currentQue = 1;
            currentIndex = indexNumber;
                        
        }
    });
                
    scrollPane.setViewportView(table1);
		
    JLabel lblCounter = new JLabel("Counter 2");
    lblCounter.setForeground(Color.BLACK);
    lblCounter.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
    lblCounter.setBounds(27, 249, 139, 40);
    panel.add(lblCounter);
		
    JScrollPane scrollPaneCounter2 = new JScrollPane();
    scrollPaneCounter2.setBounds(27, 300, 501, 180);
    panel.add(scrollPaneCounter2);
		

    table2 = new JTable(tablemodel_counter2);
    table2.setRowSelectionAllowed(false);
    table2.addMouseListener(
    new java.awt.event.MouseAdapter(){
                    
        public void mouseClicked(java.awt.event.MouseEvent e){
                        
            int indexNumber = table2.getSelectedRow();	
            int row =table2.rowAtPoint(e.getPoint());
            int column = table2.columnAtPoint(e.getPoint());		
            customer = queue2.get(indexNumber);
            currentQue = 2;
            currentIndex = indexNumber;
                        
        }  
    });
                
    scrollPaneCounter2.setViewportView(table2);

    JLabel lblCounter_2 = new JLabel("Counter 3");
    lblCounter_2.setForeground(Color.BLACK);
    lblCounter_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
    lblCounter_2.setBounds(27, 491, 139, 40);
    panel.add(lblCounter_2);

    JScrollPane scrollPaneCounter3 = new JScrollPane();
    scrollPaneCounter3.setBounds(27, 542, 501, 180);
    panel.add(scrollPaneCounter3);
		
    table3 = new JTable(tablemodel_counter3);
    table3.setRowSelectionAllowed(false);
    table3.addMouseListener(
                        
    new java.awt.event.MouseAdapter(){
        public void mouseClicked(java.awt.event.MouseEvent e){
                        
            int indexNumber = table3.getSelectedRow();			
            int row=table3.rowAtPoint(e.getPoint());
            int column= table3.columnAtPoint(e.getPoint());
            customer = queue3.get(indexNumber);
            currentQue = 3;
            currentIndex = indexNumber;              
        }              
    });
                
    scrollPaneCounter3.setViewportView(table3);
	
		
    JButton btnLoadFile = new JButton("Import customer");
    btnLoadFile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
    btnLoadFile.setBackground(SystemColor.inactiveCaption);
    btnLoadFile.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            importFile();		
        }
    });
                
    btnLoadFile.setBounds(551, 84, 185, 40);
    panel.add(btnLoadFile);
    frmCounterCustomerInfo.setSize(new Dimension(762, 780));
    frmCounterCustomerInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
    frmCounterCustomerInfo.setVisible(true);
                
}
        
	public void refresh() {
            
            this.tablemodel_counter1.setRowCount(0);
            this.tablemodel_counter2.setRowCount(0);
            this.tablemodel_counter3.setRowCount(0);
                
		for(int num=0; num < this.queue1.size(); num++)
		{
                    CustomerInformation custInfo = this.queue1.get(num);
                    this.tablemodel_counter1.addRow(new Object[]{custInfo.getCustName(), custInfo.totalItem(), String.format("%.2f",custInfo.totalPay())});
  		
		}
                
                for(int num=0; num < this.queue2.size(); num++){
                    
                    CustomerInformation custInfo = this.queue2.get(num);
                    this.tablemodel_counter2.addRow(new Object[]{custInfo.getCustName(), custInfo.totalItem(), String.format("%.2f",custInfo.totalPay())});

		}
                
                for(int num=0; num < this.queue3.size(); num++){
                    
		CustomerInformation custInfo = this.queue3.get(num);
		this.tablemodel_counter3.addRow(new Object[]{custInfo.getCustName(), custInfo.totalItem(), String.format("%.2f",custInfo.totalPay())});
                
                }
        
	} 
	
	public void importFile() {
	    try {

		FileReader file = new FileReader("Customer.txt");
		Scanner myReader = new Scanner(file);
		
		boolean begin = false;	
		String stage = "";
		String currentCustomer = "";
	                
		while (myReader.hasNextLine()) {
	    String data = myReader.nextLine();
			       
	            if(begin == false) {
	                
	                stage = "getCustomerDetail";
	                begin = true;
	                purchasedItem = new ArrayList<ItemInformation>();
	                
	            }else {
	                        
			if(data.equals("CustomerInfo")) {
			        		
			//second customer
			String[] customerInfo = currentCustomer.split(";");
			String defcustomerName = "";
			String defcustomerIC = "";
	                                        
			//split customer
			for (String custinfo : customerInfo) {
	                    String[] keyValueItem = custinfo.split(":");

	                    if(keyValueItem[0].equals("IC")) {
	                        defcustomerName = keyValueItem[1]; 
	                    }
	                }
			        		
			        		
			//split current customer	        		
			CustomerInformation cust = new CustomerInformation();
	        cust.getItemList((ArrayList<ItemInformation>) purchasedItem);
			cust.setCustName(defcustomerName);
			        		
			int totalItem = cust.totalItem();
	                        
			if(totalItem <= 5) {
				
	                if(this.count == 1) {
	                        
	                        queue1.add(cust);
			        this.count = 2;    
	                        
	                }else if(this.count == 2) { 
	                    
	                        queue2.add(cust);
	                        this.count = 1;
	                }
	                }else{
	                    
	                    queue3.add(cust);  			
			}
	                stage = "getCustomerDetail";
	                purchasedItem = new ArrayList<ItemInformation>();
			        		
			}else {
	                    
	                    if(stage.equals("getCustomerDetail")) {
	                                
			        currentCustomer = data;
			        stage = "getItemInfo";
			        			
			    }else if(stage.equals("getItemInfo")) {
			        						
			        String[] detailItem = data.split(";");
			        String ItemName = "";
			        int Quantity = 0;
			        float UnitPrice = 0;
			        			
			        for (String item : detailItem) {
	                            String[] keyValueItem = item.split(":");
	                                    
	                            if(keyValueItem[0].equals("ITEM")) {
	                                 ItemName = keyValueItem[1];
	                            }
	                            if(keyValueItem[0].equals("QTY")) {
	                                Quantity = Integer.valueOf(keyValueItem[1]);
	                            }
	                            if(keyValueItem[0].equals("RM")) {
	                                UnitPrice = Float.valueOf(keyValueItem[1]);
	                            }				
			        }
	                                
	                        ItemInformation ItemInfo = new ItemInformation();
	                        ItemInfo.setItemName(ItemName);
	                        ItemInfo.setItemPrice(UnitPrice);
	                        ItemInfo.setItemQuantity(Quantity);
				       			
	                        purchasedItem.add(ItemInfo);	

	                    }	
	                }
	            }
	            }
	                    
	            if(begin == true) {
	                        
			String[] customerInfo = currentCustomer.split(";");
		        String defcustomerName = "";
	                        
		        for (String i : customerInfo) {
	                    String[] keyValueItem = i.split(":");
	                    if(keyValueItem[0].equals("IC")) {
	                        defcustomerName = keyValueItem[1];
	                    }
	                }
		        		
	        	CustomerInformation cust = new CustomerInformation();
	        	cust.getItemList(purchasedItem);
	        	cust.setCustName(defcustomerName);
	        		
	        	int totalItem = cust.totalItem();
	        	if(totalItem <= 5) {

	                    if(this.count == 1) {    
	                        
	                        queue1.add(cust);
	                        this.count = 2;    
	                        
	                    }else if(this.count == 2) {   
	                        
	        		queue2.add(cust);
	                        this.count = 1;
	                    }
	        			
	                }else{
	                    
	                    queue3.add(cust);

	        	}
	            }
	            
	            myReader.close();           
	        } catch (FileNotFoundException e) {
	        }
	            refresh();
		}

            
	}


