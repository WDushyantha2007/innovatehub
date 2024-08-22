package com.innovatehub.user.validator;

import ch.qos.logback.core.util.StringUtil;
import com.innovatehub.user.dao.Member;

public class UserValidator {

    public UserValidator() {

    }

    /**
     * Validate the member as valid or not.
     * @param member
     * @return Return member as valid or not.
     */
    public boolean isValid(Member member) {
        if (StringUtil.isNullOrEmpty(member.getMemberName())) {
            return false;
        }
        return true;
    }

}
