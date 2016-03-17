/* NAME; Hemanta Kumar G
 * This Class was designed to Read CSV dataset file from given location,
 * This class reads records from CSV file as CSV format and stores into the MeteoriteLands objects
 * and finally the ArrayList<MeteoretiLands> returned to the caller
 * 
 * Here i used the Apache CSV file handling API, Because in given dataset some field value it self are separated by comma
 * */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadDataFromCSV {
	String filepath = null;

	ReadDataFromCSV(String filepath) {
		this.filepath = filepath;
	}

	public ArrayList<MeteoriteLandings> readData() {
		FileReader filereader = null;
		CSVFormat csvformat = null;
		CSVParser csvparser = null;
		List<MeteoriteLandings> dataset = new ArrayList<MeteoriteLandings>();

		// csvformat to retrieve some specific column data only as given problem
		// statement...
		csvformat = CSVFormat.EXCEL.withHeader("name", "id", "nametype",
				"recclass", "mass (g)", "fall", "year", "GeoLocation");
		try {
			filereader = new FileReader(filepath);
			csvparser = new CSVParser(filereader, csvformat);
			List<CSVRecord> csvrecords = csvparser.getRecords();
			//System.out.println(csvrecords.size());

			for (int i = 1; i < csvrecords.size(); i++) {
				CSVRecord record = (CSVRecord) csvrecords.get(i);
				MeteoriteLandings meteorite = new MeteoriteLandings(
						record.get("name"), Integer.parseInt(record.get("id")),
						record.get("nametype"), record.get("recclass"),
						record.get("mass (g)"), record.get("fall"),
						record.get("year"), record.get("GeoLocation"));

				dataset.add(meteorite);
			}
			csvparser.close();
		} catch (Exception e) {
		}
		return (ArrayList<MeteoriteLandings>) dataset;
	}
}
