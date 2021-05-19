package com.fengzi.dubbo.platform.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fujian
 * @version 1.0
 * @date 2021/04/07
 */
@Service
public class ActivitiServiceImpl {

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;


    public void sss() {
        //执行人userId
        String userId = "222";
        //请假天数
        Integer days = 3;
        String formId = "333";
        //启动流程实例，字符串"vacation"是BPMN模型文件里process元素的id
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacation");
        //流程实例启动后，流程会跳转到请假申请节点
        Task vacationApply = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //设置请假申请任务的执行人
        taskService.setAssignee(vacationApply.getId(), userId);
        //设置流程参数：请假天数和表单ID
        //流程引擎会根据请假天数days>3判断流程走向
        //formId是用来将流程数据和表单数据关联起来
        Map<String, Object> args = new HashMap<>();
        args.put("days", days);
        args.put("formId", formId);
        //完成请假申请任务
        taskService.complete(vacationApply.getId(), args);
    }
}
