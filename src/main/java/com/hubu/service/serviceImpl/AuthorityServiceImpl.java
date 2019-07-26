package com.hubu.service.serviceImpl;

import com.hubu.dao.AuthorityDao;
import com.hubu.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    AuthorityDao authorityDao;

    @Override
    public int getId(String role) {
        return authorityDao.getId(role);
    }

    @Override
    public List<String> getRole() {
        return authorityDao.getRole();
    }
}
