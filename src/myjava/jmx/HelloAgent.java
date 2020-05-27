package myjava.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class HelloAgent {
    public static void main(String[] args) {
        try {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            ObjectName helloName = new ObjectName("jmxBean:name=hello");
            server.registerMBean(new Hello(), helloName);
            Thread.sleep(60*60*1000);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
