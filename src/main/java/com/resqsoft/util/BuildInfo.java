package com.resqsoft.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * Returns the information contained in a build's "build.properties" file.
 */
public final class BuildInfo extends Properties {

	private static final long serialVersionUID = 1L;

	protected static BuildInfo singleton;

	protected static boolean initialized = false;

	protected static InputStream inputStream;

	private String htmlTable;

	private static final Logger APP_LOG = Logger
			.getLogger(BuildInfo.class.getName());

	public static void init(InputStream stream) {

		inputStream = stream;
		if (inputStream == null) {
			APP_LOG.info("Build properties file not found.");
		}
	}

	private void renderHtmlTable() {

		String startLeftCell = "\t\t<tr> \n"
				+ "\t\t<td width=\"35%\" valign=\"top\">\n";
		String startRightCell = "\t</td> \n"
				+ "\t\t<td width=\"65%\" valign=\"top\">\n";
		String closeRow = "\t\t</td> \n" + "\t\t</tr>\n";

		StringBuffer buffer = new StringBuffer(1023);
		buffer.append("\t<table width=\"60%\" align=\"center\"  border=\"1\">"
				+ "\n");

		final Enumeration propertyNamesEnum = this.propertyNames();
		while (propertyNamesEnum.hasMoreElements()) {
			final String propertyName = (String) propertyNamesEnum
					.nextElement();
			final String propertyValue = this.getProperty(propertyName);

			buffer.append(startLeftCell + propertyName + "\n");
			buffer.append("\t" + startRightCell + propertyValue + "\n");
			buffer.append(closeRow);
		}

		buffer.append("\t</table>");
		htmlTable = buffer.toString();
	}

	public static synchronized BuildInfo getInstance() {
		if (!initialized) {
			singleton = new BuildInfo();
			if (inputStream != null) {
				try {
					singleton.load(inputStream);
					inputStream.close();
				} catch (IOException e) {
					APP_LOG.warn("Caught IOException: " + e
							+ " trying to open input stream " + inputStream);
				}
			}

			singleton.renderHtmlTable();
			initialized = true;

			APP_LOG.info("BuildInfo singleton instance created.");
		}

		return (singleton);
	}

	public String getHtmlTable() {

		return (htmlTable);
	}
	
	/**
	 * Convenience method to get the 
	 * version number from the buildinfo.properties file
	 * by the property name of project.version.
	 * 
	 * Arbitrary additional properties can be retrieved using
	 * the getProperty(<name>).
	 */
	public String getVersion() {
		return this.getProperty("project.version");
	}
	
	/**
	 * Convenience method to get the 
	 * Build ID from the buildinfo.properties file
	 * by the property name of build.id.
	 * 
	 * Arbitrary additional properties can be retrieved using
	 * the getProperty(<name>).
	 */
	public String getBuildId() {
		return this.getProperty("build.id");
	}
	
	/**
	 * Convenience method to get the 
	 * build date from the buildinfo.properties file
	 * by the property name of build.date.
	 * 
	 * Arbitrary additional properties can be retrieved using
	 * the getProperty(<name>).
	 */
	public String getBuildDate() {
		return this.getProperty("build.date");
	}

}
