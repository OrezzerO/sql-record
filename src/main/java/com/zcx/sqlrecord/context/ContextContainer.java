package com.zcx.sqlrecord.context;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
public class ContextContainer {

    private static ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    public static UserContext getUserContext() {
        if (userContext.get() == null) {
            userContext.set(new UserContext());
        }
        return userContext.get();
    }


    public static void setUserContext(UserContext context) {
        userContext.set(context);
    }


}
