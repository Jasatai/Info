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
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bungalow extends JFrame {

	private JPanel contentPane;

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
	/*
	String[] array = new String[12];
    
    //Data Transmision
    public int getUserInteraction() {
        return 0;
    }
    public boolean getUpdate() {
        return update;
    }
    public void resetUpdate() {
        update = false;
    }

    public int[] getData() {
        return null;
    }
	*/
	/**
	 * Create the frame.
	 */
	public Bungalow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 720);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel VerfuegbarkeitsPanel = new Panel();
		VerfuegbarkeitsPanel.setBackground(Color.LIGHT_GRAY);
		VerfuegbarkeitsPanel.setBounds(89, 48, 321, 562);
		contentPane.add(VerfuegbarkeitsPanel);
		VerfuegbarkeitsPanel.setLayout(null);
		
		JLabel lblVerfuegbarkeit = new JLabel("Verfuegbarkeit:");
		lblVerfuegbarkeit.setBounds(78, 5, 125, 22);
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
		
		JTextPane txtpnAnreise = new JTextPane();
		txtpnAnreise.setBounds(112, 67, 52, 22);
		VerfuegbarkeitsPanel.add(txtpnAnreise);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(112, 110, 52, 22);
		VerfuegbarkeitsPanel.add(textPane);
		
		JLabel lblWoche = new JLabel("Woche");
		lblWoche.setBounds(112, 56, 45, 13);
		VerfuegbarkeitsPanel.add(lblWoche);
		
		JLabel lblWoche_1 = new JLabel("Woche");
		lblWoche_1.setBounds(112, 99, 45, 13);
		VerfuegbarkeitsPanel.add(lblWoche_1);
		
		JTextPane txtpnJahr = new JTextPane();
		txtpnJahr.setBounds(174, 67, 52, 22);
		VerfuegbarkeitsPanel.add(txtpnJahr);
		
		JTextPane textJahr_1 = new JTextPane();
		textJahr_1.setBounds(174, 110, 52, 22);
		VerfuegbarkeitsPanel.add(textJahr_1);
		
		JLabel lblJahr = new JLabel("Jahr");
		lblJahr.setBounds(174, 56, 45, 13);
		VerfuegbarkeitsPanel.add(lblJahr);
		
		JLabel lblJahr_1 = new JLabel("Jahr");
		lblJahr_1.setBounds(174, 99, 45, 13);
		VerfuegbarkeitsPanel.add(lblJahr_1);
		
		JLabel lblFreiebungalows = new JLabel("freie Bungalows:");
		lblFreiebungalows.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFreiebungalows.setBounds(78, 161, 152, 36);
		VerfuegbarkeitsPanel.add(lblFreiebungalows);
		
		JTextPane textFreieBungalows = new JTextPane();
		textFreieBungalows.setBounds(39, 207, 248, 312);
		VerfuegbarkeitsPanel.add(textFreieBungalows);
		
		Panel BuchungsPanel = new Panel();
		BuchungsPanel.setBackground(Color.LIGHT_GRAY);
		BuchungsPanel.setBounds(472, 339, 321, 271);
		contentPane.add(BuchungsPanel);
		BuchungsPanel.setLayout(null);
		
		JLabel lblBuchung = new JLabel("Buchung:");
		lblBuchung.setBounds(114, 10, 78, 22);
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
		
		JTextPane textWochePane_2 = new JTextPane();
		textWochePane_2.setBounds(105, 88, 52, 22);
		BuchungsPanel.add(textWochePane_2);
		
		JTextPane textJahrPane_1 = new JTextPane();
		textJahrPane_1.setBounds(177, 46, 52, 22);
		BuchungsPanel.add(textJahrPane_1);
		
		JTextPane textJahrPane_2 = new JTextPane();
		textJahrPane_2.setBounds(176, 88, 53, 22);
		BuchungsPanel.add(textJahrPane_2);
		
		JLabel lblWoche_2 = new JLabel("Woche:");
		lblWoche_2.setBounds(105, 35, 45, 13);
		BuchungsPanel.add(lblWoche_2);
		
		JLabel lblJahr_2 = new JLabel("Jahr:");
		lblJahr_2.setBounds(176, 35, 45, 13);
		BuchungsPanel.add(lblJahr_2);
		
		JLabel lblWoche_3 = new JLabel("Woche:");
		lblWoche_3.setBounds(105, 78, 45, 13);
		BuchungsPanel.add(lblWoche_3);
		
		JLabel lblJahr_3 = new JLabel("Jahr:");
		lblJahr_3.setBounds(176, 78, 45, 13);
		BuchungsPanel.add(lblJahr_3);
		
		JLabel lblBuchungenMaximaljahre = new JLabel("Buchungen maximal 10 Jahre in die Zukunft.");
		lblBuchungenMaximaljahre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuchungenMaximaljahre.setBounds(29, 108, 244, 47);
		BuchungsPanel.add(lblBuchungenMaximaljahre);
		
		JButton btnJetztBuchen = new JButton("Jetzt Buchen");
		btnJetztBuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJetztBuchen.setBackground(UIManager.getColor("Button.darkShadow"));
		btnJetztBuchen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnJetztBuchen.setBounds(79, 222, 168, 39);
		BuchungsPanel.add(btnJetztBuchen);
		
		JTextPane textAnzahlPersonenPane_1 = new JTextPane();
		textAnzahlPersonenPane_1.setBounds(177, 190, 52, 22);
		BuchungsPanel.add(textAnzahlPersonenPane_1);
		
		JTextPane txtpnBungalow = new JTextPane();
		txtpnBungalow.setBounds(177, 156, 52, 24);
		BuchungsPanel.add(txtpnBungalow);
		
		JLabel lblBungalow = new JLabel("Bungalow:");
		lblBungalow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBungalow.setBounds(91, 156, 66, 24);
		BuchungsPanel.add(lblBungalow);
		
		JLabel lblAnzahlPersonen = new JLabel("Anzahl Personen:");
		lblAnzahlPersonen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnzahlPersonen.setBounds(54, 190, 113, 22);
		BuchungsPanel.add(lblAnzahlPersonen);
		
		Panel InformationPanel = new Panel();
		InformationPanel.setBackground(Color.LIGHT_GRAY);
		InformationPanel.setBounds(472, 48, 649, 253);
		contentPane.add(InformationPanel);
		InformationPanel.setLayout(null);
		
		JLabel lblInformationen = new JLabel("Informationen:");
		lblInformationen.setBounds(260, 5, 121, 22);
		lblInformationen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		InformationPanel.add(lblInformationen);
		
		JTextPane textStatusPane_1 = new JTextPane();
		textStatusPane_1.setBounds(287, 66, 327, 158);
		InformationPanel.add(textStatusPane_1);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatus.setBounds(287, 43, 75, 22);
		InformationPanel.add(lblStatus);
		
		JLabel lblKundennummer = new JLabel("Buchungsnummer:");
		lblKundennummer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKundennummer.setBounds(50, 101, 121, 22);
		InformationPanel.add(lblKundennummer);
		
		JTextPane textBuchungsnummerPane_2 = new JTextPane();
		textBuchungsnummerPane_2.setBounds(50, 130, 196, 31);
		InformationPanel.add(textBuchungsnummerPane_2);
		
		Panel StonierungsPanel = new Panel();
		StonierungsPanel.setBackground(Color.LIGHT_GRAY);
		StonierungsPanel.setBounds(834, 339, 287, 271);
		contentPane.add(StonierungsPanel);
		StonierungsPanel.setLayout(null);
		
		JLabel lblStornierung = new JLabel("Stornierung:");
		lblStornierung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStornierung.setBounds(69, 10, 145, 29);
		StonierungsPanel.add(lblStornierung);
		
		JTextPane txtpnBuchungsnummer = new JTextPane();
		txtpnBuchungsnummer.setBounds(62, 116, 178, 29);
		StonierungsPanel.add(txtpnBuchungsnummer);
		
		JLabel lblBuchungsnummer = new JLabel("Buchungsnummer:");
		lblBuchungsnummer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuchungsnummer.setBounds(62, 89, 152, 29);
		StonierungsPanel.add(lblBuchungsnummer);
		
		JButton btnHierStonieren = new JButton("Hier Stonieren");
		btnHierStonieren.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHierStonieren.setBackground(UIManager.getColor("Button.darkShadow"));
		btnHierStonieren.setBounds(69, 173, 145, 36);
		StonierungsPanel.add(btnHierStonieren);
	}
}
