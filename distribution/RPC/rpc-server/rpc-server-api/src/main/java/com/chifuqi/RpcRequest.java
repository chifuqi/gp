package com.chifuqi;

import java.io.Serializable;

/**
 * @ClassName RpcRequest
 * @Description TODO
 * @Author 郗富琦
 * @Date 2019/6/7 22:25
 * @Version 1.0
 * @copyright: Copyright(c) 2019 Uzone Co. Ltd. All rights resrved.
 **/
public class RpcRequest implements Serializable {
    private String className;
    private String mehtodName;
    private Object[] parameters;
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMehtodName() {
        return mehtodName;
    }

    public void setMehtodName(String mehtodName) {
        this.mehtodName = mehtodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
