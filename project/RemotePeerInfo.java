/*
 *                     CEN5501C Project2
 * This is the program starting remote processes.
 * This program was only tested on CISE SunOS environment.
 * If you use another environment, for example, linux environment in CISE 
 * or other environments not in CISE, it is not guaranteed to work properly.
 * It is your responsibility to adapt this program to your running environment.
 */
package project;
public class RemotePeerInfo {
	public int peerId;
	public String peerAddress;
	public int peerPort;
	public int containsFile;
	public RemotePeerInfo(String pId, String pAddress, String pPort, String cFile) {
		peerId = Integer.parseInt(pId);
		peerAddress = pAddress;
		peerPort = Integer.parseInt(pPort);
		containsFile = Integer.parseInt(cFile);
	}
}
