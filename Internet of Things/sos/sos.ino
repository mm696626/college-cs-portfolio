//SOS by Matt McCullough
//This is a sequence of 3 short signals, followed by 3 long signals, followed by 3 short signals, and then a pause

#define ledPin 2 //2 is the LED pin for the Freenove board

static int timesLooped = 0; //number of times the cycle has looped in loop()
void setup() {
  pinMode(ledPin,OUTPUT);
}

void loop(void) {

  for(int i=0; i<3; i++)
  {
      digitalWrite(ledPin,HIGH); //turn on LED
      
      if(timesLooped != 1) //if it hasn't looped once so not the O in SOS with long pauses shorter delay else longer delay
        delay(500); 
      else
        delay(1000);
        
      digitalWrite(ledPin,LOW);  //turn off LED
      
      if(timesLooped != 1) //if it hasn't looped once so not the O in SOS with long pauses shorter delay else longer delay
        delay(500); 
      else
        delay(1000);
  }
 
  
  timesLooped++;
  if(timesLooped == 3) //if looped 3 times, reset the pattern
  {
    delay(2000); //pause after looping 3 times
    timesLooped = 0; //reset counter
  }
    
}
