package org.example.controller;

import com.aliyun.contactcenterai20240603.Client;
import com.aliyun.contactcenterai20240603.models.RunCompletionRequest;

import java.util.Arrays;

public class ClientUtil {

    /**
     * <b>description</b> :
     * <p>使用AK&amp;SK初始化账号Client</p>
     *
     * @return Client
     * @throws Exception
     */
    public static Client createClient() throws Exception {
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考。
        // 建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html。
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID。
                .setAccessKeyId(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"))
                // 必填，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
                .setAccessKeySecret(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
        // Endpoint 请参考 https://api.aliyun.com/product/ContactCenterAI
        config.endpoint = "contactcenterai.cn-shanghai.aliyuncs.com";
        return new Client(config);
    }

    public static RunCompletionRequest.RunCompletionRequestDialogue defaultDialogue() {
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
        return new RunCompletionRequest.RunCompletionRequestDialogue()
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
    }

}
