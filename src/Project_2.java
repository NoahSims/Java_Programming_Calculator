/* Author:     Noah Sims
 * Program:    Semester Project 2 - Windows 10 Programmer Calculator - Driver
 * Date:	   12/1/2019
 * Comments:
 * 		This program is the driver for the Windows 10 Programmer Calculator program
 */

import javax.swing.JFrame;
import java.awt.*;

public class Project_2 {
	public static void main(String[] args)
	{
		ProgrammerCalc window = new ProgrammerCalc();
		window.setTitle("calculator");
		window.setSize(350, 600);
		window.setMinimumSize(new Dimension(400, 625));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}