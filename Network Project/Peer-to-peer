import socket
import threading
import tkinter as tk
from datetime import datetime

# Peer settings
PEER_PORT = 65432

# Function to handle incoming connections
def handle_peer_connection(conn, addr):
    print(f"Connected by {addr}")
    while True:
        data = conn.recv(1024)
        if not data:
            break
        request = data.decode()
        response = handle_peer_request(request)
        conn.sendall(response.encode())
    conn.close()

def handle_peer_request(request):
    if request == "HELLO":
        return "Hello, Peer!"
    elif request == "TIME":
        return str(datetime.now())
    elif request == "FILE":
        with open("sample.txt", "r") as file:
            return file.read()
    else:
        return "Invalid Request"

# Function to start the peer server
def start_peer_server():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind(('', PEER_PORT))
        s.listen()
        print(f"Peer server started at port {PEER_PORT}")
        while True:
            conn, addr = s.accept()
            thread = threading.Thread(target=handle_peer_connection, args=(conn, addr))
            thread.start()

# Function to send requests to another peer
def send_peer_request(target_ip, request):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((target_ip, PEER_PORT))
        s.sendall(request.encode())
        data = s.recv(1024)
        return data.decode()

# GUI setup
def on_send():
    target_ip = entry_ip.get().strip()
    request = entry_request.get().strip().upper()
    response = send_peer_request(target_ip, request)
    text_area.insert(tk.END, f"To {target_ip} - Request: {request}\nResponse: {response}\n\n")

root = tk.Tk()
root.title("Peer")

frame_ip = tk.Frame(root)
frame_ip.pack(pady=5)

label_ip = tk.Label(frame_ip, text="Target IP:")
label_ip.pack(side=tk.LEFT)
entry_ip = tk.Entry(frame_ip, width=20)
entry_ip.pack(side=tk.LEFT, padx=5)

frame_request = tk.Frame(root)
frame_request.pack(pady=5)

label_request = tk.Label(frame_request, text="Request:")
label_request.pack(side=tk.LEFT)
entry_request = tk.Entry(frame_request, width=40)
entry_request.pack(side=tk.LEFT, padx=5)

button = tk.Button(root, text="Send", command=on_send)
button.pack(pady=5)

text_area = tk.Text(root, height=15, width=60)
text_area.pack(pady=10)

threading.Thread(target=start_peer_server, daemon=True).start()
root.mainloop()
