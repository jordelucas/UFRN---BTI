from threading import Thread
from random import randint
import time

garfos = [0, 0, 0, 0, 0]

def pensar(id):
	print("Filósofo ", id+1, ": pensando")
	time.sleep(randint(1,10))

def comer(id):
	esquerda = 0
	direita = id
	if id == 0:
		esquerda = 4
	else:
		esquerda = id - 1

	while True:
		if (garfos[esquerda] == 0) and (garfos[direita] == 0):
			garfos[direita] = 1
			garfos[esquerda] = 1
			print("Filosofo ", id+1, ": comendo")
			time.sleep(randint(1,10))
			garfos[esquerda] = 0
			garfos[direita] = 0
			pensar(id)
			break
		else:
			print("filosofo ", id+1, ": aguardando")
			time.sleep(randint(1,10))

def inicioJantar(id):
	while True:
		escolha = randint(0,1)

		if escolha == 0:
			pensar(id)
		else:
			comer(id)

filosofo1 = Thread(target=inicioJantar,args=[0])
filosofo2 = Thread(target=inicioJantar,args=[1])
filosofo3 = Thread(target=inicioJantar,args=[2])
filosofo4 = Thread(target=inicioJantar,args=[3])
filosofo5 = Thread(target=inicioJantar,args=[4])

filosofo1.start()
filosofo2.start()
filosofo3.start()
filosofo4.start()
filosofo5.start()