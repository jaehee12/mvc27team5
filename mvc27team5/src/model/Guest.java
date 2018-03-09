package model;

public class Guest {
	private String guestId;
	private String guestPw;
	
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
		return "Guest [guestId=" + guestId + ", guestPw=" + guestPw + "]";
	}
}
