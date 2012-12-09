package de.msk.mylivetracker.commons.rpc;

/**
 * RegisterUserRequest.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 2011-12-09 initial version.
 * 
 */
public class RegisterUserRequest extends ConnectToMyLiveTrackerPortalRequest {

	private static final long serialVersionUID = -7902424554270886274L;

	private String portalUserLastName;
	private String portalUserFirstName;
	private String portalUserEmailAddress;
	
	public RegisterUserRequest() {
		super();
	}

	public RegisterUserRequest(String locale,
		String senderId, String senderName, 
		String portalUserId, String portalPassword,
		String portalUserLastName,
		String portalUserFirstName,
		String portalUserEmailAddress,
		String timeZoneId) {
		super(locale, senderId, senderName, 
			portalUserId, portalPassword, timeZoneId);
		this.portalUserLastName = portalUserLastName;
		this.portalUserFirstName = portalUserFirstName;
		this.portalUserEmailAddress = portalUserEmailAddress;
	}

	/**
	 * @return the portalUserLastName
	 */
	public String getPortalUserLastName() {
		return portalUserLastName;
	}

	/**
	 * @param portalUserLastName the portalUserLastName to set
	 */
	public void setPortalUserLastName(String portalUserLastName) {
		this.portalUserLastName = portalUserLastName;
	}

	/**
	 * @return the portalUserFirstName
	 */
	public String getPortalUserFirstName() {
		return portalUserFirstName;
	}

	/**
	 * @param portalUserFirstName the portalUserFirstName to set
	 */
	public void setPortalUserFirstName(String portalUserFirstName) {
		this.portalUserFirstName = portalUserFirstName;
	}

	/**
	 * @return the portalUserEmailAddress
	 */
	public String getPortalUserEmailAddress() {
		return portalUserEmailAddress;
	}

	/**
	 * @param portalUserEmailAddress the portalUserEmailAddress to set
	 */
	public void setPortalUserEmailAddress(String portalUserEmailAddress) {
		this.portalUserEmailAddress = portalUserEmailAddress;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterUserRequest [portalUserLastName=" + portalUserLastName
			+ ", portalUserFirstName=" + portalUserFirstName
			+ ", portalUserEmailAddress=" + portalUserEmailAddress
			+ ", getSenderId()=" + getSenderId() + ", getSenderName()="
			+ getSenderName() + ", getPortalUserId()=" + getPortalUserId()
			+ ", getPortalPassword()=" + getPortalPassword()
			+ ", getTimeZoneId()=" + getTimeZoneId() + "]";
	}
}
