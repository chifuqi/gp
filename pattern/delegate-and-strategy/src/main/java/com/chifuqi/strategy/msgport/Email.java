package com.chifuqi.strategy.msgport;

import com.chifuqi.strategy.IMessage;

/**
 * @ClassName Email
 * @Description TODO
 * @Author Chi.FQ
 * @Date 2019/6/9 21:23
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class Email implements IMessage {

    @Override
    public int send(String uid, String msg) {
        System.out.println("email 发送信息：" + msg);
        return 1;
    }
}
