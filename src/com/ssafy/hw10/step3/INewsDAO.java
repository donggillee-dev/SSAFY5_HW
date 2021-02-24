package com.ssafy.hw10.step3;

import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url);
	News search(int index);
}