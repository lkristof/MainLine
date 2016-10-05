import Environment.*;
import javax.xml.stream.XMLStreamException;


/**
 * Created by ral2bp on 2016.09.29..
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Main has started");

        try {
            if (new XMLParserMain().Parser() == true)
                System.out.println("Sikeres feldolgozás");
            else
                System.out.println("Sikertelen feldolgozás");
        }
        catch (XMLStreamException e) {
            System.out.println("Sikertelen feldolgozás");
        }
        /*Call modules in the logical order here*/


    }

}
