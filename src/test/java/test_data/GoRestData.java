package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestData {
    public Map<String,String> dataKeyMap(String name,String email,String gender,String status){
        Map<String,String> dataKeyMap = new HashMap<>();
        dataKeyMap.put("name", name);
        dataKeyMap.put("email", email);
        dataKeyMap.put("gender", gender);
        dataKeyMap.put("status", status);
       return dataKeyMap;
    }
public Map<String,Object> expectedDataMethod(Object meta,Map<String,String> data){
        Map<String,Object> expectedDataMethod = new HashMap<>();
        expectedDataMethod.put("meta", meta);
        expectedDataMethod.put("data", data);
        return expectedDataMethod;
}

}
/*
{
    "meta": null,
    "data": {
        "id": 2986,
        "name": "Navin Talwar",
        "email": "navin_talwar@mclaughlin.name",
        "gender": "male",
        "status": "inactive"
    }
 */