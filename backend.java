import java.util.ArrayList; // import the ArrayList class
/**
 * @author Jasatai (JL)
 * @version 0.1.0
 * @since 0.0.1
 */
public class backend {
    
    public static void main(String[] args) {
        bungalowgui userInterface = new bungalowgui();
        userInterface.init();
        datenbank database = new datenbank();
        database.init();

        while (true) {
            int[] arr = inputUpdate(userInterface);
            //logic
            //verfuegbarkeit
            if ((arr[1] > arr[3]) || (arr[1] == arr[3] && arr[0] > arr[2])) {
                userInterface.setTextFreieBungalows("ERROR: departure date has to be after arrival date");
            } else {
                userInterface.setTextFreieBungalows(database.available(arr[1], arr[3], arr[0], arr[2]));
            }
            //informationen
            String output = "";
            output += "bungalow: " + database.recall(arr[4])[0];
            output += "\nanzahl personen: " + database.recall(arr[4])[1];
            output += "\nbuchungsnummer: " + database.recall(arr[4])[2];
            output += "anreise woche: " + database.recall(arr[4])[3];
            output += "abreise woche: " + database.recall(arr[4])[4];
            output += "anreise jahr: " + database.recall(arr[4])[5];
            output += "abreise jahr: " + database.recall(arr[4])[6];
            userInterface.setTextFreieBungalows(output);
            //buchung
            if (userInterface.buttonJetztBuchen) {
                userInterface.buttonJetztBuchen = false;
                if (arr[6] > 2022 || arr[8] > 2032) {
                    userInterface.setTextFreieBungalows("buchungs ERROR: nicht in der vergangenheit und nicht mehr als 10 jahre in der zukunft buchen");
                } else {
                    if ((arr[6] > arr[8]) || (arr[6] == arr[8] && arr[5] > arr[7])) {
                        userInterface.setTextFreieBungalows("buchungs ERROR: departure date has to be after arrival date");
                    } else {
                        userInterface.setTxtpnBuchungsnummer("" + database.save(arr[9], arr[10], arr[5], arr[6], arr[6], arr[8]));
                    }
                }
            }
            if (userInterface.buttonJHierStonieren) {
                userInterface.buttonJHierStonieren = false;
                database.stonieren(arr[4]);
            }
        }
    }

    /**
     * pulls and returns userinput
     * @param userInterface
     * @return
     */
    private static int[] inputUpdate(bungalowgui userInterface) {
        /*
         * @return [0]  => anreise woche    | verfuegbarkeit
         * @return [1]  => anreise jahr     | verfuegbarkeit
         * @return [2]  => abreise woche    | verfuegbarkeit
         * @return [3]  => abreise jahr     | verfuegbarkeit
         * @return [4]  => buchungsnummer   | information
         * @return [5]  => anreise woche    | buchung
         * @return [6]  => anreise jahr     | buchung
         * @return [7]  => abreise woche    | buchung
         * @return [8]  => abreise jahr     | buchung
         * @return [9]  => bungalow         | buchung
         * @return [10] => anzahl personen  | buchung
         */
        int[] returnArr = new int[10];
        returnArr[0] = userInterface.getTxtpnWoche1();
        returnArr[1] = userInterface.getTxtpnJahr();
        returnArr[2] = userInterface.getTextWoche();
        returnArr[3] = userInterface.getTextJahr_1();
        returnArr[4] = userInterface.getTextBuchungsnummerPane_2();
        returnArr[5] = userInterface.getTextWochePane_1();
        returnArr[6] = userInterface.getTextJahrPane_1();
        returnArr[7] = userInterface.getTextWochePane_2();
        returnArr[8] = userInterface.getTextJahrPane_2();
        returnArr[9] = userInterface.getTxtpnBungalowNummer();
        returnArr[10] = userInterface.getTextAnzahlPersonenPane_1();
        return returnArr;
    }

}
