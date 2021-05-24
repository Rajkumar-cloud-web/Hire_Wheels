package com.upgrad.hirewheels.entities;


import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    @Column( length = 50, nullable = false,unique = true)
    private String roleName;

    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    private Set<User> users;

    public Role() {
    }

    public Set<User> getUser() {
        return users;
    }

    public void setUser(Set<User> users) {
        this.users = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                // ", users=" + users +
                '}';
    }
}