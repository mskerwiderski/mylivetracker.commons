package de.msk.mylivetracker.commons;

import junit.framework.TestCase;
import de.msk.mylivetracker.commons.util.gps.LatLonUtils;
import de.msk.mylivetracker.commons.util.gps.LatLonUtils.PosType;

/**
 * classname: TestLatLonUtils
 * 
 * @author michael skerwiderski, (c)2012
 * @version 000
 * @since 1.5.0
 * 
 * history:
 * 000	2013-01-02	initial.
 * 
 */
public class TestLatLonUtils extends TestCase {

	private static final double[][] TEST_POSITIONS = new double[][] {
		{  48.136294,  11.594428 }, // Bayerischer Landtag, Munich
		{  40.727031, -73.997984 }, // Silver Towers, New York
		{ -37.845969, 144.963698 }, // Albert Park, Melbourne
		{ -34.639087, -58.406668 }, // Parque de Los Patricios, Buenos Aires
		{  52.237670,   0.914090 }, // Crown Mill, East of Bury St Edmunds
		{  51.480207,  -0.005836 }, // National Mantime Museum, Greenwich
		{   0.043538,  18.254369 }, // Mbandaka, Kongo
		{  -0.040194,  18.354071 }, // Equateur, Kongo
	};
		
	private static final String[] NMEA0183_STRS = new String[] {
		"Munich=4808.1776,N,01135.6657,E",
		"New York=4043.6219,N,07359.8790,W",
		"Melbourne=3750.7581,S,14457.8219,E",
		"Buenos Aires=3438.3452,S,05824.4001,W",
		"Crown Mill=5214.2602,N,00054.8454,E",
		"Greenwich=5128.8124,N,00000.3502,W",
		"Mbandaka=0002.6123,N,01815.2621,E",
		"Equateur=0002.4116,S,01821.2443,E",
	};
	
	public static class Nmea0183PositionDsc {
		private String name;
		private String nmea0183Lat;
		private String nmea0183Lon;
		public Nmea0183PositionDsc(String name, double lat, double lon) {
			this.name = name;
			this.nmea0183Lat = LatLonUtils.decToWgs84(lat, PosType.Latitude).toNmea0183String();
			this.nmea0183Lon = LatLonUtils.decToWgs84(lon, PosType.Longitude).toNmea0183String();
		}
		@Override
		public String toString() {
			System.out.println(this.name + "=" + 
				nmea0183Lat + "," + nmea0183Lon);
			return this.name + "=" + 
				nmea0183Lat + "," + nmea0183Lon;
		}
	}
	
	public static void main(String[] argv) {
		TestLatLonUtils test = new TestLatLonUtils();
		test.testLatLonUtils();
	}
	
	public void testLatLonUtils() {
		Nmea0183PositionDsc nmea0183Munich = 
			new Nmea0183PositionDsc("Munich", TEST_POSITIONS[0][0], TEST_POSITIONS[0][1]);
		Nmea0183PositionDsc nmea0183NewYork = 
			new Nmea0183PositionDsc("New York", TEST_POSITIONS[1][0], TEST_POSITIONS[1][1]);
		Nmea0183PositionDsc nmea0183Melbourne = 
			new Nmea0183PositionDsc("Melbourne", TEST_POSITIONS[2][0], TEST_POSITIONS[2][1]);
		Nmea0183PositionDsc nmea0183BuenosAires = 
			new Nmea0183PositionDsc("Buenos Aires", TEST_POSITIONS[3][0], TEST_POSITIONS[3][1]);
		Nmea0183PositionDsc nmea0183CrownMill = 
			new Nmea0183PositionDsc("Crown Mill", TEST_POSITIONS[4][0], TEST_POSITIONS[4][1]);
		Nmea0183PositionDsc nmea0183Greenwich = 
			new Nmea0183PositionDsc("Greenwich", TEST_POSITIONS[5][0], TEST_POSITIONS[5][1]);
		Nmea0183PositionDsc nmea0183Mbandaka = 
			new Nmea0183PositionDsc("Mbandaka", TEST_POSITIONS[6][0], TEST_POSITIONS[6][1]);
		Nmea0183PositionDsc nmea0183Equateur = 
			new Nmea0183PositionDsc("Equateur", TEST_POSITIONS[7][0], TEST_POSITIONS[7][1]);
		assertNotSame(NMEA0183_STRS[0], nmea0183Munich);
		assertNotSame(NMEA0183_STRS[1], nmea0183NewYork);
		assertNotSame(NMEA0183_STRS[2], nmea0183Melbourne);
		assertNotSame(NMEA0183_STRS[3], nmea0183BuenosAires);
		assertNotSame(NMEA0183_STRS[4], nmea0183CrownMill);
		assertNotSame(NMEA0183_STRS[5], nmea0183Greenwich);
		assertNotSame(NMEA0183_STRS[6], nmea0183Mbandaka);
		assertNotSame(NMEA0183_STRS[7], nmea0183Equateur);
	}
	
	
}
