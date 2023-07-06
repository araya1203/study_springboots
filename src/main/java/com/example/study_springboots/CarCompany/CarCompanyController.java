package com.example.study_springboots.CarCompany;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboots.CarCompany.CarcompanyService;

@RestController
public class CarCompanyController{
    @Autowired
    CarCompanyService CarCompanyService;
    
    // /companyselectSearch/COMPANY/기아자동차
    @GetMapping("/companyselectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search, @PathVariable String words) {
        Object result = CarcompanyService.selectSearch(search, words);
        return ResponseEntity.ok().body(result);
    }
    


    @GetMapping("/companyselectAll/{COMPANY}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = CarcompanyService.selectAll(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // /selectDetail/CI002
    @GetMapping("/companyselectDetail/{COMPANY}")
    public ResponseEntity selectdetail(@PathVariable String COMPANY_ID) {
        Object result = CarcompanyService.selectDetail(COMPANY_ID);
        return ResponseEntity.ok().body(result);
    }


    // create
    @PostMapping("/companyinsert")
    public ResponseEntity companyinsert(@RequestBody Map paramMap) {
        Object result = CarcompanyService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }


     // delete
    @DeleteMapping("/companydelete/{COMPANY}")
    public ResponseEntity delete(@PathVariable String COMPANY) {
        Object result = CarcompanyService.delete(COMPANY);
        return ResponseEntity.ok().body(result);
    }


    // update
    @PutMapping("/companyupdate")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = CarcompanyService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

   
     //2PC create
    @PostMapping("/companyinsertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap){
        Object result = null;
        try {
            result = CarCompanyService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
       
        return ResponseEntity.ok().body(result);
}





}

    