package com.sk7software.azuredemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JourneyStep {
    private String target;
    private String placement;
    private String content;
    private boolean disableBeacon;
}
