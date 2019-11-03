package myjava.lang;

import java.util.ArrayList;
import java.util.List;

public class ThreadList {
    private static ThreadGroup getRootThreadGroup(){
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        while(true){
            if (null != rootGroup.getParent()) {
                rootGroup = rootGroup.getParent();
            } else {
                break;
            }
        }
        return rootGroup;
    }

    public static List<String> getThreads(ThreadGroup threadGroup){
        List<String> threadList = new ArrayList<>();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        int count = threadGroup.enumerate(threads, false);
        for (int i=0; i<count; i++) {
            threadList.add(threadGroup.getName() + "线程组：" + threads[i].getName() + "***"
                    + threads[i].getState() + "***" + threads[i].isDaemon());
        }
        return threadList;
    }

    public static List<String> getThreadGroups(ThreadGroup threadGroup){
        List<String> threadList = getThreads(threadGroup);
        ThreadGroup[] groups = new ThreadGroup[threadGroup.activeGroupCount()];
        int count = threadGroup.enumerate(groups, false);
        for (int i=0; i<count; i++) {
            threadList.addAll(getThreads(groups[i]));
        }
        return threadList;
    }

    public static void main(String[] args) {
        for (String str : getThreadGroups(getRootThreadGroup())) {
            System.out.println(str);
        }
    }
}
