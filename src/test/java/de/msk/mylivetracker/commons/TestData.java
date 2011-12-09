package de.msk.mylivetracker.commons;

import java.util.Date;

import de.msk.mylivetracker.commons.protocol.UploadDataPacket;

/**
 * TestData.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-13
 * 
 */
public final class TestData {
	public static UploadDataPacket createUploadDataPacket() {
		UploadDataPacket uploadDataPacket = new UploadDataPacket();
		uploadDataPacket.setVersionCode(10);
		uploadDataPacket.setVersionName("1.2.0");
		uploadDataPacket.setDeviceId("device1");
		uploadDataPacket.setTrackId("1234567");
		uploadDataPacket.setTrackName("Track");
		uploadDataPacket.setLatitudeInDecimal(47.913250);
		uploadDataPacket.setLongitudeInDecimal(11.107537);
		uploadDataPacket.setLocationAccuracyInMtr(7.0);
		uploadDataPacket.setAltitudeInMtr(455.0);
		uploadDataPacket.setSpeedInMtrPerSecs(17.4);
		uploadDataPacket.setTrackDistanceInMtr(7052.0f);
		uploadDataPacket.setMileageInMtr(102.0);
		uploadDataPacket.setCountSatellites(5);
		uploadDataPacket.setTimestamp(((new Date()).getTime()));
		uploadDataPacket.setRuntimeMSecsPausesIncl(10000L);
		uploadDataPacket.setRuntimeMSecsPausesNotIncl(7000L);
		uploadDataPacket.setMobileCountryCode("262");
		uploadDataPacket.setMobileNetworkCode("02");
		uploadDataPacket.setMobileNetworkName("T-Mobile DE");
		uploadDataPacket.setMobileNetworkType("EDGE");
		uploadDataPacket.setLocaleAreaCode(17300);
		uploadDataPacket.setCellId(38233);
		uploadDataPacket.setHeartrateInBpm(102L);
		uploadDataPacket.setHeartrateMinInBpm(78L);
		uploadDataPacket.setHeartrateMaxInBpm(141L);
		uploadDataPacket.setHeartrateAvgInBpm(112L);
		return uploadDataPacket;
	}
}
