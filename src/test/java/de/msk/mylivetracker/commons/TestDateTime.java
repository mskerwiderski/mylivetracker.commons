package de.msk.mylivetracker.commons;

import java.text.ParseException;
import java.util.TimeZone;

import junit.framework.TestCase;
import de.msk.mylivetracker.commons.util.datetime.DateTime;
import de.msk.mylivetracker.commons.util.datetime.DateTime.DateTimeStruct;

/**
 * TestDateTime.
 * 
 * @author michael skerwiderski, (c)2011
 * 
 * @version 000
 * 
 * history
 * 000 initial 2011-08-11
 * 
 */
public class TestDateTime extends TestCase {

	private static final TimeZone TZ_UTC = TimeZone.getTimeZone(DateTime.TIME_ZONE_UTC);
	private static final TimeZone TZ_GERMANY = TimeZone.getTimeZone(DateTime.TIME_ZONE_GERMANY);
	private static final TimeZone TZ_CANADA = TimeZone.getTimeZone(DateTime.TIME_ZONE_CANADA);
			
	public void testDateTimeConstrutcors() throws ParseException {
		DateTime dt = new DateTime(TZ_GERMANY);
		DateTime dtMsecs = new DateTime(dt.getAsMSecs(), TZ_GERMANY);
		
		assertEquals(
			dt.getAsStr(TZ_UTC, DateTime.STD_DATE_TIME_FORMAT), 
			dtMsecs.getAsStr(TZ_UTC, DateTime.STD_DATE_TIME_FORMAT));
		
		assertEquals(
			dt.getAsStr(TZ_GERMANY, DateTime.STD_DATE_TIME_FORMAT), 
			dtMsecs.getAsStr(TZ_GERMANY, DateTime.STD_DATE_TIME_FORMAT));
		
		DateTime dtGermany = new DateTime("2011-10-30 03:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_GERMANY);
		String dtCanadaStr = dtGermany.getAsStr(TZ_CANADA, DateTime.STD_DATE_TIME_FORMAT);
		assertEquals("2011-10-29 21:14:15", dtCanadaStr);
		DateTime dtCanada = new DateTime(dtCanadaStr, 
			DateTime.STD_DATE_TIME_FORMAT, TZ_CANADA);
		assertEquals("2011-10-30 03:14:15",
			dtCanada.getAsStr(TZ_GERMANY, DateTime.STD_DATE_TIME_FORMAT));
	}
	
	public void testDateTimeStruct() throws ParseException {
		DateTime dt = new DateTime("2011-10-30 03:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_GERMANY);
		DateTimeStruct struct = dt.getDateTimeStruct(TZ_GERMANY);
		assertEquals(2011, struct.year);
		assertEquals(10, struct.month);
		assertEquals(30, struct.day);
		assertEquals(3, struct.hour);
		assertEquals(14, struct.minute);
		assertEquals(15, struct.second);
		assertEquals(0, struct.millisecond);
		assertEquals(TZ_GERMANY.getID(), struct.timeZoneId);
	}
	
	public void testDateTimeDayBased() throws ParseException {
		DateTime dt = new DateTime("2011-10-30 00:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_GERMANY);		
		
		String dayBegin = dt.getAsDayBasedStr(
			TZ_GERMANY, true, DateTime.STD_DATE_TIME_FORMAT);		
		assertEquals("2011-10-30 00:00:00", dayBegin);
		
		String dayEnd = dt.getAsDayBasedStr(
			TZ_GERMANY, false, DateTime.STD_DATE_TIME_FORMAT);		
		assertEquals("2011-10-30 23:59:59", dayEnd);	
		
		dt = new DateTime("2011-10-30 00:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_UTC);		
			
		dayBegin = dt.getAsDayBasedStr(
			TZ_CANADA, true, DateTime.STD_DATE_TIME_FORMAT);		
		assertEquals("2011-10-29 00:00:00", dayBegin);
			
		dayEnd = dt.getAsDayBasedStr(
			TZ_CANADA, false, DateTime.STD_DATE_TIME_FORMAT);		
		assertEquals("2011-10-29 23:59:59", dayEnd);
		
		dt = new DateTime("2011-10-30 00:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_GERMANY);	
		dt = DateTime.getAsDayBased(dt, TZ_GERMANY, true);
		assertEquals("2011-10-30 00:00:00", 
			dt.getAsStr(TZ_GERMANY, DateTime.STD_DATE_TIME_FORMAT));
		assertEquals("2011-10-29 22:00:00", 
			dt.getAsStr(TZ_UTC, DateTime.STD_DATE_TIME_FORMAT));
		
		dt = new DateTime("2011-10-30 00:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_GERMANY);	
		dt = DateTime.getAsDayBased(dt, TZ_GERMANY, false);
		assertEquals("2011-10-30 23:59:59", 
			dt.getAsStr(TZ_GERMANY, DateTime.STD_DATE_TIME_FORMAT));
		assertEquals("2011-10-30 22:59:59", 
			dt.getAsStr(TZ_UTC, DateTime.STD_DATE_TIME_FORMAT));
	}
	
	public void testInDaylightTime() throws ParseException {
		DateTime dt = new DateTime("2011-07-30 00:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_GERMANY);
		assertTrue(dt.inDaylightTime(TZ_GERMANY));
		dt = new DateTime("2011-11-30 00:14:15", 
			DateTime.STD_DATE_TIME_FORMAT, TZ_GERMANY);
		assertFalse(dt.inDaylightTime(TZ_GERMANY));		
	}
}
