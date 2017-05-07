# Deprecated
The new managed repos are
BIpPServer: https://github.com/owlfloater898/BIpPServer
BIpPClient: https://github.com/owlfloater898/BIpPClient

# BIpP
A novel protocol for anonymous communication behind NATs

## Overview

Broadcasting Ip Protocol BIpP takes inspiration from the hubs of old networking! It uses one port to listen for communications and another to broadcast to all listening devices. The data is guarenteed to only be read by the intended system using public key/private key encryption. Broadcasting devices (those that send data) have keys stored for each device they wish to target. They use the keys to encrypt their messages so only the intended computer can read them.

## Server

The server is written in python and acts as a port-forwarder and traffic multiplier.

### Server installation

1. Set your firewall to allow your preferred ports.
2. Set the ip address to listen on to the ip address of the network interface your use to connect to the internet.
3. run server.py using python 3.

## Clients

Clients recieve data from the server and decrypt anything encrypted with their public key.

### Client installation

1. edit domain/ip in code
2. Build jar file
3. run jar file

## Broadcasters

Broadcasters encrypt data then send it to the server for clients to read.

### Broadcaster installation

1. edit domain/ip in code
2. Build jar file
3. run jar file

## About the app

The app is used to send packets as a broadcaster as a proof of concept for a secure remote erase of data.
