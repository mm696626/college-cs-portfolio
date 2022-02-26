//Chaser by Matt McCullough (idk why the fifth light isn't blinking)
#define LED 33
#define LED2 25
#define LED3 26
#define LED4 27
#define LED5 14

void setup() {
  Serial.begin(115200);
  Serial.println("In setup");
  
  pinMode(LED, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  pinMode(LED4, OUTPUT);
  pinMode(LED5, OUTPUT);
  
  digitalWrite(LED, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);
  digitalWrite(LED4, LOW);
  digitalWrite(LED5, LOW);
  Serial.println("out setup");

}

void loop() {
  Serial.println("In loop");

  //turn led 1 on and others off
  digitalWrite(LED, HIGH);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);
  digitalWrite(LED4, LOW);
  digitalWrite(LED5, LOW);
  delay(500);

  //repeat for 2
  digitalWrite(LED, LOW);
  digitalWrite(LED2, HIGH);
  digitalWrite(LED3, LOW);
  digitalWrite(LED4, LOW);
  digitalWrite(LED5, LOW);
  delay(500);

  //repeat for 3
  digitalWrite(LED, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, HIGH);
  digitalWrite(LED4, LOW);
  digitalWrite(LED5, LOW);
  delay(500);

  //repeat for 4
  digitalWrite(LED, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);
  digitalWrite(LED4, HIGH);
  digitalWrite(LED5, LOW);
  delay(500);
  
  //repeat for 5
  digitalWrite(LED, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);
  digitalWrite(LED4, LOW);
  digitalWrite(LED5, HIGH);
  delay(1000);
  
  Serial.println("out loop");
}
