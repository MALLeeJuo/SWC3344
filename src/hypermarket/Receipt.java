package hypermarket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Point;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;

public class Receipt {
	
	private JTable table;
	private DefaultTableModel tablemodel;
	private String subtotal;
	private String balance;
	private String pay;

	Receipt(DefaultTableModel table_model,String subtotalpayment,String totalBalance,String totalPay, String string){
            
            tablemodel = table_model;
            subtotal = subtotalpayment;
            balance = totalBalance;
            pay = totalPay;
		
            ReceiptUI();
            
	}
        
	public void ReceiptUI() {	
            
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setLayout(null);
		frame.setTitle("Print Receipt");
		frame.setLocation(new Point(500, 300));
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Payment Receipt");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(36, 11, 150, 29);
		panel.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(28, 51, 424, 219);
		panel.add(scrollPane);
		
		table = new JTable(tablemodel);
		scrollPane.setViewportView(table);
		
		JLabel lblSubTotal = new JLabel("Sub Total :");
		lblSubTotal.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblSubTotal.setBounds(36, 278, 64, 28);
		panel.add(lblSubTotal);
		
		JLabel lblSubTotalOutput = new JLabel(subtotal);
		lblSubTotalOutput.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblSubTotalOutput.setBounds(105, 281, 64, 22);
		panel.add(lblSubTotalOutput);
		
		JLabel lblTotalPay = new JLabel("Total Pay :");
		lblTotalPay.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblTotalPay.setBounds(36, 306, 69, 28);
		panel.add(lblTotalPay);
		
		JLabel lblBalance_1 = new JLabel("Balance:");
		lblBalance_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblBalance_1.setBounds(31, 341, 69, 16);
		panel.add(lblBalance_1);
		
		JLabel lblTotalPayOutput = new JLabel(pay);
		lblTotalPayOutput.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblTotalPayOutput.setBounds(105, 306, 69, 28);
		panel.add(lblTotalPayOutput);
		
		JLabel lblBalanceOutput = new JLabel(balance);
		lblBalanceOutput.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblBalanceOutput.setBounds(105, 335, 69, 28);
		panel.add(lblBalanceOutput);
		
		frame.setVisible(true);
		
	}
}
