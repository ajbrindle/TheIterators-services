package com.sk7software.azuredemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionStatus {
    private String screenId;
    private int wid;
    private int ht;
    private String lastAction;
}
