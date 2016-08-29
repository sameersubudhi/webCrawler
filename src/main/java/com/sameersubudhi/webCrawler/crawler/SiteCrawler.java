package com.sameersubudhi.webCrawler.crawler;

import java.util.regex.Pattern;

import com.sameersubudhi.webCrawler.core.LinksList;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

public class SiteCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern.compile(
			".*(\\.(css|js|bmp|gif|jpe?g"
			+ "|png|tiff?|mid|mp2|mp3|mp4"
			+ "|wav|avi|mov|mpeg|ram|m4v|pdf"
			+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$"
		);
	
		/*
		 * (non-Javadoc) Limit the domain of search.
		 * @see edu.uci.ics.crawler4j.crawler.WebCrawler#shouldVisit(edu.uci.ics.crawler4j.url.WebURL)
		 */
		public boolean shouldVisit(WebURL url) {
			String href = url.getURL().toLowerCase();
			return !FILTERS.matcher(href).matches()	&& href.startsWith("http://wiprodigital.com/");
		}

		/*
		 * (non-Javadoc) Action to take when a page is visited.
		 * @see edu.uci.ics.crawler4j.crawler.WebCrawler#visit(edu.uci.ics.crawler4j.crawler.Page)
		 */
		@Override
		public void visit(Page page) {
			// get its own URL
			String url = page.getWebURL().getURL();
			System.out.println("Adding URL to list: " + url);

			// get the singleton instance of the ProductList
			LinksList pl = LinksList.getInstance();

			// store the url
			pl.put(url);
		}
}
