package de.msk.mylivetracker.commons.protocol;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * classname: UploadDataPacket
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class UploadDataPacket implements Serializable {
	
	private static final long serialVersionUID = 322646845849098059L;
	@SerializedName("f0") private Integer versionCode = null;	
	@SerializedName("f1") private String versionName = null;
	@SerializedName("f2") private String deviceId = null;
	@SerializedName("f3") private String trackId = null;
	@SerializedName("f4") private String trackName = null;	
	@SerializedName("f5") private Integer batteryPowerInPercent = null;
	@SerializedName("f6") private Double batteryPowerInVoltage = null;
	@SerializedName("f7") private Double mileageInMtr = null;
	@SerializedName("f8") private Boolean locationValid = null;
	@SerializedName("f9") private Double latitudeInDecimal = null;
	@SerializedName("f10") private Double longitudeInDecimal = null;
	@SerializedName("f11") private Float trackDistanceInMtr = null;
	@SerializedName("f12") private Double altitudeInMtr = null;
	@SerializedName("f13") private Double speedInMtrPerSecs = null;
	@SerializedName("f14") private Double locationAccuracyInMtr = null;
	@SerializedName("f15") private Integer countSatellites = null;
	@SerializedName("f16") private Long runtimeMSecsPausesIncl = null;
	@SerializedName("f17") private Long runtimeMSecsPausesNotIncl = null;
	@SerializedName("f18") private Long heartrateInBpm = null;
	@SerializedName("f19") private Long heartrateMinInBpm = null;
	@SerializedName("f20") private Long heartrateMaxInBpm = null;
	@SerializedName("f21") private Long heartrateAvgInBpm = null;
	@SerializedName("f22") private Boolean sosActivated = null;
	@SerializedName("f23") private Long sosId = null;
	@SerializedName("f24") private String message = null;
	@SerializedName("f25") private String phoneType = null;
	@SerializedName("f26") private String mobileCountryCode = null;
	@SerializedName("f27") private String mobileNetworkCode = null;
	@SerializedName("f28") private String mobileNetworkName = null;
	@SerializedName("f29") private String mobileNetworkType = null;
	@SerializedName("f30") private Integer cellId = null;
	@SerializedName("f31") private Integer localeAreaCode = null;
	@SerializedName("f32") private Long timestamp = null;
	@SerializedName("f33") private String username = null;
	@SerializedName("f34") private String seed = null;
	@SerializedName("f35") private String phoneNumber = null;
	
	/**
	 * @return the versionCode
	 */
	public Integer getVersionCode() {
		return versionCode;
	}
	/**
	 * @param versionCode the versionCode to set
	 */
	public void setVersionCode(Integer versionCode) {
		this.versionCode = versionCode;
	}
	/**
	 * @return the versionName
	 */
	public String getVersionName() {
		return versionName;
	}
	/**
	 * @param versionName the versionName to set
	 */
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the trackId
	 */
	public String getTrackId() {
		return trackId;
	}
	/**
	 * @param trackId the trackId to set
	 */
	public void setTrackId(String trackId) {
		this.trackId = trackId;
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
	/**
	 * @return the batteryPowerInPercent
	 */
	public Integer getBatteryPowerInPercent() {
		return batteryPowerInPercent;
	}
	/**
	 * @param batteryPowerInPercent the batteryPowerInPercent to set
	 */
	public void setBatteryPowerInPercent(Integer batteryPowerInPercent) {
		this.batteryPowerInPercent = batteryPowerInPercent;
	}
	/**
	 * @return the batteryPowerInVoltage
	 */
	public Double getBatteryPowerInVoltage() {
		return batteryPowerInVoltage;
	}
	/**
	 * @param batteryPowerInVoltage the batteryPowerInVoltage to set
	 */
	public void setBatteryPowerInVoltage(Double batteryPowerInVoltage) {
		this.batteryPowerInVoltage = batteryPowerInVoltage;
	}
	/**
	 * @return the mileageInMtr
	 */
	public Double getMileageInMtr() {
		return mileageInMtr;
	}
	/**
	 * @param mileageInMtr the mileageInMtr to set
	 */
	public void setMileageInMtr(Double mileageInMtr) {
		this.mileageInMtr = mileageInMtr;
	}
	/**
	 * @return the locationValid
	 */
	public Boolean getLocationValid() {
		return locationValid;
	}
	/**
	 * @param locationValid the locationValid to set
	 */
	public void setLocationValid(Boolean locationValid) {
		this.locationValid = locationValid;
	}
	/**
	 * @return the latitudeInDecimal
	 */
	public Double getLatitudeInDecimal() {
		return latitudeInDecimal;
	}
	/**
	 * @param latitudeInDecimal the latitudeInDecimal to set
	 */
	public void setLatitudeInDecimal(Double latitudeInDecimal) {
		this.latitudeInDecimal = latitudeInDecimal;
	}
	/**
	 * @return the longitudeInDecimal
	 */
	public Double getLongitudeInDecimal() {
		return longitudeInDecimal;
	}
	/**
	 * @param longitudeInDecimal the longitudeInDecimal to set
	 */
	public void setLongitudeInDecimal(Double longitudeInDecimal) {
		this.longitudeInDecimal = longitudeInDecimal;
	}
	/**
	 * @return the trackDistanceInMtr
	 */
	public Float getTrackDistanceInMtr() {
		return trackDistanceInMtr;
	}
	/**
	 * @param trackDistanceInMtr the trackDistanceInMtr to set
	 */
	public void setTrackDistanceInMtr(Float trackDistanceInMtr) {
		this.trackDistanceInMtr = trackDistanceInMtr;
	}
	/**
	 * @return the altitudeInMtr
	 */
	public Double getAltitudeInMtr() {
		return altitudeInMtr;
	}
	/**
	 * @param altitudeInMtr the altitudeInMtr to set
	 */
	public void setAltitudeInMtr(Double altitudeInMtr) {
		this.altitudeInMtr = altitudeInMtr;
	}
	/**
	 * @return the speedInMtrPerSecs
	 */
	public Double getSpeedInMtrPerSecs() {
		return speedInMtrPerSecs;
	}
	/**
	 * @param speedInMtrPerSecs the speedInMtrPerSecs to set
	 */
	public void setSpeedInMtrPerSecs(Double speedInMtrPerSecs) {
		this.speedInMtrPerSecs = speedInMtrPerSecs;
	}
	/**
	 * @return the locationAccuracyInMtr
	 */
	public Double getLocationAccuracyInMtr() {
		return locationAccuracyInMtr;
	}
	/**
	 * @param locationAccuracyInMtr the locationAccuracyInMtr to set
	 */
	public void setLocationAccuracyInMtr(Double locationAccuracyInMtr) {
		this.locationAccuracyInMtr = locationAccuracyInMtr;
	}
	/**
	 * @return the countSatellites
	 */
	public Integer getCountSatellites() {
		return countSatellites;
	}
	/**
	 * @param countSatellites the countSatellites to set
	 */
	public void setCountSatellites(Integer countSatellites) {
		this.countSatellites = countSatellites;
	}
	/**
	 * @return the runtimeMSecsPausesIncl
	 */
	public Long getRuntimeMSecsPausesIncl() {
		return runtimeMSecsPausesIncl;
	}
	/**
	 * @param runtimeMSecsPausesIncl the runtimeMSecsPausesIncl to set
	 */
	public void setRuntimeMSecsPausesIncl(Long runtimeMSecsPausesIncl) {
		this.runtimeMSecsPausesIncl = runtimeMSecsPausesIncl;
	}
	/**
	 * @return the runtimeMSecsPausesNotIncl
	 */
	public Long getRuntimeMSecsPausesNotIncl() {
		return runtimeMSecsPausesNotIncl;
	}
	/**
	 * @param runtimeMSecsPausesNotIncl the runtimeMSecsPausesNotIncl to set
	 */
	public void setRuntimeMSecsPausesNotIncl(Long runtimeMSecsPausesNotIncl) {
		this.runtimeMSecsPausesNotIncl = runtimeMSecsPausesNotIncl;
	}
	/**
	 * @return the heartrateInBpm
	 */
	public Long getHeartrateInBpm() {
		return heartrateInBpm;
	}
	/**
	 * @param heartrateInBpm the heartrateInBpm to set
	 */
	public void setHeartrateInBpm(Long heartrateInBpm) {
		this.heartrateInBpm = heartrateInBpm;
	}
	/**
	 * @return the heartrateMinInBpm
	 */
	public Long getHeartrateMinInBpm() {
		return heartrateMinInBpm;
	}
	/**
	 * @param heartrateMinInBpm the heartrateMinInBpm to set
	 */
	public void setHeartrateMinInBpm(Long heartrateMinInBpm) {
		this.heartrateMinInBpm = heartrateMinInBpm;
	}
	/**
	 * @return the heartrateMaxInBpm
	 */
	public Long getHeartrateMaxInBpm() {
		return heartrateMaxInBpm;
	}
	/**
	 * @param heartrateMaxInBpm the heartrateMaxInBpm to set
	 */
	public void setHeartrateMaxInBpm(Long heartrateMaxInBpm) {
		this.heartrateMaxInBpm = heartrateMaxInBpm;
	}
	/**
	 * @return the heartrateAvgInBpm
	 */
	public Long getHeartrateAvgInBpm() {
		return heartrateAvgInBpm;
	}
	/**
	 * @param heartrateAvgInBpm the heartrateAvgInBpm to set
	 */
	public void setHeartrateAvgInBpm(Long heartrateAvgInBpm) {
		this.heartrateAvgInBpm = heartrateAvgInBpm;
	}
	/**
	 * @return the sosActivated
	 */
	public Boolean getSosActivated() {
		return sosActivated;
	}
	/**
	 * @param sosActivated the sosActivated to set
	 */
	public void setSosActivated(Boolean sosActivated) {
		this.sosActivated = sosActivated;
	}
	/**
	 * @return the sosId
	 */
	public Long getSosId() {
		return sosId;
	}
	/**
	 * @param sosId the sosId to set
	 */
	public void setSosId(Long sosId) {
		this.sosId = sosId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}
	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	/**
	 * @return the mobileCountryCode
	 */
	public String getMobileCountryCode() {
		return mobileCountryCode;
	}
	/**
	 * @param mobileCountryCode the mobileCountryCode to set
	 */
	public void setMobileCountryCode(String mobileCountryCode) {
		this.mobileCountryCode = mobileCountryCode;
	}
	/**
	 * @return the mobileNetworkCode
	 */
	public String getMobileNetworkCode() {
		return mobileNetworkCode;
	}
	/**
	 * @param mobileNetworkCode the mobileNetworkCode to set
	 */
	public void setMobileNetworkCode(String mobileNetworkCode) {
		this.mobileNetworkCode = mobileNetworkCode;
	}
	/**
	 * @return the mobileNetworkName
	 */
	public String getMobileNetworkName() {
		return mobileNetworkName;
	}
	/**
	 * @param mobileNetworkName the mobileNetworkName to set
	 */
	public void setMobileNetworkName(String mobileNetworkName) {
		this.mobileNetworkName = mobileNetworkName;
	}
	/**
	 * @return the mobileNetworkType
	 */
	public String getMobileNetworkType() {
		return mobileNetworkType;
	}
	/**
	 * @param mobileNetworkType the mobileNetworkType to set
	 */
	public void setMobileNetworkType(String mobileNetworkType) {
		this.mobileNetworkType = mobileNetworkType;
	}
	/**
	 * @return the cellId
	 */
	public Integer getCellId() {
		return cellId;
	}
	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}
	/**
	 * @return the localeAreaCode
	 */
	public Integer getLocaleAreaCode() {
		return localeAreaCode;
	}
	/**
	 * @param localeAreaCode the localeAreaCode to set
	 */
	public void setLocaleAreaCode(Integer localeAreaCode) {
		this.localeAreaCode = localeAreaCode;
	}
	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the seed
	 */
	public String getSeed() {
		return seed;
	}
	/**
	 * @param seed the seed to set
	 */
	public void setSeed(String seed) {
		this.seed = seed;
	}	
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UploadDataPacket [versionCode=" + versionCode
			+ ", versionName=" + versionName + ", deviceId=" + deviceId
			+ ", trackId=" + trackId + ", trackName=" + trackName
			+ ", batteryPowerInPercent=" + batteryPowerInPercent
			+ ", batteryPowerInVoltage=" + batteryPowerInVoltage
			+ ", mileageInMtr=" + mileageInMtr + ", locationValid="
			+ locationValid + ", latitudeInDecimal=" + latitudeInDecimal
			+ ", longitudeInDecimal=" + longitudeInDecimal
			+ ", trackDistanceInMtr=" + trackDistanceInMtr
			+ ", altitudeInMtr=" + altitudeInMtr + ", speedInMtrPerSecs="
			+ speedInMtrPerSecs + ", locationAccuracyInMtr="
			+ locationAccuracyInMtr + ", countSatellites="
			+ countSatellites + ", runtimeMSecsPausesIncl="
			+ runtimeMSecsPausesIncl + ", runtimeMSecsPausesNotIncl="
			+ runtimeMSecsPausesNotIncl + ", heartrateInBpm="
			+ heartrateInBpm + ", heartrateMinInBpm=" + heartrateMinInBpm
			+ ", heartrateMaxInBpm=" + heartrateMaxInBpm
			+ ", heartrateAvgInBpm=" + heartrateAvgInBpm
			+ ", sosActivated=" + sosActivated + ", sosId=" + sosId
			+ ", message=" + message + ", phoneType=" + phoneType
			+ ", mobileCountryCode=" + mobileCountryCode
			+ ", mobileNetworkCode=" + mobileNetworkCode
			+ ", mobileNetworkName=" + mobileNetworkName
			+ ", mobileNetworkType=" + mobileNetworkType + ", cellId="
			+ cellId + ", localeAreaCode=" + localeAreaCode
			+ ", timestamp=" + timestamp + ", username=" + username
			+ ", seed=" + seed + ", phoneNumber=" + phoneNumber + "]";
	}					
}
