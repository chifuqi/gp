package com.chifuqi.strategy.msgport;

import com.chifuqi.strategy.IMessage;

/**
 * @ClassName SMS
 * @Description TODO
 * @Author Chi.FQ
 * @Date 2019/6/9 21:24
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class SMS implements IMessage {
    @Override
    public int send(String uid, String msg) {
        System.out.println("短信发送信息：" + msg);
        return 1;
    }
}
