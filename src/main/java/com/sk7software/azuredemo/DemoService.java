package com.sk7software.azuredemo;

import com.sk7software.azuredemo.model.JourneyStep;
import com.sk7software.azuredemo.model.SessionStatus;
import com.sk7software.azuredemo.model.UpdateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

@RestController
public class DemoService {
    @Autowired
    SessionDataStore sessionData;

    @GetMapping("/demo")
    public String getDemo() {
        return "Hello World";
    }

    @GetMapping("/name/{name}")
    public String getName(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping("/notify/{id}")
    public String postStatus(@PathVariable String id,
                              @RequestBody SessionStatus status) {
        System.out.println("User: " + id);
        System.out.println("Screen: " + status.getScreenId());
        System.out.println("Screen dimensions: " + status.getWid() + ", " + status.getHt());
        System.out.println("Last action: " + status.getLastAction());
        sessionData.addSessionData(id, "screenId", status.getScreenId());
        sessionData.addSessionData(id, "screenWid", status.getWid());
        sessionData.addSessionData(id, "screenHt", status.getHt());
        sessionData.addSessionData(id, "lastAction", status.getLastAction());
        return id;
    }

    @GetMapping("/status/{id}")
    public Map<String, Object> getStatus(@PathVariable String id) {
        return sessionData.getSessionData(id);
    }

    @PutMapping("/update/{id}")
    public Integer putUpdate(@PathVariable String id,
            @RequestBody UpdateInfo info) {
        sessionData.addSessionData(id, info.getKey(), info.getValue());
        return 0;
    }

    @PostMapping("/journey/{id}")
    public Integer postJourneySteps(@PathVariable String id,
                                    @RequestBody List<JourneyStep> steps) {
        sessionData.addSessionData(id, "steps", steps);
        return 0;
    }

    @GetMapping("/journey/{id}")
    public List<JourneyStep> getSteps(@PathVariable String id) {
        return (List<JourneyStep>)sessionData.getSessionData(id).get("steps");
    }
}
