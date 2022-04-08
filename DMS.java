	/**
	 * @author Jasatai
	 * @version 0.1
	 */
public class DMS {
	/**
	 * data array coding
	 * 0	buchungsmummer
	 * 1	bungalow nummer
	 * 2	start woche
	 * 3	end woche
	 * 4	anzahl persohnen
	 */
	private int[][] data = new int[10000][5];
	public void saveData(int bungalowNummer, int startWoche, int endWoche, int anzahlPersonen) {
		// find next emty position
		int temp = 0;
		while (data[temp][0] == 0) {
			temp++;
		}
		temp++;
		
		data[temp][0] = temp;
		data[temp][1] = bungalowNummer;
		data[temp][2] = startWoche;
		data[temp][3] = endWoche;
		data[temp][4] = anzahlPersonen;
		
	}
	public int[][] recall() {
		return data;
	
	}
	
}
