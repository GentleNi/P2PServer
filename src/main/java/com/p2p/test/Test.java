package com.p2p.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p2p.common.Const;
import com.p2p.entity.BaseRequest;
import com.p2p.entity.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Map<String,String> infoMap = new HashMap<String,String>();
        infoMap.put("name","jack");
        infoMap.put("age","11");
        infoMap.put("work","cleaner");
        BaseRequest<Map<String,String>> request = BaseRequest.createRequest(Const.Type.LOGIN, Const.Request.LOGIN,infoMap);
        ObjectMapper mapper = new ObjectMapper();
        String jasonString = mapper.writeValueAsString(request);
        System.out.println(jasonString);

        BaseRequest request1 = mapper.readValue(jasonString, new TypeReference<BaseRequest<Map<String, String>>>() {
        });

        System.out.println(request1.getType());
    }
}
