package org.kpu.web.domain;

import java.sql.Date;

public class BoardVO {
	 private int b_no;
	    private String b_title;
	    private String b_detail;
	    private String b_writer;
	    private Date b_date;
	    private String b_passwd;
	    
	    public BoardVO(){};
	    
	    public int getB_no() {
	        return b_no;
	    }
	    public void setB_no(int b_no) {
	        this.b_no = b_no;
	    }
	    public String getB_title() {
	        return b_title;
	    }
	    public void setB_title(String b_title) {
	        this.b_title = b_title;
	    }
	    public String getB_detail() {
	        return b_detail;
	    }
	    public void setB_detail(String b_detail) {
	        this.b_detail = b_detail;
	    }
	    public String getB_writer() {
	        return b_writer;
	    }
	    public void setB_writer(String b_writer) {
	        this.b_writer = b_writer;
	    }
	    public Date getB_date() {
	        return b_date;
	    }
	    public void setB_date(Date b_date) {
	        this.b_date = b_date;
	    }
	    public String getB_passwd() {
	        return b_passwd;
	    }
	    public void setB_passwd(String b_passwd) {
	        this.b_passwd = b_passwd;
	    }
	    
	    @Override
		public String toString() {
			return "BoardVO [b_no=" + b_no + ", b_title=" + b_title + ", b_detail=" + b_detail + ", b_writer=" + b_writer + ", b_daet="
					+ b_date + ", b_passwd=" + b_passwd + "]";
		}
}
