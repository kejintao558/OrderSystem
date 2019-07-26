package com.hubu.controller;


import com.hubu.entity.Event;
import com.hubu.service.DepartmentService;
import com.hubu.service.EventService;
import com.hubu.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("event")
@Api("日历事件操作类")
public class    EventController {
    @Autowired
    EventService eventService;
    @Autowired
    UserService userService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "addEvent",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据岗位人员自动排班",notes = "排班")
    public  List addEvent(@RequestParam("department")String dep, @RequestParam("date") String date,
                          @RequestParam("number")int num) throws ParseException {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        rightNow.setTime(sdf.parse(date));
        System.out.println(rightNow);
        Date  date1= rightNow.getTime();
        List le = new ArrayList();
        int flag = 1;
        int i = departmentService.getId(dep);
        while(flag <= num){
            List<String> ls = userService.getRealname(i);//岗位用户列表
            while(!ls.isEmpty()){ //判断是否为空
                Event event=new Event();   //创建Event实例
                Random random = new Random();
                int target = random.nextInt(ls.size());//随机获取list元素的下标
                String realname = ls.get(target); //获取该下标下的元素值

                event.setTitle(realname);//对event实例赋值
                event.setStart(date1);
                event.setDepartment(dep);
                eventService.add(event);
                le.add(event);

                rightNow.add(Calendar.DAY_OF_MONTH, 1);//日期增加一天
                date1= rightNow.getTime();
                rightNow.setTime(date1);
                ls.remove(target);
                flag++;
                if(flag>=num){
                    break;
                }
            }
        }
        return le;
    }

    @RequestMapping(value = "getEvent",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据岗位查询值班信息",notes = "排班信息")
    public List<Event> getEvent(@RequestParam("department") String dep){
        return eventService.findByDep(dep);
    }

}
