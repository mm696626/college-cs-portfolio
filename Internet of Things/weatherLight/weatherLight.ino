#define light 34
void setup() {
  Serial.begin(115200);
  pinMode(light,INPUT);
}

void loop() {
  int lightLevel = analogRead(light);
  Serial.println(lightLevel);
  delay(5000);
}
