package Test;
import Environment.XMLParserMain;
import org.junit.Assert;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import javax.swing.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;

/**
 * Created by Zolee on 2016. 10. 07..
 */
public class AllTests {

    private XMLStreamReader streamReader;
    private XMLInputFactory factory;
    private JFileChooser fileChooser;

    @Test
    public void XMLFileOpenSuccess() throws XMLStreamException {

        fileChooser = new JFileChooser(new File(System.getProperty("user.dir") + "/DataBus/src/Environment"));
        int returnValue = fileChooser.showOpenDialog(fileChooser.getParent());
        Assert.assertNotNull(fileChooser);
    }
    /*
    @Before
    public void XMLFileOpen() throws XMLStreamException {

        fileChooser = new JFileChooser(new File(System.getProperty("user.dir") + "/DataBus/src/Environment"));
        int returnValue = fileChooser.showOpenDialog(fileChooser.getParent());
        Assert.assertNotNull(fileChooser);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String path = getSelectedFile(fileChooser);
            factory = XMLInputFactory.newInstance();
            streamReader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(path));
        }
    }
    */
}
