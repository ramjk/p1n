#include <Servo.h>
#include <EEPROM.h>

Servo myservo;

byte buffer[256];
int masterPIN = 1234;


typedef union{
  byte bytes[4];
  long value;
} bytes_to_long;

int encryptPin(long unencrypted_PIN) {
  // Use some sort of basic encryption algorithm to encrypt the PIN
  
  return unencrypted_PIN;
}

void addKey(long unencrypted_PIN) {
  // Adds key to disk
  
}

bool isMatch(long unencrypted_PIN, long received_PIN) {
  // If the encrypted pin is equivalent to the received pin, return True
  long encrypted_PIN = encryptPin(unencrypted_PIN);
  return encrypted_PIN == received_PIN;
}

int getAccessLevel(long temp_key) {
  // Gets an access level for the temporary key
  return 1;
}

bool authenticate(long unencrypted_PIN, long received_PIN) {
  return isMatch(unencrypted_PIN, received_PIN);
}

void setup() {
  myservo.attach(5);
  Serial.begin(9600);
}

void loop() {
  Serial.println("Initiating...");
  delay(5000);
  int len = Serial.available();
  if(len > 0) {
    bytes_to_long bytes;
    int max_i = max(len, sizeof(bytes.bytes));
    for(int i = 0; i < max_i; i++) {
      bytes.bytes[i] = Serial.read();
    }
    Serial.println(bytes.value);
    if(authenticate(masterPIN, bytes.value)) {
      myservo.write(180);
      delay(3000);
      myservo.write(0);
  }
  }
}

