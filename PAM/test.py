#!/usr/bin/python -W default
#
# This is the test script for libpython-pam.  There aren't many stones
# left unturned.
#
# Best run from the Makefile using the target 'test'.  To run manually:
#   sudo ln -s $PWD/test-pam_python.pam /etc/pam.d
#   python test.py
#   sudo rm /etc/pam.d/test-pam_python.pam 
#
import serial
import numpy as np
import cv2
import threading
#charge template and init webcam
face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
cap = cv2.VideoCapture(0)
findFace=False

#
# Duplicates pam_permit.c
#
DEFAULT_USER  = "nobody"

def pam_sm_authenticate(pamh, flags, argv):
  autentificatorMontyPlugin()
  return pamh.PAM_SUCCESS

def pam_sm_setcred(pamh, flags, argv):
  return pamh.PAM_SUCCESS

def pam_sm_acct_mgmt(pamh, flags, argv):
  return pamh.PAM_SUCCESS

def pam_sm_open_session(pamh, flags, argv):
  return pamh.PAM_SUCCESS

def pam_sm_close_session(pamh, flags, argv):
  return pamh.PAM_SUCCESS

def pam_sm_chauthtok(pamh, flags, argv):
  return pamh.PAM_SUCCESS

def lecturaSerial():
    ser = serial.Serial('/dev/ttyUSB0', 9600) #We initialize the serial port 9600 baud
    cod ="04 26 56 AA 10 2C 80" #target code
    #variable to store the message
    #we assign a value entered by the user
    frase=""
    while not(cod in frase): 
        frase = ser.readline()
    return frase
def autentificatorMontyPlugin():
    t = threading.Thread(target=lecturaSerial)
    t.start()
    while (t.isAlive() or not findFace):
        #read frame and save
        ret, img = cap.read()
        #convert img to white and black
        gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        #find faces and save position
        faces = face_cascade.detectMultiScale(gray, 1.3, 5)
        #Print rectangle in faces
    
        for (x,y,w,h) in faces:
            cv2.rectangle(img,(x,y),(x+w,y+h),(125,255,0),2)
        #Show img
        cv2.imshow('img',img)
    
        if len(faces)!= 0:
            findFace=True

        cv2.waitKey(1)
    cap.release()
    return PAM_SUCCESS