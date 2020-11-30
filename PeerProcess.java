//package project;
import java.net.*;
import java.net.http.WebSocket.Listener;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import java.lang.*;

import project.CommonConfig;
import project.PeerInfoConfig;
import project.RemotePeerInfo;

public class PeerProcess {
    // public int id;
    public static void printCommonConfig(CommonConfig c){
        System.out.println(c.NumberOfPreferredNeighbors);
        System.out.println(c.UnchokingInterval);
        System.out.println(c.OptimisticUnchokingInterval);
        System.out.println(c.FileName);
        System.out.println(c.FileSize);
        System.out.println(c.PieceSize);
    }
    public static void printPeerConfig(PeerInfoConfig pic){
        for (RemotePeerInfo i:pic.peerInfoList){
            System.out.println(i.peerAddress+" "+i.peerId+" "+i.peerPort+" "+i.containsFile);
        }
    }
    public static void makeTcpConnection(int id,RemotePeerInfo p){
        System.out.println(id+"-"+p.peerId);
    }
    public static void main(String[] args)  throws Exception  {
        CommonConfig c = new CommonConfig();
        PeerInfoConfig pic=new PeerInfoConfig();
        c.loadCommonFile();
        pic.getConfiguration();

        int id = Integer.parseInt(args[0]);
        Boolean make = true;
        int myPort = 8080;
        for (RemotePeerInfo p:pic.peerInfoList){
            if(p.peerId==id){myPort=p.peerPort;break;}
        }
        ServerSocket listener = new ServerSocket(myPort);;
        for(int i=0;i<pic.peerInfoList.size();i++){
            if(pic.peerInfoList.get(i).peerId==id){
                make = false;
                myPort = pic.peerInfoList.get(i).peerPort;
                // listener = new ServerSocket(myPort);
                System.out.println("listening on port "+myPort);
            }
            if(make){
                System.out.println("requesting to "+pic.peerInfoList.get(i).peerAddress+" port "+pic.peerInfoList.get(i).peerPort);
                Socket requestSocket = new Socket(pic.peerInfoList.get(i).peerAddress, pic.peerInfoList.get(i).peerPort);
            }else{
                if(id != pic.peerInfoList.get(i).peerId){
                    Thread t = new Thread(listener);
                    t.start();
                    
                }
            }
        }
        System.out.println(id);
    }

    public void run(ServerSocket listener) throws Exception{
        System.out.println("thread");
        Socket sid = listener.accept();
        System.out.println("Connected to "+sid.getInetAddress()+"/"+sid.getPort()+"/");
        byte[] b;
        boolean wh = true;
        while(wh){
            int len = sid.getInputStream().read(b);
            System.out.println(b);
            if(len == -100){wh= false;}
        }
    }
}