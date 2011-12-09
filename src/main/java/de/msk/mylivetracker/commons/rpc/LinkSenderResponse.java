package de.msk.mylivetracker.commons.rpc;



/**
 * LinkSenderResponse.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-14
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

	/**
	 * @return the serverAddress
	 */
	public String getServerAddress() {
		return serverAddress;
	}

	/**
	 * @param serverAddress the serverAddress to set
	 */
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	/**
	 * @return the serverPort
	 */
	public Integer getServerPort() {
		return serverPort;
	}

	/**
	 * @param serverPort the serverPort to set
	 */
	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
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
	 * @return the senderUsername
	 */
	public String getSenderUsername() {
		return senderUsername;
	}

	/**
	 * @param senderUsername the senderUsername to set
	 */
	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	/**
	 * @return the senderPassword
	 */
	public String getSenderPassword() {
		return senderPassword;
	}

	/**
	 * @param senderPassword the senderPassword to set
	 */
	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}

	/**
	 * @return the trackName
	 */
	public String getTrackName() {
		return trackName;
	}

	/**
	 * @param trackName the trackName to set
	 */
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LinkSenderResponse [serverAddress=" + serverAddress
			+ ", serverPort=" + serverPort + ", senderId=" + senderId
			+ ", senderName=" + senderName + ", senderUsername="
			+ senderUsername + ", senderPassword=" + senderPassword
			+ ", trackName=" + trackName + ", resultCode=" + resultCode
			+ ", resultMessage=" + resultMessage + "]";
	}	
}
