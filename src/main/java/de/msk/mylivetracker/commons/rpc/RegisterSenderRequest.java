package de.msk.mylivetracker.commons.rpc;

/**
 * classname: RegisterSenderRequest
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class RegisterSenderRequest extends RpcRequest {
	private static final long serialVersionUID = 5887406148061762562L;

	public static final String METHOD_NAME = "registerSender";
	
	private String senderId;
	private String senderName;
	private String portalUserId;
	private String portalPassword;
	private String timeZoneId;
	
	public RegisterSenderRequest() {		
	}

	public RegisterSenderRequest(String locale, 
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

	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getPortalUserId() {
		return portalUserId;
	}
	public void setPortalUserId(String portalUserId) {
		this.portalUserId = portalUserId;
	}
	public String getPortalPassword() {
		return portalPassword;
	}
	public void setPortalPassword(String portalPassword) {
		this.portalPassword = portalPassword;
	}
	public String getTimeZoneId() {
		return timeZoneId;
	}
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	@Override
	public String toString() {
		return "RegisterSenderRequest [senderId=" + senderId + ", senderName="
			+ senderName + ", portalUserId=" + portalUserId
			+ ", portalPassword=" + portalPassword + ", timeZoneId="
			+ timeZoneId + "]";
	}
}
