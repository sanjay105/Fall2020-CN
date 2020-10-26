package project;
import java.io.*;
import java.util.*;
public class CommonConfig {
    public  int NumberOfPreferredNeighbors;
    public  int UnchokingInterval;
    public  int OptimisticUnchokingInterval;
    public  String FileName;
    public  int FileSize;
    public  int PieceSize;
    public  void loadCommonFile(){
        try{
            FileReader fobj = new FileReader("project/Common.cfg");
            Scanner fReader = new Scanner(fobj);
            while (fReader.hasNextLine()){
                String line= fReader.nextLine();
                String[] temp=line.split(" ");
                if(temp[0].equals("NumberOfPreferredNeighbors")){
                    NumberOfPreferredNeighbors=Integer.parseInt(temp[1]);
                }else if(temp[0].equals("UnchokingInterval")){
                    UnchokingInterval=Integer.parseInt(temp[1]);
                }else if(temp[0].equals("OptimisticUnchokingInterval")){
                    OptimisticUnchokingInterval=Integer.parseInt(temp[1]);
                }else if(temp[0].equals("FileName")){
                    FileName = temp[1];
                }else if(temp[0].equals("FileSize")){
                    FileSize = Integer.parseInt(temp[1]);
                }else if(temp[0].equals("PieceSize")){
                    PieceSize = Integer.parseInt(temp[1]);
                }
            }
            fReader.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) throws Exception{
        System.out.println("sanjay");
    }
}
