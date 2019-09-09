from threading import Thread
import time


def carrinho(velocidade,nome):
    distancia = 0
    while distancia <= 1000:
        print("Carrinho :",nome,distancia)
        distancia += velocidade
        time.sleep(0.3)



carrinho1 = Thread(target=carrinho,args=[1.1,"Ed\n"])
carrinho2 = Thread(target=carrinho,args=[1.2,"Paulo\n"])


carrinho1.start()
carrinho2.start()


