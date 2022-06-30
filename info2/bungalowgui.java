import java.io.*;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.*;

/**
 * @author Jasatai (JL)
 * @author Franzi (design)
 * @version 2.0.0
 * @since 0.0.1
 */
public class bungalowgui extends JFrame {

	private JPanel contentPane;

	private static JTextPane txtpns[] = new JTextPane[14];
	private static JLabel lbls[] = new JLabel[17];

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		init();
		while (true) {
			int[] localLow = getTxt();
			for (int i = 0; i < localLow.length; i++) {
				System.out.println(localLow[i]);
			}
		}
	}

	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bungalowgui frame = new bungalowgui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * //textBungalowNr = new JTextField();
	 * textBungalowNr.setBounds(159, 21, 164, 40);
	 * getContentPane().add(textBungalowNr);
	 * textBungalowNr.setColumns(10);
	 */
	public bungalowgui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// LABLES

		String line = "";
		final String delimiter = ",";
		String filePath = System.getProperty("user.dir") + "\\info2\\labels.csv";
		try {
			FileReader fileReader = new FileReader(filePath);

			BufferedReader reader = new BufferedReader(fileReader);
			reader.readLine();
			int index1 = 0;
			while ((line = reader.readLine()) != null) // loops through every line until null found
			{
				String[] token = line.split(delimiter); // separate every token by comma
				for (int i = 0; i < token.length; i++) {
					System.out.println(token[i]);
				}
				lbls[index1] = new JLabel(token[0]);
				lbls[index1].setFont(fonts(Integer.parseInt(token[1])));
				lbls[index1].setToolTipText(token[2]);
				lbls[index1].setBounds(Integer.parseInt(token[3]), Integer.parseInt(token[4]),
						Integer.parseInt(token[5]), Integer.parseInt(token[6]));
				contentPane.add(lbls[index1]);
				index1++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("filePath: " + filePath);
		}

		// TEXT PANES
		String filePath2 = System.getProperty("user.dir") + "\\info2\\textPanes.csv";
		try {
			FileReader fileReader = new FileReader(filePath2);

			BufferedReader reader = new BufferedReader(fileReader);
			reader.readLine();
			int index1 = 0;
			while ((line = reader.readLine()) != null) // loops through every line until null found
			{
				String[] token = line.split(delimiter); // separate every token by comma
				for (int i = 0; i < token.length; i++) {
					System.out.println(token[i]);
				}
				txtpns[index1] = new JTextPane();
				txtpns[index1].setText(token[0]);
				txtpns[index1].setFont(fonts(Integer.parseInt(token[1])));
				txtpns[index1].setToolTipText(token[2]);
				txtpns[index1].setBounds(Integer.parseInt(token[3]), Integer.parseInt(token[4]),
						Integer.parseInt(token[5]), Integer.parseInt(token[6]));
				txtpns[index1].setEditable(Boolean.parseBoolean(token[7]));
				contentPane.add(txtpns[index1]);
				index1++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("filePath: " + filePath);
		}

		// BUTTONS
		JButton b1 = new JButton("Buchen");
		JButton b2 = new JButton("Stonieren");

		b1.setBounds(540, 530, 180, 40);
		b2.setBounds(900, 530, 230, 40);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpns[11].setText("-2");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtpns[13].setText("-2");
			}
		});
		contentPane.add(b1);
		contentPane.add(b2);
	}

	public Font fonts(int index) {

		switch (index) {
			case 0:
				return new Font("Tahoma", Font.BOLD, 20);
			case 1:
				return new Font("Tahoma", Font.PLAIN, 14);
			case 2:
				return new Font("Tahoma", Font.PLAIN, 16);
			case 3:
				return new Font("Tahoma", Font.BOLD, 14);
			default:
				return new Font("Tahoma", Font.PLAIN, 11);
		}
	}

	public static int[] getTxt() {
		int[] returnArr = new int[14];
		for (int i = 0; i < returnArr.length; i++) {
			try {
				returnArr[i] = Integer.parseInt(txtpns[i].getText());
			} catch (Exception e) {
				returnArr[i] = -1;
			}
		}
		return returnArr;
	}

	public void setOutput(int i, String s) {
		txtpns[i].setText(s);
	}

}
