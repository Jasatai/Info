import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bungalow extends JFrame {

	private JPanel contentPane;
	public boolean buttonJetztBuchen = false;
	public boolean buttonJHierStonieren = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bungalow frame = new Bungalow();
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
		textBungalowNr.setBounds(159, 21, 164, 40);
		getContentPane().add(textBungalowNr);
		textBungalowNr.setColumns(10);
	 */
	public Bungalow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Hintergrund Verfuegbarkeit
		Panel VerfuegbarkeitsPanel = new Panel();
		VerfuegbarkeitsPanel.setBackground(Color.LIGHT_GRAY);
		VerfuegbarkeitsPanel.setBounds(84, 48, 321, 562);
		contentPane.add(VerfuegbarkeitsPanel);
		VerfuegbarkeitsPanel.setLayout(null);
		
		//Ueberschrifften
		JLabel lblVerfuegbarkeit = new JLabel("Verfuegbarkeit:");
		lblVerfuegbarkeit.setBounds(94, 10, 125, 22);
		lblVerfuegbarkeit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		VerfuegbarkeitsPanel.add(lblVerfuegbarkeit);
		
		JLabel lblAnreiseLable = new JLabel("Anreise:");
		lblAnreiseLable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnreiseLable.setBounds(54, 67, 63, 22);
		VerfuegbarkeitsPanel.add(lblAnreiseLable);
		
		JLabel lblAbreiseLable = new JLabel("Abreise:");
		lblAbreiseLable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbreiseLable.setBounds(54, 110, 63, 22);
		VerfuegbarkeitsPanel.add(lblAbreiseLable);
		
		//eingabefeldAnreiseUndAbreise
		JTextPane txtpnWoche1 = new JTextPane();
		txtpnWoche1.setBounds(112, 67, 52, 22);
		VerfuegbarkeitsPanel.add(txtpnWoche1);
		getContentPane().add(txtpnWoche1);
		
		JTextPane textWoche = new JTextPane();
		textWoche.setBounds(112, 110, 52, 22);
		VerfuegbarkeitsPanel.add(textWoche);
		getContentPane().add(textWoche);
		
		//Ueberschrifften
		JLabel lblWoche = new JLabel("Woche");
		lblWoche.setBounds(112, 56, 45, 13);
		VerfuegbarkeitsPanel.add(lblWoche);
		
		JLabel lblWoche_1 = new JLabel("Woche");
		lblWoche_1.setBounds(112, 99, 45, 13);
		VerfuegbarkeitsPanel.add(lblWoche_1);
		
		//eingaben
		JTextPane txtpnJahr = new JTextPane();
		txtpnJahr.setBounds(174, 67, 52, 22);
		VerfuegbarkeitsPanel.add(txtpnJahr);
		
		JTextPane textJahr_1 = new JTextPane();
		textJahr_1.setBounds(174, 110, 52, 22);
		VerfuegbarkeitsPanel.add(textJahr_1);
		getContentPane().add(textJahr_1);
		
		JLabel lblJahr = new JLabel("Jahr");
		lblJahr.setBounds(174, 56, 45, 13);
		VerfuegbarkeitsPanel.add(lblJahr);
		
		JLabel lblJahr_1 = new JLabel("Jahr");
		lblJahr_1.setBounds(174, 99, 45, 13);
		VerfuegbarkeitsPanel.add(lblJahr_1);
		
		//UeberschriftFreieBungalows
		JLabel lblFreiebungalows = new JLabel("freie Bungalows:");
		lblFreiebungalows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFreiebungalows.setBounds(78, 161, 152, 36);
		VerfuegbarkeitsPanel.add(lblFreiebungalows);
		
		
		JTextPane textFreieBungalows = new JTextPane();
		textFreieBungalows.setEditable(false);
		textFreieBungalows.setBounds(28, 207, 274, 320);
		VerfuegbarkeitsPanel.add(textFreieBungalows);
		getContentPane().add(textFreieBungalows);
		
		//Hintergrund 
		Panel BuchungsPanel = new Panel();
		BuchungsPanel.setBackground(Color.LIGHT_GRAY);
		BuchungsPanel.setBounds(439, 145, 369, 371);
		contentPane.add(BuchungsPanel);
		BuchungsPanel.setLayout(null);
		
		JLabel lblBuchung = new JLabel("Buchung:");
		lblBuchung.setBounds(151, 10, 78, 22);
		lblBuchung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BuchungsPanel.add(lblBuchung);
		
		JLabel lblAnreise = new JLabel("Anreise:");
		lblAnreise.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnreise.setBounds(41, 46, 63, 22);
		BuchungsPanel.add(lblAnreise);
		
		JLabel lblAbreise = new JLabel("Abreise:");
		lblAbreise.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbreise.setBounds(41, 88, 63, 22);
		BuchungsPanel.add(lblAbreise);
		
		JTextPane textWochePane_1 = new JTextPane();
		textWochePane_1.setBounds(105, 46, 52, 22);
		BuchungsPanel.add(textWochePane_1);
		getContentPane().add(textWochePane_1);
		
		JTextPane textWochePane_2 = new JTextPane();
		textWochePane_2.setBounds(105, 88, 52, 22);
		BuchungsPanel.add(textWochePane_2);
		getContentPane().add(textWochePane_2);
		
		JTextPane textJahrPane_1 = new JTextPane();
		textJahrPane_1.setBounds(209, 46, 52, 22);
		BuchungsPanel.add(textJahrPane_1);
		getContentPane().add(textJahrPane_1);
		
		JTextPane textJahrPane_2 = new JTextPane();
		textJahrPane_2.setBounds(208, 88, 53, 22);
		BuchungsPanel.add(textJahrPane_2);
		getContentPane().add(textJahrPane_2);
		
		JLabel lblWoche_2 = new JLabel("Woche:");
		lblWoche_2.setBounds(105, 35, 45, 13);
		BuchungsPanel.add(lblWoche_2);
		
		JLabel lblJahr_2 = new JLabel("Jahr:");
		lblJahr_2.setBounds(208, 35, 45, 13);
		BuchungsPanel.add(lblJahr_2);
		
		JLabel lblWoche_3 = new JLabel("Woche:");
		lblWoche_3.setBounds(105, 78, 45, 13);
		BuchungsPanel.add(lblWoche_3);
		
		JLabel lblJahr_3 = new JLabel("Jahr:");
		lblJahr_3.setBounds(208, 78, 45, 13);
		BuchungsPanel.add(lblJahr_3);
		
		JLabel lblBuchungenMaximaljahre = new JLabel("Buchungen maximal 10 Jahre in die Zukunft.");
		lblBuchungenMaximaljahre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuchungenMaximaljahre.setBounds(87, 101, 244, 47);
		BuchungsPanel.add(lblBuchungenMaximaljahre);
		
		//ButtonJetztBuchen
		JButton btnJetztBuchen = new JButton("Jetzt Buchen");
		btnJetztBuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonJetztBuchen = true;
			}
		});
		btnJetztBuchen.setBackground(UIManager.getColor("Button.darkShadow"));
		btnJetztBuchen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnJetztBuchen.setBounds(109, 301, 168, 39);
		BuchungsPanel.add(btnJetztBuchen);
		
		
		
		JTextPane textAnzahlPersonenPane_1 = new JTextPane();
		textAnzahlPersonenPane_1.setBounds(177, 190, 52, 22);
		BuchungsPanel.add(textAnzahlPersonenPane_1);
		getContentPane().add(textAnzahlPersonenPane_1);
		
		JTextPane txtpnBungalowNummer = new JTextPane();
		txtpnBungalowNummer.setBounds(177, 156, 52, 24);
		BuchungsPanel.add(txtpnBungalowNummer);
		getContentPane().add(txtpnBungalowNummer);
		
		JLabel lblBungalow = new JLabel("Bungalow:");
		lblBungalow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBungalow.setBounds(91, 156, 66, 24);
		BuchungsPanel.add(lblBungalow);
		
		JLabel lblAnzahlPersonen = new JLabel("Anzahl Personen:");
		lblAnzahlPersonen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnzahlPersonen.setBounds(54, 190, 113, 22);
		BuchungsPanel.add(lblAnzahlPersonen);
		
		JLabel lblBuchungsnummer = new JLabel("Buchungsnummer:");
		lblBuchungsnummer.setBounds(109, 234, 152, 29);
		BuchungsPanel.add(lblBuchungsnummer);
		lblBuchungsnummer.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		//Buchungsnummer
		JTextPane txtpnBuchungsnummer = new JTextPane();
		txtpnBuchungsnummer.setEditable(false);
		txtpnBuchungsnummer.setBounds(99, 262, 178, 29);
		BuchungsPanel.add(txtpnBuchungsnummer);
		
		Panel InformationPanel = new Panel();
		InformationPanel.setBackground(Color.LIGHT_GRAY);
		InformationPanel.setBounds(843, 48, 321, 556);
		contentPane.add(InformationPanel);
		InformationPanel.setLayout(null);
		
		JLabel lblInformationen = new JLabel("Informationen:");
		lblInformationen.setBounds(102, 10, 121, 22);
		lblInformationen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		InformationPanel.add(lblInformationen);
		
		JTextPane textStatusPane_1 = new JTextPane();
		textStatusPane_1.setEditable(false);
		textStatusPane_1.setBounds(37, 231, 258, 233);
		InformationPanel.add(textStatusPane_1);
		getContentPane().add(textStatusPane_1);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(45, 199, 75, 22);
		InformationPanel.add(lblStatus);
		
		JLabel lblKundennummer = new JLabel("Buchungsnummer:");
		lblKundennummer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKundennummer.setBounds(45, 101, 121, 22);
		InformationPanel.add(lblKundennummer);
		
		JTextPane textBuchungsnummerPane_2 = new JTextPane();
		textBuchungsnummerPane_2.setBounds(55, 134, 196, 31);
		InformationPanel.add(textBuchungsnummerPane_2);
		getContentPane().add(textBuchungsnummerPane_2);
		
		JButton btnHierStonieren = new JButton("Hier Stonieren");
		btnHierStonieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonJHierStonieren = true;
			}
		});
		btnHierStonieren.setBounds(102, 488, 145, 36);
		InformationPanel.add(btnHierStonieren);
		btnHierStonieren.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHierStonieren.setBackground(UIManager.getColor("Button.darkShadow"));
		

	}
}
