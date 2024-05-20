import socket
import threading
from tkinter import *

def receive_messages(client_socket, text_widget):
    while True:
        message = client_socket.recv(1024).decode("utf-8")
        if not message:
            break
        text_widget.insert(END, f"{message}\n")
    client_socket.close()

def send_message(client_socket, message_entry):
    message = message_entry.get()
    client_socket.send(message.encode("utf-8"))
    message_entry.delete(0, END)

def main():
    root = Tk()
    root.title("Client")

    text_widget = Text(root)
    text_widget.pack()

    message_entry = Entry(root)
    message_entry.pack()

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect(("127.0.0.1", 9999))

    threading.Thread(target=receive_messages, args=(client_socket, text_widget)).start()

    send_button = Button(root, text="Send", command=lambda: send_message(client_socket, message_entry))
    send_button.pack()

    root.mainloop()

if __name__ == "__main__":
    main()
