package myjava.lang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowEvent;

public class ThreadPriorityTest extends JFrame {

    protected void do_this_windowActived(WindowEvent e) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads);
        //DefaultTableModel model = table.getModel();
    }
}
