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
        int[] lastInput = new int[11];
        int[] arr = new int[11];
        final int[] outputPorts = { 4, 11, 13 };

        while (true) {
            // wait for change
            Boolean change = false;
            while (!change) {
                arr = inputUpdate(userInterface);
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != lastInput[i]) {
                        change = true;
                        System.out.println(i + ":\t" + arr[i]);
                    }
                }
                if (bungalowgui.getTxt()[11] == -2) {
                    System.out.println("Button \"buchen\" Pressed");
                    buchen(userInterface, outputPorts, database);
                }
                if (bungalowgui.getTxt()[13] == -2) {
                    System.out.println("Button \"stonieren\" Pressed");
                    userInterface.setOutput(outputPorts[2], stonieren(database, arr));
                }
                lastInput = arr;
            }

            // logic
            // verfuegbarkeit
            if (arr[0] == -1 || arr[1] == -1 || arr[2] == -1 || arr[3] == -1) {
                userInterface.setOutput(outputPorts[0], "bitte daten eingeben");
            } else if ((arr[1] > arr[3]) || (arr[1] == arr[3] && arr[0] > arr[2])) {
                userInterface.setOutput(outputPorts[0], "ERROR: departure date has to be after arrival date");
            } else if (arr[0] < 1 || arr[0] > 53 || arr[2] < 1 || arr[2] > 53) {
                userInterface.setOutput(outputPorts[0], "ERROR: woche has to be between 1 and 53");
            } else if (arr[1] < 2022 || arr[1] > 2122) {
                userInterface.setOutput(outputPorts[0], "ERROR: Jahr has to be between 2022 and 2122");
            } else {
                userInterface.setOutput(outputPorts[0], database.available(arr[1], arr[3], arr[0], arr[2]));
            }
            // informationen
            userInterface.setOutput(outputPorts[2], database.recall(arr[4]));
        }
    }
    /**
     * @param userInterface gui
     * @param outputPorts indexes of the output
     * @param database database
     */
    private static void buchen(bungalowgui userInterface, int[] outputPorts, datenbank database) {
        int[] arr = inputUpdate(userInterface);
        if (arr[5] == -1 || arr[6] == -1 || arr[7] == -1 || arr[8] == -1) {
            userInterface.setOutput(outputPorts[1], "bitte daten eingeben");
        } else if ((arr[6] > arr[8]) || (arr[6] == arr[8] && arr[5] > arr[7])) {
            userInterface.setOutput(outputPorts[1], "ERROR: departure date has to be after arrival date");
        } else if (arr[5] < 1 || arr[5] > 53 || arr[7] < 1 || arr[7] > 53) {
            userInterface.setOutput(outputPorts[1], "ERROR: woche has to be between 1 and 53");
        } else if (arr[6] < 2022 || arr[6] > 2122) {
            userInterface.setOutput(outputPorts[1], "ERROR: Jahr has to be between 2022 and 2122");
        } else {
            userInterface.setOutput(outputPorts[1],
                    database.save(arr[9], arr[10], arr[5], arr[7], arr[6], arr[8]));
        }
    }

    /**
     * gibt der datenbank den befehl zum stonieren
     * @param database database
     * @param arr user input
     * @return true if successful and false otherwise
     */
    private static String stonieren(datenbank database, int[] arr) {
        return database.stonieren(arr[4]);
    }

    /**
     * pulls and returns userinput
     * 
     * @param userInterface the gui object
     * @return the user input
     */
    private static int[] inputUpdate(bungalowgui userInterface) {
        /**
         * @return [0] => anreise woche | verfuegbarkeit
         * @return [1] => anreise jahr | verfuegbarkeit
         * @return [2] => abreise woche | verfuegbarkeit
         * @return [3] => abreise jahr | verfuegbarkeit
         * @return [4] => buchungsnummer | information
         * @return [5] => anreise woche | buchung
         * @return [6] => anreise jahr | buchung
         * @return [7] => abreise woche | buchung
         * @return [8] => abreise jahr | buchung
         * @return [9] => bungalow | buchung
         * @return [10] => anzahl personen | buchung
         */
        int[] inputArray = userInterface.getTxt();
        int[] returnArr = new int[11];
        returnArr[0] = inputArray[0];
        returnArr[1] = inputArray[1];
        returnArr[2] = inputArray[2];
        returnArr[3] = inputArray[3];
        returnArr[4] = inputArray[12];
        returnArr[5] = inputArray[5];
        returnArr[6] = inputArray[6];
        returnArr[7] = inputArray[7];
        returnArr[8] = inputArray[8];
        returnArr[9] = inputArray[9];
        returnArr[10] = inputArray[10];
        return returnArr;
    }

}
