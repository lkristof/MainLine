package Environment;

import Environment.*;
import Environment.misc.*;

import javax.swing.*;
import javax.xml.stream.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ral2bp on 2016.09.29..
 */
public class XMLParserMain {

    private XMLInputFactory factory;
    private XMLStreamReader streamReader;
    private int tmpId;
    private String tmpName;
    private String tmpType;
    private List<WorldObject> DynamicObjects = null;
    private int tmpPosX;
    private int tmpPosY;
    private int[] Transform = new int[4];
    private int Zlevel;
    private int Opacity;


    public boolean Parser() throws XMLStreamException {

        if (XmlFileOpener() == true)
        {
            while (streamReader.hasNext()) {
                int event = streamReader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("Object".equals(streamReader.getLocalName())) {
                            tmpType = streamReader.getAttributeValue("", "type");
                            tmpName = streamReader.getAttributeValue("", "name");
                            tmpId = Integer.parseInt(streamReader.getAttributeValue("", "id"));
                        }
                        if ("Objects".equals(streamReader.getLocalName())) {
                            DynamicObjects = new ArrayList<>();
                        }
                        if ("Position".equals(streamReader.getLocalName())) {
                            tmpPosX = Integer.parseInt(streamReader.getAttributeValue("","x"));
                            tmpPosY = Integer.parseInt(streamReader.getAttributeValue("","y"));
                        }
                        if ("Transform".equals(streamReader.getLocalName())) {
                            Transform[0] = Integer.parseInt(streamReader.getAttributeValue("","m21"));
                            Transform[1] = Integer.parseInt(streamReader.getAttributeValue("","m11"));
                            Transform[2] = Integer.parseInt(streamReader.getAttributeValue("","m22"));
                            Transform[3] = Integer.parseInt(streamReader.getAttributeValue("","m12"));
                        }
                        if ("ZLevel".equals(streamReader.getLocalName())) {
                            Zlevel = Integer.parseInt(streamReader.getAttributeValue("","ZLevel"));
                        }
                        if ("Opacity".equals(streamReader.getLocalName())) {
                            Opacity = Integer.parseInt(streamReader.getAttributeValue("", "Opacity"));
                        }


                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if ("Object".equals(streamReader.getLocalName())){
                            String[] splitNameTag;
                            splitNameTag = tmpName.split("/");
                            if (DynamicObjects != null) {
                                CreateClassElementByName(splitNameTag[2]);
                            } else {

                                return false;
                            }
                        }
                        break;

                }
            }
            return true;
        }
        else
            return false;
    }

    private void CreateClassElementByName(String name)
    {
            switch (name) {
                case "people": {
                    System.out.println(name+"-t hozunk létre");
                    DynamicObjects.add(new People(tmpId, null, null, tmpId, tmpId));
                }
                    break;
                case "trees":
                    System.out.println(name+"-t hozunk létre");
                    DynamicObjects.add(new Tree(tmpId,null,null,tmpId,tmpId));
                    break;
                case "parking":
                    switch (tmpType)
                    {
                        case "svg":
                        System.out.println(name + " táblát hozunk létre");
                            break;
                        case "image":
                            System.out.println(name + " elemet hozunk létre");
                            break;
                    }


                    break;
                case "2_lane_simple":
                    System.out.println(name+"-t hozunk létre");
                    break;
                case "2_lane_advanced":
                    System.out.println(name+"-t hozunk létre");
                    break;
                case "crosswalks":
                    System.out.println(name+"-t hozunk létre");
                    break;
                case "direction":
                    System.out.println(name+"-t hozunk létre");
                    break;
            }
    }

    private boolean XmlFileOpener() //
    {
        JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.dir")+"/DataBus/src/Environment"));
        int returnValue = fileChooser.showOpenDialog(fileChooser.getParent());
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String[] parse = selectedFile.getPath().split("\\\\");
            String path = parse[parse.length - 2] + "\\" + parse[parse.length - 1];
            System.out.println("A feldolgozandó XML: " + parse[parse.length-1]);
            try {
                factory = XMLInputFactory.newInstance();
                streamReader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(path));
                return true;

            } catch (XMLStreamException e) {
                System.out.println("Valami nem jó");
                return false;
            }
        }
        else {
            System.out.println("Nem lett megadva file");
            return false;
        }
    }
}
