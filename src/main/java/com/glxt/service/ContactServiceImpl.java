package com.glxt.service;

import com.glxt.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper contactMapper;

    @Override
    public List contTable() {
        return contactMapper.contTable();
    }
    @Override
    public List contChart(){
        return contactMapper.contChart();
    }
}
