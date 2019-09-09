import threading
import time

def worker(message):
    for i in range(5):
        print (message)
        
        time.sleep(1)

t = threading.Thread(target=worker,args=("thread sendo executada\n",))
t.start()

#print(threading.active_count())

while t.isAlive():
    print ("Aguardando thread\n")
    time.sleep(5)

print ("Thread morreu")
print ("Finalizando programa")
