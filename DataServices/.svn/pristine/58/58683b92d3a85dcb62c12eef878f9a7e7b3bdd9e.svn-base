package aero.sita.IATABaggageXML;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import aero.sita.generated.BagPublishNotif;

public class CassandraProducer  {

    public static final String TIME_BUCKET = "2014-01-01";

/*    @Autowired
    private CassandraOperations cassandraTemplate;

    public Msg InsertMsgToCassandraDB(BagPublishNotif bag) {
        Msg msg = new Msg();
        		msg.setMsgID(bag.getBag().getCrew().getAllianceCode().getValue());
        		msg.setMsgDate(Instant.now());
        		
        cassandraTemplate.insert(msg);

        Select select = QueryBuilder.select().from("Msg").where(QueryBuilder.eq("MsgID", bag.getBag().getCrew().getAllianceCode().getValue())).limit(10);
        		

        Msg retrievedMsg = cassandraTemplate.selectOne(select, Msg.class);

       // List<Event> retrievedEvents = cassandraTemplate.select(select, Event.class);

        System.out.println("#########################################################################################");
        System.out.println(" retrievedMsg:"+retrievedMsg);
        return retrievedMsg;
    }*/
    
    public Map  insertMsg(BagPublishNotif bag){
        HashMap<String, Object> insert = new LinkedHashMap<String, Object>();
        insert.put("id", UUID.randomUUID());
        insert.put("album", "Undertow");
        insert.put("title", "Bottom");
        insert.put("artist", "Tool");
        insert.put("tags", "");
        return insert;
    }
}