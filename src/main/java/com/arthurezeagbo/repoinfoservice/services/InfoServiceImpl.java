package com.arthurezeagbo.repoinfoservice.services;

import com.arthurezeagbo.repoinfoservice.models.Item;
import com.arthurezeagbo.repoinfoservice.models.LanguageDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InfoServiceImpl implements IInfoService {

    final WebClient webClient;

    public InfoServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    private Flux<Item> getRepositoryData(){

        return webClient
                .get()
                .uri("http://localhost:8081/api/v1/repo/getall")
                .retrieve()
                .bodyToFlux(Item.class);
    }

    private List<Item> getListOfRepositoryItems(Flux<Item> items){

        //remove items that have null value from the data and return a list of items
        return
                items
                .collect(Collectors.toList())
                .block()
                .stream()
                .filter(c -> c.getLanguage() != null)
                .collect(Collectors.toList());
    }

    private Map<String,List<Item>> groupRepositoryItems(List<Item> items){

        //group the repositories by language
        Map<String,List<Item>> listMap = items.stream()
                                        .collect(
                                                Collectors.toMap(
                                                        Item::getLanguage,
                                                        x -> {
                                                            List<Item> list = new ArrayList<>();
                                                            list.add(x);
                                                            return list;
                                                        },
                                                        (left, right) -> {
                                                            left.addAll(right);
                                                            return left;
                                                        },
                                                        HashMap::new
                                                )
                                        );

        return listMap.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue)
                );
    }

    private List<LanguageDetail> getLanguageDetails(Map<String,List<Item>> itemsMap,List<Item> data){

        //return a grouped list having languges,total count of languages,
        // and list of repositories for the language

        return itemsMap.entrySet()
                .stream()
                .map(
                        p -> new LanguageDetail(
                                p.getKey()
                                ,p.getValue().stream().collect(Collectors.counting()).intValue()
                                ,p.getValue()
                        )
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<LanguageDetail> getLanguageInformation() {

        Flux<Item> repoData = getRepositoryData();
        List<Item> itemsList =  getListOfRepositoryItems(repoData);

        Map<String,List<Item>> groupedItems = groupRepositoryItems(itemsList);
        List<LanguageDetail> languageDetails = getLanguageDetails(groupedItems, itemsList);

        return languageDetails;
    }
}
