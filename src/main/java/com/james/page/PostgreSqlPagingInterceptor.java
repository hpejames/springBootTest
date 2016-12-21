package com.james.page;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;

@Intercepts(@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})) 
public class PostgreSqlPagingInterceptor extends AbstractPagingInterceptor {

    @Override
    protected String getSelectTotalSql(String targetSql) {
        String sql = targetSql.toLowerCase();
        StringBuilder sqlBuilder = new StringBuilder(sql);
        
        int orderByPos = 0;
        if((orderByPos = sqlBuilder.lastIndexOf(ORDER_BY)) != -1) {
            sqlBuilder.delete(orderByPos, sqlBuilder.length());
        }
        sqlBuilder.insert(0, "select count(1) as _count from ( ").append(" ) as page_temp");
        
        return sqlBuilder.toString();
    }

    @Override
    protected String getSelectPagingSql(String targetSql, PagingBounds<?> bounds) {
        String sql = targetSql.toLowerCase();
        StringBuilder sqlBuilder = new StringBuilder(sql);
        
//        sqlBuilder.append(" LIMIT ").append(bounds.getLimit()).append(" OFFSET ").append(bounds.getOffset());

        return sqlBuilder.toString();
    }
}