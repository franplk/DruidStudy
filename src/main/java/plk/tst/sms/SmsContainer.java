/**
 * 创建日期 : 2016年12月30日
 * 修改历史 :
 * 1. [2016年12月30日]创建文件 by {康培亮/AB052634}
 */
package plk.tst.sms;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送短信的手机号码存储
 * 
 * @author {康培亮/AB052634}
 */
public class SmsContainer {

    private int number;
    private List<String> telNumberList;

    public SmsContainer() {
        this.number = 0;
    }

    public SmsContainer(List<String> telNumberList) {
        this();
        this.telNumberList = telNumberList;
    }

    public int getNumber() {
        return number;
    }

    public synchronized String getNextTel() {
        if (null == telNumberList) {
            throw new RuntimeException("没有电话");
        }
        number++;

        return telNumberList.remove(0);
    }

    public boolean isEmpty() {
        if (null == telNumberList) {
            return true;
        }
        return telNumberList.isEmpty();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<String> getTelNumberList() {
        return telNumberList;
    }

    public void setTelNumberList(List<String> telNumberList) {
        this.telNumberList = telNumberList;
    }

    public void initTest(int conut) {
        List<String> telNumberList = new ArrayList<String>();
        for (int idx = 1; idx <= conut; idx++) {
            telNumberList.add("tel-" + idx);
        }
        setTelNumberList(telNumberList);
    }
}
