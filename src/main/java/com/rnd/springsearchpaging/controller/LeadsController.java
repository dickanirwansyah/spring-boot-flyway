package com.rnd.springsearchpaging.controller;

import com.rnd.springsearchpaging.entity.Leads;
import com.rnd.springsearchpaging.repository.LeadsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/leads")
public class LeadsController {

    private static final Logger log = LoggerFactory.getLogger(LeadsController.class);

    @Autowired
    private LeadsRepository leadsRepository;

    @GetMapping
    public List<Leads> listLeads(){
       return leadsRepository.findAll();
    }

    @GetMapping(value = "/by")
    public List<Leads> listLeadsByFirstname1(@RequestParam("firstname")String firstname){
        return leadsRepository.findLeadsByFirstname(firstname);
    }

    @GetMapping(value = "/yb")
    public List<Leads> listLeadsByFirstname2(@RequestParam("firstname")Optional<String> firstname){
        return leadsRepository.findLeadsByFirstname(firstname.orElse("_"));
    }

    @GetMapping(value = "/yy")
    public Page<Leads> listLeadsByFirstname3(@RequestParam("firstname")Optional<String> firstname){
        return leadsRepository.findDataLeadsByFirstname(firstname.orElse("_"),
                new PageRequest(0, 3));
    }

    @GetMapping(value = "/bb")
    public Page<Leads> listLeadsByFirstname4(@RequestParam("firstname")Optional<String>firstname,
                                             @RequestParam("page")Optional<Integer>page,
                                             @RequestParam("sort")Optional<String>sortBy){

        return leadsRepository.findDataLeadsByFirstname(firstname.orElse("_"),
                new PageRequest(page.orElse(0), 5, Sort.Direction.ASC, sortBy.orElse("id")));
    }
}

