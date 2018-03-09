/*[진경수]*/
package model;

public class Guest {
	private String guestNo;
	private String guestId;
	private String guestPw;
	public String getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(String guestNo) {
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
	@Override
	public String toString() {
		return "Guest [guestNo=" + guestNo + ", guestId=" + guestId + ", guestPw=" + guestPw + "]";
	}
}
