package com.chifuqi.strategy;

/**
 * @ClassName MsgTest
 * @Description TODO
 * @Author Chi.FQ
 * @Date 2019/6/9 22:17
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class MsgTest {
    public static void main(String[] args) {
        Message msg = new Message("1", "发送通知信息");
        msg.send(MsgStrategy.SMS);
        msg.send(MsgStrategy.EMAIL);
    }
}
