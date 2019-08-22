from threading import Thread
from random import randint
import time

current = [0, 0, 0]

def inicio(id):
	tempo = id+5
	while tempo > 0:
		print("Executando thread ", id ," por ", tempo, " segundos...")
		time.sleep(1)
		tempo = tempo -1
	current[id] = 0

cont = 0

def cpu():

	current[cont] = 1
	contador = contador + 1

def verificar_inicio(id):
	while True:
		if current[id] == 1:
			inicio(id)
			cpu()
		time.sleep(1)

filosofo1 = Thread(target=verificar_inicio,args=[0])
filosofo2 = Thread(target=verificar_inicio,args=[1])
filosofo3 = Thread(target=verificar_inicio,args=[2])

filosofo1.start()
filosofo2.start()
filosofo3.start()

cpu()