package com.amtf.demo.params;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties
@Getter
@Setter

public class F040001Params {
    /**
     * 页面id
     */
    private String IViewId;
}
