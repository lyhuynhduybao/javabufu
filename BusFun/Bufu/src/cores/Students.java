package cores;

public class Students {
	private int sid;
	private String name;
	private String address;
	private int bus_id;
	private int time_id;
	private String userName;
	private String password;
	private boolean admin;
	
	public Students(int sid, String name, String address, int bus_id, int time_id, String userName, String password,
			boolean admin) {
		this.sid = sid;
		this.name = name;
		this.address = address;
		this.bus_id = bus_id;
		this.time_id = time_id;
		this.userName = userName;
		this.password = password;
		this.admin = admin;
	}
	public Students(int sid) {
		this(sid,"","",0,0,"","",false);
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Students() {
	}
	public int getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public int getTime_id() {
		return time_id;
	}
	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "UserInfo [sid=" + sid + ", name=" + name + ", address=" + address + ", bus_id=" + bus_id + ", time_id="
				+ time_id + ", user_name=" + userName + ", password=" + password + ", admin=" + admin + "]";
	}
	
}
