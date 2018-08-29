package com.samplemaven.jagacy.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jagacy.Key;
import com.jagacy.util.JagacyException;

public class CommonActionsUtil {

	private static final Logger log = LogManager.getLogger(CommonActionsUtil.class);

	/**
	 * 
	 * @param key
	 * @return 
	 */
	public static Key pressKey(SessionDriver sd, String key) {
		//		Map<String, Key> keyBoardMapping = new HashMap<>();
		//		try {
		//			keyBoardMapping.put("Enter", sd.writeKey(Key.ENTER));
		//			keyBoardMapping.put("F24", sd.writeKey(Key.PF24));
		//			
		//			return keyBoardMapping.get(key);
		//		} catch (Exception e) {
		//			log.error("Cannot find indicated key {} {}", key, e);
		//		}
		//		return keyBoardMapping.get(key);
		Key kb = null;
		try {
			switch (key) {
			case "Enter":
				kb =  sd.writeKey(Key.ENTER);
			default:
				kb = null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kb;
	}
}
