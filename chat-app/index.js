const express = require('express');
const app = express();

const http = require('http');
const server = http.createServer(app);
const {Server} = require('socket.io');

const io = new Server(server);

app.get('/', (reg, res) => {
    res.sendFile(__dirname + '/index.html');
})

server.listen(3000, () => {
    console.log('app connected - Đã kết nối đến app chat');
});

io.on('connection', (socket) => {
    console.log('user connected - người dùng đã kết nối');

    socket.on('on-chat', data => {
        console.log({data});
        io.emit('user-chat', data)
    });
});