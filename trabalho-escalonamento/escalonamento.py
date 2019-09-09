from threading import Thread
import queue
import time

def current(id, tempo):
    while tempo > 0:
        print('Thread ', id, ' executando por ', tempo,' segundos...')
        tempo = tempo - 1
        time.sleep(1)

def cpu (tx):
    tx.start()
    tx.join()

def escalonamento ():
    tx = fila.get()
    fila.put(tx)
    return tx

t1 = Thread(target=current,args=[1,5])
t2 = Thread(target=current,args=[2,3])
t3 = Thread(target=current,args=[3,2])

fila = queue.Queue()
fila.put(t1)
fila.put(t2)
fila.put(t3)

while True:
    cpu(escalonamento())