package de.msk.mylivetracker.commons.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * classname: SerDeserializer
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class SerDeserializer {

	private boolean compress = false;
	private Gson gson = null;
	
	public SerDeserializer(boolean compress) {
		this.compress = compress;
		this.gson = new GsonBuilder().create();
	}
	
	public byte[] serialize(UploadDataPacket uploadDataPacket) {
		byte[] bytes = null;
		String gsonStr = this.gson.toJson(uploadDataPacket);
		if (this.compress) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gos = null;
			try {			
				gos = new GZIPOutputStream(baos);
				gos.write(gsonStr.getBytes());
				gos.close();
				bytes = baos.toByteArray();
			} catch (Exception e) {
				bytes = null;
			}
		} else {
			bytes = gsonStr.getBytes();
		}
		return bytes;
	}
		
	public UploadDataPacket deserialize(byte[] bytes) {
		UploadDataPacket uploadDataPacket = null;
		StringBuffer sbuf = new StringBuffer();		
		try {
			if (this.compress) {
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				GZIPInputStream gis = new GZIPInputStream(bais);
				byte[] buffer = new byte[256];
				int cnt = -1;
				do {
					cnt = gis.read(buffer, 0, 256);
					if (cnt > 0) {
						sbuf.append(new String(buffer, 0, cnt));
					}
				} while (cnt != -1);
				gis.close();
			} else {
				sbuf.append(new String(bytes));
			}			
			Gson gson = new Gson();
			uploadDataPacket = (UploadDataPacket) gson.fromJson(
				sbuf.toString(), UploadDataPacket.class);
		} catch (Exception e) {
			uploadDataPacket = null;
		} 
		
		return uploadDataPacket;
	}
}
