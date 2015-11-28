import serial #cargamos la libreria serial

def lecturaSerial():
    ser = serial.Serial('COM4', 9600) #We initialize the serial port 9600 baud
    #variable to store the message
    #we assign a value entered by the user
    frase=""
    frase = ser.readline()
    print (frase)
       #ser.write(enter) #send the serial input
    return frase
  