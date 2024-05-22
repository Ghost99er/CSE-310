import socket
import threading
from tkinter import *

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

def start_server(text_widget, server_ip_entry, server_port_entry):
    server_ip = server_ip_entry.get()
    server_port = int(server_port_entry.get())
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((server_ip, server_port))
    server.listen(5)
    text_widget.insert(END, f"Server started on {server_ip}:{server_port}, waiting for connections...\n")

    while True:
        client_socket, addr = server.accept()
        text_widget.insert(END, f"Accepted connection from {addr}\n")
        client_handler = threading.Thread(target=handle_client, args=(client_socket, text_widget))
        client_handler.start()

def send_message(peer_socket, message_entry, username):
    message = f"{username}: {message_entry.get()}"
    peer_socket.send(message.encode("utf-8"))
    message_entry.delete(0, END)

def connect_to_server(text_widget, server_ip_entry, server_port_entry, message_entry, username):
    server_ip = server_ip_entry.get()
    server_port = int(server_port_entry.get())
    peer_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    peer_socket.connect((server_ip, server_port))
    
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

def show_instructions():
    instructions = Toplevel(root)
    instructions.title("Instructions")
    text_widget = Text(instructions, wrap="word", width=50, height=20)
    text_widget.pack()

    instructions_text = """
    Instructions for Running the Peer-to-Peer Chat Application

    If you haven't already, install PyInstaller using pip:
    CMD: pip install pyinstaller

Make sure the Host and clients are all on the same network (WI-FI)

    Running the Server (Host):
    1. Click on peer.exe
    2. Enter Server Details:
       - Server IP: Enter the IP address of the server machine. 
         To find your IP address:
         - Press Win + R, type cmd, and press Enter.
         - Type ipconfig and press Enter.
         - Look for the "IPv4 Address" under the network connection you are using (e.g., Wi-Fi or Ethernet).
       - Server Port: Enter a port number (use 9999)
    3. Start the Server:
       Click the "Start Server" button. The server will start, and you should see a message in the text area indicating that the server is waiting for connections.

    Running the Client (User):
    1. Click on peer.exe
    2. Enter Client Details:
       - Username: Enter a unique username.
       - Server IP: Enter the IP address of the server machine (same IP entered by the server).
       - Server Port: Enter a port number (use 9999)
    3. Connect to the Server:
       Click the "Connect to Server" button. The client will connect to the server, and you should see a message indicating the connection is successful.
    4. Send Messages:
       Type your message in the message entry field and click the "Send" button to send the message. All connected clients will see the message.
    """

    text_widget.insert(END, instructions_text)
    text_widget.config(state=DISABLED)

def main():
    global root
    root = Tk()
    root.title("Peer-to-Peer Chat")

    text_widget = Text(root)
    text_widget.pack()

    username_entry = Entry(root)
    username_entry.insert(0, "Enter Username")
    username_entry.pack()

    server_ip_entry = Entry(root)
    server_ip_entry.insert(0, "Enter Server IP")
    server_ip_entry.pack()

    server_port_entry = Entry(root)
    server_port_entry.insert(0, "Enter Server Port")
    server_port_entry.pack()

    message_entry = Entry(root)
    message_entry.pack()

    start_button = Button(root, text="Start Server", command=lambda: threading.Thread(target=start_server, args=(text_widget, server_ip_entry, server_port_entry)).start())
    start_button.pack()

    connect_button = Button(root, text="Connect to Server", command=lambda: connect_to_server(text_widget, server_ip_entry, server_port_entry, message_entry, username_entry.get()))
    connect_button.pack()

    instructions_button = Button(root, text="Show Instructions", command=show_instructions)
    instructions_button.pack()

    root.mainloop()

if __name__ == "__main__":
    main()
