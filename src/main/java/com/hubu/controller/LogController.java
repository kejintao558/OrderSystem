package com.hubu.controller;

import com.hubu.entity.Department;
import com.hubu.entity.Event;
import com.hubu.entity.Log;
import com.hubu.service.DepartmentService;
import com.hubu.service.EventService;
import com.hubu.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("log")
@Api("日志操作类")
public class LogController {
    @Autowired
    LogService logService;
    @Autowired
    EventService eventService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "getLog",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询是否有交接班日志",notes = "查询日志")
    public Log getLog(String department) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowtime = sdf.format(new Date());// new Date()为获取当前系统时间
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(sdf.parse(nowtime));
        Date date = rightNow.getTime();//查询日历事件
        Event event = eventService.getBylog(department,date);
        if (event != null){
            Log log = new Log();//创建日志实例
            log.setLocalday(event.getStart());
            log.setDepartment(event.getDepartment());
            log.setHander(event.getTitle());//交班人
            rightNow.add(Calendar.DAY_OF_MONTH, 1);
            date = rightNow.getTime();
            log.setCarryer(eventService.getBylog(department,date).getTitle());//接班人
            Log log1 = logService.find(log.getDepartment(),log.getLocalday());
            if (log1 == null){
                logService.add(log);
                return log;
            }
            else{
                return log1;
            }

        }
        else
            return null;

    }

//    @RequestMapping(value = "setHandFlag",method = RequestMethod.PUT)
//    @ResponseBody
//    @ApiOperation(value = "更改交班标志",notes = "更改交班标志")
//    public void setHandFlag(@RequestParam("depName") String department,@RequestParam("localday") String date) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//        Date localday = sdf.parse(date);
//        Log log = logService.find(department,localday);;
//        if(log != null){
//            log.setHandflag(Boolean.TRUE);
//            logService.update(log);
//        }
//    }



//    @RequestMapping(value = "setCarryFlag",method = RequestMethod.PUT)
//    @ResponseBody
//    @ApiOperation(value = "更改接班标志",notes = "更改接班标志")
//    public void setCarryFlag(@RequestParam("depName") String department,@RequestParam("localday") String date) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//        Date localday = sdf.parse(date);
//        Log log = logService.find(department,localday);;
//        if(log != null){
//            log.setCarryflag(Boolean.TRUE);
//            logService.update(log);
//        }
//
//    }

    @RequestMapping(value = "setHandFlag",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更改交班标志",notes = "更改交班标志")
    public void setHandFlag(@RequestBody Log log) throws ParseException {
        System.out.println(log);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowtime = sdf.format(log.getLocalday());
        Date date= sdf.parse(nowtime);
        log.setLocalday(date);
        log = logService.find(log.getDepartment(),log.getLocalday());
        System.out.println(log);
        if(log != null){
            log.setHandflag(Boolean.TRUE);
            logService.update(log);
        }
    }

    @RequestMapping(value = "setCarryFlag",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更改接班标志",notes = "更改接班标志")
    public void setCarryFlag(@RequestBody Log log) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowtime = sdf.format(log.getLocalday());
        Date date= sdf.parse(nowtime);
        log.setLocalday(date);
        log = logService.find(log.getDepartment(),log.getLocalday());
        if(log != null){
            log.setCarryflag(Boolean.TRUE);
            logService.update(log);
        }
    }

    @RequestMapping(value = "findLog",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询日志公告",notes = "查询日志公告")
    public List<Log> findLog(int depid){
        Department dep = departmentService.find(depid);
        List<Log> ls = logService.findLog(dep.getDepartment());
        List<Log> log = new ArrayList<Log>();
        for(int i = 0;i<ls.size();i++){
            if(ls.get(i).getHandflag() && ls.get(i).getCarryflag()){
                log.add(ls.get(i));
            }
        }
        return log;
    }

}
