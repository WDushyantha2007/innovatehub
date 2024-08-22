package com.innovatehub.cache.APIAuthorizeCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APICacheManager {

    private static HashMap<Integer, List<String>> apiAccessMap = null;

    private static HashMap<String, Integer> tokenPrev = new HashMap<>();

    /**
     * Create role cache with url patterns.
     * @return
     */
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

    /**
     * Find for the given token mapping role id.
     * The check given role has api access.
     * @param tokenID
     * @param api
     * @return
     */
    public static boolean findRoleHasAPIAcesss(String tokenID, String api) {
        int roleId = tokenPrev.get(tokenID) == null ? 0 : tokenPrev.get(tokenID);
        return roleId == 0 ? false : getRoleApiMap().get(roleId).contains(api);
    }

    /**
     * Map given token to the role id.
     * @param tokenID Security token ID.
     * @param roleId
     */
    public static synchronized void addTokenPrevilages(String tokenID, int roleId) {
        tokenPrev.put(tokenID, roleId);
    }

    /**
     * Clear tokenPrev token role mapping cache.
     */
    public static void clearCache() {
        tokenPrev.clear();
    }

    /**
     * Check particular token exists in token role mapping cache(tokenPrev).
     * @param tokenID
     * @return
     */
    public boolean containsToken(String tokenID) {
        return tokenPrev.containsKey(tokenID);
    }

}
