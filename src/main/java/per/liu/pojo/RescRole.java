package per.liu.pojo;

import org.apache.ibatis.type.Alias;

/**
 * Created by IntelliJ IDEA.
 * User: liu
 * Date: 13-4-2
 * Time: 下午4:15
 */

public class RescRole {

    private Long id;
    private Integer rescId;
    private Integer roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRescId() {
        return rescId;
    }

    public void setRescId(Integer rescId) {
        this.rescId = rescId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
