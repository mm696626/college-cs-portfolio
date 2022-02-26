#define red 13
#define green 12
#define blue 26

#define rCh 0
#define gCh 1
#define bCh 2

static int count = 0;

static int redVals[] = {255, 255, 255, 0, 0, 75};
static int greenVals[] = {0, 127, 255, 255, 0, 0};
static int blueVals[] = {0, 0, 0, 0, 255, 130};
void setup() {
  Serial.begin(115200);
  pinMode(red,OUTPUT);
  pinMode(green,OUTPUT);
  pinMode(blue,OUTPUT);
  
  digitalWrite(red,LOW);
  digitalWrite(green,LOW);
  digitalWrite(blue,LOW);
  
  ledcAttachPin( red, rCh ); //assign RGB led pins to channels  
  ledcAttachPin( green, gCh );
  ledcAttachPin( blue, bCh );
  ledcSetup( rCh, 1000, 8 ); //1 kHz PWM, 8-bit resolution
  ledcSetup( gCh, 1000, 8 );
  ledcSetup( bCh, 1000, 8 );
}

void loop() {
  count = random(0,6); //generates random number from 0 to 5
  ledcWrite(rCh, redVals[count]);
  ledcWrite(gCh, greenVals[count]);
  ledcWrite(bCh, blueVals[count]);
 
  delay(500);
  
}
