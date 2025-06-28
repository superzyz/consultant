package com.heima.consultant.aiservice;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",//指定模型
        streamingChatModel = "openAiStreamingChatModel",
        chatMemory = "chatMemory"//配置会话记忆对象
)
//@AiService
public interface ConsultantService {

    //用于聊天的方法
    //@SystemMessage("你是纵咏钊的狗，只爱纵咏钊")
    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(String message);
}
