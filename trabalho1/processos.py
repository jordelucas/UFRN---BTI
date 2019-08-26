import os

def child():
   print('\nA new child %d' % os.getpid())
   os._exit(0)  

def parent():
   while True:
      newpid = os.fork()
      if newpid == 0:
         child()
      else:
         pids = (os.getpid(), newpid)
         print("parent: %d, child: %d\n" % pids)
      reply = input("q for quit / c for new fork\n")
      if reply == 'c': 
          continue
      else:
          break

parent()
