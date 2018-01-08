package com.samuleev.server.controller;

import com.samuleev.remote.model.RemoteSearchCriteria;
import com.samuleev.remote.model.RemoteSearchResult;
import com.samuleev.server.controller.adapter.local.DocumentSearchCriteriaConverter;
import com.samuleev.server.controller.adapter.remote.RemoteSearchResultConverter;
import com.samuleev.server.model.DocumentSearchCriteria;
import com.samuleev.server.model.DocumentSearchResult;
import com.samuleev.server.service.SearchEngineFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchEngineFacade searchEngineFacade;

    @RequestMapping(method = RequestMethod.POST)
    public RemoteSearchResult getSearch(@RequestBody RemoteSearchCriteria remoteSearchCriteria) {
        DocumentSearchCriteria documentSearchCriteria
                = DocumentSearchCriteriaConverter.convert(remoteSearchCriteria);

        DocumentSearchResult documentSearchResult = searchEngineFacade.search(documentSearchCriteria);

        return RemoteSearchResultConverter.convert(documentSearchResult);
    }
}
