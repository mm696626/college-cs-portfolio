//Blink by Matt McCullough
#define LED 27

void setup() {
  Serial.begin(115200);
  Serial.println("In setup");
  pinMode(LED, OUTPUT);
  digitalWrite(LED, LOW);
  Serial.println("out setup");

}

void loop() {
  Serial.println("In loop");
  digitalWrite(LED, HIGH); //turn LED on
  delay(1000);
  digitalWrite(LED, LOW); //turn LED off
  delay(1000);
  Serial.println("out loop");
}
