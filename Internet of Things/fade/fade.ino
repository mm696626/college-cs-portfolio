#define red 13
#define green 12
#define blue 26

#define rCh 0
#define gCh 1
#define bCh 2

static int newColor = 0;
static int lastColor = 0; //remember last color to fade into new color (red is default here)

static int redVals[] = {255, 255, 255, 0, 0, 75};
static int greenVals[] = {0, 130, 255, 255, 0, 0};
static int blueVals[] = {0, 0, 0, 0, 255, 130};

static int steps = 5; //fade in 5 steps

static int r = 255;
static int g = 0;
static int b = 0;

static int rFade = 0;
static int gFade = 0;
static int bFade = 0;



void setup() {
  Serial.begin(115200);
  pinMode(red,OUTPUT);
  pinMode(green,OUTPUT);
  pinMode(blue,OUTPUT);
  
  
  ledcAttachPin( red, rCh ); //assign RGB led pins to channels  
  ledcAttachPin( green, gCh );
  ledcAttachPin( blue, bCh );
  ledcSetup( rCh, 1000, 8 ); //1 kHz PWM, 8-bit resolution
  ledcSetup( gCh, 1000, 8 );
  ledcSetup( bCh, 1000, 8 );


  //default as red (so it has a last color to refer to)
  ledcWrite(rCh, 255);
  ledcWrite(gCh, 0);
  ledcWrite(bCh, 0);
}

void loop() {

  lastColor = newColor; //save last new color into here
  while(lastColor == newColor) //make sure colors aren't the same
  {
    newColor = random(0,6); //generates random number from 0 to 5
  }

  findFadeAmounts(); //find fade amounts
  
  for (int i=0; i<steps; i++)
  {
      if (redVals[newColor] > redVals[lastColor])
          r = r + rFade;
      if (greenVals[newColor] > greenVals[lastColor])
          g = g + gFade;
      if (blueVals[newColor] > blueVals[lastColor])
          b = b + bFade;


      if (redVals[newColor] < redVals[lastColor])
          r = r - rFade;
      if (greenVals[newColor] < greenVals[lastColor])
          g = g - gFade;
      if (blueVals[newColor] < blueVals[lastColor])
          b = b - bFade;
     
      ledcWrite(rCh, r);
      ledcWrite(gCh, g);
      ledcWrite(bCh, b);
      delay(500);
  }
  delay(1500);
}


void findFadeAmounts()
{
    //get difference of old and new
    rFade = (redVals[lastColor] - redVals[newColor])/steps;
    if (rFade < 0)
    {
      rFade = rFade * -1; //make sure fade is positive
    }
    
    gFade = (greenVals[lastColor] - greenVals[newColor])/steps;
    if (gFade < 0)
    {
      gFade = gFade * -1;
    }
    
    bFade = (blueVals[lastColor] - blueVals[newColor])/steps;
    if (bFade < 0)
    {
      bFade = bFade * -1;
    }
}
