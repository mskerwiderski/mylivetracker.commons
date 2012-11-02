package de.msk.mylivetracker.commons.rpc;

/**
 * LinkSenderResponse.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 001 2012-11-02 statusParamsId added.
 * 000 2011-08-14 initial.
 * 
 */
public class LinkSenderResponse extends RpcResponse {

	private static final long serialVersionUID = -4817872943024174676L;

	private String serverAddress;
	private Integer serverPort;
	private String senderId;
	private String senderName;
	private String senderUsername;
	private String senderPassword;
	private String trackName;	
	private String statusParamsId;
	
	public LinkSenderResponse() {		
	}
	
	public LinkSenderResponse(
		String locale, ResultCode resultCode) {
		super(locale, resultCode);		
	}
	
	public LinkSenderResponse(
		String locale, ResultCode resultCode,
		String addInfo) {
		super(locale, resultCode, addInfo);
	}

	public LinkSenderResponse(
		String locale, ResultCode resultCode,
		String serverAddress, Integer serverPort,
		String senderId, String senderName, String senderUsername,
		String senderPassword, String trackName,
		String statusParamsId) {
		super(locale, resultCode);
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		this.senderId = senderId;
		this.senderName = senderName;
		this.senderUsername = senderUsername;
		this.senderPassword = senderPassword;
		this.trackName = trackName;
		this.statusParamsId = statusParamsId;
	}

	public String getServerAddress() {
		return serverAddress;
	}
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public Integer getServerPort() {
		return serverPort;
	}
	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
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
	public String getSenderUsername() {
		return senderUsername;
	}
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}
	public String getSenderPassword() {
		return senderPassword;
	}
	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	public String getStatusParamsId() {
		return statusParamsId;
	}
	public void setStatusParamsId(String statusParamsId) {
		this.statusParamsId = statusParamsId;
	}

	@Override
	public String toString() {
		return "LinkSenderResponse [serverAddress=" + serverAddress
			+ ", serverPort=" + serverPort + ", senderId=" + senderId
			+ ", senderName=" + senderName + ", senderUsername="
			+ senderUsername + ", senderPassword=" + senderPassword
			+ ", trackName=" + trackName + ", statusParamsId="
			+ statusParamsId + "]";
	}
}
