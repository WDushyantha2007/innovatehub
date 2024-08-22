package com.innovatehub.cache.APIAuthorizeCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APICacheManager {

    private static HashMap<Integer, List<String>> apiAccessMap = null;

    private static HashMap<String, Integer> tokenPrev = new HashMap<>();

    public static synchronized HashMap<Integer, List<String>> getRoleApiMap() {
        if (apiAccessMap == null) {
            apiAccessMap = new HashMap<>();
            List<String> apiList = new ArrayList<>();
            apiList.add("product");
            apiList.add("user");
            apiList.add("order");
            apiAccessMap.put(1, apiList);
        }
        return apiAccessMap;
    }

    public static boolean findRoleHasAPIAcesss(String tokenID, String api) {
        int roleId = tokenPrev.get(tokenID) == null ? 0 : tokenPrev.get(tokenID);
        return roleId == 0 ? false : getRoleApiMap().get(roleId).contains(api);
    }

    public static synchronized void addTokenPrevilages(String id, int roleId) {
        tokenPrev.put(id, roleId);
    }

    public boolean containsToken(String id) {
        return tokenPrev.containsKey(id);
    }

}
