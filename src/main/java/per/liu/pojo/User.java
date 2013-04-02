package per.liu.pojo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: liu
 * Date: 13-4-2
 * Time: 下午2:34
 */
public class User {

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private String descn;
    private UserRole userRole;
    private List<RescRole> rescRoles;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<RescRole> getRescRoles() {
        return rescRoles;
    }

    public void setRescRoles(List<RescRole> rescRoles) {
        this.rescRoles = rescRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }
}
