/*[진경수]*/
package model;

public class GuestAddr {
	private int guestAddrNo;
	private int guestNo;
	private String address;
	
	public int getGuestAddrNo() {
		return guestAddrNo;
	}
	public void setGuestAddrNo(int guestAddrNo) {
		this.guestAddrNo = guestAddrNo;
	}
	public int getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "GuestAddr [guestAddrNo=" + guestAddrNo + ", guestNo=" + guestNo + ", address=" + address + "]";
	}
}
