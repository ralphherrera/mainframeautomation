/*package com.samplemaven.jagacy.utils;

import java.awt.Color;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tn5250j.Session5250;
import org.tn5250j.SessionConfig;
import org.tn5250j.beans.ProtocolBean;
import org.tn5250j.framework.tn5250.Screen5250;
import org.tn5250j.framework.tn5250.ScreenPlanes;

public class TestClass extends Session5250 {

	public TestClass(Properties arg0, String arg1, String arg2, SessionConfig arg3) {
		super(arg0, arg1, arg2, arg3);
	}



	private static final Logger log = LogManager.getLogger(TestClass.class);

	
	
	public static void main(String[] args) {
		
		try {
			 ProtocolBean pb = new ProtocolBean("test", "111");
		        pb.setHostName("pub400.com");
		        
		        Session5250 session = pb.getSession();
		        pb.connect();
		        
		        Screen5250 screen = session.getScreen();
		        session.isConnected();
		        screen.toggleGUIInterface();
        		
		        char [] buffer = new char[1920];
		        StringBuilder sb = new StringBuilder();
		        Thread.sleep(3000);
		        ScreenPlanes sp = new ScreenPlanes(screen, 80);
		        sp.GetScreen(buffer, 80, 80);
		       
		        screen.GetScreen(buffer, 1920, 80);
		        String showme = new String(buffer);
		        
		        for(int i=0;i<showme.length();i+=80) {
		            sb.append(showme.substring(i, i+80));
		            sb.append("\n");
		        }
		        
		        // Append data to Window
		        JFrame win =new JFrame("tn5250j test window");
		        win.setSize(800, 600);
		        win.setBackground(Color.BLACK);
		        JTextArea ta = new JTextArea(sb.toString());
		        win.add(ta);
		        win.setVisible(true);
		        
		        System.out.println(sb.toString());
		        session.disconnect();
		} catch (Exception e) {
			log.error("Something went wrong {}", e);
		}
	}

}
*/