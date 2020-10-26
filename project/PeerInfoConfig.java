package project;

import java.util.*;
import java.io.*;

public class PeerInfoConfig {
    public ArrayList<RemotePeerInfo> peerInfoList;
	
	public void getConfiguration()
	{
		String st;
		peerInfoList = new ArrayList<RemotePeerInfo>();
		try {
			BufferedReader in = new BufferedReader(new FileReader("project/PeerInfo.cfg"));
			while((st = in.readLine()) != null) {
				String[] tokens = st.split("\\s+");
				peerInfoList.add(new RemotePeerInfo(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3])));
			}
			in.close();
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
