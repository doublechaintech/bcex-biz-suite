package com.doublechaintech.bcex;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BcexQuery extends BaseQuery {
	
	public BcexQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("bcex");
  }

  public BcexQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}













