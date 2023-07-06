package com.example.study_springboots.CarCompany;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboots.dao.SharedDao;

@Service        // service에서 transactional 씌어야 정확성을 유지해줌 
@Transactional // 데이터 보장을 해줌?
public class CarcompanyService{
    @Autowired
    SharedDao sharedDao;

     //검색(조건-search : YEAR, CAR_NAME)   
    public Object selectSearch(String search, String words) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectSearch";
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search); //화면을 만들지 않고 words 동일, 구분자로 구분하기 위함
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }


    public Object selectAll(String COMPANY) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectAll";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY", COMPANY);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(String COMPANY) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "CarCompany.selectByUID";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY", COMPANY);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }



    public Object insert(Map dataMap) {
        String sqlMapId = "CarCompany.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object update(Map dataMap) {
        String sqlMapId = "CarCompany.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

    public Object delete(String COMPANY) {
        String sqlMapId = "CarCompany.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY", COMPANY);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }


    public Object insertDouble(Map dataMap){
        String sqlMapId = "CarCompany.insert";
        Object result = sharedDao.insert(sqlMapId,dataMap);
        result = sharedDao.insert(sqlMapId,dataMap);

        return result;
    }



}



