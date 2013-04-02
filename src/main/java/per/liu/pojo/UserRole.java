package per.liu.pojo;

import org.apache.ibatis.type.Alias;

/**
 * Created by IntelliJ IDEA.
 * User: liu
 * Date: 13-4-2
 * Time: 下午4:14
 */

public class UserRole {
    private Long id;
    private Integer userId;
    private Integer roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public UserRole(Long id,Integer userId,Integer roleId){
        this.id=id;
        this.userId=userId;
        this.roleId=roleId;
    }
}
