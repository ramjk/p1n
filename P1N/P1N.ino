#include <EEPROM.h>
#include <Time.h>

byte buffer[256];

typedef union{
  byte bytes[4];
  long value;
} bytes_to_long;

int encryptPin(long unencrypted_PIN, long current_time) {
  // Use some sort of basic encryption algorithm to encrypt the PIN
  
  return unencrypted_PIN;
}

void addKey(long unencrypted_PIN, long start_time, long end_time, long current_time) {
  // Adds key to disk
  
}

bool isMatch(long unencrypted_PIN, long received_PIN, long current_time) {
  // If the encrypted pin is equivalent to the received pin, return True
  long encrypted_PIN = encryptPin(unencrypted_PIN, current_time);
  return encrypted_PIN == received_PIN;
}

int getAccessLevel(long temp_key) {
  // Gets an access level for the temporary key
  return 1;
}

bool authenticate(long unencrypted_PIN, long received_PIN, long current_time) {
  if(isMatch(unencrypted_PIN, received_PIN, current_time)) {
    return true;
  }
  else {
    return false;
  }
}

void setup() {
  
}

void loop() {
  long current_time = now();
  int len = Serial.available();
  if(len > 0) {
    bytes_to_long bytes;
    int max_i = max(len, sizeof(bytes.bytes));
    for(int i = 0; i < max_i; i++) {
      bytes.bytes[i] = Serial.read();
    }
    value = EEPROM.read(
  }
}

