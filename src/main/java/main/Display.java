package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Display extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // Runnable là lớp mở giao diện
			public void run() {
				try {
					Display frame = new Display();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_hourCheckIn;
	private JTextField textField_distance;
	private JTextField textField_minuteAwaiting;

	public Display() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Lexus Taxi Service (Calculation)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 0, 296, 58);
		contentPane.add(lblNewLabel);

		JLabel lblTheHourCheckin = new JLabel("Time get-in taxi (hour)");
		lblTheHourCheckin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheHourCheckin.setBounds(20, 48, 178, 29);
		contentPane.add(lblTheHourCheckin);

		JLabel lblTheAmountOf = new JLabel("The distance (km)");
		lblTheAmountOf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheAmountOf.setBounds(20, 112, 178, 29);
		contentPane.add(lblTheAmountOf);

		JLabel lblTheAmountOf_2 = new JLabel("The waiting time (minute)");
		lblTheAmountOf_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheAmountOf_2.setBounds(20, 192, 195, 29);
		contentPane.add(lblTheAmountOf_2);

		JLabel lblTheAmountOf_2_1 = new JLabel("The amount of passengers");
		lblTheAmountOf_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheAmountOf_2_1.setBounds(20, 277, 195, 29);
		contentPane.add(lblTheAmountOf_2_1);

		JRadioButton rdbtn_oneTimePassenger = new JRadioButton("One-time passengers");
		rdbtn_oneTimePassenger.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn_oneTimePassenger.setBounds(20, 443, 178, 29);
		contentPane.add(rdbtn_oneTimePassenger);

		JRadioButton rdbtn_RegularClients = new JRadioButton("Regular Clients");
		rdbtn_RegularClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn_RegularClients.setBounds(20, 480, 178, 29);
		contentPane.add(rdbtn_RegularClients);

		ButtonGroup btGroup = new ButtonGroup();
		btGroup.add(rdbtn_RegularClients);
		btGroup.add(rdbtn_oneTimePassenger);

		JLabel totalFee = new JLabel("");
		totalFee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalFee.setBounds(123, 277, 119, 29);
		contentPane.add(totalFee);

		textField_hourCheckIn = new JTextField();
		textField_hourCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_hourCheckIn.setBounds(20, 84, 239, 29);
		contentPane.add(textField_hourCheckIn);
		textField_hourCheckIn.setColumns(10);

		textField_distance = new JTextField();
		textField_distance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_distance.setColumns(10);
		textField_distance.setBounds(20, 152, 239, 29);
		contentPane.add(textField_distance);

		textField_minuteAwaiting = new JTextField();
		textField_minuteAwaiting.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_minuteAwaiting.setColumns(10);
		textField_minuteAwaiting.setBounds(20, 232, 239, 29);
		contentPane.add(textField_minuteAwaiting);

		JComboBox comboBox_noPassenger = new JComboBox();
		comboBox_noPassenger.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_noPassenger.setBounds(20, 317, 239, 29);

		for(int i = 1; i <= 7; i++) {
			comboBox_noPassenger.addItem(i);
		}
		comboBox_noPassenger.setSelectedIndex(-1);
		contentPane.add(comboBox_noPassenger);

		JLabel lblTheAmountOf_2_1_2 = new JLabel("The amount of children");
		lblTheAmountOf_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheAmountOf_2_1_2.setBounds(20, 362, 195, 29);
		contentPane.add(lblTheAmountOf_2_1_2);

		JComboBox comboBox_noChildren = new JComboBox();
		comboBox_noChildren.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_noPassenger.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_noPassenger.getSelectedIndex() != -1) {
					comboBox_noChildren.removeAllItems();
					int noPassengers = Integer.valueOf(comboBox_noPassenger.getSelectedItem().toString());
					for(int i = 0; i < noPassengers; i++) {
						comboBox_noChildren.addItem(i);
					}
				}
			}
		});

		comboBox_noChildren.setBounds(20, 407, 239, 29);

		JLabel lbl_totalFare = new JLabel("");
		lbl_totalFare.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_totalFare.setBounds(117, 516, 165, 29);
		contentPane.add(lbl_totalFare);


		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Taxi taxi = new Taxi();
				taxi.setHourCheckIn(Integer.valueOf(textField_hourCheckIn.getText().toString()));
				taxi.setDistance(Double.valueOf(textField_distance.getText().toString()));
				taxi.setMinuteAwaiting(Integer.valueOf(textField_minuteAwaiting.getText().toString()));
				taxi.setNoPassenger(Integer.valueOf(comboBox_noPassenger.getSelectedItem().toString()));
				taxi.setNoChildren(Integer.valueOf(comboBox_noChildren.getSelectedItem().toString()));
				if(rdbtn_oneTimePassenger.isSelected()) {
					taxi.setPassengerType(true);
				}
				if(rdbtn_RegularClients.isSelected()) {
					taxi.setPassengerType(false);
				}
				TaxiProcess taxiProcess = new TaxiProcess();
				lbl_totalFare.setText(taxiProcess.calculateTotalFee(taxi).toString());

			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 556, 128, 38);
		contentPane.add(btnNewButton);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnCancel.setBounds(154, 556, 128, 38);
		contentPane.add(btnCancel);
		contentPane.add(comboBox_noChildren);

		JLabel lblTheAmountOf_2_1_2_1 = new JLabel("Total (RM):");
		lblTheAmountOf_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheAmountOf_2_1_2_1.setBounds(20, 516, 103, 29);
		contentPane.add(lblTheAmountOf_2_1_2_1);

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_hourCheckIn.setText("");
				textField_distance.setText("");
				textField_minuteAwaiting.setText("");
				comboBox_noPassenger.setSelectedIndex(-1);
				comboBox_noChildren.setSelectedIndex(-1);
				btGroup.clearSelection();

			}
		});

	}
}
