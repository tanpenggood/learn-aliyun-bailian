package org.example;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;

@Slf4j
@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class Demo2Application {

    @GetMapping(value = "/ai/chat/stream", produces = "text/html;charset=UTF-8")
    public Flux<String> aiChatStream(@RequestParam(value = "message", defaultValue = "你是谁？") String message) throws NoApiKeyException, InputRequiredException {
        Generation gen = new Generation();
        Message userMsg = Message.builder().role(Role.USER.getValue()).content(message).build();
        GenerationParam param = GenerationParam.builder()
                // 若没有配置环境变量，请用百炼API Key将下行替换为：.apiKey("sk-xxx")
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .model("qwen-plus")   // 此处以qwen-plus为例，您可按需更换模型名称。模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
                .messages(Arrays.asList(userMsg))
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .incrementalOutput(true)
                .build();
        return Flux.from(gen.streamCall(param)
                .map(s -> s.getOutput())
                .map(s -> s.getChoices())
                .map(s -> s.get(0))
                .map(s -> s.getMessage())
                .map(s -> s.getContent()));
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}