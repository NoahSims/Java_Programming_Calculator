import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgrammerCalc extends JFrame implements ActionListener
{
	static final long serialVersionUID = 0; // I don't know what this means but JFrame says I need it
	JButton menuButton;
	JLabel titleLabel, equationLabel, answerLabel;
	JButton hexLabel, decLabel, octLabel, binLabel;
	JButton placeHolderButton, wordButton, msButton, mButton;
	JButton lshButton, rshButton, orButton, xOrButton, notButton, andButton;					// row 0
	JButton secondButton, modButton, clearEButton, clearButton, backButton, divButton;			// row 1
	JButton numAButton, numBButton, num7Button, num8Button, num9Button, multButton;				// row 2
	JButton numCButton, numDButton, num4Button, num5Button, num6Button, minusButton;			// row 3
	JButton numEButton, numFButton, num1Button, num2Button, num3Button, pluseButton;			// row 4
	JButton openParButton, closeParButton, signButton, num0Button, periodButton, equalButton;	// row 5
	JPanel mainPanel;
	GridBagConstraints c;
	
	final int HEXADECIMAL = 16;
	final int DECIMAL = 10;
	final int OCTAL = 8;
	final int BINARY = 2;
	
	int activeBase = DECIMAL;
	String currentValue = "0";
	int runningTotal = 0;
	boolean beginNewNumber = true;
	
	public ProgrammerCalc()
	{
		mainPanel = new JPanel(new GridBagLayout());
		
		menuButton = new JButton("menu");
		titleLabel = new JLabel("Programmer");
		
		equationLabel = new JLabel("", SwingConstants.RIGHT);
		answerLabel = new JLabel("0", SwingConstants.RIGHT);
		
		hexLabel = new JButton("HEX  0");
		decLabel = new JButton("DEC  0");
		octLabel = new JButton("OCT  0");
		binLabel = new JButton("BIN  0");
		
		placeHolderButton = new JButton("Place holder");
		wordButton = new JButton("WORD");
		msButton = new JButton("MS");
		mButton = new JButton("M");
		
		lshButton = new JButton("Lsh");
		rshButton = new JButton("Rsh");
		orButton = new JButton("Or");
		xOrButton = new JButton("Xor");
		notButton = new JButton("Not");
		andButton = new JButton("And");
		
		secondButton = new JButton("2nd");
		modButton = new JButton("Mod");
		clearEButton = new JButton("CE");
		clearButton = new JButton("C");
		backButton = new JButton("<-");
		divButton = new JButton("/");
		
		numAButton = new JButton("A");
		numBButton = new JButton("B");
		num7Button = new JButton("7");
		num8Button = new JButton("8");
		num9Button = new JButton("9");
		multButton = new JButton("x");
		
		numCButton = new JButton("C");
		numDButton = new JButton("D");
		num4Button = new JButton("4");
		num5Button = new JButton("5");
		num6Button = new JButton("6");
		minusButton = new JButton("-");
		
		numEButton = new JButton("E");
		numFButton = new JButton("F");
		num1Button = new JButton("1");
		num2Button = new JButton("2");
		num3Button = new JButton("3");
		pluseButton = new JButton("+");
		
		openParButton = new JButton("(");
		closeParButton = new JButton(")");
		signButton = new JButton("+/-");
		num0Button = new JButton("0");
		periodButton = new JButton(".");
		equalButton = new JButton("=");
				
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		
		c.gridy = 0;
		c.gridx = 0;
		c.weightx = 1;
		c.weighty = .3;
		mainPanel.add(menuButton, c);
		c.gridwidth = 6;
		c.gridx = 1;
		mainPanel.add(titleLabel, c);
		
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 10);
		mainPanel.add(equationLabel, c);
		
		c.gridy = 2;
		c.gridx = 0;
		c.weighty = 1;
		c.gridwidth = 7;
		mainPanel.add(answerLabel, c);
		
		c.gridy = 3;
		c.ipady = 0;
		c.weighty = .2;
		c.insets = new Insets(0, 0, 0, 0);
		mainPanel.add(hexLabel, c);
		
		c.gridy = 4;
		mainPanel.add(decLabel, c);
		
		c.gridy = 5;
		mainPanel.add(octLabel, c);
		
		c.gridy = 6;
		mainPanel.add(binLabel, c);
		
		c.gridy = 7;
		c.gridwidth = 2;
		mainPanel.add(placeHolderButton, c);
		c.gridx = 2;
		mainPanel.add(wordButton, c);
		c.gridwidth = 1;
		c.gridx = 4;
		mainPanel.add(msButton, c);
		c.gridx = 5;
		mainPanel.add(mButton, c);
		
		c.gridy = 8;
		c.weighty = .4;
		c.gridwidth = 1;
		c.gridx = 0;
		mainPanel.add(lshButton, c);
		c.gridx = 1;
		mainPanel.add(rshButton, c);
		c.gridx = 2;
		mainPanel.add(orButton, c);
		c.gridx = 3;
		mainPanel.add(xOrButton, c);
		c.gridx = 4;
		mainPanel.add(notButton, c);
		c.gridx = 5;
		mainPanel.add(andButton, c);
		
		c.gridy = 9;
		c.gridx = 0;
		mainPanel.add(secondButton, c);
		c.gridx = 1;
		mainPanel.add(modButton, c);
		c.gridx = 2;
		mainPanel.add(clearEButton, c);
		c.gridx = 3;
		mainPanel.add(clearButton, c);
		c.gridx = 4;
		mainPanel.add(backButton, c);
		c.gridx = 5;
		mainPanel.add(divButton, c);
		
		c.gridy = 10;
		c.gridx = 0;
		mainPanel.add(numAButton, c);
		c.gridx = 1;
		mainPanel.add(numBButton, c);
		c.gridx = 2;
		mainPanel.add(num7Button, c);
		c.gridx = 3;
		mainPanel.add(num8Button, c);
		c.gridx = 4;
		mainPanel.add(num9Button, c);
		c.gridx = 5;
		mainPanel.add(multButton, c);
		
		c.gridy = 11;
		c.gridx = 0;
		mainPanel.add(numCButton, c);
		c.gridx = 1;
		mainPanel.add(numDButton, c);
		c.gridx = 2;
		mainPanel.add(num4Button, c);
		c.gridx = 3;
		mainPanel.add(num5Button, c);
		c.gridx = 4;
		mainPanel.add(num6Button, c);
		c.gridx = 5;
		mainPanel.add(minusButton, c);
		
		c.gridy = 12;
		c.gridx = 0;
		mainPanel.add(numEButton, c);
		c.gridx = 1;
		mainPanel.add(numFButton, c);
		c.gridx = 2;
		mainPanel.add(num1Button, c);
		c.gridx = 3;
		mainPanel.add(num2Button, c);
		c.gridx = 4;
		mainPanel.add(num3Button, c);
		c.gridx = 5;
		mainPanel.add(pluseButton, c);
		
		c.gridy = 13;
		c.gridx = 0;
		mainPanel.add(openParButton, c);
		c.gridx = 1;
		mainPanel.add(closeParButton, c);
		c.gridx = 2;
		mainPanel.add(signButton, c);
		c.gridx = 3;
		mainPanel.add(num0Button, c);
		c.gridx = 4;
		mainPanel.add(periodButton, c);
		c.gridx = 5;
		mainPanel.add(equalButton, c);
		
		add(mainPanel, BorderLayout.CENTER);
		
		hexLabel.addActionListener(this);
		decLabel.addActionListener(this);
		octLabel.addActionListener(this);
		binLabel.addActionListener(this);
		
		num0Button.addActionListener(this);
		num1Button.addActionListener(this);
		num2Button.addActionListener(this);
		num3Button.addActionListener(this);
		num4Button.addActionListener(this);
		num5Button.addActionListener(this);
		num6Button.addActionListener(this);
		num7Button.addActionListener(this);
		num8Button.addActionListener(this);
		num9Button.addActionListener(this);
		numAButton.addActionListener(this);
		numBButton.addActionListener(this);
		numCButton.addActionListener(this);
		numDButton.addActionListener(this);
		numEButton.addActionListener(this);
		numFButton.addActionListener(this);
		
		pluseButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == num0Button)
		{
			updateNumber("0");
		}
		
		if(e.getSource() == num1Button)
		{
			updateNumber("1");
		}
		
		if(activeBase >= OCTAL)
		{
			if(e.getSource() == num2Button)
			{
				updateNumber("2");
			}
			
			if(e.getSource() == num3Button)
			{
				updateNumber("3");
			}
			
			if(e.getSource() == num4Button)
			{
				updateNumber("4");
			}
			
			if(e.getSource() == num5Button)
			{
				updateNumber("5");
			}
			
			if(e.getSource() == num6Button)
			{
				updateNumber("6");
			}
			
			if(e.getSource() == num7Button)
			{
				updateNumber("7");
			}
		}
		
		if(activeBase >= DECIMAL)
		{
			if(e.getSource() == num8Button)
			{
				updateNumber("8");
			}
			
			if(e.getSource() == num9Button)
			{
				updateNumber("9");
			}
		}
		
		if(activeBase >= HEXADECIMAL)
		{
			if(e.getSource() == numAButton)
			{
				updateNumber("a");
			}
			
			if(e.getSource() == numBButton)
			{
				updateNumber("b");
			}
			
			if(e.getSource() == numCButton)
			{
				updateNumber("c");
			}
			
			if(e.getSource() == numDButton)
			{
				updateNumber("d");
			}
			
			if(e.getSource() == numEButton)
			{
				updateNumber("e");
			}
			
			if(e.getSource() == numFButton)
			{
				updateNumber("f");
			}
		}
		
		if(e.getSource() == pluseButton)
		{
			beginNewNumber = true;
			equationLabel.setText(equationLabel.getText() + " + ");
		}
		
		if(e.getSource() == hexLabel)
		{
			updateBase(HEXADECIMAL);
		}
		
		if(e.getSource() == decLabel)
		{
			updateBase(DECIMAL);
		}
		
		if(e.getSource() == octLabel)
		{
			updateBase(OCTAL);
		}
		
		if(e.getSource() == binLabel)
		{
			updateBase(BINARY);
		}
	}
	
	public void updateNumber(String num)
	{
		if(beginNewNumber)
		{
			beginNewNumber = false;
			currentValue = num;
		}
		else
		{
			currentValue += num;
		}
		
		answerLabel.setText(currentValue);
		
		hexLabel.setText("HEX " + baseConversion(currentValue, activeBase, HEXADECIMAL));
		decLabel.setText("DEC " + baseConversion(currentValue, activeBase, DECIMAL));
		octLabel.setText("OCT " + baseConversion(currentValue, activeBase, OCTAL));
		binLabel.setText("BIN " + baseConversion(currentValue, activeBase, BINARY));
		equationLabel.setText(equationLabel.getText() + num);
	}
	
	public void updateBase(int newBase)
	{
		currentValue = baseConversion(currentValue, activeBase, newBase);
		answerLabel.setText(currentValue);
		
		activeBase = newBase;
	}
	
	public String baseConversion(String value, int fromBase, int toBase)
	{
		return Integer.toString(Integer.parseInt(value, fromBase), toBase);
	}
}