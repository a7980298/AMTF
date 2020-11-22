package com.amtf.demo.params;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Getter
@Setter

public class F050001Params {
    /**
     * 页面id
     */
    private String IViewId;
}
