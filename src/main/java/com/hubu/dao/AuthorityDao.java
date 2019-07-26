package com.hubu.dao;

import java.util.List;

public interface AuthorityDao {
    public int getId(String role);
    public List<String> getRole();
}
