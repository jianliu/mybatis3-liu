package per.liu.mapper;

import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.scripting.defaults.RawLanguageDriver;
import per.liu.pojo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: liu
 * Date: 13-4-2
 * Time: 下午2:33
 */
public interface UserMapper {
    //    对于简单语句来说,使用注解代码会更加清晰,然而 Java 注解对于复杂语句来说就会 混乱, 应该限制使用
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectOne(int id);

    /**
     * 不用同时在这里写sql，又在对应的mapper namespace上写sql，mybatis会放弃猜，直接抛错
     *
     * @return
     */
    List<User> getUsers();

    @Lang(RawLanguageDriver.class)
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectByRaw(int id);
}
