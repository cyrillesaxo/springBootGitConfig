package aero.sita.casandra.persistence.repository;

import java.util.List;

import org.apache.camel.Exchange;

import aero.sita.mqtt.model.bimsxml.BagMqtt;

public interface BagMqttRepository {
	 public void insertBagMqtt(Exchange ex)throws Exception;
	 
	 public List<BagMqtt> selectBagMqtt(Exchange ex)throws Exception;
}
