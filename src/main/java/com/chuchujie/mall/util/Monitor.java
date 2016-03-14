package com.chuchujie.mall.util;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Monitor {

    private static final String IP = "10.30.10.227";
    private static List<Integer> _portList;//端口
    private static DatagramSocket _socket; // udp套接字
    private static DatagramPacket _packet;// udp数据包

    static {
        _portList = new ArrayList<Integer>();
        _portList.add(21555);
        _portList.add(21556);

    }

    //上报延迟接口,参数上报id,上报时间(ms)
    public static void sendTime(long time) {
        sendMessage(content(191) + time, 1);
    }

    //拼接传输文本格式
    private static String content(int pid)
    {
        return getSeq() + "-==-" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "-==-" + pid + "-==-";
    }

    //udp协议发送信息
    private static void sendMessage(String message, int port) {
        byte[] buf = new byte[0]; //创建发送数据缓冲区
        try {
            buf = message.getBytes("UTF-8");
            _packet = new DatagramPacket(buf, buf.length, InetAddress.getByName(IP),_portList.get(port));
            _socket = new DatagramSocket();
            _socket.setSoTimeout(1000);
            _socket.send(_packet);
            _socket.close();
        } catch (Exception e) {
        }
    }

    //创建唯一的序列化字段,主要为了查出一次请求中的所有log
    public static String getSeq() {
        return UUID.randomUUID().toString();
    }
}
