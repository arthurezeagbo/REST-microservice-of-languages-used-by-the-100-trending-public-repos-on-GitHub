package com.arthurezeagbo.repodataservice.services;

import com.arthurezeagbo.repodataservice.models.Base;
import com.arthurezeagbo.repodataservice.models.Item;
import reactor.core.publisher.Flux;

import java.util.List;

public interface IRepoService {

    public Flux<Item> fetchRepositories();

}
