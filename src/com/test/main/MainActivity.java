package com.test.main;

import com.test.perfordata.DeviceAndPack;
import com.test.util.AppInfo;
import com.test.util.DevicesInfos;
import com.test.util.InfoByDevice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * 20200427:��ʼ�����
 */
public class MainActivity {
    public static void main(String[] args) {
        DeviceAndPack deviceAndPack = new DeviceAndPack();

        JFrame jFrame = new JFrame("PerformanceMonitor--by sai");

        jFrame.setSize(1500, 1000);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("closing����");
                System.exit(0);
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 500, 500));
        panel.setBackground(Color.YELLOW);
//        JButton bt1=new JButton("TEST");
//        panel.add(bt1);

        //�����豸ѡ��
        JLabel device=new JLabel("device��");
        panel.add(device);
        DevicesInfos devicesInfos = new DevicesInfos();
        String[] packBoxValue=devicesInfos.getDevicesArray();
        JComboBox packCombo = new JComboBox(packBoxValue);
        if (packBoxValue.length>1) {
            packCombo.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == e.SELECTED) {
                        System.out.println("12322131");
                        deviceAndPack.setDeivceid(String.valueOf(packCombo.getSelectedItem()));
                    }
                }
            });
        }else if(packBoxValue.length==1){
            deviceAndPack.setDeivceid(packBoxValue[0]);
        }else{
            System.out.println("device is exception");
        }


        panel.add(packCombo);

        //���Ӱ���ѡ��
        InfoByDevice info=new InfoByDevice("Q5S5T19529000632");
        String[] comboValue=info.getAllPack();

        JLabel label=new JLabel("������");
        panel.add(label);
        JComboBox jComboBox = new JComboBox(comboValue);
        JList jList=new JList();
        JScrollPane jp=new JScrollPane(jList);
        jp.setPreferredSize(new Dimension(100, 200));

        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    //ѡ������󣬾Ϳ��Լ���Ӧ����Ϣ
                    deviceAndPack.setPackagename(String.valueOf(jComboBox.getSelectedItem()));
                    System.out.println(deviceAndPack.getDeivceid()+"::::"+deviceAndPack.getPackagename());
                }
            }
        });

        panel.add(jComboBox);

        jFrame.add(panel);

        jFrame.setVisible(true);
    }
}