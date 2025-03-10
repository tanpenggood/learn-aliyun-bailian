# 阿里云灵积平台学习项目

这个项目是用于学习和探索阿里云百炼平台（Bailian）的示例项目。百炼平台是阿里云推出的大模型服务平台，提供了丰富的AI模型能力。

## 项目简介

本项目旨在展示如何使用阿里云灵积平台的各种功能，包括但不限于：

- 模型调用和接口对接
- 应用场景示例
- 最佳实践演示

## 环境要求

- Java 17
- Spring Boot 3.3.9
- DashScope 2.18.3
- 阿里云账号
- 百炼平台访问权限和相关密钥

## 项目结构

```
learn-aliyun-bailian/
├── demo1-bailian-llm             # 调用大模型（文本生成、视觉理解）
├── demo2-bailian-llm-stream      # 调用大模型（文本生成-流式输出）
├── demo3-bailian-app-agent       # 调用应用（智能体应用）
├── pom.xml
└── README.md
```

## 注意事项

- 请确保妥善保管您的阿里云访问密钥
- 使用前请仔细阅读灵积平台的服务条款和使用文档
- 注意遵守相关的使用限制和配额

## 贡献指南

欢迎提交 Issue 和 Pull Request 来帮助改进这个项目。

## 许可证

MIT License

## 相关资源

- [阿里云百炼平台官方文档](https://help.aliyun.com/document_detail/2399480.html)
- [API 参考](https://help.aliyun.com/document_detail/2400395.html) 
- [将API Key配置到环境变量](https://help.aliyun.com/zh/model-studio/developer-reference/configure-api-key-through-environment-variables)