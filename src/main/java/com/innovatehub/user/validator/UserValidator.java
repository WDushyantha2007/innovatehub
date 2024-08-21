package com.innovatehub.user.validator;

import ch.qos.logback.core.util.StringUtil;
import com.innovatehub.user.dao.Member;

public class UserValidator {

    public UserValidator() {

    }

    public boolean isValid(Member member) {
        if (StringUtil.isNullOrEmpty(member.getMemberName())) {
            return false;
        }
        return true;
    }

}
