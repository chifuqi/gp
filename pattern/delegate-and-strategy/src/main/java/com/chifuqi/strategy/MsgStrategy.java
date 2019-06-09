package com.chifuqi.strategy;

import  com.chifuqi.strategy.msgport.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MsgStrategy
 * @Description TODO
 * @Author Chi.FQ
 * @Date 2019/6/9 21:29
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class MsgStrategy {
    public static final String EMAIL = "EMAIL";
    public static final String SMS = "SMS";
    public static final String DEFAULT_MSG = SMS;

    private static Map<String, IMessage> msgStrategy = new HashMap<>();

    static {
        msgStrategy.put(EMAIL, new Email());
        msgStrategy.put(SMS, new SMS());
    }

    public static IMessage get(String msgKey){
        if(!msgStrategy.containsKey(msgKey)){
            return msgStrategy.get(DEFAULT_MSG);
        }
        return msgStrategy.get(msgKey);
    }
}
