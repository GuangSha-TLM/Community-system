package com.gsxy.core.service.impl;

import com.gsxy.core.mapper.ActivityMapper;
import com.gsxy.core.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;



}
