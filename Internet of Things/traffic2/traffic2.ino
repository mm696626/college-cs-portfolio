#define red 33
#define yellow 25
#define green 26

#define red2 27
#define yellow2 14
#define green2 12
#define sw 13

//simulates traffic light at CT side

void setup (void) {

  Serial.begin(115200);

  //turn on CT light pins and switch input pin
  pinMode(red, OUTPUT);
  pinMode(yellow, OUTPUT);
  pinMode(green, OUTPUT);
  pinMode(red2, OUTPUT);
  pinMode(yellow2, OUTPUT);
  pinMode(green2, OUTPUT);
  pinMode(sw, INPUT);
  attachInterrupt(digitalPinToInterrupt(sw), isr, RISING); //put interrupt on button pin
  
  

}

void loop (void) {

   if (digitalRead(sw)==LOW) { //this means the isr method was called
     changeLights(); //method that changes the lights
    }
  
    delay(1000); 
}

void isr() { //interrupt service routine
  digitalWrite(sw, LOW);
}


void changeLights()
{
  //I actually got 6 LED's on the board this time, but otherwise this code is indentical to the routine from traffic1
  digitalWrite(red, LOW);
  digitalWrite(green2, LOW);
  delay(1500);
  digitalWrite(yellow, HIGH);
  digitalWrite(yellow2, HIGH);
  delay(1500);
  digitalWrite(yellow, LOW);
  digitalWrite(yellow2, LOW);
  delay(1500);
  digitalWrite(green, HIGH);
  digitalWrite(red2, HIGH);
  delay(1500);
  digitalWrite(green, LOW);
  digitalWrite(red2, LOW);
  delay(1500);
  digitalWrite(yellow, HIGH);
  digitalWrite(yellow2, HIGH);
  delay(1500);
  digitalWrite(yellow, LOW);
  digitalWrite(yellow2, LOW);
  delay(1500);
  digitalWrite(red, HIGH);
  digitalWrite(green2, HIGH);
  delay(1500);
}
