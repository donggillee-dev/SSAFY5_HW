package com.ssafy.hw10.step3;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO {
	List<News> list = new ArrayList<>();
	
	@Override
	public List<News> getNewsList(String url) {
		list.removeAll(list);
		connectNews(url);
		return null;
	}

	private void connectNews(String url) {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = f.newDocumentBuilder();
			Document dom = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = dom.getDocumentElement();
			NodeList n = root.getElementsByTagName("item");

			for (int i = 0; i < n.getLength(); i++) {
				News w = new News();
				Node item = n.item(i);
				NodeList kids = item.getChildNodes();
				for (int j = 0; j < kids.getLength(); j++) {
					Node kid = kids.item(j);
					String name = kid.getNodeName();
					if (name.equalsIgnoreCase("title")) {
						w.setTitle(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("description")) {
						w.setDesc(kid.getFirstChild().getNodeValue());
					} else if (name.equalsIgnoreCase("link")) {
						w.setLink(kid.getFirstChild().getNodeValue());
					}
				}
				System.out.println(w);
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}
	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
