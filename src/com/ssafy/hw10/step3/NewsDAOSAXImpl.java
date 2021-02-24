package com.ssafy.hw10.step3;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	List<News> list = new ArrayList<>();

	@Override
	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectNews(url);
		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private void connectNews(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb = new StringBuilder();
		boolean flag;
		News n;
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			super.characters(ch, start, length);
			sb.append(ch, start, length);
		}

		@Override
		public void startElement(String uri, String localName, String qname, Attributes attributes)
				throws SAXException {
			super.startElement(uri, localName, qname, attributes);
			if (qname.equalsIgnoreCase("item")) {
				n = new News();
			}
		}

		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			if (n != null) {
				if (name.equalsIgnoreCase("title")) {
					n.setTitle(sb.toString().trim());
				} else if (name.equalsIgnoreCase("description")) {
					n.setDesc(sb.toString().trim());
				} else if (name.equalsIgnoreCase("link")) {
					n.setLink(sb.toString().trim());
				} else if (name.equalsIgnoreCase("item")) {
					list.add(n);
				}
			}
			sb.setLength(0);
		}
	}
}
