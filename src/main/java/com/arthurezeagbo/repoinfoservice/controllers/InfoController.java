package com.arthurezeagbo.repoinfoservice.controllers;

import com.arthurezeagbo.repoinfoservice.models.Item;
import com.arthurezeagbo.repoinfoservice.models.LanguageDetail;
import com.arthurezeagbo.repoinfoservice.services.IInfoService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/info")
@RestController
public class InfoController {

    private final IInfoService _infoService;

    public InfoController(IInfoService _infoService) {
        this._infoService = _infoService;
    }

    @GetMapping("/getlanguages")
    public List<LanguageDetail> getRepoLanguagues() throws JsonProcessingException {

        return  _infoService.getLanguageInformation();
    }
}
