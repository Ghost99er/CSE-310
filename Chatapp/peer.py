import socket
import threading
from tkinter import *

# Predefined server IP and port
#Change the SERVER_IP in the peer.py script to the IP address of the machine that will run the server.
#Press Win + R, type cmd, and press Enter.
#Type ipconfig and press Enter
#Look for the "IPv4 Address" under the network connection you are using (e.g., Wi-Fi or Ethernet). This is the IP address you will use.
# SERVER_IP = "example"  # Replace with the actual IP address of the server machine

SERVER_IP = "127.0.0.1"  # Use localhost for local testing; change as needed
SERVER_PORT = 9999

def handle_client(client_socket, text_widget):
    while True:
        try:
            message = client_socket.recv(1024).decode("utf-8")
            if not message:
                break
            text_widget.insert(END, f"{message}\n")
        except ConnectionResetError:
            break
    client_socket.close()

def start_server(text_widget):
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((SERVER_IP, SERVER_PORT))
    server.listen(5)
    text_widget.insert(END, "Server started, waiting for connections...\n")

    while True:
        client_socket, addr = server.accept()
        text_widget.insert(END, f"Accepted connection from {addr}\n")
        client_handler = threading.Thread(target=handle_client, args=(client_socket, text_widget))
        client_handler.start()

def send_message(peer_socket, message_entry, username):
    message = f"{username}: {message_entry.get()}"
    peer_socket.send(message.encode("utf-8"))
    message_entry.delete(0, END)

def connect_to_server(text_widget, message_entry, username):
    peer_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    peer_socket.connect((SERVER_IP, SERVER_PORT))
    
    threading.Thread(target=receive_messages, args=(peer_socket, text_widget)).start()

    send_button = Button(root, text="Send", command=lambda: send_message(peer_socket, message_entry, username))
    send_button.pack()

def receive_messages(peer_socket, text_widget):
    while True:
        try:
            message = peer_socket.recv(1024).decode("utf-8")
            if not message:
                break
            text_widget.insert(END, f"{message}\n")
        except ConnectionResetError:
            break
    peer_socket.close()

def main():
    global root
    root = Tk()
    root.title("Peer-to-Peer Chat")

    text_widget = Text(root)
    text_widget.pack()

    username_entry = Entry(root)
    username_entry.insert(0, "Enter Username")
    username_entry.pack()

    message_entry = Entry(root)
    message_entry.pack()

    start_button = Button(root, text="Start Server", command=lambda: threading.Thread(target=start_server, args=(text_widget,)).start())
    start_button.pack()

    connect_button = Button(root, text="Connect to Server", command=lambda: connect_to_server(text_widget, message_entry, username_entry.get()))
    connect_button.pack()

    root.mainloop()

if __name__ == "__main__":
    main()
