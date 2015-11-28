/**
 * ----------------------------------------------------------------------------
 * This is a MFRC522 library example; see https://github.com/miguelbalboa/rfid
 * for further details and other examples.
 * 
 * NOTE: The library file MFRC522.h has a lot of useful info. Please read it.
 * 
 * Released into the public domain.
 * ----------------------------------------------------------------------------
 * This sample shows how to read and write data blocks on a MIFARE Classic PICC
 * (= card/tag).
 * 
 * BEWARE: Data will be written to the PICC, in sector #1 (blocks #4 to #7).
 * 
 * 
 * Typical pin layout used:
 * -----------------------------------------------------------------------------------------
 *             MFRC522      Arduino       Arduino   Arduino    Arduino          Arduino
 *             Reader/PCD   Uno           Mega      Nano v3    Leonardo/Micro   Pro Micro
 * Signal      Pin          Pin           Pin       Pin        Pin              Pin
 * -----------------------------------------------------------------------------------------
 * RST/Reset   RST          9             5         D9         RESET/ICSP-5     RST
 * SPI SS      SDA(SS)      10            53        D10        10               10
 * SPI MOSI    MOSI         11 / ICSP-4   51        D11        ICSP-4           16
 * SPI MISO    MISO         12 / ICSP-1   50        D12        ICSP-1           14
 * SPI SCK     SCK          13 / ICSP-3   52        D13        ICSP-3           15
 * 
 */

#include <SPI.h>
#include <MFRC522.h>

#define RST_PIN         9           // Configurable, see typical pin layout above
#define SS_PIN          10          // Configurable, see typical pin layout above

MFRC522 mfrc522(SS_PIN, RST_PIN);   // Create MFRC522 instance.

MFRC522::MIFARE_Key key;

/**
 * Initialize.
 */
void setup() {
    Serial.begin(9600); // Initialize serial communications with the PC
    while (!Serial);    // Do nothing if no serial port is opened (added for Arduinos based on ATMEGA32U4)
    SPI.begin();        // Init SPI bus
    mfrc522.PCD_Init(); // Init MFRC522 card

    // Prepare the key (used both as key A and as key B)
    // using FFFFFFFFFFFFh which is the default at chip delivery from the factory
    for (byte i = 0; i < 6; i++) {
        key.keyByte[i] = 0xFF;
    }

    Serial.println(F("Scan a MIFARE Classic PICC to demonstrate read and write."));
    Serial.print(F("Using key (for A and B):"));
    dump_byte_array(key.keyByte, MFRC522::MF_KEY_SIZE);
    Serial.println();
    
    Serial.println(F("BEWARE: Data will be written to the PICC, in sector #1"));
}

/**
 * Main loop.
 */
void loop() {
    // Look for new cards
    if ( ! mfrc522.PICC_IsNewCardPresent())
        return;

    // Select one of the cards
    if ( ! mfrc522.PICC_ReadCardSerial())
        return;

    // Show some details of the PICC (that is: the tag/card)
    Serial.print(F("Card UID:"));
    dump_byte_array(mfrc522.uid.uidByte, mfrc522.uid.size);
    Serial.println();
    Serial.print(F("PICC type: "));
    byte piccType = mfrc522.PICC_GetType(mfrc522.uid.sak);
    Serial.println(mfrc522.PICC_GetTypeName(piccType));

    // Check for compatibility
    if (    piccType != MFRC522::PICC_TYPE_MIFARE_MINI
        &&  piccType != MFRC522::PICC_TYPE_MIFARE_1K
        &&  piccType != MFRC522::PICC_TYPE_MIFARE_4K) {
        Serial.println(F("This sample only works with MIFARE Classic cards."));
        return;
    }

    // In this sample we use the second sector,
    // that is: sector #1, covering block #4 up to and including block #7
    byte sector         = 1;
    byte blockAddr      = 4;
    byte dataBlock[]    = {
        2, 2, 2, 0x04, //  1,  2,   3,  4,
        0x05, 0x06, 0x07, 0x08, //  5,  6,   7,  8,
        0x08, 0x09, 0xff, 0x0b, //  9, 10, 255, 12,
        0x0c, 0x0d, 0x0e, 0x0f  // 13, 14,  15, 16
    };
    byte trailerBlock   = 7;
    byte status;
    byte buffer[18];
    byte size = sizeof(buffer);

   
   
    // Write data to the block
    char* datos;
    escribirDatos(datos);
    // Read data from the block (again, should now be what we have written)
    lecturaBloque(buffer,blockAddr,size);
        
    finalizar();
}

/**
 * Helper routine to dump a byte array as hex values to Serial.
 */
void dump_byte_array(byte *buffer, byte bufferSize) {
    for (byte i = 0; i < bufferSize; i++) {
        Serial.print(buffer[i] < 0x10 ? " 0" : " ");
        Serial.print(buffer[i], HEX);
    }
}

//escribir los datos en el token de arduino
void escribirDatos(char *datosBlock){
    byte sector         = 1;
    byte blockAddr      = 4;
    byte dataBlock[]    = {
        0, 0, 0, 0, //  1,  2,   3,  4,
        0, 0, 0, 0, //  5,  6,   7,  8,
        0, 0, 0, 0, //  9, 10, 255, 12,
        0, 0, 0, 0 // 13, 14,  15, 16
    };

    for (sector = 1; sector<=15;sector++){
     switch (sector){
        case 1:
          blockAddr = 4;
          AutentificacionDeClave (7);
          break;
        case 2:
          blockAddr = 8;
          AutentificacionDeClave (11);
          break;
        case 3:
          blockAddr = 12;
          AutentificacionDeClave (15);
          break;
        case 4:
          blockAddr = 16;
          AutentificacionDeClave (19);
          break;
        case 5:
          blockAddr = 20;
          AutentificacionDeClave (23);
          break;
        case 6:
          blockAddr = 24;
          AutentificacionDeClave (27);
          break;
        case 7:
          blockAddr = 28;
          AutentificacionDeClave (31);
          break;
        case 8:
          blockAddr = 32;
          AutentificacionDeClave (35);
          break;
        case 9:
          blockAddr = 36;
          AutentificacionDeClave (39);
          break;
        case 10:
          blockAddr = 40;
          AutentificacionDeClave (43);
          break;
        case 11:
          blockAddr = 44;
          AutentificacionDeClave (47);
          break;
        case 12:
          blockAddr = 48;
          AutentificacionDeClave (51);
          break;
        case 13:
          blockAddr = 52;
          AutentificacionDeClave (55);
          break;
        case 14:
          blockAddr = 56;
          AutentificacionDeClave (59);
          break;
        case 15:
          blockAddr = 60;
          AutentificacionDeClave (63);
          break;
      }
    
    byte trailerBlock   = 7;
    byte status;
    byte buffer[18];
    byte size = sizeof(buffer);
    Serial.print(F("Writing data into block ")); 
    int i;
    for(i=blockAddr;i<blockAddr+4;i++){
    Serial.print(i);
    Serial.println(F(" ..."));
    dump_byte_array(dataBlock, 16); Serial.println();
    status = mfrc522.MIFARE_Write(i, dataBlock, 16);
    if (status != MFRC522::STATUS_OK) {
        Serial.print(F("MIFARE_Write() failed: "));
        Serial.println(mfrc522.GetStatusCodeName(status));
    }
    Serial.println();
    }
    delay(1000);
    }
}

//Leer la clave de auntetificacion para poder escribir y leer
  void AutentificacionDeClave (byte trailerBlock){
  byte status;
  Serial.println(F("Authenticating again using key B..."));
    status = mfrc522.PCD_Authenticate(MFRC522::PICC_CMD_MF_AUTH_KEY_B, trailerBlock, &key, &(mfrc522.uid));
    if (status != MFRC522::STATUS_OK) {
        Serial.print(F("PCD_Authenticate() failed: "));
        Serial.println(mfrc522.GetStatusCodeName(status));
        //return status;
    }
    //return status;
}

//Lectura del token de identificacion
byte lecturaBloque(byte *buffer,byte blockAddr,byte size){
  // Read data from the block (again, should now be what we have written)
    byte status;
    Serial.print(F("Reading data from block ")); Serial.print(blockAddr);
    Serial.println(F(" ..."));
    status = mfrc522.MIFARE_Read(blockAddr, buffer, &size);
    if (status != MFRC522::STATUS_OK) {
        Serial.print(F("MIFARE_Read() failed: "));
        Serial.println(mfrc522.GetStatusCodeName(status));
        return status;
    }
    Serial.print(F("Data in block ")); Serial.print(blockAddr); Serial.println(F(":"));
    dump_byte_array(buffer, 16); Serial.println();
    return status;
}

//finaliza la conexion del rfid
void finalizar(){
    // Halt PICC
    mfrc522.PICC_HaltA();
    // Stop encryption on PCD
    mfrc522.PCD_StopCrypto1();
}

