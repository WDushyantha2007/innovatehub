package com.innovatehub.login.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserJdbcRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findUserById(int userId) {
        User user = new User();
        String sql = "select UserID,Password,roleId from user";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            user.setUserId((Integer) row.get("UserID"));
            user.setbCryptPassword((String) row.get("Password"));
            user.setRoleId((Integer) row.get("roleId"));
        }

        return user;
    }
}
