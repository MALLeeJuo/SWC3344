package hypermarket;

import java.util.LinkedList;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class MainGUI {

	private LinkedList<CustomerInformation> counter1;
	private LinkedList<CustomerInformation> counter2;
	private LinkedList<CustomerInformation> counter3;
	private int count;
    private String purchasedItem;
	
	MainGUI(){
		gui();
		count = 1;
}
	
	public void gui() {
		
		counter1 = new LinkedList<CustomerInformation>();
		counter2 = new LinkedList<CustomerInformation>();
		counter3 = new LinkedList<CustomerInformation>();
		
		JFrame frame = new JFrame();
		frame.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setLayout(null);
		
		frame.setTitle("Hypermarket self checkout");
		frame.setLocation(new Point(10, 10));
		frame.getContentPane().add(panel);
		
		JLabel lblPointOfSales = new JLabel("Hypermarket Self Checkout");
		lblPointOfSales.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 36));
		lblPointOfSales.setForeground(Color.BLACK);
		lblPointOfSales.setBounds(98, 11, 497, 79);
		panel.add(lblPointOfSales);
		
		JButton btnQueue = new JButton("Next");
		btnQueue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnQueue.setForeground(SystemColor.inactiveCaptionText);
		btnQueue.setBackground(SystemColor.inactiveCaption);
		btnQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counter ct = new Counter(counter1,counter2,counter3,count);
				frame.setVisible(false);
			}
		});
		
		btnQueue.setBounds(195, 126, 253, 49);
		panel.add(btnQueue);
		
		JLabel lblNewLabel = new JLabel("Next to continue\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(262, 77, 117, 38);
		panel.add(lblNewLabel);
		frame.setSize(new Dimension(688, 240));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);
	}
}