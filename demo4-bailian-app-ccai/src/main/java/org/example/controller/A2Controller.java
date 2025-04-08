package org.example.controller;

import com.aliyun.contactcenterai20240603.Client;
import com.aliyun.contactcenterai20240603.models.RunCompletionRequest;
import com.aliyun.contactcenterai20240603.models.RunCompletionResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class A2Controller {

    @GetMapping(value = "/ai/app/ccai/a2")
    public RunCompletionResponse a2(@RequestParam(value = "message", defaultValue = "很高兴见到你。") String message) throws Exception {
        log.info("start.");
        RunCompletionRequest runCompletionRequest = new RunCompletionRequest()
                .setDialogue(ClientUtil.defaultDialogue())
                .setTemplateIds(List.of(
                        1120L
                ));
        RuntimeOptions runtime = new RuntimeOptions();
        runtime.setConnectTimeout(Integer.MAX_VALUE);
        runtime.setReadTimeout(Integer.MAX_VALUE);
        Map<String, String> headers = new HashMap<>();
        try {
            // 复制代码运行请自行打印 API 的返回值
            Client client = ClientUtil.createClient();
            RunCompletionResponse response = client.runCompletionWithOptions("llm-g1ss1dpovtmdv36l", "013437ac6f3949e9b82fc75f128ccb20",
                    runCompletionRequest, headers, runtime);
            log.info("finish.");
            return response;
        } catch (TeaException error) {
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 此处仅做打印展示，请谨慎对待异常处理，在工程项目中切勿直接忽略异常。
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            Common.assertAsString(error.message);
        }
        return null;
    }

}
