package org.example;

import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.properties.BailianEnglishTranslationApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class Demo3Application {

    private final BailianEnglishTranslationApplicationProperties bailianEnglishTranslationApplicationProperties;

    @GetMapping(value = "/ai/app/agent")
    public String aiAppAgent(@RequestParam(value = "message", defaultValue = "很高兴见到你。") String message) throws NoApiKeyException, InputRequiredException {
        ApplicationParam param = ApplicationParam.builder()
                // 若没有配置环境变量，可用百炼API Key将下行替换为：.apiKey("sk-xxx")。但不建议在生产环境中直接将API Key硬编码到代码中，以减少API Key泄露风险。
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .appId(bailianEnglishTranslationApplicationProperties.getAppId())
                .prompt(message)
                .build();
        // 配置私网终端节点
        Application application = new Application(bailianEnglishTranslationApplicationProperties.getBaseUrl());
        ApplicationResult result = application.call(param);

        log.info("text: {}", result.getOutput().getText());
        return result.getOutput().getText();
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

}