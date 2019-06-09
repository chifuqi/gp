package com.myself.chain;

/**
 * @ClassName Request
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/4 17:23
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/

public class Request {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
