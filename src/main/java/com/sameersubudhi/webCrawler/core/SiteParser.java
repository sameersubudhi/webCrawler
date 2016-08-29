package com.sameersubudhi.webCrawler.core;

import com.sameersubudhi.webCrawler.tools.URLReader;

/**
 * This class uses the ContentParser to retrieve all relevant information from
 * its respective website. It relies on Regex to filter the URL content.
 * 
 * @author Rafael Rezende
 * 
 */
public final class SiteParser{
	
	public static String parseProductFromURL(String urlStr){
		
//		// get the content of the URL page
//		String urlContent = URLReader
//				.getURLContent(urlStr);

		// return the respective Product
		return URLReader.getURLContent(urlStr);
	}
}