package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException {

        // Current usage
        BookMetadataFormatter formatter = null;
        try {
            formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.JSON);
            formatter.append(TestData.dragonBook);
            formatter.append(TestData.dinosaurBook);
            //System.out.print(formatter.getMetadataString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // Expected usage
        System.out.println("------------------------------------ XML Exporter ------------------------------------");

        BookMetadataExporter xmlExporter = new XMLBookMetadataExporter();
        xmlExporter.add(TestData.sailboatBook);
        xmlExporter.add(TestData.GoFBook);
        System.out.println(xmlExporter.export());

        System.out.println("------------------------------------ JSON Exporter ------------------------------------");
        BookMetadataExporter jsonExporter = new JSONBookMetadataExporter();
        jsonExporter.add(TestData.sailboatBook);
        jsonExporter.add(TestData.GoFBook);
        System.out.println(jsonExporter.export());

        System.out.println("\n------------------------------------ CSV Exporter ------------------------------------");
        BookMetadataExporter csvExporter = new CSVBookMetadataExporter();
        csvExporter.add(TestData.sailboatBook);
        csvExporter.add(TestData.GoFBook);
        System.out.println(csvExporter.export());
    }
}
