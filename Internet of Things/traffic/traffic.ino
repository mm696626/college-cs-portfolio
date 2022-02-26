#define red 25
#define yellow 26
#define green 27
#define sw 13

//simulates traffic light at CT side

void setup (void) {

  Serial.begin(115200);

  //turn on CT light pins and switch input pin
  pinMode(red, OUTPUT);
  pinMode(yellow, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(sw, INPUT);
  

}

void loop (void) {

  int val = digitalRead(sw); //read value of switch
  digitalWrite(red, HIGH); //turn on red by default

  if (val == HIGH) //if switch is pressed
  {
    int rand = random(1,11); //generates random number from 1 to 10

    if (rand == 5)
    {
      Serial.println("Lights changing back");
      changeLights();
    }
  }

  
  
  delay(1000); 
}

void changeLights()
{
  //changes CT side lights to normal, highway code is the inverse of this (green, yellow, red, yellow, green), but I could not fit 6 LEDS
  
  digitalWrite(red, LOW);
  delay(1500);
  digitalWrite(yellow, HIGH);
  delay(1500);
  digitalWrite(yellow, LOW);
  delay(1500);
  digitalWrite(green, HIGH);
  delay(1500);
  digitalWrite(green, LOW);
  delay(1500);
  digitalWrite(yellow, HIGH);
  delay(1500);
  digitalWrite(yellow, LOW);
  delay(1500);
  digitalWrite(red, HIGH);
  delay(1500);
}
