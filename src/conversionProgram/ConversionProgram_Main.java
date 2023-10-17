/* 
 * NAME: Tracy Bullock
 * CLASS: CMIS 242 (2215)
 * DATE: May 30, 2021
 * 
 * This program is made to convert temperature from either Fahrenheit to Celsius
 * or Celsius to Fahrenheit and distance from either miles to Kilometers or
 * kilometers to miles. To do this, the user will be prompted for the conversion
 * they would like to make and have to press continue. They will then be prompted 
 * for the value to be converted and have to click convert. At anytime the user
 * can select the desired page from the file drop menu under page selection. The 
 * user can also click back from any conversion page to return to the main page.
 * class and student information can also be found in the info drop menu. To 
 * close the program the user must click the x in the upper right corner or 
 * select exit under the file drop menu. if a selection is not made or appropriate 
 * information not entered during the program, an error message will be displayed.
 * 
 */

package conversionProgram;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class ConversionProgram_Main extends JFrame {

	private JPanel contentPane, startPanel, toCelsiusPanel, 
		toCelsiusTitlePanel, toCelsiusConversionPanel, toFahrPanel, 
		toFahrTitlePanel, toFahrConversionPanel, toKmPanel, 
		toKmTitlePanel, toKmConversionPanel, toMilesTitlePanel, 
		toMilesConversionPanel, toMilesPanel;
	private final ButtonGroup bgMeassurment = new ButtonGroup();
	private String[] options;
	private JButton btnContinue, btnToCelsiusBack, btnConvertToCelsius, 
		btnToFahrBack, btnConvertToFahr, btnToKmBack, btnConvertToKm, 
		btnToMilesBack, btnConvertToMiles;
	private JLayeredPane layeredPane;
	private JRadioButton rbTemperature, rbDistance;
	private JComboBox cbConversionType;
	private JLabel lblFahrenheitToCelcius, lblEnterFahr, lblCelciusToFahrenheit, 
		lblGetFahr, lblEnterCelsius, lblMilesToKilometers, lblGetKm, lblEnterMiles, 
		lblKilometersToMiles, lblGetMiles, lblEnterKm, lblToCelsiusIntructions, 
		lblToFahrIntructions, lblToKmIntructions, lblToMilesIntructions;
	private JTextField txtEnterFahr, txtGetCelsius, txtGetFahr, txtEnterCelsius, 
		txtGetKm, txtEnterMiles, txtGetMiles, txtEnterKm;
	private JMenu menuPageSelection, menuInfo;
	private JMenuItem menuExit, menuMainPage, menuFahrToCels, menuCelsToFahr, 
		menuMiToKm, menuKmToMi, menuClassInfo, menuStudentInfo;

	//////////////////////////////////////
	// Launch the application.
	////////////////////////////////////
	public static void main(String[] args) {
		
		///////////////////////////
		// Customize DialogPanes
		/////////////////////////
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager UI = new UIManager();
		UI.put("OptionPane.messageFont", new FontUIResource("Arial", Font.BOLD, 12));
		UI.put("OptionPane.background", new ColorUIResource(144,146,151));
		UI.put("OptionPane.messageForeground", new ColorUIResource(252,252,252));
		UI.put("Panel.background", new ColorUIResource(112,112,114));
		
		intro();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversionProgram_Main frame = new ConversionProgram_Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	////////////////////////////
	// Create the frame.
	//////////////////////////
	public ConversionProgram_Main() {
		
		initComponents();
		createEvents();
	}
	
	/////////////////////////////////////////////////////////
	// method to give class info and indroduce program
	///////////////////////////////////////////////////////
	public static void intro() {
					
		// window for class info
		JOptionPane.showInternalMessageDialog(null, "\n      " + 
				"NAME: Tracy Bullock\n      " + 
				"CLASS: CMIS 242 (2215)               \n      DATE: 05/30/2021\n ", 
				"Class Project", JOptionPane.INFORMATION_MESSAGE);
					
		// window for app intro
		JOptionPane.showInternalMessageDialog(null, "\n    Welcome to the Westinghouse Conversion Program!    \n" + 
				"\n      The best temperature & distance coversion app!  \n ", 
				"Westinghouse International", JOptionPane.PLAIN_MESSAGE);
		}
	
	///////////////////////////////
	// method to say goodbye
	/////////////////////////////
	public static void outro() {
		
		JOptionPane.showInternalMessageDialog(null, "\n      Thank you for using the "
				+ "Westinghouse Conversion Program.      \n" + 
				"\n                                           Have a great day!\n ", 
				"GoodBye", JOptionPane.PLAIN_MESSAGE);
	}
	
	////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating and
	// initializing components.
	//////////////////////////////////////////////////////////////////
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 406, 399);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		menuPageSelection = new JMenu("Page Selection");
		menuPageSelection.setIcon(new ImageIcon(ConversionProgram_Main.class.getResource("/resources/selectionIcon.png")));
		mnNewMenu.add(menuPageSelection);
		
		menuMainPage = new JMenuItem("Main Page");
		menuPageSelection.add(menuMainPage);
		
		menuFahrToCels = new JMenuItem("Fahrenheit to Celsius");
		menuPageSelection.add(menuFahrToCels);
		
		menuCelsToFahr = new JMenuItem("Celsius To Fahrenheit");
		menuPageSelection.add(menuCelsToFahr);
		
		menuMiToKm = new JMenuItem("Miles to Kilometers");
		menuPageSelection.add(menuMiToKm);
		
		menuKmToMi = new JMenuItem("Kilometers to Miles");
		menuPageSelection.add(menuKmToMi);
		
		menuExit = new JMenuItem("Exit Program");
		menuExit.setIcon(new ImageIcon(ConversionProgram_Main.class.getResource("/resources/exitIcon.png")));
		mnNewMenu.add(menuExit);
		
		menuInfo = new JMenu("Info");
		menuBar.add(menuInfo);
		
		menuClassInfo = new JMenuItem("Class Info");
		menuClassInfo.setIcon(new ImageIcon(ConversionProgram_Main.class.getResource("/resources/classIcon.png")));
		menuInfo.add(menuClassInfo);
		
		menuStudentInfo = new JMenuItem("Student Info");
		menuStudentInfo.setIcon(new ImageIcon(ConversionProgram_Main.class.getResource("/resources/studentIcon.png")));
		menuInfo.add(menuStudentInfo);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 394, 344);
		contentPane.add(layeredPane);
		
		startPanel = new JPanel();
		startPanel.setBackground(Color.DARK_GRAY);
		startPanel.setBounds(0, 0, 394, 344);
		layeredPane.add(startPanel);
		
		JPanel StartTitlePanel = new JPanel();
		StartTitlePanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblStartQuestion = new JLabel("    What would you like to convert?");
		lblStartQuestion.setFont(new Font("Calibri Light", Font.BOLD, 22));
		GroupLayout gl_StartTitlePanel = new GroupLayout(StartTitlePanel);
		gl_StartTitlePanel.setHorizontalGroup(
			gl_StartTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_StartTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStartQuestion, GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_StartTitlePanel.setVerticalGroup(
			gl_StartTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_StartTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStartQuestion, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addContainerGap())
		);
		StartTitlePanel.setLayout(gl_StartTitlePanel);
		
		JPanel SelectionPanel = new JPanel();
		SelectionPanel.setBackground(Color.LIGHT_GRAY);
		
		rbTemperature = new JRadioButton("Temperature");
		bgMeassurment.add(rbTemperature);
		rbTemperature.setBackground(Color.LIGHT_GRAY);
		
		rbDistance = new JRadioButton("Distance");
		bgMeassurment.add(rbDistance);
		rbDistance.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblMeassurement = new JLabel("Conversion Messurement:");
		
		JLabel lblConversionType = new JLabel("Conversion Type:");
		
		cbConversionType = new JComboBox();
		cbConversionType.setModel(new DefaultComboBoxModel(new String[] {"Select an option"}));
		GroupLayout gl_SelectionPanel = new GroupLayout(SelectionPanel);
		gl_SelectionPanel.setHorizontalGroup(
			gl_SelectionPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 364, Short.MAX_VALUE)
				.addGroup(gl_SelectionPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_SelectionPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_SelectionPanel.createSequentialGroup()
							.addGap(49)
							.addComponent(rbTemperature)
							.addGap(18)
							.addComponent(rbDistance))
						.addComponent(lblMeassurement)
						.addGroup(gl_SelectionPanel.createSequentialGroup()
							.addComponent(lblConversionType)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbConversionType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_SelectionPanel.setVerticalGroup(
			gl_SelectionPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 205, Short.MAX_VALUE)
				.addGroup(gl_SelectionPanel.createSequentialGroup()
					.addGap(49)
					.addComponent(lblMeassurement, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_SelectionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbTemperature)
						.addComponent(rbDistance))
					.addGap(18)
					.addGroup(gl_SelectionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConversionType, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbConversionType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		SelectionPanel.setLayout(gl_SelectionPanel);
		
		btnContinue = new JButton("Continue");
		
		GroupLayout gl_startPanel = new GroupLayout(startPanel);
		gl_startPanel.setHorizontalGroup(
			gl_startPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_startPanel.createSequentialGroup()
					.addGroup(gl_startPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_startPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_startPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(StartTitlePanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
								.addComponent(SelectionPanel, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)))
						.addGroup(gl_startPanel.createSequentialGroup()
							.addGap(160)
							.addComponent(btnContinue)))
					.addContainerGap())
		);
		gl_startPanel.setVerticalGroup(
			gl_startPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_startPanel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(StartTitlePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(SelectionPanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnContinue)
					.addContainerGap())
		);
		startPanel.setLayout(gl_startPanel);
		
		toCelsiusPanel = new JPanel();
		toCelsiusPanel.setBackground(Color.DARK_GRAY);
		layeredPane.setLayer(toCelsiusPanel, 0);
		toCelsiusPanel.setBounds(0, 0, 394, 344);
		layeredPane.add(toCelsiusPanel);
		
		toCelsiusTitlePanel = new JPanel();
		toCelsiusTitlePanel.setBackground(Color.LIGHT_GRAY);
		
		lblFahrenheitToCelcius = new JLabel("                Fahrenheit to Celcius");
		lblFahrenheitToCelcius.setFont(new Font("Calibri Light", Font.BOLD, 22));
		GroupLayout gl_toCelsiusTitlePanel = new GroupLayout(toCelsiusTitlePanel);
		gl_toCelsiusTitlePanel.setHorizontalGroup(
			gl_toCelsiusTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 374, Short.MAX_VALUE)
				.addGroup(gl_toCelsiusTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFahrenheitToCelcius, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_toCelsiusTitlePanel.setVerticalGroup(
			gl_toCelsiusTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_toCelsiusTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFahrenheitToCelcius, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addContainerGap())
		);
		toCelsiusTitlePanel.setLayout(gl_toCelsiusTitlePanel);
		
		toCelsiusConversionPanel = new JPanel();
		toCelsiusConversionPanel.setBackground(Color.LIGHT_GRAY);
		
		lblEnterFahr = new JLabel("Enter temp to be converted:");
		
		txtEnterFahr = new JTextField();
		txtEnterFahr.setColumns(10);
		
		JLabel lblGetCelsius = new JLabel("Conversion:");
		
		txtGetCelsius = new JTextField();
		txtGetCelsius.setEditable(false);
		txtGetCelsius.setColumns(10);
		
		lblToCelsiusIntructions = new JLabel("Click back button to return to main menu or X to close");
		GroupLayout gl_toCelsiusConversionPanel = new GroupLayout(toCelsiusConversionPanel);
		gl_toCelsiusConversionPanel.setHorizontalGroup(
			gl_toCelsiusConversionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toCelsiusConversionPanel.createSequentialGroup()
					.addGroup(gl_toCelsiusConversionPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_toCelsiusConversionPanel.createSequentialGroup()
							.addContainerGap(112, Short.MAX_VALUE)
							.addComponent(lblGetCelsius)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGetCelsius, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_toCelsiusConversionPanel.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_toCelsiusConversionPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblToCelsiusIntructions)
								.addGroup(gl_toCelsiusConversionPanel.createSequentialGroup()
									.addComponent(lblEnterFahr)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEnterFahr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_toCelsiusConversionPanel.setVerticalGroup(
			gl_toCelsiusConversionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_toCelsiusConversionPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_toCelsiusConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterFahr)
						.addComponent(txtEnterFahr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_toCelsiusConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGetCelsius)
						.addComponent(txtGetCelsius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblToCelsiusIntructions))
		);
		toCelsiusConversionPanel.setLayout(gl_toCelsiusConversionPanel);
		
		btnToCelsiusBack = new JButton("Back");
		
		btnConvertToCelsius = new JButton("Convert");
		
		GroupLayout gl_toCelsiusPanel = new GroupLayout(toCelsiusPanel);
		gl_toCelsiusPanel.setHorizontalGroup(
			gl_toCelsiusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toCelsiusPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_toCelsiusPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(toCelsiusTitlePanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addComponent(toCelsiusConversionPanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_toCelsiusPanel.createSequentialGroup()
							.addComponent(btnToCelsiusBack)
							.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
							.addComponent(btnConvertToCelsius)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_toCelsiusPanel.setVerticalGroup(
			gl_toCelsiusPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toCelsiusPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(toCelsiusTitlePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(toCelsiusConversionPanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_toCelsiusPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnToCelsiusBack)
						.addComponent(btnConvertToCelsius))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		toCelsiusPanel.setLayout(gl_toCelsiusPanel);
		
		toFahrPanel = new JPanel();
		layeredPane.setLayer(toFahrPanel, 0);
		toFahrPanel.setBackground(Color.DARK_GRAY);
		toFahrPanel.setBounds(0, 0, 394, 344);
		layeredPane.add(toFahrPanel);
		
		toFahrTitlePanel = new JPanel();
		toFahrTitlePanel.setBackground(Color.LIGHT_GRAY);
		
		lblCelciusToFahrenheit = new JLabel("                Celcius to Fahrenheit");
		lblCelciusToFahrenheit.setFont(new Font("Calibri Light", Font.BOLD, 22));
		GroupLayout gl_toFahrTitlePanel = new GroupLayout(toFahrTitlePanel);
		gl_toFahrTitlePanel.setHorizontalGroup(
			gl_toFahrTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 374, Short.MAX_VALUE)
				.addGroup(gl_toFahrTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCelciusToFahrenheit, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_toFahrTitlePanel.setVerticalGroup(
			gl_toFahrTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_toFahrTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCelciusToFahrenheit, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addContainerGap())
		);
		toFahrTitlePanel.setLayout(gl_toFahrTitlePanel);
		
		toFahrConversionPanel = new JPanel();
		toFahrConversionPanel.setBackground(Color.LIGHT_GRAY);
		
		lblGetFahr = new JLabel("Conversion:");
		
		txtGetFahr = new JTextField();
		txtGetFahr.setEditable(false);
		txtGetFahr.setColumns(10);
		
		lblEnterCelsius = new JLabel("Enter temp to be converted:");
		
		txtEnterCelsius = new JTextField();
		txtEnterCelsius.setColumns(10);
		
		lblToFahrIntructions = new JLabel("Click back button to return to main menu or X to close");
		GroupLayout gl_toFahrConversionPanel = new GroupLayout(toFahrConversionPanel);
		gl_toFahrConversionPanel.setHorizontalGroup(
			gl_toFahrConversionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toFahrConversionPanel.createSequentialGroup()
					.addGroup(gl_toFahrConversionPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_toFahrConversionPanel.createSequentialGroup()
							.addContainerGap(112, Short.MAX_VALUE)
							.addComponent(lblGetFahr)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGetFahr, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_toFahrConversionPanel.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_toFahrConversionPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblToFahrIntructions, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_toFahrConversionPanel.createSequentialGroup()
									.addComponent(lblEnterCelsius)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEnterCelsius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_toFahrConversionPanel.setVerticalGroup(
			gl_toFahrConversionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_toFahrConversionPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_toFahrConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterCelsius)
						.addComponent(txtEnterCelsius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_toFahrConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGetFahr)
						.addComponent(txtGetFahr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblToFahrIntructions))
		);
		toFahrConversionPanel.setLayout(gl_toFahrConversionPanel);
		
		btnToFahrBack = new JButton("Back");
		
		btnConvertToFahr = new JButton("Convert");
		GroupLayout gl_toFahrPanel = new GroupLayout(toFahrPanel);
		gl_toFahrPanel.setHorizontalGroup(
			gl_toFahrPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE)
				.addGroup(gl_toFahrPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_toFahrPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(toFahrTitlePanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addComponent(toFahrConversionPanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_toFahrPanel.createSequentialGroup()
							.addComponent(btnToFahrBack)
							.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
							.addComponent(btnConvertToFahr)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_toFahrPanel.setVerticalGroup(
			gl_toFahrPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 344, Short.MAX_VALUE)
				.addGroup(gl_toFahrPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(toFahrTitlePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(toFahrConversionPanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_toFahrPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnToFahrBack)
						.addComponent(btnConvertToFahr))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		toFahrPanel.setLayout(gl_toFahrPanel);
		
		toKmPanel = new JPanel();
		layeredPane.setLayer(toKmPanel, 0);
		toKmPanel.setBackground(Color.DARK_GRAY);
		toKmPanel.setBounds(0, 0, 394, 344);
		layeredPane.add(toKmPanel);
		
		toKmTitlePanel = new JPanel();
		toKmTitlePanel.setBackground(Color.LIGHT_GRAY);
		
		lblMilesToKilometers = new JLabel("                   Miles to Kilometers");
		lblMilesToKilometers.setFont(new Font("Calibri Light", Font.BOLD, 22));
		GroupLayout gl_toKmTitlePanel = new GroupLayout(toKmTitlePanel);
		gl_toKmTitlePanel.setHorizontalGroup(
			gl_toKmTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 374, Short.MAX_VALUE)
				.addGroup(gl_toKmTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMilesToKilometers, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_toKmTitlePanel.setVerticalGroup(
			gl_toKmTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_toKmTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMilesToKilometers, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addContainerGap())
		);
		toKmTitlePanel.setLayout(gl_toKmTitlePanel);
		
		toKmConversionPanel = new JPanel();
		toKmConversionPanel.setBackground(Color.LIGHT_GRAY);
		
		lblGetKm = new JLabel("Conversion:");
		
		txtGetKm = new JTextField();
		txtGetKm.setEditable(false);
		txtGetKm.setColumns(10);
		
		lblEnterMiles = new JLabel("Enter distance to be converted:");
		
		txtEnterMiles = new JTextField();
		txtEnterMiles.setColumns(10);
		
		lblToKmIntructions = new JLabel("Click back button to return to main menu or X to close");
		GroupLayout gl_toKmConversionPanel = new GroupLayout(toKmConversionPanel);
		gl_toKmConversionPanel.setHorizontalGroup(
			gl_toKmConversionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toKmConversionPanel.createSequentialGroup()
					.addGroup(gl_toKmConversionPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_toKmConversionPanel.createSequentialGroup()
							.addContainerGap(112, Short.MAX_VALUE)
							.addComponent(lblGetKm)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGetKm, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_toKmConversionPanel.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_toKmConversionPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblToKmIntructions, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_toKmConversionPanel.createSequentialGroup()
									.addComponent(lblEnterMiles)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEnterMiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_toKmConversionPanel.setVerticalGroup(
			gl_toKmConversionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_toKmConversionPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_toKmConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterMiles)
						.addComponent(txtEnterMiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_toKmConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGetKm)
						.addComponent(txtGetKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblToKmIntructions))
		);
		toKmConversionPanel.setLayout(gl_toKmConversionPanel);
		
		btnToKmBack = new JButton("Back");
		
		btnConvertToKm = new JButton("Convert");
		GroupLayout gl_toKmPanel = new GroupLayout(toKmPanel);
		gl_toKmPanel.setHorizontalGroup(
			gl_toKmPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE)
				.addGroup(gl_toKmPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_toKmPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(toKmTitlePanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addComponent(toKmConversionPanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_toKmPanel.createSequentialGroup()
							.addComponent(btnToKmBack)
							.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
							.addComponent(btnConvertToKm)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_toKmPanel.setVerticalGroup(
			gl_toKmPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 344, Short.MAX_VALUE)
				.addGroup(gl_toKmPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(toKmTitlePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(toKmConversionPanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_toKmPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnToKmBack)
						.addComponent(btnConvertToKm))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		toKmPanel.setLayout(gl_toKmPanel);
		
		toMilesPanel = new JPanel();
		layeredPane.setLayer(toMilesPanel, 0);
		toMilesPanel.setBackground(Color.DARK_GRAY);
		toMilesPanel.setBounds(0, 0, 394, 344);
		layeredPane.add(toMilesPanel);
		
		toMilesTitlePanel = new JPanel();
		toMilesTitlePanel.setBackground(Color.LIGHT_GRAY);
		
		lblKilometersToMiles = new JLabel("                   Kilometers to Miles");
		lblKilometersToMiles.setFont(new Font("Calibri Light", Font.BOLD, 22));
		GroupLayout gl_toMilesTitlePanel = new GroupLayout(toMilesTitlePanel);
		gl_toMilesTitlePanel.setHorizontalGroup(
			gl_toMilesTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 374, Short.MAX_VALUE)
				.addGroup(gl_toMilesTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKilometersToMiles, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_toMilesTitlePanel.setVerticalGroup(
			gl_toMilesTitlePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
				.addGroup(gl_toMilesTitlePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKilometersToMiles, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addContainerGap())
		);
		toMilesTitlePanel.setLayout(gl_toMilesTitlePanel);
		
		toMilesConversionPanel = new JPanel();
		toMilesConversionPanel.setBackground(Color.LIGHT_GRAY);
		
		lblGetMiles = new JLabel("Conversion:");
		
		txtGetMiles = new JTextField();
		txtGetMiles.setEditable(false);
		txtGetMiles.setColumns(10);
		
		lblEnterKm = new JLabel("Enter distance to be converted:");
		
		txtEnterKm = new JTextField();
		txtEnterKm.setColumns(10);
		
		lblToMilesIntructions = new JLabel("Click back button to return to main menu or X to close");
		GroupLayout gl_toMilesConversionPanel = new GroupLayout(toMilesConversionPanel);
		gl_toMilesConversionPanel.setHorizontalGroup(
			gl_toMilesConversionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toMilesConversionPanel.createSequentialGroup()
					.addGroup(gl_toMilesConversionPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_toMilesConversionPanel.createSequentialGroup()
							.addContainerGap(112, Short.MAX_VALUE)
							.addComponent(lblGetMiles)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtGetMiles, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_toMilesConversionPanel.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_toMilesConversionPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblToMilesIntructions, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_toMilesConversionPanel.createSequentialGroup()
									.addComponent(lblEnterKm)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEnterKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_toMilesConversionPanel.setVerticalGroup(
			gl_toMilesConversionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_toMilesConversionPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_toMilesConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterKm)
						.addComponent(txtEnterKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(gl_toMilesConversionPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGetMiles)
						.addComponent(txtGetMiles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(lblToMilesIntructions))
		);
		toMilesConversionPanel.setLayout(gl_toMilesConversionPanel);
		
		btnToMilesBack = new JButton("Back");
		
		btnConvertToMiles = new JButton("Convert");
		GroupLayout gl_toMilesPanel = new GroupLayout(toMilesPanel);
		gl_toMilesPanel.setHorizontalGroup(
			gl_toMilesPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 394, Short.MAX_VALUE)
				.addGroup(gl_toMilesPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_toMilesPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(toMilesTitlePanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addComponent(toMilesConversionPanel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_toMilesPanel.createSequentialGroup()
							.addComponent(btnToMilesBack)
							.addPreferredGap(ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
							.addComponent(btnConvertToMiles)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_toMilesPanel.setVerticalGroup(
			gl_toMilesPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 344, Short.MAX_VALUE)
				.addGroup(gl_toMilesPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(toMilesTitlePanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(toMilesConversionPanel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_toMilesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnToMilesBack)
						.addComponent(btnConvertToMiles))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		toMilesPanel.setLayout(gl_toMilesPanel);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversionProgram_Main.class.getResource("/resources/westinghouse.png")));
		setTitle("Westinghouse Conversion Program");
	}
	
	////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating events.
	///////////////////////////////////////////////////////////////////
	private void createEvents() {
		
		///////////////////////////////////////
		// listener to detect program close
		/////////////////////////////////////
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				int close = JOptionPane.showConfirmDialog(null, "\n  Would you like to close this application?        ", 
						"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (close == JOptionPane.YES_OPTION) {
					outro();
					System.exit(0);;
				}
			 }
		});
		
		//////////////////////////////////////////
		// actionlistener for temp radio button
		////////////////////////////////////////
		rbTemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rbTemperature.isSelected()) {
					cbConversionType.setModel(new DefaultComboBoxModel(getOptions("temperature")));
				}
				
			}
		});
		
		//////////////////////////////////////////////
		// actionlistener for distance radio button
		////////////////////////////////////////////
		rbDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rbDistance.isSelected()) {
					cbConversionType.setModel(new DefaultComboBoxModel(getOptions("distance")));
				}
				
			}
		});
		
		//////////////////////////////////////////////
		// actionlistener for continue button
		////////////////////////////////////////////
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				if (((String)cbConversionType.getSelectedItem()).equalsIgnoreCase("fahrenheit to celsius")) {
					layeredPane.add(toCelsiusPanel);
				} else if (((String)cbConversionType.getSelectedItem()).equalsIgnoreCase("celsius to fahrenheit")) {
					layeredPane.add(toFahrPanel);
				} else if (((String)cbConversionType.getSelectedItem()).equalsIgnoreCase("miles to kilometers")) {
					layeredPane.add(toKmPanel);
				} else if (((String)cbConversionType.getSelectedItem()).equalsIgnoreCase("kilometers to miles")) {
					layeredPane.add(toMilesPanel);
				} else {
					JOptionPane.showMessageDialog(null, "\n       Invalid Selection!", "Error", 
							JOptionPane.ERROR_MESSAGE);
					layeredPane.add(startPanel);
					clearStartPanel();
				}
				
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for convert button when converting to celsius
		////////////////////////////////////////////////////////////////
		btnConvertToCelsius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FahrToCelsius toCelsius = new FahrToCelsius();
				toCelsius.setConversion(txtEnterFahr.getText());
				if (!(toCelsius.getConversion() == null)) {
					txtGetCelsius.setText(toCelsius.getConversion());
				} else {
					clearToCelsiusTxt();
				}
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for back button when converting to celsius
		////////////////////////////////////////////////////////////////
		btnToCelsiusBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clearToCelsiusTxt();
				layeredPane.removeAll();
				layeredPane.add(startPanel);
				clearStartPanel();
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for convert button when converting to fahr
		////////////////////////////////////////////////////////////////
		btnConvertToFahr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CelsiusToFahr toFahr = new CelsiusToFahr();
				toFahr.setConversion(txtEnterCelsius.getText());
				if (!(toFahr.getConversion() == null)) {
					txtGetFahr.setText(toFahr.getConversion());
				} else {
					clearToFahrTxt();
				}
			}
		});
		
		///////////////////////////////////////////////////////////////
		// actionlistener for back button when converting to fahr
		/////////////////////////////////////////////////////////////
		btnToFahrBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				clearToFahrTxt();
				layeredPane.add(startPanel);
				clearStartPanel();
			}
		});
		
		////////////////////////////////////////////////////////////////
		// actionlistener for convert button when converting to km
		//////////////////////////////////////////////////////////////
		btnConvertToKm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MilesToKm toKm = new MilesToKm();
				toKm.setConversion(txtEnterMiles.getText());
				if (!(toKm.getConversion() == null)) {
					txtGetKm.setText(toKm.getConversion());
				} else {
					clearToKmTxt();
				}
			}
		});
		
		/////////////////////////////////////////////////////////////
		// actionlistener for back button when converting to km
		///////////////////////////////////////////////////////////
		btnToKmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				clearToKmTxt();
				layeredPane.add(startPanel);
				clearStartPanel();
			}
		});
		
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for convert button when converting to miles
		////////////////////////////////////////////////////////////////
		btnConvertToMiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KmToMiles toMiles = new KmToMiles();
				toMiles.setConversion(txtEnterKm.getText());
				if (!(toMiles.getConversion() == null)) {
					txtGetMiles.setText(toMiles.getConversion());
				} else {
					clearToMilesTxt();
				}
			}
		});
		
		////////////////////////////////////////////////////////////////
		// actionlistener for back button when converting to miles
		//////////////////////////////////////////////////////////////
		btnToMilesBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				clearToMilesTxt();
				layeredPane.add(startPanel);
				clearStartPanel();
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item main page selection
		////////////////////////////////////////////////////////////////
		menuMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				clearToFahrTxt();
				clearToCelsiusTxt();
				clearToMilesTxt();
				clearToKmTxt();
				layeredPane.add(startPanel);
				clearStartPanel();
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item fahr to celsius selection
		////////////////////////////////////////////////////////////////
		menuFahrToCels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(toCelsiusPanel);
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item celsius to fahr selection
		////////////////////////////////////////////////////////////////
		menuCelsToFahr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(toFahrPanel);
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item miles to km selection
		////////////////////////////////////////////////////////////////
		menuMiToKm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(toKmPanel);
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item km to miles selection
		////////////////////////////////////////////////////////////////
		menuKmToMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				layeredPane.removeAll();
				layeredPane.add(toMilesPanel);
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item exit program selection
		////////////////////////////////////////////////////////////////
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int close = JOptionPane.showConfirmDialog(null, "\n  Would you like to close this application?        ", 
						"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (close == JOptionPane.YES_OPTION) {
					outro();
					System.exit(0);;
				}
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item class info selection
		////////////////////////////////////////////////////////////////
		menuClassInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "\nSEMESTER:   Summer 2021\n\n"
						+ "CLASS:          CMIS 242 Intermediate Programming (2215)    \n"
						+ "\nDATES:           05/12/2021 - 06/29/2021\n ", 
						"CLASS INFORMATION", JOptionPane.PLAIN_MESSAGE, new ImageIcon(ConversionProgram_Main.class.getResource("/resources/UMGC.png")));
			}
		});
		
		//////////////////////////////////////////////////////////////////
		// actionlistener for menu item student info selection
		////////////////////////////////////////////////////////////////
		menuStudentInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "DEGREE PATH:\n                            Bachelors - Computer Networks & Cybersecurity    \n"
						+ "                            Minor - Computer Science\n"
						+ "              NAME:\n                            Tracy Bullock\n"
						+ "                 AGE:\n                            33\n ", 
						"STUDENT INFORMATION", JOptionPane.PLAIN_MESSAGE, new ImageIcon(ConversionProgram_Main.class.getResource("/resources/ME.png")));
			}
		});
	}
	
	//////////////////////////////////////////////////////////////////
	// method to get main page options from radio button selections
	////////////////////////////////////////////////////////////////
	private String[] getOptions(String measurement) {
		
		if (measurement.equalsIgnoreCase("temperature")) {
			return options = new String[] {"Select an option", "Fahrenheit to Celsius", "Celsius to Fahrenheit"};
		} else {
			return options = new String[] {"Select an option", "Miles to Kilometers", "Kilometers to Miles"};
		}
	}
	
	//////////////////////////////////////////////////////
	// method to clear the start panel selections
	////////////////////////////////////////////////////
	private void clearStartPanel() {
		
		cbConversionType.setModel(new DefaultComboBoxModel(new String[] {"Select an option"}));
		bgMeassurment.clearSelection();
		
	}
	
	///////////////////////////////////////////////////////////
	// method to clear the panel on convert to celsius panel
	/////////////////////////////////////////////////////////
	private void clearToCelsiusTxt() {
		
		txtEnterFahr.setText("");
		txtGetCelsius.setText("");
	}
	
	///////////////////////////////////////////////////////////
	// method to clear the panel on convert to fahr panel
	/////////////////////////////////////////////////////////
	private void clearToFahrTxt() {
		txtEnterCelsius.setText("");
		txtGetFahr.setText("");
	}
	
	///////////////////////////////////////////////////////////
	// method to clear the panel on convert to km panel
	/////////////////////////////////////////////////////////
	private void clearToKmTxt() {
		txtEnterMiles.setText("");
		txtGetKm.setText("");
	}
	
	///////////////////////////////////////////////////////////
	// method to clear the panel on convert to miles panel
	/////////////////////////////////////////////////////////
	private void clearToMilesTxt() {
		txtEnterKm.setText("");
		txtGetMiles.setText("");
	}
}
