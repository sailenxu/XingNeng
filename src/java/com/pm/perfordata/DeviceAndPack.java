package com.pm.perfordata;

public class DeviceAndPack {
    //���ӵ���ģʽ
    private static DeviceAndPack deviceAndPack = new DeviceAndPack();
    public static DeviceAndPack getDeviceAndPack() {
        return deviceAndPack;
    }

    public static String deivceid;
    public static String packagename;
    public void setDeivceid(String deivceid) {
        this.deivceid = deivceid;
    }
    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }
}