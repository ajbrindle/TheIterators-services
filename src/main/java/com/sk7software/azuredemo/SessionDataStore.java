package com.sk7software.azuredemo;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class SessionDataStore {
    private Map<String, Map<String, Object>> sessionData;

    public SessionDataStore() {
        sessionData = new HashMap<>();
    }

    public void addSessionData(String id, String key, Object value) {
        Map<String, Object> thisSession = sessionData.get(id);
        if (thisSession == null) {
            thisSession = new HashMap<>();
        }

        thisSession.put(key, value);
        sessionData.put(id, thisSession);
    }

    public Map<String, Object> getSessionData(String id) {
        if (sessionData.containsKey(id)) {
            return sessionData.get(id);
        } else {
            return Collections.emptyMap();
        }
    }
}
