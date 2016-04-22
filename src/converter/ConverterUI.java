package converter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;;

/**
 * 
 * @author 5810545416-Thanut
 *
 */
public class ConverterUI extends JFrame {
	// attributes for graphical component
	private JButton convertButton;
	private UnitConverter unitconverter;
	private JPanel contentPane;
	private JTextField inputField1;
	private JTextField inputField2;
	private JComboBox comboBox1;
	private JComboBox comboBox2;

	
	/**
	 * 
	 * main method for run the program's UI
	 */
	public static void main(String[] args) {
		UnitConverter unitconverter = new UnitConverter();
		ConverterUI form = new ConverterUI(unitconverter);
		form.setVisible(true);
	}
	
	/**
	 * 
	 * Constructor of this program
	 */
	public ConverterUI( UnitConverter uc){
		this.unitconverter = uc;
		this.setTitle("Length Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	/**
	 * initialize components in the window
	 */
	private void initComponents(){
		setBounds(100, 100, 450, 80);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setResizable(false);
		
		contentPane.setLayout(new GridLayout(2,1));
		
		Container body = new Container();
		body.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		inputField1 = new JTextField(10);
		inputField1.setHorizontalAlignment(SwingConstants.RIGHT);
		inputField1.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e){
				inputField1.setText("");
            }
		});
		inputField1.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					inputField1.addActionListener(new ConvertButtonListener());
				}
			}
		});
		body.add(inputField1);
		
		comboBox1 = new JComboBox(unitconverter.getUnits());
		body.add(comboBox1);
		
		JLabel label = new JLabel(" = ");
		body.add(label);
		
		inputField2 = new JTextField(10);
		inputField2.setHorizontalAlignment(SwingConstants.RIGHT);
		inputField2.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e){
				inputField2.setText("");
            }
		});
		inputField2.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					inputField2.addActionListener(new ConvertButtonListener());
				}
			}
		});
		body.add(inputField2);
		
		comboBox2 = new JComboBox(unitconverter.getUnits());
		body.add(comboBox2);
		
		JButton ConvertButton = new JButton("Convert!");
		ConvertButton.addActionListener(new ConvertButtonListener());
		body.add(ConvertButton);
		
		JButton ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputField1.setText("");
				inputField2.setText("");
			}
		});
		body.add(ClearButton);
		
		Container option = new Container();
		option.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton LeftToRight = new JRadioButton("Left - > Right");
		LeftToRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(LeftToRight.isSelected()){
					inputField1.setEnabled(false);
					inputField1.setText("");
				}else{
					inputField1.setEnabled(true);
					inputField1.setText("");
				}
				
			}
		});
		option.add(LeftToRight);
		
		JRadioButton RightToLeft = new JRadioButton("Right - > Left");
		RightToLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(RightToLeft.isSelected()){
					inputField2.setEnabled(false);
					inputField2.setText("");
				}else{
					inputField2.setEnabled(true);
					inputField2.setText("");
				}
			}
		});
		option.add(RightToLeft);
		contentPane.add(body);
		contentPane.add(option);
		this.pack();
	}
	
	/**
	 * ConvertButtonListener is an ActionListener that perform an action when
	 * the button is pressed. It is an inner class so it can access private
	 * attributes of ConverterUI
	 * It reads the text from a JTextField, convert the value to a number,
	 * call the unitconverter to convert, and write result in other text field.
	 */
	class ConvertButtonListener implements ActionListener{
		/** the action to perform action when the "convert" button or enter key is pressed */
		
		public void actionPerformed(ActionEvent e) {
			String s = inputField1.getText().trim();
			//This line is for testing. Comment it out after you see how it works.
			if(s.length() >0){
				try{
					double value = Double.valueOf(s);
					Unit formUnit = (Unit)comboBox1.getSelectedItem();
					Unit toUnit = (Unit)comboBox2.getSelectedItem();
					inputField2.setText(String.format("%.3f", unitconverter.convert(value, formUnit, toUnit)));
				}catch(Exception e1){
					System.out.println(e1);
					inputField1.setText("Error");
					inputField2.setText("Error");
				}
			}else{
				try{
					double value = Double.valueOf(inputField2.getText().trim());
					Unit formUnit = (Unit)comboBox2.getSelectedItem();
					Unit toUnit = (Unit)comboBox1.getSelectedItem();
					inputField1.setText(String.format("%.3f", unitconverter.convert(value, formUnit, toUnit)));
				}catch(Exception e1){
					System.out.println(e1);
					inputField1.setText("Error");
					inputField2.setText("Error");
				}
			}
		}
	}
}
