import http.server
import socketserver
import os
import sys

PORT = 8080
DIRECTORY = os.path.dirname(os.path.abspath(__file__))

class Handler(http.server.SimpleHTTPRequestHandler):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, directory=DIRECTORY, **kwargs)

    def log_message(self, format, *args):
        # Clean logging
        sys.stderr.write(f"[{self.log_date_time_string()}] {format % args}\n")

def start_server():
    global PORT
    while True:
        try:
            with socketserver.TCPServer(("", PORT), Handler) as httpd:
                print(f"\n=======================================================")
                print(f"  GRAMTECH WEB APPLICATION RUNNING!")
                print(f"  URL: http://localhost:{PORT}")
                print(f"  Network URL: http://127.0.0.1:{PORT}")
                print(f"=======================================================\n")
                sys.stdout.flush()
                httpd.serve_forever()
        except OSError as e:
            if e.errno == 10048 or "address already in use" in str(e).lower():
                PORT += 1
                continue
            else:
                raise e

if __name__ == "__main__":
    start_server()
