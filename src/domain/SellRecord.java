package domain;

import java.util.List;


public class SellRecord {

	private int sellNum;
	private String guestName;
	private List<WineRecord> listRecord;
	public int getSellNum() {
		return sellNum;
	}
	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public List<WineRecord> getListRecord() {
		return listRecord;
	}
	public void setListRecord(List<WineRecord> listRecord) {
		this.listRecord = listRecord;
	} 
}
