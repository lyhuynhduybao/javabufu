package cores;

import java.sql.Time;

public class TimeTable {
	private int tid;
	private Time interv;
	
	public TimeTable(int tid, Time interv) {
		this.tid = tid;
		this.interv = interv;
	}
	
	public TimeTable(int tid) {
		this(tid,null);
	}

	public int getTid() {
		return tid;
	}
	public Time getInterv() {
		return interv;
	}
	public void setInterv(Time interv) {
		this.interv = interv;
	}
	
}
