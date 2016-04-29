package cores;

public class BusStop {
	private int bid;
	private String address;

	public BusStop(int bid, String address) {
		this.bid = bid;
		this.address = address;
	}

	public BusStop(int bid) {
		this(bid,"");
	}

	public int getBid() {
		return bid;
	}

	@Override
	public String toString() {
		return "BusStop [bid=" + bid + ", address=" + address + "]";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
