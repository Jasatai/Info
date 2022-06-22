/**
 * @author Jasatai (JL)
 * @version 0.0.1
 * @since 0.1.0
 */
public class datenbank {
    
    /**
     * bunglaow
     * jahr
     * woche
     * daten
     */
    int[][][][] database = new int[10][10][53][7];
    int[][] buchungsnummern = new int[1000000][7];
    int buchungsnummerIntern = 0;
    /**
     * init
     */
    public void init() {
        for (int i = 0; i < database.length; i++) {
            for (int j = 0; j < database[i].length; j++) {
                for (int k = 0; k < database[i][j].length; k++) {
                    for (int l = 0; l < database[i][j][k].length; l++) {
                        database[i][j][k][l] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < buchungsnummern.length; i++) {
            for (int j = 0; j < buchungsnummern[i].length; j++) {
                buchungsnummern[i][j] = -1;
            }
        }
    }

    /**
     * saves user input
     * @param bungalow
     * @param AnzahlPersonen
     * @param anwo
     * @param abwo
     * @param anja
     * @param abja
     * @return
     */
    public int save(int bungalow, int AnzahlPersonen, int anwo, int abwo, int anja, int abja) {
        buchungsnummern[buchungsnummerIntern][0] = bungalow;
        buchungsnummern[buchungsnummerIntern][1] = AnzahlPersonen;
        buchungsnummern[buchungsnummerIntern][2] = buchungsnummerIntern;
        buchungsnummern[buchungsnummerIntern][3] = anwo;
        buchungsnummern[buchungsnummerIntern][4] = abwo;
        buchungsnummern[buchungsnummerIntern][5] = anja;
        buchungsnummern[buchungsnummerIntern][6] = abja;

        for (int i = anja-2022; i < abja-2022; i++) {
            for (int j = anwo-1; j < abwo-1; j++) {
                database[bungalow][i][j][0] = bungalow;
                database[bungalow][i][j][1] = AnzahlPersonen;
                database[bungalow][i][j][2] = buchungsnummerIntern;
                database[bungalow][i][j][3] = anwo;
                database[bungalow][i][j][4] = abwo;
                database[bungalow][i][j][5] = anja;
                database[bungalow][i][j][6] = abja;
                
            }
        }
        buchungsnummerIntern++;
        return buchungsnummerIntern-1;
    }
    /**
     * gibt informationen zur buchungsnummer zurueck
     * @param buchungsnummerIn
     * @return buchungsnummern[buchungsnummerIn]
     */
    public int[] recall(int buchungsnummerIn) {
        return buchungsnummern[buchungsnummerIn];
    }

    /**
     * gibt string mit freien bungalows fuer den zeitraum zurueck
     * @param anja
     * @param abja
     * @param anwo
     * @param abwo
     * @return
     */
    public String available(int anja, int abja, int anwo, int abwo) {
        boolean[] bAvailable = new boolean[10];
        String output = "";
        boolean first = true;
        for (int i = 0; i < buchungsnummern.length; i++) {
            bAvailable[i] = true;
        }
        for (int k = 0; k < database.length; k++) {
            for (int i = anja-2022; i < abja-2022; i++) {
                for (int j = anwo-1; j < abwo-1; j++) {
                    if(database[k][i][j][0] != -1) {
                        bAvailable[k] = false;
                    }
                    
                }
            }
        }
        for (int i = 0; i < bAvailable.length; i++) {
            if (bAvailable[i]) {
                if (first) {
                    output += i;
                } else {
                    output += ", " + i;
                }
            }
        }
        return output;
    }

    /**
     * stoniert buchungsnummer
     * @param buchungsnummer
     */
    public void stonieren(int buchungsnummer) {
        for (int i = buchungsnummern[buchungsnummer][5]-2022; i < buchungsnummern[buchungsnummer][6]-2022; i++) {
            for (int j = buchungsnummern[buchungsnummer][3]; j < buchungsnummern[buchungsnummer][4]; j++) {
                database[buchungsnummern[buchungsnummer][0]][i][j][0] = -1;
                database[buchungsnummern[buchungsnummer][0]][i][j][1] = -1;
                database[buchungsnummern[buchungsnummer][0]][i][j][2] = -1;
                database[buchungsnummern[buchungsnummer][0]][i][j][3] = -1;
                database[buchungsnummern[buchungsnummer][0]][i][j][4] = -1;
                database[buchungsnummern[buchungsnummer][0]][i][j][5] = -1;
                database[buchungsnummern[buchungsnummer][0]][i][j][6] = -1;
            }
        }
        buchungsnummern[buchungsnummer][0] = -1;
        buchungsnummern[buchungsnummer][1] = -1;
        buchungsnummern[buchungsnummer][2] = -1;
        buchungsnummern[buchungsnummer][3] = -1;
        buchungsnummern[buchungsnummer][4] = -1;
        buchungsnummern[buchungsnummer][5] = -1;
        buchungsnummern[buchungsnummer][6] = -1;
    }

}
