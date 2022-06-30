import java.sql.*;

/**
 * @author Jasatai (JL)
 * @version 0.0.2
 * @since 0.1.0
 */
public class datenbank {

	/**
	 * bunglaow jahr woche daten
	 */
	static final int anzahlBungalows = 3;
	private static Connection c = null;
	private static Statement stmt = null;
	int buchungsnummerIntern = 0;
	String output[] = new String[9];

	/**
	 * init
	 */
	public void init() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:BungalowProjekt.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			String q = "SELECT buchungsnummer FROM buchungsnummern;";
			ResultSet rs = stmt.executeQuery(q);
			while (rs.next()) {
				if (rs.getInt("buchungsnummer") > buchungsnummerIntern) {
					buchungsnummerIntern = rs.getInt("buchungsnummer");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		output[0] = "buchungsnummer: ";
		output[1] = "\nanzahl personen: ";
		output[2] = "\nanreise woche: ";
		output[3] = "\nabreise woche: ";
		output[4] = "\nanreise jahr: ";
		output[5] = "\nabreise jahr: ";
		output[6] = "\nanreise in wochen seit woche 1 2022: ";
		output[7] = "\nabreise in wochen seit woche 1 2022: ";
		output[8] = "\nbungalow: ";

	}

	/**
	 * saves user input
	 * 
	 * @param bungalow       die bungalow nummer
	 * @param AnzahlPersonen die anzahl der personen
	 * @param anwo           die woche der ankunft
	 * @param abwo           die woche der abreise
	 * @param anja           das jahr der ankunft
	 * @param abja           das jahr der abreise
	 * @return die buchungsnummer
	 */
	public String save(int bungalow, int AnzahlPersonen, int anwo, int abwo, int anja, int abja) {
		//get weeks
		long an = ((anja - 2022) * 53) + anwo;
		long ab = ((abja - 2022) * 53) + abwo;
		//get results from sqlite quarry
		//check if available
		String q = "SELECT an,ab FROM buchungsnummern WHERE bungalow = " + bungalow + ";";
		try {
			ResultSet rs = stmt.executeQuery(q);
			while (rs.next()) {
				if ((an <= rs.getInt("ab") && an >= rs.getInt("an"))
						|| (ab >= rs.getInt("an") && ab <= rs.getInt("ab"))
						|| (an <= rs.getInt("an") && ab >= rs.getInt("ab"))) {
					return "ERROR: bungalow nicht verfuegbar";
				}
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if available, save new data
		String sql = "INSERT INTO BUCHUNGSNUMMERN (BUCHUNGSNUMMER,ANZAHL_PERSONEN,ANWO,ABWO,ANJA,ABJA,AN,AB,BUNGALOW) "
				+ "VALUES (" + buchungsnummerIntern + ", " + AnzahlPersonen + ", " + anwo + ", " + abwo + ", " + anja
				+ ", " + abja + ", " + an + ", " + ab + ", " + bungalow + ");";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "sql error";
		}
		
		buchungsnummerIntern++;
		return String.valueOf(buchungsnummerIntern - 1);
	}

	/**
	 * gibt informationen zur buchungsnummer zurueck
	 * 
	 * @param buchungsnummerIn buchungsnummer
	 * @return informationen
	 */
	public String recall(int buchungsnummerIn) {
		//if field empty, return
		if (buchungsnummerIn == -1) {
			return "bitte buchungsnummer eingeben";
		}
		//sql querry for buchungsnummer
		String q = null;
		try {
			String r = "";
			q = "SELECT * " + "FROM buchungsnummern " + "WHERE buchungsnummer = " + buchungsnummerIn + ";";
			ResultSet rs = stmt.executeQuery(q);
			while (rs.next()) {
				for (int i = 1; i < 10; i++) {
					if (rs.getInt(i) != -1) {
						r = r + output[i - 1] + rs.getInt(i);
					} else {
						r = r + output[i - 1] + "NA";
					}
				}
			}
			if (!rs.isClosed()) {
				rs.close();
			}
			return r;
		} catch (Exception e) {
			System.out.println(q);
			e.printStackTrace();
			return "404 Not Found";
		}

	}

	/**
	 * gibt string mit freien bungalows fuer den zeitraum zurueck
	 * 
	 * @param anja das jahr der ankunft
	 * @param abja das jahr der abreise
	 * @param anwo die woche der ankunft
	 * @param abwo die woche der abreise
	 * @return die freien bungalows
	 */
	public String available(int anja, int abja, int anwo, int abwo) {
		String q = "";
		boolean[] bAvailable = new boolean[anzahlBungalows];

		long an = ((anja - 2022) * 53) + anwo;
		long ab = ((abja - 2022) * 53) + abwo;
		String output = "";
		boolean first = true;
		for (int i = 0; i < bAvailable.length; i++) {
			bAvailable[i] = true;
		}
		ResultSet rs;
		for (int k = 0; k < bAvailable.length; k++) {
			q = "SELECT an,ab FROM buchungsnummern WHERE bungalow = " + k + ";";
			try {
				rs = stmt.executeQuery(q);
				while (rs.next()) {
					if ((an <= rs.getInt("ab") && an >= rs.getInt("an"))
							|| (ab >= rs.getInt("an") && ab <= rs.getInt("ab"))
							|| (an <= rs.getInt("an") && ab >= rs.getInt("ab"))) {
						bAvailable[k] = false;
					}
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < bAvailable.length; i++) {
			if (bAvailable[i]) {
				if (first) {
					output += i + 1;
					first = false;
				} else {
					output += ", ";
					output += i + 1;
				}
			}
		}
		if (output.equals("")) {
			output += "no available bungalows found";
		}
		return output;
	}

	/**
	 * stoniert die buchung der buchungsnummer
	 * 
	 * @param buchungsnummer
	 */
	public String stonieren(int buchungsnummer) {
		try {
			
			String d = "DELETE FROM buchungsnummern WHERE buchungsnummer = " + buchungsnummer + ";";
			stmt.executeUpdate(d);

			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "404 Not Found";
		}
	}

	public static int anzahlBungalows() {
		return anzahlBungalows;
	}

}
