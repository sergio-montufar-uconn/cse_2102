#
# PORT 8093
#
#
# PORT 8093
#

import http.server
import socketserver
from http import HTTPStatus


class Handler(http.server.SimpleHTTPRequestHandler):

    def do_GET(self):
        Handler.i = 0
        self.send_response(HTTPStatus.OK)
        self.end_headers()
        my_str = "If you read this, you've been bamboozled by Sergio!"
        self.wfile.write(bytes(my_str, 'utf-8'))


httpd = socketserver.TCPServer(('', 8093), Handler)
httpd.serve_forever()