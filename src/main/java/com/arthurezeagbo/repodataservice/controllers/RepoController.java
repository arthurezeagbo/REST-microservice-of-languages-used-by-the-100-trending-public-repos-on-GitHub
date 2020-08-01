package com.arthurezeagbo.repodataservice.controllers;

import com.arthurezeagbo.repodataservice.models.Base;
import com.arthurezeagbo.repodataservice.models.Item;
import com.arthurezeagbo.repodataservice.services.IRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/repo")
@RestController
public class RepoController {

    private final IRepoService _repoService;

    public RepoController(IRepoService _repoService) {
        this._repoService = _repoService;
    }

    @GetMapping("/getall")

    public Flux<Item> getAllData(){

        Flux<Item> data = _repoService.fetchRepositories();

        return data;
    }
}
