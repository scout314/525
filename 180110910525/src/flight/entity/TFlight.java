package flight.entity;

import java.sql.Timestamp;



public class TFlight {
	private int f_no;
	private TAirplane airPlane;
	private String f_start;
	private String f_dist;
	private float f_price;
	private Timestamp f_time;
	private int f_psgnum;
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public TAirplane getAirPlane() {
		return airPlane;
	}
	public void setAirPlane(TAirplane airPlane) {
		this.airPlane = airPlane;
	}
	public String getF_start() {
		return f_start;
	}
	public void setF_start(String f_start) {
		this.f_start = f_start;
	}
	public String getF_dist() {
		return f_dist;
	}
	public void setF_dist(String f_dist) {
		this.f_dist = f_dist;
	}
	public float getF_price() {
		return f_price;
	}
	public void setF_price(float f_price) {
		this.f_price = f_price;
	}
	public Timestamp getF_time() {
		return f_time;
	}
	public void setF_time(Timestamp f_time) {
		this.f_time = f_time;
	}
	public int getF_psgnum() {
		return f_psgnum;
	}
	public void setF_psgnum(int f_psgnum) {
		this.f_psgnum = f_psgnum;
	}
	
	


}
