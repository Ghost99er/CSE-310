import socket
import threading
from tkinter import *

def handle_client(client_socket, text_widget):
    while True:
        message = client_socket.recv(1024).decode("utf-8")
        if not message:
            break
        text_widget.insert(END, f"Client: {message}\n")
        response = f"Server: {message}"  # Simple echo response
        client_socket.send(response.encode("utf-8"))
    client_socket.close()

def start_server(text_widget):
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind(("0.0.0.0", 9999))
    server.listen(5)
    text_widget.insert(END, "Server started, waiting for connections...\n")
    
    while True:
        client_socket, addr = server.accept()
        text_widget.insert(END, f"Accepted connection from {addr}\n")
        client_handler = threading.Thread(target=handle_client, args=(client_socket, text_widget))
        client_handler.start()

def main():
    root = Tk()
    root.title("Server")

    text_widget = Text(root)
    text_widget.pack()

    start_button = Button(root, text="Start Server", command=lambda: threading.Thread(target=start_server, args=(text_widget,)).start())
    start_button.pack()

    root.mainloop()

if __name__ == "__main__":
    main()
