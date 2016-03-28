package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import cores.BusStop;
import cores.Students;
import cores.TimeTable;

public class DBUtils {
	public static Students findUser(Connection conn, String userName, String password) throws SQLException {

		String sql = "Select * from Students where user_name = ? and password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {

			int sid = rs.getInt("sid");
			String name = rs.getString("name");
			String address = rs.getString("address");
			int bus_id = rs.getInt("bus_id");
			int time_id = rs.getInt("time_id");
			boolean admin = rs.getBoolean("admin");
			Students user = new Students();
			user.setSid(sid);
			user.setUserName(userName);
			user.setPassword(password);
			user.setAddress(address);
			user.setName(name);
			user.setAdmin(admin);
			user.setBus_id(bus_id);
			user.setTime_id(time_id);
			user.toString();
			return user;
		}
		return null;
	}

	public static Students findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select * from Students where user_name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			rs.getInt("sid");
			String name = rs.getString("name");
			String address = rs.getString("address");
			int bus_id = rs.getInt("bus_id");
			int time_id = rs.getInt("time_id");
			String password = rs.getString("password");
			boolean admin = rs.getBoolean("admin");

			Students user = new Students();

			user.setUserName(userName);
			user.setPassword(password);
			user.setAddress(address);
			user.setName(name);
			user.setAdmin(admin);
			user.setBus_id(bus_id);
			user.setTime_id(time_id);

			return user;
		}
		return null;
	}
	public static void updateStudent(Connection con , Students student)throws SQLException{
		String sql = "UPDATE Students SET name = ?, address = ?, bus_id = ?, time_id = ?, password = ?, admin = ?, user_name = ? WHERE sid = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, student.getName());
		pstm.setString(2, student.getAddress());
		pstm.setInt(3, student.getBus_id());
		pstm.setInt(4, student.getTime_id());
		pstm.setString(5, student.getPassword());
		pstm.setBoolean(6, student.isAdmin());
		pstm.setString(7, student.getUserName());
		pstm.setInt(8, student.getSid());
		pstm.executeUpdate(sql);
	}
	
	public static BusStop findBusStop(Connection con, int bus_id) throws SQLException{
		String sql = "SELECT * FROM BusStop WHERE bid = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, bus_id);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()){
			String address = rs.getString("address");
			BusStop bstop = new BusStop(bus_id);
			bstop.setAddress(address);
			
			return bstop;	
		}

		return null;
	}
	public static List<BusStop> getTrip(Connection con, Students stu)throws SQLException{
		String sql = "SELECT * FROM BusStop WHERE tid=?";
		List<BusStop> list = new ArrayList<BusStop>();
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, stu.getTime_id());
		ResultSet rs = pstm.executeQuery();
		int i = 1;
		while(rs.next()){
			
			BusStop bs = new BusStop(i);
			bs.setAddress(rs.getString("address"));
			i++;
			list.add(bs);
		}
		return list;
	}
	public static void updateBusStop(Connection con, BusStop bstop)throws SQLException{
		String sql = "UPDATE BusStop SET address=? WHERE bid = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setString(1, bstop.getAddress());
		pstm.setInt(3, bstop.getBid());
		pstm.executeUpdate();
	}
	public static TimeTable findTime(Connection con, int time_id)throws SQLException{
		String sql = "SELECT * FROM TimeTable WHERE tid = ?";
		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, time_id);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()){
			Time interv = rs.getTime("interv");
			TimeTable tb = new TimeTable(time_id);
			tb.setInterv(interv);
			return tb;
		}
		return null;
	}


}
