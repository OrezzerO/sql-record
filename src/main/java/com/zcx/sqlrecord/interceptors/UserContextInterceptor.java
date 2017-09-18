package com.zcx.sqlrecord.interceptors;

import com.zcx.sqlrecord.constant.SessionKeyConstants;
import com.zcx.sqlrecord.context.Constants;
import com.zcx.sqlrecord.context.ContextContainer;
import com.zcx.sqlrecord.entity.User;
import com.zcx.sqlrecord.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * Created by zhangchengxi on 2017/9/18.
 */
@Component
public class UserContextInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute(SessionKeyConstants.userId);

        if (Objects.nonNull(userId)) {
            User user = userRepository.findOne(userId);
            ContextContainer.getUserContext().setUser(user);
            return true;
        } else {
            response.sendRedirect(Constants.HOME_PAGE);
            return false;
        }
    }
}
