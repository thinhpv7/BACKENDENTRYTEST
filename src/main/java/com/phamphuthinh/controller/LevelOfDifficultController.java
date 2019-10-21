package com.phamphuthinh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phamphuthinh.entity.LevelOfDifficult;
import com.phamphuthinh.service.LevelOfDifficultService;

@RestController
public class LevelOfDifficultController{

	@Autowired
	LevelOfDifficultService levelOfDifficultService;
 
    @RequestMapping(value = "/levelofdifficult")
    public List<LevelOfDifficult> sample() {
        return levelOfDifficultService.getAll();
    }
 
    @RequestMapping(value = "/createlevelofdifficult", method = RequestMethod.POST)
    public LevelOfDifficult createSample(@Valid @RequestBody LevelOfDifficult level)
    {
        return levelOfDifficultService.createLevelOfDifficult(level);
    }
 
    @RequestMapping(value = "/deletelevelofdifficult/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") Integer id) 
    {
        return levelOfDifficultService.deleteLevelOfDifficult(id);
    }
 
    @RequestMapping(value = "/updatelevelofdifficult/{id}", method = RequestMethod.PUT)
    public LevelOfDifficult updateSample(@PathVariable(value = "id") Integer id, @Valid @RequestBody LevelOfDifficult level) 
    {
        return levelOfDifficultService.updateLevelOfDifficult(id, level);
    }
    
    @RequestMapping(value = "/levelofdifficultpage", method = RequestMethod.GET)
    public ResponseEntity<List<LevelOfDifficult>> getAllHocVien(
                        @RequestParam(defaultValue = "0") Integer pageNo,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "LEVELOFDIFFICULTID") String sortBy)
    {
        List<LevelOfDifficult> list = levelOfDifficultService.getLevelOfDifficultPage(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<List<LevelOfDifficult>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
