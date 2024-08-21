package com.innovatehub.cache.APIAuthorizeCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APICacheManager {

    private static HashMap<Integer, List<String>> apiAccessMap = null;

    private static HashMap<String, Integer> tokenPrev = new HashMap<>();

    public synchronized HashMap<Integer, List<String>> getRoleApiMap() {
        if(apiAccessMap == null) {
            apiAccessMap = new HashMap<>();
            List<String> apiList = new ArrayList<>();
            apiList.add("product");
            apiList.add("user");
            apiList.add("order");
            apiAccessMap.put(1, apiList);
        }
        return apiAccessMap;
    }

    public boolean findRoleHasAPIAcesss(int id, String api) {
        return this.getRoleApiMap().get(id).contains(api);
    }

    public static synchronized void addTokenPrevilages(String id, int roleId) {
        tokenPrev.put(id, roleId);
    }

    public boolean containsToken(String id) {
        return tokenPrev.containsKey(id);
    }

}
