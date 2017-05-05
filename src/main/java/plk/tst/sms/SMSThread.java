/**
 * 创建日期 : 2016年12月30日
 * 修改历史 :
 * 1. [2016年12月30日]创建文件 by {康培亮/AB052634}
 */
package plk.tst.sms;

import java.util.concurrent.CountDownLatch;

/**
 * @author {康培亮/AB052634}
 */
public class SMSThread extends Thread {

    private CountDownLatch downLatch;
    private SmsContainer smsContainer;

    public SMSThread() {
    }

    public SMSThread(SmsContainer smsContainer, CountDownLatch downLatch) {
        this.smsContainer = smsContainer;
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        while (true) {
            if (smsContainer.isEmpty()) {
                break;
            }
            sendMsg(smsContainer.getNextTel());
            downLatch.countDown();;
        }
    }

    private void sendMsg(String nextTel) {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();;
        }
        System.out.println(nextTel);
    }

    public static void main(String args[]) throws Exception {

        SmsContainer container = new SmsContainer();
        container.initTest(200);
        
        CountDownLatch downLatch = new CountDownLatch(200);
        
        for (int i = 0; i < 10; i++) {
            Thread thread = new SMSThread(container, downLatch);
            thread.start();
        }
        
        downLatch.await();
        
        System.out.println(container.getNumber());
    }
}
