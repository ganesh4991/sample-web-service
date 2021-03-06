package com.sample.controller;

import com.sample.models.model.UniversityInfo;
import com.sample.models.model.UniversityInfoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by ganeshramiyer on 10/12/16.
 */

@Controller
public class UniversityController {

    @Autowired
    UniversityInfoRepository universityInfoRepository;

    Logger logger = Logger.getLogger(UniversityController.class);

    @RequestMapping(value = "/adduniversity", method = RequestMethod.GET)
    @ResponseBody
    public String addUniversity() {
        UniversityInfo testUniv = new UniversityInfo();
        testUniv.setId();
        testUniv.setUniversityName("IU");
        testUniv.setDepartmentInfo("SOIC");
        universityInfoRepository.save(testUniv);
        return "University Added";
    }

    @RequestMapping(value = "/getuniversities", method = RequestMethod.GET)
    @ResponseBody
    public List<UniversityInfo> getUniversities() {
        List<UniversityInfo> universityInfoList = universityInfoRepository.findAll();
        return universityInfoList;
    }

    @RequestMapping(value = "/getdept", method = RequestMethod.GET)
    @ResponseBody
    public List<UniversityInfo> getUniversityDepts(@RequestParam("univName") String univName) {
        logger.info(univName);
        List<UniversityInfo> universityInfoList = universityInfoRepository.findByUniversityName(univName);
        return universityInfoList;
    }
}
