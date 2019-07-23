package com.baomidou.mybatisplus.samples.crud;

import com.baomidou.mybatisplus.samples.crud.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: mafei2
 * @date: 2019-05-22 18:09
 */
public class ThirdPartyPayPO {
    private static final Logger logger = LoggerFactory.getLogger(ThirdPartyPayPO.class);

    private String channelCode = "111";

    //请求时间
    private String timestamp;

    //对应的公钥
    private String channelKey = "111";

    //验签串
    private String sign;

    //订单ID
    private String orderId;

    //是否改签（0未改签，1改签）
    private String isChange;

    //订单描述
    private String orderDes;

    //操作号
    private String actionId;

    //订单支付专项类型
    private String txnBId;

    //订单金额
    private BigDecimal txnAmt;

    //员工Id
    private String retailId;

    //产品类型
    private String productType;


    public String getProductType() {
        return productType;
    }

    public ThirdPartyPayPO setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public ThirdPartyPayPO setChannelCode(String channelCode) {
        this.channelCode = channelCode;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public ThirdPartyPayPO setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public ThirdPartyPayPO setChannelKey(String channelKey) {
        this.channelKey = channelKey;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public ThirdPartyPayPO setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public ThirdPartyPayPO setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getIsChange() {
        return isChange;
    }

    public ThirdPartyPayPO setIsChange(String isChange) {
        this.isChange = isChange;
        return this;
    }

    public String getOrderDes() {
        return orderDes;
    }

    public ThirdPartyPayPO setOrderDes(String orderDes) {
        this.orderDes = orderDes;
        return this;
    }

    public String getActionId() {
        return actionId;
    }

    public ThirdPartyPayPO setActionId(String actionId) {
        this.actionId = actionId;
        return this;
    }

    public String getTxnBId() {
        return txnBId;
    }

    public ThirdPartyPayPO setTxnBId(String txnBId) {
        this.txnBId = txnBId;
        return this;
    }

    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    public ThirdPartyPayPO setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
        return this;
    }

    public String getRetailId() {
        return retailId;
    }

    public ThirdPartyPayPO setRetailId(String retailId) {
        this.retailId = retailId;
        return this;
    }

    @Override
    public String toString() {
        return "ThirdPartyPayPO{" +
                "channelCode='" + channelCode + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", channelKey='" + channelKey + '\'' +
                ", sign='" + sign + '\'' +
                ", orderId='" + orderId + '\'' +
                ", isChange='" + isChange + '\'' +
                ", orderDes='" + orderDes + '\'' +
                ", actionId='" + actionId + '\'' +
                ", txnBId='" + txnBId + '\'' +
                ", txnAmt=" + txnAmt +
                ", retailId='" + retailId + '\'' +
                '}';
    }

    /**
     *	将对象转成form表单形式
     *
     * @return
     * @date 2019年5月23日 下午2:41:04
     * @author mafei2
     */
    public String toForm(String md5Sign,String action){

        return "{\"url\":\"<form id=\\\"batchForm\\\" method=\\\"post\\\" " +
                "action=\\\""+action+"\\\" target=\\\"_blank\\\">" +
                "<input type=\\\"hidden\\\" id=\\\"channelCode\\\" name=\\\"channelCode\\\" value=\\\""+channelCode+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"timestamp\\\" name=\\\"timestamp\\\" value=\\\""+timestamp+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"channelKey\\\" name=\\\"channelKey\\\" value=\\\""+channelKey+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"sign\\\" name=\\\"sign\\\" value=\\\""+ md5Sign+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"orderId\\\" name=\\\"orderId\\\" value=\\\""+orderId+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"actionId\\\" name=\\\"actionId\\\" value=\\\""+actionId+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"txnBId\\\" name=\\\"txnBId\\\" value=\\\""+txnBId+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"txnAmt\\\" name=\\\"txnAmt\\\" value=\\\""+txnAmt+"\\\"/>" +
                "<input type=\\\"hidden\\\" id=\\\"retailId\\\" name=\\\"retailId\\\" value=\\\""+retailId+"\\\"/>" +
                "</form><script type=\\\"text/javascript\\\">document.getElementById('batchForm').submit();</script>}\"}";



    }


    @Test
    public void test(){
       /* Long times=System.currentTimeMillis();
        System.out.println(times);
        for (int i = 0; i <200000 ; i++) {
            System.out.println(i);
        }
        System.out.println((double)(System.currentTimeMillis()-times)/1000);*/
      /*  List<Integer> integers=new ArrayList<>();
        integers.add(3);
        integers.add(4);
        for(Integer integer:integers){
            integer=5;
        }
        System.out.println(integers);


        List<User> users=new ArrayList<>();
        users.add(new User().setName("111"));

        for(User user:users){
            user.setName("222");
        }
        System.out.println(users.get(0).getName());*/
        /*Integer value = 51;
        int value2 = 20;
        int value3 = (int) Math.ceil((double) value / value2);
        System.out.println(value3);
        System.out.println(value2>value3);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");*/

        try {
            String a="1234";
            System.out.println(
                    a.substring(0,500)
            );
        } catch (Exception e) {
            logger.info("123 :{}", 123,e);

        }

    }
}
