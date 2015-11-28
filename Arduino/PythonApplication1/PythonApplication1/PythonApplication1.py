import serial #cargamos la libreria serial
import sys
ser = serial.Serial('COM4', 9600) #inicializamos el puerto de serie a 9600 baud
 
#variable para almacenar el mensaje
#le asignamos un valor introducido por el usuario
frase= "Introduce un caracter ('s' para salir) "
print ("Introduce un caracter ('s' para salir)")
entrada = input()
 
while entrada != 's': #introduciendo 's' salimos del bucle
 
   #ser.write(entrada) #envia la entrada por serial
   frase = ser.readline();
   print (frase)
   entrada = input() #introduce otro caracter por teclado