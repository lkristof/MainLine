package Environment;

import Environment.misc.*;
import Environment.road_signs.*;
import Environment.road_tiles.LaneAdvanced;
import Environment.road_tiles.LaneSimple;
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

    public XMLInputFactory getXMLInputFactory(){return factory;}

    private XMLStreamReader streamReader;
    private int sceneHeihgt;
    private int sceneWidth;
    private int sceneMeasureType;
    private String sceneColor;
    private Scene scene;

    private int tmpId;
    private String tmpName;
    private String parameterGroupName;

    private List<WorldObject> DynamicObjects = null;

    //interface-hez tulajdonsáj hogy visszaadhassuk a teljes listát
    public List<WorldObject> getDynamicObjects(){return  DynamicObjects; }

    private int[] tmpPos = new int[2];
    private double[] tmpTransform = new double[4];
    private int tmpZlevel;
    private int tmpOpacity;
    private int[] tmpRoadColor1 = new int[4]; // 0 - r, 1 - g, 2 - b, 3 - a
    private int[] tmpRoadColor2 = new int[4]; // 0 - g, 1 - type, 2 - index, 3 - r, 4 - a, 5 - name, 6 - b, (7 - text)
    private int[] tmpRoadColor3 = new int[4]; // 0 - g, 1 - type, 2 - index, 3 - r, 4 - a, 5 - name, 6 - b, (7 - text)

    private String tmpRoadPaintingName1 = "";
    private String tmpRoadPaintingName2 = "";
    private String tmpRoadPaintingName3 = "";

    private static XMLParserMain instance = null;
    private JFileChooser jFileChooser = null;

    public void setjFileChooser(JFileChooser jFileChooser) {
        this.jFileChooser = jFileChooser; }

    public static XMLParserMain getInstance(){
        if (instance == null){
            instance = new XMLParserMain();
        }
        return instance;
    }

    public boolean Parser() throws XMLStreamException {

        if (XmlFileOpener()) {
            while (streamReader.hasNext()) {
                int event = streamReader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        objectCase();
                        sceneCase();
                        checkIfTagEqual();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (objectCaseWithEndElement()) {
                            return false;
                        }
                        sceneCaseWithEndElement();
                        break;
                }
            }
            streamReader.close();
            //writeOutTheObjects();
            return true;
        } else {
            streamReader.close();
            return false;
        }
    }

    final protected boolean XmlFileOpener()
    {
        JFileChooser fileChooser = new JFileChooser(new File(System.getProperty("user.dir") + "/DataBus/src/Environment"));
        int returnValue = fileChooser.showOpenDialog(fileChooser.getParent());
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String[] parse = selectedFile.getPath().split("\\\\");
            String path = parse[parse.length - 2] + "\\" + parse[parse.length - 1];
            System.out.println("A feldolgozandó XML: " + parse[parse.length - 1]);
            try {
                factory = XMLInputFactory.newInstance();
                streamReader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(path));
                return true;

            } catch (XMLStreamException e) {
                System.out.println(String.format("%s\n" + "%s", "Valami nem jó", e.getMessage()));
                return false;
            }
        } else {
            System.out.println("Nem lett megadva file");
            return false;
        }
    }

    private void sceneCase() {
        if ("Scene".equals(streamReader.getLocalName())) {
            sceneWidth = Integer.parseInt(streamReader.getAttributeValue("", "width"));
            sceneHeihgt = Integer.parseInt(streamReader.getAttributeValue("", "height"));
            sceneMeasureType = Integer.parseInt(streamReader.getAttributeValue("", "measureType"));
            sceneColor = streamReader.getAttributeValue("", "color");
        }
    }
    //for test cases
    final protected void objectCase() {
        if ("Object".equals(streamReader.getLocalName())) {
            tmpName = streamReader.getAttributeValue("", "name");
            tmpId = Integer.parseInt(streamReader.getAttributeValue("", "id"));
        }
    }

    private void checkIfTagEqual() {
        if ("Objects".equals(streamReader.getLocalName())) {
            DynamicObjects = new ArrayList<>();
        }
        if ("Position".equals(streamReader.getLocalName())) {
            tmpPos[0] = (int) Math.round(Double.parseDouble(streamReader.getAttributeValue("", "x")));
            tmpPos[1] = (int) Math.round(Double.parseDouble(streamReader.getAttributeValue("", "y")));
        }
        if ("Transform".equals(streamReader.getLocalName())) {
            tmpTransform[0] = Double.parseDouble(streamReader.getAttributeValue("", "m21"));
            tmpTransform[1] = Double.parseDouble(streamReader.getAttributeValue("", "m11"));
            tmpTransform[2] = Double.parseDouble(streamReader.getAttributeValue("", "m22"));
            tmpTransform[3] = Double.parseDouble(streamReader.getAttributeValue("", "m12"));
        }
        if ("ZLevel".equals(streamReader.getLocalName())) {
            tmpZlevel = Integer.parseInt(streamReader.getAttributeValue("", "ZLevel"));
        }
        if ("Opacity".equals(streamReader.getLocalName())) {
            tmpOpacity = Integer.parseInt(streamReader.getAttributeValue("", "Opacity"));
        }
        if ("ParameterGroup".equals(streamReader.getLocalName())) {
            parameterGroupNameSwitch();
        }
        if ("Parameter".equals(streamReader.getLocalName())) {
            getParameterByGroupName();
        }
    }

    private boolean objectCaseWithEndElement() throws XMLStreamException {
        if ("Object".equals(streamReader.getLocalName())) {
            String[] splitName = tmpName.split("/");
            if (DynamicObjects != null) {
                CreateClassElementByName(splitName[1], splitName[2], splitName[3]);
            } else {
                streamReader.close();
                return true;
            }
        }
        return false;
    }

    private void getParameterByGroupName() {
        switch (parameterGroupName) {
            case "RoadColor_1":
                tmpRoadColor1[0] = Integer.parseInt(streamReader.getAttributeValue("", "r"));
                tmpRoadColor1[1] = Integer.parseInt(streamReader.getAttributeValue("", "g"));
                tmpRoadColor1[2] = Integer.parseInt(streamReader.getAttributeValue("", "b"));
                tmpRoadColor1[3] = Integer.parseInt(streamReader.getAttributeValue("", "a"));
                break;
            case "RoadColor_2":
                tmpRoadColor2[0] = Integer.parseInt(streamReader.getAttributeValue("", "r"));
                tmpRoadColor2[1] = Integer.parseInt(streamReader.getAttributeValue("", "g"));
                tmpRoadColor2[2] = Integer.parseInt(streamReader.getAttributeValue("", "b"));
                tmpRoadColor2[3] = Integer.parseInt(streamReader.getAttributeValue("", "a"));
                break;
            case "RoadColor_3":
                tmpRoadColor3[0] = Integer.parseInt(streamReader.getAttributeValue("", "r"));
                tmpRoadColor3[1] = Integer.parseInt(streamReader.getAttributeValue("", "g"));
                tmpRoadColor3[2] = Integer.parseInt(streamReader.getAttributeValue("", "b"));
                tmpRoadColor3[3] = Integer.parseInt(streamReader.getAttributeValue("", "a"));
                break;
            case "RoadPainting_1":
                if ("true".equals(streamReader.getAttributeValue("", "value"))) {
                    tmpRoadPaintingName1 = streamReader.getAttributeValue("", "name");
                }
                break;
            case "RoadPainting_2":
                if ("true".equals(streamReader.getAttributeValue("", "value"))) {
                    tmpRoadPaintingName2 = streamReader.getAttributeValue("", "name");
                }
                break;
            case "RoadPainting_3":
                if ("true".equals(streamReader.getAttributeValue("", "value"))) {
                    tmpRoadPaintingName3 = streamReader.getAttributeValue("", "name");
                }
                break;
            case "":
                break;
            default:
                break;
        }
    }

    private void parameterGroupNameSwitch() {
        switch (streamReader.getAttributeValue("", "name")) {
            case "RoadColor_1":
                parameterGroupName = "RoadColor_1";
                break;
            case "RoadColor_2":
                parameterGroupName = "RoadColor_2";
                break;
            case "RoadColor_3":
                parameterGroupName = "RoadColor_3";
                break;
            case "RoadPainting_1":
                parameterGroupName = "RoadPainting_1";
                break;
            case "RoadPainting_2":
                parameterGroupName = "RoadPainting_2";
                break;
            case "RoadPainting_3":
                parameterGroupName = "RoadPainting_3";
                break;
            default:
                parameterGroupName = "";
        }
    }



    private void CreateClassElementByName(String collection, String collectionType, String elementType) {
        switch (collectionType) {
            //misc mappában lévők
            case "crosswalks":
                DynamicObjects.add(new Crosswalk(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity));
                break;
            case "people": {
                DynamicObjects.add(new People(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity)); //int Id,  startPosition, int[] Transform, int Zlevel, int Opacity)
            }
            break;
            case "trees":
                DynamicObjects.add(new Tree(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity));
                break;
            case "parking":
                parkingCollectionSwitch(collection, collectionType, elementType);
                break;
            //road_signs mappában lévők kivéve a parking-ot
            case "direction":
                createDirectionTable(elementType);
                break;
            case "priority":
                createPriorityTable(elementType);
                break;
            case "speed":
                createSpeedTable(elementType);
                break;
            //road_tiles mappában lévők
            case "2_lane_simple":
                create2laneSimple(elementType);
                break;
            case "2_lane_advanced":
                create2LaneAdvanced(elementType);
                break;
        }
    }

    private void createDirectionTable(String elementType) {
        switch (elementType) {
            case "209-30_.svg":
                DynamicObjects.add(new Direction(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Direction.DirectionType.Forward));
                break;
            case "211-10_.svg":
                DynamicObjects.add(new Direction(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Direction.DirectionType.Left));
                break;
            case "211-20_.svg":
                DynamicObjects.add(new Direction(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Direction.DirectionType.Right));
                break;
            case "214-10_.svg":
                DynamicObjects.add(new Direction(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Direction.DirectionType.ForwardLeft));
                break;
            case "214-20_.svg":
                DynamicObjects.add(new Direction(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Direction.DirectionType.ForwardRight));
                break;
            case "215_.svg":
                DynamicObjects.add(new Direction(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Direction.DirectionType.Round));
                break;
        }
    }

    private void createPriorityTable(String elementType) {
        switch (elementType) {
            case "205_.svg":
                DynamicObjects.add(new Priority(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Priority.PriorityType.Yield));
                break;
            case "206_.svg":
                DynamicObjects.add(new Priority(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Priority.PriorityType.Stop));
                break;
            case "306_.svg":
                DynamicObjects.add(new Priority(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Priority.PriorityType.Priority));
                break;
        }
    }

    private void createSpeedTable(String elementType) {
        switch (elementType) {
        case "274_51_.svg": //10
        DynamicObjects.add(new Speed(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Speed.SpeedType.Ten));
        break;
        case "274_52_.svg": //20
        DynamicObjects.add(new Speed(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Speed.SpeedType.Twenty));
        break;
        case "274_54_.svg": //400
        DynamicObjects.add(new Speed(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Speed.SpeedType.Forty));
        break;
        case "274_55_.svg": //50
        DynamicObjects.add(new Speed(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Speed.SpeedType.Fifty));
        break;
        case "274_57_.svg": //70
        DynamicObjects.add(new Speed(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Speed.SpeedType.Seventy));
        break;
        case "274_59_.svg": //90
        DynamicObjects.add(new Speed(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Speed.SpeedType.Ninety));
        break;
        case "274_60_.svg": //100
        DynamicObjects.add(new Speed(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, Speed.SpeedType.Hundred));
        break;
    }
    }

    private void create2LaneAdvanced(String elementType) {
        switch (elementType) {
            case "2_t_junction_l.tile":
                DynamicObjects.add(new LaneAdvanced(tmpId, tmpPos, 890, 1400, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneAdvanced.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneAdvanced.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneAdvanced.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneAdvanced.LaneAdvancedType.TJunctionLeft));
                break;
            case "2_t_junction_r.tile":
                DynamicObjects.add(new LaneAdvanced(tmpId, tmpPos, 890, 1400, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneAdvanced.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneAdvanced.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneAdvanced.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneAdvanced.LaneAdvancedType.TJunctionRight));
                break;
            case "2_rotary.tile":
                DynamicObjects.add(new LaneAdvanced(tmpId, tmpPos, 1400, 1400, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneAdvanced.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneAdvanced.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneAdvanced.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneAdvanced.LaneAdvancedType.Rotary));
                break;
            case "2_crossroads_2.tile":
                DynamicObjects.add(new LaneAdvanced(tmpId, tmpPos, 1400, 1400, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneAdvanced.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneAdvanced.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneAdvanced.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneAdvanced.LaneAdvancedType.CrossRoads));
                break;
        }
    }

    private void create2laneSimple(String elementType) {
        switch (elementType) {
            case "2_simple_45l.tile":
                DynamicObjects.add(new LaneSimple(tmpId, tmpPos, 390, 370, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneSimple.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneSimple.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneSimple.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneSimple.LaneSimpleType.Left45));
                break;
            case "2_simple_45r.tile":
                DynamicObjects.add(new LaneSimple(tmpId, tmpPos, 390, 370, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneSimple.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneSimple.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneSimple.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneSimple.LaneSimpleType.Right45));
                break;
            case "2_simple_65l.tile":
                DynamicObjects.add(new LaneSimple(tmpId, tmpPos, 450, 475, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneSimple.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneSimple.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneSimple.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneSimple.LaneSimpleType.Left65));
                break;
            case "2_simple_65r.tile":
                DynamicObjects.add(new LaneSimple(tmpId, tmpPos, 450, 475, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneSimple.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneSimple.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneSimple.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneSimple.LaneSimpleType.Right65));
                break;
            case "2_simple_90l.tile":
                DynamicObjects.add(new LaneSimple(tmpId, tmpPos, 530, 530, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneSimple.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneSimple.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneSimple.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneSimple.LaneSimpleType.Left90));
                break;
            case "2_simple_90r.tile":
                DynamicObjects.add(new LaneSimple(tmpId, tmpPos, 530, 530, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneSimple.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneSimple.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneSimple.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneSimple.LaneSimpleType.Right90));
                break;
            case "2_simple_s.tile":
                DynamicObjects.add(new LaneSimple(tmpId, tmpPos, 350, 350, tmpTransform, tmpZlevel, tmpOpacity, tmpRoadColor1, tmpRoadColor2, tmpRoadColor3, LaneSimple.RoadPaintings1.valueOf(tmpRoadPaintingName1), LaneSimple.RoadPaintings2.valueOf(tmpRoadPaintingName2), LaneSimple.RoadPaintings3.valueOf(tmpRoadPaintingName3), LaneSimple.LaneSimpleType.Straight));
                break;
        }
    }

    private void parkingCollectionSwitch(String collection, String collectionType, String elementType) {
        switch (collection) {
            case "road_signs":
                createParkingSign(elementType);
                break;
            case "misc":
                createParkingMisc(elementType);
                break;
        }
    }

    private void createParkingSign(String elementType) {
        switch (elementType) {
            case "314_10_.svg": //bal
                DynamicObjects.add(new ParkingSign(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, ParkingSign.ParkingSignType.ParkingLeft));
                break;
            case "314_20_.svg": //jobb
                DynamicObjects.add((new ParkingSign(tmpId, tmpPos, tmpTransform, tmpZlevel, tmpOpacity, ParkingSign.ParkingSignType.ParkingRight)));
                break;
        }
    }

    private void createParkingMisc(String elementType) {
        switch (elementType) {
            case "parking_0.svg":
                DynamicObjects.add(new Parking(tmpId, tmpPos, 150, 600, tmpTransform, tmpZlevel, tmpOpacity, Parking.ParkingElement.ParallelParking, false));
                break;
            case "parking_90.svg":
                DynamicObjects.add(new Parking(tmpId, tmpPos, 300, 460, tmpTransform, tmpZlevel, tmpOpacity, Parking.ParkingElement.PerpendicularParking, false));
                break;
            case "parking_bollard.pix":
                DynamicObjects.add(new Parking(tmpId, tmpPos, 80, 75, tmpTransform, tmpZlevel, tmpOpacity, Parking.ParkingElement.Bollard, true));
                break;
        }
    }

    private void sceneCaseWithEndElement() {
        if ("Scene".equals(streamReader.getLocalName())) {
            scene = new Scene(sceneWidth, sceneHeihgt, sceneMeasureType, sceneColor);
        }
    }

    public List<WorldObject> getWorld()
    {
        return DynamicObjects;
    }

    public List<WorldObject> getObjectsSeenForSensors()
    {
        //itt le kell majd szűrni a szenzor által látott területen alapján
        return DynamicObjects;
    }

    public void writeOutTheObjects()
    {
        for (WorldObject object : DynamicObjects)
        {
            System.out.println("Objektum: " + object.toString());
        }
    }

    public Scene getScene()
    {
        return this.scene;
    }
}
