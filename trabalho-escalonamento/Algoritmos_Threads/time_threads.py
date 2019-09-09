import threading
import time

def print_time(nomeDoThread, delay):
    conta = 0
    while conta < 5:
        time.sleep(delay)
        conta += 1
        print(nomeDoThread, time.ctime(time.time()),"\n")


try:
    t1 = threading.Thread(target=print_time,args=["Thread-1",2])
    t2 = threading.Thread(target=print_time,args=["Thread-2",4])
    t1.start()
    t2.start()
except:
    print("Erro ao criar as threads")


