package com.sda.spring.jdbctemplate.exceptions;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;

public class CustomSQLErrorCodeTranslator extends SQLErrorCodeSQLExceptionTranslator {

    @Override
    protected DataAccessException customTranslate(String task, String sql, SQLException sqlException) {
        if (sqlException.getErrorCode() == 23503) {
            return new DataIntegrityViolationException(
                    "Custom Exception translator - Integrity constraint violation.", sqlException);
        }
        return null;
    }
}

