package de.msk.mylivetracker.commons.rpc;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

/**
 * classname: RpcResponse
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public abstract class RpcResponse implements Serializable {

	private static final long serialVersionUID = -3961353471464696L;
	
	public enum ResultCode {
		Ok(0),
		InternalServerError(-1),
		InvalidData(-2),
		InvalidInputParams(-10),
		InvalidPortalUsernamePassword(-20),
		SenderIdNotAllowed(-30),
		SenderCountLimitReached(-40),
		SenderNotAuthorized(-50),
		ProtocolVersionNotSupported(-100);
		private int code;
		private ResultCode(int code) {
			this.code = code;			
		}
		public boolean isSuccess() {
			return this.equals(Ok);
		}
		public int getCode() {
			return code;
		}
	}
	
	protected ResultCode resultCode;
	protected String resultMessage;	
	protected String addInfo;
		
	public RpcResponse() {
	}
	
	private static final String RESULTCODES = "de.msk.mylivetracker.commons.rpc.resultcodes.resultcodes";
	
	public RpcResponse(String locale, ResultCode resultCode, String addInfo) {
		this(locale, resultCode);
		this.addInfo = addInfo;		
	}
	
	public RpcResponse(String locale, ResultCode resultCode) {
		this.resultCode = resultCode;
		
		this.resultMessage = ResourceBundle.getBundle(
			RESULTCODES, 
			StringUtils.equalsIgnoreCase(locale, "de") ? Locale.GERMAN : Locale.ENGLISH).
			getString(resultCode.name());		
	}
	
	/**
	 * @return the resultCode
	 */
	public ResultCode getResultCode() {
		return resultCode;
	}
	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * @return the resultMessage
	 */
	public String getResultMessage() {
		return resultMessage;
	}
	/**
	 * @param resultMessage the resultMessage to set
	 */
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	/**
	 * @return the addInfo
	 */
	public String getAddInfo() {
		return addInfo;
	}
	/**
	 * @param addInfo the addInfo to set
	 */
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}		
}
