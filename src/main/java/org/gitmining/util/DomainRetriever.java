package org.gitmining.util;

public class DomainRetriever {
	public static String extractBlogDomain(String url){
		String[] items = url.split("\\.");
		String contain = items[0];
		if(items.length >=2) {
			contain = items[items.length-2];
		}
		
		String[] items2 = contain.split("/");
		return items2[items2.length-1];
	}

	public static String extractEmailDomain(String url){
		String[] items = url.split("\\.");
		String contain = items[0];
		if(items.length >=2) {
			contain = items[items.length-2];
		}
		String[] items2 = contain.split("@");
		return items2[items2.length-1];
	}
}
