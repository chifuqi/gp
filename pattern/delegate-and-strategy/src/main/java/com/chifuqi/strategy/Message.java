package com.chifuqi.strategy;

import com.chifuqi.strategy.IMessage;

/**
 * @ClassName Message
 * @Description TODO
 * @Author Chi.FQ
 * @Date 2019/6/9 21:45
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class Message {
    private String usrid;
    private String msg;

    public Message(String usrid, String msg) {
        this.usrid = usrid;
        this.msg = msg;
    }

    public int send(String msgKey){
        IMessage imsg = MsgStrategy.get(msgKey);
        return imsg.send(usrid, msg);
    }
}
