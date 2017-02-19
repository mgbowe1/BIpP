import socket
import json

configs = {"ip":"10.101.44.12", "listen_port":2048, "boradcast_port":4095}

def init():
    serversocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    print(serversocket)
    serversocket.bind((configs['ip'], config["listen_port"]))
    print(serversocket)
    serversocket.listen(10)
    while 1:
        (clientsocket, address) = serversocket.accept()
        # Do something
        print(address)
init()
