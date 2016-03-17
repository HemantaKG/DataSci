/*NAME HEMANTA KUMAR G
 * THIS CODE WAS DESIGNED TO ANALYSIS OF DATA AS PER GIVEN PROBLEM STATEMENTS...
 * 
 * TO RUN: THIS CLASS HAVE THE main() METHOD...
 * 
 * 1. groupByRecclass(): Performs the group by arrangement of recclass data points
 * 2. massHeaviestAndLightest(): Finds the MAX and MIN mass values
 * 3. averageMass() Finds the Average mass of whole data point...
 * 4*. yearRange10(): shows the # of records in 10 year range...*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DoAnalysis {

	private Double[] massList(ArrayList<MeteoriteLandings> dataset) {
		Set<Double> mass_set = new TreeSet<Double>();

		Iterator<MeteoriteLandings> iterator = dataset.iterator();
		while (iterator.hasNext()) {
			MeteoriteLandings meteorite = iterator.next();
			if (!meteorite.getMass().equals("")) {
				mass_set.add(Double.parseDouble(meteorite.getMass()));
			} else {
				mass_set.add(0.0);
			}
		}
		Double[] mass_list = new Double[mass_set.size()];
		mass_set.toArray(mass_list);
		return mass_list;
	}

	public void groupByRecclass(ArrayList<MeteoriteLandings> dataset) {
		Map<String, Integer> treemap = new TreeMap<String, Integer>();

		Iterator<MeteoriteLandings> iterator = dataset.iterator();
		while (iterator.hasNext()) {
			MeteoriteLandings meteorite = iterator.next();
			if (treemap.containsKey(meteorite.getRecclass())) {
				treemap.put(meteorite.getRecclass(),
						treemap.get(meteorite.getRecclass()) + 1);
			} else {
				treemap.put(meteorite.getRecclass(), 1);
			}
		}
		Set<String> set = treemap.keySet();
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			System.out.println(key + " " + treemap.get(key));//OUTPUT 1...
		}
	}

	public void massHeaviestAndLightest(ArrayList<MeteoriteLandings> dataset) {
		Double[] mass_list = this.massList(dataset);
		System.out.println("Heaviest Mass: " + mass_list[mass_list.length - 1]);
		System.out.println("Lightest Mass: " + mass_list[0]);
		//OUTPUT 2...

	}

	public void averageMass(ArrayList<MeteoriteLandings> dataset) {
		double sum = 0.0;
		int count = 0;
		
		/*
		 * Double[] mass_list = this.massList(dataset); for (double mass :
		 * mass_list) { sum += mass; }
		 */
		
		Iterator<MeteoriteLandings> iterator = dataset.iterator();
		while (iterator.hasNext()) {
			MeteoriteLandings meteorite = iterator.next();
			if (!meteorite.getMass().equals("")) {
				sum += Double.parseDouble(meteorite.getMass());
				count++;
			} else {
				count++;
			}
		}
		System.out.println("Average Mass: " + sum / count);//OUTPUT 4...
	}

	public void yearRange10(ArrayList<MeteoriteLandings> dataset) {
		Map<Integer, Integer> treemap1 = new TreeMap<Integer, Integer>();
		int maxyear = 0;
		int minyear = 0;

		Iterator<MeteoriteLandings> iterator = dataset.iterator();
		while (iterator.hasNext()) {
			MeteoriteLandings meteorite = iterator.next();
			if (!meteorite.getYear().equals("")) {
				String[] temp = meteorite.getYear().split(" ")[0].toString()
						.split("/");
				int year = Integer.parseInt(temp[2]);
				if (treemap1.containsKey(year)) {
					treemap1.put(year, treemap1.get(year) + 1);
				} else {
					treemap1.put(year, 1);
				}
				if (maxyear == 0 && minyear == 0) {
					maxyear = year;
					minyear = year;
				}
				if (maxyear < year) {
					maxyear = year;
				} else if (minyear > year) {
					minyear = year;
				}

			} else {
				// meteorite.setYear("blank");
			}
		}
		//System.out.println(maxyear);
		//System.out.println(minyear);
		//System.out.println(treemap1);

		Map<String, Integer> treemap2 = new TreeMap<String, Integer>();
		Set<Integer> year_list = treemap1.keySet();
		Iterator<Integer> it = year_list.iterator();
		int year1 = it.next();
		int year2 = 0;
		String label = null;
		while (it.hasNext()) {
			year2 = it.next();
			if (year2 - year1 > 10) {
				label = year1 + "-" + (year1 + 10);
				year1 = year2;
			} else if (year2 - year1 == 10) {
				label = year1 + "-" + year2;
				year1 = year2;
			} else {
				label = year1 + "-" + (year1 + 10);
			}

			if (treemap2.containsKey(label)) {
				treemap2.put(label, treemap2.get(label) + treemap1.get(year1));
			} else {
				treemap2.put(label, treemap1.get(year1));
			}
		}
		Set<String> label_set= treemap2.keySet();
		Iterator<String> iterator1= label_set.iterator();
		while(iterator1.hasNext()){
			String key= iterator1.next();
			System.out.println(key+ ", " + treemap2.get(key));// OUTPUT 3*
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath = "./Archive/Meteorite_Landings.csv";
		ArrayList<MeteoriteLandings> dataset = new ReadDataFromCSV(filepath)
				.readData();
		DoAnalysis doAnalysis = new DoAnalysis();

		System.out.println("SHOW THE RECORDS GROUP BY \"RECCLASS\": ");
		doAnalysis.groupByRecclass(dataset);

		System.out.println();
		
		System.out
				.println("SHOW THE HEAVIEST MASS RECORD VALUE AND LIGHTEST MASS RECORD VALUE: ");
		doAnalysis.massHeaviestAndLightest(dataset);

		System.out.println();
		
		System.out.println("SHOW TH AVERAGE MASS VALUE: ");
		doAnalysis.averageMass(dataset);

		System.out.println();
		
		System.out.println("SHOW THE # RECORDS IN 10 YEAR DURATION RANGE: ");
		doAnalysis.yearRange10(dataset);
	}

}
