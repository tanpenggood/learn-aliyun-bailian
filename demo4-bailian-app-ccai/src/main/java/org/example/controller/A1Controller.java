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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class A1Controller {

    @GetMapping(value = "/ai/app/ccai/a1")
    public RunCompletionResponse a1(@RequestParam(value = "message", defaultValue = "很高兴见到你。") String message) throws Exception {
        log.info("start.");
        /*
            客服:请问您想咨询五险一金哪方面的问题呢？
            客户:我要查下账户，帮我查下，我有点看不懂现在的操作说明
            客服:请问您是在固定单位上班，还是自由工作者呢？
            客户:我有固定公司的，我在我公司里面，我在办公室里
            客服:请您提供一下个人信息，我这边核对一下，包括姓名、性别、年龄、社保卡号等信息，再帮您查询一下您的养老保险账户
            客户:嗯，张三、男、63岁、卡号啊，29230293xxxx，这是我的中信银行卡号啊。
            客服:请您稍等，正在为您查询，您好，您尾号789的社保卡养老保险余额是20680元，上个月15号您的当月养老保险缴纳金已到帐2000元
            客户:好
            客户:我自己怎么查我每个月有多少钱
            客服:您可以登录本市12345微信小程序，在首页可以看到五险一金入口，点击进入对应的养老保险、医疗保险等就能看到您的账户信息。
            客户:好好
            客户:谢谢
            客服:请问还有其他问题吗？
            客户:没了
            客服:好的
            客服:如果还有其他问题，欢迎您再次来电
            客户:嗯，拜拜
        */
        RunCompletionRequest.RunCompletionRequestDialogue dialogue = new RunCompletionRequest.RunCompletionRequestDialogue()
                .setSentences(Arrays.asList(
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("请问您想咨询五险一金哪方面的问题呢？"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("我要查下账户，帮我查下，我有点看不懂现在的操作说明"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("请问您是在固定单位上班，还是自由工作者呢？"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("我有固定公司的，我在我公司里面，我在办公室里"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("请您提供一下个人信息，我这边核对一下，包括姓名、性别、年龄、社保卡号等信息，再帮您查询一下您的养老保险账户"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("嗯，张三、男、63岁、卡号啊，29230293xxxx，这是我的中信银行卡号啊。"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("请您稍等，正在为您查询，您好，您尾号789的社保卡养老保险余额是20680元，上个月15号您的当月养老保险缴纳金已到帐2000元"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("好"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("我自己怎么查我每个月有多少钱"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("您可以登录本市12345微信小程序，在首页可以看到五险一金入口，点击进入对应的养老保险、医疗保险等就能看到您的账户信息。"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("好好"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("谢谢"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("请问还有其他问题吗？"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("没了"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("好的"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("agent").setText("如果还有其他问题，欢迎您再次来电"),
                        new RunCompletionRequest.RunCompletionRequestDialogueSentences().setRole("user").setText("嗯，拜拜")
                ));
        RunCompletionRequest runCompletionRequest = new RunCompletionRequest()
                .setDialogue(dialogue)
                .setTemplateIds(List.of(
                        1118L
                ));
        RuntimeOptions runtime = new RuntimeOptions();
        runtime.setConnectTimeout(Integer.MAX_VALUE);
        runtime.setReadTimeout(Integer.MAX_VALUE);
        Map<String, String> headers = new HashMap<>();
        try {
            // 复制代码运行请自行打印 API 的返回值
            Client client = ClientUtil.createClient();
            RunCompletionResponse response = client.runCompletionWithOptions("llm-g1ss1dpovtmdv36l", "b7d6b067590d4205b8a7a981dd25d26d",
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
