package de.msk.mylivetracker.commons.rpc;

/**
 * LinkSenderResponse.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-12-26
 * 
 */
public class RegisterUserResponse extends ConnectToMyLiveTrackerPortalResponse {

	private static final long serialVersionUID = -7353691274871842016L;
	
	public RegisterUserResponse() {
		super();
	}

	public RegisterUserResponse(
		String locale, ResultCode resultCode) {
		super(locale, resultCode);		
	}
	
	public RegisterUserResponse(
		String locale, ResultCode resultCode,
		String addInfo) {
		super(locale, resultCode, addInfo);
	}

	public RegisterUserResponse(
		String locale, ResultCode resultCode,
		String serverAddress, Integer serverPort,
		String senderId, String senderName, String senderUsername,
		String senderPassword, String trackName) {
		super(locale, resultCode,
			serverAddress, serverPort,
			senderId, senderName, senderUsername,
			senderPassword, trackName);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterUserResponse [toString()=" + super.toString() + "]";
	}
}
