package de.msk.mylivetracker.commons.util.datetime;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * classname: DateTime
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-03	revised for v1.5.x.
 * 
 */
public class DateTime implements Serializable {	
	
	private static final Log log = LogFactory.getLog(DateTime.class);	
	
	private static final long serialVersionUID = 3805376142431179459L;
	
	public static final String TIME_ZONE_UTC = "Etc/UTC";
	public static final String TIME_ZONE_GERMANY = "Europe/Berlin";
	public static final String TIME_ZONE_CANADA = "Canada/Central";
	public static final String STD_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; 
	public static final String STD_DATE_FORMAT = "yyyy-MM-dd";	
	public static final String PRETTY_DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";
	public static final String PRETTY_DATE_FORMAT = "dd.MM.yyyy";
	public static final String INTERNAL_DATE_TIME_FMT = "yyyyMMddHHmmssSSS";
	public static final String INTERNAL_DATE_FMT = "yyyyMMdd";
	public static final String INTERNAL_TIME_DAY_BEGINS = "000000000";
	public static final String INTERNAL_TIME_DAY_ENDS = "235959999";
	
	private String dateTimeStrAsUtc = null;	
	private Date javaDateObjAsUtc = null;
	
	/**
	 * gets current date time as formatted string.
	 * @param timeZone - the requested time zone of the date time string.
	 * @param dateTimeStrFmt - the requested format of the date time string.
	 * @return the formatted current date time string.
	 */
	public static String getCurrentAsStr(TimeZone timeZone, String dateTimeStrFmt) {
		DateTime dateTime = new DateTime();
		return dateTime.getAsStr(timeZone, dateTimeStrFmt);
	}
	
	/**
	 * gets current utc date time as formatted string.
	 * @param timeZone - the requested time zone of the date time string.
	 * @param dateTimeStrFmt - the requested format of the date time string.
	 * @return the formatted current utc date time string.
	 */
	public static String getCurrentAsUtcStr(String dateTimeStrFmt) {
		DateTime dateTime = new DateTime();
		return dateTime.getAsStr(TimeZone.getTimeZone(TIME_ZONE_UTC), dateTimeStrFmt);
	}
	
	/**
	 * throws a runtime exception if given parse exception is not null.
	 * @param e - the parse exception.
	 */
	private void throwParseExceptionAsRuntimeExceptionIfNotNull(ParseException e) {
		if (e != null) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * throws a parse exception if given parse exception is not null.
	 * @param e - the parse exception.
	 * @throws ParseException if given e is not null. 
	 */
	private void throwParseExceptionAsParseExceptionIfNotNull(ParseException e) 
		throws ParseException {
		if (e != null) {
			throw e;
		}
	}
	
	/**
	 * constructs a date time object with current date time
	 * based on system time zone. 
	 * @param timeTone - the required time zone.
	 */
	public DateTime() {
		this(TimeZone.getDefault());
	}
	
	/**
	 * constructs a date time object with date time as milliseconds 
	 * since standard base time based on system time zone.
	 * @param msecs - the milliseconds.
	 * @param timeTone - the required time zone.
	 */	
	public DateTime(long msecs) {
		this(msecs, TimeZone.getDefault());
	}
	
	/**
	 * constructs a date time object with current date time 
	 * based on requested time zone.
	 * @param timeTone - the required time zone.
	 */
	public DateTime(TimeZone timeZone) {
		String srcDateTimeStr = javaDateObjToIntStrRep(new Date(), INTERNAL_DATE_TIME_FMT);
		ParseException exception = init(srcDateTimeStr, INTERNAL_DATE_TIME_FMT, timeZone);
		throwParseExceptionAsRuntimeExceptionIfNotNull(exception);
	}
	
	/**
	 * constructs a date time object with date time as milliseconds 
	 * since standard base time based on requested time zone.
	 * @param msecs - the milliseconds.
	 * @param timeTone - the required time zone.
	 */	
	public DateTime(long msecs, TimeZone timeZone) {
		String srcDateTimeStr = javaDateObjToIntStrRep(new Date(msecs), INTERNAL_DATE_TIME_FMT);
		ParseException exception = init(srcDateTimeStr, INTERNAL_DATE_TIME_FMT, timeZone);
		throwParseExceptionAsRuntimeExceptionIfNotNull(exception);
	}
		
	/**
	 * constructs a date time object with givven date time string, format and time zone.
	 * @param srcDateTimeStr - the given source date time string.
	 * @param srcDateTimeStrFmt - the given source date time string format.
	 * @param srcTimeZone - the given source time zone.
	 * @throws ParseException if one of the date time string parsing calls fails.
	 */	
	public DateTime(String srcDateTimeStr, String srcDateTimeStrFmt, TimeZone srcTimeZone) 
		throws ParseException{
		ParseException exception = init(srcDateTimeStr, srcDateTimeStrFmt, srcTimeZone);
		throwParseExceptionAsParseExceptionIfNotNull(exception);
	}	
		
	/**
	 * checks whether date time is in daylight time.
	 * @param timeZone - the required time zone.
	 * @return true if it is in daylight time, otherwise false.
	 */
	public boolean inDaylightTime(TimeZone timeZone) {
		return timeZone.inDaylightTime(this.javaDateObjAsUtc);
	}
	
	/**
	 * inits date time object.
	 * @param srcDateTimeStr - the given source date time string.
	 * @param srcDateTimeStrFmt - the given source date time string format.
	 * @param srcTimeZone - the given source time zone.
	 * @return parse exception if one of the date time string parsing calls fails. 
	 */
	private ParseException init(String srcDateTimeStr, String srcDateTimeStrFmt, TimeZone srcTimeZone) {
		ParseException exception = null;
		try {
			this.dateTimeStrAsUtc = modifyTimeZone(
				srcDateTimeStr, srcDateTimeStrFmt, 
				srcTimeZone, TimeZone.getTimeZone(TIME_ZONE_UTC), 
				INTERNAL_DATE_TIME_FMT);			
			SimpleDateFormat sdf = new SimpleDateFormat(INTERNAL_DATE_TIME_FMT);
			sdf.setTimeZone(TimeZone.getTimeZone(DateTime.TIME_ZONE_UTC));
			this.javaDateObjAsUtc = sdf.parse(this.dateTimeStrAsUtc);
		} catch (ParseException e) {
			exception = e;
		}
		return exception;
	}

	/**
	 * gets date time as milliseconds since standard base time.
	 * @return date time as milliseconds.
	 */
	public long getAsMSecs() {
		return this.javaDateObjAsUtc.getTime();
	}	
	
	/**
	 * gets date time as formatted string.
	 * @param timeZone - the requested time zone of the date time string.
	 * @param dateTimeStrFmt - the requested format of the date time string.
	 * @return the formatted date time string.
	 */
	public String getAsStr(TimeZone timeZone, String dateTimeStrFmt) {
		String dateTimeStr = null;
		try {
			dateTimeStr = modifyTimeZone(
				this.dateTimeStrAsUtc, INTERNAL_DATE_TIME_FMT, 
				TimeZone.getTimeZone(TIME_ZONE_UTC), timeZone, 
				dateTimeStrFmt);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return dateTimeStr;
	}
		
	/**
	 * gets a date time object as day based in given time zone.
	 * @param dateTime - the source date time object.
	 * @param timeZone - the requested time zone.
	 * @param isDayStart - indicates whether start of day or end of day is required.
	 * @return date time object as day based in given time zone.
	 */
	public static DateTime getAsDayBased(DateTime dateTime, TimeZone timeZone, boolean isDayStart) {
		String dayStartStr = dateTime.getAsDayBasedStr(
			timeZone, isDayStart, DateTime.STD_DATE_TIME_FORMAT);
		DateTime dayStartObj = null;
		try {
			dayStartObj = new DateTime(dayStartStr, 
				DateTime.STD_DATE_TIME_FORMAT, timeZone);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return dayStartObj;
	}
	
	/**
	 * gets date time string as day based (start of day = 00:00:00.000 or end of day 23:59:59.999).
	 * @param timeZone - the required time zone.
	 * @param isDayStart - indicates whether start of day or end of day is required.
	 * @param dateTimeStrFmt - required date time string format.
	 * @return date time string as day based.
	 */
	public String getAsDayBasedStr(TimeZone timeZone, boolean isDayStart, String dateTimeStrFmt) {		
		String dateTimeStrDayBased = 
			StringUtils.left(	
				this.getAsStr(timeZone, DateTime.INTERNAL_DATE_TIME_FMT), 8);
		log.debug("dateTimeStrDayBased=" + dateTimeStrDayBased);
		if (isDayStart) {
			dateTimeStrDayBased += DateTime.INTERNAL_TIME_DAY_BEGINS;
		} else {
			dateTimeStrDayBased += DateTime.INTERNAL_TIME_DAY_ENDS;
		}
		log.debug("dateTimeStrDayBased=" + dateTimeStrDayBased);
		try {
			dateTimeStrDayBased = modifyTimeZone(
				dateTimeStrDayBased, INTERNAL_DATE_TIME_FMT, 
				timeZone, timeZone, dateTimeStrFmt);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		log.debug("dateTimeStrDayBased=" + dateTimeStrDayBased);
		return dateTimeStrDayBased;
	}
	
	/**
	 * converts a java date object to a date time string.
	 * conversion is done without modifying the time zone.  
	 * @param date - the givven java date object.
	 * @param dateFmt - the requested format of the date time string.
	 * @return the internal string representation.
	 */
	private static String javaDateObjToIntStrRep(Date date, String dateFmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFmt);
		return sdf.format(date);
	}
	
	/**
	 * modifies the time zone of a given date time string.
	 * @param srcDateTimeStr - the source date time string.
	 * @param srcDateTimeStrFmt - the source date time string format.
	 * @param srcTimeZone - the time zone of the source date time string.
	 * @param destTimeZone - the requested destination time zone.
	 * @param destDateTimeStrFmt - the requested format of the destination date time string.
	 * @return a date time string in the requested format, based on the requested time zone.
	 * @throws ParseException if one of the date time string parsing calls fails.
	 */
	private static String modifyTimeZone(
		String srcDateTimeStr, String srcDateTimeStrFmt, 
		TimeZone srcTimeZone, TimeZone destTimeZone,
		String destDateTimeStrFmt) throws ParseException {
		log.debug("convert '" + srcDateTimeStr + "' from time zone '" + 
			srcTimeZone.getID() + "' to time zone '" + 
			destTimeZone.getID() + "'");
		SimpleDateFormat sdf = new SimpleDateFormat(srcDateTimeStrFmt);
		sdf.setTimeZone(srcTimeZone);
		Date srcDateTime = sdf.parse(srcDateTimeStr);
		sdf = new SimpleDateFormat(destDateTimeStrFmt);
		sdf.setTimeZone(destTimeZone);
		String destDateTimeStr = sdf.format(srcDateTime);
		log.debug("return: '" + destDateTimeStr + "'");
		return destDateTimeStr;
	}
		
	/**
	 * date time structure.
	 */
	public static class DateTimeStruct {
		public int year;
		public int month;
		public int day;
		public int hour;
		public int minute;
		public int second;
		public int millisecond;
		public String timeZoneId;
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "DateTimeStruct [year=" + year + ", month=" + month
				+ ", day=" + day + ", hour=" + hour + ", minute=" + minute
				+ ", second=" + second + ", millisecond=" + millisecond
				+ ", timeZoneId=" + timeZoneId + "]";
		}			
	}
	
	public static final String STRUCT_DATE_TIME_FORMAT = "yyyyMMddHHmmssSSS";
	
	/**
	 * gets date time as date time structure.
	 * @param timeZone - the required time zone.
	 * @return date time structure.
	 */
	public DateTimeStruct getDateTimeStruct(TimeZone timeZone) {
		if (timeZone == null) {
			throw new IllegalArgumentException("timeZone must not be empty.");
		}
		DateTimeStruct struct = new DateTimeStruct();
		String dateTimeStr = this.getAsStr(timeZone, STRUCT_DATE_TIME_FORMAT);		
		struct.year = Integer.valueOf(StringUtils.substring(dateTimeStr, 0, 4)); 
		struct.month = Integer.valueOf(StringUtils.substring(dateTimeStr, 4, 6));
		struct.day = Integer.valueOf(StringUtils.substring(dateTimeStr, 6, 8));
		struct.hour = Integer.valueOf(StringUtils.substring(dateTimeStr, 8, 10));
		struct.minute = Integer.valueOf(StringUtils.substring(dateTimeStr, 10, 12));
		struct.second = Integer.valueOf(StringUtils.substring(dateTimeStr, 12, 14));
		struct.millisecond = Integer.valueOf(StringUtils.substring(dateTimeStr, 14, 17));
		struct.timeZoneId = timeZone.getID();
		return struct;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DateTime [date=" + 
			this.getAsStr(TimeZone.getTimeZone(TIME_ZONE_UTC), PRETTY_DATE_TIME_FORMAT) + 
			" " + TIME_ZONE_UTC + "]";
	}	
}
