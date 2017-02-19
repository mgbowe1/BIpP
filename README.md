# BIpP
A novel protocol for anonymous communication bhind NATs

## Overview
-----------
Broadcasting Ip Protocol BIpP takes inspiration from the hubs of old networking! It uses one port to listen for communications and another to broadcast to all listening devices. The data is guarenteed to only be read by the intended system using public key/private key encryption. Broadcasting devices (those that send data) have keys stored for each device they wish to target. They use the keys to encrypt their messages so only the intended computer can read them.

## Server
---------
The server is written in python and acts as a port-forwarder and traffic multiplier.

## Clients
----------
Clients recieve data from the server and decrypt anything encrypted with their public key.

## Broadcasters
---------------
Broadcasters encrypt data then send it to the server for clients to read.
