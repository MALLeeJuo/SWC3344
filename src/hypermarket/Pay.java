package hypermarket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Pay {
    
	private JTextField txtPayment;
	private DefaultTableModel table_model;
	private JLabel lblSubBalanceOutput;
	private JLabel lblSubTotalOutput;
	private Float balancePayment;
	private CustomerInformation customerInfo;

	Pay(CustomerInformation customer){	
	
            this.customerInfo = customer;
            PayUI();
	}
	
	public void PayUI() {
            JFrame framePayment = new JFrame();
            framePayment.setResizable(false);
            JPanel panel = new JPanel();
            panel.setBackground(SystemColor.textHighlight);
            panel.setLayout(null);
            framePayment.setTitle("Payment");
		
            framePayment.getContentPane().add(panel);
            JLabel lblSubTotal = new JLabel("Sub Total :");
            lblSubTotal.setForeground(Color.BLACK);
            lblSubTotal.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
            lblSubTotal.setBounds(44, 22, 146, 38);
            panel.add(lblSubTotal);
		
		
            JLabel lblPayAmount = new JLabel("Pay Amount");
            lblPayAmount.setForeground(Color.BLACK);
            lblPayAmount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
            lblPayAmount.setBounds(44, 71, 146, 41);
            panel.add(lblPayAmount);
            ButtonGroup group = new ButtonGroup();
		
            lblSubTotalOutput = new JLabel(String.valueOf(customerInfo.totalPay()));
            lblSubTotalOutput.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
            lblSubTotalOutput.setBounds(174, 26, 97, 30);
            panel.add(lblSubTotalOutput);
            JButton btnPrintReceipt = new JButton("Pay");
            btnPrintReceipt.setBackground(SystemColor.activeCaption);
            btnPrintReceipt.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 31));
            btnPrintReceipt.setForeground(Color.BLACK);
            btnPrintReceipt.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
				
                    calculateBalance();
                    ArrayList<ItemInformation> itemInfo2 = customerInfo.sendItemList();
				
                    String column_names[]= {"Item","Quantity","Unit Price","Price"};
                    table_model =new DefaultTableModel(column_names,0);
                    for (int counter = 0; counter < itemInfo2.size(); counter++) { 		      
                        // System.out.println(this.itemInfo.get(counter)); 
			ItemInformation pr = itemInfo2.get(counter);
                        table_model.addRow(new Object[]{pr.getItemName(), pr.getItemQuantity(), String.format("%.2f",pr.getItemPrice()),String.format("%.2f",pr.getItemPrice())});		
                    } 	
			Receipt print = new Receipt(table_model,String.valueOf(customerInfo.totalPay()),String.valueOf(customerInfo.totalItem()),lblSubBalanceOutput.getText(),txtPayment.getText());
			framePayment.setVisible(false);
			
		}
		});
            
            btnPrintReceipt.setBounds(44, 224, 227, 55);
            panel.add(btnPrintReceipt);
		
		
            txtPayment = new JTextField();
            txtPayment.setBackground(SystemColor.inactiveCaption);
            txtPayment.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
            txtPayment.setBounds(48, 123, 209, 45);
            panel.add(txtPayment);
            txtPayment.setColumns(10);
		
            framePayment.setTitle("Pay");
            framePayment.setLocation(new Point(500, 300));
            framePayment.getContentPane().add(panel);
		
            JLabel lblSubBalance = new JLabel("Balance :");
            lblSubBalance.setForeground(Color.BLACK);
            lblSubBalance.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
            lblSubBalance.setBounds(44, 179, 120, 38);
            panel.add(lblSubBalance);
		
            lblSubBalanceOutput = new JLabel("0.00");
            lblSubBalanceOutput.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
            lblSubBalanceOutput.setBounds(155, 183, 116, 30);
            panel.add(lblSubBalanceOutput);
            framePayment.setSize(new Dimension(335, 348));
		
            framePayment.setVisible(true);
	}
	
	public void calculateBalance() {
	 
		try {
			balancePayment =  Float.parseFloat(lblSubTotalOutput.getText()) - Float.parseFloat(txtPayment.getText());
			lblSubBalanceOutput.setText(String.format("%.2f",balancePayment));
		}catch (Exception e) {
	    }
	}
}

