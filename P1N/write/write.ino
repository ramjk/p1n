#include <EEPROM.h>

typedef union{
  byte bytes[4];
  long value;
} bytes_to_long;


bytes_to_long key = {.value = 1234};

void setup() {
  for(int i = 0; i < 4; i++) {
    EEPROM.write(i, key.bytes[i]);
  }
}

void loop() {
  
}

