/**
 * @author Jasatai (JL)
 * @version 0.0.2
 * @since 0.1.0
 */
public class datenbank {

    /**
     * bunglaow
     * jahr
     * woche
     * daten
     */
    static final int anzahlBungalows = 3;
    static int[][][][] database = new int[10][1000][53][7];
    int[][] buchungsnummern = new int[1000000][7];
    long[][] databaseIndex = new long[anzahlBungalows][2];
    int buchungsnummerIntern = 0;
    String output[] = new String[7];

    /**
     * init
     */
    public void init() {
        for (int i = 0; i < anzahlBungalows; i++) {
            databaseIndex[i][0] = -1;
            databaseIndex[i][1] = -1;
        }
        for (int i = 0; i < buchungsnummern.length; i++) {
            for (int j = 0; j < buchungsnummern[i].length; j++) {
                buchungsnummern[i][j] = -1;
            }
        }

        output[0] = "bungalow: ";
        output[1] = "\nanzahl personen: ";
        output[2] = "\nbuchungsnummer: ";
        output[3] = "\nanreise woche: ";
        output[4] = "\nabreise woche: ";
        output[5] = "\nanreise jahr: ";
        output[6] = "\nabreise jahr: ";
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
        long an = ((anja - 2022)*53)+anwo;
        long ab = ((abja - 2022)*53)+abwo;
        if ((an <= databaseIndex[bungalow][1] && an >= databaseIndex[bungalow][0]) || (ab >= databaseIndex[bungalow][0] && ab <= databaseIndex[bungalow][1]) || (an <= databaseIndex[bungalow][0] && ab >= databaseIndex[bungalow][1])) {
            return "ERROR: bungalow nicht verfuegbar";
        }
        buchungsnummern[buchungsnummerIntern][0] = bungalow;
        buchungsnummern[buchungsnummerIntern][1] = AnzahlPersonen;
        buchungsnummern[buchungsnummerIntern][2] = buchungsnummerIntern;
        buchungsnummern[buchungsnummerIntern][3] = anwo;
        buchungsnummern[buchungsnummerIntern][4] = abwo;
        buchungsnummern[buchungsnummerIntern][5] = anja;
        buchungsnummern[buchungsnummerIntern][6] = abja;

        databaseIndex[bungalow][0] = ((anja - 2022)*53)+anwo;
        databaseIndex[bungalow][1] = ((abja - 2022)*53)+abwo;

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
        try {
            String r = "";
            for (int i = 0; i < output.length; i++) {
                if (buchungsnummern[buchungsnummerIn][0] != -1) {
                    r = r + output[i] + String.valueOf(buchungsnummern[buchungsnummerIn][i]);
                } else {
                    r = r + output[i] + "NA";
                }
            }
            return r;
        } catch (Exception e) {
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
        boolean[] bAvailable = new boolean[anzahlBungalows];
        
        long an = ((anja - 2022)*53)+anwo;
        long ab = ((abja - 2022)*53)+abwo;
        String output = "";
        boolean first = true;
        for (int i = 0; i < bAvailable.length; i++) {
            bAvailable[i] = true;
        }
        for (int k = 0; k < databaseIndex.length; k++) {
            if ((an <= databaseIndex[k][1] && an >= databaseIndex[k][0]) || (ab >= databaseIndex[k][0] && ab <= databaseIndex[k][1]) || (an <= databaseIndex[k][0] && ab >= databaseIndex[k][1])) {
                bAvailable[k] = false;
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
            databaseIndex[buchungsnummern[buchungsnummer][0]][0] = -1;
            databaseIndex[buchungsnummern[buchungsnummer][0]][1] = -1;

            buchungsnummern[buchungsnummer][0] = -1;
            buchungsnummern[buchungsnummer][1] = -1;
            buchungsnummern[buchungsnummer][2] = -1;
            buchungsnummern[buchungsnummer][3] = -1;
            buchungsnummern[buchungsnummer][4] = -1;
            buchungsnummern[buchungsnummer][5] = -1;
            buchungsnummern[buchungsnummer][6] = -1;

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
