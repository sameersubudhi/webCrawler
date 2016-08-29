package com.sameersubudhi.webCrawler;

import com.sameersubudhi.webCrawler.core.LinksList;
import com.sameersubudhi.webCrawler.core.SiteParser;
import com.sameersubudhi.webCrawler.crawler.CrawlerControl;

/**
 * This application contains a web crawler that fetches every link from a
 * reference website.
 * 
 * @author Sameer Subudhi
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// creation of the unique instance containing the list of links
		LinksList pList = LinksList.getInstance();

		// starts the web crawler in parallel
		CrawlerControl.startCrawler();
		
		// routine to consume the links from the list of links
		for (int counter = 0; counter < 10;) {
			String urlStr = pList.get();
			System.out.println(SiteParser.parseProductFromURL(urlStr));
		}
		
		// Print all the URLs collected by the crawler
		pList.printLinks();
		
		System.exit(0);
	}
}