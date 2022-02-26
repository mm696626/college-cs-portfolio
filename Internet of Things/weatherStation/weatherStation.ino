#include "DHTesp.h"
#include "WiFi.h"



#define ssid "LAPTOP-USDV5SB6 5439"  //wifi network name
#define pwd  "b243?1N9" //wifi password
#define  hostDomain "grevera.ddns.net"    //internet domain to request from
#define  hostDoc  "/~wilma/iot.php"  //cannot be empty; use "/" if necessary (doc root)
#define  hostPort 80


#define dhtPin 33
#define light 34
static DHTesp dht;

void setup() {
  Serial.begin(115200);
  pinMode(light,INPUT); //set up light sensor
  dht.setup( dhtPin, DHTesp::DHT11 ); //init sensor
  connectToWiFi(); //connect to network
}


static void connectToWiFi ( void ) {
    Serial.println( "Connecting to WiFi network: " + String(ssid) );

    WiFi.begin( ssid, pwd );
    while (WiFi.status() != WL_CONNECTED) {  //wait until connected
        delay( 1000 );
        Serial.print( "." );
    }

    Serial.println();
    Serial.println( "WiFi connected!" );
    Serial.print( "IP address: " );
    Serial.println( WiFi.localIP() );
}


void loop() {

  int lightLevel = analogRead(light);
  double temp = 0;
  double humidity = 0;
  Serial.println(lightLevel);
  
  TempAndHumidity values = dht.getTempAndHumidity();
  if(dht.getStatus() == 0)
  {
    temp = dht.toFahrenheit(values.temperature);
    humidity = values.humidity;
    Serial.println("T: " + String(temp) + "F H: " + String(humidity) + "%");
  }

  //construct URL string here
  String user = "?user=matt";
  String lightRequest = "&light=";
  String tempRequest = "&temp=";
  String humidRequest = "&humid=";

  
  //put all the pieces together
  String hostDocNew = hostDoc + user + lightRequest + String(lightLevel) + tempRequest + String(temp) + humidRequest + String(humidity); 
  //example string /~wilma/iot21.php?user=matt&light=100&temp=90&humid=80
  
  requestURL((char*)hostDomain, hostDocNew, hostPort);
  delay(10000); //delay for 10 seconds so requests aren't constantly sent
}

static void requestURL ( char* host, String doc, uint8_t port ) {
      Serial.println( "----------" );
      Serial.println( "Connecting to domain: " + String(host) );

      // Use WiFiClient class to create TCP connections
      WiFiClient client;
      if (!client.connect(host, port)) {
          Serial.println( "connection failed" );
          return;
      }
      Serial.println( "Connected!" );
      Serial.println( "----------" );
      // This will send the request to the server
      client.print( (String) "GET " + doc + " HTTP/1.1\r\n" +
                             "Host: " + String(host) + "\r\n" +
                             "Connection: close\r\n\r\n" );
      unsigned long timeout = millis();
      while (client.available() == 0) {  //wait for response(but not forever)
          if (millis()-timeout > 5000) {
              Serial.println( ">>> Client Timeout !" );
              client.stop();
              return;
          }
      }

      //read all lines of the reply from server and print them
      while (client.available()) {
          String line = client.readStringUntil( '\r' );
          Serial.print( line );
      }

      Serial.println();
      Serial.println( "closing connection" );
      client.stop();
}
