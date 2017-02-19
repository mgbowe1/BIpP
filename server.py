import socket
import json
import threading
import select

#Global data
configs = {"ip":"10.101.44.12", "listen_port":2048, "broadcast_port":4095}
active_csockets = []

# The phone socket thread
def p_sock_listener(sock):
    while 1:
        (new_sock, new_addr) = sock.accept()
        print("Data producer: {0}".format(new_addr))
        send_thread = threading.Thread(name="send-thread", target=recv_msg, args=([new_sock]))
        send_thread.start()

def recv_msg(sock):
    running = 1
    while running:
        mess = sock.recv(8192)
        if not mess:
            running = 0
        else:
            print(mess.decode("ascii"))
            send_message(mess)

def c_sock_listener(sock):
    while 1:
        (new_sock, new_addr) = sock.accept()
        print(new_addr)
        new_sock.setblocking(0)
        active_csockets.append(new_sock)
        #new_sock.send('Hello client\n'.encode())

def send_message(message):
    for sock in active_csockets:
        try:
            sock.send(message)
        except IOError:
            print("{0}: Disconnected".format(sock))
            active_csockets.remove(sock)
def init():
    phonesocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    phonesocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    print(phonesocket)
    phonesocket.bind((configs['ip'], configs["listen_port"]))
    print(phonesocket)
    phonesocket.listen(10)
    compsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    compsocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    compsocket.bind((configs['ip'], configs["broadcast_port"]))
    compsocket.listen(10)
    pthread = threading.Thread(name="listen-thread-2048", target=p_sock_listener, args=([phonesocket]))
    pthread.start()
    cthread = threading.Thread(name="broadcast-thread-4095", target=c_sock_listener, args=([compsocket]))
    cthread.start()
    pthread.join()

init()
