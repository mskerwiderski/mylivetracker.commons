package de.msk.mylivetracker.commons.rpc;

/**
 * classname: RegisterSenderResponse
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class RegisterSenderResponse extends RpcResponse {

	private static final long serialVersionUID = -4817872943024174676L;

	private String serverAddress;
	private Integer serverPort;
	private String senderId;
	private String senderName;
	private String senderUsername;
	private String senderPassword;
	private String trackName;	
	
	public RegisterSenderResponse() {		
	}
	
	public RegisterSenderResponse(
		String locale, ResultCode resultCode) {
		super(locale, resultCode);		
	}
	
	public RegisterSenderResponse(
		String locale, ResultCode resultCode,
		String addInfo) {
		super(locale, resultCode, addInfo);
	}

	public RegisterSenderResponse(
		String locale, ResultCode resultCode,
		String serverAddress, Integer serverPort,
		String senderId, String senderName, String senderUsername,
		String senderPassword, String trackName) {
		super(locale, resultCode);
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		this.senderId = senderId;
		this.senderName = senderName;
		this.senderUsername = senderUsername;
		this.senderPassword = senderPassword;
		this.trackName = trackName;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegisterSenderResponse [serverAddress=")
			.append(serverAddress).append(", serverPort=")
			.append(serverPort).append(", senderId=").append(senderId)
			.append(", senderName=").append(senderName)
			.append(", senderUsername=").append(senderUsername)
			.append(", senderPassword=").append(senderPassword)
			.append(", trackName=").append(trackName).append("]");
		return builder.toString();
	}
}
