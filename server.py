import socket

def init():
    serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    serversocket.bind((socket.gethostname(), 2048))
    serversocket.listen(10)
    while 1:
        (clientsocket, address) = serversocket.accept()
        # Do something
init()
