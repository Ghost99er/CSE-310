import socket
import tkinter as tk

# Server settings
HOST = '127.0.0.1'  # The server's hostname or IP address
PORT = 65432        # The port used by the server

# Function to send request to server and receive response
def send_request(request):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        s.connect((HOST, PORT))
        s.sendall(request.encode())
        data = s.recv(1024)
        return data.decode()

# GUI setup
def on_send():
    request = entry.get().strip().upper()
    response = send_request(request)
    text_area.insert(tk.END, f"Request: {request}\nResponse: {response}\n\n")

root = tk.Tk()
root.title("Client")

frame = tk.Frame(root)
frame.pack(pady=10)

entry = tk.Entry(frame, width=50)
entry.pack(side=tk.LEFT, padx=10)

button = tk.Button(frame, text="Send", command=on_send)
button.pack(side=tk.LEFT)

text_area = tk.Text(root, height=15, width=60)
text_area.pack(pady=10)

root.mainloop()
