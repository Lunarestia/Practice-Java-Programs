import java.util.Scanner;

public class TextMsgExpander {
    public static void main(String[] args) {

        //define strings
        String textMessage;
        String BFF = "best friend forever";
        String IDK = "I don't know";
        String JK = "just kidding";
        String TMI = "too much information";
        String TTYL = "talk to you later";

        //prompt for input
        System.out.println("Enter text: ");
        Scanner scnr = new Scanner(System.in);
        textMessage = scnr.nextLine();
        System.out.println("You entered: " + textMessage);
        System.out.println();

        //check for BFF
        if (textMessage.contains("BFF")) {
            textMessage = textMessage.replace("BFF", BFF);
            System.out.println("Replaced \"BFF\" with \"best friend forever\".");
        }
        //check for IDK
        if (textMessage.contains("IDK")) {
            textMessage = textMessage.replace("IDK", IDK);
            System.out.println("Replaced \"IDK\" with \"I don't know\".");
        }
        //check for JK
        if (textMessage.contains("JK")) {
            textMessage = textMessage.replace("JK", JK);
            System.out.println("Replaced \"JK\" with \"just kidding\".");
        }
        //check for TMI
        if (textMessage.contains("TMI")) {
            textMessage = textMessage.replace("TMI", TMI);
            System.out.println("Replaced \"TMI\" with \"too much information\".");
        }
        //check for TTYL
        if (textMessage.contains("TTYL")) {
            textMessage = textMessage.replace("TTYL", TTYL);
            System.out.println("Replaced \"TTYL\" with \"talk to you later\".");
        }
        //output text message expanded
        System.out.println();
        System.out.println("Expanded: " + textMessage);
    }
}