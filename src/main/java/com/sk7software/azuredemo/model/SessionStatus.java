package com.sk7software.azuredemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionStatus {
    private String screenId;
    private int wid;
    private int ht;
    private String lastAction;
    private String name;
    private String deviceName;
    private String appVersion;
    private String os;
    private String loginDt;
    private String updateDt;
}
