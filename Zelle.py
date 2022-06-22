import threading
from time import sleep
from turtle import setposition

class Zelle(threading.Thread):
    def __init__(self, spiel, position):
        self.position = position
        self.spiel = spiel
        self.is_Alive = True

    def getPosition(self):
        return self.position

    def setPosition(self, position):
        self.position = position

    def isAlive(self):
        return self.isALive

    def setAlive(self, alive):
        self.isALive = alive

    def run(self):
        try:
            sleep(100)
        except InterruptedError:
            print("Fehler")
        #while(self.is_Alive):
            #self.spiel <- here call the Funktion in the SpielDesLebens Class
        
    def stop_Tread(self):
        self.is_Alive = False
    #Siehe https://openbook.rheinwerk-verlag.de/python/32_005.html
    #Und https://docs.python.org/3/library/threading.html#condition-objects
