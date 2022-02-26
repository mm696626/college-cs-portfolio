#include "DHTesp.h"

#define dhtPin 33
#define light 34

static DHTesp dht;
void setup() {
  Serial.begin(115200);
  pinMode(light,INPUT); //set up light sensor
  dht.setup( dhtPin, DHTesp::DHT11 ); //init sensor
}

void loop() {
  int lightLevel = analogRead(light);
  Serial.println("Light: " + String(lightLevel));
  TempAndHumidity values = dht.getTempAndHumidity();
  if(dht.getStatus() == 0)
  {
    double f = dht.toFahrenheit(values.temperature);
    double h = values.humidity;
    Serial.println("T: " + String(f) + "F H: " + String(h) + "%");
  }
  delay(5000);
}
