package cores;

import java.sql.Time;

public class BusDistance {
	private int did;
	private float distance;
	private Time duration;
	private int bus_id1;
	private int bus_id2;
	
	public BusDistance(int did, float distance, Time duration, int bus_id1, int bus_id2) {
		this.did = did;
		this.distance = distance;
		this.duration = duration;
		this.bus_id1 = bus_id1;
		this.bus_id2 = bus_id2;
	}
	
	public BusDistance(int did) {
		this(did,0,null,0,0);
	}

	public int getDid() {
		return did;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public int getBus_id1() {
		return bus_id1;
	}
	public void setBus_id1(int bus_id1) {
		this.bus_id1 = bus_id1;
	}
	public int getBus_id2() {
		return bus_id2;
	}
	public void setBus_id2(int bus_id2) {
		this.bus_id2 = bus_id2;
	}

	@Override
	public String toString() {
		return "BusDistance [did=" + did + ", distance=" + distance + ", duration=" + duration + ", bus_id1=" + bus_id1
				+ ", bus_id2=" + bus_id2 + "]";
	}
	
}
