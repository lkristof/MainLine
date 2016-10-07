package Environment;

import Environment.misc.*;
import Environment.road_signs.ParkingTable;

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
    private List<WorldObject> DynamicObjects = null;
    private int[] tmpPos = new int[2];
    private double[] tmpTransform = new double[4];
    private int tmpZlevel;
    private int tmpOpacity;


    public boolean Parser() throws XMLStreamException {

        if (XmlFileOpener())
        {
            while (streamReader.hasNext()) {
                int event = streamReader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if ("Object".equals(streamReader.getLocalName())) {
                            tmpName = streamReader.getAttributeValue("", "name");
                            tmpId = Integer.parseInt(streamReader.getAttributeValue("", "id"));
                        }
                        if ("Objects".equals(streamReader.getLocalName())) {
                            DynamicObjects = new ArrayList<>();
                        }
                        if ("Position".equals(streamReader.getLocalName())) {
                            tmpPos[0] = (int)Math.round(Double.parseDouble(streamReader.getAttributeValue("","x")));
                            tmpPos[1] = (int)Math.round(Double.parseDouble(streamReader.getAttributeValue("","y")));
                        }
                        if ("Transform".equals(streamReader.getLocalName())) {
                            tmpTransform[0] = (int)Math.round(Double.parseDouble(streamReader.getAttributeValue("","m21")));
                            tmpTransform[1] = (int)Math.round(Double.parseDouble(streamReader.getAttributeValue("","m11")));
                            tmpTransform[2] = (int)Math.round(Double.parseDouble(streamReader.getAttributeValue("","m22")));
                            tmpTransform[3] = (int)Math.round(Double.parseDouble(streamReader.getAttributeValue("","m12")));
                        }
                        if ("ZLevel".equals(streamReader.getLocalName())) {
                            tmpZlevel = Integer.parseInt(streamReader.getAttributeValue("","ZLevel"));
                        }
                        if ("Opacity".equals(streamReader.getLocalName())) {
                            tmpOpacity = Integer.parseInt(streamReader.getAttributeValue("", "Opacity"));
                        }


                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if ("Object".equals(streamReader.getLocalName())){
                            String[] splitName = tmpName.split("/");
                            if (DynamicObjects != null) {
                                CreateClassElementByName(splitName[1],splitName[2],splitName[3]);
                            } else {
                                streamReader.close();
                                return false;
                            }
                        }
                        break;

                }
            }
            streamReader.close();
            return true;
        }
        else {
            streamReader.close();
            return false;
        }
    }

    private void CreateClassElementByName(String collection, String collectionType, String elementType)
    {
            switch (collectionType) {
                //misc mappában lévők
                case "crosswalks":
                    System.out.println(collectionType+"-t hozunk létre");
                    break;
                case "people": {
                    System.out.println(collectionType+"-t hozunk létre");
                    DynamicObjects.add(new People(tmpId, tmpPos, tmpTransform,tmpZlevel,tmpOpacity)); //int Id,  startPosition, int[] Transform, int Zlevel, int Opacity)
                }
                    break;
                case "trees":
                    System.out.println(collectionType+"-t hozunk létre");
                    DynamicObjects.add(new Tree(tmpId, tmpPos, tmpTransform,tmpZlevel,tmpOpacity));
                    break;
                case "parking":
                    switch (collection)
                    {
                        case "road_signs":
                        System.out.println(collectionType + " táblát hozunk létre");
                            switch (elementType) {
                                case "314_10_.svg":
                                    DynamicObjects.add(new ParkingSign(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity));
                                    break;
                                case "314_20_.svg":
                                    DynamicObjects.add(new ParkingTable(tmpId,tmpPos,tmpTransform,tmpZlevel,tmpOpacity));
                                    break;
                            }
                            break;
                        case "misc":
                            System.out.println(collectionType + " elemet hozunk létre");
                            switch (elementType) {
                                case "parking_0.svg":
                                    DynamicObjects.add(new Parking(tmpId,tmpPos,tmpTransform,tmpZlevel,tmpOpacity, Parking.ParkingElement.ParallelParking));
                                    break;
                                case "parking_90.svg":
                                    DynamicObjects.add(new Parking(tmpId,tmpPos,tmpTransform,tmpZlevel,tmpOpacity, Parking.ParkingElement.PerpendicularParkinng));
                                    break;
                                case "parking_bollard.pix":
                                    DynamicObjects.add(new Parking(tmpId,tmpPos,tmpTransform,tmpZlevel,tmpOpacity, Parking.ParkingElement.PerpendicularParkinng));
                                    break;
                            }

                            break;
                    }
                    break;
               //road_signs mappában lévők kivéve a parking-ot
                case "direction":
                    System.out.println(collectionType+"-t hozunk létre");
                    break;
                case "priority":
                    System.out.println(collectionType+"-t hozunk létre");
                    break;
                case "speed":
                    System.out.println(collectionType+"-t hozunk létre");
                    break;
                //road_tiles mappában lévők
                case "2_lane_simple":
                    System.out.println(collectionType+"-t hozunk létre");
                    break;
                case "2_lane_advanced":
                    System.out.println(collectionType+"-t hozunk létre");
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
                System.out.println(String.format("%s\n" + "%s", "Valami nem jó", e.getMessage()));
                return false;
            }
        }
        else {
            System.out.println("Nem lett megadva file");
            return false;
        }
    }
}
