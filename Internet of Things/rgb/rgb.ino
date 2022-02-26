//RGB by Matt McCullough
#define LED 27
#define LED2 14
#define LED3 12

void setup() {
  Serial.begin(115200);
  Serial.println("In setup");
  pinMode(LED, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  
  digitalWrite(LED, LOW);
  digitalWrite(LED2, LOW);
  digitalWrite(LED3, LOW);
  Serial.println("out setup");

}

void loop() {
  Serial.println("In loop");
  //blinks an assortment of colors and turns each of the components (red, green, blue on and off to create different colors)
  
  digitalWrite(LED, HIGH);
  delay(1000);
  digitalWrite(LED, LOW);
  delay(1000);
  digitalWrite(LED2, HIGH);
  delay(1000);
  digitalWrite(LED2, LOW);
  delay(1000);
  digitalWrite(LED3, HIGH);
  delay(1000);
  digitalWrite(LED3, LOW);
  delay(1000);
  Serial.println("out loop");
}
