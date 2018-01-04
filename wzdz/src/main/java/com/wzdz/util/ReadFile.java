package com.wzdz.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class ReadFile {
	
	public Map<String,Object> readFile(String name) throws IOException{
    	Properties prop = new Properties(); 
    	 InputStream in;
    	 Map<String,Object> map= new HashMap<String,Object>();
		try {
			in = new BufferedInputStream (new FileInputStream(name));
			 prop.load(in);     ///加载属性列表
             Iterator<String> it=prop.stringPropertyNames().iterator();
             while(it.hasNext()){
                String key=it.next();
                map.put(key, prop.getProperty(key));
//                 System.out.println(key+":"+prop.getProperty(key));
           }
             in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	            
    	return map;
    }

}
