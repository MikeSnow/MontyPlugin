import serial #We load the serial library
import sys
ser = serial.Serial('COM4', 9600) #We initialize the serial port 9600 baud
 
#variable to store the message
#we assign a value entered by the user
frase= "Introduce un caracter ('s' para salir) "
print ("Introduce un caracter ('s' para salir)")
entrada = input()
 
while entrada != 's': #We introduced ' s ' out of the loop
 
   #ser.write(enter) #send the serial input
   frase = ser.readline();
   print (frase)
   entrada = input() #introduces another character keyboard