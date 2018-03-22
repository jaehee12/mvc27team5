/*[진경수]*/
package model;

public class Guest {
	private int guestNo;
	private String guestId;
	private String guestPw;
	private int guestCount;
	public int getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestPw() {
		return guestPw;
	}
	public void setGuestPw(String guestPw) {
		this.guestPw = guestPw;
	}
	public int getGuestCount() {
		return guestCount;
	}
	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}
	@Override
	public String toString() {
		return "Guest [guestNo=" + guestNo + ", guestId=" + guestId + ", guestPw=" + guestPw + ", guestCount="
				+ guestCount + "]";
	}
	
	
}
