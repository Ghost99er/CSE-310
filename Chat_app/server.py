import socket
import threading
from datetime import datetime

# Server settings
HOST = '127.0.0.1'  # Localhost
PORT = 65432        # Arbitrary non-privileged port

# Function to handle client connections
def handle_client(conn, addr):
    print(f"Connected by {addr}")
    while True:
        data = conn.recv(1024)
        if not data:
            break
        request = data.decode()
        response = handle_request(request)
        conn.sendall(response.encode())
    conn.close()

def handle_request(request):
    if request == "HELLO":
        return "Hello, Client!"
    elif request == "TIME":
        return str(datetime.now())
    elif request == "FILE":
        with open("sample.txt", "r") as file:
            return file.read()
    else:
        return "Invalid Request"

# Main server loop
def start_server():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.bind((HOST, PORT))
        s.listen()
        print(f"Server started at {HOST}:{PORT}")
        while True:
            conn, addr = s.accept()
            thread = threading.Thread(target=handle_client, args=(conn, addr))
            thread.start()

if __name__ == "__main__":
    start_server()
