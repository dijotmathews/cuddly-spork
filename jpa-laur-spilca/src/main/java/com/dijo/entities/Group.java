package com.dijo.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "app_group")
public class Group {

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;


    @Column(name = "group_name")
    private String groupName;

    @ManyToMany
    @JoinTable(name = "app_users_app_groups", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
