package com.dsi.tp1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Consumer;
import com.dsi.tp1.entities.PayementInfo;
import com.dsi.tp1.repositories.ConsumerRepository;
import com.dsi.tp1.repositories.PayementInfoRepository;
@Service
public class ConsumerService implements IConsumerServive {
@Autowired
private ConsumerRepository consumerRepository ;
private PayementInfoRepository payementInfoRepository;
@SuppressWarnings("unused")
@Autowired
private Environment env;
@Override
public Consumer getInfoConsumer(int id) {
    Optional<Consumer> optionalConsumer = consumerRepository.findById(id);
    
    if (optionalConsumer.isPresent()) {
        Consumer consumer = optionalConsumer.get();
        consumer.setNom("New Name");
        consumer.setTelephone("New Telephone");
        consumer.setAdresse_mail("New Email");
        consumer.setPayementInfo(new PayementInfo());
        return consumerRepository.save(consumer);
    }
    
    return null;
}

@Override
public void subscribeConsumer(Consumer consumer) {
    consumerRepository.save(consumer);	
}
@Override
public List<PayementInfo> findCardByConsumer(int consumer_id) {
    List<PayementInfo> allPayementInfos = payementInfoRepository.findAll();
    List<PayementInfo> availablePayementInfos = new ArrayList<>();
    
    for (PayementInfo payementInfo : allPayementInfos) {
        if (payementInfo.getConsumer_id() == consumer_id) {
            availablePayementInfos.add(payementInfo);
        }
    }
    return availablePayementInfos;
}

}


	
