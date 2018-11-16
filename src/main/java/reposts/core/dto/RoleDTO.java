package reposts.core.dto;

import reposts.core.entities.User;

import java.util.List;

public class RoleDTO {

    private List<User> users;
    private String role;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
