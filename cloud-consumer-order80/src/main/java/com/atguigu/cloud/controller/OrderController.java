package com.atguigu.cloud.controller;

import com.atguigu.cloud.config.RestTemplateConfig;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称

    @Resource
    private RestTemplate restTemplate;

    //增加
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    //根据id查询
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    //修改
    @GetMapping("/consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO){
         restTemplate.put(PaymentSrv_URL + "/pay/update", payDTO);
         return ResultData.success("修改成功");
    }

    //删除
    @GetMapping("/consumer/pay/del/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id){
        restTemplate.delete(PaymentSrv_URL + "/pay/del/" + id,id);
        return ResultData.success("删除成功");
    }

    //获取consul配置信息，可以看到负载均衡，默认使用轮巡算法
    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }
}
