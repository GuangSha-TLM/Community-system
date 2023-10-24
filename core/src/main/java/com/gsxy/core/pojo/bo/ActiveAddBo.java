package com.gsxy.core.pojo.bo;

import com.gsxy.core.pojo.Activity;
import java.io.Serializable;

public class ActiveAddBo implements Serializable {

    private String token;
    private Activity activity;

    public ActiveAddBo(String token, Activity activity) {
        this.token = token;
        this.activity = activity;
    }

    public ActiveAddBo() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "ActivityAddBo{" +
                "token='" + token + '\'' +
                ", activity=" + activity +
                '}';
    }
}
