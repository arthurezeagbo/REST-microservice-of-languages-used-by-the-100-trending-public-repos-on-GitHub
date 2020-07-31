package com.arthurezeagbo.repodataservice.services;

import com.arthurezeagbo.repodataservice.models.Base;
import com.arthurezeagbo.repodataservice.models.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class RepoServiceImpl implements IRepoService {

    final WebClient webClient;

    public RepoServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Flux<Item> fetchRepositories() {

        String githubUrl = "https://api.github.com/search/repositories?q=created:>"+getDateOfPast30Days()+"&sort=stars&order=desc";

        Flux<Item> data = webClient
                .get()
                .uri(githubUrl)
                .retrieve()
                .bodyToFlux(Base.class)
                .flatMap(
                        item -> {
                            return Flux.just(item.getItems());
                        }
                )
                .take(100);

        return data;
    }

    public String getDateOfPast30Days() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(cal.getTime());

        return dateString;
    }

}
