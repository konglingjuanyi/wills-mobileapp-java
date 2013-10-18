package com.renren.intl.soundsns.utils;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class NetworkUtils {
	public static   Inet4Address getInetLocalIp() {  
		  
		Inet4Address rlt = null;
        try {  
            for (Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces(); e.hasMoreElements();) {  
                NetworkInterface item = e.nextElement();
                for (InterfaceAddress address : item.getInterfaceAddresses()) {  
                    if (address.getAddress() instanceof Inet4Address) {  
                        Inet4Address inet4Address = (Inet4Address) address.getAddress();  
                        if(inet4Address.isLoopbackAddress()){
                        	continue;
                        }
                         
                        rlt  = inet4Address;
                        //System.out.println(inet4Address.getHostAddress());
                        if(inet4Address.getHostAddress().startsWith("10")){
                        	return rlt;
                        }
                     //   System.out.println(inet4Address.getHostAddress());  
                      //  System.out.println(inet4Address.isLinkLocalAddress() + " " + inet4Address.isLoopbackAddress() + " " + inet4Address.isMCGlobal() + " " + inet4Address.isMulticastAddress());  
                    }  
                }  
            }  
        } catch (IOException ex) {  
  
        }
		return rlt;  
    }  
	
	public static void main(String args[]){
		System.out.println(NetworkUtils.getInetLocalIp().getHostAddress());
	}
}