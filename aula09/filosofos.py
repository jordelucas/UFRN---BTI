from threading import Thread
from random import randint
import time


def comer(id):
	esquerda = 0
	direita = id
	if id == 0:
		esquerda = 4
	else:
		esquerda = id - 1

	print("filosofo ", id+1, "|direita: ", direita, "|esquerda: ", esquerda)

	

	if (garfos[esquerda] == 0) and (garfos[direita] == 0):
		print("filosofo ", id+1, " comendo")
		garfos[esquerda] = 1
		garfos[direita] = 1
		time.sleep(randint(0,9))
		print("filosofo ", id+1, " pensando")
		garfos[esquerda] = 0
		garfos[direita] = 0
	else:
		print("filosofo ", id+1, " aguardando")
		time.sleep(randint(0,9))
	

garfos = [0, 0, 0, 0, 0]

filosofo1 = Thread(target=comer,args=[0])
filosofo2 = Thread(target=comer,args=[1])
filosofo3 = Thread(target=comer,args=[2])
filosofo4 = Thread(target=comer,args=[3])
filosofo5 = Thread(target=comer,args=[4])

while True:
	filosofo1.start()
	filosofo2.start()
	filosofo3.start()
	filosofo4.start()
	filosofo5.start()
