package name.samolisov.spring.wm.demo;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JMSReceiver implements MessageListener {
    public JMSReceiver() {
        System.out.println("[JMSReceiver] construct");
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("[JMSReceiver] Receiving the message: "
                    + textMessage.getText());
            System.out.println("[JMSReceiver] executing in thread: "
                    + Thread.currentThread().getName());
            System.out.println("[JMSReceiver] start at " + (new Date()));
            Thread.sleep(5000);
            System.out.println("[JMSReceiver] end at " + (new Date()));
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
