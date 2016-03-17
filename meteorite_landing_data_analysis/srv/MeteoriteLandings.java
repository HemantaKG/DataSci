/*NAME: Hemanta Kumar G
 *MeteotiteLandings row object class, holds each row of dataset at an object...
 *
 *MeteoriteLandings Data have following properties such as: name, id, nametype, recclass, mass, fall, year, GeoLocation.
 *getter/getter methods are used to access and modify datapoints...
 * */

public class MeteoriteLandings {
	private String name;
	private int id;
	private String nametype;
	private String recclass;
	private String mass;
	private String fall;
	private String year;
	private String GeoLocation;

	MeteoriteLandings(String name, int id, String nametype, String recclass,
			String mass, String fall, String year, String GeoLocation) {
		super();
		this.name = name;
		this.id = id;
		this.nametype = nametype;
		this.recclass = recclass;
		this.mass = mass;
		this.fall = fall;
		this.year = year;
		this.GeoLocation = GeoLocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNametype() {
		return nametype;
	}

	public void setNametype(String nametype) {
		this.nametype = nametype;
	}

	public String getRecclass() {
		return recclass;
	}

	public void setRecclass(String recclass) {
		this.recclass = recclass;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	public String getFall() {
		return fall;
	}

	public void setFall(String fall) {
		this.fall = fall;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGeoLocation() {
		return GeoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		GeoLocation = geoLocation;
	}

}
