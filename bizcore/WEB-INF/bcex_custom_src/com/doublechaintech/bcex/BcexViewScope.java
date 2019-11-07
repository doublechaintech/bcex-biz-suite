package com.doublechaintech.bcex;


import com.terapico.caf.viewpage.SerializeScope;

public class BcexViewScope extends BcexBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static BcexViewScope instance = null;
	public static BcexViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (BcexViewScope.class) {
			instance = new BcexViewScope();
		}
		return instance;
	}
}







