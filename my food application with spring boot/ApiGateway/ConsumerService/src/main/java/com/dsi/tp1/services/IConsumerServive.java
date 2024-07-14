package com.dsi.tp1.services;

import java.util.List;

import com.dsi.tp1.entities.Consumer;
import com.dsi.tp1.entities.PayementInfo;

public interface IConsumerServive {
	   public Consumer getInfoConsumer(int id);
	   public void subscribeConsumer(Consumer consumer);
	   public List<PayementInfo> findCardByConsumer(int consumer_id);
	    
}
