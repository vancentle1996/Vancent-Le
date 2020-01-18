import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.text.DecimalFormat;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.Image;

public class hairquoter {

	private JFrame frmHairProductsCalculator;
	private JCheckBox standardshipping_checkbox;
	private JCheckBox expressshipping_checkbox;
	private JTextField totalWPaypalFee;
	private JTextField totalQuantity_txtfield;
	private JTextField totalWOPaypalFee;
	private JLabel total_With_Paypal_Label;
	private JLabel total_Without_Paypal_Label;
	private JButton clear_Button;
	private JButton add_Button;
	private JTextField subTotal_txtField;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JComboBox<String>straightLengths;
	private JComboBox<String>straightQuantity;

	// VARIABLES
	final double STANDARD_SHIPPING = 8.0;
	final double EXPRESS_SHIPPING = 24.0;
	double total_With_Shipping, totalWithPaypalFee, totalWithOutPaypalFee, subtotal;
	final double POINT_THREE = 0.30;
	final double PAYPAL_FEE = 1.03;

	// Variables that store users' parsed inputs (e.g., string -> integer)
	int  quantity_Of_Straight, quantity_Of_Loose, quantity_Of_Body, quantity_Of_Deep, quantity_Of_Rare, quantity_Of_Steam1, quantity_Of_Steam2, quantity_Of_Blonde, quantity_Of_Grey,
	quantity_Of_StraightClosure, quantity_Of_LooseClosure, quantity_Of_BodyClosure, quantity_Of_DeepClosure, quantity_Of_RareClosure, quantity_Of_Steam1Closure, quantity_Of_Steam2Closure, 
	quantity_Of_BlondeClosure, quantity_Of_GreyClosure, quantity_Of_StraightFrontal, quantity_Of_LooseFrontal, quantity_Of_BodyFrontal, quantity_Of_DeepFrontal, quantity_Of_RareFrontal, 
	quantity_Of_Steam1Frontal, quantity_Of_Steam2Frontal, quantity_Of_BlondeFrontal, quantity_Of_GreyFrontal, quantity_Counter;

	// Variables that store the price of each pattern 
	double straight, loose, body, deep, rare, steam1, steam2, blonde, grey, straightClosure, looseClosure, bodyClosure, deepClosure, rareClosure, steam1Closure, steam2Closure, blondeClosure, 
	greyClosure, straightFrontal, looseFrontal, bodyFrontal, deepFrontal, rareFrontal, steam1Frontal, steam2Frontal, blondeFrontal,greyFrontal;
	
	String straightString = "Straight\n";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hairquoter window = new hairquoter();
					window.frmHairProductsCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hairquoter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHairProductsCalculator = new JFrame();
		frmHairProductsCalculator.setResizable(false);
		frmHairProductsCalculator.setFont(new Font("Arial Black", Font.BOLD, 13));
		frmHairProductsCalculator.setForeground(Color.BLACK);
		frmHairProductsCalculator.setTitle("Hair Extensions Calculator");
		frmHairProductsCalculator.getContentPane().setBackground(new Color(192, 192, 192));
		frmHairProductsCalculator.getContentPane().setEnabled(false);
		frmHairProductsCalculator.getContentPane().setSize(new Dimension(5, 5));
		frmHairProductsCalculator.setBackground(new Color(255, 255, 255));
		frmHairProductsCalculator.setBounds(350, 350, 700, 750);
		frmHairProductsCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHairProductsCalculator.getContentPane().setLayout(null);

		// LABELS
		JLabel pattern_Label = new JLabel("PATTERN");
		pattern_Label.setHorizontalTextPosition(SwingConstants.CENTER);
		pattern_Label.setBackground(Color.WHITE);
		pattern_Label.setFont(new Font("Century", Font.BOLD, 13));
		pattern_Label.setBounds(28, 11, 86, 14);
		frmHairProductsCalculator.getContentPane().add(pattern_Label);

		JLabel length_Label = new JLabel("LENGTH");
		length_Label.setFont(new Font("Century", Font.BOLD, 13));
		length_Label.setBounds(210, 11, 86, 14);
		frmHairProductsCalculator.getContentPane().add(length_Label);

		JLabel quantity_Label = new JLabel("QUANTITY");
		quantity_Label.setFont(new Font("Century", Font.BOLD, 13));
		quantity_Label.setBounds(315, 11, 101, 14);
		frmHairProductsCalculator.getContentPane().add(quantity_Label);

		JLabel straight_Label = new JLabel("Straight");
		straight_Label.setBounds(28, 35, 48, 14);
		frmHairProductsCalculator.getContentPane().add(straight_Label);

		JLabel loose_Label = new JLabel("Loose Wave");
		loose_Label.setBounds(28, 60, 86, 14);
		frmHairProductsCalculator.getContentPane().add(loose_Label);

		JLabel body_Label = new JLabel("Body Wave");
		body_Label.setBounds(28, 85, 86, 14);
		frmHairProductsCalculator.getContentPane().add(body_Label);

		JLabel deep_Label = new JLabel("Deep Wave");
		deep_Label.setBounds(28, 110, 86, 14);
		frmHairProductsCalculator.getContentPane().add(deep_Label);

		JLabel rare_Label = new JLabel("Rare Curly");
		rare_Label.setBounds(28, 135, 86, 14);
		frmHairProductsCalculator.getContentPane().add(rare_Label);

		JLabel steam1_Label = new JLabel("Steam #1");
		steam1_Label.setBounds(28, 160, 86, 14);
		frmHairProductsCalculator.getContentPane().add(steam1_Label);

		JLabel steam2_Label = new JLabel("Steam #2");
		steam2_Label.setBounds(28, 185, 86, 14);
		frmHairProductsCalculator.getContentPane().add(steam2_Label);

		JLabel blonde_Label = new JLabel("Straight Blonde");
		blonde_Label.setBounds(28, 210, 125, 14);
		frmHairProductsCalculator.getContentPane().add(blonde_Label);

		JLabel grey_Label = new JLabel("Grey");
		grey_Label.setBounds(28, 235, 86, 14);
		frmHairProductsCalculator.getContentPane().add(grey_Label);

		JLabel looseClosure_Label = new JLabel("Loose Wave Closure");
		looseClosure_Label.setBounds(28, 286, 125, 14);
		frmHairProductsCalculator.getContentPane().add(looseClosure_Label);

		JLabel bodyClosure_Label = new JLabel("Body Wave Closure");
		bodyClosure_Label.setBounds(28, 311, 143, 14);
		frmHairProductsCalculator.getContentPane().add(bodyClosure_Label);

		JLabel deepClosure_Label = new JLabel("Deep Wave Closure");
		deepClosure_Label.setBounds(28, 336, 125, 14);
		frmHairProductsCalculator.getContentPane().add(deepClosure_Label);

		JLabel rareClosure_Label = new JLabel("Rare Curly Closure");
		rareClosure_Label.setBounds(28, 361, 125, 14);
		frmHairProductsCalculator.getContentPane().add(rareClosure_Label);

		JLabel steam1Closure_Label = new JLabel("Steam #1 Closure");
		steam1Closure_Label.setBounds(28, 386, 125, 14);
		frmHairProductsCalculator.getContentPane().add(steam1Closure_Label);

		JLabel steam2Closure_Label = new JLabel("Steam #2 Closure");
		steam2Closure_Label.setBounds(28, 411, 111, 14);
		frmHairProductsCalculator.getContentPane().add(steam2Closure_Label);

		JLabel blondeClosure_Label = new JLabel("Straight Blonde Closure");
		blondeClosure_Label.setBounds(28, 436, 172, 14);
		frmHairProductsCalculator.getContentPane().add(blondeClosure_Label);

		JLabel greyClosure_Label = new JLabel("Grey Closure");
		greyClosure_Label.setBounds(28, 461, 86, 14);
		frmHairProductsCalculator.getContentPane().add(greyClosure_Label);

		JLabel straightFrontal_Label = new JLabel("Straight Frontal");
		straightFrontal_Label.setBounds(28, 486, 125, 14);
		frmHairProductsCalculator.getContentPane().add(straightFrontal_Label);

		JLabel looseFrontal_Label = new JLabel("Loose Wave Frontal");
		looseFrontal_Label.setBounds(28, 511, 125, 14);
		frmHairProductsCalculator.getContentPane().add(looseFrontal_Label);

		JLabel bodyFrontal_Label = new JLabel("Body Wave Frontal");
		bodyFrontal_Label.setBounds(28, 536, 125, 14);
		frmHairProductsCalculator.getContentPane().add(bodyFrontal_Label);

		JLabel deepFrontal_Label = new JLabel("Deep Wave Frontal");
		deepFrontal_Label.setBounds(28, 561, 125, 14);
		frmHairProductsCalculator.getContentPane().add(deepFrontal_Label);

		JLabel rareFrontal_Label = new JLabel("Rare Curly Frontal ");
		rareFrontal_Label.setBounds(28, 586, 125, 14);
		frmHairProductsCalculator.getContentPane().add(rareFrontal_Label);

		JLabel steam1Frontal_Label = new JLabel("Steam #1 Frontal ");
		steam1Frontal_Label.setBounds(28, 611, 125, 14);
		frmHairProductsCalculator.getContentPane().add(steam1Frontal_Label);

		JLabel steam2Frontal_Label = new JLabel("Steam #2 Frontal ");
		steam2Frontal_Label.setBounds(28, 636, 125, 14);
		frmHairProductsCalculator.getContentPane().add(steam2Frontal_Label);

		JLabel straightClosure_Label = new JLabel("Straight Closure");
		straightClosure_Label.setBounds(28, 260, 111, 14);
		frmHairProductsCalculator.getContentPane().add(straightClosure_Label);

		JLabel blondeFrontal_Label = new JLabel("Straight Blonde Frontal ");
		blondeFrontal_Label.setBounds(28, 660, 143, 14);
		frmHairProductsCalculator.getContentPane().add(blondeFrontal_Label);

		JLabel greyFrontal_Label = new JLabel("Grey Frontal ");
		greyFrontal_Label.setBounds(28, 685, 86, 14);
		frmHairProductsCalculator.getContentPane().add(greyFrontal_Label);

		JLabel shippingMethod_Label = new JLabel("Shipping Methods: ");
		shippingMethod_Label.setFont(new Font("Tahoma", Font.BOLD, 12));
		shippingMethod_Label.setBounds(428, 144, 176, 14);
		frmHairProductsCalculator.getContentPane().add(shippingMethod_Label);

		JLabel totalQuantity_Label = new JLabel("Total Quantity:");
		totalQuantity_Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		totalQuantity_Label.setBounds(428, 488, 101, 14);
		frmHairProductsCalculator.getContentPane().add(totalQuantity_Label);

		JLabel subTotal_Label = new JLabel("Subtotal:");
		subTotal_Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		subTotal_Label.setBounds(428, 97, 73, 14);
		frmHairProductsCalculator.getContentPane().add(subTotal_Label);
		
		total_With_Paypal_Label = new JLabel("Total w/ Paypal Fee:");
		total_With_Paypal_Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		total_With_Paypal_Label.setBounds(428, 538, 143, 14);
		frmHairProductsCalculator.getContentPane().add(total_With_Paypal_Label);

		total_Without_Paypal_Label = new JLabel("Total w/o Paypal Fee:");
		total_Without_Paypal_Label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		total_Without_Paypal_Label.setBounds(428, 587, 173, 14);
		frmHairProductsCalculator.getContentPane().add(total_Without_Paypal_Label);

		JTextArea show_Addition_txtArea = new JTextArea();
		show_Addition_txtArea.setColumns(20);
		show_Addition_txtArea.setLineWrap(true);
		show_Addition_txtArea.setBounds(428, 373, 231, 93);
		frmHairProductsCalculator.getContentPane().add(show_Addition_txtArea);

		// THE COMBO BOX FOR STRAIGHT'S LENGTHS
		straightLengths = new JComboBox<>();
		straightLengths.setBackground(Color.WHITE);
		straightLengths.setForeground(Color.BLACK);
		straightLengths.addItem("0\"");
		straightLengths.addItem("10\"");
		straightLengths.addItem("12\"");
		straightLengths.addItem("14\"");
		straightLengths.addItem("16\"");
		straightLengths.addItem("18\"");
		straightLengths.addItem("20\"");
		straightLengths.addItem("22\"");
		straightLengths.addItem("24\"");
		straightLengths.addItem("26\"");
		straightLengths.addItem("28\"");
		straightLengths.addItem("30\"");
		straightLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (straightLengths.getSelectedIndex() == 0)
					straight = 0;
				if (straightLengths.getSelectedIndex() == 1)
					straight = 40;
				if (straightLengths.getSelectedIndex() == 2)
					straight = 42.50;
				if (straightLengths.getSelectedIndex() == 3)
					straight = 46;
				if (straightLengths.getSelectedIndex() == 4)
					straight = 48.50;
				if (straightLengths.getSelectedIndex() == 5)
					straight = 51;
				if (straightLengths.getSelectedIndex() == 6)
					straight = 53.50;
				if (straightLengths.getSelectedIndex() == 7)
					straight = 56;
				if (straightLengths.getSelectedIndex() == 8)
					straight = 58.50;
				if (straightLengths.getSelectedIndex() == 9)
					straight = 61;
				if (straightLengths.getSelectedIndex() == 10)
					straight = 63.50;
				if (straightLengths.getSelectedIndex() == 11)
					straight = 66;
			}
		});
		straightLengths.setBounds(210, 31, 63, 22);
		frmHairProductsCalculator.getContentPane().add(straightLengths);

		// THE COMBO BOX FOR STRAIGHT QUANTITY
		straightQuantity = new JComboBox<>();
		straightQuantity.addItem("0");
		straightQuantity.addItem("1");
		straightQuantity.addItem("2");
		straightQuantity.addItem("3");
		straightQuantity.addItem("4");
		straightQuantity.addItem("5");
		straightQuantity.addItem("6");
		straightQuantity.addItem("7");
		straightQuantity.addItem("8");
		straightQuantity.addItem("9");
		straightQuantity.addItem("10");
		straightQuantity.addItem("11");
		straightQuantity.addItem("12");
		straightQuantity.addItem("13");
		straightQuantity.addItem("14");
		straightQuantity.addItem("15");
		straightQuantity.addItem("16");
		straightQuantity.addItem("17");
		straightQuantity.addItem("18");
		straightQuantity.addItem("19");
		straightQuantity.addItem("20");
		straightQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (straightQuantity.getSelectedIndex() == 0)
					quantity_Of_Straight = 0;
				if (straightQuantity.getSelectedIndex() == 1)
					quantity_Of_Straight = 1;
				if (straightQuantity.getSelectedIndex() == 2)
					quantity_Of_Straight = 2;
				if (straightQuantity.getSelectedIndex() == 3)
					quantity_Of_Straight = 3;
				if (straightQuantity.getSelectedIndex() == 4)
					quantity_Of_Straight = 4;
				if (straightQuantity.getSelectedIndex() == 5)
					quantity_Of_Straight = 5;
				if (straightQuantity.getSelectedIndex() == 6)
					quantity_Of_Straight = 6;
				if (straightQuantity.getSelectedIndex() == 7)
					quantity_Of_Straight = 7;
				if (straightQuantity.getSelectedIndex() == 8)
					quantity_Of_Straight = 8;
				if (straightQuantity.getSelectedIndex() == 9)
					quantity_Of_Straight = 9;
				if (straightQuantity.getSelectedIndex() == 10)
					quantity_Of_Straight = 10;
				if (straightQuantity.getSelectedIndex() == 11)
					quantity_Of_Straight = 11;
				if (straightQuantity.getSelectedIndex() == 12)
					quantity_Of_Straight = 12;
				if (straightQuantity.getSelectedIndex() == 13)
					quantity_Of_Straight = 13;
				if (straightQuantity.getSelectedIndex() == 14)
					quantity_Of_Straight = 14;
				if (straightQuantity.getSelectedIndex() == 15)
					quantity_Of_Straight = 15;
				if (straightQuantity.getSelectedIndex() == 16)
					quantity_Of_Straight = 16;
				if (straightQuantity.getSelectedIndex() == 17)
					quantity_Of_Straight = 17;
				if (straightQuantity.getSelectedIndex() == 18)
					quantity_Of_Straight = 18;
				if (straightQuantity.getSelectedIndex() == 19)
					quantity_Of_Straight = 19;
				if (straightQuantity.getSelectedIndex() == 20)
					quantity_Of_Straight = 20;
			}
		});
		straightQuantity.setBounds(315, 31, 63, 22);
		frmHairProductsCalculator.getContentPane().add(straightQuantity);

		// THE COMBO BOX FOR LOOSE WAVE'S LENGTHS
		JComboBox<String>looseLengths = new JComboBox<>();
		looseLengths.addItem("0\"");
		looseLengths.addItem("12\"");
		looseLengths.addItem("14\"");
		looseLengths.addItem("16\"");
		looseLengths.addItem("18\"");
		looseLengths.addItem("20\"");
		looseLengths.addItem("22\"");
		looseLengths.addItem("24\"");
		looseLengths.addItem("26\"");
		looseLengths.addItem("28\"");
		looseLengths.addItem("30\"");
		looseLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (looseLengths.getSelectedIndex() == 0)
					loose = 0;
				if (looseLengths.getSelectedIndex() == 1)
					loose = 43.50;
				if (looseLengths.getSelectedIndex() == 2)
					loose = 47;
				if (looseLengths.getSelectedIndex() == 3)
					loose = 49.50;
				if (looseLengths.getSelectedIndex() == 4)
					loose = 52;
				if (looseLengths.getSelectedIndex() == 5)
					loose = 54.50;
				if (looseLengths.getSelectedIndex() == 6)
					loose = 57;
				if (looseLengths.getSelectedIndex() == 7)
					loose = 59.50;
				if (looseLengths.getSelectedIndex() == 8)
					loose = 62;
				if (looseLengths.getSelectedIndex() == 9)
					loose = 64.50;
				if (looseLengths.getSelectedIndex() == 10)
					loose = 67;
			}
		});
		looseLengths.setBounds(210, 56, 63, 22);
		frmHairProductsCalculator.getContentPane().add(looseLengths);

		// THE COMBO BOX FOR LOOSE WAVE QUANTITY
		JComboBox<String>looseQuantity = new JComboBox<>();
		looseQuantity.addItem("0");
		looseQuantity.addItem("1");
		looseQuantity.addItem("2");
		looseQuantity.addItem("3");
		looseQuantity.addItem("4");
		looseQuantity.addItem("5");
		looseQuantity.addItem("6");
		looseQuantity.addItem("7");
		looseQuantity.addItem("8");
		looseQuantity.addItem("9");
		looseQuantity.addItem("10");
		looseQuantity.addItem("11");
		looseQuantity.addItem("12");
		looseQuantity.addItem("13");
		looseQuantity.addItem("14");
		looseQuantity.addItem("15");
		looseQuantity.addItem("16");
		looseQuantity.addItem("17");
		looseQuantity.addItem("18");
		looseQuantity.addItem("19");
		looseQuantity.addItem("20");
		looseQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (looseQuantity.getSelectedIndex() == 0)
					quantity_Of_Loose = 0;
				if (looseQuantity.getSelectedIndex() == 1)
					quantity_Of_Loose = 1;
				if (looseQuantity.getSelectedIndex() == 2)
					quantity_Of_Loose = 2;
				if (looseQuantity.getSelectedIndex() == 3)
					quantity_Of_Loose = 3;
				if (looseQuantity.getSelectedIndex() == 4)
					quantity_Of_Loose = 4;
				if (looseQuantity.getSelectedIndex() == 5)
					quantity_Of_Loose = 5;
				if (looseQuantity.getSelectedIndex() == 6)
					quantity_Of_Loose = 6;
				if (looseQuantity.getSelectedIndex() == 7)
					quantity_Of_Loose = 7;
				if (looseQuantity.getSelectedIndex() == 8)
					quantity_Of_Loose = 8;
				if (looseQuantity.getSelectedIndex() == 9)
					quantity_Of_Loose = 9;
				if (looseQuantity.getSelectedIndex() == 10)
					quantity_Of_Loose = 10;
				if (looseQuantity.getSelectedIndex() == 11)
					quantity_Of_Loose = 11;
				if (looseQuantity.getSelectedIndex() == 12)
					quantity_Of_Loose = 12;
				if (looseQuantity.getSelectedIndex() == 13)
					quantity_Of_Loose = 13;
				if (looseQuantity.getSelectedIndex() == 14)
					quantity_Of_Loose = 14;
				if (looseQuantity.getSelectedIndex() == 15)
					quantity_Of_Loose = 15;
				if (looseQuantity.getSelectedIndex() == 16)
					quantity_Of_Loose = 16;
				if (looseQuantity.getSelectedIndex() == 17)
					quantity_Of_Loose = 17;
				if (looseQuantity.getSelectedIndex() == 18)
					quantity_Of_Loose = 18;
				if (looseQuantity.getSelectedIndex() == 19)
					quantity_Of_Loose = 19;
				if (looseQuantity.getSelectedIndex() == 20)
					quantity_Of_Loose = 20;
			}
		});
		looseQuantity.setBounds(315, 56, 63, 22);
		frmHairProductsCalculator.getContentPane().add(looseQuantity);

		// THE COMBO BOX FOR BODY WAVE LENGTHS
		JComboBox<String>bodyLengths = new JComboBox<String>();
		bodyLengths.addItem("0\"");
		bodyLengths.addItem("10\"");
		bodyLengths.addItem("12\"");
		bodyLengths.addItem("14\"");
		bodyLengths.addItem("16\"");
		bodyLengths.addItem("18\"");
		bodyLengths.addItem("20\"");
		bodyLengths.addItem("22\"");
		bodyLengths.addItem("24\"");
		bodyLengths.addItem("26\"");
		bodyLengths.addItem("28\"");
		bodyLengths.addItem("30\"");
		bodyLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bodyLengths.getSelectedIndex() == 0)
					body = 0;
				if (bodyLengths.getSelectedIndex() == 1)
					body = 42;
				if (bodyLengths.getSelectedIndex() == 2)
					body = 44.50;
				if (bodyLengths.getSelectedIndex() == 3)
					body = 48;
				if (bodyLengths.getSelectedIndex() == 4)
					body = 50.50;
				if (bodyLengths.getSelectedIndex() == 5)
					body = 53;
				if (bodyLengths.getSelectedIndex() == 6)
					body = 55.50;
				if (bodyLengths.getSelectedIndex() == 7)
					body = 58;
				if (bodyLengths.getSelectedIndex() == 8)
					body = 60.50;
				if (bodyLengths.getSelectedIndex() == 9)
					body = 63;
				if (bodyLengths.getSelectedIndex() == 10)
					body = 65.50;
				if (bodyLengths.getSelectedIndex() == 11)
					body = 68;
			}
		});
		bodyLengths.setBounds(210, 81, 63, 22);
		frmHairProductsCalculator.getContentPane().add(bodyLengths);

		// THE COMBO BOX FOR BODY WAVE QUANTITY
		JComboBox<String>bodyQuantity = new JComboBox<String>();
		bodyQuantity.addItem("0");
		bodyQuantity.addItem("1");
		bodyQuantity.addItem("2");
		bodyQuantity.addItem("3");
		bodyQuantity.addItem("4");
		bodyQuantity.addItem("5");
		bodyQuantity.addItem("6");
		bodyQuantity.addItem("7");
		bodyQuantity.addItem("8");
		bodyQuantity.addItem("9");
		bodyQuantity.addItem("10");
		bodyQuantity.addItem("11");
		bodyQuantity.addItem("12");
		bodyQuantity.addItem("13");
		bodyQuantity.addItem("14");
		bodyQuantity.addItem("15");
		bodyQuantity.addItem("16");
		bodyQuantity.addItem("17");
		bodyQuantity.addItem("18");
		bodyQuantity.addItem("19");
		bodyQuantity.addItem("20");
		bodyQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bodyQuantity.getSelectedIndex() == 0)
					quantity_Of_Body = 0;
				if (bodyQuantity.getSelectedIndex() == 1)
					quantity_Of_Body = 1;
				if (bodyQuantity.getSelectedIndex() == 2)
					quantity_Of_Body = 2;
				if (bodyQuantity.getSelectedIndex() == 3)
					quantity_Of_Body = 3;
				if (bodyQuantity.getSelectedIndex() == 4)
					quantity_Of_Body = 4;
				if (bodyQuantity.getSelectedIndex() == 5)
					quantity_Of_Body = 5;
				if (bodyQuantity.getSelectedIndex() == 6)
					quantity_Of_Body = 6;
				if (bodyQuantity.getSelectedIndex() == 7)
					quantity_Of_Body = 7;
				if (bodyQuantity.getSelectedIndex() == 8)
					quantity_Of_Body = 8;
				if (bodyQuantity.getSelectedIndex() == 9)
					quantity_Of_Body = 9;
				if (bodyQuantity.getSelectedIndex() == 10)
					quantity_Of_Body = 10;
				if (bodyQuantity.getSelectedIndex() == 11)
					quantity_Of_Body = 11;
				if (bodyQuantity.getSelectedIndex() == 12)
					quantity_Of_Body = 12;
				if (bodyQuantity.getSelectedIndex() == 13)
					quantity_Of_Body = 13;
				if (bodyQuantity.getSelectedIndex() == 14)
					quantity_Of_Body = 14;
				if (bodyQuantity.getSelectedIndex() == 15)
					quantity_Of_Body = 15;
				if (bodyQuantity.getSelectedIndex() == 16)
					quantity_Of_Body = 16;
				if (bodyQuantity.getSelectedIndex() == 17)
					quantity_Of_Body = 17;
				if (bodyQuantity.getSelectedIndex() == 18)
					quantity_Of_Body = 18;
				if (bodyQuantity.getSelectedIndex() == 19)
					quantity_Of_Body = 19;
				if (bodyQuantity.getSelectedIndex() == 20)
					quantity_Of_Body = 20;
			}
		});
		bodyQuantity.setBounds(315, 81, 63, 22);
		frmHairProductsCalculator.getContentPane().add(bodyQuantity);

		// THE COMBO BOX FOR DEEP WAVE LENGTHS
		JComboBox<String> deepLengths = new JComboBox<String>();
		deepLengths.addItem("0\"");
		deepLengths.addItem("12\"");
		deepLengths.addItem("14\"");
		deepLengths.addItem("16\"");
		deepLengths.addItem("18\"");
		deepLengths.addItem("20\"");
		deepLengths.addItem("22\"");
		deepLengths.addItem("24\"");
		deepLengths.addItem("26\"");
		deepLengths.addItem("28\"");
		deepLengths.addItem("30\"");
		deepLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deepLengths.getSelectedIndex() == 0)
					deep = 0;
				if (deepLengths.getSelectedIndex() == 1)
					deep = 47;
				if (deepLengths.getSelectedIndex() == 2)
					deep = 50.50;
				if (deepLengths.getSelectedIndex() == 3)
					deep = 53;
				if (deepLengths.getSelectedIndex() == 4)
					deep = 55.50;
				if (deepLengths.getSelectedIndex() == 5)
					deep = 58;
				if (deepLengths.getSelectedIndex() == 6)
					deep = 60.50;
				if (deepLengths.getSelectedIndex() == 7)
					deep = 63;
				if (deepLengths.getSelectedIndex() == 8)
					deep = 65.50;
				if (deepLengths.getSelectedIndex() == 9)
					deep = 68;
				if (deepLengths.getSelectedIndex() == 10)
					deep = 70.50;
			}
		});
		deepLengths.setBounds(210, 106, 63, 22);
		frmHairProductsCalculator.getContentPane().add(deepLengths);

		JComboBox<String> deepQuantity = new JComboBox<String>();
		deepQuantity.addItem("0");
		deepQuantity.addItem("1");
		deepQuantity.addItem("2");
		deepQuantity.addItem("3");
		deepQuantity.addItem("4");
		deepQuantity.addItem("5");
		deepQuantity.addItem("6");
		deepQuantity.addItem("7");
		deepQuantity.addItem("8");
		deepQuantity.addItem("9");
		deepQuantity.addItem("10");
		deepQuantity.addItem("11");
		deepQuantity.addItem("12");
		deepQuantity.addItem("13");
		deepQuantity.addItem("14");
		deepQuantity.addItem("15");
		deepQuantity.addItem("16");
		deepQuantity.addItem("17");
		deepQuantity.addItem("18");
		deepQuantity.addItem("19");
		deepQuantity.addItem("20");
		deepQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deepQuantity.getSelectedIndex() == 0)
					quantity_Of_Deep = 0;
				if (deepQuantity.getSelectedIndex() == 1)
					quantity_Of_Deep = 1;
				if (deepQuantity.getSelectedIndex() == 2)
					quantity_Of_Deep = 2;
				if (deepQuantity.getSelectedIndex() == 3)
					quantity_Of_Deep = 3;
				if (deepQuantity.getSelectedIndex() == 4)
					quantity_Of_Deep = 4;
				if (deepQuantity.getSelectedIndex() == 5)
					quantity_Of_Deep = 5;
				if (deepQuantity.getSelectedIndex() == 6)
					quantity_Of_Deep = 6;
				if (deepQuantity.getSelectedIndex() == 7)
					quantity_Of_Deep = 7;
				if (deepQuantity.getSelectedIndex() == 8)
					quantity_Of_Deep = 8;
				if (deepQuantity.getSelectedIndex() == 9)
					quantity_Of_Deep = 9;
				if (deepQuantity.getSelectedIndex() == 10)
					quantity_Of_Deep = 10;
				if (deepQuantity.getSelectedIndex() == 11)
					quantity_Of_Deep = 11;
				if (deepQuantity.getSelectedIndex() == 12)
					quantity_Of_Deep = 12;
				if (deepQuantity.getSelectedIndex() == 13)
					quantity_Of_Deep = 13;
				if (deepQuantity.getSelectedIndex() == 14)
					quantity_Of_Deep = 14;
				if (deepQuantity.getSelectedIndex() == 15)
					quantity_Of_Deep = 15;
				if (deepQuantity.getSelectedIndex() == 16)
					quantity_Of_Deep = 16;
				if (deepQuantity.getSelectedIndex() == 17)
					quantity_Of_Deep = 17;
				if (deepQuantity.getSelectedIndex() == 18)
					quantity_Of_Deep = 18;
				if (deepQuantity.getSelectedIndex() == 19)
					quantity_Of_Deep = 19;
				if (deepQuantity.getSelectedIndex() == 20)
					quantity_Of_Deep = 20;
			}
		});
		deepQuantity.setBounds(315, 106, 63, 22);
		frmHairProductsCalculator.getContentPane().add(deepQuantity);

		// THE COMBO BOX FOR RARE CURLY LENGTHS
		JComboBox<String> rareLengths = new JComboBox<>();
		rareLengths.addItem("0\"");
		rareLengths.addItem("10\"");
		rareLengths.addItem("12\"");
		rareLengths.addItem("14\"");
		rareLengths.addItem("16\"");
		rareLengths.addItem("18\"");
		rareLengths.addItem("20\"");
		rareLengths.addItem("22\"");
		rareLengths.addItem("24\"");
		rareLengths.addItem("26\"");
		rareLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rareLengths.getSelectedIndex() == 0)
					rare = 0;
				if (rareLengths.getSelectedIndex() == 1)
					rare = 54;
				if (rareLengths.getSelectedIndex() == 2)
					rare = 56;
				if (rareLengths.getSelectedIndex() == 3)
					rare = 59;
				if (rareLengths.getSelectedIndex() == 4)
					rare = 63;
				if (rareLengths.getSelectedIndex() == 5)
					rare = 65;
				if (rareLengths.getSelectedIndex() == 6)
					rare = 69;
				if (rareLengths.getSelectedIndex() == 7)
					rare = 71;
				if (rareLengths.getSelectedIndex() == 8)
					rare = 74;
				if (rareLengths.getSelectedIndex() == 9)
					rare = 78;
			}
		});
		rareLengths.setBounds(210, 131, 63, 22);
		frmHairProductsCalculator.getContentPane().add(rareLengths);

		// THE COMBO BOX FOR RARE CURLY QUANTITY
		JComboBox<String> rareQuantity = new JComboBox<>();
		rareQuantity.addItem("0");
		rareQuantity.addItem("1");
		rareQuantity.addItem("2");
		rareQuantity.addItem("3");
		rareQuantity.addItem("4");
		rareQuantity.addItem("5");
		rareQuantity.addItem("6");
		rareQuantity.addItem("7");
		rareQuantity.addItem("8");
		rareQuantity.addItem("9");
		rareQuantity.addItem("10");
		rareQuantity.addItem("11");
		rareQuantity.addItem("12");
		rareQuantity.addItem("13");
		rareQuantity.addItem("14");
		rareQuantity.addItem("15");
		rareQuantity.addItem("16");
		rareQuantity.addItem("17");
		rareQuantity.addItem("18");
		rareQuantity.addItem("19");
		rareQuantity.addItem("20");
		rareQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rareQuantity.getSelectedIndex() == 0)
					quantity_Of_Rare = 0;
				if (rareQuantity.getSelectedIndex() == 1)
					quantity_Of_Rare = 1;
				if (rareQuantity.getSelectedIndex() == 2)
					quantity_Of_Rare = 2;
				if (rareQuantity.getSelectedIndex() == 3)
					quantity_Of_Rare = 3;
				if (rareQuantity.getSelectedIndex() == 4)
					quantity_Of_Rare = 4;
				if (rareQuantity.getSelectedIndex() == 5)
					quantity_Of_Rare = 5;
				if (rareQuantity.getSelectedIndex() == 6)
					quantity_Of_Rare = 6;
				if (rareQuantity.getSelectedIndex() == 7)
					quantity_Of_Rare = 7;
				if (rareQuantity.getSelectedIndex() == 8)
					quantity_Of_Rare = 8;
				if (rareQuantity.getSelectedIndex() == 9)
					quantity_Of_Rare = 9;
				if (rareQuantity.getSelectedIndex() == 10)
					quantity_Of_Rare = 10;
				if (rareQuantity.getSelectedIndex() == 11)
					quantity_Of_Rare = 11;
				if (rareQuantity.getSelectedIndex() == 12)
					quantity_Of_Rare = 12;
				if (rareQuantity.getSelectedIndex() == 13)
					quantity_Of_Rare = 13;
				if (rareQuantity.getSelectedIndex() == 14)
					quantity_Of_Rare = 14;
				if (rareQuantity.getSelectedIndex() == 15)
					quantity_Of_Rare = 15;
				if (rareQuantity.getSelectedIndex() == 16)
					quantity_Of_Rare = 16;
				if (rareQuantity.getSelectedIndex() == 17)
					quantity_Of_Rare = 17;
				if (rareQuantity.getSelectedIndex() == 18)
					quantity_Of_Rare = 18;
				if (rareQuantity.getSelectedIndex() == 19)
					quantity_Of_Rare = 19;
				if (rareQuantity.getSelectedIndex() == 20)
					quantity_Of_Rare = 20;
			}
		});
		rareQuantity.setBounds(315, 131, 63, 22);
		frmHairProductsCalculator.getContentPane().add(rareQuantity);

		// THE COMBO BOX FOR STEAM #1's LENGTHS
		JComboBox<String> steam1Lengths = new JComboBox<>();
		steam1Lengths.addItem("0\"");
		steam1Lengths.addItem("12\"");
		steam1Lengths.addItem("14\"");
		steam1Lengths.addItem("16\"");
		steam1Lengths.addItem("18\"");
		steam1Lengths.addItem("20\"");
		steam1Lengths.addItem("22\"");
		steam1Lengths.addItem("24\"");
		steam1Lengths.addItem("26\"");
		steam1Lengths.addItem("28\"");
		steam1Lengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam1Lengths.getSelectedIndex() == 0)
					steam1 = 0;
				if (steam1Lengths.getSelectedIndex() == 1)
					steam1 = 48;
				if (steam1Lengths.getSelectedIndex() == 2)
					steam1 = 51.50;
				if (steam1Lengths.getSelectedIndex() == 3)
					steam1 = 54;
				if (steam1Lengths.getSelectedIndex() == 4)
					steam1 = 56.50;
				if (steam1Lengths.getSelectedIndex() == 5)
					steam1 = 59;
				if (steam1Lengths.getSelectedIndex() == 6)
					steam1 = 61.50;
				if (steam1Lengths.getSelectedIndex() == 7)
					steam1 = 64;
				if (steam1Lengths.getSelectedIndex() == 8)
					steam1 = 66.50;
				if (steam1Lengths.getSelectedIndex() == 9)
					steam1 = 69;
			}
		});
		steam1Lengths.setBounds(210, 156, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam1Lengths);

		// THE COMBO BOX FOR STEAM #1's QUANTITY
		JComboBox<String> steam1Quantity = new JComboBox<>();
		steam1Quantity.addItem("0");
		steam1Quantity.addItem("1");
		steam1Quantity.addItem("2");
		steam1Quantity.addItem("3");
		steam1Quantity.addItem("4");
		steam1Quantity.addItem("5");
		steam1Quantity.addItem("6");
		steam1Quantity.addItem("7");
		steam1Quantity.addItem("8");
		steam1Quantity.addItem("9");
		steam1Quantity.addItem("10");
		steam1Quantity.addItem("11");
		steam1Quantity.addItem("12");
		steam1Quantity.addItem("13");
		steam1Quantity.addItem("14");
		steam1Quantity.addItem("15");
		steam1Quantity.addItem("16");
		steam1Quantity.addItem("17");
		steam1Quantity.addItem("18");
		steam1Quantity.addItem("19");
		steam1Quantity.addItem("20");
		steam1Quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam1Quantity.getSelectedIndex() == 0)
					quantity_Of_Steam1 = 0;
				if (steam1Quantity.getSelectedIndex() == 1)
					quantity_Of_Steam1 = 1;
				if (steam1Quantity.getSelectedIndex() == 2)
					quantity_Of_Steam1 = 2;
				if (steam1Quantity.getSelectedIndex() == 3)
					quantity_Of_Steam1 = 3;
				if (steam1Quantity.getSelectedIndex() == 4)
					quantity_Of_Steam1 = 4;
				if (steam1Quantity.getSelectedIndex() == 5)
					quantity_Of_Steam1 = 5;
				if (steam1Quantity.getSelectedIndex() == 6)
					quantity_Of_Steam1 = 6;
				if (steam1Quantity.getSelectedIndex() == 7)
					quantity_Of_Steam1 = 7;
				if (steam1Quantity.getSelectedIndex() == 8)
					quantity_Of_Steam1 = 8;
				if (steam1Quantity.getSelectedIndex() == 9)
					quantity_Of_Steam1 = 9;
				if (steam1Quantity.getSelectedIndex() == 10)
					quantity_Of_Steam1 = 10;
				if (steam1Quantity.getSelectedIndex() == 11)
					quantity_Of_Steam1 = 11;
				if (steam1Quantity.getSelectedIndex() == 12)
					quantity_Of_Steam1 = 12;
				if (steam1Quantity.getSelectedIndex() == 13)
					quantity_Of_Steam1 = 13;
				if (steam1Quantity.getSelectedIndex() == 14)
					quantity_Of_Steam1 = 14;
				if (steam1Quantity.getSelectedIndex() == 15)
					quantity_Of_Steam1 = 15;
				if (steam1Quantity.getSelectedIndex() == 16)
					quantity_Of_Steam1 = 16;
				if (steam1Quantity.getSelectedIndex() == 17)
					quantity_Of_Steam1 = 17;
				if (steam1Quantity.getSelectedIndex() == 18)
					quantity_Of_Steam1 = 18;
				if (steam1Quantity.getSelectedIndex() == 19)
					quantity_Of_Steam1 = 19;
				if (steam1Quantity.getSelectedIndex() == 20)
					quantity_Of_Steam1 = 20;
			}
		});
		steam1Quantity.setBounds(315, 156, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam1Quantity);

		// THE COMBO BOX FOR STEAM #2's LENGTHS
		JComboBox<String> steam2Lengths = new JComboBox<>();
		steam2Lengths.addItem("0\"");
		steam2Lengths.addItem("12\"");
		steam2Lengths.addItem("14\"");
		steam2Lengths.addItem("16\"");
		steam2Lengths.addItem("18\"");
		steam2Lengths.addItem("20\"");
		steam2Lengths.addItem("22\"");
		steam2Lengths.addItem("24\"");
		steam2Lengths.addItem("26\"");
		steam2Lengths.addItem("28\"");
		steam2Lengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam2Lengths.getSelectedIndex() == 0)
					steam2 = 0;
				if (steam2Lengths.getSelectedIndex() == 1)
					steam2 = 48;
				if (steam2Lengths.getSelectedIndex() == 2)
					steam2 = 51.50;
				if (steam2Lengths.getSelectedIndex() == 3)
					steam2 = 54;
				if (steam2Lengths.getSelectedIndex() == 4)
					steam2 = 56.50;
				if (steam2Lengths.getSelectedIndex() == 5)
					steam2 = 59;
				if (steam2Lengths.getSelectedIndex() == 6)
					steam2 = 61.50;
				if (steam2Lengths.getSelectedIndex() == 7)
					steam2 = 64;
				if (steam2Lengths.getSelectedIndex() == 8)
					steam2 = 66.50;
				if (steam2Lengths.getSelectedIndex() == 9)
					steam2 = 69;
			}
		});
		steam2Lengths.setBounds(210, 181, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam2Lengths);

		// THE COMBO BOX FOR STEAM #2's QUANTITY
		JComboBox<String> steam2Quantity = new JComboBox<>();
		steam2Quantity.addItem("0");
		steam2Quantity.addItem("1");
		steam2Quantity.addItem("2");
		steam2Quantity.addItem("3");
		steam2Quantity.addItem("4");
		steam2Quantity.addItem("5");
		steam2Quantity.addItem("6");
		steam2Quantity.addItem("7");
		steam2Quantity.addItem("8");
		steam2Quantity.addItem("9");
		steam2Quantity.addItem("10");
		steam2Quantity.addItem("11");
		steam2Quantity.addItem("12");
		steam2Quantity.addItem("13");
		steam2Quantity.addItem("14");
		steam2Quantity.addItem("15");
		steam2Quantity.addItem("16");
		steam2Quantity.addItem("17");
		steam2Quantity.addItem("18");
		steam2Quantity.addItem("19");
		steam2Quantity.addItem("20");
		steam2Quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam2Quantity.getSelectedIndex() == 0)
					quantity_Of_Steam2 = 0;
				if (steam2Quantity.getSelectedIndex() == 1)
					quantity_Of_Steam2 = 1;
				if (steam2Quantity.getSelectedIndex() == 2)
					quantity_Of_Steam2 = 2;
				if (steam2Quantity.getSelectedIndex() == 3)
					quantity_Of_Steam2 = 3;
				if (steam2Quantity.getSelectedIndex() == 4)
					quantity_Of_Steam2 = 4;
				if (steam2Quantity.getSelectedIndex() == 5)
					quantity_Of_Steam2 = 5;
				if (steam2Quantity.getSelectedIndex() == 6)
					quantity_Of_Steam2 = 6;
				if (steam2Quantity.getSelectedIndex() == 7)
					quantity_Of_Steam2 = 7;
				if (steam2Quantity.getSelectedIndex() == 8)
					quantity_Of_Steam2 = 8;
				if (steam2Quantity.getSelectedIndex() == 9)
					quantity_Of_Steam2 = 9;
				if (steam2Quantity.getSelectedIndex() == 10)
					quantity_Of_Steam2 = 10;
				if (steam2Quantity.getSelectedIndex() == 11)
					quantity_Of_Steam2 = 11;
				if (steam2Quantity.getSelectedIndex() == 12)
					quantity_Of_Steam2 = 12;
				if (steam2Quantity.getSelectedIndex() == 13)
					quantity_Of_Steam2 = 13;
				if (steam2Quantity.getSelectedIndex() == 14)
					quantity_Of_Steam2 = 14;
				if (steam2Quantity.getSelectedIndex() == 15)
					quantity_Of_Steam2 = 15;
				if (steam2Quantity.getSelectedIndex() == 16)
					quantity_Of_Steam2 = 16;
				if (steam2Quantity.getSelectedIndex() == 17)
					quantity_Of_Steam2 = 17;
				if (steam2Quantity.getSelectedIndex() == 18)
					quantity_Of_Steam2 = 18;
				if (steam2Quantity.getSelectedIndex() == 19)
					quantity_Of_Steam2 = 19;
				if (steam2Quantity.getSelectedIndex() == 20)
					quantity_Of_Steam2 = 20;
			}
		});
		steam2Quantity.setBounds(315, 181, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam2Quantity);

		// THE COMBO BOX FOR BLONDE'S LENGTHS
		JComboBox<String> blondeLengths = new JComboBox<>();
		blondeLengths.addItem("0\"");
		blondeLengths.addItem("12\"");
		blondeLengths.addItem("14\"");
		blondeLengths.addItem("16\"");
		blondeLengths.addItem("18\"");
		blondeLengths.addItem("20\"");
		blondeLengths.addItem("22\"");
		blondeLengths.addItem("24\"");
		blondeLengths.addItem("26\"");
		blondeLengths.addItem("28\"");
		blondeLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blondeLengths.getSelectedIndex() == 0)
					blonde = 0;
				if (blondeLengths.getSelectedIndex() == 1)
					blonde = 52.50;
				if (blondeLengths.getSelectedIndex() == 2)
					blonde = 56;
				if (blondeLengths.getSelectedIndex() == 3)
					blonde = 58.50;
				if (blondeLengths.getSelectedIndex() == 4)
					blonde = 61;
				if (blondeLengths.getSelectedIndex() == 5)
					blonde = 63.50;
				if (blondeLengths.getSelectedIndex() == 6)
					blonde = 66;
				if (blondeLengths.getSelectedIndex() == 7)
					blonde = 68.50;
				if (blondeLengths.getSelectedIndex() == 8)
					blonde = 71;
				if (blondeLengths.getSelectedIndex() == 8)
					blonde = 73.50;
			}
		});
		blondeLengths.setBounds(210, 206, 63, 22);
		frmHairProductsCalculator.getContentPane().add(blondeLengths);
		
		// THE COMBO BOX FOR BLONDE'S QUANTITY
		JComboBox<String> blondeQuantity = new JComboBox<>();
		blondeQuantity.addItem("0");
		blondeQuantity.addItem("1");
		blondeQuantity.addItem("2");
		blondeQuantity.addItem("3");
		blondeQuantity.addItem("4");
		blondeQuantity.addItem("5");
		blondeQuantity.addItem("6");
		blondeQuantity.addItem("7");
		blondeQuantity.addItem("8");
		blondeQuantity.addItem("9");
		blondeQuantity.addItem("10");
		blondeQuantity.addItem("11");
		blondeQuantity.addItem("12");
		blondeQuantity.addItem("13");
		blondeQuantity.addItem("14");
		blondeQuantity.addItem("15");
		blondeQuantity.addItem("16");
		blondeQuantity.addItem("17");
		blondeQuantity.addItem("18");
		blondeQuantity.addItem("19");
		blondeQuantity.addItem("20");
		blondeQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blondeQuantity.getSelectedIndex() == 0)
					quantity_Of_Blonde = 0;
				if (blondeQuantity.getSelectedIndex() == 1)
					quantity_Of_Blonde = 1;
				if (blondeQuantity.getSelectedIndex() == 2)
					quantity_Of_Blonde = 2;
				if (blondeQuantity.getSelectedIndex() == 3)
					quantity_Of_Blonde = 3;
				if (blondeQuantity.getSelectedIndex() == 4)
					quantity_Of_Blonde = 4;
				if (blondeQuantity.getSelectedIndex() == 5)
					quantity_Of_Blonde = 5;
				if (blondeQuantity.getSelectedIndex() == 6)
					quantity_Of_Blonde = 6;
				if (blondeQuantity.getSelectedIndex() == 7)
					quantity_Of_Blonde = 7;
				if (blondeQuantity.getSelectedIndex() == 8)
					quantity_Of_Blonde = 8;
				if (blondeQuantity.getSelectedIndex() == 9)
					quantity_Of_Blonde = 9;
				if (blondeQuantity.getSelectedIndex() == 10)
					quantity_Of_Blonde = 10;
				if (blondeQuantity.getSelectedIndex() == 11)
					quantity_Of_Blonde = 11;
				if (blondeQuantity.getSelectedIndex() == 12)
					quantity_Of_Blonde = 12;
				if (blondeQuantity.getSelectedIndex() == 13)
					quantity_Of_Blonde = 13;
				if (blondeQuantity.getSelectedIndex() == 14)
					quantity_Of_Blonde = 14;
				if (blondeQuantity.getSelectedIndex() == 15)
					quantity_Of_Blonde = 15;
				if (blondeQuantity.getSelectedIndex() == 16)
					quantity_Of_Blonde = 16;
				if (blondeQuantity.getSelectedIndex() == 17)
					quantity_Of_Blonde = 17;
				if (blondeQuantity.getSelectedIndex() == 18)
					quantity_Of_Blonde = 18;
				if (blondeQuantity.getSelectedIndex() == 19)
					quantity_Of_Blonde = 19;
				if (blondeQuantity.getSelectedIndex() == 20)
					quantity_Of_Blonde = 20;
			}
		});
		blondeQuantity.setBounds(315, 206, 63, 22);
		frmHairProductsCalculator.getContentPane().add(blondeQuantity);

		// THE COMBO BOX FOR GREY'S LENGTHS
		JComboBox<String> greyLengths = new JComboBox<>();
		greyLengths.addItem("0\"");
		greyLengths.addItem("12\"");
		greyLengths.addItem("14\"");
		greyLengths.addItem("16\"");
		greyLengths.addItem("18\"");
		greyLengths.addItem("20\"");
		greyLengths.addItem("22\"");
		greyLengths.addItem("24\"");
		greyLengths.addItem("26\"");
		greyLengths.addItem("28\"");
		greyLengths.addItem("30\"");
		greyLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greyLengths.getSelectedIndex() == 0)
					grey = 0;
				if (greyLengths.getSelectedIndex() == 1)
					grey = 43.50;
				if (greyLengths.getSelectedIndex() == 2)
					grey = 47;
				if (greyLengths.getSelectedIndex() == 3)
					grey = 49.50;
				if (greyLengths.getSelectedIndex() == 4)
					grey = 52;
				if (greyLengths.getSelectedIndex() == 5)
					grey = 54.50;
				if (greyLengths.getSelectedIndex() == 6)
					grey = 57;
				if (greyLengths.getSelectedIndex() == 7)
					grey = 59.50;
				if (greyLengths.getSelectedIndex() == 8)
					grey = 62;
				if (greyLengths.getSelectedIndex() == 9)
					grey = 64.50;
				if (greyLengths.getSelectedIndex() == 10)
					grey = 67;
			}
		});
		greyLengths.setBounds(210, 231, 63, 22);
		frmHairProductsCalculator.getContentPane().add(greyLengths);

		// THE COMBO BOX FOR GREY'S QUANTITY
		JComboBox<String> greyQuantity = new JComboBox<>();
		greyQuantity.addItem("0");
		greyQuantity.addItem("1");
		greyQuantity.addItem("2");
		greyQuantity.addItem("3");
		greyQuantity.addItem("4");
		greyQuantity.addItem("5");
		greyQuantity.addItem("6");
		greyQuantity.addItem("7");
		greyQuantity.addItem("8");
		greyQuantity.addItem("9");
		greyQuantity.addItem("10");
		greyQuantity.addItem("11");
		greyQuantity.addItem("12");
		greyQuantity.addItem("13");
		greyQuantity.addItem("14");
		greyQuantity.addItem("15");
		greyQuantity.addItem("16");
		greyQuantity.addItem("17");
		greyQuantity.addItem("18");
		greyQuantity.addItem("19");
		greyQuantity.addItem("20");
		greyQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greyQuantity.getSelectedIndex() == 0)
					quantity_Of_Grey = 0;
				if (greyQuantity.getSelectedIndex() == 1)
					quantity_Of_Grey = 1;
				if (greyQuantity.getSelectedIndex() == 2)
					quantity_Of_Grey = 2;
				if (greyQuantity.getSelectedIndex() == 3)
					quantity_Of_Grey = 3;
				if (greyQuantity.getSelectedIndex() == 4)
					quantity_Of_Grey = 4;
				if (greyQuantity.getSelectedIndex() == 5)
					quantity_Of_Grey = 5;
				if (greyQuantity.getSelectedIndex() == 6)
					quantity_Of_Grey = 6;
				if (greyQuantity.getSelectedIndex() == 7)
					quantity_Of_Grey = 7;
				if (greyQuantity.getSelectedIndex() == 8)
					quantity_Of_Grey = 8;
				if (greyQuantity.getSelectedIndex() == 9)
					quantity_Of_Grey = 9;
				if (greyQuantity.getSelectedIndex() == 10)
					quantity_Of_Grey = 10;
				if (greyQuantity.getSelectedIndex() == 11)
					quantity_Of_Grey = 11;
				if (greyQuantity.getSelectedIndex() == 12)
					quantity_Of_Grey = 12;
				if (greyQuantity.getSelectedIndex() == 13)
					quantity_Of_Grey = 13;
				if (greyQuantity.getSelectedIndex() == 14)
					quantity_Of_Grey = 14;
				if (greyQuantity.getSelectedIndex() == 15)
					quantity_Of_Grey = 15;
				if (greyQuantity.getSelectedIndex() == 16)
					quantity_Of_Grey = 16;
				if (greyQuantity.getSelectedIndex() == 17)
					quantity_Of_Grey = 17;
				if (greyQuantity.getSelectedIndex() == 18)
					quantity_Of_Grey = 18;
				if (greyQuantity.getSelectedIndex() == 19)
					quantity_Of_Grey = 19;
				if (greyQuantity.getSelectedIndex() == 20)
					quantity_Of_Grey = 20;
			}
		});
		greyQuantity.setBounds(315, 231, 63, 22);
		frmHairProductsCalculator.getContentPane().add(greyQuantity);

		// THE COMBOX FOR STRAIGHT CLOSURE'S LENGTHS
		JComboBox<String> straightClosureLengths = new JComboBox<>();
		straightClosureLengths.addItem("0\"");
		straightClosureLengths.addItem("12\"");
		straightClosureLengths.addItem("14\"");
		straightClosureLengths.addItem("16\"");
		straightClosureLengths.addItem("18\"");
		straightClosureLengths.addItem("20\"");
		straightClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (straightClosureLengths.getSelectedIndex() == 0)
					straightClosure = 0;
				if (straightClosureLengths.getSelectedIndex() == 1)
					straightClosure = 55;
				if (straightClosureLengths.getSelectedIndex() == 2)
					straightClosure = 60;
				if (straightClosureLengths.getSelectedIndex() == 3)
					straightClosure = 65;
				if (straightClosureLengths.getSelectedIndex() == 4)
					straightClosure = 70;
				if (straightClosureLengths.getSelectedIndex() == 5)
					straightClosure = 75;
			}
		});
		straightClosureLengths.setBounds(210, 256, 63, 22);
		frmHairProductsCalculator.getContentPane().add(straightClosureLengths);

		// THE COMBOX FOR STRAIGHT CLOSURE'S QUANITTY
		JComboBox<String> straightClosureQuantity = new JComboBox<>();
		straightClosureQuantity.addItem("0");
		straightClosureQuantity.addItem("1");
		straightClosureQuantity.addItem("2");
		straightClosureQuantity.addItem("3");
		straightClosureQuantity.addItem("4");
		straightClosureQuantity.addItem("5");
		straightClosureQuantity.addItem("6");
		straightClosureQuantity.addItem("7");
		straightClosureQuantity.addItem("8");
		straightClosureQuantity.addItem("9");
		straightClosureQuantity.addItem("10");
		straightClosureQuantity.addItem("11");
		straightClosureQuantity.addItem("12");
		straightClosureQuantity.addItem("13");
		straightClosureQuantity.addItem("14");
		straightClosureQuantity.addItem("15");
		straightClosureQuantity.addItem("16");
		straightClosureQuantity.addItem("17");
		straightClosureQuantity.addItem("18");
		straightClosureQuantity.addItem("19");
		straightClosureQuantity.addItem("20");
		straightClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (straightClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_StraightClosure = 0;
				if (straightClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_StraightClosure = 1;
				if (straightClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_StraightClosure = 2;
				if (straightClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_StraightClosure = 3;
				if (straightClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_StraightClosure = 4;
				if (straightClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_StraightClosure = 5;
				if (straightClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_StraightClosure = 6;
				if (straightClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_StraightClosure = 7;
				if (straightClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_StraightClosure = 8;
				if (straightClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_StraightClosure = 9;
				if (straightClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_StraightClosure = 10;
				if (straightClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_StraightClosure = 11;
				if (straightClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_StraightClosure = 12;
				if (straightClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_StraightClosure = 13;
				if (straightClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_StraightClosure = 14;
				if (straightClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_StraightClosure = 15;
				if (straightClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_StraightClosure = 16;
				if (straightClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_StraightClosure = 17;
				if (straightClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_StraightClosure = 18;
				if (straightClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_StraightClosure = 19;
				if (straightClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_StraightClosure = 20;
			}
		});
		straightClosureQuantity.setBounds(315, 256, 63, 22);
		frmHairProductsCalculator.getContentPane().add(straightClosureQuantity);

		// THE COMBO BOX FOR THE LOOSE CLOSURE'S LENGTHS
		JComboBox<String> looseClosureLengths = new JComboBox<>();
		looseClosureLengths.addItem("0\"");
		looseClosureLengths.addItem("12\"");
		looseClosureLengths.addItem("14\"");
		looseClosureLengths.addItem("16\"");
		looseClosureLengths.addItem("18\"");
		looseClosureLengths.addItem("20\"");
		looseClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (looseClosureLengths.getSelectedIndex() == 0)
					looseClosure = 0;
				if (looseClosureLengths.getSelectedIndex() == 1)
					looseClosure = 57.50;
				if (looseClosureLengths.getSelectedIndex() == 2)
					looseClosure = 62.50;
				if (looseClosureLengths.getSelectedIndex() == 3)
					looseClosure = 67.50;
				if (looseClosureLengths.getSelectedIndex() == 4)
					looseClosure = 72.50;
				if (looseClosureLengths.getSelectedIndex() == 5)
					looseClosure = 77.50;
			}
		});
		looseClosureLengths.setBounds(210, 282, 63, 22);
		frmHairProductsCalculator.getContentPane().add(looseClosureLengths);

		// THE COMBO BOX FOR THE LOOSE CLOSURE'S QUANTITY
		JComboBox<String> looseClosureQuantity = new JComboBox<>();
		looseClosureQuantity.addItem("0");
		looseClosureQuantity.addItem("1");
		looseClosureQuantity.addItem("2");
		looseClosureQuantity.addItem("3");
		looseClosureQuantity.addItem("4");
		looseClosureQuantity.addItem("5");
		looseClosureQuantity.addItem("6");
		looseClosureQuantity.addItem("7");
		looseClosureQuantity.addItem("8");
		looseClosureQuantity.addItem("9");
		looseClosureQuantity.addItem("10");
		looseClosureQuantity.addItem("11");
		looseClosureQuantity.addItem("12");
		looseClosureQuantity.addItem("13");
		looseClosureQuantity.addItem("14");
		looseClosureQuantity.addItem("15");
		looseClosureQuantity.addItem("16");
		looseClosureQuantity.addItem("17");
		looseClosureQuantity.addItem("18");
		looseClosureQuantity.addItem("19");
		looseClosureQuantity.addItem("20");
		looseClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (looseClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_LooseClosure = 0;
				if (looseClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_LooseClosure = 1;
				if (looseClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_LooseClosure = 2;
				if (looseClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_LooseClosure = 3;
				if (looseClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_LooseClosure = 4;
				if (looseClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_LooseClosure = 5;
				if (looseClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_LooseClosure = 6;
				if (looseClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_LooseClosure = 7;
				if (looseClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_LooseClosure = 8;
				if (looseClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_LooseClosure = 9;
				if (looseClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_LooseClosure = 10;
				if (looseClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_LooseClosure = 11;
				if (looseClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_LooseClosure = 12;
				if (looseClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_LooseClosure = 13;
				if (looseClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_LooseClosure = 14;
				if (looseClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_LooseClosure = 15;
				if (looseClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_LooseClosure = 16;
				if (looseClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_LooseClosure = 17;
				if (looseClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_LooseClosure = 18;
				if (looseClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_LooseClosure = 19;
				if (looseClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_LooseClosure = 20;
			}
		});
		looseClosureQuantity.setBounds(315, 282, 63, 22);
		frmHairProductsCalculator.getContentPane().add(looseClosureQuantity);

		// THE COMBO BOX FOR THE BODY CLOSURE'S LENGTHS
		JComboBox<String> bodyClosureLengths = new JComboBox<>();
		bodyClosureLengths.addItem("0\"");
		bodyClosureLengths.addItem("12\"");
		bodyClosureLengths.addItem("14\"");
		bodyClosureLengths.addItem("16\"");
		bodyClosureLengths.addItem("18\"");
		bodyClosureLengths.addItem("20\"");
		bodyClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bodyClosureLengths.getSelectedIndex() == 0)
					bodyClosure = 0;
				if (bodyClosureLengths.getSelectedIndex() == 1)
					bodyClosure = 58.50;
				if (bodyClosureLengths.getSelectedIndex() == 2)
					bodyClosure = 63.50;
				if (bodyClosureLengths.getSelectedIndex() == 3)
					bodyClosure = 68.50;
				if (bodyClosureLengths.getSelectedIndex() == 4)
					bodyClosure = 73.50;
				if (bodyClosureLengths.getSelectedIndex() == 5)
					bodyClosure = 78.50;
			}
		});
		bodyClosureLengths.setBounds(210, 307, 63, 22);
		frmHairProductsCalculator.getContentPane().add(bodyClosureLengths);

		// THE COMBO BOX FOR THE BODY CLOSURE'S QUANTITY
		JComboBox<String> bodyClosureQuantity = new JComboBox<>();
		bodyClosureQuantity.addItem("0");
		bodyClosureQuantity.addItem("1");
		bodyClosureQuantity.addItem("2");
		bodyClosureQuantity.addItem("3");
		bodyClosureQuantity.addItem("4");
		bodyClosureQuantity.addItem("5");
		bodyClosureQuantity.addItem("6");
		bodyClosureQuantity.addItem("7");
		bodyClosureQuantity.addItem("8");
		bodyClosureQuantity.addItem("9");
		bodyClosureQuantity.addItem("10");
		bodyClosureQuantity.addItem("11");
		bodyClosureQuantity.addItem("12");
		bodyClosureQuantity.addItem("13");
		bodyClosureQuantity.addItem("14");
		bodyClosureQuantity.addItem("15");
		bodyClosureQuantity.addItem("16");
		bodyClosureQuantity.addItem("17");
		bodyClosureQuantity.addItem("18");
		bodyClosureQuantity.addItem("19");
		bodyClosureQuantity.addItem("20");
		bodyClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bodyClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_BodyClosure = 0;
				if (bodyClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_BodyClosure = 1;
				if (bodyClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_BodyClosure = 2;
				if (bodyClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_BodyClosure = 3;
				if (bodyClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_BodyClosure = 4;
				if (bodyClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_BodyClosure = 5;
				if (bodyClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_BodyClosure = 6;
				if (bodyClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_BodyClosure = 7;
				if (bodyClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_BodyClosure = 8;
				if (bodyClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_BodyClosure = 9;
				if (bodyClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_BodyClosure = 10;
				if (bodyClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_BodyClosure = 11;
				if (bodyClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_BodyClosure = 12;
				if (bodyClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_BodyClosure = 13;
				if (bodyClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_BodyClosure = 14;
				if (bodyClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_BodyClosure = 15;
				if (bodyClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_BodyClosure = 16;
				if (bodyClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_BodyClosure = 17;
				if (bodyClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_BodyClosure = 18;
				if (bodyClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_BodyClosure = 19;
				if (bodyClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_BodyClosure = 20;
			}
		});
		bodyClosureQuantity.setBounds(315, 307, 63, 22);
		frmHairProductsCalculator.getContentPane().add(bodyClosureQuantity);

		// THE COMBO BOX FOR DEEP CLOSURE'S LENGTHS
		JComboBox<String> deepClosureLengths = new JComboBox<>();
		deepClosureLengths.addItem("0\"");
		deepClosureLengths.addItem("12\"");
		deepClosureLengths.addItem("14\"");
		deepClosureLengths.addItem("16\"");
		deepClosureLengths.addItem("18\"");
		deepClosureLengths.addItem("20\"");
		deepClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deepClosureLengths.getSelectedIndex() == 0)
					deepClosure = 0;
				if (deepClosureLengths.getSelectedIndex() == 1)
					deepClosure = 60;
				if (deepClosureLengths.getSelectedIndex() == 2)
					deepClosure = 65;
				if (deepClosureLengths.getSelectedIndex() == 3)
					deepClosure = 70;
				if (deepClosureLengths.getSelectedIndex() == 4)
					deepClosure = 75;
				if (deepClosureLengths.getSelectedIndex() == 5)
					deepClosure = 80;
			}
		});
		deepClosureLengths.setBounds(210, 332, 63, 22);
		frmHairProductsCalculator.getContentPane().add(deepClosureLengths);

		// THE COMBO BOX FOR DEEP CLOSURE'S QUANTITY
		JComboBox<String> deepClosureQuantity = new JComboBox<>();
		deepClosureQuantity.addItem("0");
		deepClosureQuantity.addItem("1");
		deepClosureQuantity.addItem("2");
		deepClosureQuantity.addItem("3");
		deepClosureQuantity.addItem("4");
		deepClosureQuantity.addItem("5");
		deepClosureQuantity.addItem("6");
		deepClosureQuantity.addItem("7");
		deepClosureQuantity.addItem("8");
		deepClosureQuantity.addItem("9");
		deepClosureQuantity.addItem("10");
		deepClosureQuantity.addItem("11");
		deepClosureQuantity.addItem("12");
		deepClosureQuantity.addItem("13");
		deepClosureQuantity.addItem("14");
		deepClosureQuantity.addItem("15");
		deepClosureQuantity.addItem("16");
		deepClosureQuantity.addItem("17");
		deepClosureQuantity.addItem("18");
		deepClosureQuantity.addItem("19");
		deepClosureQuantity.addItem("20");
		deepClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deepClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_DeepClosure = 0;
				if (deepClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_DeepClosure = 1;
				if (deepClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_DeepClosure = 2;
				if (deepClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_DeepClosure = 3;
				if (deepClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_DeepClosure = 4;
				if (deepClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_DeepClosure = 5;
				if (deepClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_DeepClosure = 6;
				if (deepClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_DeepClosure = 7;
				if (deepClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_DeepClosure = 8;
				if (deepClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_DeepClosure = 9;
				if (deepClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_DeepClosure = 10;
				if (deepClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_DeepClosure = 11;
				if (deepClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_DeepClosure = 12;
				if (deepClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_DeepClosure = 13;
				if (deepClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_DeepClosure = 14;
				if (deepClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_DeepClosure = 15;
				if (deepClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_DeepClosure = 16;
				if (deepClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_DeepClosure = 17;
				if (deepClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_DeepClosure = 18;
				if (deepClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_DeepClosure = 19;
				if (deepClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_DeepClosure = 20;
			}
		});
		deepClosureQuantity.setBounds(315, 332, 63, 22);
		frmHairProductsCalculator.getContentPane().add(deepClosureQuantity);

		// THE COMBO BOX FOR RARE CLOSURE'S LENGTHS
		JComboBox<String> rareClosureLengths = new JComboBox<>();
		rareClosureLengths.addItem("0\"");
		rareClosureLengths.addItem("12\"");
		rareClosureLengths.addItem("14\"");
		rareClosureLengths.addItem("16\"");
		rareClosureLengths.addItem("18\"");
		rareClosureLengths.addItem("20\"");
		rareClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rareClosureLengths.getSelectedIndex() == 0)
					rareClosure = 0;
				if (rareClosureLengths.getSelectedIndex() == 1)
					rareClosure = 62.50;
				if (rareClosureLengths.getSelectedIndex() == 2)
					rareClosure = 67.50;
				if (rareClosureLengths.getSelectedIndex() == 3)
					rareClosure = 72.50;
				if (rareClosureLengths.getSelectedIndex() == 4)
					rareClosure = 77.50;
				if (rareClosureLengths.getSelectedIndex() == 5)
					rareClosure = 82.50;
			}
		});
		rareClosureLengths.setBounds(210, 357, 63, 22);
		frmHairProductsCalculator.getContentPane().add(rareClosureLengths);

		// THE COMBO BOX FOR RARE CLOSURE'S QUANTITY
		JComboBox<String> rareClosureQuantity = new JComboBox<>();
		rareClosureQuantity.addItem("0");
		rareClosureQuantity.addItem("1");
		rareClosureQuantity.addItem("2");
		rareClosureQuantity.addItem("3");
		rareClosureQuantity.addItem("4");
		rareClosureQuantity.addItem("5");
		rareClosureQuantity.addItem("6");
		rareClosureQuantity.addItem("7");
		rareClosureQuantity.addItem("8");
		rareClosureQuantity.addItem("9");
		rareClosureQuantity.addItem("10");
		rareClosureQuantity.addItem("11");
		rareClosureQuantity.addItem("12");
		rareClosureQuantity.addItem("13");
		rareClosureQuantity.addItem("14");
		rareClosureQuantity.addItem("15");
		rareClosureQuantity.addItem("16");
		rareClosureQuantity.addItem("17");
		rareClosureQuantity.addItem("18");
		rareClosureQuantity.addItem("19");
		rareClosureQuantity.addItem("20");
		rareClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rareClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_RareClosure = 0;
				if (rareClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_RareClosure = 1;
				if (rareClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_RareClosure = 2;
				if (rareClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_RareClosure = 3;
				if (rareClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_RareClosure = 4;
				if (rareClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_RareClosure = 5;
				if (rareClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_RareClosure = 6;
				if (rareClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_RareClosure = 7;
				if (rareClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_RareClosure = 8;
				if (rareClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_RareClosure = 9;
				if (rareClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_RareClosure = 10;
				if (rareClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_RareClosure = 11;
				if (rareClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_RareClosure = 12;
				if (rareClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_RareClosure = 13;
				if (rareClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_RareClosure = 14;
				if (rareClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_RareClosure = 15;
				if (rareClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_RareClosure = 16;
				if (rareClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_RareClosure = 17;
				if (rareClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_RareClosure = 18;
				if (rareClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_RareClosure = 19;
				if (rareClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_RareClosure = 20;
			}
		});
		rareClosureQuantity.setBounds(315, 357, 63, 22);
		frmHairProductsCalculator.getContentPane().add(rareClosureQuantity);

		// THE COMBO BOX FOR STEAM #1 CLOSURE'S LENGTHS
		JComboBox<String> steam1ClosureLengths = new JComboBox<>();
		steam1ClosureLengths.addItem("0\"");
		steam1ClosureLengths.addItem("12\"");
		steam1ClosureLengths.addItem("14\"");
		steam1ClosureLengths.addItem("16\"");
		steam1ClosureLengths.addItem("18\"");
		steam1ClosureLengths.addItem("20\"");
		steam1ClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam1ClosureLengths.getSelectedIndex() == 0)
					steam1Closure = 0;
				if (steam1ClosureLengths.getSelectedIndex() == 1)
					steam1Closure = 57.50;
				if (steam1ClosureLengths.getSelectedIndex() == 2)
					steam1Closure = 62.50;
				if (steam1ClosureLengths.getSelectedIndex() == 3)
					steam1Closure = 67.50;
				if (steam1ClosureLengths.getSelectedIndex() == 4)
					steam1Closure = 72.50;
				if (steam1ClosureLengths.getSelectedIndex() == 5)
					steam1Closure = 77.50;
			}
		});
		steam1ClosureLengths.setBounds(210, 382, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam1ClosureLengths);

		// THE COMBO BOX FOR STEAM #1 CLOSURE'S QUANTITY
		JComboBox<String> steam1ClosureQuantity = new JComboBox<>();
		steam1ClosureQuantity.addItem("0");
		steam1ClosureQuantity.addItem("1");
		steam1ClosureQuantity.addItem("2");
		steam1ClosureQuantity.addItem("3");
		steam1ClosureQuantity.addItem("4");
		steam1ClosureQuantity.addItem("5");
		steam1ClosureQuantity.addItem("6");
		steam1ClosureQuantity.addItem("7");
		steam1ClosureQuantity.addItem("8");
		steam1ClosureQuantity.addItem("9");
		steam1ClosureQuantity.addItem("10");
		steam1ClosureQuantity.addItem("11");
		steam1ClosureQuantity.addItem("12");
		steam1ClosureQuantity.addItem("13");
		steam1ClosureQuantity.addItem("14");
		steam1ClosureQuantity.addItem("15");
		steam1ClosureQuantity.addItem("16");
		steam1ClosureQuantity.addItem("17");
		steam1ClosureQuantity.addItem("18");
		steam1ClosureQuantity.addItem("19");
		steam1ClosureQuantity.addItem("20");
		steam1ClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam1ClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_Steam1Closure = 0;
				if (steam1ClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_Steam1Closure = 1;
				if (steam1ClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_Steam1Closure = 2;
				if (steam1ClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_Steam1Closure = 3;
				if (steam1ClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_Steam1Closure = 4;
				if (steam1ClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_Steam1Closure = 5;
				if (steam1ClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_Steam1Closure = 6;
				if (steam1ClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_Steam1Closure = 7;
				if (steam1ClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_Steam1Closure = 8;
				if (steam1ClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_Steam1Closure = 9;
				if (steam1ClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_Steam1Closure = 10;
				if (steam1ClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_Steam1Closure = 11;
				if (steam1ClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_Steam1Closure = 12;
				if (steam1ClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_Steam1Closure = 13;
				if (steam1ClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_Steam1Closure = 14;
				if (steam1ClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_Steam1Closure = 15;
				if (steam1ClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_Steam1Closure = 16;
				if (steam1ClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_Steam1Closure = 17;
				if (steam1ClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_Steam1Closure = 18;
				if (steam1ClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_Steam1Closure = 19;
				if (steam1ClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_Steam1Closure = 20;
			}
		});
		steam1ClosureQuantity.setBounds(315, 382, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam1ClosureQuantity);

		// THE COMBO BOX FOR STEAM #2 CLOSURE'S LENGTHS
		JComboBox<String> steam2ClosureLengths = new JComboBox<>();
		steam2ClosureLengths.addItem("0\"");
		steam2ClosureLengths.addItem("12\"");
		steam2ClosureLengths.addItem("14\"");
		steam2ClosureLengths.addItem("16\"");
		steam2ClosureLengths.addItem("18\"");
		steam2ClosureLengths.addItem("20\"");
		steam2ClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam2ClosureLengths.getSelectedIndex() == 0)
					steam2Closure = 0;
				if (steam2ClosureLengths.getSelectedIndex() == 1)
					steam2Closure = 57.50;
				if (steam2ClosureLengths.getSelectedIndex() == 2)
					steam2Closure = 62.50;
				if (steam2ClosureLengths.getSelectedIndex() == 3)
					steam2Closure = 67.50;
				if (steam2ClosureLengths.getSelectedIndex() == 4)
					steam2Closure = 72.50;
				if (steam2ClosureLengths.getSelectedIndex() == 5)
					steam2Closure = 77.50;
			}
		});
		steam2ClosureLengths.setBounds(210, 407, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam2ClosureLengths);

		// THE COMBO BOX FOR STEAM #2 CLOSURE'S QUANTITY
		JComboBox<String> steam2ClosureQuantity = new JComboBox<>();
		steam2ClosureQuantity.addItem("0");
		steam2ClosureQuantity.addItem("1");
		steam2ClosureQuantity.addItem("2");
		steam2ClosureQuantity.addItem("3");
		steam2ClosureQuantity.addItem("4");
		steam2ClosureQuantity.addItem("5");
		steam2ClosureQuantity.addItem("6");
		steam2ClosureQuantity.addItem("7");
		steam2ClosureQuantity.addItem("8");
		steam2ClosureQuantity.addItem("9");
		steam2ClosureQuantity.addItem("10");
		steam2ClosureQuantity.addItem("11");
		steam2ClosureQuantity.addItem("12");
		steam2ClosureQuantity.addItem("13");
		steam2ClosureQuantity.addItem("14");
		steam2ClosureQuantity.addItem("15");
		steam2ClosureQuantity.addItem("16");
		steam2ClosureQuantity.addItem("17");
		steam2ClosureQuantity.addItem("18");
		steam2ClosureQuantity.addItem("19");
		steam2ClosureQuantity.addItem("20");
		steam2ClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam2ClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_Steam2Closure = 0;
				if (steam2ClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_Steam2Closure = 1;
				if (steam2ClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_Steam2Closure = 2;
				if (steam2ClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_Steam2Closure = 3;
				if (steam2ClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_Steam2Closure = 4;
				if (steam2ClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_Steam2Closure = 5;
				if (steam2ClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_Steam2Closure = 6;
				if (steam2ClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_Steam2Closure = 7;
				if (steam2ClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_Steam2Closure = 8;
				if (steam2ClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_Steam2Closure = 9;
				if (steam2ClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_Steam2Closure = 10;
				if (steam2ClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_Steam2Closure = 11;
				if (steam2ClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_Steam2Closure = 12;
				if (steam2ClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_Steam2Closure = 13;
				if (steam2ClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_Steam2Closure = 14;
				if (steam2ClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_Steam2Closure = 15;
				if (steam2ClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_Steam2Closure = 16;
				if (steam2ClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_Steam2Closure = 17;
				if (steam2ClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_Steam2Closure = 18;
				if (steam2ClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_Steam2Closure = 19;
				if (steam2ClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_Steam2Closure = 20;
			}
		});
		steam2ClosureQuantity.setBounds(315, 407, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam2ClosureQuantity);

		// THE COMBO BOX FOR BLONDE CLOSURES'S LENGTHS
		JComboBox<String> blondeClosureLengths = new JComboBox<>();
		blondeClosureLengths.addItem("0\"");
		blondeClosureLengths.addItem("12\"");
		blondeClosureLengths.addItem("14\"");
		blondeClosureLengths.addItem("16\"");
		blondeClosureLengths.addItem("18\"");
		blondeClosureLengths.addItem("20\"");
		blondeClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blondeClosureLengths.getSelectedIndex() == 0)
					blondeClosure = 0;
				if (blondeClosureLengths.getSelectedIndex() == 1)
					blondeClosure = 70;
				if (blondeClosureLengths.getSelectedIndex() == 2)
					blondeClosure = 75;
				if (blondeClosureLengths.getSelectedIndex() == 3)
					blondeClosure = 80;
				if (blondeClosureLengths.getSelectedIndex() == 4)
					blondeClosure = 85;
				if (blondeClosureLengths.getSelectedIndex() == 5)
					blondeClosure = 90;
			}
		});
		blondeClosureLengths.setBounds(210, 432, 63, 22);
		frmHairProductsCalculator.getContentPane().add(blondeClosureLengths);

		// THE COMBO BOX FOR BLONDE CLOSURES'S QUANTITY
		JComboBox<String> blondeClosureQuantity = new JComboBox<>();
		blondeClosureQuantity.addItem("0");
		blondeClosureQuantity.addItem("1");
		blondeClosureQuantity.addItem("2");
		blondeClosureQuantity.addItem("3");
		blondeClosureQuantity.addItem("4");
		blondeClosureQuantity.addItem("5");
		blondeClosureQuantity.addItem("6");
		blondeClosureQuantity.addItem("7");
		blondeClosureQuantity.addItem("8");
		blondeClosureQuantity.addItem("9");
		blondeClosureQuantity.addItem("10");
		blondeClosureQuantity.addItem("11");
		blondeClosureQuantity.addItem("12");
		blondeClosureQuantity.addItem("13");
		blondeClosureQuantity.addItem("14");
		blondeClosureQuantity.addItem("15");
		blondeClosureQuantity.addItem("16");
		blondeClosureQuantity.addItem("17");
		blondeClosureQuantity.addItem("18");
		blondeClosureQuantity.addItem("19");
		blondeClosureQuantity.addItem("20");
		blondeClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blondeClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_BlondeClosure = 0;
				if (blondeClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_BlondeClosure = 1;
				if (blondeClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_BlondeClosure = 2;
				if (blondeClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_BlondeClosure = 3;
				if (blondeClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_BlondeClosure = 4;
				if (blondeClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_BlondeClosure = 5;
				if (blondeClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_BlondeClosure = 6;
				if (blondeClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_BlondeClosure = 7;
				if (blondeClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_BlondeClosure = 8;
				if (blondeClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_BlondeClosure = 9;
				if (blondeClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_BlondeClosure = 10;
				if (blondeClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_BlondeClosure = 11;
				if (blondeClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_BlondeClosure = 12;
				if (blondeClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_BlondeClosure = 13;
				if (blondeClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_BlondeClosure = 14;
				if (blondeClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_BlondeClosure = 15;
				if (blondeClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_BlondeClosure = 16;
				if (blondeClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_BlondeClosure = 17;
				if (blondeClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_BlondeClosure = 18;
				if (blondeClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_BlondeClosure = 19;
				if (blondeClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_BlondeClosure = 20;
			}
		});
		blondeClosureQuantity.setBounds(315, 432, 63, 22);
		frmHairProductsCalculator.getContentPane().add(blondeClosureQuantity);

		// THE COMBO BOX FOR GREY CLOSURE'S LENGTHS
		JComboBox<String> greyClosureLengths = new JComboBox<>();
		greyClosureLengths.addItem("0\"");
		greyClosureLengths.addItem("12\"");
		greyClosureLengths.addItem("14\"");
		greyClosureLengths.addItem("16\"");
		greyClosureLengths.addItem("18\"");
		greyClosureLengths.addItem("20\"");
		greyClosureLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greyClosureLengths.getSelectedIndex() == 0)
					greyClosure = 0;
				if (greyClosureLengths.getSelectedIndex() == 1)
					greyClosure = 57.50;
				if (greyClosureLengths.getSelectedIndex() == 2)
					greyClosure = 62.50;
				if (greyClosureLengths.getSelectedIndex() == 3)
					greyClosure = 67.50;
				if (greyClosureLengths.getSelectedIndex() == 4)
					greyClosure = 72.50;
				if (greyClosureLengths.getSelectedIndex() == 5)
					greyClosure = 77.50;
			}
		});
		greyClosureLengths.setBounds(210, 457, 63, 22);
		frmHairProductsCalculator.getContentPane().add(greyClosureLengths);

		// THE COMBO BOX FOR GREY CLOSURE'S QUANTITY
		JComboBox<String> greyClosureQuantity = new JComboBox<>();
		greyClosureQuantity.addItem("0");
		greyClosureQuantity.addItem("1");
		greyClosureQuantity.addItem("2");
		greyClosureQuantity.addItem("3");
		greyClosureQuantity.addItem("4");
		greyClosureQuantity.addItem("5");
		greyClosureQuantity.addItem("6");
		greyClosureQuantity.addItem("7");
		greyClosureQuantity.addItem("8");
		greyClosureQuantity.addItem("9");
		greyClosureQuantity.addItem("10");
		greyClosureQuantity.addItem("11");
		greyClosureQuantity.addItem("12");
		greyClosureQuantity.addItem("13");
		greyClosureQuantity.addItem("14");
		greyClosureQuantity.addItem("15");
		greyClosureQuantity.addItem("16");
		greyClosureQuantity.addItem("17");
		greyClosureQuantity.addItem("18");
		greyClosureQuantity.addItem("19");
		greyClosureQuantity.addItem("20");
		greyClosureQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greyClosureQuantity.getSelectedIndex() == 0)
					quantity_Of_GreyClosure = 0;
				if (greyClosureQuantity.getSelectedIndex() == 1)
					quantity_Of_GreyClosure = 1;
				if (greyClosureQuantity.getSelectedIndex() == 2)
					quantity_Of_GreyClosure = 2;
				if (greyClosureQuantity.getSelectedIndex() == 3)
					quantity_Of_GreyClosure = 3;
				if (greyClosureQuantity.getSelectedIndex() == 4)
					quantity_Of_GreyClosure = 4;
				if (greyClosureQuantity.getSelectedIndex() == 5)
					quantity_Of_GreyClosure = 5;
				if (greyClosureQuantity.getSelectedIndex() == 6)
					quantity_Of_GreyClosure = 6;
				if (greyClosureQuantity.getSelectedIndex() == 7)
					quantity_Of_GreyClosure = 7;
				if (greyClosureQuantity.getSelectedIndex() == 8)
					quantity_Of_GreyClosure = 8;
				if (greyClosureQuantity.getSelectedIndex() == 9)
					quantity_Of_GreyClosure = 9;
				if (greyClosureQuantity.getSelectedIndex() == 10)
					quantity_Of_GreyClosure = 10;
				if (greyClosureQuantity.getSelectedIndex() == 11)
					quantity_Of_GreyClosure = 11;
				if (greyClosureQuantity.getSelectedIndex() == 12)
					quantity_Of_GreyClosure = 12;
				if (greyClosureQuantity.getSelectedIndex() == 13)
					quantity_Of_GreyClosure = 13;
				if (greyClosureQuantity.getSelectedIndex() == 14)
					quantity_Of_GreyClosure = 14;
				if (greyClosureQuantity.getSelectedIndex() == 15)
					quantity_Of_GreyClosure = 15;
				if (greyClosureQuantity.getSelectedIndex() == 16)
					quantity_Of_GreyClosure = 16;
				if (greyClosureQuantity.getSelectedIndex() == 17)
					quantity_Of_GreyClosure = 17;
				if (greyClosureQuantity.getSelectedIndex() == 18)
					quantity_Of_GreyClosure = 18;
				if (greyClosureQuantity.getSelectedIndex() == 19)
					quantity_Of_GreyClosure = 19;
				if (greyClosureQuantity.getSelectedIndex() == 20)
					quantity_Of_GreyClosure = 20;
			}
		});
		greyClosureQuantity.setBounds(315, 457, 63, 22);
		frmHairProductsCalculator.getContentPane().add(greyClosureQuantity);

		// THE COMBO BOX FOR STRAIGHT FRONTAL'S LENGTHS
		JComboBox<String> straightFrontalLengths = new JComboBox<>();
		straightFrontalLengths.addItem("0\"");
		straightFrontalLengths.addItem("12\"");
		straightFrontalLengths.addItem("14\"");
		straightFrontalLengths.addItem("16\"");
		straightFrontalLengths.addItem("18\"");
		straightFrontalLengths.addItem("20\"");
		straightFrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (straightFrontalLengths.getSelectedIndex() == 0)
					straightFrontal = 0;
				if (straightFrontalLengths.getSelectedIndex() == 1)
					straightFrontal = 100;
				if (straightFrontalLengths.getSelectedIndex() == 2)
					straightFrontal = 105;
				if (straightFrontalLengths.getSelectedIndex() == 3)
					straightFrontal = 110;
				if (straightFrontalLengths.getSelectedIndex() == 4)
					straightFrontal = 115;
				if (straightFrontalLengths.getSelectedIndex() == 5)
					straightFrontal = 120;
			}
		});
		straightFrontalLengths.setBounds(210, 482, 63, 22);
		frmHairProductsCalculator.getContentPane().add(straightFrontalLengths);

		// THE COMBO BOX FOR STRAIGHT FRONTAL'S QUANTITY
		JComboBox<String> straightFrontalQuantity = new JComboBox<>();
		straightFrontalQuantity.addItem("0");
		straightFrontalQuantity.addItem("1");
		straightFrontalQuantity.addItem("2");
		straightFrontalQuantity.addItem("3");
		straightFrontalQuantity.addItem("4");
		straightFrontalQuantity.addItem("5");
		straightFrontalQuantity.addItem("6");
		straightFrontalQuantity.addItem("7");
		straightFrontalQuantity.addItem("8");
		straightFrontalQuantity.addItem("9");
		straightFrontalQuantity.addItem("10");
		straightFrontalQuantity.addItem("11");
		straightFrontalQuantity.addItem("12");
		straightFrontalQuantity.addItem("13");
		straightFrontalQuantity.addItem("14");
		straightFrontalQuantity.addItem("15");
		straightFrontalQuantity.addItem("16");
		straightFrontalQuantity.addItem("17");
		straightFrontalQuantity.addItem("18");
		straightFrontalQuantity.addItem("19");
		straightFrontalQuantity.addItem("20");
		straightFrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (straightFrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_StraightFrontal = 0;
				if (straightFrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_StraightFrontal = 1;
				if (straightFrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_StraightFrontal = 2;
				if (straightFrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_StraightFrontal = 3;
				if (straightFrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_StraightFrontal = 4;
				if (straightFrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_StraightFrontal = 5;
				if (straightFrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_StraightFrontal = 6;
				if (straightFrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_StraightFrontal = 7;
				if (straightFrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_StraightFrontal = 8;
				if (straightFrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_StraightFrontal = 9;
				if (straightFrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_StraightFrontal = 10;
				if (straightFrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_StraightFrontal = 11;
				if (straightFrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_StraightFrontal = 12;
				if (straightFrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_StraightFrontal = 13;
				if (straightFrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_StraightFrontal = 14;
				if (straightFrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_StraightFrontal = 15;
				if (straightFrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_StraightFrontal = 16;
				if (straightFrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_StraightFrontal = 17;
				if (straightFrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_StraightFrontal = 18;
				if (straightFrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_StraightFrontal = 19;
				if (straightFrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_StraightFrontal = 20;
			}
		});
		straightFrontalQuantity.setBounds(315, 482, 63, 22);
		frmHairProductsCalculator.getContentPane().add(straightFrontalQuantity);

		// THE COMBO BOX FOR LOOSE WAVE FRONTAL'S LENGTHS
		JComboBox<String> looseFrontalLengths = new JComboBox<>();
		looseFrontalLengths.addItem("0\"");
		looseFrontalLengths.addItem("12\"");
		looseFrontalLengths.addItem("14\"");
		looseFrontalLengths.addItem("16\"");
		looseFrontalLengths.addItem("18\"");
		looseFrontalLengths.addItem("20\"");
		looseFrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (looseFrontalLengths.getSelectedIndex() == 0)
					looseFrontal = 0;
				if (looseFrontalLengths.getSelectedIndex() == 1)
					looseFrontal = 102.50;
				if (looseFrontalLengths.getSelectedIndex() == 2)
					looseFrontal = 107.50;
				if (looseFrontalLengths.getSelectedIndex() == 3)
					looseFrontal = 112.50;
				if (looseFrontalLengths.getSelectedIndex() == 4)
					looseFrontal = 117.50;
				if (looseFrontalLengths.getSelectedIndex() == 5)
					looseFrontal = 122.50;
			}
		});
		looseFrontalLengths.setBounds(210, 507, 63, 22);
		frmHairProductsCalculator.getContentPane().add(looseFrontalLengths);

		// THE COMBO BOX FOR LOOSE WAVE FRONTAL'S QUANTITY
		JComboBox<String> looseFrontalQuantity = new JComboBox<>();
		looseFrontalQuantity.addItem("0");
		looseFrontalQuantity.addItem("1");
		looseFrontalQuantity.addItem("2");
		looseFrontalQuantity.addItem("3");
		looseFrontalQuantity.addItem("4");
		looseFrontalQuantity.addItem("5");
		looseFrontalQuantity.addItem("6");
		looseFrontalQuantity.addItem("7");
		looseFrontalQuantity.addItem("8");
		looseFrontalQuantity.addItem("9");
		looseFrontalQuantity.addItem("10");
		looseFrontalQuantity.addItem("11");
		looseFrontalQuantity.addItem("12");
		looseFrontalQuantity.addItem("13");
		looseFrontalQuantity.addItem("14");
		looseFrontalQuantity.addItem("15");
		looseFrontalQuantity.addItem("16");
		looseFrontalQuantity.addItem("17");
		looseFrontalQuantity.addItem("18");
		looseFrontalQuantity.addItem("19");
		looseFrontalQuantity.addItem("20");
		looseFrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (looseFrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_LooseFrontal = 0;
				if (looseFrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_LooseFrontal = 1;
				if (looseFrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_LooseFrontal = 2;
				if (looseFrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_LooseFrontal = 3;
				if (looseFrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_LooseFrontal = 4;
				if (looseFrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_LooseFrontal = 5;
				if (looseFrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_LooseFrontal = 6;
				if (looseFrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_LooseFrontal = 7;
				if (looseFrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_LooseFrontal = 8;
				if (looseFrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_LooseFrontal = 9;
				if (looseFrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_LooseFrontal = 10;
				if (looseFrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_LooseFrontal = 11;
				if (looseFrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_LooseFrontal = 12;
				if (looseFrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_LooseFrontal = 13;
				if (looseFrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_LooseFrontal = 14;
				if (looseFrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_LooseFrontal = 15;
				if (looseFrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_LooseFrontal = 16;
				if (looseFrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_LooseFrontal = 17;
				if (looseFrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_LooseFrontal = 18;
				if (looseFrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_LooseFrontal = 19;
				if (looseFrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_LooseFrontal = 20;
			}
		});
		looseFrontalQuantity.setBounds(315, 507, 63, 22);
		frmHairProductsCalculator.getContentPane().add(looseFrontalQuantity);

		// THE COMBO BOX FOR BODY WAVE FRONTAL'S LENGTHS
		JComboBox<String> bodyFrontalLengths = new JComboBox<>();
		bodyFrontalLengths.addItem("0\"");
		bodyFrontalLengths.addItem("12\"");
		bodyFrontalLengths.addItem("14\"");
		bodyFrontalLengths.addItem("16\"");
		bodyFrontalLengths.addItem("18\"");
		bodyFrontalLengths.addItem("20\"");
		bodyFrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bodyFrontalLengths.getSelectedIndex() == 0)
					bodyFrontal = 0;
				if (bodyFrontalLengths.getSelectedIndex() == 1)
					bodyFrontal = 103.50;
				if (bodyFrontalLengths.getSelectedIndex() == 2)
					bodyFrontal = 108.50;
				if (bodyFrontalLengths.getSelectedIndex() == 3)
					bodyFrontal = 113.50;
				if (bodyFrontalLengths.getSelectedIndex() == 4)
					bodyFrontal = 118.50;
				if (bodyFrontalLengths.getSelectedIndex() == 5)
					bodyFrontal = 123.50;
			}
		});
		bodyFrontalLengths.setBounds(210, 532, 63, 22);
		frmHairProductsCalculator.getContentPane().add(bodyFrontalLengths);

		// THE COMBO BOX FOR BODY WAVE FRONTAL'S QUANTITY
		JComboBox<String> bodyFrontalQuantity = new JComboBox<>();
		bodyFrontalQuantity.addItem("0");
		bodyFrontalQuantity.addItem("1");
		bodyFrontalQuantity.addItem("2");
		bodyFrontalQuantity.addItem("3");
		bodyFrontalQuantity.addItem("4");
		bodyFrontalQuantity.addItem("5");
		bodyFrontalQuantity.addItem("6");
		bodyFrontalQuantity.addItem("7");
		bodyFrontalQuantity.addItem("8");
		bodyFrontalQuantity.addItem("9");
		bodyFrontalQuantity.addItem("10");
		bodyFrontalQuantity.addItem("11");
		bodyFrontalQuantity.addItem("12");
		bodyFrontalQuantity.addItem("13");
		bodyFrontalQuantity.addItem("14");
		bodyFrontalQuantity.addItem("15");
		bodyFrontalQuantity.addItem("16");
		bodyFrontalQuantity.addItem("17");
		bodyFrontalQuantity.addItem("18");
		bodyFrontalQuantity.addItem("19");
		bodyFrontalQuantity.addItem("20");
		bodyFrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bodyFrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_BodyFrontal = 0;
				if (bodyFrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_BodyFrontal = 1;
				if (bodyFrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_BodyFrontal = 2;
				if (bodyFrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_BodyFrontal = 3;
				if (bodyFrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_BodyFrontal = 4;
				if (bodyFrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_BodyFrontal = 5;
				if (bodyFrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_BodyFrontal = 6;
				if (bodyFrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_BodyFrontal = 7;
				if (bodyFrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_BodyFrontal = 8;
				if (bodyFrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_BodyFrontal = 9;
				if (bodyFrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_BodyFrontal = 10;
				if (bodyFrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_BodyFrontal = 11;
				if (bodyFrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_BodyFrontal = 12;
				if (bodyFrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_BodyFrontal = 13;
				if (bodyFrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_BodyFrontal = 14;
				if (bodyFrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_BodyFrontal = 15;
				if (bodyFrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_BodyFrontal = 16;
				if (bodyFrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_BodyFrontal = 17;
				if (bodyFrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_BodyFrontal = 18;
				if (bodyFrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_BodyFrontal = 19;
				if (bodyFrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_BodyFrontal = 20;
			}
		});
		bodyFrontalQuantity.setBounds(315, 532, 63, 22);
		frmHairProductsCalculator.getContentPane().add(bodyFrontalQuantity);

		// THE COMBO BOX FOR DEEP WAVE FRONTAL'S LENGTHS
		JComboBox<String> deepFrontalLengths = new JComboBox<>();
		deepFrontalLengths.addItem("0\"");
		deepFrontalLengths.addItem("12\"");
		deepFrontalLengths.addItem("14\"");
		deepFrontalLengths.addItem("16\"");
		deepFrontalLengths.addItem("18\"");
		deepFrontalLengths.addItem("20\"");
		deepFrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deepFrontalLengths.getSelectedIndex() == 0)
					deepFrontal = 0;
				if (deepFrontalLengths.getSelectedIndex() == 1)
					deepFrontal = 105;
				if (deepFrontalLengths.getSelectedIndex() == 2)
					deepFrontal = 110;
				if (deepFrontalLengths.getSelectedIndex() == 3)
					deepFrontal = 115;
				if (deepFrontalLengths.getSelectedIndex() == 4)
					deepFrontal = 120;
				if (deepFrontalLengths.getSelectedIndex() == 5)
					deepFrontal = 125;
			}
		});
		deepFrontalLengths.setBounds(210, 557, 63, 22);
		frmHairProductsCalculator.getContentPane().add(deepFrontalLengths);

		// THE COMBO BOX FOR DEEP WAVE FRONTAL'S QUANTITY
		JComboBox<String> deepFrontalQuantity = new JComboBox<>();
		deepFrontalQuantity.addItem("0");
		deepFrontalQuantity.addItem("1");
		deepFrontalQuantity.addItem("2");
		deepFrontalQuantity.addItem("3");
		deepFrontalQuantity.addItem("4");
		deepFrontalQuantity.addItem("5");
		deepFrontalQuantity.addItem("6");
		deepFrontalQuantity.addItem("7");
		deepFrontalQuantity.addItem("8");
		deepFrontalQuantity.addItem("9");
		deepFrontalQuantity.addItem("10");
		deepFrontalQuantity.addItem("11");
		deepFrontalQuantity.addItem("12");
		deepFrontalQuantity.addItem("13");
		deepFrontalQuantity.addItem("14");
		deepFrontalQuantity.addItem("15");
		deepFrontalQuantity.addItem("16");
		deepFrontalQuantity.addItem("17");
		deepFrontalQuantity.addItem("18");
		deepFrontalQuantity.addItem("19");
		deepFrontalQuantity.addItem("20");
		deepFrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (deepFrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_DeepFrontal = 0;
				if (deepFrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_DeepFrontal = 1;
				if (deepFrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_DeepFrontal = 2;
				if (deepFrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_DeepFrontal = 3;
				if (deepFrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_DeepFrontal = 4;
				if (deepFrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_DeepFrontal = 5;
				if (deepFrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_DeepFrontal = 6;
				if (deepFrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_DeepFrontal = 7;
				if (deepFrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_DeepFrontal = 8;
				if (deepFrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_DeepFrontal = 9;
				if (deepFrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_DeepFrontal = 10;
				if (deepFrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_DeepFrontal = 11;
				if (deepFrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_DeepFrontal = 12;
				if (deepFrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_DeepFrontal = 13;
				if (deepFrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_DeepFrontal = 14;
				if (deepFrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_DeepFrontal = 15;
				if (deepFrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_DeepFrontal = 16;
				if (deepFrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_DeepFrontal = 17;
				if (deepFrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_DeepFrontal = 18;
				if (deepFrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_DeepFrontal = 19;
				if (deepFrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_DeepFrontal = 20;
			}
		});
		deepFrontalQuantity.setBounds(315, 557, 63, 22);
		frmHairProductsCalculator.getContentPane().add(deepFrontalQuantity);

		// THE COMBO BOX FOR RARE CURLY FRONTAL'S LENGTHS
		JComboBox<String> rareFrontalLengths = new JComboBox<>();
		rareFrontalLengths.addItem("0\"");
		rareFrontalLengths.addItem("12\"");
		rareFrontalLengths.addItem("14\"");
		rareFrontalLengths.addItem("16\"");
		rareFrontalLengths.addItem("18\"");
		rareFrontalLengths.addItem("20\"");
		rareFrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rareFrontalLengths.getSelectedIndex() == 0)
					rareFrontal = 0;
				if (rareFrontalLengths.getSelectedIndex() == 1)
					rareFrontal = 107.50;
				if (rareFrontalLengths.getSelectedIndex() == 2)
					rareFrontal = 112.50;
				if (rareFrontalLengths.getSelectedIndex() == 3)
					rareFrontal = 117.50;
				if (rareFrontalLengths.getSelectedIndex() == 4)
					rareFrontal = 122.50;
				if (rareFrontalLengths.getSelectedIndex() == 5)
					rareFrontal = 127.50;
			}
		});
		rareFrontalLengths.setBounds(210, 582, 63, 22);
		frmHairProductsCalculator.getContentPane().add(rareFrontalLengths);

		// THE COMBO BOX FOR RARE CURLY FRONTAL'S QUANTITY
		JComboBox<String> rareFrontalQuantity = new JComboBox<>();
		rareFrontalQuantity.addItem("0");
		rareFrontalQuantity.addItem("1");
		rareFrontalQuantity.addItem("2");
		rareFrontalQuantity.addItem("3");
		rareFrontalQuantity.addItem("4");
		rareFrontalQuantity.addItem("5");
		rareFrontalQuantity.addItem("6");
		rareFrontalQuantity.addItem("7");
		rareFrontalQuantity.addItem("8");
		rareFrontalQuantity.addItem("9");
		rareFrontalQuantity.addItem("10");
		rareFrontalQuantity.addItem("11");
		rareFrontalQuantity.addItem("12");
		rareFrontalQuantity.addItem("13");
		rareFrontalQuantity.addItem("14");
		rareFrontalQuantity.addItem("15");
		rareFrontalQuantity.addItem("16");
		rareFrontalQuantity.addItem("17");
		rareFrontalQuantity.addItem("18");
		rareFrontalQuantity.addItem("19");
		rareFrontalQuantity.addItem("20");
		rareFrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rareFrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_RareFrontal = 0;
				if (rareFrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_RareFrontal = 1;
				if (rareFrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_RareFrontal = 2;
				if (rareFrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_RareFrontal = 3;
				if (rareFrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_RareFrontal = 4;
				if (rareFrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_RareFrontal = 5;
				if (rareFrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_RareFrontal = 6;
				if (rareFrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_RareFrontal = 7;
				if (rareFrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_RareFrontal = 8;
				if (rareFrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_RareFrontal = 9;
				if (rareFrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_RareFrontal = 10;
				if (rareFrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_RareFrontal = 11;
				if (rareFrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_RareFrontal = 12;
				if (rareFrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_RareFrontal = 13;
				if (rareFrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_RareFrontal = 14;
				if (rareFrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_RareFrontal = 15;
				if (rareFrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_RareFrontal = 16;
				if (rareFrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_RareFrontal = 17;
				if (rareFrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_RareFrontal = 18;
				if (rareFrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_RareFrontal = 19;
				if (rareFrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_RareFrontal = 20;
			}
		});
		rareFrontalQuantity.setBounds(315, 582, 63, 22);
		frmHairProductsCalculator.getContentPane().add(rareFrontalQuantity);

		// THE COMBO BOX FOR STEAM #1 FRONTAL'S LENGTHS
		JComboBox<String> steam1FrontalLengths = new JComboBox<>();
		steam1FrontalLengths.addItem("0\"");
		steam1FrontalLengths.addItem("12\"");
		steam1FrontalLengths.addItem("14\"");
		steam1FrontalLengths.addItem("16\"");
		steam1FrontalLengths.addItem("18\"");
		steam1FrontalLengths.addItem("20\"");
		steam1FrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam1FrontalLengths.getSelectedIndex() == 0)
					steam1Frontal = 0;
				if (steam1FrontalLengths.getSelectedIndex() == 1)
					steam1Frontal = 102.50;
				if (steam1FrontalLengths.getSelectedIndex() == 2)
					steam1Frontal = 107.50;
				if (steam1FrontalLengths.getSelectedIndex() == 3)
					steam1Frontal = 112.50;
				if (steam1FrontalLengths.getSelectedIndex() == 4)
					steam1Frontal = 117.50;
				if (steam1FrontalLengths.getSelectedIndex() == 5)
					steam1Frontal = 122.50;
			}
		});
		steam1FrontalLengths.setBounds(210, 607, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam1FrontalLengths);

		// THE COMBO BOX FOR STEAM #1 FRONTAL'S QUANTITY
		JComboBox<String> steam1FrontalQuantity = new JComboBox<>();
		steam1FrontalQuantity.addItem("0");
		steam1FrontalQuantity.addItem("1");
		steam1FrontalQuantity.addItem("2");
		steam1FrontalQuantity.addItem("3");
		steam1FrontalQuantity.addItem("4");
		steam1FrontalQuantity.addItem("5");
		steam1FrontalQuantity.addItem("6");
		steam1FrontalQuantity.addItem("7");
		steam1FrontalQuantity.addItem("8");
		steam1FrontalQuantity.addItem("9");
		steam1FrontalQuantity.addItem("10");
		steam1FrontalQuantity.addItem("11");
		steam1FrontalQuantity.addItem("12");
		steam1FrontalQuantity.addItem("13");
		steam1FrontalQuantity.addItem("14");
		steam1FrontalQuantity.addItem("15");
		steam1FrontalQuantity.addItem("16");
		steam1FrontalQuantity.addItem("17");
		steam1FrontalQuantity.addItem("18");
		steam1FrontalQuantity.addItem("19");
		steam1FrontalQuantity.addItem("20");
		steam1FrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam1FrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_Steam1Frontal = 0;
				if (steam1FrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_Steam1Frontal = 1;
				if (steam1FrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_Steam1Frontal = 2;
				if (steam1FrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_Steam1Frontal = 3;
				if (steam1FrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_Steam1Frontal = 4;
				if (steam1FrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_Steam1Frontal = 5;
				if (steam1FrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_Steam1Frontal = 6;
				if (steam1FrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_Steam1Frontal = 7;
				if (steam1FrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_Steam1Frontal = 8;
				if (steam1FrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_Steam1Frontal = 9;
				if (steam1FrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_Steam1Frontal = 10;
				if (steam1FrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_Steam1Frontal = 11;
				if (steam1FrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_Steam1Frontal = 12;
				if (steam1FrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_Steam1Frontal = 13;
				if (steam1FrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_Steam1Frontal = 14;
				if (steam1FrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_Steam1Frontal = 15;
				if (steam1FrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_Steam1Frontal = 16;
				if (steam1FrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_Steam1Frontal = 17;
				if (steam1FrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_Steam1Frontal = 18;
				if (steam1FrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_Steam1Frontal = 19;
				if (steam1FrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_Steam1Frontal = 20;
			}
		});
		steam1FrontalQuantity.setBounds(315, 607, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam1FrontalQuantity);

		// THE COMBO BOX FOR STEAM #2 FRONTAL'S LENGTHS
		JComboBox<String> steam2FrontalLengths = new JComboBox<>();
		steam2FrontalLengths.addItem("0\"");
		steam2FrontalLengths.addItem("12\"");
		steam2FrontalLengths.addItem("14\"");
		steam2FrontalLengths.addItem("16\"");
		steam2FrontalLengths.addItem("18\"");
		steam2FrontalLengths.addItem("20\"");
		steam2FrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam2FrontalLengths.getSelectedIndex() == 0)
					steam2Frontal = 0;
				if (steam2FrontalLengths.getSelectedIndex() == 1)
					steam2Frontal = 102.50;
				if (steam2FrontalLengths.getSelectedIndex() == 2)
					steam2Frontal = 107.50;
				if (steam2FrontalLengths.getSelectedIndex() == 3)
					steam2Frontal = 112.50;
				if (steam2FrontalLengths.getSelectedIndex() == 4)
					steam2Frontal = 117.50;
				if (steam2FrontalLengths.getSelectedIndex() == 5)
					steam2Frontal = 122.50;
			}
		});
		steam2FrontalLengths.setBounds(210, 632, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam2FrontalLengths);

		// THE COMBO BOX FOR STEAM #2 FRONTAL'S QUANITTY
		JComboBox<String> steam2FrontalQuantity = new JComboBox<>();
		steam2FrontalQuantity.addItem("0");
		steam2FrontalQuantity.addItem("1");
		steam2FrontalQuantity.addItem("2");
		steam2FrontalQuantity.addItem("3");
		steam2FrontalQuantity.addItem("4");
		steam2FrontalQuantity.addItem("5");
		steam2FrontalQuantity.addItem("6");
		steam2FrontalQuantity.addItem("7");
		steam2FrontalQuantity.addItem("8");
		steam2FrontalQuantity.addItem("9");
		steam2FrontalQuantity.addItem("10");
		steam2FrontalQuantity.addItem("11");
		steam2FrontalQuantity.addItem("12");
		steam2FrontalQuantity.addItem("13");
		steam2FrontalQuantity.addItem("14");
		steam2FrontalQuantity.addItem("15");
		steam2FrontalQuantity.addItem("16");
		steam2FrontalQuantity.addItem("17");
		steam2FrontalQuantity.addItem("18");
		steam2FrontalQuantity.addItem("19");
		steam2FrontalQuantity.addItem("20");
		steam2FrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (steam2FrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_Steam2Frontal = 0;
				if (steam2FrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_Steam2Frontal = 1;
				if (steam2FrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_Steam2Frontal = 2;
				if (steam2FrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_Steam2Frontal = 3;
				if (steam2FrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_Steam2Frontal = 4;
				if (steam2FrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_Steam2Frontal = 5;
				if (steam2FrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_Steam2Frontal = 6;
				if (steam2FrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_Steam2Frontal = 7;
				if (steam2FrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_Steam2Frontal = 8;
				if (steam2FrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_Steam2Frontal = 9;
				if (steam2FrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_Steam2Frontal = 10;
				if (steam2FrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_Steam2Frontal = 11;
				if (steam2FrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_Steam2Frontal = 12;
				if (steam2FrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_Steam2Frontal = 13;
				if (steam2FrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_Steam2Frontal = 14;
				if (steam2FrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_Steam2Frontal = 15;
				if (steam2FrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_Steam2Frontal = 16;
				if (steam2FrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_Steam2Frontal = 17;
				if (steam2FrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_Steam2Frontal = 18;
				if (steam2FrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_Steam2Frontal = 19;
				if (steam2FrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_Steam2Frontal = 20;
			}
		});
		steam2FrontalQuantity.setBounds(315, 632, 63, 22);
		frmHairProductsCalculator.getContentPane().add(steam2FrontalQuantity);

		// THE COMBO BOX FOR BLONDE FRONTAL'S LENGTHS
		JComboBox<String> blondeFrontalLengths = new JComboBox<>();
		blondeFrontalLengths.addItem("0\"");
		blondeFrontalLengths.addItem("12\"");
		blondeFrontalLengths.addItem("14\"");
		blondeFrontalLengths.addItem("16\"");
		blondeFrontalLengths.addItem("18\"");
		blondeFrontalLengths.addItem("20\"");
		blondeFrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blondeFrontalLengths.getSelectedIndex() == 0)
					blondeFrontal = 0;
				if (blondeFrontalLengths.getSelectedIndex() == 1)
					blondeFrontal = 115;
				if (blondeFrontalLengths.getSelectedIndex() == 2)
					blondeFrontal = 120;
				if (blondeFrontalLengths.getSelectedIndex() == 3)
					blondeFrontal = 125;
				if (blondeFrontalLengths.getSelectedIndex() == 4)
					blondeFrontal = 130;
				if (blondeFrontalLengths.getSelectedIndex() == 5)
					blondeFrontal = 135;
			}
		});
		blondeFrontalLengths.setBounds(210, 656, 63, 22);
		frmHairProductsCalculator.getContentPane().add(blondeFrontalLengths);

		// THE COMBO BOX FOR BLONDE FRONTAL'S QUANTITY
		JComboBox<String> blondeFrontalQuantity = new JComboBox<>();
		blondeFrontalQuantity.addItem("0");
		blondeFrontalQuantity.addItem("1");
		blondeFrontalQuantity.addItem("2");
		blondeFrontalQuantity.addItem("3");
		blondeFrontalQuantity.addItem("4");
		blondeFrontalQuantity.addItem("5");
		blondeFrontalQuantity.addItem("6");
		blondeFrontalQuantity.addItem("7");
		blondeFrontalQuantity.addItem("8");
		blondeFrontalQuantity.addItem("9");
		blondeFrontalQuantity.addItem("10");
		blondeFrontalQuantity.addItem("11");
		blondeFrontalQuantity.addItem("12");
		blondeFrontalQuantity.addItem("13");
		blondeFrontalQuantity.addItem("14");
		blondeFrontalQuantity.addItem("15");
		blondeFrontalQuantity.addItem("16");
		blondeFrontalQuantity.addItem("17");
		blondeFrontalQuantity.addItem("18");
		blondeFrontalQuantity.addItem("19");
		blondeFrontalQuantity.addItem("20");
		blondeFrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blondeFrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_BlondeFrontal = 0;
				if (blondeFrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_BlondeFrontal = 1;
				if (blondeFrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_BlondeFrontal = 2;
				if (blondeFrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_BlondeFrontal = 3;
				if (blondeFrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_BlondeFrontal = 4;
				if (blondeFrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_BlondeFrontal = 5;
				if (blondeFrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_BlondeFrontal = 6;
				if (blondeFrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_BlondeFrontal = 7;
				if (blondeFrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_BlondeFrontal = 8;
				if (blondeFrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_BlondeFrontal = 9;
				if (blondeFrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_BlondeFrontal = 10;
				if (blondeFrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_BlondeFrontal = 11;
				if (blondeFrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_BlondeFrontal = 12;
				if (blondeFrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_BlondeFrontal = 13;
				if (blondeFrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_BlondeFrontal = 14;
				if (blondeFrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_BlondeFrontal = 15;
				if (blondeFrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_BlondeFrontal = 16;
				if (blondeFrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_BlondeFrontal = 17;
				if (blondeFrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_BlondeFrontal = 18;
				if (blondeFrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_BlondeFrontal = 19;
				if (blondeFrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_BlondeFrontal = 20;
			}
		});
		blondeFrontalQuantity.setBounds(315, 656, 63, 22);
		frmHairProductsCalculator.getContentPane().add(blondeFrontalQuantity);

		// THE COMBO BOX FOR GREY FRONTAL'S LENGTHS
		JComboBox<String> greyFrontalLengths = new JComboBox<>();
		greyFrontalLengths.addItem("0\"");
		greyFrontalLengths.addItem("12\"");
		greyFrontalLengths.addItem("14\"");
		greyFrontalLengths.addItem("16\"");
		greyFrontalLengths.addItem("18\"");
		greyFrontalLengths.addItem("20\"");
		greyFrontalLengths.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greyFrontalLengths.getSelectedIndex() == 0)
					greyFrontal = 0;
				if (greyFrontalLengths.getSelectedIndex() == 1)
					greyFrontal = 102.50;
				if (greyFrontalLengths.getSelectedIndex() == 2)
					greyFrontal = 107.50;
				if (greyFrontalLengths.getSelectedIndex() == 3)
					greyFrontal = 112.50;
				if (greyFrontalLengths.getSelectedIndex() == 4)
					greyFrontal = 117.50;
				if (greyFrontalLengths.getSelectedIndex() == 5)
					greyFrontal = 122.50;
			}
		});
		greyFrontalLengths.setBounds(210, 681, 63, 22);
		frmHairProductsCalculator.getContentPane().add(greyFrontalLengths);

		// THE COMBO BOX FOR GREY FRONTAL'S QUANTITY
		JComboBox<String> greyFrontalQuantity = new JComboBox<>();
		greyFrontalQuantity.addItem("0");
		greyFrontalQuantity.addItem("1");
		greyFrontalQuantity.addItem("2");
		greyFrontalQuantity.addItem("3");
		greyFrontalQuantity.addItem("4");
		greyFrontalQuantity.addItem("5");
		greyFrontalQuantity.addItem("6");
		greyFrontalQuantity.addItem("7");
		greyFrontalQuantity.addItem("8");
		greyFrontalQuantity.addItem("9");
		greyFrontalQuantity.addItem("10");
		greyFrontalQuantity.addItem("11");
		greyFrontalQuantity.addItem("12");
		greyFrontalQuantity.addItem("13");
		greyFrontalQuantity.addItem("14");
		greyFrontalQuantity.addItem("15");
		greyFrontalQuantity.addItem("16");
		greyFrontalQuantity.addItem("17");
		greyFrontalQuantity.addItem("18");
		greyFrontalQuantity.addItem("19");
		greyFrontalQuantity.addItem("20");
		greyFrontalQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greyFrontalQuantity.getSelectedIndex() == 0)
					quantity_Of_GreyFrontal = 0;
				if (greyFrontalQuantity.getSelectedIndex() == 1)
					quantity_Of_GreyFrontal = 1;
				if (greyFrontalQuantity.getSelectedIndex() == 2)
					quantity_Of_GreyFrontal = 2;
				if (greyFrontalQuantity.getSelectedIndex() == 3)
					quantity_Of_GreyFrontal = 3;
				if (greyFrontalQuantity.getSelectedIndex() == 4)
					quantity_Of_GreyFrontal = 4;
				if (greyFrontalQuantity.getSelectedIndex() == 5)
					quantity_Of_GreyFrontal = 5;
				if (greyFrontalQuantity.getSelectedIndex() == 6)
					quantity_Of_GreyFrontal = 6;
				if (greyFrontalQuantity.getSelectedIndex() == 7)
					quantity_Of_GreyFrontal = 7;
				if (greyFrontalQuantity.getSelectedIndex() == 8)
					quantity_Of_GreyFrontal = 8;
				if (greyFrontalQuantity.getSelectedIndex() == 9)
					quantity_Of_GreyFrontal = 9;
				if (greyFrontalQuantity.getSelectedIndex() == 10)
					quantity_Of_GreyFrontal = 10;
				if (greyFrontalQuantity.getSelectedIndex() == 11)
					quantity_Of_GreyFrontal = 11;
				if (greyFrontalQuantity.getSelectedIndex() == 12)
					quantity_Of_GreyFrontal = 12;
				if (greyFrontalQuantity.getSelectedIndex() == 13)
					quantity_Of_GreyFrontal = 13;
				if (greyFrontalQuantity.getSelectedIndex() == 14)
					quantity_Of_GreyFrontal = 14;
				if (greyFrontalQuantity.getSelectedIndex() == 15)
					quantity_Of_GreyFrontal = 15;
				if (greyFrontalQuantity.getSelectedIndex() == 16)
					quantity_Of_GreyFrontal = 16;
				if (greyFrontalQuantity.getSelectedIndex() == 17)
					quantity_Of_GreyFrontal = 17;
				if (greyFrontalQuantity.getSelectedIndex() == 18)
					quantity_Of_GreyFrontal = 18;
				if (greyFrontalQuantity.getSelectedIndex() == 19)
					quantity_Of_GreyFrontal = 19;
				if (greyFrontalQuantity.getSelectedIndex() == 20)
					quantity_Of_GreyFrontal = 20;
			}
		});
		greyFrontalQuantity.setBounds(315, 681, 63, 22);
		frmHairProductsCalculator.getContentPane().add(greyFrontalQuantity);

		// ADD BUTTON - ADDING ALL THE PRICES OF CHOSEN PRODUCTS/PATTERNS ALONG WITH THEIR QUANTITY
		add_Button = new JButton("Add For \r\nCalculation");
		add_Button.setForeground(new Color(255, 255, 255));
		add_Button.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		add_Button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		add_Button.setBackground(new Color(0, 128, 0));
		add_Button.setFont(new Font("Consolas", Font.BOLD, 15));
		add_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				straightOrder();
				
				// Add the number of pieces/products
				quantity_Counter += straightQuantity.getSelectedIndex() + looseQuantity.getSelectedIndex() + bodyQuantity.getSelectedIndex() + deepQuantity.getSelectedIndex() +
				rareQuantity.getSelectedIndex() + steam1Quantity.getSelectedIndex() + steam2Quantity.getSelectedIndex() + blondeQuantity.getSelectedIndex() +
				greyQuantity.getSelectedIndex() + straightClosureQuantity.getSelectedIndex() + looseClosureQuantity.getSelectedIndex() + bodyClosureQuantity.getSelectedIndex() +
				deepClosureQuantity.getSelectedIndex() + rareClosureQuantity.getSelectedIndex() + steam1ClosureQuantity.getSelectedIndex() + steam2ClosureQuantity.getSelectedIndex() +
				straightFrontalQuantity.getSelectedIndex() + looseFrontalQuantity.getSelectedIndex() + bodyFrontalQuantity.getSelectedIndex() + deepFrontalQuantity.getSelectedIndex() +
				rareFrontalQuantity.getSelectedIndex() + steam1FrontalQuantity.getSelectedIndex() + steam2FrontalQuantity.getSelectedIndex() + blondeFrontalQuantity.getSelectedIndex() + 
				greyFrontalQuantity.getSelectedIndex();
				
				// Calculating the total of products selected - shipping + PayPal fee are not included
				subtotal += (straight * quantity_Of_Straight) + (loose * quantity_Of_Loose) + (body * quantity_Of_Body) + (deep * quantity_Of_Deep) + (rare * quantity_Of_Rare) + 
				(steam1 * quantity_Of_Steam1) + (steam2 * quantity_Of_Steam2) + (blonde * quantity_Of_Blonde) + (grey * quantity_Of_Grey) +
				(straightClosure * quantity_Of_StraightClosure) + (looseClosure * quantity_Of_LooseClosure) + (bodyClosure * quantity_Of_BodyClosure) + (deepClosure * quantity_Of_DeepClosure) + 
				(rareClosure * quantity_Of_RareClosure) + (steam1Closure * quantity_Of_Steam1Closure) + (steam2Closure * quantity_Of_Steam2Closure) + (blondeClosure * quantity_Of_BlondeClosure) + 
				(grey * quantity_Of_GreyClosure) + (straightFrontal * quantity_Of_StraightFrontal) + (looseFrontal * quantity_Of_LooseFrontal) + (bodyFrontal * quantity_Of_BodyFrontal) + 
				(deepFrontal * quantity_Of_DeepFrontal) + (rareFrontal * quantity_Of_RareFrontal) + (steam1Frontal * quantity_Of_Steam1Frontal) + (steam2Frontal * quantity_Of_Steam2Frontal) + 
				(blondeFrontal * quantity_Of_BlondeFrontal) + (greyFrontal * quantity_Of_GreyFrontal);
				
				// Display the total to the subtotal's text field
				subTotal_txtField.setText("$" + Double.toString(subtotal));

			}
		});
		add_Button.setBounds(453, 35, 185, 50);
		frmHairProductsCalculator.getContentPane().add(add_Button);

		// STANDARD SHIPPING CHECKBOX
		standardshipping_checkbox = new JCheckBox("USPS Standard Shipping ($8)");
		standardshipping_checkbox.setBackground(new Color(192, 192, 192));
		standardshipping_checkbox.setForeground(Color.BLACK);
		standardshipping_checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Calculates total with standard shipping + $1 a piece
					total_With_Shipping = subtotal + STANDARD_SHIPPING + quantity_Counter;

				} catch (java.lang.NumberFormatException notChosen) {
					JOptionPane.showMessageDialog(null,
							"Please enter numbers, not characters (in length or quantity fields)");
				}
			}
		});
		standardshipping_checkbox.setBounds(428, 160, 200, 23);
		frmHairProductsCalculator.getContentPane().add(standardshipping_checkbox);

		// EXPRESS SHIPPING CHECKBOX
		expressshipping_checkbox = new JCheckBox("USPS Express Shipping ($24)");
		expressshipping_checkbox.setBackground(new Color(192, 192, 192));
		expressshipping_checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Calculates total with express shipping + $1 a piece
					total_With_Shipping = subtotal + EXPRESS_SHIPPING + quantity_Counter;

				} catch (java.lang.NumberFormatException notChosen) {
					JOptionPane.showMessageDialog(null,
							"Please enter numbers, not characters (in length or quantity fields)");
				}
			}
		});
		expressshipping_checkbox.setBounds(428, 181, 201, 23);
		frmHairProductsCalculator.getContentPane().add(expressshipping_checkbox);

		// CALCULATE BUTTON - CALCULATING THE GRAND TOTAL WITH AND WITHOUT PAYPAL FEE
		JButton calculate_button = new JButton("Calculate");
		calculate_button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		calculate_button.setFont(new Font("Consolas", Font.BOLD, 24));
		calculate_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String totalOut;
					
					show_Addition_txtArea.setText(straightString);
					
					// Formatting the total WITH PayPal fee
					DecimalFormat myFormatter = new DecimalFormat();

					// Calculating the total W/ the PayPal fee
					totalWithPaypalFee = (total_With_Shipping + POINT_THREE) * PAYPAL_FEE;

					// Calculating the total W/O the PayPal fee
					totalWithOutPaypalFee = total_With_Shipping;

					// Formatting operation
					totalOut = myFormatter.format(totalWithPaypalFee);

					// Displaying total quantity, total with and without PayPal fee to appropriate
					// text fields
					totalQuantity_txtfield.setText(Integer.toString(quantity_Counter));
					totalWPaypalFee.setText("$" + (totalOut));
					totalWOPaypalFee.setText("$" + Double.toString(totalWithOutPaypalFee));

				} catch (Exception incorrectInput) {
					JOptionPane.showMessageDialog(null, "Please check if number(s) are entered");
				}
			}
		});
		calculate_button.setBackground(new Color(25, 25, 112));
		calculate_button.setForeground(new Color(255, 255, 255));
		calculate_button.setBounds(465, 256, 152, 74);
		frmHairProductsCalculator.getContentPane().add(calculate_button);

		// CLEAR BUTTON - SETTING EVERYTHING TO ZERO OR EMPTY 
		clear_Button = new JButton("Clear");
		Image recycle = new ImageIcon(this.getClass().getResource("Oxygen-Icons.org-Oxygen-Actions-trash-empty.ico")).getImage();
		clear_Button.setIcon(new ImageIcon(recycle));
		clear_Button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		clear_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// SETTING APPROPRIATE VALUES TO ZERO OR NULL WHEN USERS HIT CLEAR
				straightLengths.setSelectedItem("0\"");straightQuantity.setSelectedItem("0");
				looseLengths.setSelectedItem("0\"");looseQuantity.setSelectedItem("0");
				bodyLengths.setSelectedItem("0\"");bodyQuantity.setSelectedItem("0");
				deepLengths.setSelectedItem("0\"");deepQuantity.setSelectedItem("0");
				rareLengths.setSelectedItem("0\"");rareQuantity.setSelectedItem("0");
				steam1Lengths.setSelectedItem("0\"");steam1Quantity.setSelectedItem("0");
				steam2Lengths.setSelectedItem("0\"");steam2Quantity.setSelectedItem("0");
				blondeLengths.setSelectedItem("0\"");blondeQuantity.setSelectedItem("0");
				greyLengths.setSelectedItem("0\"");greyQuantity.setSelectedItem("0");
				straightClosureLengths.setSelectedItem("0\"");straightClosureQuantity.setSelectedItem("0");
				looseClosureLengths.setSelectedItem("0\"");looseClosureQuantity.setSelectedItem("0");
				bodyClosureLengths.setSelectedItem("0\"");bodyClosureQuantity.setSelectedItem("0");
				deepClosureLengths.setSelectedItem("0\"");deepClosureQuantity.setSelectedItem("0");
				rareClosureLengths.setSelectedItem("0\"");rareClosureQuantity.setSelectedItem("0");
				steam1ClosureLengths.setSelectedItem("0\"");steam1ClosureQuantity.setSelectedItem("0");
				steam2ClosureLengths.setSelectedItem("0\"");steam2ClosureQuantity.setSelectedItem("0");
				blondeClosureLengths.setSelectedItem("0\"");blondeClosureQuantity.setSelectedItem("0");
				greyClosureLengths.setSelectedItem("0\"");greyClosureQuantity.setSelectedItem("0");
				straightFrontalLengths.setSelectedItem("0\"");straightFrontalQuantity.setSelectedItem("0");
				looseFrontalLengths.setSelectedItem("0\"");looseFrontalQuantity.setSelectedItem("0");
				bodyFrontalLengths.setSelectedItem("0\"");bodyFrontalQuantity.setSelectedItem("0");
				deepFrontalLengths.setSelectedItem("0\"");deepFrontalQuantity.setSelectedItem("0");
				rareFrontalLengths.setSelectedItem("0\"");rareFrontalQuantity.setSelectedItem("0");
				steam1FrontalLengths.setSelectedItem("0\"");steam1FrontalQuantity.setSelectedItem("0");
				steam2FrontalLengths.setSelectedItem("0\"");steam2FrontalQuantity.setSelectedItem("0");
				blondeFrontalLengths.setSelectedItem("0\"");blondeFrontalQuantity.setSelectedItem("0");
				greyFrontalLengths.setSelectedItem("0\"");greyFrontalQuantity.setSelectedItem("0");
				subtotal = 0;
				subTotal_txtField.setText(Double.toString(0.0));
				standardshipping_checkbox.setSelected(false);
				expressshipping_checkbox.setSelected(false);
				show_Addition_txtArea.setText("");
				quantity_Counter = 0;
				totalQuantity_txtfield.setText(Integer.toString(0));
				total_With_Shipping = 0;
				totalWithPaypalFee = 0;
				totalWPaypalFee.setText(Double.toString(totalWithPaypalFee));
				totalWithOutPaypalFee = 0;
				totalWOPaypalFee.setText(Double.toString(totalWithOutPaypalFee));
			}
		});
		clear_Button.setForeground(new Color(0, 0, 0));
		clear_Button.setBackground(new Color(128, 0, 0));
		clear_Button.setFont(new Font("Consolas", Font.BOLD, 18));
		clear_Button.setBounds(501, 636, 86, 47);
		frmHairProductsCalculator.getContentPane().add(clear_Button);

		// TOTAL TXTFIELD
		totalWPaypalFee = new JTextField();
		totalWPaypalFee.setBorder(null);
		totalWPaypalFee.setHorizontalAlignment(SwingConstants.LEFT);
		totalWPaypalFee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		totalWPaypalFee.setBounds(573, 527, 86, 35);
		frmHairProductsCalculator.getContentPane().add(totalWPaypalFee);
		totalWPaypalFee.setColumns(10);

		totalQuantity_txtfield = new JTextField();
		totalQuantity_txtfield.setBorder(null);
		totalQuantity_txtfield.setFont(new Font("Times New Roman", Font.BOLD, 14));
		totalQuantity_txtfield.setBounds(573, 477, 86, 35);
		frmHairProductsCalculator.getContentPane().add(totalQuantity_txtfield);
		totalQuantity_txtfield.setColumns(10);

		totalWOPaypalFee = new JTextField();
		totalWOPaypalFee.setBorder(null);
		totalWOPaypalFee.setHorizontalAlignment(SwingConstants.LEFT);
		totalWOPaypalFee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		totalWOPaypalFee.setColumns(10);
		totalWOPaypalFee.setBounds(573, 577, 86, 35);
		frmHairProductsCalculator.getContentPane().add(totalWOPaypalFee);

		subTotal_txtField = new JTextField();
		subTotal_txtField.setBorder(null);
		subTotal_txtField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		subTotal_txtField.setBounds(505, 91, 99, 33);
		frmHairProductsCalculator.getContentPane().add(subTotal_txtField);
		subTotal_txtField.setColumns(10);

		// SEPARATORS
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(428, 348, 231, 2);
		frmHairProductsCalculator.getContentPane().add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(428, 235, 231, 2);
		frmHairProductsCalculator.getContentPane().add(separator_2);

		separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 0, 0));
		separator_3.setBackground(new Color(0, 0, 0));
		separator_3.setBounds(428, 135, 231, 2);
		frmHairProductsCalculator.getContentPane().add(separator_3);

		separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 0));
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(428, 623, 231, 2);
		frmHairProductsCalculator.getContentPane().add(separator_4);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(414, 11, 2, 689);
		frmHairProductsCalculator.getContentPane().add(separator);

	}
	
	/*THIS TRACKS WHAT LENGTH AND QUANTITY USERS SELECT FROM COMBO BOX
	THEN IT PRINTS OUT THE PATTERN ALONG WITH THE LENGTH AND QUANTITY*/
	public String straightOrder()
	{
		if(straightLengths.getSelectedIndex() == 0)
			straightString = "";
		if(straightLengths.getSelectedIndex() == 1)
			straightString += "10\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 2)
			straightString += "12\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 3)
			straightString += "14\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 4)
			straightString += "16\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 5)
			straightString += "18\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 6)
			straightString += "20\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 7)
			straightString += "22\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 8)
			straightString += "24\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 9)
			straightString += "26\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 10)
			straightString += "28\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 11)
			straightString += "30\" x " + straightQuantity.getSelectedIndex() + "\n";
		
		return straightString;
	}
	
	/*THIS TRACKS WHAT LENGTH AND QUANTITY USERS SELECT FROM COMBO BOX
	THEN IT PRINTS OUT THE PATTERN ALONG WITH THE LENGTH AND QUANTITY*/
	public String looseOrder()
	{
		if(looseLengths.getSelectedIndex() == 0)
			straightString = "";
		if(straightLengths.getSelectedIndex() == 1)
			straightString += "10\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 2)
			straightString += "12\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 3)
			straightString += "14\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 4)
			straightString += "16\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 5)
			straightString += "18\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 6)
			straightString += "20\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 7)
			straightString += "22\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 8)
			straightString += "24\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 9)
			straightString += "26\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 10)
			straightString += "28\" x " + straightQuantity.getSelectedIndex() + "\n";
		if(straightLengths.getSelectedIndex() == 11)
			straightString += "30\" x " + straightQuantity.getSelectedIndex() + "\n";
		
		return straightString;
	}
}
