package aero.sita.IATABaggageXML;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.vertx.camel.CamelBridge;
import io.vertx.camel.CamelBridgeOptions;
import io.vertx.camel.InboundMapping;
import io.vertx.camel.OutboundMapping;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.JsonObject;

/**
 * @author Cyrille Eloundou
 */
public class DataServicesMain extends AbstractVerticle {

	private final static Logger log = LoggerFactory.getLogger(DataServicesMain.class);
    private static final String ADDRESS = "localhost";
    private static final String MESSAGE = " <xml>Send msg to Andy 3</xml>";
    private static final String TOPIC = "test";
    
    private static Vertx camelVerticle =  Vertx.vertx();
    private static Vertx kafkaVerticle =  Vertx.vertx();
    
	public static void main(String[] args) {
		try {
			initcamelVerticle();
			//initKafkaVerticle();
		} catch (Exception e) {
			log.error("Unable to initialize verticles :"+e);
		}
	}

  @Override
  public void start() throws Exception {
    ApplicationContext app = new ClassPathXmlApplicationContext("META-INF/spring/camelContext.xml");
    CamelContext camel = app.getBean("camel", CamelContext.class);

    CamelBridge.create(vertx, new CamelBridgeOptions(camel)
    	.addInboundMapping(InboundMapping.fromCamel("direct:outMQQTClient").toVertx("eventbus-address"))
        .addOutboundMapping(OutboundMapping.fromVertx("eventbus-address").toCamel("direct:inMQQTClient")))
        .start();

  }

  private void invoke(HttpServerRequest request) {
    String param = request.getParam("name");
    if (param == null) {
      param = "vert.x";
    }
    vertx.eventBus().<String>send("invocation", param, reply -> {
      if (reply.failed()) {
        request.response().setStatusCode(400).end(reply.cause().getMessage());
      } else {
        request.response().setStatusCode(400).end(reply.result().body());
      }
    });
  }
  
  
  public  void receiveMessage(Exchange exchange) throws Exception {
	  String MESSAGE = exchange.getIn().getBody(String.class);
/*      final KafkaProducerService kafkaProducerService = KafkaProducerService.createProxy(kafkaVerticle, ADDRESS);
      kafkaProducerService.sendString(new StringKafkaMessage(MESSAGE), (Handler<AsyncResult<Void>>) message -> {
          if (message.failed()) {
          	System.out.println("Failed to send messages after 3 tries.");
          }
      });*/
      
    	exchange.getOut().setBody(exchange.getIn().getBody());
      	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
  }
  
  protected static void deploy( Vertx vertx , DeploymentOptions deploymentOptions) throws InterruptedException {
      vertx.deployVerticle("service:MQQTClient.kafka-producer", deploymentOptions, result -> {
          if (result.failed()) {
              result.cause().printStackTrace();
          }
      });
  }

  public static void initcamelVerticle()throws Exception{
	  camelVerticle.deployVerticle(DataServicesMain.class.getName());
  }
  
  public static void initKafkaVerticle() throws Exception {
      JsonObject config = new JsonObject();
      config.put("address", ADDRESS);
      config.put("brokerList", "localhost:9092");
      config.put( "defaultTopic", TOPIC);
      config.put( "requiredAcks", 1);

      final DeploymentOptions deploymentOptions = new DeploymentOptions();
      deploymentOptions.setConfig(config);
      deploymentOptions.setWorker(true);
      deploy( kafkaVerticle, deploymentOptions);

  }
}
