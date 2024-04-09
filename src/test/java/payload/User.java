package payload;

public class User {
//	int id;
//	String username;
//	String firstName;
//	String lastName; 
//	String email; 
//	String password; 
//	String phone; 
//	String userStatus; 
//	String screenshotPath; 
//	
//	public String getScreenshotPath() {
//		return screenshotPath;
//	}
//
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int i) {
//		this.id = i;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String string) {
//		this.phone = string;
//	}
//	public String getUserStatus() {
//		return userStatus;
//	}
//	public void setUserStatus(String userStatus) {
//		this.userStatus = userStatus;
//	}
//	
//	
//	
	int airlineId;
	String airlineName;
	String iata;
	String icao; 
	String alias; 
	String callsign;
	int createdBy;
	int updatedBy;
	
	public int getAirlineId() {
		return airlineId;
	}
	public void getAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}
	public String getIcao() {
		return icao;
	}
	public void setIcao(String icao) {
		this.icao = icao;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getCallsign() {
		return callsign;
	}
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	} 
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	} 
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	} 
}
