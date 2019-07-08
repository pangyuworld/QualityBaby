package com.swust.fund;

import com.github.pagehelper.PageInfo;
import com.swust.fund.entity.Activity;
import com.swust.fund.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FundApplicationTests {
    @Autowired
    private ActivityService activityService;

    @Test
    public void contextLoads() {
        PageInfo<Activity> activities = activityService.getActivity(1, 2, true);
        System.out.println(activities);
    }

}
