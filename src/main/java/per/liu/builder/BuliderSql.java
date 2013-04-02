package per.liu.builder;

import static org.apache.ibatis.jdbc.SelectBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Created by IntelliJ IDEA.
 * User: liu
 * Date: 13-4-2
 * Time: 下午5:49
 */
public class BuliderSql {

    public String selectBlogsSql() {
        BEGIN(); // Clears ThreadLocal variable
        SELECT("*");
        FROM("user");
        return SQL();
    }

    public String deletePersonSql() {
        BEGIN(); // Clears ThreadLocal variable
        DELETE_FROM("PERSON");
        WHERE("ID = ${id}");
        return SQL();
    }


    public String insertPersonSql() {
        BEGIN(); // Clears ThreadLocal variable
        INSERT_INTO("PERSON");
        VALUES("ID, FIRST_NAME", "${id}, ${firstName}");
        VALUES("LAST_NAME", "${lastName}");
        return SQL();
    }

    public String updatePersonSql() {
        BEGIN(); // Clears ThreadLocal variable
        UPDATE("PERSON");
        SET("FIRST_NAME = ${firstName}");
        WHERE("ID = ${id}");
        return SQL();
    }

}
