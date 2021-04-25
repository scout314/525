package flight.entity;

import java.sql.Timestamp;



public class TOrder {
	private int o_no;
	private TUser user;
	private TFlight flight;
	private String o_f_start;
	private String o_f_dist;
	private float o_f_price;
	private Timestamp o_time;
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public TFlight getFlight() {
		return flight;
	}
	public void setFlight(TFlight flight) {
		this.flight = flight;
	}
	
	public String getO_f_start() {
		return o_f_start;
	}
	public void setO_f_start(String o_f_start) {
		this.o_f_start = o_f_start;
	}
	public String getO_f_dist() {
		return o_f_dist;
	}
	public void setO_f_dist(String o_f_dist) {
		this.o_f_dist = o_f_dist;
	}
	
	public float getO_f_price() {
		return o_f_price;
	}
	public void setO_f_price(float o_f_price) {
		this.o_f_price = o_f_price;
	}
	public Timestamp getO_time() {
		return o_time;
	}
	public void setO_time(Timestamp o_time) {
		this.o_time = o_time;
	}
	
	
	
}
