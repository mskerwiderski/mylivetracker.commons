package de.msk.mylivetracker.commons.rpc;

import java.io.Serializable;

/**
 * RpcRequest.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-15
 * 
 */
public abstract class RpcRequest implements Serializable {

	private static final long serialVersionUID = 1323861035747994803L;	

	protected String locale;
	
	public RpcRequest() {
	}

	public RpcRequest(String locale) {
		this.locale = locale;	
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	
}
