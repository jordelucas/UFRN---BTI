import os
import time

def child():
   print('\nA new child %d' % os.getpid())
   os._exit(0)  

def criar():
   newpid = os.fork()
   if newpid == 0:
      time.sleep(30)
      os.kill(os.getpid(), 9)
   else:
      print(os.getpid())

def encerrar():
   n_pid = int(input('Informe o PID que deseja encerrar: '))
   os.kill(os.getpid(), 9)


def listar_processos():
   os.system('ps -e -o pid,uname')


def menu():
   op = 0
   while op != 3:
      print('\n1. Criar processo')
      print('2. Encerrar processo')
      print('3. Finalizar execução')

      op = input('Escolha uma opção: ')

      if op == '1':
         criar()
         listar_processos()
      else:
         if op == '2':
            encerrar()
            listar_processos()

menu()