package br.qziul.restful.dto;

import br.qziul.restful.model.*;

import java.util.List;

public class UserDTO {
    private String name;
    private AccountDTO account;
    private CardDTO card;
    private List<FeatureDTO> features;
    private List<NewsDTO> news;

    public User convertToUser() {
        FeatureDTO featureDTO = new FeatureDTO();
        NewsDTO newsDTO = new NewsDTO();
        return new User(
                this.name,
                this.account.convertToAccount(),
                this.card.convertToCard(),
                featureDTO.convertToFeature(this.features),
                newsDTO.convertToNews(this.news)
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public CardDTO getCard() {
        return card;
    }

    public void setCard(CardDTO card) {
        this.card = card;
    }

    public List<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureDTO> features) {
        this.features = features;
    }

    public List<NewsDTO> getNews() {
        return news;
    }

    public void setNews(List<NewsDTO> news) {
        this.news = news;
    }
}
