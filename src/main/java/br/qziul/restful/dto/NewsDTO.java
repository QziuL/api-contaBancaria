package br.qziul.restful.dto;

import br.qziul.restful.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsDTO {
    private String icon;
    private String description;

    public List<News> convertToNews(List<NewsDTO> newsListDTO) {
        List<News> news = new ArrayList<>();
        for (NewsDTO newsDTO : newsListDTO) {
            news.add(new News(newsDTO.icon, newsDTO.description));
        }
        return news;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
