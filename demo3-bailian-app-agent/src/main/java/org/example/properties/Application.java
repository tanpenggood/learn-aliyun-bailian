package org.example.properties;

import lombok.Data;

@Data
public class Application {

    private String name;
    private String appId;
    /**
     * 智能体应用
     * 工作流应用
     * 智能体编排应用
     */
    private String appType;
    private String baseUrl;

}
