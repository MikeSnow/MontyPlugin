import serial #cargamos la libreria serial

def lecturaSerial():
    ser = serial.Serial('COM4', 9600) #inicializamos el puerto de serie a 9600 baud
    #variable para almacenar el mensaje
    #le asignamos un valor introducido por el usuari
    frase=""
    frase = ser.readline()
    print (frase)
       #ser.write(entrada) #envia la entrada por serial
    return frase
  