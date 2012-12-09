package de.msk.mylivetracker.commons.rpc;

/**
 * ConnectToMyLiveTrackerPortalRequest.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-14
 * 
 */
public class ConnectToMyLiveTrackerPortalRequest extends RpcRequest {

	private static final long serialVersionUID = 5887406148061762562L;
	
	private String senderId;
	private String senderName;
	private String portalUserId;
	private String portalPassword;
	private String timeZoneId;
	
	public ConnectToMyLiveTrackerPortalRequest() {		
	}

	public ConnectToMyLiveTrackerPortalRequest(String locale, 
		String senderId, String senderName,
		String portalUserId, String portalPassword,
		String timeZoneId) {
		super(locale);
		this.senderId = senderId;
		this.senderName = senderName;
		this.portalUserId = portalUserId;
		this.portalPassword = portalPassword;
		this.timeZoneId = timeZoneId;
	}


	/**
	 * @return the senderId
	 */
	public String getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId the senderId to set
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the portalUserId
	 */
	public String getPortalUserId() {
		return portalUserId;
	}

	/**
	 * @param portalUserId the portalUserId to set
	 */
	public void setPortalUserId(String portalUserId) {
		this.portalUserId = portalUserId;
	}

	/**
	 * @return the portalPassword
	 */
	public String getPortalPassword() {
		return portalPassword;
	}

	/**
	 * @param portalPassword the portalPassword to set
	 */
	public void setPortalPassword(String portalPassword) {
		this.portalPassword = portalPassword;
	}

	/**
	 * @return the timeZoneId
	 */
	public String getTimeZoneId() {
		return timeZoneId;
	}

	/**
	 * @param timeZoneId the timeZoneId to set
	 */
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConnectToMyLiveTrackerPortalRequest [senderId=")
			.append(senderId).append(", senderName=").append(senderName)
			.append(", portalUserId=").append(portalUserId)
			.append(", portalPassword=").append(portalPassword)
			.append(", timeZoneId=").append(timeZoneId).append("]");
		return builder.toString();
	}
}
