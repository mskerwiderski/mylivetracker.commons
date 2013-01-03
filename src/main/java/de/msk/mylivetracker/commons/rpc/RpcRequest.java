package de.msk.mylivetracker.commons.rpc;

import java.io.Serializable;

/**
 * classname: RpcRequest
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
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

	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
}
