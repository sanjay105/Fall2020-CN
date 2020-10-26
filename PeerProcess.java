//package project;
import java.io.*;
import java.util.*;

import project.CommonConfig;
import project.PeerInfoConfig;
import project.RemotePeerInfo;

public class PeerProcess{
    
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
    public static void main(String[] args){
        CommonConfig c = new CommonConfig();
        PeerInfoConfig pic=new PeerInfoConfig();
        c.loadCommonFile();
        pic.getConfiguration();
        printCommonConfig(c);
        printPeerConfig(pic);
    }
};