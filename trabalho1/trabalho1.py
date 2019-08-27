import os
import time

def criar():
   newpid = os.fork()
   if newpid == 0:
      time.sleep(30)
      os.kill(os.getpid(), 9)
   else:
      return

def encerrar():
   n_pid = int(input('\nInforme o PID que deseja encerrar: '))
   os.kill(n_pid, 9)


def listar_processos():
   os.system('ps -e -o pid,uname')


def menu():
   op = 0
   while op != 3:
      print('\n1. Criar processo')
      print('2. Encerrar processo')
      print('3. Finalizar execução')

      op = int(input('Escolha uma opção: '))

      if op == 1:
         criar()
         listar_processos()
      else:
         if op == 2:
            encerrar()
            listar_processos()

menu()