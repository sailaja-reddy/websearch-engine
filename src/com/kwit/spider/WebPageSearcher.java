package com.kwit.spider;

/**
 * WebPageXtractor - extracts information from a WebPage passed as an input
 * stream. 
 * <li>Makes use of SimpleHTMLParser object. 
 * <li>Used to use HTMLEditorKit and HTMLEditorKit Parser. 
 * <li>This turned out to be too buggy for this application.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class WebPageSearcher extends Parser
{
	private ArrayList links;
	private ArrayList images;
	private ArrayList title;
	private boolean inTitle;

	/** Constructor */
	public WebPageSearcher()
	{
		super();
		links = new ArrayList();
		images = new ArrayList();
		title = new ArrayList();
	}

	// Utility method for extracting href attribute
	private String extractHref(String tag)
	{
		String delims = "\t\r\f\n \'\"=";
		StringTokenizer tt = new StringTokenizer(tag, delims);
		while (tt.hasMoreElements())
		{
			String s = tt.nextToken();
			if (s.equalsIgnoreCase("href"))
			{
				if (!tt.hasMoreElements())
					return (null);
				else
					return (tt.nextToken());
			}
		}
		return (null);
	}

	// Utility method for extracting src attribute
	private String extractSrc(String tag)
	{
		String delims = "\t\r\f\n \'\"=";
		StringTokenizer tt = new StringTokenizer(tag, delims);
		while (tt.hasMoreElements())
		{
			String s = tt.nextToken();
			if (s.equalsIgnoreCase("src"))
			{
				if (!tt.hasMoreElements())
					return (null);
				else
					return (tt.nextToken());
			}
		}
		return (null);
	}

	/**
	 * Returns the images.
	 * 
	 * @return ArrayList
	 */
	public ArrayList getImages()
	{
		return images;
	}

	/**
	 * Returns the links.
	 * 
	 * @return ArrayList
	 */
	public ArrayList getLinks()
	{
		return links;
	}

	/**
	 * Returns the title.
	 * 
	 * @return ArrayList
	 */
	public ArrayList getTitle()
	{
		return title;
	}

	/**
	 * If we're within TITLE tags - save the title
	 * 
	 * @see Parser#processContent(Tokenizer)
	 */
	public void processContent(Tokenizer token)
	{
		String s = token.getContent().trim();
		if (s != null && s.length() != 0)
		{
			if (inTitle)
				title.add(s);
		}
	}

	/**
	 * Look for </title> tags
	 * 
	 * @see Parser#processEndTag(Tokenizer)
	 */
	public void processEndTag(Tokenizer token) throws IOException
	{
		String tag = Parser.getTagType(token, true);
		if (tag == null)
			throw new IOException("HTML parsing error");
		else if (tag.equals("title"))
			inTitle = false;
	}

	/**
	 * Handle Anchor, Image, Frame, and Title tags
	 * 
	 * @see Parser#processTag(Tokenizer)
	 */
	public void processTag(Tokenizer token) throws IOException
	{
		String tag = Parser.getTagType(token, true);
		if (tag == null)
			throw new IOException("HTML parsing error");
		else if (tag.equals("a"))
		{
			String link = extractHref(token.getContent());
			if (link != null)
				links.add(link);
		}
		else if (tag.equals("img"))
		{
			String image = extractSrc(token.getContent());
			if (image != null)
				images.add(image);
		}
		else if (tag.equals("frame"))
		{
			String link = extractSrc(token.getContent());
			if (link != null)
				links.add(link);
		}
		else if (tag.equals("title"))
			inTitle = true;
	}
}
